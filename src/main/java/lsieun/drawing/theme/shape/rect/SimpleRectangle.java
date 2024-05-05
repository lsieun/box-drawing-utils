package lsieun.drawing.theme.shape.rect;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;

public class SimpleRectangle implements Drawable {
    public final int width;
    public final int height;

    public SimpleRectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @SuppressWarnings({"Duplicates"})
    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        canvas.moveTo(startRow, startCol);
        canvas.drawRectangle(width, height);
    }
}
