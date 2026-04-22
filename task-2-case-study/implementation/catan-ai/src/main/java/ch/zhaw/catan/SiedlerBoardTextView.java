package ch.zhaw.catan;

import ch.zhaw.hexboard.HexBoardTextView;
import ch.zhaw.hexboard.Label;

import java.awt.Point;
import java.util.Map;

public class SiedlerBoardTextView extends HexBoardTextView<Config.Land, Settlement, String, String> {

    public SiedlerBoardTextView(SiedlerBoard board) {
        super(board);
        Map<Point, Integer> diceNumbers = board.getDiceNumbers();
        for (Map.Entry<Point, Integer> entry : diceNumbers.entrySet()) {
            int num = entry.getValue();
            if (num < 10) {
                setLowerFieldLabel(entry.getKey(), new Label(' ', (char) ('0' + num)));
            } else {
                setLowerFieldLabel(entry.getKey(),
                        new Label((char) ('0' + num / 10), (char) ('0' + num % 10)));
            }
        }
    }
}
