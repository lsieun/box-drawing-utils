package run.sample;

import lsieun.drawing.canvas.TextDirection;
import lsieun.drawing.theme.bit.ByteEntry;
import lsieun.drawing.theme.bit.ByteType;
import lsieun.drawing.theme.bit.MultiBytes;
import lsieun.drawing.theme.line.ContinuousLine;
import lsieun.drawing.theme.table.MarkdownTable;
import lsieun.drawing.theme.text.PlainText;
import lsieun.drawing.theme.text.PlainTextWithBorder;
import lsieun.drawing.theme.tree.BinaryTree;
import lsieun.drawing.theme.tree.DirectoryTree;

import java.util.ArrayList;
import java.util.List;

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
        bytes.add(ByteEntry.valueOf(ByteType.SINGLE, 3, ""));
        bytes.add(ByteEntry.valueOf(ByteType.MULTIPLE, 8, ""));
        bytes.add(ByteEntry.valueOf(ByteType.MULTIPLE, 16, "this is a multiple-bytes data"));
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
}
