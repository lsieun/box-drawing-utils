package lsieun.drawing.utils;

import lsieun.drawing.theme.table.TableType;
import org.junit.jupiter.api.Test;

class TableUtilsTest {

    @Test
    @SuppressWarnings("UnnecessaryLocalVariable")
    void testPrintTable() {
        String[] titleNames = {"a", "b", "sum"};

        int[][] dataMatrix = new int[10][3];
        for (int i = 0; i < 10; i++) {
            int a = i;
            int b = i + 1;
            int sum = a + b;
            dataMatrix[i][0] = a;
            dataMatrix[i][1] = b;
            dataMatrix[i][2] = sum;
        }

        for (TableType type : TableType.values()) {
            TableUtils.printTable(titleNames, dataMatrix, type);
        }
    }

    @Test
    void testPrintTableFromClasspath() {
        String[][] matrix = MatrixUtils.readMatrixFromClasspath("table.md", "Common", ",");
        for (TableType type : TableType.values()) {
            TableUtils.printTable(matrix, type);
        }
    }

    @Test
    void testPrintTableFromClasspathByCellSeparator() {
        String[][] matrix = MatrixUtils.readMatrixFromClasspath("table.md", "Platform MXBeans", "\\|");
        for (TableType type : TableType.values()) {
            TableUtils.printTable(matrix, type);
        }
    }
}