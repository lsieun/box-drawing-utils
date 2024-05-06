package lsieun.drawing.theme.table;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.TextAlign;
import lsieun.drawing.theme.shape.rect.FullRectangle;

public class OneLineTable extends MatrixTable {
    public final TextAlign align;

    public OneLineTable(String[][] matrix) {
        this(matrix, TextAlign.CENTER, 0, 1);
    }

    public OneLineTable(String[][] matrix, TextAlign align) {
        this(matrix, align, 0, 1);
    }

    public OneLineTable(String[][] matrix, TextAlign align, int cellInnerRowPadding, int cellInnerColPadding) {
        super(matrix, cellInnerRowPadding, cellInnerColPadding);
        this.align = align;
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {

        // text - rect
        int totalRows = getTotalRows();
        int totalCols = getTotalCols();
        FullRectangle[][] rectMatrix = new FullRectangle[totalRows][totalCols];
        for(int i = 0; i < totalRows; i++) {
            for(int j = 0; j < totalCols; j++) {
                int contentWidth = getCellContentWidth(i, j);
                String cellValue = getCellValue(i, j);
                FullRectangle rect = new FullRectangle(contentWidth, cellInnerColPadding, cellInnerRowPadding,cellValue, align);
                rectMatrix[i][j] = rect;
            }
        }

        // draw rect
        canvas.moveTo(startRow, startCol);
        int row = startRow;

        for(int i = 0; i < totalRows; i++) {
            int col = startCol;
            for(int j = 0; j < totalCols; j++) {
                FullRectangle rect = rectMatrix[i][j];
                canvas.draw(row, col, rect);
                col += rect.getWidth() - getCellBorderWidth(i, j);
            }
            row += rectMatrix[i][0].getHeight() - getCellBorderWidth(i, 0);
        }
    }
}
