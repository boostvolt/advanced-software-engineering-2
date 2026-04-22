package ch.zhaw.catan;

import org.junit.jupiter.api.Test;

import java.awt.Point;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SiedlerGameTest {

    @Test
    void requirementPlayerSwitching() {
        SiedlerGame game = new SiedlerGame(7, 3);
        assertEquals(Config.Faction.RED, game.getCurrentPlayerFaction());

        game.switchToNextPlayer();
        assertEquals(Config.Faction.BLUE, game.getCurrentPlayerFaction());

        game.switchToNextPlayer();
        assertEquals(Config.Faction.GREEN, game.getCurrentPlayerFaction());

        game.switchToNextPlayer();
        assertEquals(Config.Faction.RED, game.getCurrentPlayerFaction());

        game.switchToPreviousPlayer();
        assertEquals(Config.Faction.GREEN, game.getCurrentPlayerFaction());

        game.switchToPreviousPlayer();
        assertEquals(Config.Faction.BLUE, game.getCurrentPlayerFaction());

        game.switchToPreviousPlayer();
        assertEquals(Config.Faction.RED, game.getCurrentPlayerFaction());
    }

    @Test
    void requirementSetupTestBoardUsedWithTheTests() {
        SiedlerGame game = new SiedlerGame(7, 2);
        SiedlerBoard board = game.getBoard();

        // Verify all land types from Section 7
        assertEquals(Config.Land.FOREST, board.getField(new Point(5, 5)));
        assertEquals(Config.Land.FOREST, board.getField(new Point(3, 11)));
        assertEquals(Config.Land.FOREST, board.getField(new Point(10, 8)));
        assertEquals(Config.Land.FOREST, board.getField(new Point(8, 14)));

        assertEquals(Config.Land.MEADOW, board.getField(new Point(7, 5)));
        assertEquals(Config.Land.MEADOW, board.getField(new Point(9, 5)));
        assertEquals(Config.Land.MEADOW, board.getField(new Point(10, 14)));
        assertEquals(Config.Land.MEADOW, board.getField(new Point(5, 17)));

        assertEquals(Config.Land.GRAINFIELD, board.getField(new Point(4, 8)));
        assertEquals(Config.Land.GRAINFIELD, board.getField(new Point(8, 8)));
        assertEquals(Config.Land.GRAINFIELD, board.getField(new Point(11, 11)));
        assertEquals(Config.Land.GRAINFIELD, board.getField(new Point(4, 14)));

        assertEquals(Config.Land.MOUNTAIN, board.getField(new Point(6, 8)));
        assertEquals(Config.Land.MOUNTAIN, board.getField(new Point(9, 11)));
        assertEquals(Config.Land.MOUNTAIN, board.getField(new Point(6, 14)));

        assertEquals(Config.Land.CLAYSOIL, board.getField(new Point(5, 11)));
        assertEquals(Config.Land.CLAYSOIL, board.getField(new Point(7, 17)));
        assertEquals(Config.Land.CLAYSOIL, board.getField(new Point(9, 17)));

        assertEquals(Config.Land.DESERT, board.getField(new Point(7, 11)));

        assertEquals(Config.Land.WATER, board.getField(new Point(4, 2)));
        assertEquals(Config.Land.WATER, board.getField(new Point(6, 2)));
        assertEquals(Config.Land.WATER, board.getField(new Point(8, 2)));
        assertEquals(Config.Land.WATER, board.getField(new Point(10, 2)));
        assertEquals(Config.Land.WATER, board.getField(new Point(3, 5)));
        assertEquals(Config.Land.WATER, board.getField(new Point(11, 5)));
        assertEquals(Config.Land.WATER, board.getField(new Point(2, 8)));
        assertEquals(Config.Land.WATER, board.getField(new Point(12, 8)));
        assertEquals(Config.Land.WATER, board.getField(new Point(1, 11)));
        assertEquals(Config.Land.WATER, board.getField(new Point(13, 11)));
        assertEquals(Config.Land.WATER, board.getField(new Point(2, 14)));
        assertEquals(Config.Land.WATER, board.getField(new Point(12, 14)));
        assertEquals(Config.Land.WATER, board.getField(new Point(3, 17)));
        assertEquals(Config.Land.WATER, board.getField(new Point(11, 17)));
        assertEquals(Config.Land.WATER, board.getField(new Point(4, 20)));
        assertEquals(Config.Land.WATER, board.getField(new Point(6, 20)));
        assertEquals(Config.Land.WATER, board.getField(new Point(8, 20)));
        assertEquals(Config.Land.WATER, board.getField(new Point(10, 20)));

        // Verify dice numbers
        Map<Point, Integer> diceNumbers = board.getDiceNumbers();
        assertEquals(2, (int) diceNumbers.get(new Point(4, 8)));
        assertEquals(3, (int) diceNumbers.get(new Point(7, 5)));
        assertEquals(3, (int) diceNumbers.get(new Point(8, 14)));
        assertEquals(4, (int) diceNumbers.get(new Point(6, 8)));
        assertEquals(4, (int) diceNumbers.get(new Point(7, 17)));
        assertEquals(5, (int) diceNumbers.get(new Point(3, 11)));
        assertEquals(5, (int) diceNumbers.get(new Point(8, 8)));
        assertEquals(6, (int) diceNumbers.get(new Point(5, 5)));
        assertEquals(6, (int) diceNumbers.get(new Point(9, 11)));
        assertEquals(7, (int) diceNumbers.get(new Point(7, 11)));
        assertEquals(8, (int) diceNumbers.get(new Point(9, 5)));
        assertEquals(8, (int) diceNumbers.get(new Point(5, 17)));
        assertEquals(9, (int) diceNumbers.get(new Point(5, 11)));
        assertEquals(9, (int) diceNumbers.get(new Point(11, 11)));
        assertEquals(10, (int) diceNumbers.get(new Point(4, 14)));
        assertEquals(10, (int) diceNumbers.get(new Point(10, 8)));
        assertEquals(11, (int) diceNumbers.get(new Point(6, 14)));
        assertEquals(11, (int) diceNumbers.get(new Point(9, 17)));
        assertEquals(12, (int) diceNumbers.get(new Point(10, 14)));
    }

    @Test
    void requirementResourcePayoutAndReturnValueForDiceThrow() {
        SiedlerGame game = new SiedlerGame(7, 2);

        // RED settlement at (5,3) - corner of FOREST(5,5) chip 6
        assertTrue(game.placeInitialSettlement(new Point(5, 3), false));
        assertTrue(game.placeInitialRoad(new Point(5, 3), new Point(6, 4)));

        game.switchToNextPlayer();

        // BLUE settlement at (9,3) - corner of MEADOW(9,5) chip 8
        assertTrue(game.placeInitialSettlement(new Point(9, 3), false));
        assertTrue(game.placeInitialRoad(new Point(9, 3), new Point(10, 4)));

        // Second round (reverse) - BLUE second settlement
        assertTrue(game.placeInitialSettlement(new Point(10, 10), true));
        assertTrue(game.placeInitialRoad(new Point(10, 10), new Point(11, 9)));

        // RED second settlement
        game.switchToPreviousPlayer();
        assertTrue(game.placeInitialSettlement(new Point(4, 6), true));
        assertTrue(game.placeInitialRoad(new Point(4, 6), new Point(5, 7)));

        // Dice roll 6: FOREST(5,5)->WOOD, MOUNTAIN(9,11)->STONE
        // RED has settlements at (5,3) and (4,6), both corners of FOREST(5,5)
        // BLUE has settlement at (10,10), corner of MOUNTAIN(9,11)
        Map<Config.Faction, List<Config.Resource>> payout6 = game.throwDice(6);

        List<Config.Resource> redPayout = payout6.get(Config.Faction.RED);
        assertEquals(2, Collections.frequency(redPayout, Config.Resource.WOOD));

        List<Config.Resource> bluePayout = payout6.get(Config.Faction.BLUE);
        assertEquals(1, Collections.frequency(bluePayout, Config.Resource.STONE));

        // Dice roll 8: MEADOW(9,5)->WOOL, MEADOW(5,17)->WOOL
        // BLUE has settlement at (9,3), corner of MEADOW(9,5)
        Map<Config.Faction, List<Config.Resource>> payout8 = game.throwDice(8);
        List<Config.Resource> bluePayout8 = payout8.get(Config.Faction.BLUE);
        assertTrue(bluePayout8.contains(Config.Resource.WOOL));
        assertEquals(1, Collections.frequency(bluePayout8, Config.Resource.WOOL));

        // Dice roll 7: no resources produced
        Map<Config.Faction, List<Config.Resource>> payout7 = game.throwDice(7);
        assertTrue(payout7.get(Config.Faction.RED).isEmpty());
        assertTrue(payout7.get(Config.Faction.BLUE).isEmpty());
    }

    @Test
    void testDistanceRule() {
        SiedlerGame game = new SiedlerGame(7, 2);

        assertTrue(game.placeInitialSettlement(new Point(5, 3), false));

        // Adjacent corners of (5,3): (5,1), (6,4), (4,4) - all should fail
        assertFalse(game.placeInitialSettlement(new Point(6, 4), false));
        assertFalse(game.placeInitialSettlement(new Point(4, 4), false));

        // Non-adjacent corner should succeed
        assertTrue(game.placeInitialSettlement(new Point(8, 4), false));
    }

    @Test
    void testBuildCityInheritance() {
        // Verify City extends Settlement (Teilaufgabe 2 inheritance requirement)
        City city = new City(Config.Faction.RED);
        assertTrue(city instanceof Settlement);
        assertEquals(2, city.getVictoryPoints());
        assertEquals(2, city.getResourceProduction());
        assertEquals("RC", city.toString());

        Settlement settlement = new Settlement(Config.Faction.BLUE);
        assertEquals(1, settlement.getVictoryPoints());
        assertEquals(1, settlement.getResourceProduction());
        assertEquals("BS", settlement.toString());
    }

    @Test
    void testTradeWithBank() {
        SiedlerGame game = new SiedlerGame(7, 2);

        // Setup
        assertTrue(game.placeInitialSettlement(new Point(5, 3), false));
        assertTrue(game.placeInitialRoad(new Point(5, 3), new Point(6, 4)));
        game.switchToNextPlayer();
        assertTrue(game.placeInitialSettlement(new Point(9, 3), false));
        assertTrue(game.placeInitialRoad(new Point(9, 3), new Point(10, 4)));
        assertTrue(game.placeInitialSettlement(new Point(10, 10), true));
        assertTrue(game.placeInitialRoad(new Point(10, 10), new Point(11, 9)));
        game.switchToPreviousPlayer();
        assertTrue(game.placeInitialSettlement(new Point(4, 6), true));
        assertTrue(game.placeInitialRoad(new Point(4, 6), new Point(5, 7)));

        // RED has WOOD=1, GRAIN=1 from founding payout
        // Cannot trade with less than 4 resources
        assertFalse(game.tradeWithBankFourToOne(Config.Resource.WOOD, Config.Resource.STONE));

        // Give RED enough WOOD via dice rolls
        game.throwDice(6); // RED gets 2 WOOD (total 3)
        game.throwDice(6); // RED gets 2 WOOD (total 5)

        // Now RED has 5 WOOD, trade 4 for 1 STONE
        assertTrue(game.tradeWithBankFourToOne(Config.Resource.WOOD, Config.Resource.STONE));
        assertEquals(1, game.getCurrentPlayerResourceStock(Config.Resource.WOOD));
        assertEquals(1, game.getCurrentPlayerResourceStock(Config.Resource.STONE));
    }

    @Test
    void testInitialSettlementPayout() {
        SiedlerGame game = new SiedlerGame(7, 2);

        // RED first settlement - no payout
        assertTrue(game.placeInitialSettlement(new Point(5, 3), false));
        assertTrue(game.placeInitialRoad(new Point(5, 3), new Point(6, 4)));
        assertEquals(0, game.getCurrentPlayerResourceStock(Config.Resource.WOOD));

        game.switchToNextPlayer();
        assertTrue(game.placeInitialSettlement(new Point(9, 3), false));
        assertTrue(game.placeInitialRoad(new Point(9, 3), new Point(10, 4)));

        // BLUE second settlement at (10,10) with payout
        // Adjacent fields: (10,8)=FOREST->WOOD, (11,11)=GRAINFIELD->GRAIN, (9,11)=MOUNTAIN->STONE
        assertTrue(game.placeInitialSettlement(new Point(10, 10), true));
        assertEquals(1, game.getCurrentPlayerResourceStock(Config.Resource.WOOD));
        assertEquals(1, game.getCurrentPlayerResourceStock(Config.Resource.GRAIN));
        assertEquals(1, game.getCurrentPlayerResourceStock(Config.Resource.STONE));
    }

    @Test
    void testWinnerDetection() {
        SiedlerGame game = new SiedlerGame(7, 2);

        // No winner at start
        assertNull(game.getWinner());

        // Place initial settlements (2 VP for RED)
        assertTrue(game.placeInitialSettlement(new Point(5, 3), false));
        assertTrue(game.placeInitialRoad(new Point(5, 3), new Point(6, 4)));
        game.switchToNextPlayer();
        assertTrue(game.placeInitialSettlement(new Point(9, 3), false));
        assertTrue(game.placeInitialRoad(new Point(9, 3), new Point(10, 4)));
        assertTrue(game.placeInitialSettlement(new Point(10, 10), true));
        assertTrue(game.placeInitialRoad(new Point(10, 10), new Point(11, 9)));
        game.switchToPreviousPlayer();
        assertTrue(game.placeInitialSettlement(new Point(4, 6), true));
        assertTrue(game.placeInitialRoad(new Point(4, 6), new Point(5, 7)));

        // RED has 2 settlements = 2 VP, not enough for 7
        assertNull(game.getWinner());
    }
}
