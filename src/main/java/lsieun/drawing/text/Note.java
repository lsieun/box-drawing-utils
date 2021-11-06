package lsieun.drawing.text;

import lsieun.canvas.TextDirection;

public class Note {
    public int row;
    public int col;
    public TextDirection direction;
    public int height;
    public String text;

    public Note(int row, int col, TextDirection direction, int height, String text) {
        this.row = row;
        this.col = col;
        this.direction = direction;
        this.height = height;
        this.text = text;
    }

    public static Note valueOf(int row, int col, TextDirection direction, int height, String text) {
        return new Note(row, col, direction, height, text);
    }
}
