package run;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.utils.FileUtils;
import run.sample.*;

import java.util.List;

public class B_Drawable {
    public static void main(String[] args) {
        // 1. graph
        Drawable graph = Sample.getContinuousLine1();

        // 2. draw
        Canvas canvas = new Canvas();
        canvas.draw(3, 10, graph);

        // 3. print
        canvas.printPixels();
        System.out.println(canvas);

        // 4. output
        List<String> lines = canvas.getLines();
        String filepath = PathManager.getOutputPath();
        FileUtils.writeLines(filepath, lines);
        String message = String.format("file:///%s", filepath);
        System.out.println(message);
    }
}
