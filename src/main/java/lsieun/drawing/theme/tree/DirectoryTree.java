package lsieun.drawing.theme.tree;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.canvas.TextDirection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class DirectoryTree implements Drawable, Comparable<DirectoryTree> {
    private static final int HORIZON_LENGTH = 3;
    private static final int HORIZON_SPACE = 1;

    public int row = -1;
    public int col = -1;
    public int maxRow;
    public final String name;
    public DirectoryTree parent;
    public List<DirectoryTree> children = new ArrayList<>();

    private DirectoryTree(String name) {
        Objects.requireNonNull(name);
        this.name = name;
    }

    public void add(DirectoryTree entry) {
        this.children.add(entry);
        entry.parent = this;
    }

    @Override
    public int compareTo(DirectoryTree another) {
        return this.name.compareTo(another.name);
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        Canvas localCanvas = getLocalCanvas();
        localCanvas.updatePosition(startRow, startCol);

        canvas.overlay(localCanvas);
    }

    private Canvas getLocalCanvas() {
        Canvas canvas = new Canvas();
        drawTree(canvas, this, 0, 0);
        return canvas;
    }

    public void drawTree(Canvas canvas, DirectoryTree tree, int row, int col) {
        // 1. update tree position
        tree.row = row;
        tree.col = col;

        // 2. draw parent line
        DirectoryTree parent = tree.parent;
        if (parent != null) {
            canvas.moveTo(parent.row + 1, parent.col)
                    .drawVerticalLine(tree.row - parent.row - 1)
                    .switchDirection(TextDirection.UP, TextDirection.RIGHT)
                    .drawHorizontalLine(HORIZON_LENGTH);
        }

        // 3. draw tree itself
        canvas.moveTo(row, col);
        canvas.drawText(tree.name);

        // 4. draw tree's children
        List<DirectoryTree> children = tree.children;
        int size = children.size();
        if (size > 0) {
            Collections.sort(children);
            DirectoryTree firstChild = children.get(0);
            drawTree(canvas, firstChild, row + 1, col + HORIZON_LENGTH + HORIZON_SPACE + 1);
        }

        // 5. update tree's max row
        if (size < 1) {
            tree.maxRow = row;
        }
        else {
            tree.maxRow = tree.children.get(size - 1).maxRow;
        }

        // 6. draw tree's brothers
        DirectoryTree brotherTree = getBrother(tree);
        if (brotherTree != null) {
            drawTree(canvas, brotherTree, tree.maxRow + 1, tree.col);
        }
    }

    private DirectoryTree getBrother(DirectoryTree tree) {
        DirectoryTree parent = tree.parent;
        if (parent == null) return null;

        int index = parent.children.indexOf(tree);
        int brotherSize = parent.children.size();
        if (index < brotherSize - 1) {
            return parent.children.get(index + 1);
        }
        return null;
    }

    public static DirectoryTree valueOf(String name) {
        return new DirectoryTree(name);
    }
}
