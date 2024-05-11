package lsieun.drawing.theme.shape.rect;

import lsieun.drawing.canvas.Box;
import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.canvas.TextAlign;
import lsieun.drawing.theme.text.EmptyText;
import lsieun.drawing.theme.text.Text;
import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FullRectangleTest {
    @Test
    @Order(1)
    void testEmptyRectangle() {
        Drawable drawable = FullRectangle.of(
                5, 0, 0, 0,
                EmptyText.INSTANCE,
                TextAlign.CENTER_MIDDLE,
                false
        );
        CanvasUtils.print(drawable);
    }

    @Test
    @Order(2)
    void testRectangleWithText() {
        List<String> lines = new ArrayList<>();
        lines.add("Hello World");
        lines.add("Hello World");
        Text text = Text.of(lines);
        Drawable drawable = FullRectangle.of(
                0, 0, 0, 0,
                text,
                TextAlign.LEFT_TOP,
                false
        );
        CanvasUtils.print(drawable);
    }


    @Test
    @Order(3)
    void testAllAlign() {
        for (TextAlign align : TextAlign.values()) {
            testAlign(align);
        }
    }


    private void testAlign(TextAlign align) {
        System.out.println(align);

        List<String> lines = new ArrayList<>();
        lines.add("Bad times make a good man.");
        lines.add("The greatest test of courage on earth is to bear defeat without losing heart.");
        lines.add("Sow nothing, reap nothing.");
        lines.add("Life is but a hard and tortuous journey.");
        Drawable drawable = FullRectangle.of(0, 10, 0, 0, lines, align, false);
        CanvasUtils.print(drawable);
    }

    @Test
    @Order(4)
    void testDrawFourDirection() {
        List<String> lines = Collections.emptyList();

        FullRectangle rect = FullRectangle.of(20, 5, 0, 0, lines, TextAlign.LEFT_TOP, false);
        Canvas canvas = new Canvas();
        canvas.draw(3, 20, rect);

        canvas.moveTo(rect.getTop(), rect.getCenterCol());
        canvas.drawPixel(Box.VERTICAL);

        canvas.moveTo(rect.getBottom(), rect.getCenterCol());
        canvas.drawPixel(Box.VERTICAL);

        canvas.moveTo(rect.getCenterRow(), rect.getLeft());
        canvas.drawPixel(Box.HORIZONTAL);

        canvas.moveTo(rect.getCenterRow(), rect.getRight());
        canvas.drawPixel(Box.HORIZONTAL);

        canvas.rectifyPosition();

        System.out.println(canvas);
    }
}
