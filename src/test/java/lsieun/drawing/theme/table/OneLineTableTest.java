package lsieun.drawing.theme.table;

import lsieun.drawing.canvas.TextAlign;
import lsieun.drawing.utils.CanvasUtils;
import lsieun.drawing.utils.MatrixUtils;
import lsieun.drawing.utils.io.resource.ResourceUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

class OneLineTableTest {
    @Test
    void test() throws IOException {
        Path path = ResourceUtils.readFilePath("table.md", true);
        String[][] matrix = MatrixUtils.readMatrix(path, "Common", ",");

        for(TextAlign align : TextAlign.values()) {
            OneLineTable table = new OneLineTable(matrix, align);
            CanvasUtils.print(table);
        }
    }
}