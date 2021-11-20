package lsieun.drawing.theme.tree;

import java.util.ArrayList;
import java.util.List;

class TreeTextGraph {
    private static final int NOT_SET = -1;

    public int row = NOT_SET;
    public int col = NOT_SET;
    public int length;
    public Tree tree;
    public TreeTextGraph parent;
    public final List<TreeTextGraph> children = new ArrayList<>();

}
