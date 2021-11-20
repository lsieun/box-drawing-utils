package lsieun.drawing.theme.text;

import lsieun.drawing.canvas.TextDirection;

public class Note {
    public int row;
    public int col;
    public int range;
    public TextDirection direction;
    public int height;
    public String text;

    public Note(int row, int col, TextDirection direction, int height, String text) {
        this(row, col, 0, direction, height, text);
    }

    public Note(int row, int col, int range, TextDirection direction, int height, String text) {
        this.row = row;
        this.col = col;
        this.range = range;
        this.direction = direction;
        this.height = height;
        this.text = text;
    }

    public static Note valueOf(int row, int col, TextDirection direction, int height, String text) {
        return new Note(row, col, direction, height, text);
    }

    public static Note valueOf(int row, int col, int range, TextDirection direction, int height, String text) {
        return new Note(row, col, range, direction, height, text);
    }
}
