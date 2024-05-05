package lsieun.drawing.theme.shape.line;

import lsieun.drawing.canvas.TextDirection;
import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

class ContinuousLineTest {
    @Test
    void test1() {
        ContinuousLine line = new ContinuousLine();
        line.setDirection(TextDirection.UP);
        line.drawLine(3)
                .turn(TextDirection.RIGHT).drawLine(10)
                .turn(TextDirection.DOWN).drawLine(5)
                .turn(TextDirection.LEFT).drawLine(20)
                .turn(TextDirection.UP).drawLine(7)
                .turn(TextDirection.RIGHT).drawLine(30);

        CanvasUtils.print(line);
    }

    @Test
    void test2() {
        ContinuousLine line = new ContinuousLine();
        line.setDirection(TextDirection.UP);
        line.drawLine(3)
                .turn(TextDirection.LEFT).drawLine(10)
                .turn(TextDirection.DOWN).drawLine(5)
                .turn(TextDirection.RIGHT).drawLine(20)
                .turn(TextDirection.UP).drawLine(7)
                .turn(TextDirection.LEFT).drawLine(30);
        CanvasUtils.print(line);
    }
}