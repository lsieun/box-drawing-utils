package lsieun.box.drawing.utils;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    public final String line;
    public Tree parent;
    public final List<Tree> children = new ArrayList<>();

    public Tree(String line) {
        this.line = line;
    }

    public void addChild(Tree child) {
        children.add(child);
        child.parent = this;
    }

    public static Tree valueOf(String line) {
        return new Tree(line);
    }
}
