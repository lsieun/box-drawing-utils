package run;

import lsieun.drawing.utils.FileUtils;

public class PathManager {
    public static String getOutputPath() {
        return FileUtils.getFilePath("canvas.txt");
    }
}
