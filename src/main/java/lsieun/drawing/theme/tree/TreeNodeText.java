package lsieun.drawing.theme.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNodeText extends TreeNode<TreeNodeText> {
    public final String text;

    public TreeNodeText(String text) {
        this.text = text;
    }

    public static TreeNodeText valueOf(String text) {
        return new TreeNodeText(text);
    }

    public static List<TreeNodeText> parseLines(List<String> lines) {
        List<TreeNodeText> list = new ArrayList<>();

        TreeNodeText currentTree = null;
        for (String line : lines) {
            if (line == null) continue;
            // title
            if (line.startsWith("#")) continue;
            // code segment
            if (line.startsWith("`")) continue;
            // line separator
            if (line.startsWith("---")) continue;
            int index = line.indexOf("-");
            if (index < 0) continue;

            String name = line.substring(index + 1).trim();

            if (index == 0) {
                TreeNodeText tree = TreeNodeText.valueOf(name);
                list.add(tree);
                currentTree = tree;
            }
            else {
                addItem2Tree(currentTree, index / 4, name);
            }
        }

        return list;
    }

    public static void addItem2Tree(TreeNodeText root, int level, String name) {
        TreeNodeText tree = root;
        for (int i = 1; i < level; i++) {
            int size = tree.children.size();
            tree = tree.children.get(size - 1);
        }

        TreeNodeText newChild = TreeNodeText.valueOf(name);
        tree.addChild(newChild);
    }
}
