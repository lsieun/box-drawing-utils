package lsieun.drawing.theme.tree;

import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;


class BinaryTreeTest {
    @Test
    void test() {
        BinaryTree root = BinaryTree.valueOf("root");

        BinaryTree child0 = BinaryTree.valueOf("left");
        BinaryTree child1 = BinaryTree.valueOf("right");
        root.addLeftChild(child0);
        root.addRightChild(child1);

        BinaryTree child00 = BinaryTree.valueOf("left-left");
        BinaryTree child01 = BinaryTree.valueOf("left-right");
        child0.addLeftChild(child00);
        child0.addRightChild(child01);

        BinaryTree child000 = BinaryTree.valueOf("left-left-left");
        child00.addLeftChild(child000);

        BinaryTree child11 = BinaryTree.valueOf("right-right");
        child1.addRightChild(child11);

        CanvasUtils.print(root);
    }
}