package lsieun.drawing.utils;

import lsieun.drawing.theme.text.Text;
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

    public static int maxLength(String[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int max = 0;
        for (String str : array) {
            if (str == null) {
                continue;
            }
            int len = str.length();
            if (len > max) {
                max = len;
            }
        }
        return max;
    }

    public static int maxLength(String[][] matrix) {
        int max = 0;
        for (String[] array : matrix) {
            int length = maxLength(array);
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    public static int maxLength(String[][][] cube) {
        int max = 0;
        for (String[][] matrix : cube) {
            int length = maxLength(matrix);
            if (length > max) {
                max = length;
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
                int len = str == null ? 0 : str.length();
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
        int max = root.val.getMaxColWidth();
        max = Math.max(max, maxLength(root.leftChild));
        max = Math.max(max, maxLength(root.rightChild));
        return max;
    }

    public static int maxLength(TreeNodeText root) {
        if (root == null) {
            return 0;
        }
        int max = root.val.length();
        if (root.hasChildren()) {
            for (TreeNodeText child : root.children) {
                max = Math.max(max, maxLength(child));
            }
        }

        return max;
    }

    public static int maxLength(Text text) {
        if (text == null) {
            return 0;
        }

        int max = 0;
        int totalRows = text.getTotalRows();
        for (int row = 0; row < totalRows; row++) {
            String str = text.getLine(row);
            int len = str == null ? 0 : str.length();
            if (len > max) {
                max = len;
            }
        }
        return max;
    }

    public static int maxLength(Text[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int max = 0;
        for (Text text : array) {
            int len = maxLength(text);
            if (len > max) {
                max = len;
            }
        }
        return max;
    }

    public static int maxLength(Text[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0;
        for (Text[] array : matrix) {
            int len = maxLength(array);
            if (len > max) {
                max = len;
            }
        }
        return max;
    }

    public static boolean isAllNull(String[] array) {
        if (array == null) {
            return true;
        }

        for (String str : array) {
            if (str != null) {
                return false;
            }
        }
        return true;
    }
}
