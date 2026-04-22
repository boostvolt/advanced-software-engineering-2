package ch.zhaw.catan;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<Config.Resource, Integer> stock;

    public Bank() {
        stock = new HashMap<>();
        for (Config.Resource r : Config.Resource.values()) {
            stock.put(r, Config.INITIAL_RESOURCE_CARDS_BANK);
        }
    }

    public int getStock(Config.Resource resource) {
        return stock.getOrDefault(resource, 0);
    }

    public void addResource(Config.Resource resource, int amount) {
        stock.put(resource, stock.get(resource) + amount);
    }

    public void removeResource(Config.Resource resource, int amount) {
        stock.put(resource, stock.get(resource) - amount);
    }

    public boolean hasResource(Config.Resource resource, int amount) {
        return getStock(resource) >= amount;
    }
}
