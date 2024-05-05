package lsieun.drawing.theme.table;

import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.canvas.TextAlign;
import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

class FixedWidthOneLineTableTest {
    @Test
    void test() {
        String[][] matrix = {
                {"A", "B", "C"},
                {"D", "E", "F"},
        };

        Drawable drawable = new FixedWidthOneLineTable(matrix, TextAlign.LEFT, 10);

        CanvasUtils.print(drawable);
    }
}