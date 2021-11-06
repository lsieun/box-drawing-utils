package lsieun.drawing.text;

import lsieun.canvas.Drawable;
import lsieun.canvas.TextDirection;
import lsieun.canvas.TextStateCanvas;

import java.util.ArrayList;
import java.util.List;

public class TextWithNote implements Drawable {
    public int row;
    public int col;
    public List<String> lines;
    public final List<Note> noteList = new ArrayList<>();

    public TextWithNote(List<String> lines) {
        this.row = 0;
        this.col = 0;
        this.lines = lines;
    }

    public void addNote(int row, int col, TextDirection direction, int height, String text) {
        if (direction != TextDirection.UP && direction != TextDirection.DOWN) {
            throw new IllegalArgumentException("direction is not correct: " + direction);
        }
        noteList.add(Note.valueOf(row, col, direction, height, text));
    }

    @Override
    public void draw() {
        updateRow();

        TextStateCanvas canvas = new TextStateCanvas();
        canvas.drawMultiLineText(row, col, lines);

        for (Note note : noteList) {
            int currentRow = this.row + note.row;
            int currentCol = this.col + note.col;
            if (note.direction == TextDirection.UP) {
                canvas.moveTo(currentRow - 1, currentCol);
                canvas.turnUp().drawLine(note.height).switchRight().drawLine(3);
                canvas.moveRight(1);
                canvas.drawText(note.text);
            }
            else if (note.direction == TextDirection.DOWN) {
                canvas.moveTo(currentRow + 1, currentCol);
                canvas.turnDown().drawLine(note.height).switchRight().drawLine(3);
                canvas.moveRight(1);
                canvas.drawText(note.text);
            }
            else {
                assert false : "impossible";
            }
        }

        String result = list2str(canvas.getLines());
        System.out.println(result);
    }

    private void updateRow() {
        for (Note note : noteList) {
            if (note.direction == TextDirection.UP) {
                int deltaRow = note.height + 1;
                if (deltaRow > this.row) {
                    this.row = deltaRow;
                }
            }
        }
    }
}
