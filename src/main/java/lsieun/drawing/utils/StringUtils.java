package lsieun.drawing.utils;

import lsieun.drawing.theme.tree.BinaryTreeNodeText;
import lsieun.drawing.theme.tree.TreeNodeText;

import java.util.List;

public class StringUtils {
    public static int maxLength(List<String> lines) {
        if (lines == null || lines.isEmpty()) {
            return 0;
        }

        int maxLength = 0;
        for (String str : lines) {
            if (str == null) {
                continue;
            }
            int len = str.length();
            if (len > maxLength) {
                maxLength = len;
            }
        }
        return maxLength;
    }

    public static int maxLength(String[][] matrix) {
        int max = 0;
        for (String[] row : matrix) {
            for (String item : row) {
                int length = item.length();
                if (length > max) {
                    max = length;
                }
            }
        }
        return max;
    }

    public static int[] getColWidthArray(String[][] matrix) {
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;
        int[] colWidthArray = new int[totalCols];
        for (int col = 0; col < totalCols; col++) {
            for (int row = 0; row < totalRows; row++) {
                String str = matrix[row][col];
                int len = str == null? 0 : str.length();
                if (len > colWidthArray[col]) {
                    colWidthArray[col] = len;
                }
            }
        }
        return colWidthArray;
    }



    public static int maxLength(BinaryTreeNodeText root) {
        if (root == null) {
            return 0;
        }
        int max = root.text.length();
        max = Math.max(max, maxLength(root.leftChild));
        max = Math.max(max, maxLength(root.rightChild));
        return max;
    }

    public static int maxLength(TreeNodeText root) {
        if (root == null) {
            return 0;
        }
        int max = root.text.length();
        if (root.hasChildren()) {
            for (TreeNodeText child : root.children) {
                max = Math.max(max, maxLength(child));
            }
        }

        return max;
    }
}
