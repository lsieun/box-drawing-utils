package lsieun.drawing.theme.tree;

public class BinaryTreeNodeText extends BinaryTreeNode<BinaryTreeNodeText> {
    public final String text;

    public BinaryTreeNodeText(String text) {
        this.text = text;
    }

    public static BinaryTreeNodeText of(String text) {
        return new BinaryTreeNodeText(text);
    }
}
