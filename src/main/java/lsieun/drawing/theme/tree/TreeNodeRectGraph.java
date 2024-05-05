package lsieun.drawing.theme.tree;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.theme.shape.line.ConnectionDirection;
import lsieun.drawing.theme.shape.line.ContinuousLine;
import lsieun.drawing.theme.shape.rect.FullRectangle;
import lsieun.drawing.utils.LineUtils;
import lsieun.drawing.utils.StringUtils;

public class TreeNodeRectGraph extends TreeNode<TreeNodeRectGraph> implements Drawable {
    private static final int HORIZONTAL_GAP = 5;

    private final TreeNodeText node;
    private final FullRectangle rect;
    private final GraphDirection direction;
    private int low;
    private int high;

    public TreeNodeRectGraph(TreeNodeText node, int contentWidth) {
        this(node, contentWidth, GraphDirection.TOP_DOWN);
    }

    public TreeNodeRectGraph(TreeNodeText node, int contentWidth, GraphDirection direction) {
        this.node = node;
        this.rect = new FullRectangle(contentWidth, node.text);
        this.direction = direction;
    }


    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        Canvas localCanvas = getLocalCanvas();
        localCanvas.updatePosition(startRow, startCol);

        canvas.overlay(localCanvas);
    }

    private Canvas getLocalCanvas() {
        Canvas canvas = new Canvas();
        updatePosition(0, 0);
        canvas.rectifyPosition();

        draw(canvas, this);

        return canvas;
    }

    private void updatePosition(int startRow, int startCol) {
        if (!hasChildren()) {
            // rect
            rect.setStartRow(startRow);
            rect.setStartCol(startCol);

            // graph
            switch (direction) {

                case LEFT_RIGHT:
                case RIGHT_LEFT: {
                    low = rect.getTop();
                    high = rect.getBottom();
                    break;
                }
                case TOP_DOWN:
                case BOTTOM_UP:
                default: {
                    low = rect.getLeft();
                    high = rect.getRight();
                    break;
                }
            }
            return;
        }

        switch (direction) {
            case BOTTOM_UP: {
                // rect
                rect.setStartRow(startRow);

                for (TreeNodeRectGraph child : children) {
                    child.updatePosition(startRow - rect.getHeight() - 1, startCol);
                    startCol = child.high + HORIZONTAL_GAP;
                }

                TreeNodeRectGraph firstChild = children.get(0);
                TreeNodeRectGraph lastChild = children.get(children.size() - 1);
                int col = (firstChild.rect.getLeft() + lastChild.rect.getLeft()) / 2;

                rect.setStartCol(col);

                // graph
                low = firstChild.rect.getLeft();
                high = lastChild.rect.getRight();

                break;
            }
            case LEFT_RIGHT: {
                // rect
                rect.setStartCol(startCol);

                for (TreeNodeRectGraph child : children) {
                    child.updatePosition(startRow, startCol + rect.getWidth() + 1 + HORIZONTAL_GAP);
                    startRow = child.high + 2;
                }

                TreeNodeRectGraph firstChild = children.get(0);
                TreeNodeRectGraph lastChild = children.get(children.size() - 1);
                int row = (firstChild.rect.getTop() + lastChild.rect.getTop()) / 2;

                rect.setStartRow(row);

                // graph
                low = firstChild.rect.getTop();
                high = lastChild.rect.getBottom();


                break;
            }
            case RIGHT_LEFT: {
                // rect
                rect.setStartCol(startCol);

                for (TreeNodeRectGraph child : children) {
                    child.updatePosition(startRow, startCol - child.rect.getWidth() - 1 - HORIZONTAL_GAP);
                    startRow = child.high + 2;
                }

                TreeNodeRectGraph firstChild = children.get(0);
                TreeNodeRectGraph lastChild = children.get(children.size() - 1);
                int row = (firstChild.rect.getTop() + lastChild.rect.getTop()) / 2;

                rect.setStartRow(row);

                // graph
                low = firstChild.rect.getTop();
                high = lastChild.rect.getBottom();

                break;
            }
            case TOP_DOWN:
            default: {
                // rect
                rect.setStartRow(startRow);

                for (TreeNodeRectGraph child : children) {
                    child.updatePosition(startRow + rect.getHeight() + 1, startCol);
                    startCol = child.high + HORIZONTAL_GAP;
                }

                TreeNodeRectGraph firstChild = children.get(0);
                TreeNodeRectGraph lastChild = children.get(children.size() - 1);
                int col = (firstChild.rect.getLeft() + lastChild.rect.getLeft()) / 2;

                rect.setStartCol(col);


                // graph
                low = firstChild.rect.getLeft();
                high = lastChild.rect.getRight();

                break;
            }
        }
    }

    private static void draw(Canvas canvas, TreeNodeRectGraph graph) {
        canvas.draw(graph.rect.getStartRow(), graph.rect.getStartCol(), graph.rect);

        if (graph.hasChildren()) {
            for (TreeNodeRectGraph child : graph.children) {
                draw(canvas, child);

                ContinuousLine line = connect(graph.rect, child.rect, graph.direction);
                canvas.draw(line.getStartRow(), line.getStartCol(), line);
            }
        }
    }

    private static ContinuousLine connect(FullRectangle rect1, FullRectangle rect2, GraphDirection direction) {
        switch (direction) {
            case LEFT_RIGHT:
            case RIGHT_LEFT: {
                return LineUtils.connect(rect1, rect2, ConnectionDirection.HORIZONTAL);
            }
            case TOP_DOWN:
            case BOTTOM_UP:
            default: {
                return LineUtils.connect(rect1, rect2, ConnectionDirection.VERTICAL);
            }
        }
    }


    public static TreeNodeRectGraph of(TreeNodeText node, GraphDirection direction) {
        int maxLength = StringUtils.maxLength(node);
        return recursive(node, maxLength, direction);
    }

    private static TreeNodeRectGraph recursive(TreeNodeText node, int contentWidth, GraphDirection direction) {
        TreeNodeRectGraph graph = new TreeNodeRectGraph(node, contentWidth, direction);

        if (node.hasChildren()) {
            for (TreeNodeText child : node.children) {
                TreeNodeRectGraph childGraph = recursive(child, contentWidth, direction);
                graph.addChild(childGraph);
            }
        }

        return graph;
    }
}
