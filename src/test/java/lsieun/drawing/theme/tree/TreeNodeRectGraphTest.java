package lsieun.drawing.theme.tree;

import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.utils.CanvasUtils;
import lsieun.drawing.utils.io.resource.ResourceUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

class TreeNodeRectGraphTest {
    @Test
    void testReadTreeFromMarkDown() throws IOException {
        Path path = ResourceUtils.readFilePath("tree.md", true);
        List<String> lines = ResourceUtils.readLines(path);
        List<TreeNodeText> list = TreeNodeText.parseLines(lines);
        TreeNodeText node = list.get(0);

        for(GraphDirection direction : GraphDirection.values()) {
            System.out.println("direction = " + direction);
            Drawable drawable = TreeNodeRectGraph.of(node, direction);
            CanvasUtils.print(drawable);
        }

    }
}