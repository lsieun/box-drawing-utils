package lsieun.drawing.tree;

import lsieun.canvas.Drawable;

import java.util.ArrayList;
import java.util.List;

public class Tree implements Drawable {
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

    @Override
    public void draw() {
        TreeTextGraph graph = TreeTextGraphUtils.createGraphFromTree(this);
        TreeTextGraphUtils.updatePosition(graph);
        TreeTextGraphUtils.print(graph);
        TreeTextGraphUtils.draw(graph);
    }
}
