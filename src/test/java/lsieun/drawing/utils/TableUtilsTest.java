package lsieun.drawing.utils;

import lsieun.drawing.theme.table.TableType;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

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
    void testPrintTableFromClasspath() throws IOException {
        Path path = ResourceUtils.readFilePath("table.md", true);
        String[][] matrix = MatrixUtils.readMatrix(path, "Common", ",");
        for (TableType type : TableType.values()) {
            TableUtils.printTable(matrix, type);
        }
    }

    @Test
    void testPrintTableFromClasspathByCellSeparator() throws IOException {
        Path path = ResourceUtils.readFilePath("table.md", true);
        String[][] matrix = MatrixUtils.readMatrix(path, "Platform MXBeans", "\\|");
        for (TableType type : TableType.values()) {
            TableUtils.printTable(matrix, type);
        }
    }
}