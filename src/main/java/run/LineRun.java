package run;

import lsieun.canvas.TextCanvas;

import java.util.List;

public class LineRun {
    public static void main(String[] args) {
        // 第一步，创建TextCanvas对象
        TextCanvas canvas = new TextCanvas();

        // 第二步，画线
        canvas.drawHorizontalLine(4, 5, 30);
        canvas.drawVerticalLine(1, 20, 6);

        // 第三步，打印输出
        List<String> lines = canvas.getLines();
        lines.forEach(System.out::println);
    }
}
