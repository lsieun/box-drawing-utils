package lsieun.drawing.theme.bit;

import lsieun.drawing.canvas.Box;
import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;

import java.util.ArrayList;
import java.util.List;

public class MultiBytes implements Drawable {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String EQUAL = "=";


    public final List<ByteEntry> entryList = new ArrayList<>();

    public void add(ByteEntry item) {
        entryList.add(item);
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        Canvas localCanvas = getLocalCanvas();
        localCanvas.updatePosition(startRow, startCol);

        canvas.overlay(localCanvas);
    }

    private Canvas getLocalCanvas() {
        int row = 0;
        int col = 0;
        Canvas canvas = new Canvas();

        for (ByteEntry entry : entryList) {
            ByteType type = entry.type;
            int length = entry.length;
            String text = entry.text;

            String border = type == ByteType.SINGLE ? MINUS : EQUAL;

            // first line
            canvas.moveTo(row, col);
            canvas.drawPixel(PLUS);
            for (int i = 0; i < length; i++) {
                canvas.right(1);
                canvas.drawPixel(border);
            }

            // second line
            canvas.moveTo(row + 1, col);
            canvas.drawPixel(Box.VERTICAL);
            canvas.right(1);
            canvas.drawText(text);

            // third line
            canvas.moveTo(row + 2, col);
            canvas.drawPixel(PLUS);
            for (int i = 0; i < length; i++) {
                canvas.right(1);
                canvas.drawPixel(border);
            }

            col += length + 1;
        }

        {
            // the last column
            canvas.moveTo(row, col);
            canvas.drawPixel(PLUS);
            canvas.moveTo(row + 1, col);
            canvas.drawPixel(Box.VERTICAL);
            canvas.moveTo(row + 2, col);
            canvas.drawPixel(PLUS);
        }

        return canvas;
    }
}
