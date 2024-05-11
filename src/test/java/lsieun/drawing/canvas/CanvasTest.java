package lsieun.drawing.canvas;

import org.junit.jupiter.api.Test;

class CanvasTest {
    @Test
    void test() {
        // 1. create Canvas
        Canvas canvas = new Canvas();

        // 2. move to a certain position, and draw something
        // (1) draw point
        canvas.moveTo(0, 3).drawPixel("@");
        canvas.moveTo(1, 6).drawPixel("#");
        canvas.moveTo(2, 9).drawPixel("$");

        // (2) draw line
        canvas.moveTo(3, 3).drawHorizontalLine(20);
        canvas.moveTo(4, 10).drawVerticalLine(-5);
        canvas.moveTo(4, 11).drawText("hello world");

        // (3) draw polygon
        canvas.moveTo(5, 2).drawRectangle(20, 3);

        // 3. print
        canvas.printPixels();
        System.out.println(canvas);
    }

    @Test
    void testDrawTextAlign() {
        Canvas canvas = new Canvas();
        canvas.moveTo(2, 30);
        canvas.drawRectangle(11, 5);

        canvas.moveTo(3, 31);
        canvas.drawText(11, "AAAAA", HorizontalAlign.LEFT);

        canvas.moveTo(4, 31);
        canvas.drawText(11, "BBBBB", HorizontalAlign.RIGHT);

        canvas.moveTo(5, 31);
        canvas.drawText(11, "CCCCC", HorizontalAlign.CENTER);

        canvas.moveTo(6, 31);
        canvas.drawText(11, "DDDDDD", HorizontalAlign.CENTER);

        canvas.moveTo(7, 31);
        canvas.drawText(11, "ABCDEFGHIJKLMNOPQRSTUVWXYZ", HorizontalAlign.CENTER);

        System.out.println(canvas);
    }
}