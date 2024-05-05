package lsieun.drawing.theme.tree;

import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class HuffmanTreeTest {
    @Test
    void test() {
        List<HuffmanTree> list = new ArrayList<>();
        list.add(HuffmanTree.valueOf("a", 10));
        list.add(HuffmanTree.valueOf("e", 15));
        list.add(HuffmanTree.valueOf("i", 30));
        list.add(HuffmanTree.valueOf("o", 16));
        list.add(HuffmanTree.valueOf("u", 29));
        HuffmanTree tree = HuffmanTree.generateTree(list);
        CanvasUtils.print(tree);
    }
}