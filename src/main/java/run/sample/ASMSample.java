package run.sample;

import lsieun.drawing.canvas.TextAlign;
import lsieun.drawing.canvas.TextDirection;
import lsieun.drawing.theme.table.OneLineTable;
import lsieun.drawing.theme.text.PlainTextWithNote;
import lsieun.drawing.theme.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class ASMSample {
    public static OneLineTable getOneLineTable() {
        String[][] matrix = {
                {"0", "Interpreter", "Value", "Range"},
                {"1", "BasicInterpreter", "BasicValue", "7"},
                {"2", "BasicVerifier", "BasicValue", "7"},
                {"3", "SimpleVerifier", "BasicValue", "N"},
                {"4", "SourceInterpreter", "SourceValue", "N"},
        };
        return new OneLineTable(matrix, TextAlign.CENTER);
    }

    public static PlainTextWithNote getPlainTextWithNote() {
        List<String> lines = new ArrayList<>();
        lines.add("Analyzer<BasicValue> analyzer = new Analyzer<>(new BasicInterpreter());");
        lines.add("Frame<BasicValue>[] frames = analyzer.analyze(owner, mn);");

        PlainTextWithNote text = new PlainTextWithNote(lines);
        text.addNote(0, 2, TextDirection.UP, 2, "Analyzer");
        text.addNote(0, 14, TextDirection.UP, 1, "Value");
        text.addNote(0, 56, TextDirection.UP, 1, "Interpreter");
        text.addNote(1, 2, TextDirection.DOWN, 2, "Frame");
        text.addNote(1, 11, TextDirection.DOWN, 1, "Value");
        text.addNote(1, 29, 27, TextDirection.DOWN, 1, "invoke analyze method");
        return text;
    }

    public static Tree getTreeOfWhatASMCanDo() {
        Tree tree = Tree.valueOf("Java ASM");

        Tree child1 = Tree.valueOf("analysis");
        Tree child2 = Tree.valueOf("generation");
        Tree child3 = Tree.valueOf("transformation");
        tree.addChild(child1);
        tree.addChild(child2);
        tree.addChild(child3);

        Tree child11 = Tree.valueOf("find potential bugs");
        Tree child12 = Tree.valueOf("detect unused code");
        Tree child13 = Tree.valueOf("reverse engineer code");
        child1.addChild(child11);
        child1.addChild(child12);
        child1.addChild(child13);

        Tree child31 = Tree.valueOf("optimize programs");
        Tree child32 = Tree.valueOf("obfuscate programs");
        Tree child33 = Tree.valueOf("insert performance monitoring code");
        child3.addChild(child31);
        child3.addChild(child32);
        child3.addChild(child33);

        return tree;
    }

    public static Tree getTreeOfASMComponents() {
        Tree tree = Tree.valueOf("Java ASM");

        Tree child1 = Tree.valueOf("Core API");
        Tree child2 = Tree.valueOf("Tree API");
        tree.addChild(child1);
        tree.addChild(child2);

        Tree child11 = Tree.valueOf("asm.jar");
        Tree child12 = Tree.valueOf("asm-util.jar");
        Tree child13 = Tree.valueOf("asm-commons.jar");
        child1.addChild(child11);
        child1.addChild(child12);
        child1.addChild(child13);

        Tree child21 = Tree.valueOf("asm-tree.jar");
        Tree child22 = Tree.valueOf("asm-analysis.jar");
        child2.addChild(child21);
        child2.addChild(child22);

        return tree;
    }
}
