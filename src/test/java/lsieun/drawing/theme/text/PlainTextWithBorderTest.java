package lsieun.drawing.theme.text;

import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PlainTextWithBorderTest {
    @Test
    void testPlainTextWithBorder() {
        List<String> textList = new ArrayList<>();
        textList.add("I love three things in the world: the sun, the moon, and you.");
        textList.add("The sun for the day, the moon for the night, and you forever.");

        Drawable drawable = PlainTextWithBorder.valueOf(textList);
        CanvasUtils.print(drawable);
    }
}