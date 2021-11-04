package lsieun.box.drawing.utils;

import lsieun.box.drawing.BoxDrawing;
import lsieun.box.drawing.TextStateCanvas;

import java.util.ArrayList;
import java.util.List;

public class TreeTextGraphUtils {
    private static final int PADDING_SPACE = 1;
    private static final int CONNECTION_LINE_LENGTH = 3;

    public static void print(TreeTextGraph graph) {
        List<TreeTextGraph> list = getList(graph);

        for (TreeTextGraph item : list) {
            String line = String.format("(%02d, %02d): %s", item.row, item.col, item.tree.line);
            System.out.println(line);
        }
    }

    public static void draw(TreeTextGraph graph) {
        // 1. get list
        List<TreeTextGraph> list = getList(graph);

        // 2. draw text
        TextStateCanvas canvas = new TextStateCanvas();
        for (TreeTextGraph item : list) {
            canvas.drawText(item.row, item.col, item.tree.line);
        }

        // 3. draw connection line
        for (TreeTextGraph item : list) {
            List<TreeTextGraph> children = item.children;
            int size = children.size();
            if (size < 1) continue;

            int startRow = children.get(0).row;
            int midRow = item.row;
            int stopRow = children.get(size - 1).row;

            int startCol = item.col + item.tree.line.length() + PADDING_SPACE;
            int midCol = item.col + item.length + CONNECTION_LINE_LENGTH + PADDING_SPACE;
            int colCount = midCol - startCol;

            canvas.moveTo(midRow, startCol);
            canvas.turnRight().drawLine(colCount).switchUp().drawLine(midRow - startRow - 1);

            canvas.moveTo(midRow, startCol);
            canvas.turnRight().drawLine(colCount).switchDown().drawLine(stopRow - midRow - 1);

            for (int i = 0; i < size; i++) {
                TreeTextGraph child = children.get(i);
                String ch;
                if (i == 0) {
                    ch = BoxDrawing.LIGHT_DOWN_AND_RIGHT.val;
                }
                else if (i == size - 1) {
                    ch = BoxDrawing.LIGHT_UP_AND_RIGHT.val;
                }
                else {
                    ch = BoxDrawing.LIGHT_VERTICAL_AND_RIGHT.val;
                }

                canvas.mergePixel(child.row, midCol, ch);
                canvas.moveTo(child.row, midCol + 1);
                canvas.turnRight().drawLine(CONNECTION_LINE_LENGTH);
            }
        }

        // 4. print
        List<String> lines = canvas.getLines();
        lines.forEach(System.out::println);
    }

    public static void updatePosition(TreeTextGraph graph) {
        // 1. update row and col
        updateRow(graph);
        updateCol(graph);

        // 2. update row again
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
