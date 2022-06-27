package run;

import lsieun.drawing.utils.FileUtils;

import java.util.ArrayList;
import java.util.List;

public class C_TransformLines {
    private static final String[] INDENT_ARRAY = new String[20];

    static {
        INDENT_ARRAY[0] = "";
        for (int i = 1; i < INDENT_ARRAY.length; i++) {
            INDENT_ARRAY[i] = INDENT_ARRAY[i - 1] + "    ";
        }
    }

    public static void main(String[] args) {
        String filePath = FileUtils.getFilePath("tree-of-java-generic.md");
        List<String> oldLines = FileUtils.readLines(filePath);


        List<String> resultList = new ArrayList<>();
        for (String line : oldLines) {
            if (
                    "".endsWith(line) ||
                    line.startsWith("#") ||
                            line.startsWith("`") ||
                            line.startsWith("---")
            ) {
                resultList.add(line);
                continue;
            }

            int index = line.indexOf("-");
            String newLine = INDENT_ARRAY[index] + line.substring(index);
            resultList.add(newLine);
        }

        for (String line : resultList) {
            System.out.println(line);
        }

        FileUtils.writeLines(filePath, resultList);
    }
}
