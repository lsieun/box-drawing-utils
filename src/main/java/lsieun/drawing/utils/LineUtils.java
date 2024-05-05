package lsieun.drawing.utils;

import lsieun.drawing.canvas.Box;
import lsieun.drawing.canvas.TextDirection;
import lsieun.drawing.theme.shape.line.ConnectionDirection;
import lsieun.drawing.theme.shape.line.ContinuousLine;
import lsieun.drawing.theme.shape.rect.Rectangle;

public class LineUtils {
    public static ContinuousLine connect(Rectangle rect1, Rectangle rect2, ConnectionDirection direction) {
        switch (direction) {
            case VERTICAL:
                if (rect2.getTop() - rect1.getBottom() >= 2) {
                    return connectTopDown(rect1, rect2);
                }
                else if (rect1.getTop() - rect2.getBottom() >= 2) {
                    return connectTopDown(rect2, rect1);
                }
                else {
                    throw new RuntimeException("Cannot connect " + rect1 + " and " + rect2 + " with direction " + direction);
                }
            case HORIZONTAL:
                if (rect2.getLeft() - rect1.getRight() >= 2) {
                    return connectLeftRight(rect1, rect2);
                }
                else if (rect1.getLeft() - rect2.getRight() >= 2) {
                    return connectLeftRight(rect2, rect1);
                }
                else {
                    throw new RuntimeException("Cannot connect " + rect1 + " and " + rect2 + " with direction " + direction);
                }
            default:
                throw new RuntimeException("Unsupported connection direction: " + direction);
        }
    }

    private static ContinuousLine connectTopDown(Rectangle rect1, Rectangle rect2) {
        int row1 = rect1.getBottom();
        int col1 = rect1.getCenterCol();

        int row2 = rect2.getTop();
        int col2 = rect2.getCenterCol();

        int rowBetween = row2 - row1 - 1;
        int colBetween = Math.abs(col2 - col1) - 1;

        ContinuousLine line = new ContinuousLine();
        line.setStartRow(row1);
        line.setStartCol(col1);
        line.setDirection(TextDirection.DOWN);
        line.setStart(Box.DOWN_AND_HORIZONTAL.val);
        if (col1 == col2) {
            line.drawLine(rowBetween);
        }
        else {
            int halfUp = (rowBetween - 1) / 2;
            int halfDown = (rowBetween - 1) - halfUp;

            line.drawLine(halfUp);
            if (col1 < col2) {
                line.turn(TextDirection.RIGHT);
            }
            else {
                line.turn(TextDirection.LEFT);
            }
            line.drawLine(colBetween)
                    .turn(TextDirection.DOWN)
                    .drawLine(halfDown);
        }
        line.setStop(Box.UP_AND_HORIZONTAL.val);

        return line;
    }

    private static ContinuousLine connectLeftRight(Rectangle rect1, Rectangle rect2) {
        int row1 = rect1.getCenterRow();
        int col1 = rect1.getRight();

        int row2 = rect2.getCenterRow();
        int col2 = rect2.getLeft();

        int colBetween = col2 - col1 - 1;
        int rowBetween = Math.abs(row2 - row1) - 1;

        ContinuousLine line = new ContinuousLine();
        line.setStartRow(row1);
        line.setStartCol(col1);
        line.setDirection(TextDirection.RIGHT);
        line.setStart(Box.VERTICAL_AND_RIGHT.val);
        if (row1 == row2) {
            line.drawLine(colBetween);
        }
        else {
            int halfLeft = (colBetween - 1) / 2;
            int halfRight = (colBetween - 1) - halfLeft;

            line.drawLine(halfLeft);
            if (row1 < row2) {
                line.turn(TextDirection.DOWN);
            }
            else {
                line.turn(TextDirection.UP);
            }
            line.drawLine(rowBetween)
                    .turn(TextDirection.RIGHT)
                    .drawLine(halfRight);
        }
        line.setStop(Box.VERTICAL_AND_LEFT.val);

        return line;
    }
}
