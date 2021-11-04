package run;

import lsieun.box.drawing.utils.Tree;
import lsieun.box.drawing.utils.TreeTextGraph;
import lsieun.box.drawing.utils.TreeTextGraphUtils;

public class TreeRun {
    public static void main(String[] args) {
        Tree tree1 = getSample1();
        draw(tree1);

        Tree tree2 = getSample2();
        draw(tree2);
    }

    public static void draw(Tree tree) {
        TreeTextGraph graph = TreeTextGraphUtils.createGraphFromTree(tree);
        TreeTextGraphUtils.updatePosition(graph);
        TreeTextGraphUtils.print(graph);
        TreeTextGraphUtils.draw(graph);
    }

    public static Tree getSample1() {
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

    public static Tree getSample2() {
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
