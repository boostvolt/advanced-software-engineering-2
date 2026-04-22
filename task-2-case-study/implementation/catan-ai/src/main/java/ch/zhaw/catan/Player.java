package ch.zhaw.catan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Player {
    private final Config.Faction faction;
    private final Map<Config.Resource, Integer> resources;
    private int roadsRemaining;
    private int settlementsRemaining;
    private int citiesRemaining;

    public Player(Config.Faction faction) {
        this.faction = faction;
        this.resources = new HashMap<>();
        for (Config.Resource r : Config.Resource.values()) {
            resources.put(r, 0);
        }
        this.roadsRemaining = Config.Structure.ROAD.getStockPerPlayer();
        this.settlementsRemaining = Config.Structure.SETTLEMENT.getStockPerPlayer();
        this.citiesRemaining = Config.Structure.CITY.getStockPerPlayer();
    }

    public Config.Faction getFaction() {
        return faction;
    }

    public int getResourceCount(Config.Resource resource) {
        return resources.getOrDefault(resource, 0);
    }

    public int getTotalResourceCount() {
        int total = 0;
        for (int count : resources.values()) {
            total += count;
        }
        return total;
    }

    public void addResource(Config.Resource resource, int amount) {
        resources.put(resource, resources.get(resource) + amount);
    }

    public void removeResource(Config.Resource resource, int amount) {
        resources.put(resource, resources.get(resource) - amount);
    }

    public boolean hasResources(List<Config.Resource> cost) {
        Map<Config.Resource, Integer> needed = new HashMap<>();
        for (Config.Resource r : cost) {
            needed.put(r, needed.getOrDefault(r, 0) + 1);
        }
        for (Map.Entry<Config.Resource, Integer> entry : needed.entrySet()) {
            if (getResourceCount(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    public void payResources(List<Config.Resource> cost) {
        for (Config.Resource r : cost) {
            removeResource(r, 1);
        }
    }

    public int getRoadsRemaining() {
        return roadsRemaining;
    }

    public int getSettlementsRemaining() {
        return settlementsRemaining;
    }

    public int getCitiesRemaining() {
        return citiesRemaining;
    }

    public void useRoad() {
        roadsRemaining--;
    }

    public void useSettlement() {
        settlementsRemaining--;
    }

    public void useCity() {
        citiesRemaining--;
    }

    public void returnSettlement() {
        settlementsRemaining++;
    }
}
