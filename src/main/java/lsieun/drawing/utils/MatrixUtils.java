package lsieun.drawing.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class MatrixUtils {
    public static String[][] from(int[][] data) {
        int totalRows = data.length;
        int totalCols = data[0].length;

        String[][] matrix = new String[totalRows][totalCols];
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                matrix[row][col] = String.valueOf(data[row][col]).intern();
            }
        }
        return matrix;
    }

    public static String[][] from(long[][] data) {
        int totalRows = data.length;
        int totalCols = data[0].length;

        String[][] matrix = new String[totalRows][totalCols];
        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                matrix[row][col] = String.valueOf(data[row][col]).intern();
            }
        }
        return matrix;
    }



    public static String[][] readMatrix(Path path, String title) throws IOException {
        return readMatrix(path, title, ",");
    }

    public static String[][] readMatrix(Path path, String title, final String cellSeparator) throws IOException {
        List<String> lines = Files.readAllLines(path);
        return readMatrix(lines, title, cellSeparator);
    }

    public static String[][] readMatrix(List<String> lines, String title) throws IOException {
        return readMatrix(lines, title, ",");
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    public static String[][] readMatrix(List<String> lines, final String title, final String cellSeparator) {
        String name = title;
        boolean flag = false;
        List<String> list = new ArrayList<>();
        for (String line : lines) {
            if (line == null) continue;
            line = line.trim();
            if ("".equals(line)) continue;
            if (line.startsWith("#")) {
                line = line.substring(1).trim();
                flag = line.startsWith(name);
                continue;
            }

            if (flag) {
                list.add(line);
            }
        }

        int row = list.size();
        int col = list.get(0).split(cellSeparator).length;

        String[][] matrix = new String[row][col];
        for (int i = 0; i < row; i++) {
            String line = list.get(i);
            String[] array = line.split(cellSeparator);
            for (int j = 0; j < col; j++) {
                String item = array[j].trim();
                matrix[i][j] = item;
            }
        }
        return matrix;
    }
}
