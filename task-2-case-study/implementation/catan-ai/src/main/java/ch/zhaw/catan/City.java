package ch.zhaw.catan;

public class City extends Settlement {

    public City(Config.Faction faction) {
        super(faction);
    }

    @Override
    public int getVictoryPoints() {
        return 2;
    }

    @Override
    public int getResourceProduction() {
        return 2;
    }

    @Override
    public String toString() {
        return "" + getFaction().name().charAt(0) + "C";
    }
}
