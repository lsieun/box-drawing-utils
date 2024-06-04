package lsieun.drawing.theme.tree;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.theme.shape.line.ConnectionDirection;
import lsieun.drawing.theme.shape.line.ContinuousLine;
import lsieun.drawing.theme.shape.rect.FullRectangle;
import lsieun.drawing.utils.LineUtils;
import lsieun.drawing.utils.StringUtils;

public class BinaryTreeNodeRectGraph extends BinaryTreeNode<BinaryTreeNodeRectGraph> implements Drawable {
    private static final int HORIZONTAL_GAP = 5;

    private final FullRectangle rect;
    private final GraphDirection direction;
    private int low;
    private int high;

    public BinaryTreeNodeRectGraph(BinaryTreeNodeText node, int contentWidth) {
        this(node, contentWidth, GraphDirection.TOP_DOWN);
    }

    public BinaryTreeNodeRectGraph(BinaryTreeNodeText node, int contentWidth, GraphDirection direction) {
        this.rect = FullRectangle.of(contentWidth, node.val);
        this.direction = direction;
    }

    public static BinaryTreeNodeRectGraph of(BinaryTreeNodeText node) {
        return of(node, GraphDirection.TOP_DOWN);
    }

    public static BinaryTreeNodeRectGraph of(BinaryTreeNodeText node, GraphDirection direction) {
        int maxLength = StringUtils.maxLength(node);
        return recursive(node, maxLength, direction);
    }

    private static BinaryTreeNodeRectGraph recursive(BinaryTreeNodeText node, int contentWidth, GraphDirection direction) {
        BinaryTreeNodeRectGraph graph = new BinaryTreeNodeRectGraph(node, contentWidth, direction);

        if (node.hasLeftChild()) {
            BinaryTreeNodeRectGraph leftChild = recursive(node.leftChild, contentWidth, direction);
            graph.addLeftChild(leftChild);
        }

        if (node.hasRightChild()) {
            BinaryTreeNodeRectGraph rightChild = recursive(node.rightChild, contentWidth, direction);
            graph.addRightChild(rightChild);
        }
        return graph;
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

    private static void draw(Canvas canvas, BinaryTreeNodeRectGraph graph) {
        canvas.draw(graph.rect.getStartRow(), graph.rect.getStartCol(), graph.rect);

        if (graph.hasLeftChild()) {
            draw(canvas, graph.leftChild);

            ContinuousLine line = connect(graph.rect, graph.leftChild.rect, graph.direction);
            canvas.draw(line.getStartRow(), line.getStartCol(), line);

        }

        if (graph.hasRightChild()) {
            draw(canvas, graph.rightChild);

            ContinuousLine line = connect(graph.rect, graph.rightChild.rect, graph.direction);
            canvas.draw(line.getStartRow(), line.getStartCol(), line);
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

    private void updatePosition(int startRow, int startCol) {
        if (isLeaf()) {
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

                if (hasLeftChild()) {
                    leftChild.updatePosition(rect.getTop() - rect.getHeight() - 2, startCol);
                }

                rect.setStartCol(hasLeftChild() ? leftChild.high : startCol);


                if (hasRightChild()) {
                    rightChild.updatePosition(rect.getTop() - rect.getHeight() - 2, rect.getRight());
                }

                // graph
                low = hasLeftChild() ? leftChild.low : rect.getLeft();
                high = hasRightChild() ? rightChild.high : rect.getRight();

                break;
            }
            case LEFT_RIGHT: {
                // rect
                rect.setStartRow(startRow);
                rect.setStartCol(startCol);

                if (hasLeftChild()) {
                    leftChild.updatePosition(rect.getTop() - rect.getHeight(), rect.getRight() + 1 + HORIZONTAL_GAP);
                }

                if (hasRightChild()) {
                    rightChild.updatePosition(rect.getTop() + rect.getHeight(), rect.getRight() + 1 + HORIZONTAL_GAP);
                }

                // graph
                low = hasLeftChild() ? leftChild.low : rect.getTop();
                high = hasRightChild() ? rightChild.high : rect.getBottom();

                break;
            }
            case RIGHT_LEFT: {
                // rect
                rect.setStartRow(startRow);
                rect.setStartCol(startCol);

                if (hasLeftChild()) {
                    leftChild.updatePosition(rect.getTop() - rect.getHeight(), rect.getLeft() - rect.getWidth() - 1 - HORIZONTAL_GAP);
                }

                if (hasRightChild()) {
                    rightChild.updatePosition(rect.getTop() + rect.getHeight(), rect.getLeft() - rect.getWidth() - 1 - HORIZONTAL_GAP);
                }

                // graph
                low = hasLeftChild() ? leftChild.low : rect.getTop();
                high = hasRightChild() ? rightChild.high : rect.getBottom();

                break;
            }
            case TOP_DOWN:
            default: {
                // rect
                rect.setStartRow(startRow);

                if (hasLeftChild()) {
                    leftChild.updatePosition(rect.getBottom() + 2, startCol);
                }

                rect.setStartCol(hasLeftChild() ? leftChild.high : startCol);


                if (hasRightChild()) {
                    rightChild.updatePosition(rect.getBottom() + 2, rect.getRight());
                }

                // graph
                low = hasLeftChild() ? leftChild.low : rect.getLeft();
                high = hasRightChild() ? rightChild.high : rect.getRight();
                break;
            }
        }
    }
}
