package ch.zhaw.catan;

public class Settlement {
    private final Config.Faction faction;

    public Settlement(Config.Faction faction) {
        this.faction = faction;
    }

    public Config.Faction getFaction() {
        return faction;
    }

    public int getVictoryPoints() {
        return 1;
    }

    public int getResourceProduction() {
        return 1;
    }

    @Override
    public String toString() {
        return "" + faction.name().charAt(0) + "S";
    }
}
