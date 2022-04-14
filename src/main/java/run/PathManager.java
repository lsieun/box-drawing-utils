package run;

import lsieun.drawing.utils.FileUtils;

public class PathManager {
    public static String getOutputPath() {
        return FileUtils.getFilePath("canvas.txt");
    }

    public static String getFileName() {
        return "tree-of-java-byte-buddy.md";
    }

    public static String getItem() {
        return "JavaConstant";
    }

    public static String getDirectory() {
        return "D:\\tmp\\spi";
    }

    public static String getJarPath() {
        return "D:\\git-repo\\java-agent-maven\\target\\TheAgent.jar";
    }
}
