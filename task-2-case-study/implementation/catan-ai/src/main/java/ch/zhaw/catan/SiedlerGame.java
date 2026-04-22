package ch.zhaw.catan;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SiedlerGame {
    private final SiedlerBoard board;
    private final List<Player> players;
    private final Bank bank;
    private final int winPoints;
    private int currentPlayerIndex;
    private Point thiefPosition;

    public SiedlerGame(int winPoints, int numberOfPlayers) {
        this.winPoints = winPoints;
        this.board = new SiedlerBoard();
        this.board.createStandardBoard();
        this.bank = new Bank();
        this.thiefPosition = new Point(Config.INITIAL_THIEF_POSITION);

        this.players = new ArrayList<>();
        Config.Faction[] factions = Config.Faction.values();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(factions[i]));
        }
        this.currentPlayerIndex = 0;
    }

    public void switchToNextPlayer() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public void switchToPreviousPlayer() {
        currentPlayerIndex = (currentPlayerIndex - 1 + players.size()) % players.size();
    }

    public List<Config.Faction> getPlayerFactions() {
        List<Config.Faction> factions = new ArrayList<>();
        for (Player p : players) {
            factions.add(p.getFaction());
        }
        return factions;
    }

    public SiedlerBoard getBoard() {
        return board;
    }

    public Config.Faction getCurrentPlayerFaction() {
        return players.get(currentPlayerIndex).getFaction();
    }

    public int getCurrentPlayerResourceStock(Config.Resource resource) {
        return players.get(currentPlayerIndex).getResourceCount(resource);
    }

    public int getBankResourceStock(Config.Resource resource) {
        return bank.getStock(resource);
    }

    private Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    private Player getPlayer(Config.Faction faction) {
        for (Player p : players) {
            if (p.getFaction() == faction) {
                return p;
            }
        }
        return null;
    }

    public boolean placeInitialSettlement(Point position, boolean payout) {
        if (!board.hasCorner(position) || board.getCorner(position) != null) {
            return false;
        }
        if (!board.getNeighboursOfCorner(position).isEmpty()) {
            return false;
        }
        Player player = getCurrentPlayer();
        if (player.getSettlementsRemaining() <= 0) {
            return false;
        }

        board.setCorner(position, new Settlement(player.getFaction()));
        player.useSettlement();

        if (payout) {
            List<Point> adjacentFields = SiedlerBoard.getAdjacentFieldCoordinates(position);
            for (Point fieldPos : adjacentFields) {
                if (board.hasField(fieldPos)) {
                    Config.Land land = board.getField(fieldPos);
                    Config.Resource resource = land.getResource();
                    if (resource != null && bank.hasResource(resource, 1)) {
                        player.addResource(resource, 1);
                        bank.removeResource(resource, 1);
                    }
                }
            }
        }
        return true;
    }

    public boolean placeInitialRoad(Point roadStart, Point roadEnd) {
        if (!board.hasEdge(roadStart, roadEnd) || board.getEdge(roadStart, roadEnd) != null) {
            return false;
        }
        Player player = getCurrentPlayer();
        Config.Faction faction = player.getFaction();

        boolean connected = isConnectedToPlayerStructure(roadStart, faction)
                || isConnectedToPlayerStructure(roadEnd, faction);
        if (!connected) {
            return false;
        }
        if (player.getRoadsRemaining() <= 0) {
            return false;
        }

        String roadCode = "" + faction.name().charAt(0) + faction.name().charAt(0);
        board.setEdge(roadStart, roadEnd, roadCode);
        player.useRoad();
        return true;
    }

    private boolean isConnectedToPlayerStructure(Point corner, Config.Faction faction) {
        if (board.hasCorner(corner)) {
            Settlement s = board.getCorner(corner);
            if (s != null && s.getFaction() == faction) {
                return true;
            }
        }
        for (String edgeData : board.getAdjacentEdges(corner)) {
            if (edgeData != null && getFactionFromEdge(edgeData) == faction) {
                return true;
            }
        }
        return false;
    }

    private static Config.Faction getFactionFromEdge(String edgeData) {
        if (edgeData == null || edgeData.isEmpty()) {
            return null;
        }
        char c = edgeData.charAt(0);
        for (Config.Faction f : Config.Faction.values()) {
            if (f.name().charAt(0) == c) {
                return f;
            }
        }
        return null;
    }

    public Map<Config.Faction, List<Config.Resource>> throwDice(int diceValue) {
        Map<Config.Faction, List<Config.Resource>> result = new HashMap<>();
        for (Player p : players) {
            result.put(p.getFaction(), new ArrayList<>());
        }

        if (diceValue == 7) {
            Random random = new Random();
            for (Player p : players) {
                int total = p.getTotalResourceCount();
                if (total > Config.MAX_CARDS_IN_HAND_NO_DROP) {
                    int discard = total / 2;
                    List<Config.Resource> hand = new ArrayList<>();
                    for (Config.Resource r : Config.Resource.values()) {
                        for (int i = 0; i < p.getResourceCount(r); i++) {
                            hand.add(r);
                        }
                    }
                    Collections.shuffle(hand, random);
                    for (int i = 0; i < discard; i++) {
                        Config.Resource r = hand.get(i);
                        p.removeResource(r, 1);
                        bank.addResource(r, 1);
                    }
                }
            }
            return result;
        }

        List<Point> fields = board.getFieldsForDiceValue(diceValue);

        // Calculate demand per resource per player
        Map<Config.Resource, Map<Config.Faction, Integer>> demand = new HashMap<>();

        for (Point fieldPos : fields) {
            if (fieldPos.equals(thiefPosition)) {
                continue;
            }
            Config.Land land = board.getField(fieldPos);
            Config.Resource resource = land.getResource();
            if (resource == null) {
                continue;
            }

            List<Point> corners = SiedlerBoard.getCornerCoordinatesOfField(fieldPos);
            for (Point corner : corners) {
                if (!board.hasCorner(corner)) {
                    continue;
                }
                Settlement s = board.getCorner(corner);
                if (s != null) {
                    int amount = s.getResourceProduction();
                    Config.Faction faction = s.getFaction();

                    if (!demand.containsKey(resource)) {
                        demand.put(resource, new HashMap<>());
                    }
                    Map<Config.Faction, Integer> factionDemand = demand.get(resource);
                    factionDemand.put(faction,
                            factionDemand.getOrDefault(faction, 0) + amount);
                }
            }
        }

        // Check bank supply and distribute
        for (Map.Entry<Config.Resource, Map<Config.Faction, Integer>> entry : demand.entrySet()) {
            Config.Resource resource = entry.getKey();
            Map<Config.Faction, Integer> factionDemand = entry.getValue();

            int totalDemand = 0;
            for (int d : factionDemand.values()) {
                totalDemand += d;
            }

            if (bank.hasResource(resource, totalDemand)) {
                for (Map.Entry<Config.Faction, Integer> fd : factionDemand.entrySet()) {
                    Config.Faction faction = fd.getKey();
                    int amount = fd.getValue();
                    Player player = getPlayer(faction);
                    player.addResource(resource, amount);
                    bank.removeResource(resource, amount);
                    for (int i = 0; i < amount; i++) {
                        result.get(faction).add(resource);
                    }
                }
            }
        }

        return result;
    }

    public boolean buildSettlement(Point position) {
        Player player = getCurrentPlayer();

        if (!player.hasResources(Config.Structure.SETTLEMENT.getCost())) {
            return false;
        }
        if (player.getSettlementsRemaining() <= 0) {
            return false;
        }
        if (!board.hasCorner(position) || board.getCorner(position) != null) {
            return false;
        }
        if (!board.getNeighboursOfCorner(position).isEmpty()) {
            return false;
        }

        // Must be adjacent to one of the player's roads
        Config.Faction faction = player.getFaction();
        boolean hasAdjacentRoad = false;
        for (String edgeData : board.getAdjacentEdges(position)) {
            if (edgeData != null && getFactionFromEdge(edgeData) == faction) {
                hasAdjacentRoad = true;
                break;
            }
        }
        if (!hasAdjacentRoad) {
            return false;
        }

        player.payResources(Config.Structure.SETTLEMENT.getCost());
        for (Config.Resource r : Config.Structure.SETTLEMENT.getCost()) {
            bank.addResource(r, 1);
        }

        board.setCorner(position, new Settlement(faction));
        player.useSettlement();
        return true;
    }

    public boolean buildCity(Point position) {
        Player player = getCurrentPlayer();
        Config.Faction faction = player.getFaction();

        if (!player.hasResources(Config.Structure.CITY.getCost())) {
            return false;
        }
        if (player.getCitiesRemaining() <= 0) {
            return false;
        }
        if (!board.hasCorner(position)) {
            return false;
        }
        Settlement existing = board.getCorner(position);
        if (existing == null || existing.getFaction() != faction || existing instanceof City) {
            return false;
        }

        player.payResources(Config.Structure.CITY.getCost());
        for (Config.Resource r : Config.Structure.CITY.getCost()) {
            bank.addResource(r, 1);
        }

        board.setCorner(position, new City(faction));
        player.useCity();
        player.returnSettlement();
        return true;
    }

    public boolean buildRoad(Point roadStart, Point roadEnd) {
        Player player = getCurrentPlayer();
        Config.Faction faction = player.getFaction();

        if (!player.hasResources(Config.Structure.ROAD.getCost())) {
            return false;
        }
        if (player.getRoadsRemaining() <= 0) {
            return false;
        }
        if (!board.hasEdge(roadStart, roadEnd) || board.getEdge(roadStart, roadEnd) != null) {
            return false;
        }

        boolean connected = isConnectedToPlayerStructure(roadStart, faction)
                || isConnectedToPlayerStructure(roadEnd, faction);
        if (!connected) {
            return false;
        }

        player.payResources(Config.Structure.ROAD.getCost());
        for (Config.Resource r : Config.Structure.ROAD.getCost()) {
            bank.addResource(r, 1);
        }

        String roadCode = "" + faction.name().charAt(0) + faction.name().charAt(0);
        board.setEdge(roadStart, roadEnd, roadCode);
        player.useRoad();
        return true;
    }

    public boolean tradeWithBankFourToOne(Config.Resource offer, Config.Resource want) {
        Player player = getCurrentPlayer();
        if (player.getResourceCount(offer) < 4) {
            return false;
        }
        if (!bank.hasResource(want, 1)) {
            return false;
        }

        player.removeResource(offer, 4);
        bank.addResource(offer, 4);
        player.addResource(want, 1);
        bank.removeResource(want, 1);
        return true;
    }

    public Config.Faction getWinner() {
        for (Player p : players) {
            if (countVictoryPoints(p.getFaction()) >= winPoints) {
                return p.getFaction();
            }
        }
        return null;
    }

    private int countVictoryPoints(Config.Faction faction) {
        int vp = 0;
        for (Settlement s : board.getCorners()) {
            if (s.getFaction() == faction) {
                vp += s.getVictoryPoints();
            }
        }
        return vp;
    }

    public boolean placeThiefAndStealCard(Point field) {
        if (!board.hasField(field)) {
            return false;
        }
        Config.Land land = board.getField(field);
        if (land == Config.Land.WATER) {
            return false;
        }
        if (field.equals(thiefPosition)) {
            return false;
        }

        thiefPosition = new Point(field);

        Player currentPlayer = getCurrentPlayer();
        List<Player> victims = new ArrayList<>();
        List<Point> corners = SiedlerBoard.getCornerCoordinatesOfField(field);
        for (Point corner : corners) {
            if (!board.hasCorner(corner)) {
                continue;
            }
            Settlement s = board.getCorner(corner);
            if (s != null && s.getFaction() != currentPlayer.getFaction()) {
                Player victim = getPlayer(s.getFaction());
                if (!victims.contains(victim) && victim.getTotalResourceCount() > 0) {
                    victims.add(victim);
                }
            }
        }

        if (!victims.isEmpty()) {
            Random random = new Random();
            Player victim = victims.get(random.nextInt(victims.size()));

            List<Config.Resource> victimHand = new ArrayList<>();
            for (Config.Resource r : Config.Resource.values()) {
                for (int i = 0; i < victim.getResourceCount(r); i++) {
                    victimHand.add(r);
                }
            }

            if (!victimHand.isEmpty()) {
                Config.Resource stolen = victimHand.get(random.nextInt(victimHand.size()));
                victim.removeResource(stolen, 1);
                currentPlayer.addResource(stolen, 1);
            }
        }

        return true;
    }
}
