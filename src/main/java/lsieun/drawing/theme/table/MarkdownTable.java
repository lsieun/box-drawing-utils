package lsieun.drawing.theme.table;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.canvas.TextAlign;

public class MarkdownTable extends MatrixTable implements Drawable {
    private static final String MARKDOWN_BORDER = "|";
    private static final String MARKDOWN_SEPARATOR = "-";

    public final TextAlign align;

    public MarkdownTable(String[][] matrix) {
        this(matrix, TextAlign.LEFT_MIDDLE);
    }

    public MarkdownTable(String[][] matrix, TextAlign align) {
        super(matrix);
        this.align = align;
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        Canvas localCanvas = getLocalCanvas();
        localCanvas.updatePosition(startRow, startCol);

        canvas.overlay(localCanvas);
    }

    private Canvas getLocalCanvas() {
        Canvas canvas = new Canvas();

        int row = 0;
        int col = 0;

        // header
        canvas.moveTo(row, col);
        drawOneRow(canvas, 0);

        // separation line
        canvas.moveTo(++row, col);
        drawSeparationLine(canvas, row);

        // body
        for (int i = 1; i < getTotalRows(); i++) {
            canvas.moveTo(++row, col);
            drawOneRow(canvas, i);
        }

        return canvas;
    }

    private void drawOneRow(Canvas canvas, int matrixRowIndex) {
        canvas.drawPixel(MARKDOWN_BORDER);

        int row = canvas.getRow();

        int currentCol = 0;
        for (int col = 0; col < getTotalCols(); col++) {
            int contentWidth = getCellContentWidth(matrixRowIndex, col);
            int paddingWidth = getCellInnerColPadding(matrixRowIndex, col);
            int borderWidth = getCellBorderWidth(matrixRowIndex, col);

            canvas.right(borderWidth + paddingWidth);
            String cellValue = getCellValue(matrixRowIndex, col);
            canvas.drawText(contentWidth, cellValue, align.hAlign);
            currentCol += 2 * paddingWidth + contentWidth + borderWidth;
            canvas.moveTo(row, currentCol);

            canvas.drawPixel(MARKDOWN_BORDER);
        }
    }

    private void drawSeparationLine(Canvas canvas, int row) {
        canvas.drawPixel(MARKDOWN_BORDER);

        int totalCols = getTotalCols();
        for (int col = 0; col < totalCols; col++) {
            int contentWidth = getCellContentWidth(row, col);
            int paddingWidth = getCellInnerColPadding(row, col);
            int count = 2 * paddingWidth + contentWidth;

            canvas.right(1);
            for (int i = 0; i < count; i++) {
                canvas.drawPixel(MARKDOWN_SEPARATOR);
                canvas.right(1);
            }

            canvas.drawPixel(MARKDOWN_BORDER);
        }
    }
}
