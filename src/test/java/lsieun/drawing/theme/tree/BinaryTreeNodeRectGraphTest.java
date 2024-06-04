package lsieun.drawing.theme.tree;

import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BinaryTreeNodeRectGraphTest {

    @Test
    @Order(1)
    void testBinaryTreeNodeRectGraph() {
        // create a binary tree
        BinaryTreeNodeText root = BinaryTreeNodeText.of("idx: 0", "root");
        BinaryTreeNodeText node1 = BinaryTreeNodeText.of("idx: 1", "node1");
        BinaryTreeNodeText node2 = BinaryTreeNodeText.of("idx: 2", "node2");
        BinaryTreeNodeText node3 = BinaryTreeNodeText.of("idx: 3", "node3");
        BinaryTreeNodeText node4 = BinaryTreeNodeText.of("node4");
        BinaryTreeNodeText node5 = BinaryTreeNodeText.of("node5");
        BinaryTreeNodeText node6 = BinaryTreeNodeText.of("node6");
        BinaryTreeNodeText node7 = BinaryTreeNodeText.of("node7");
        BinaryTreeNodeText node8 = BinaryTreeNodeText.of("node8");
        root.addLeftChild(node1);
        root.addRightChild(node2);
        node1.addLeftChild(node3);
        node1.addRightChild(node4);
        node2.addLeftChild(node5);
        node2.addRightChild(node6);
        node4.addLeftChild(node7);
        node4.addRightChild(node8);

        // create a rect graph
        for (GraphDirection direction : GraphDirection.values()) {
            System.out.println("direction = " + direction);
            Drawable rectGraph = BinaryTreeNodeRectGraph.of(root, direction);
            CanvasUtils.print(rectGraph);
        }
    }

    @Test
    @Order(2)
    void testBinaryTreeNodeRectGraph2() {
        // create a binary tree
        BinaryTreeNodeText root = generateNodeTreeByDepth(1, 0, 4);

        // create a rect graph
        for (GraphDirection direction : GraphDirection.values()) {
            System.out.println("direction = " + direction);
            Drawable rectGraph = BinaryTreeNodeRectGraph.of(root, direction);
            CanvasUtils.print(rectGraph);
        }
    }

    private static BinaryTreeNodeText generateNodeTreeByDepth(int index, int depth, int maxDepth) {
        if (depth == maxDepth) {
            return null;
        }

        String name = String.format("%03d", index);
        BinaryTreeNodeText node = BinaryTreeNodeText.of(name);

        node.addLeftChild(generateNodeTreeByDepth(2 * index, depth + 1, maxDepth));

        node.addRightChild(generateNodeTreeByDepth(2 * index + 1, depth + 1, maxDepth));

        return node;
    }

    @Test
    @Order(3)
    void testBinaryTreeNodeRectGraph3() {
        // create a binary tree
        BinaryTreeNodeText root = generateNodeTreeByIndex(1, 25);

        // create a rect graph
        for (GraphDirection direction : GraphDirection.values()) {
            System.out.println("direction = " + direction);
            Drawable rectGraph = BinaryTreeNodeRectGraph.of(root, direction);
            CanvasUtils.print(rectGraph);
        }

    }

    private static BinaryTreeNodeText generateNodeTreeByIndex(int index, int maxIndex) {
        if (index > maxIndex) {
            return null;
        }

        String name = String.format("%03d", index);
        BinaryTreeNodeText node = BinaryTreeNodeText.of(name);

        node.addLeftChild(generateNodeTreeByIndex(2 * index, maxIndex));

        node.addRightChild(generateNodeTreeByIndex(2 * index + 1, maxIndex));

        return node;
    }
}