package lsieun.drawing.theme.tree;

import java.util.ArrayList;
import java.util.List;

class TreeTextGraphUtils {
    private static final int PADDING_SPACE = 1;
    private static final int CONNECTION_LINE_LENGTH = 3;

    public static void print(TreeTextGraph graph) {
        List<TreeTextGraph> list = getList(graph);

        for (TreeTextGraph item : list) {
            String line = String.format("(%02d, %02d): %s", item.row, item.col, item.tree.line);
            System.out.println(line);
        }
    }

    public static void updatePosition(TreeTextGraph graph) {
        // 1. update row and col
        updateRow(graph);
        updateCol(graph);

        // 2. update row again
//        updateRowAgain(graph);
    }

    public static List<TreeTextGraph> getList(TreeTextGraph graph) {
        List<TreeTextGraph> list = new ArrayList<>();
        list.add(graph);
        for (int i = 0; i < list.size(); i++) {
            TreeTextGraph item = list.get(i);
            List<TreeTextGraph> children = item.children;
            list.addAll(children);
        }
        return list;
    }

    public static void updateRowAgain(TreeTextGraph graph) {
        List<TreeTextGraph> list = getList(graph);
        for (int i = list.size() - 1; i >= 0; i--) {
            TreeTextGraph item = list.get(i);
            List<TreeTextGraph> children = item.children;
            int size = children.size();
            if (size == 0) continue;

            int firstRow = children.get(0).row;
            int lastRow = children.get(size - 1).row;
            int sum = firstRow + lastRow;
            if (sum % 2 == 1) {
                for (TreeTextGraph child : children) {
                    if (child.row >= item.row) {
                        addRow(child, 1);
                    }
                }
                item.row = (sum + 1) / 2;
            }
            else {
                item.row = sum / 2;
            }
        }
    }

    public static void addRow(TreeTextGraph graph, int row) {
        List<TreeTextGraph> list = getList(graph);
        for (TreeTextGraph item : list) {
            item.row += row;
        }
    }

    public static void updateRow(TreeTextGraph graph) {
        int row = 0;
        TreeTextGraph target = findTheTopMostLeaf(graph);
        while (target != null) {
            boolean isLeaf = isLeaf(target);
            if (isLeaf) {
                target.row = row;
                row += 2;
                while (true) {
                    TreeTextGraph next = findNext(target);
                    if (next == null) {
                        if (target == null) break;
                        target = target.parent;
                        updateParentRowByChildren(target);
                    }
                    else {
                        target = next;
                        break;
                    }
                }
            }
            else {
                target = findTheTopMostLeaf(target);
            }
        }
    }

    public static void updateCol(TreeTextGraph rootGraph) {
        rootGraph.col = 0;
        rootGraph.length = rootGraph.tree.line.length();
        List<TreeTextGraph> list = new ArrayList<>();
        list.add(rootGraph);
        for (int i = 0; i < list.size(); i++) {
            TreeTextGraph item = list.get(i);
            List<TreeTextGraph> children = item.children;
            int maxLength = 0;
            for (TreeTextGraph child : children) {
                int length = child.tree.line.length();
                if (length > maxLength) {
                    maxLength = length;
                }
            }
            for (TreeTextGraph child : children) {
                child.col = item.col + item.length + 2 * CONNECTION_LINE_LENGTH + 2 * PADDING_SPACE + 1;
                child.length = maxLength;
                list.add(child);
            }
        }
    }

    public static TreeTextGraph findNext(TreeTextGraph item) {
        if (item == null) return null;

        TreeTextGraph parent = item.parent;
        if (parent == null) {
            return null;
        }

        List<TreeTextGraph> children = parent.children;
        int size = children.size();
        int index = children.indexOf(item);
        if (index == size - 1) {
            return null;
        }
        else {
            return children.get(index + 1);
        }
    }

    public static boolean isLeaf(TreeTextGraph graph) {
        if (graph == null) return false;
        return graph.children.size() <= 0;
    }

    public static void updateParentRowByChildren(TreeTextGraph graph) {
        if (graph == null) return;

        List<TreeTextGraph> children = graph.children;
        int size = children.size();
        int minRow = children.get(0).row;
        int maxRow = children.get(size - 1).row;

        graph.row = (minRow + maxRow) / 2;
    }

    public static TreeTextGraph findTheTopMostLeaf(TreeTextGraph rootGraph) {
        TreeTextGraph targetGraph = rootGraph;
        while (true) {
            List<TreeTextGraph> children = targetGraph.children;
            if (children.size() == 0) {
                break;
            }
            targetGraph = children.get(0);
        }

        return targetGraph;
    }

    public static TreeTextGraph createGraphFromTree(Tree rootTree) {
        if (rootTree == null) return null;
        TreeTextGraph rootGraph = new TreeTextGraph();
        copyTree2Graph(rootTree, rootGraph, 0);

        return rootGraph;
    }

    public static void copyTree2Graph(Tree tree, TreeTextGraph graph, int level) {
        graph.tree = tree;
        for (Tree childTree : tree.children) {
            TreeTextGraph childGraph = new TreeTextGraph();
            childGraph.parent = graph;
            graph.children.add(childGraph);

            copyTree2Graph(childTree, childGraph, level + 1);
        }
    }
}
