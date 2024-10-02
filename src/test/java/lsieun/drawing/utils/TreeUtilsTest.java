package lsieun.drawing.utils;

import lsieun.drawing.canvas.Drawable;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

class TreeUtilsTest {
    @Test
    void testReadTreeFromMarkDown() throws IOException {
        Path path = ResourceUtils.readFilePath("tree.md", true);
        List<String> lines = ResourceUtils.readLines(path);
        List<? extends Drawable> list = TreeUtils.readTree(lines, "Direction");
        if (list.size() == 0) {
            return;
        }

        Drawable drawable = list.get(0);
        CanvasUtils.print(drawable);
    }

    @Test
    void testReadDirectory() throws IOException {
        String dir = System.getProperty("user.dir");
        Path path = Paths.get(dir);
        Drawable drawable = TreeUtils.readDirectory(path, false);
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
    void testReadJavaImports() throws IOException {
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