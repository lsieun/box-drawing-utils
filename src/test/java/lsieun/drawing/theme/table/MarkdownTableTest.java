package lsieun.drawing.theme.table;

import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

class MarkdownTableTest {
    @Test
    void test() {
        String[][] matrix = {
                {"Year", "Algorithm", "Bit Length"},
                {"1992", "MD5", "128"},
                {"1993", "SHA1", "160"},
                {"2001", "SHA256", "256"},
                {"2001", "SHA384", "384"},
                {"2001", "SHA512", "512"},
        };
        Drawable drawable = new MarkdownTable(matrix);
        CanvasUtils.print(drawable);
    }

}