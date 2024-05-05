package lsieun.drawing.utils;

import lsieun.drawing.canvas.Drawable;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

class TreeUtilsTest {
    @Test
    void testReadTreeFromMarkDown() {
        List<String> lines = FileUtils.readLinesFromClasspath("tree.md");
        List<? extends Drawable> list = TreeUtils.readTreeFromMarkdown(lines, "Direction");
        if (list.size() == 0) {
            return;
        }

        Drawable drawable = list.get(0);
        CanvasUtils.print(drawable);
    }

    @Test
    void testReadDirectory() {
        String dir = System.getProperty("user.dir");
        Drawable drawable = TreeUtils.readDirectory(dir, false);
        CanvasUtils.print(drawable);
    }

    @Test
    void testReadJar() {
        String dir = System.getProperty("user.dir");
        String filepath = dir + File.separator + "target" + File.separator + "box-drawing-utils-1.0-SNAPSHOT.jar";
        File f = new File(filepath);
        if (!f.exists()) {
            System.out.println("File not found: " + filepath);
            return;
        }

        Drawable drawable = TreeUtils.readJarFile(f.getAbsolutePath());
        CanvasUtils.print(drawable);
    }

    @Test
    void testReadJavaImports() {
        String dir = System.getProperty("user.dir");
        String filepath = dir + File.separator + "src/main/java/lsieun/drawing/utils/TreeUtils.java";
        File f = new File(filepath);
        if (!f.exists()) {
            System.out.println("File not found: " + filepath);
            return;
        }

        List<? extends Drawable> list = TreeUtils.readJavaFileImports(f.getAbsolutePath(), "java");
        for (Drawable drawable : list) {
            CanvasUtils.print(drawable);
        }
    }

}