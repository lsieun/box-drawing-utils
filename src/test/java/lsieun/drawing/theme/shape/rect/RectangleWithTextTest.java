package lsieun.drawing.theme.shape.rect;

import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.canvas.TextAlign;
import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class RectangleWithTextTest {
    @Test
    void test() {
        List<String> lines = new ArrayList<>();
        lines.add("Bad times make a good man.");
        lines.add("The greatest test of courage on earth is to bear defeat without losing heart.");
        lines.add("Sow nothing, reap nothing.");
        lines.add("Life is but a hard and tortuous journey.");
        Drawable drawable = new RectangleWithText(50, 5, lines, TextAlign.CENTER);
        CanvasUtils.print(3, 10, drawable);
    }
}