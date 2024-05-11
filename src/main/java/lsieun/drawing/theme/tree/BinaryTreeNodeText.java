package lsieun.drawing.theme.tree;

public class BinaryTreeNodeText extends BinaryTreeNode<BinaryTreeNodeText> {
    public final String val;

    public BinaryTreeNodeText(String val) {
        this.val = val;
    }

    public static BinaryTreeNodeText of(String text) {
        return new BinaryTreeNodeText(text);
    }
}
