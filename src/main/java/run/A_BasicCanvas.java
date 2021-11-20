package run;

import lsieun.drawing.canvas.Canvas;

public class A_BasicCanvas {
    public static void main(String[] args) {
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
}
