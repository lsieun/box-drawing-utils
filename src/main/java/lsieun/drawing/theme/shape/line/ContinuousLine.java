package lsieun.drawing.theme.shape.line;

import lsieun.drawing.canvas.Box;
import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.canvas.TextDirection;
import lsieun.drawing.theme.shape.AbstractShape;

public class ContinuousLine extends AbstractShape implements Drawable {
    private final Canvas localCanvas = new Canvas();

    private TextDirection direction = TextDirection.RIGHT;

    public void setDirection(TextDirection direction) {
        this.direction = direction;
    }

    public ContinuousLine setStart(String mark) {
        localCanvas.drawPixel(mark);
        move(1);
        return this;
    }

    public ContinuousLine setStop(String mark) {
        localCanvas.drawPixel(mark);
        return this;
    }

    private void move(int step) {
        switch (direction) {
            case UP:
                localCanvas.up(step);
                break;
            case RIGHT:
                localCanvas.right(step);
                break;
            case DOWN:
                localCanvas.down(step);
                break;
            case LEFT:
                localCanvas.left(step);
                break;
            default:
                assert false : "impossible here";
        }
    }

    public ContinuousLine turn(TextDirection direction) {
        if (this.direction == TextDirection.UP && direction == TextDirection.LEFT) {
            localCanvas.drawPixel(Box.DOWN_AND_LEFT);
        }
        else if (this.direction == TextDirection.UP && direction == TextDirection.RIGHT) {
            localCanvas.drawPixel(Box.DOWN_AND_RIGHT);
        }
        else if (this.direction == TextDirection.RIGHT && direction == TextDirection.UP) {
            localCanvas.drawPixel(Box.UP_AND_LEFT);
        }
        else if (this.direction == TextDirection.RIGHT && direction == TextDirection.DOWN) {
            localCanvas.drawPixel(Box.DOWN_AND_LEFT);
        }
        else if (this.direction == TextDirection.DOWN && direction == TextDirection.RIGHT) {
            localCanvas.drawPixel(Box.UP_AND_RIGHT);
        }
        else if (this.direction == TextDirection.DOWN && direction == TextDirection.LEFT) {
            localCanvas.drawPixel(Box.UP_AND_LEFT);
        }
        else if (this.direction == TextDirection.LEFT && direction == TextDirection.DOWN) {
            localCanvas.drawPixel(Box.DOWN_AND_RIGHT);
        }
        else if (this.direction == TextDirection.LEFT && direction == TextDirection.UP) {
            localCanvas.drawPixel(Box.UP_AND_RIGHT);
        }
        else {
            assert false : "impossible here";
        }
        this.direction = direction;
        move(1);
        return this;
    }

    public ContinuousLine drawLine(int count) {
        if (count < 0) {
            throw new IllegalArgumentException("'count' should be greater than zero: " + count);
        }
        if (count == 0) {
            return this;
        }

        switch (direction) {
            case UP:
                localCanvas.drawVerticalLine(-count);
                break;
            case RIGHT:
                localCanvas.drawHorizontalLine(count);
                break;
            case DOWN:
                localCanvas.drawVerticalLine(count);
                break;
            case LEFT:
                localCanvas.drawHorizontalLine(-count);
                break;
            default:
                assert false : "impossible here";
        }
        return this;
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        localCanvas.updatePosition(startRow, startCol);

        canvas.overlay(localCanvas);
    }
}
