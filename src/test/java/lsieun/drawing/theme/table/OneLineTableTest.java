package lsieun.drawing.theme.table;

import lsieun.drawing.canvas.TextAlign;
import lsieun.drawing.utils.CanvasUtils;
import lsieun.drawing.utils.MatrixUtils;
import org.junit.jupiter.api.Test;

class OneLineTableTest {
    @Test
    void test() {
        String[][] matrix = MatrixUtils.readMatrixFromClasspath("table.md", "Common", ",");

        for(TextAlign align : TextAlign.values()) {
            OneLineTable table = new OneLineTable(matrix, align);
            CanvasUtils.print(table);
        }
    }
}