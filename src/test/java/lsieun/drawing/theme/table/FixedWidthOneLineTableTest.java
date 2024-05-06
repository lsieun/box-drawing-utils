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

        for(TextAlign align : TextAlign.values()) {
            System.out.println("Text Align: " + align);
            Drawable drawable = new FixedWidthOneLineTable(matrix, align, 10);
            CanvasUtils.print(drawable);
        }
    }
}