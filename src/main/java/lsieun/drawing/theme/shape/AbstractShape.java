package lsieun.drawing.theme.shape;

import lsieun.drawing.canvas.Drawable;

public abstract class AbstractShape implements Drawable {
    private int startRow;
    private int startCol;

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int startRow) {
        this.startRow = startRow;
    }

    public int getStartCol() {
        return startCol;
    }

    public void setStartCol(int startCol) {
        this.startCol = startCol;
    }
}
