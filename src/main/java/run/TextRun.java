package run;

import lsieun.box.drawing.TextCanvas;

import java.util.ArrayList;
import java.util.List;

public class TextRun {
    public static void main(String[] args) {
        // 第一步，创建TextCanvas对象
        TextCanvas canvas = new TextCanvas();

        // 第二步，文本信息

        // 单选文本
        canvas.drawText(2, 0, "You know some birds are not meant to be caged, their feathers are just too bright.");

        // 多行文本
        List<String> textList = new ArrayList<>();
        textList.add("I love three things in the world: the sun, the moon, and you.");
        textList.add("The sun for the day, the moon for the night, and you forever.");
        canvas.drawMultiLineText(4, 5, textList);

        // 多行文本+边框
        canvas.drawMultiLineTextWithBorder(7, 10, textList);

        // 第三步，打印输出
        List<String> lines = canvas.getLines();
        lines.forEach(System.out::println);
    }
}
