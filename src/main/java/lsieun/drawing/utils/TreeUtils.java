package lsieun.drawing.utils;

import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.theme.tree.BinaryTreeNode;
import lsieun.drawing.theme.tree.DirectoryTree;
import lsieun.drawing.theme.tree.Tree;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

    public static void trimTree(Tree root, String... trimNames) {
        if (trimNames == null || trimNames.length == 0) {
            return;
        }

        List<Tree> treeList = new ArrayList<>();
        treeList.add(root);
        for (int i = 0; i < treeList.size(); i++) {
            Tree tree = treeList.get(i);
            String name = tree.line;

            List<Tree> children = tree.children;
            if (children.isEmpty() && exists(name, trimNames)) {
                Tree parent = tree.parent;
                parent.children.remove(tree);
            }
            else {
                treeList.addAll(children);
            }
        }
    }

    static boolean exists(String name, String... trimNames) {
        for (String str : trimNames) {
            if (name.equals(str)) {
                return true;
            }
        }
        return false;
    }
    // endregion

    // region markdown
    public static List<? extends Drawable> readTree(Path path, String item) throws IOException {
        List<String> lines = Files.readAllLines(path);
        return readTree(lines, item);
    }

    public static List<? extends Drawable> readTree(List<String> lines, String item) {
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
    public static DirectoryTree readDirectory(Path dirPath, boolean includeEmptyDirectory) throws IOException {
        String name = dirPath.getFileName().toString();

        DirectoryTree root = DirectoryTree.valueOf(name);
        readDirectory(dirPath, root, includeEmptyDirectory);

        return root;
    }

    public static void readDirectory(Path dirPath, DirectoryTree tree, boolean includeEmptyDirectory) throws IOException {
        if (!Files.exists(dirPath) || !Files.isDirectory(dirPath)) {
            return;
        }

        try (DirectoryStream<Path> paths = Files.newDirectoryStream(dirPath)) {
            for (Path p : paths) {
                String name = p.getFileName().toString();
                if (name.startsWith(".")) continue;

                DirectoryTree child = DirectoryTree.valueOf(name);

                if (Files.isDirectory(p)) {
                    readDirectory(p, child, includeEmptyDirectory);

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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    // endregion


    // region java imports
    public static List<? extends Drawable> readJavaFileImports(String filepath, String packageName) throws IOException {
        Path path = Paths.get(filepath);
        List<String> lines = Files.readAllLines(path);
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
            targetTree = Tree.of(item);
            treeList.add(targetTree);
        }

        mergeImportTree(targetTree.children, array, index + 1);
    }
    // endregion
}
