package lsieun.drawing.utils;

import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.theme.tree.Tree;
import run.PathManager;

import java.util.ArrayList;
import java.util.List;

public class TreeUtils {
    public static List<? extends Drawable> readTree() {
        String filepath = FileUtils.getFilePath(PathManager.getFileName());
        List<String> lines = FileUtils.readLines(filepath);
        List<Tree> list = Tree.parseLines(lines);

        List<Tree> resultList = new ArrayList<>();
        for (Tree tree : list) {
            String str = tree.line;
            if (str == null) continue;
            if (str.startsWith(PathManager.getItem())) {
                resultList.add(tree);
            }
        }
        return resultList;
    }

    public static List<? extends Drawable> readJavaFileImports() {
        String filepath = "D:\\git-repo\\learn-java-fx\\src\\main\\java\\lsieun\\fx\\basic\\HelloFXApp.java";
        String packageName = "javafx";
        List<String> lines = FileUtils.readLines(filepath);
        String prefix = String.format("import %s", packageName);
        List<String> importClassList = new ArrayList<>();
        for (String line : lines) {
            if (line.startsWith(prefix)) {
                String className = line.substring(7, line.length() - 1);
                importClassList.add(className);
            }
        }
        importClassList.sort(String::compareTo);

        List<Tree> treeList = new ArrayList<>();

        for (String line : importClassList) {
            String[] array = line.split("\\.");
            mergeImportTree(treeList, array, 0);
        }

        return treeList;
    }

    private static void mergeImportTree(List<Tree> treeList, String[] array, int index) {
        int length = array.length;
        if (length == index) return;

        String item = array[index];
        Tree targetTree = null;
        for (Tree tree : treeList) {
            if (tree.line.endsWith(item)) {
                targetTree = tree;
                break;
            }
        }

        if (targetTree == null) {
            targetTree = Tree.valueOf(item);
            treeList.add(targetTree);
        }

        mergeImportTree(targetTree.children, array, index + 1);
    }
}
