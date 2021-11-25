package run.sample;

import lsieun.drawing.theme.tree.BinaryTree;
import lsieun.drawing.theme.tree.Tree;
import lsieun.utils.BitUtils;

public class DataCompressionSample {
    public static Tree getTreeOfDataCompression() {
        Tree tree = Tree.valueOf("Data Compression");

        Tree child1 = Tree.valueOf("lossless");
        Tree child2 = Tree.valueOf("lossy");
        tree.addChild(child1);
        tree.addChild(child2);

        Tree child11 = Tree.valueOf("Run-length");
        Tree child12 = Tree.valueOf("Huffman");
        Tree child13 = Tree.valueOf("Lempel Ziv");
        child1.addChild(child11);
        child1.addChild(child12);
        child1.addChild(child13);

        Tree child21 = Tree.valueOf("JPEG");
        Tree child22 = Tree.valueOf("MPEG");
        Tree child23 = Tree.valueOf("MP3");
        child2.addChild(child21);
        child2.addChild(child22);
        child2.addChild(child23);

        return tree;
    }

    public static Tree getTreeOfDeflate() {
        Tree tree = Tree.valueOf("deflate");

        Tree child1 = Tree.valueOf("block 1");
        Tree child2 = Tree.valueOf("block m");
        Tree child3 = Tree.valueOf("block n");
        tree.addChild(child1);
        tree.addChild(child2);
        tree.addChild(child3);

        Tree child21 = Tree.valueOf("Huffman code tree 1: literals + lengths");
        Tree child22 = Tree.valueOf("Huffman code tree 2: distances");
        Tree child23 = Tree.valueOf("compressed data");
        child2.addChild(child21);
        child2.addChild(child22);
        child2.addChild(child23);

        Tree child231 = Tree.valueOf("literal bytes");
        Tree child232 = Tree.valueOf("pointers to duplicated strings: <length, backward distance>");
        child23.addChild(child231);
        child23.addChild(child232);

        return tree;
    }

    public static BinaryTree getBinaryTreeOfDeflate() {
        BinaryTree tree = BinaryTree.valueOf("root");
        addBinaryTreeRange(tree, 0b00110000, 0b10111111, 8, 0);
        addBinaryTreeRange(tree, 0b110010000, 0b111111111, 9, 144);
        addBinaryTreeRange(tree, 0b0000000, 0b0010111, 7, 256);
        addBinaryTreeRange(tree, 0b11000000, 0b11000111, 8, 280);
        return tree;
    }

    private static void addBinaryTreeRange(BinaryTree tree, int start, int stop, int bitLength, int num) {
        for (int i = start; i <= stop; i++) {
            String binary_str_32_bit = BitUtils.fromInt(i);

            String binary_str_shorter = binary_str_32_bit.substring(binary_str_32_bit.length() - bitLength);
            BinaryTree.addChild(tree, binary_str_shorter, String.valueOf(i + num - start));
        }
    }
}
