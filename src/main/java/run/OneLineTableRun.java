package run;

import lsieun.canvas.TextAlign;
import lsieun.drawing.table.OneLineTable;

public class OneLineTableRun {
    public static void main(String[] args) {
        String[][] matrix = getSample();
        OneLineTable table = new OneLineTable(matrix, TextAlign.CENTER);
        table.draw();
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    public static String[][] getSample() {
        String[][] matrix = {
                {"0", "Interpreter", "Value", "Range"},
                {"1", "BasicInterpreter", "BasicValue", "7"},
                {"2", "BasicVerifier", "BasicValue", "7"},
                {"3", "SimpleVerifier", "BasicValue", "N"},
                {"4", "SourceInterpreter", "SourceValue", "N"},
        };
        return matrix;
    }
}
