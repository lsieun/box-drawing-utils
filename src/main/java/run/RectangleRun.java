package run;

import lsieun.canvas.TextCanvas;

import java.util.List;

public class RectangleRun {
    public static void main(String[] args) {
        // 第一步，创建TextCanvas对象
        TextCanvas canvas = new TextCanvas();

        // 第二步，画矩形框
        canvas.drawRectangle(2, 10, 5, 20);

        // 第三步，打印输出
        List<String> lines = canvas.getLines();
        lines.forEach(System.out::println);
    }
}
