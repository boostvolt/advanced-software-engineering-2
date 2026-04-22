package ch.zhaw.catan;

import java.awt.Point;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Config {
    public static final int MIN_NUMBER_OF_PLAYERS = 2;
    public static final int MAX_NUMBER_OF_PLAYERS = 4;
    public static final int MAX_CARDS_IN_HAND_NO_DROP = 7;
    public static final Point INITIAL_THIEF_POSITION = new Point(7, 11);
    public static final int INITIAL_RESOURCE_CARDS_BANK = 19;

    public enum Faction {
        RED, BLUE, GREEN, YELLOW;
    }

    public enum Resource {
        GRAIN, WOOL, WOOD, STONE, CLAY;
    }

    public enum Land {
        FOREST("FO", Resource.WOOD),
        MEADOW("ME", Resource.WOOL),
        GRAINFIELD("GR", Resource.GRAIN),
        MOUNTAIN("MO", Resource.STONE),
        CLAYSOIL("CL", Resource.CLAY),
        WATER("WA", null),
        DESERT("DE", null);

        private final String label;
        private final Resource resource;

        Land(String label, Resource resource) {
            this.label = label;
            this.resource = resource;
        }

        public Resource getResource() {
            return resource;
        }

        @Override
        public String toString() {
            return label;
        }
    }

    public enum Structure {
        SETTLEMENT(List.of(Resource.WOOD, Resource.CLAY, Resource.WOOL, Resource.GRAIN), 5),
        CITY(List.of(Resource.GRAIN, Resource.GRAIN, Resource.STONE, Resource.STONE, Resource.STONE), 4),
        ROAD(List.of(Resource.WOOD, Resource.CLAY), 15);

        private final List<Resource> cost;
        private final int stockPerPlayer;

        Structure(List<Resource> cost, int stockPerPlayer) {
            this.cost = cost;
            this.stockPerPlayer = stockPerPlayer;
        }

        public List<Resource> getCost() {
            return cost;
        }

        public int getStockPerPlayer() {
            return stockPerPlayer;
        }
    }

    public static Map<Point, Land> getStandardLandPlacement() {
        Map<Point, Land> map = new HashMap<>();
        map.put(new Point(5, 5), Land.FOREST);
        map.put(new Point(3, 11), Land.FOREST);
        map.put(new Point(10, 8), Land.FOREST);
        map.put(new Point(8, 14), Land.FOREST);

        map.put(new Point(7, 5), Land.MEADOW);
        map.put(new Point(9, 5), Land.MEADOW);
        map.put(new Point(10, 14), Land.MEADOW);
        map.put(new Point(5, 17), Land.MEADOW);

        map.put(new Point(4, 8), Land.GRAINFIELD);
        map.put(new Point(8, 8), Land.GRAINFIELD);
        map.put(new Point(11, 11), Land.GRAINFIELD);
        map.put(new Point(4, 14), Land.GRAINFIELD);

        map.put(new Point(6, 8), Land.MOUNTAIN);
        map.put(new Point(9, 11), Land.MOUNTAIN);
        map.put(new Point(6, 14), Land.MOUNTAIN);

        map.put(new Point(5, 11), Land.CLAYSOIL);
        map.put(new Point(7, 17), Land.CLAYSOIL);
        map.put(new Point(9, 17), Land.CLAYSOIL);

        map.put(new Point(7, 11), Land.DESERT);

        map.put(new Point(4, 2), Land.WATER);
        map.put(new Point(6, 2), Land.WATER);
        map.put(new Point(8, 2), Land.WATER);
        map.put(new Point(10, 2), Land.WATER);
        map.put(new Point(3, 5), Land.WATER);
        map.put(new Point(11, 5), Land.WATER);
        map.put(new Point(2, 8), Land.WATER);
        map.put(new Point(12, 8), Land.WATER);
        map.put(new Point(1, 11), Land.WATER);
        map.put(new Point(13, 11), Land.WATER);
        map.put(new Point(2, 14), Land.WATER);
        map.put(new Point(12, 14), Land.WATER);
        map.put(new Point(3, 17), Land.WATER);
        map.put(new Point(11, 17), Land.WATER);
        map.put(new Point(4, 20), Land.WATER);
        map.put(new Point(6, 20), Land.WATER);
        map.put(new Point(8, 20), Land.WATER);
        map.put(new Point(10, 20), Land.WATER);

        return map;
    }

    public static Map<Point, Integer> getStandardDiceNumberPlacement() {
        Map<Point, Integer> map = new HashMap<>();
        map.put(new Point(4, 8), 2);
        map.put(new Point(7, 5), 3);
        map.put(new Point(8, 14), 3);
        map.put(new Point(6, 8), 4);
        map.put(new Point(7, 17), 4);
        map.put(new Point(3, 11), 5);
        map.put(new Point(8, 8), 5);
        map.put(new Point(5, 5), 6);
        map.put(new Point(9, 11), 6);
        map.put(new Point(7, 11), 7);
        map.put(new Point(9, 5), 8);
        map.put(new Point(5, 17), 8);
        map.put(new Point(5, 11), 9);
        map.put(new Point(11, 11), 9);
        map.put(new Point(4, 14), 10);
        map.put(new Point(10, 8), 10);
        map.put(new Point(6, 14), 11);
        map.put(new Point(9, 17), 11);
        map.put(new Point(10, 14), 12);
        return map;
    }
}
