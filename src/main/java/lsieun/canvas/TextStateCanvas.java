package lsieun.canvas;

public class TextStateCanvas extends TextCanvas {
    private int row;
    private int col;
    private TextDirection direction;

    public void moveTo(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void moveUp(int count) {
        row -= count;
    }

    public void moveDown(int count) {
        row += count;
    }

    public void moveLeft(int count) {
        col -= count;
    }

    public void moveRight(int count) {
        col += count;
    }

    public TextStateCanvas drawLine(int count) {
        if (count == 0) {
            return this;
        }
        else if (count < 0) {
            throw new IllegalArgumentException("count should be greater than zero: " + count);
        }

        switch (direction) {
            case UP:
                drawVerticalLine(row - count + 1, col, count);
                moveUp(count);
                break;
            case DOWN:
                drawVerticalLine(row, col, count);
                moveDown(count);
                break;
            case LEFT:
                drawHorizontalLine(row, col - count + 1, count);
                moveLeft(count);
                break;
            case RIGHT:
                drawHorizontalLine(row, col, count);
                moveRight(count);
                break;
            default:
                throw new RuntimeException("Unsupported Direction: " + direction);
        }
        return this;
    }

    public TextStateCanvas drawText(String text) {
        drawText(row, col, text);
        col += text.length();
        return this;
    }

    public TextStateCanvas turnUp() {
        direction = TextDirection.UP;
        return this;
    }

    public TextStateCanvas turnDown() {
        direction = TextDirection.DOWN;
        return this;
    }

    public TextStateCanvas turnLeft() {
        direction = TextDirection.LEFT;
        return this;
    }

    public TextStateCanvas turnRight() {
        direction = TextDirection.RIGHT;
        return this;
    }

    public TextStateCanvas switchUp() {
        if (direction == TextDirection.LEFT) {
            mergePixel(row, col, BoxDrawing.LIGHT_UP_AND_RIGHT.val);
        }
        else if (direction == TextDirection.RIGHT) {
            mergePixel(row, col, BoxDrawing.LIGHT_UP_AND_LEFT.val);
        }
        else {
            assert false : "should not be here";
        }

        moveUp(1);
        direction = TextDirection.UP;
        return this;
    }

    public TextStateCanvas switchDown() {
        if (direction == TextDirection.LEFT) {
            mergePixel(row, col, BoxDrawing.LIGHT_DOWN_AND_RIGHT.val);
        }
        else if (direction == TextDirection.RIGHT) {
            mergePixel(row, col, BoxDrawing.LIGHT_DOWN_AND_LEFT.val);
        }
        else {
            assert false : "should not be here";
        }

        moveDown(1);
        direction = TextDirection.DOWN;
        return this;
    }

    public TextStateCanvas switchLeft() {
        if (direction == TextDirection.UP) {
            mergePixel(row, col, BoxDrawing.LIGHT_DOWN_AND_LEFT.val);
        }
        else if (direction == TextDirection.DOWN) {
            mergePixel(row, col, BoxDrawing.LIGHT_UP_AND_LEFT.val);
        }
        else {
            assert false : "should not be here";
        }

        moveLeft(1);
        direction = TextDirection.LEFT;
        return this;
    }

    public TextStateCanvas switchRight() {
        if (direction == TextDirection.UP) {
            mergePixel(row, col, BoxDrawing.LIGHT_DOWN_AND_RIGHT.val);
        }
        else if (direction == TextDirection.DOWN) {
            mergePixel(row, col, BoxDrawing.LIGHT_UP_AND_RIGHT.val);
        }
        else {
            assert false : "should not be here";
        }

        moveRight(1);
        direction = TextDirection.RIGHT;
        return this;
    }

}
