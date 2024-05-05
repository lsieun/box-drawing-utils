package lsieun.drawing.theme.tree;

import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.utils.CanvasUtils;
import lsieun.drawing.utils.FileUtils;
import org.junit.jupiter.api.Test;

import java.util.List;

class TreeNodeRectGraphTest {
    @Test
    void testReadTreeFromMarkDown() {
        List<String> lines = FileUtils.readLinesFromClasspath("tree.md");
        List<TreeNodeText> list = TreeNodeText.parseLines(lines);
        TreeNodeText node = list.get(0);

        for(GraphDirection direction : GraphDirection.values()) {
            System.out.println("direction = " + direction);
            Drawable drawable = TreeNodeRectGraph.of(node, direction);
            CanvasUtils.print(drawable);
        }

    }
}