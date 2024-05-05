package lsieun.drawing.theme.shape.rect;

import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

class SimpleRectangleTest {
    @Test
    void test() {
        SimpleRectangle rectangle = new SimpleRectangle(10, 3);
        CanvasUtils.print(rectangle);
    }
}