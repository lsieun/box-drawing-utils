package lsieun.drawing.utils;

import lsieun.drawing.theme.tree.Tree;

import java.util.Formatter;
import java.util.List;

public class MarkdownUtils {
    private static final String INDENT = "    ";

    public static void print(Tree tree) {
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        formatTree(fm, tree, 0);
        String text = sb.toString();
        System.out.println(text);
    }

    private static void formatTree(Formatter fm, Tree tree, int level) {
        String prefix = repeat(INDENT, level);
        String name = tree.line;
        fm.format("%s- %s%n", prefix, name);

        List<Tree> children = tree.children;
        for (Tree child : children) {
            formatTree(fm, child, level + 1);
        }
    }

    private static String repeat(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
