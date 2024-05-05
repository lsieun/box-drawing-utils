package lsieun.drawing.utils;

import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.theme.tree.BinaryTreeNode;
import lsieun.drawing.theme.tree.DirectoryTree;
import lsieun.drawing.theme.tree.Tree;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class TreeUtils {
    // region help methods
    public static boolean isRoot(BinaryTreeNode<?> tree) {
        return tree.parent == null;
    }

    public static boolean isLeaf(BinaryTreeNode<?> tree) {
        return (tree.leftChild == null) && (tree.rightChild == null);
    }

    public static boolean hasParent(BinaryTreeNode<?> tree) {
        return tree.parent != null;
    }

    public static boolean hasLeftChild(BinaryTreeNode<?> tree) {
        return tree.leftChild != null;
    }

    public static boolean hasRightChild(BinaryTreeNode<?> tree) {
        return tree.rightChild != null;
    }

    public static boolean hasBothChild(BinaryTreeNode<?> tree) {
        return (tree.leftChild != null) && (tree.rightChild != null);
    }

    // endregion

    // region markdown
    public static List<? extends Drawable> readTreeFromMarkdown(String filepath, String item) {
        List<String> lines = FileUtils.readLines(filepath);
        return readTreeFromMarkdown(lines, item);
    }

    public static List<? extends Drawable> readTreeFromMarkdown(List<String> lines, String item) {
        List<Tree> list = Tree.parseLines(lines);
        List<Tree> resultList = new ArrayList<>();
        for (Tree tree : list) {
            String str = tree.line;
            if (str == null) continue;
            if (str.startsWith(item)) {
                resultList.add(tree);
            }
        }
        return resultList;
    }
    // endregion


    // region directory
    public static DirectoryTree readDirectory(String filepath, boolean includeEmptyDirectory) {
        File file = new File(filepath);
        String name = file.getName();

        DirectoryTree root = DirectoryTree.valueOf(name);
        readDirectory(file, root, includeEmptyDirectory);

        return root;
    }

    public static void readDirectory(File file, DirectoryTree tree, boolean includeEmptyDirectory) {
        if (!file.exists() || !file.isDirectory()) {
            return;
        }

        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                String name = f.getName();
                if (name.startsWith(".")) continue;

                DirectoryTree child = DirectoryTree.valueOf(name);


                if (f.isDirectory()) {
                    readDirectory(f, child, includeEmptyDirectory);

                    // do not show empty folder
                    if (child.children.size() > 0) {
                        tree.add(child);
                    }
                    else {
                        if (includeEmptyDirectory) {
                            tree.add(child);
                        }
                    }
                }
                else {
                    tree.add(child);
                }
            }
        }
    }
    // endregion


    // region jar
    public static DirectoryTree readJarFile(String filepath) {
        File file = new File(filepath);
        String name = file.getName();

        DirectoryTree root = DirectoryTree.valueOf(name);
        List<String> list = getAllEntries(filepath);
        Collections.sort(list);
        for (String item : list) {
            if (item.endsWith("/")) continue;
            DirectoryTree child = DirectoryTree.valueOf(item);
            root.add(child);
        }

        return root;
    }

    public static List<String> getAllEntries(String filePath) {
        List<String> list = new ArrayList<>();
        try {
            JarFile jarFile = new JarFile(filePath);
            Enumeration<JarEntry> entries = jarFile.entries();
            while (entries.hasMoreElements()) {
                JarEntry entry = entries.nextElement();
                list.add(entry.getName());
            }
            jarFile.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    // endregion


    // region java imports
    public static List<? extends Drawable> readJavaFileImports(String filepath, String packageName) {
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
    // endregion
}
