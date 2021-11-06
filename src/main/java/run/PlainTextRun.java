package run;

import lsieun.drawing.text.PlainText;

import java.util.ArrayList;
import java.util.List;

public class PlainTextRun {
    public static void main(String[] args) {
        List<String> textList = new ArrayList<>();
        textList.add("I love three things in the world: the sun, the moon, and you.");
        textList.add("The sun for the day, the moon for the night, and you forever.");

        PlainText text = PlainText.valueOf(3, 10, textList);
        text.draw();
    }
}
