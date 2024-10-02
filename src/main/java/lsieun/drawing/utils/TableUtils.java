package lsieun.drawing.utils;

import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.theme.table.FixedWidthOneLineTable;
import lsieun.drawing.theme.table.MarkdownTable;
import lsieun.drawing.theme.table.OneLineTable;
import lsieun.drawing.theme.table.TableType;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;

public class TableUtils {
    public static void printTable(Path path, String item, TableType tableType) throws IOException {
        String[][] matrix = MatrixUtils.readMatrix(path, item);
        printTable(matrix, tableType);
    }

    public static void printTable(List<String> lines, String item, TableType tableType) throws IOException {
        String[][] matrix = MatrixUtils.readMatrix(lines, item);
        printTable(matrix, tableType);
    }

    public static void printTable(String[] titleNames, int[][] dataMatrix, TableType tableType) {
        printTable(titleNames, MatrixUtils.from(dataMatrix), tableType);
    }

    public static void printTable(String[] titleNames, long[][] dataMatrix, TableType tableType) {
        printTable(titleNames, MatrixUtils.from(dataMatrix), tableType);
    }

    public static void printTable(String[] titleNames, String[][] dataMatrix, TableType tableType) {
        int totalRows = dataMatrix.length + 1;
        int totalCols = titleNames.length;

        String[][] matrix = new String[totalRows][totalCols];

        // title
        for (int col = 0; col < totalCols; col++) {
            matrix[0][col] = titleNames[col].intern();
        }

        // data
        for (int row = 1; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                matrix[row][col] = String.valueOf(dataMatrix[row - 1][col]).intern();
            }
        }

        printTable(matrix, tableType);
    }

    public static void printTable(String[][] matrix, TableType tableType) {
        Function<String[][], Drawable> func;
        switch (tableType) {
            case MARKDOWN:
                func = MarkdownTable::new;
                break;
            case ONE_LINE:
                func = OneLineTable::new;
                break;
            case FIXED_WIDTH:
                func = FixedWidthOneLineTable::new;
                break;
            default:
                throw new IllegalArgumentException("Unsupported table type: " + tableType);
        }
        Drawable drawable = func.apply(matrix);
        CanvasUtils.print(drawable);
    }
}
