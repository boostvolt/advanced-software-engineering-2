package ch.zhaw.catan;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

import java.awt.Point;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class App {
    private enum Command {
        DISPLAY_BOARD, DISPLAY_PLAYER_RESOURCES, DISPLAY_BANK_RESOURCES,
        DISPLAY_STRUCTURE_COSTS, DISPLAY_SCORES,
        BUILD_ROAD, BUILD_SETTLEMENT, BUILD_CITY,
        TRADE, NEXT_TURN, QUIT
    }

    public static void main(String[] args) {
        TextIO textIO = TextIoFactory.getTextIO();
        TextTerminal<?> terminal = textIO.getTextTerminal();

        terminal.println("=== Siedler von Catan ===");

        int numPlayers = textIO.newIntInputReader()
                .withMinVal(Config.MIN_NUMBER_OF_PLAYERS)
                .withMaxVal(Config.MAX_NUMBER_OF_PLAYERS)
                .read("Number of players (2-4)");

        SiedlerGame game = new SiedlerGame(7, numPlayers);

        // Founding phase - first round (forward)
        for (int i = 0; i < numPlayers; i++) {
            if (i > 0) {
                game.switchToNextPlayer();
            }
            terminal.println("\n" + game.getCurrentPlayerFaction() + ": Place first settlement");
            displayBoard(terminal, game);
            placeSettlement(textIO, terminal, game, false);
            placeInitialRoad(textIO, terminal, game);
        }

        // Founding phase - second round (reverse)
        for (int i = 0; i < numPlayers; i++) {
            if (i > 0) {
                game.switchToPreviousPlayer();
            }
            terminal.println("\n" + game.getCurrentPlayerFaction() + ": Place second settlement");
            displayBoard(terminal, game);
            placeSettlement(textIO, terminal, game, true);
            placeInitialRoad(textIO, terminal, game);
        }

        // Main game
        Random random = new Random();
        boolean gameOver = false;

        while (!gameOver) {
            terminal.println("\n=== " + game.getCurrentPlayerFaction() + "'s turn ===");

            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            int diceSum = die1 + die2;
            terminal.println("Dice: " + die1 + " + " + die2 + " = " + diceSum);

            if (diceSum == 7) {
                game.throwDice(7);
                terminal.println("A 7 was rolled! Move the robber.");
                displayBoard(terminal, game);
                boolean placed = false;
                while (!placed) {
                    int x = textIO.newIntInputReader().read("Robber field X");
                    int y = textIO.newIntInputReader().read("Robber field Y");
                    placed = game.placeThiefAndStealCard(new Point(x, y));
                    if (!placed) {
                        terminal.println("Invalid field. Try again.");
                    }
                }
            } else {
                Map<Config.Faction, List<Config.Resource>> payout = game.throwDice(diceSum);
                for (Map.Entry<Config.Faction, List<Config.Resource>> entry : payout.entrySet()) {
                    if (!entry.getValue().isEmpty()) {
                        terminal.println(entry.getKey() + " received: " + entry.getValue());
                    }
                }
            }

            boolean endTurn = false;
            while (!endTurn && !gameOver) {
                Command action = textIO.newEnumInputReader(Command.class).read("Action");

                switch (action) {
                    case DISPLAY_BOARD:
                        displayBoard(terminal, game);
                        break;
                    case DISPLAY_PLAYER_RESOURCES:
                        displayPlayerResources(terminal, game);
                        break;
                    case DISPLAY_BANK_RESOURCES:
                        displayBankResources(terminal, game);
                        break;
                    case DISPLAY_STRUCTURE_COSTS:
                        displayStructureCosts(terminal);
                        break;
                    case DISPLAY_SCORES:
                        displayScores(terminal, game);
                        break;
                    case BUILD_ROAD:
                        buildRoadAction(textIO, terminal, game);
                        break;
                    case BUILD_SETTLEMENT:
                        buildSettlementAction(textIO, terminal, game);
                        break;
                    case BUILD_CITY:
                        buildCityAction(textIO, terminal, game);
                        break;
                    case TRADE:
                        tradeAction(textIO, terminal, game);
                        break;
                    case NEXT_TURN:
                        endTurn = true;
                        break;
                    case QUIT:
                        gameOver = true;
                        break;
                }
            }

            Config.Faction winner = game.getWinner();
            if (winner != null) {
                terminal.println("\n*** " + winner + " wins! ***");
                gameOver = true;
            } else if (!gameOver) {
                game.switchToNextPlayer();
            }
        }

        terminal.println("Game over.");
    }

    private static void displayBoard(TextTerminal<?> terminal, SiedlerGame game) {
        SiedlerBoardTextView view = new SiedlerBoardTextView(game.getBoard());
        terminal.println(view.toString());
    }

    private static void displayPlayerResources(TextTerminal<?> terminal, SiedlerGame game) {
        terminal.println(game.getCurrentPlayerFaction() + "'s resources:");
        for (Config.Resource r : Config.Resource.values()) {
            terminal.println("  " + r + ": " + game.getCurrentPlayerResourceStock(r));
        }
    }

    private static void displayBankResources(TextTerminal<?> terminal, SiedlerGame game) {
        terminal.println("Bank resources:");
        for (Config.Resource r : Config.Resource.values()) {
            terminal.println("  " + r + ": " + game.getBankResourceStock(r));
        }
    }

    private static void displayStructureCosts(TextTerminal<?> terminal) {
        terminal.println("Structure costs:");
        for (Config.Structure s : Config.Structure.values()) {
            terminal.println("  " + s.name() + ": " + s.getCost());
        }
    }

    private static void displayScores(TextTerminal<?> terminal, SiedlerGame game) {
        terminal.println("Scores:");
        for (Config.Faction f : game.getPlayerFactions()) {
            int vp = 0;
            for (Settlement s : game.getBoard().getCorners()) {
                if (s.getFaction() == f) {
                    vp += s.getVictoryPoints();
                }
            }
            terminal.println("  " + f + ": " + vp + " VP");
        }
    }

    private static void placeSettlement(TextIO textIO, TextTerminal<?> terminal,
                                        SiedlerGame game, boolean payout) {
        boolean placed = false;
        while (!placed) {
            int x = textIO.newIntInputReader().read("Settlement X");
            int y = textIO.newIntInputReader().read("Settlement Y");
            placed = game.placeInitialSettlement(new Point(x, y), payout);
            if (!placed) {
                terminal.println("Invalid position. Try again.");
            }
        }
    }

    private static void placeInitialRoad(TextIO textIO, TextTerminal<?> terminal,
                                         SiedlerGame game) {
        boolean placed = false;
        while (!placed) {
            int x1 = textIO.newIntInputReader().read("Road start X");
            int y1 = textIO.newIntInputReader().read("Road start Y");
            int x2 = textIO.newIntInputReader().read("Road end X");
            int y2 = textIO.newIntInputReader().read("Road end Y");
            placed = game.placeInitialRoad(new Point(x1, y1), new Point(x2, y2));
            if (!placed) {
                terminal.println("Invalid road. Try again.");
            }
        }
    }

    private static void buildRoadAction(TextIO textIO, TextTerminal<?> terminal,
                                        SiedlerGame game) {
        int x1 = textIO.newIntInputReader().read("Road start X");
        int y1 = textIO.newIntInputReader().read("Road start Y");
        int x2 = textIO.newIntInputReader().read("Road end X");
        int y2 = textIO.newIntInputReader().read("Road end Y");
        if (!game.buildRoad(new Point(x1, y1), new Point(x2, y2))) {
            terminal.println("Cannot build road there.");
        } else {
            terminal.println("Road built!");
        }
    }

    private static void buildSettlementAction(TextIO textIO, TextTerminal<?> terminal,
                                              SiedlerGame game) {
        int x = textIO.newIntInputReader().read("Settlement X");
        int y = textIO.newIntInputReader().read("Settlement Y");
        if (!game.buildSettlement(new Point(x, y))) {
            terminal.println("Cannot build settlement there.");
        } else {
            terminal.println("Settlement built!");
        }
    }

    private static void buildCityAction(TextIO textIO, TextTerminal<?> terminal,
                                        SiedlerGame game) {
        int x = textIO.newIntInputReader().read("City X");
        int y = textIO.newIntInputReader().read("City Y");
        if (!game.buildCity(new Point(x, y))) {
            terminal.println("Cannot build city there.");
        } else {
            terminal.println("City built!");
        }
    }

    private static void tradeAction(TextIO textIO, TextTerminal<?> terminal,
                                    SiedlerGame game) {
        Config.Resource offer = textIO.newEnumInputReader(Config.Resource.class).read("Give 4x");
        Config.Resource want = textIO.newEnumInputReader(Config.Resource.class).read("Receive 1x");
        if (!game.tradeWithBankFourToOne(offer, want)) {
            terminal.println("Trade failed.");
        } else {
            terminal.println("Trade successful!");
        }
    }
}
