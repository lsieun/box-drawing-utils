package lsieun.drawing.utils;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;

public class CanvasUtils {
    // region print
    public static void print(Drawable drawable) {
        Canvas canvas = new Canvas();
        canvas.draw(0, 0, drawable);
        canvas.rectifyPosition();
        String str = canvas.toString();
        System.out.println(str);
    }

    public static void print(int startRow, int startCol, Drawable drawable) {
        Canvas canvas = new Canvas();
        canvas.draw(startRow, startCol, drawable);
        canvas.rectifyPosition();
        String str = canvas.toString();
        System.out.println(str);
    }
    // endregion
}
