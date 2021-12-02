package lsieun.drawing.theme.tree;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.canvas.TextDirection;
import lsieun.drawing.unicode.*;

import java.util.ArrayList;
import java.util.Formatter;
import java.util.List;
import java.util.Objects;

public class BinaryTree implements Drawable {
    private static final int COL_SPACE = 5;

    private static final String NO_CHILD = GeometricShapes.WHITE_SQUARE.value;
    private static final String ONE_LEFT_CHILD = GeometricShapes.SQUARE_WITH_UPPER_RIGHT_TO_LOWER_LEFT_FILL.value;
    private static final String ONE_RIGHT_CHILD = GeometricShapes.SQUARE_WITH_UPPER_LEFT_TO_LOWER_RIGHT_FILL.value;
    private static final String TWO_CHILD = GeometricShapes.BLACK_SQUARE.value;


    public int row = -1;
    public int col = -1;
    public int maxCol;
    public String name;
    public BinaryTree parent;
    public BinaryTree leftChild;
    public BinaryTree rightChild;

    protected BinaryTree(String name) {
        this.name = name;
    }

    public void addLeftChild(BinaryTree child) {
        this.leftChild = child;
        child.parent = this;
    }

    public void addRightChild(BinaryTree child) {
        this.rightChild = child;
        child.parent = this;
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        Canvas localCanvas = getLocalCanvas();
        localCanvas.updatePosition(startRow, startCol);

        canvas.overlay(localCanvas);
    }

    private Canvas getLocalCanvas() {
        update(this);

        Canvas canvas = new Canvas();
        drawBinaryTree(canvas, this);
        canvas.rectifyPosition();
        return canvas;
    }

    private void drawBinaryTree(Canvas canvas, BinaryTree tree) {
        Objects.requireNonNull(tree);

        // 1. tree itself
        canvas.moveTo(tree.row, tree.col);
        if (hasBothChild(tree)) {
            canvas.drawPixel(TWO_CHILD);
        }
        else if (hasLeftChild(tree)) {
            canvas.drawPixel(ONE_LEFT_CHILD);
        }
        else if (hasRightChild(tree)) {
            canvas.drawPixel(ONE_RIGHT_CHILD);
        }
        else {
            canvas.drawPixel(NO_CHILD);
            canvas.moveTo(tree.row + 1, tree.col);
            canvas.drawText(tree.name);
        }

        // 2. parent line
        if (hasParent(tree)) {
            BinaryTree parent = tree.parent;

            if (tree == parent.leftChild) {
                canvas.moveTo(tree.row - 1, tree.col);
                canvas.switchDirection(TextDirection.DOWN, TextDirection.RIGHT);
                canvas.drawHorizontalLine(parent.col - tree.col - 1);
                canvas.switchDirection(TextDirection.LEFT, TextDirection.UP);

                canvas.moveTo(tree.row - 1, tree.col - 2);
                canvas.drawPixel("0");
            }

            if (tree == parent.rightChild) {
                canvas.moveTo(parent.row + 1, parent.col);
                canvas.switchDirection(TextDirection.UP, TextDirection.RIGHT);
                canvas.drawHorizontalLine(tree.col - parent.col - 1);
                canvas.switchDirection(TextDirection.LEFT, TextDirection.DOWN);

                canvas.moveTo(tree.row - 1, tree.col + 2);
                canvas.drawPixel("1");
            }
        }

        // 3. left child
        if (hasLeftChild(tree)) {
            BinaryTree leftChild = tree.leftChild;
            drawBinaryTree(canvas, leftChild);
        }

        // 4. right child
        if (hasRightChild(tree)) {
            BinaryTree rightChild = tree.rightChild;
            drawBinaryTree(canvas, rightChild);
        }
    }

    @Override
    public String toString() {
        update(this);
        List<BinaryTree> list = new ArrayList<>();
        list.add(this);

        for (int i = 0; i < list.size(); i++) {
            BinaryTree tree = list.get(i);
            if (hasLeftChild(tree)) {
                list.add(tree.leftChild);
            }
            if (hasRightChild(tree)) {
                list.add(tree.rightChild);
            }
        }

        System.out.println("tree size: " + list.size());
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        for (BinaryTree item : list) {
            fm.format("%s: (%d, %d) - %d%n", item.name, item.row, item.col, item.maxCol);
        }

        return sb.toString();
    }

    // region private static methods
    private static boolean hasParent(BinaryTree tree) {
        return tree.parent != null;
    }

    private static boolean hasLeftChild(BinaryTree tree) {
        return tree.leftChild != null;
    }

    private static boolean hasRightChild(BinaryTree tree) {
        return tree.rightChild != null;
    }

    private static boolean hasBothChild(BinaryTree tree) {
        return (tree.leftChild != null) && (tree.rightChild != null);
    }

    private static boolean hasNoChild(BinaryTree tree) {
        return (tree.leftChild == null) && (tree.rightChild == null);
    }

    private static void update(BinaryTree tree) {
        updateTreeRow(tree, 0);
        updateTreeCol(tree, 0);
    }

    private static void updateTreeRow(BinaryTree tree, int row) {
        if (tree == null) return;

        // tree itself
        tree.row = row;

        // left child
        if (hasLeftChild(tree)) {
            BinaryTree leftChild = tree.leftChild;
            updateTreeRow(leftChild, row + 2);
        }

        // right child
        if (hasRightChild(tree)) {
            BinaryTree rightChild = tree.rightChild;
            updateTreeRow(rightChild, row + 2);
        }
    }

    private static void updateTreeCol(BinaryTree tree, int col) {
        if (tree == null) return;
        // no child
        if (hasNoChild(tree)) {
            tree.col = col;
            tree.maxCol = col;
            return;
        }

        // left child
        if (hasLeftChild(tree)) {
            BinaryTree leftChild = tree.leftChild;
            updateTreeCol(leftChild, col);
        }

        // tree itself: col
        if (hasLeftChild(tree)) {
            BinaryTree leftChild = tree.leftChild;
            tree.col = leftChild.maxCol + COL_SPACE;
        }
        else {
            tree.col = col;
        }

        // right child
        if (hasRightChild(tree)) {
            BinaryTree rightChild = tree.rightChild;
            updateTreeCol(rightChild, tree.col + COL_SPACE);
        }

        // tree itself: max col
        if (hasRightChild(tree)) {
            tree.maxCol = tree.rightChild.maxCol;
        }
        else {
            tree.maxCol = tree.col;
        }
    }
    // endregion

    // region public static method
    public static BinaryTree valueOf(String name) {
        return new BinaryTree(name);
    }

    public static void addChild(BinaryTree tree, String binaryStr, String name) {
        int length = binaryStr.length();
        BinaryTree target = tree;
        for (int i = 0; i < length; i++) {
            char ch = binaryStr.charAt(i);
            if (ch == '0') {
                if (target.leftChild == null) {
                    BinaryTree child = BinaryTree.valueOf("");
                    target.addLeftChild(child);
                }
                target = target.leftChild;
            }
            else {
                if (target.rightChild == null) {
                    BinaryTree child = BinaryTree.valueOf("");
                    target.addRightChild(child);
                }
                target = target.rightChild;
            }
        }
        target.name = name;
    }
    // endregion
}
