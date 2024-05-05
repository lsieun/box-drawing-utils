package lsieun.drawing.theme.tree;

import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

class TreeTest {

    @Test
    void test() {
        Tree root = Tree.valueOf("root");
        Tree node1 = Tree.valueOf("node1");
        Tree node2 = Tree.valueOf("node2");
        Tree node3 = Tree.valueOf("node3");
        Tree node4 = Tree.valueOf("node4");
        Tree node5 = Tree.valueOf("node5");
        Tree node6 = Tree.valueOf("node6");

        root.addChild(node1);
        root.addChild(node2);
        root.addChild(node3);
        node1.addChild(node3);
        node1.addChild(node4);
        node2.addChild(node5);
        node3.addChild(node6);

        CanvasUtils.print(root);
    }

}