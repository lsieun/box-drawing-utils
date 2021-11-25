package run.sample;

import lsieun.drawing.theme.table.MarkdownTable;
import lsieun.drawing.theme.tree.Tree;

public class GitSample {
    public static Tree getTreeOfPackFormat() {
        Tree tree = Tree.valueOf("pack format");

        Tree child1 = Tree.valueOf("header (12-bytes)");
        Tree child2 = Tree.valueOf("object entries");
        Tree child3 = Tree.valueOf("checksum (20-bytes)");
        tree.addChild(child1);
        tree.addChild(child2);
        tree.addChild(child3);

        Tree child11 = Tree.valueOf("signature (4-bytes)");
        Tree child12 = Tree.valueOf("version (4-bytes)");
        Tree child13 = Tree.valueOf("objects number (4-bytes)");
        child1.addChild(child11);
        child1.addChild(child12);
        child1.addChild(child13);

        Tree child21 = Tree.valueOf("entry 1");
        Tree child22 = Tree.valueOf("entry 2");
        Tree child23 = Tree.valueOf("entry 3");
        Tree child2m = Tree.valueOf("entry m");
        Tree child2n = Tree.valueOf("entry n");
        Tree child2dot1 = Tree.valueOf("......");
        Tree child2dot2 = Tree.valueOf("......");
        child2.addChild(child21);
        child2.addChild(child22);
        child2.addChild(child23);
        child2.addChild(child2dot1);
        child2.addChild(child2m);
        child2.addChild(child2dot2);
        child2.addChild(child2n);

        Tree child211 = Tree.valueOf("type (3-bit)");
        Tree child212 = Tree.valueOf("data length");
        Tree child213 = Tree.valueOf("compressed data");
        child2m.addChild(child211);
        child2m.addChild(child212);
        child2m.addChild(child213);

        return tree;
    }

    public static MarkdownTable getMarkdownTable() {
        String[][] matrix = {
                {"command", "HEAD", "branch", "index", "working dir"},
                {"`git reset --hard`", "NO", "NO", "YES", "YES"},
                {"`git reset --mixed`", "NO", "NO", "YES", "NO"},
                {"`git reset --soft`", "YES", "NO", "NO", "NO"},
                {"`git checkout`", "YES", "YES", "YES", "YES"},
                {"", "", "", "", ""},
                {"", "", "", "", ""},
        };
        return new MarkdownTable(matrix);
    }
}
