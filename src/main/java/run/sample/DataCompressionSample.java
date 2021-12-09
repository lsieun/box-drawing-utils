package run.sample;

import lsieun.drawing.theme.tree.BinaryTree;
import lsieun.drawing.utils.BitUtils;

public class DataCompressionSample {
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
