package run.sample;

import lsieun.drawing.canvas.TextAlign;
import lsieun.drawing.canvas.TextDirection;
import lsieun.drawing.theme.bit.ByteEntry;
import lsieun.drawing.theme.bit.ByteType;
import lsieun.drawing.theme.bit.MultiBytes;
import lsieun.drawing.theme.line.ContinuousLine;
import lsieun.drawing.theme.shape.Rectangle;
import lsieun.drawing.theme.shape.RectangleWithText;
import lsieun.drawing.theme.table.MarkdownTable;
import lsieun.drawing.theme.table.OneLineTable;
import lsieun.drawing.theme.text.PlainText;
import lsieun.drawing.theme.text.PlainTextWithBorder;
import lsieun.drawing.theme.tree.BinaryTree;
import lsieun.drawing.theme.tree.DirectoryTree;
import lsieun.drawing.theme.tree.HuffmanTree;
import lsieun.drawing.theme.tree.Tree;
import lsieun.drawing.utils.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Sample {
    public static PlainText getPlainText() {
        List<String> textList = new ArrayList<>();
        textList.add("You know some birds are not meant to be caged, their feathers are just too bright.");
        textList.add("I love three things in the world: the sun, the moon, and you.");
        textList.add("The sun for the day, the moon for the night, and you forever.");

        return PlainText.valueOf(textList);
    }

    public static PlainTextWithBorder getPlainTextWithBorder() {
        List<String> textList = new ArrayList<>();
        textList.add("I love three things in the world: the sun, the moon, and you.");
        textList.add("The sun for the day, the moon for the night, and you forever.");

        return PlainTextWithBorder.valueOf(textList);
    }

    public static ContinuousLine getContinuousLine1() {
        ContinuousLine line = new ContinuousLine();
        line.setDirection(TextDirection.UP);
        line.drawLine(3)
                .turn(TextDirection.RIGHT).drawLine(10)
                .turn(TextDirection.DOWN).drawLine(5)
                .turn(TextDirection.LEFT).drawLine(20)
                .turn(TextDirection.UP).drawLine(7)
                .turn(TextDirection.RIGHT).drawLine(30);
        return line;
    }

    public static ContinuousLine getContinuousLine2() {
        ContinuousLine line = new ContinuousLine();
        line.setDirection(TextDirection.UP);
        line.drawLine(3)
                .turn(TextDirection.LEFT).drawLine(10)
                .turn(TextDirection.DOWN).drawLine(5)
                .turn(TextDirection.RIGHT).drawLine(20)
                .turn(TextDirection.UP).drawLine(7)
                .turn(TextDirection.LEFT).drawLine(30);
        return line;
    }

    public static MarkdownTable getMarkdownTable() {
        String[][] matrix = {
                {"Year", "Algorithm", "Bit Length"},
                {"1992", "MD5", "128"},
                {"1993", "SHA1", "160"},
                {"2001", "SHA256", "256"},
                {"2001", "SHA384", "384"},
                {"2001", "SHA512", "512"},
        };
        return new MarkdownTable(matrix);
    }

    public static MultiBytes getByteFormat() {
        MultiBytes bytes = new MultiBytes();
        bytes.add(ByteEntry.valueOf(ByteType.SINGLE, 3, "76543210"));
        bytes.add(ByteEntry.valueOf(ByteType.SINGLE, 3, "one byte"));
        bytes.add(ByteEntry.valueOf(ByteType.MULTIPLE, 8, ""));
        bytes.add(ByteEntry.valueOf(ByteType.MULTIPLE, 16, "a variable number of bytes"));
        return bytes;
    }

    public static DirectoryTree getDirectoryTree() {
        DirectoryTree tree = DirectoryTree.valueOf("IDEA");

        DirectoryTree bin = DirectoryTree.valueOf("bin");
        DirectoryTree help = DirectoryTree.valueOf("help");
        DirectoryTree jbr = DirectoryTree.valueOf("jbr");
        DirectoryTree lib = DirectoryTree.valueOf("lib");
        DirectoryTree license = DirectoryTree.valueOf("license");
        DirectoryTree plugins = DirectoryTree.valueOf("plugins");
        DirectoryTree redist = DirectoryTree.valueOf("redist");
        tree.add(bin);
        tree.add(help);
        tree.add(jbr);
        tree.add(lib);
        tree.add(license);
        tree.add(plugins);
        tree.add(redist);

        DirectoryTree idea_bat = DirectoryTree.valueOf("idea.bat");
        DirectoryTree idea_exe = DirectoryTree.valueOf("idea.exe");
        DirectoryTree idea_exe_vmoptions = DirectoryTree.valueOf("idea.exe.vmoptions");
        bin.add(idea_bat);
        bin.add(idea_exe);
        bin.add(idea_exe_vmoptions);

        DirectoryTree reference_card_pdf = DirectoryTree.valueOf("ReferenceCard.pdf");
        DirectoryTree reference_card_for_mac_pdf = DirectoryTree.valueOf("ReferenceCardForMac.pdf");
        help.add(reference_card_pdf);
        help.add(reference_card_for_mac_pdf);

        DirectoryTree idea_jar = DirectoryTree.valueOf("idea.jar");
        DirectoryTree idea_rt_jar = DirectoryTree.valueOf("idea_rt.jar");
        lib.add(idea_jar);
        lib.add(idea_rt_jar);

        DirectoryTree plugin_java = DirectoryTree.valueOf("java");
        DirectoryTree plugin_java_ide_customization = DirectoryTree.valueOf("java-ide-customization");
        plugins.add(plugin_java);
        plugins.add(plugin_java_ide_customization);

        return tree;
    }

    public static BinaryTree getBinaryTree() {
        BinaryTree root = BinaryTree.valueOf("root");

        BinaryTree child0 = BinaryTree.valueOf("left");
        BinaryTree child1 = BinaryTree.valueOf("right");
        root.addLeftChild(child0);
        root.addRightChild(child1);

        BinaryTree child00 = BinaryTree.valueOf("left-left");
        BinaryTree child01 = BinaryTree.valueOf("left-right");
        child0.addLeftChild(child00);
        child0.addRightChild(child01);

        BinaryTree child000 = BinaryTree.valueOf("left-left-left");
        child00.addLeftChild(child000);

        BinaryTree child11 = BinaryTree.valueOf("right-right");
        child1.addRightChild(child11);

        return root;
    }

    public static HuffmanTree getHuffmanTree() {
        List<HuffmanTree> list = new ArrayList<>();
        list.add(HuffmanTree.valueOf("a", 10));
        list.add(HuffmanTree.valueOf("e", 15));
        list.add(HuffmanTree.valueOf("i", 30));
        list.add(HuffmanTree.valueOf("o", 16));
        list.add(HuffmanTree.valueOf("u", 29));
        return HuffmanTree.generateTree(list);
    }

    public static Rectangle getRectangle() {
        return new Rectangle(10, 3);
    }

    public static RectangleWithText getRectangleWithText() {
        List<String> lines = new ArrayList<>();
        lines.add("Bad times make a good man.");
        lines.add("The greatest test of courage on earth is to bear defeat without losing heart.");
        lines.add("Sow nothing, reap nothing.");
        lines.add("Life is but a hard and tortuous journey.");
        return new RectangleWithText(50, 3, lines, TextAlign.CENTER);
    }


    public static DirectoryTree readDirectory() {
        String filepath = "D:\\gitee\\java-agent-maven";
        File file = new File(filepath);
        String name = file.getName();

        DirectoryTree root = DirectoryTree.valueOf(name);
        readDirectory(file, root);

        return root;
    }

    public static void readDirectory(File file, DirectoryTree tree) {
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
                    readDirectory(f, child);

                    // do not show empty folder
                    if (child.children.size() > 0) {
                        tree.add(child);
                    }
                }
                else {
                    tree.add(child);
                }
            }
        }
    }

    public static DirectoryTree readJarFile() {
        String filepath = "D:\\gitee\\java-agent-maven\\target\\TheAgent.jar";
        File file = new File(filepath);
        String name = file.getName();

        DirectoryTree root = DirectoryTree.valueOf(name);
        List<String> list = getAllEntries(filepath);
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

    public static Tree readTree() {
        String filepath = FileUtils.getFilePath("tree-of-java-asm.txt");
        List<String> lines = FileUtils.readLines(filepath);
        List<Tree> list = Tree.parseLines(lines);

        for (Tree tree : list) {
            String str = tree.line;
            if (str == null) continue;
            if (str.startsWith("What ASM Can Do")) {
                return tree;
            }
        }
        return list.get(0);
    }

    public static OneLineTable readOneLineTable() {
        String[][] matrix = readMatrix();
        return new OneLineTable(matrix, TextAlign.CENTER);
    }

    public static MarkdownTable readMarkdownTable() {
        String[][] matrix = readMatrix();
        return new MarkdownTable(matrix);
    }

    public static String[][] readMatrix() {
        return readMatrix("table-of-java-jmx.txt", "management interfaces", ",");
    }

    public static String[][] readMatrix(final String filename, final String title, final String cellSeparator) {
        String filepath = FileUtils.getFilePath(filename);
        List<String> lines = FileUtils.readLines(filepath);

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
