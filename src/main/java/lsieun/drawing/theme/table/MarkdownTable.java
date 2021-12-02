package lsieun.drawing.theme.table;

import lsieun.drawing.canvas.Box;
import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;

public class MarkdownTable extends AbstractTable implements Drawable {

    private final String[][] matrix;

    public MarkdownTable(String[][] matrix) {
        this.matrix = matrix;
    }

    @Override
    protected int getCellLength(int row, int col) {
        String item = matrix[row][col];
        return item == null ? 0 : item.length();
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        Canvas localCanvas = getLocalCanvas();
        localCanvas.updatePosition(startRow, startCol);

        canvas.overlay(localCanvas);
    }

    private Canvas getLocalCanvas() {
        int rowCount = matrix.length;
        int colCount = matrix[0].length;

        int[] colWidthArray = getColWidthArray(rowCount, colCount);

        Canvas canvas = new Canvas();

        // draw border
        for (int row = 0; row < rowCount + 1; row++) {
            int currentCol = 0;
            canvas.moveTo(row, currentCol);
            canvas.drawPixel(Box.VERTICAL);
            for (int col = 0; col < colCount; col++) {
                int width = colWidthArray[col];
                if (row == 0) {
                    canvas.right(1 + cell_inner_padding);
                    String cellValue = getCellValue(row, col);
                    canvas.drawText(cellValue);
                    currentCol += width + 1;
                    canvas.moveTo(row, currentCol);
                }
                else if (row == 1) {
                    canvas.right(1);
                    for (int i = 0; i < width; i++) {
                        canvas.drawPixel("-");
                        canvas.right(1);
                    }
                }
                else {
                    canvas.right(1 + cell_inner_padding);
                    String cellValue = getCellValue(row - 1, col);
                    canvas.drawText(cellValue);
                    currentCol += width + 1;
                    canvas.moveTo(row, currentCol);
                }
                canvas.drawPixel(Box.VERTICAL);
            }
        }

        return canvas;
    }

    public String getCellValue(int row, int col) {
        String item = matrix[row][col];
        return item == null ? Box.SPACE.val : item;
    }
}
