package lsieun.drawing.theme.text;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;

import java.util.ArrayList;
import java.util.List;

public class PlainTextWithBorder implements Drawable {
    public final int rowPadding;
    public final int colPadding;

    public final List<String> lines = new ArrayList<>();

    public PlainTextWithBorder() {
        this(0, 1);
    }

    public PlainTextWithBorder(int rowPadding, int colPadding) {
        this.rowPadding = rowPadding;
        this.colPadding = colPadding;
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        int size = lines.size();
        int width = 0;
        for (String line : lines) {
            if (line == null) line = "";
            int length = line.length() + 2 * colPadding;
            if (length > width) {
                width = length;
            }
        }
        int height = size + 2 * rowPadding;
        canvas.moveTo(startRow, startCol).drawRectangle(width, height);


        for (int i = 0; i < size; i++) {
            String line = lines.get(i);
            if (line == null) line = "";
            canvas.moveTo(startRow + i + 1 + rowPadding, startCol + 1 + colPadding)
                    .drawText(line);
        }
    }

    public static PlainTextWithBorder valueOf(String line) {
        PlainTextWithBorder text = new PlainTextWithBorder();
        text.lines.add(line);
        return text;
    }

    public static PlainTextWithBorder valueOf(List<String> lines) {
        PlainTextWithBorder text = new PlainTextWithBorder();
        text.lines.addAll(lines);
        return text;
    }
}
