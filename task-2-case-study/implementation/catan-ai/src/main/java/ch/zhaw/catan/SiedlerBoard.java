package ch.zhaw.catan;

import ch.zhaw.hexboard.HexBoard;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SiedlerBoard extends HexBoard<Config.Land, Settlement, String, String> {

    private final Map<Point, Integer> diceNumbers;

    public SiedlerBoard() {
        super();
        this.diceNumbers = new HashMap<>();
    }

    public void createStandardBoard() {
        Map<Point, Config.Land> landPlacement = Config.getStandardLandPlacement();
        for (Map.Entry<Point, Config.Land> entry : landPlacement.entrySet()) {
            addField(entry.getKey(), entry.getValue());
        }
        diceNumbers.putAll(Config.getStandardDiceNumberPlacement());
    }

    public Map<Point, Integer> getDiceNumbers() {
        return Collections.unmodifiableMap(diceNumbers);
    }

    public int getDiceNumber(Point field) {
        return diceNumbers.getOrDefault(field, 0);
    }

    public List<Point> getFieldsForDiceValue(int value) {
        List<Point> result = new ArrayList<>();
        for (Map.Entry<Point, Integer> entry : diceNumbers.entrySet()) {
            if (entry.getValue() == value) {
                result.add(entry.getKey());
            }
        }
        return result;
    }

    public static List<Point> getCornerCoordinatesOfField(Point center) {
        List<Point> corners = new ArrayList<>();
        corners.add(new Point(center.x, center.y - 2));
        corners.add(new Point(center.x + 1, center.y - 1));
        corners.add(new Point(center.x + 1, center.y + 1));
        corners.add(new Point(center.x, center.y + 2));
        corners.add(new Point(center.x - 1, center.y + 1));
        corners.add(new Point(center.x - 1, center.y - 1));
        return corners;
    }

    public static List<Point> getAdjacentFieldCoordinates(Point corner) {
        List<Point> fields = new ArrayList<>();
        if (corner.y % 3 == 0) {
            fields.add(new Point(corner.x, corner.y + 2));
            fields.add(new Point(corner.x + 1, corner.y - 1));
            fields.add(new Point(corner.x - 1, corner.y - 1));
        } else {
            fields.add(new Point(corner.x, corner.y - 2));
            fields.add(new Point(corner.x + 1, corner.y + 1));
            fields.add(new Point(corner.x - 1, corner.y + 1));
        }
        return fields;
    }

    public Set<Point> getAllCornerCoordinates() {
        return getCornerCoordinates();
    }
}
