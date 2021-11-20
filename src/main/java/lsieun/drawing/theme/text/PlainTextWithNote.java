package lsieun.drawing.theme.text;

import lsieun.drawing.canvas.BoxDrawing;
import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.canvas.TextDirection;

import java.util.ArrayList;
import java.util.List;

public class PlainTextWithNote implements Drawable {
    public List<String> lines;
    public final List<Note> noteList = new ArrayList<>();

    public PlainTextWithNote(List<String> lines) {
        this.lines = lines;
    }

    public void addNote(int row, int col, TextDirection direction, int height, String text) {
        addNote(row, col, 0, direction, height, text);
    }

    public void addNote(int row, int col, int range, TextDirection direction, int height, String text) {
        if (direction != TextDirection.UP && direction != TextDirection.DOWN) {
            throw new IllegalArgumentException("direction is not correct: " + direction);
        }
        noteList.add(Note.valueOf(row, col, range, direction, height, text));
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        Canvas localCanvas = getLocalCanvas();
        localCanvas.updatePosition(startRow, startCol);
        localCanvas.rectifyPosition();

        canvas.overlay(localCanvas);
    }

    public Canvas getLocalCanvas() {
        Canvas canvas = new Canvas();

        int size = lines.size();
        for (int i = 0; i < size; i++) {
            String line = lines.get(i);
            if (line == null) line = "";
            canvas.moveTo(i, 0).drawText(line);
        }

        for (Note note : noteList) {
            int currentRow = note.row;
            int currentCol = note.col;
            if (note.direction == TextDirection.UP) {
                if (note.range <= 2) {
                    canvas.moveTo(currentRow - 1, currentCol);
                    canvas.drawVerticalLine(-note.height).switchDirection(TextDirection.DOWN, TextDirection.RIGHT).drawHorizontalLine(3);
                    canvas.right(1).drawText(note.text);
                }
                else {
                    canvas.moveTo(currentRow - 1, currentCol);
                    canvas.drawPixel(BoxDrawing.LIGHT_DOWN_AND_RIGHT);
                    canvas.right(1).drawHorizontalLine(note.range - 2).drawPixel(BoxDrawing.LIGHT_DOWN_AND_LEFT);
                    canvas.moveTo(currentRow - 1, currentCol + note.range / 2).drawPixel(BoxDrawing.LIGHT_UP_AND_HORIZONTAL);
                    canvas.moveTo(currentRow - 2, currentCol + note.range / 2).switchDirection(TextDirection.DOWN, TextDirection.RIGHT).drawHorizontalLine(3);
                    canvas.right(1);
                    canvas.drawText(note.text);
                }
            }
            else if (note.direction == TextDirection.DOWN) {
                if (note.range <= 2) {
                    canvas.moveTo(currentRow + 1, currentCol);
                    canvas.drawVerticalLine(note.height).switchDirection(TextDirection.UP, TextDirection.RIGHT).drawHorizontalLine(3);
                    canvas.right(1);
                    canvas.drawText(note.text);
                }
                else {
                    canvas.moveTo(currentRow + 1, currentCol);
                    canvas.drawPixel(BoxDrawing.LIGHT_UP_AND_RIGHT.val);
                    canvas.right(1).drawHorizontalLine(note.range - 2).drawPixel(BoxDrawing.LIGHT_UP_AND_LEFT);
                    canvas.moveTo(currentRow + 1, currentCol + note.range / 2).drawPixel(BoxDrawing.LIGHT_DOWN_AND_HORIZONTAL);
                    canvas.moveTo(currentRow + 2, currentCol + note.range / 2).switchDirection(TextDirection.UP, TextDirection.RIGHT).drawHorizontalLine(3);
                    canvas.right(1);
                    canvas.drawText(note.text);
                }
            }
            else {
                assert false : "impossible";
            }
        }

        canvas.rectifyPosition();
        return canvas;
    }


}
