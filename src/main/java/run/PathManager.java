package run;

import lsieun.utils.FileUtils;

public class PathManager {
    public static String getOutputPath() {
        return FileUtils.getFilePath("canvas.txt");
    }
}
