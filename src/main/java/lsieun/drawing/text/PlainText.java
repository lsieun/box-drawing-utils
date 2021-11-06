package lsieun.drawing.text;

import lsieun.canvas.Drawable;
import lsieun.canvas.TextStateCanvas;

import java.util.List;

public class PlainText implements Drawable {
    public int row;
    public int col;
    public final List<String> lines;

    private PlainText(List<String> lines) {
        this(0, 0, lines);
    }

    public PlainText(int row, int col, List<String> lines) {
        this.row = row;
        this.col = col;
        this.lines = lines;
    }

    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public void draw() {
        TextStateCanvas canvas = new TextStateCanvas();
        canvas.drawMultiLineText(row, col, lines);

        List<String> lines = canvas.getLines();
        lines.forEach(System.out::println);
    }

    public static PlainText valueOf(List<String> lines) {
        return new PlainText(lines);
    }

    public static PlainText valueOf(int row, int col, List<String> lines) {
        return new PlainText(row, col, lines);
    }
}
