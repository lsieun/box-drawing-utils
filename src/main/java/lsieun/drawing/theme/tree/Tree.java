package lsieun.drawing.theme.tree;

import lsieun.drawing.canvas.Box;
import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.canvas.TextDirection;

import java.util.ArrayList;
import java.util.List;

public class Tree implements Drawable {
    private static final int PADDING_SPACE = 1;
    private static final int CONNECTION_LINE_LENGTH = 3;

    public final String line;
    public Tree parent;
    public final List<Tree> children = new ArrayList<>();

    private Tree(String line) {
        this.line = line;
    }

    public void addChild(Tree child) {
        children.add(child);
        child.parent = this;
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        Canvas localCanvas = getLocalCanvas();
        localCanvas.updatePosition(startRow, startCol);

        canvas.overlay(localCanvas);
    }

    private Canvas getLocalCanvas() {
        // 1. get list
        TreeTextGraph graph = TreeTextGraphUtils.createGraphFromTree(this);
        TreeTextGraphUtils.updatePosition(graph);
        List<TreeTextGraph> list = TreeTextGraphUtils.getList(graph);

        // 2. draw text
        Canvas canvas = new Canvas();
        for (TreeTextGraph item : list) {
            canvas.moveTo(item.row, item.col);
            canvas.drawText(item.tree.line);
        }

        // 3. draw connection line
        for (TreeTextGraph item : list) {
            List<TreeTextGraph> children = item.children;
            int size = children.size();
            if (size < 1) continue;

            int startRow = children.get(0).row;
            int midRow = item.row;
            int stopRow = children.get(size - 1).row;

            int startCol = item.col + item.tree.line.length() + PADDING_SPACE;
            int midCol = item.col + item.length + CONNECTION_LINE_LENGTH + PADDING_SPACE;
            int colCount = midCol - startCol;

            canvas.moveTo(midRow, startCol);
            canvas.drawHorizontalLine(colCount).switchDirection(TextDirection.LEFT, TextDirection.UP)
                    .drawVerticalLine((startRow == midRow) ? 0 : (startRow - midRow + 1));

            canvas.moveTo(midRow, startCol);
            canvas.drawHorizontalLine(colCount).switchDirection(TextDirection.LEFT, TextDirection.DOWN)
                    .drawVerticalLine((stopRow == midRow) ? 0 : (stopRow - midRow - 1));

            for (int i = 0; i < size; i++) {
                TreeTextGraph child = children.get(i);
                Box ch;
                if (i == 0) {
                    ch = Box.DOWN_AND_RIGHT;
                }
                else if (i == size - 1) {
                    ch = Box.UP_AND_RIGHT;
                }
                else {
                    ch = Box.VERTICAL_AND_RIGHT;
                }

                canvas.moveTo(child.row, midCol);
                canvas.drawPixel(ch);
                canvas.moveTo(child.row, midCol + 1);
                canvas.drawHorizontalLine(CONNECTION_LINE_LENGTH);
            }
        }

        // 4. print
        return canvas;
    }

    public static Tree of(String line) {
        return new Tree(line);
    }

    public static List<Tree> parseLines(List<String> lines) {
        List<Tree> list = new ArrayList<>();

        Tree currentTree = null;
        for (String line : lines) {
            if (line == null) continue;
            // title
            if (line.startsWith("#")) continue;
            // code segment
            if (line.startsWith("`")) continue;
            // line separator
            if (line.startsWith("---")) continue;
            int index = line.indexOf("-");
            if (index < 0) continue;

            String name = line.substring(index + 1).trim();

            if (index == 0) {
                Tree tree = Tree.of(name);
                list.add(tree);
                currentTree = tree;
            }
            else {
                addItem2Tree(currentTree, index / 4, name);
            }
        }

        return list;
    }

    public static void addItem2Tree(Tree root, int level, String name) {
        Tree tree = root;
        for (int i = 1; i < level; i++) {
            int size = tree.children.size();
            tree = tree.children.get(size - 1);
        }

        Tree newChild = Tree.of(name);
        tree.addChild(newChild);
    }
}
