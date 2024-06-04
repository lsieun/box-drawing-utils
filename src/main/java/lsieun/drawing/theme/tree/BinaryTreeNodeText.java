package lsieun.drawing.theme.tree;

import lsieun.drawing.theme.text.Text;

public class BinaryTreeNodeText extends BinaryTreeNode<BinaryTreeNodeText> {
    public final Text val;

    public BinaryTreeNodeText(String... val) {
        this(Text.of(val));
    }

    public BinaryTreeNodeText(Text val) {
        this.val = val;
    }

    public static BinaryTreeNodeText of(String... text) {
        return new BinaryTreeNodeText(text);
    }
}
