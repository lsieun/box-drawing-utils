package lsieun.box.drawing.utils;

import java.util.ArrayList;
import java.util.List;

public class TreeTextGraph {
    private static final int NOT_SET = -1;

    public int row = NOT_SET;
    public int col = NOT_SET;
    public int length;
    public Tree tree;
    public TreeTextGraph parent;
    public final List<TreeTextGraph> children = new ArrayList<>();

}
