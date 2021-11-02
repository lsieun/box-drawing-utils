package run;

import lsieun.box.drawing.TextCanvas;

import java.util.List;

public class PixelRun {
    public static void main(String[] args) {
        // 第一步，创建TextCanvas对象
        TextCanvas canvas = new TextCanvas();

        // 画线
        canvas.drawHorizontalLine(4, 5, 30);
        canvas.drawVerticalLine(1, 20, 6);

        // 画矩形框
        canvas.drawRectangle(2, 10, 5, 20);

        canvas.printPixels();
        List<String> lines = canvas.getLines();
        lines.forEach(System.out::println);
    }
}
