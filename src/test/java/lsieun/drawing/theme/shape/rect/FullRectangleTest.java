package lsieun.drawing.theme.shape.rect;

import lsieun.drawing.canvas.*;
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
        List<String> lines = new ArrayList<>();
        Drawable drawable = new FullRectangle(5, 0, 0, 0, lines, TextAlign.LEFT, VerticalAlign.TOP);
        CanvasUtils.print(drawable);
    }

    @Test
    @Order(2)
    void testOneLineRectangle() {
        List<String> lines = new ArrayList<>();
        lines.add("Hello World");
        Drawable drawable = new FullRectangle(0, 0, 0, 0, lines, TextAlign.LEFT, VerticalAlign.TOP);
        CanvasUtils.print(drawable);
    }


    @Test
    @Order(3)
    void testAlignLeft() {
        for (VerticalAlign vAlign : VerticalAlign.values()) {
            testAlign(TextAlign.LEFT, vAlign);
        }
    }

    @Test
    @Order(4)
    void testAlignCenter() {
        for (VerticalAlign vAlign : VerticalAlign.values()) {
            testAlign(TextAlign.CENTER, vAlign);
        }
    }

    @Test
    @Order(5)
    void testAlignRight() {
        for (VerticalAlign vAlign : VerticalAlign.values()) {
            testAlign(TextAlign.RIGHT, vAlign);
        }
    }

    private void testAlign(TextAlign align, VerticalAlign vAlign) {
        String str = String.format("%s + %s", align, vAlign);
        System.out.println(str);

        List<String> lines = new ArrayList<>();
        lines.add("Bad times make a good man.");
        lines.add("The greatest test of courage on earth is to bear defeat without losing heart.");
        lines.add("Sow nothing, reap nothing.");
        lines.add("Life is but a hard and tortuous journey.");
        Drawable drawable = new FullRectangle(0, 10, 0, 0, lines, align, vAlign);
        CanvasUtils.print(drawable);
    }

    @Test
    @Order(6)
    void testDrawFourDirection() {
        List<String> lines = Collections.emptyList();

        FullRectangle rect = new FullRectangle(20, 4, 0, 0, lines, TextAlign.LEFT, VerticalAlign.TOP);
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
