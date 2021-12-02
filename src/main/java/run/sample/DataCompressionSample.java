package run.sample;

import lsieun.drawing.theme.tree.BinaryTree;
import lsieun.drawing.theme.tree.Tree;
import lsieun.drawing.utils.BitUtils;

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
        Tree child2 = Tree.valueOf("block 2");
        Tree child3 = Tree.valueOf("block 3");
        Tree childm = Tree.valueOf("block m");
        Tree childn = Tree.valueOf("block n");
        tree.addChild(child1);
        tree.addChild(child2);
        tree.addChild(child3);
        tree.addChild(childm);
        tree.addChild(childn);

        Tree child21 = Tree.valueOf("LZ77 algorithm");
        Tree child22 = Tree.valueOf("Huffman coding");
        child2.addChild(child21);
        child2.addChild(child22);

        Tree childm1 = Tree.valueOf("a pair of Huffman code trees");
        Tree childm2 = Tree.valueOf("a compressed data");
        childm.addChild(childm1);
        childm.addChild(childm2);

        Tree childm11 = Tree.valueOf("literals + lengths");
        Tree childm12 = Tree.valueOf("distances");
        childm1.addChild(childm11);
        childm1.addChild(childm12);

        Tree child231 = Tree.valueOf("literal bytes");
        Tree child232 = Tree.valueOf("pointers: <length, backward distance>");
        childm2.addChild(child231);
        childm2.addChild(child232);

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
