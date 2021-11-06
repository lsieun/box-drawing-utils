# box-drawing-utils

:sunny:

Use [box-drawing characters](https://unicode-table.com/en/blocks/box-drawing/) to draw different graphs.

```text
git clone https://github.com/lsieun/box-drawing-utils
```

## Examples

### text

```java
public class TextRun {
    public static void main(String[] args) {
        // 第一步，创建TextCanvas对象
        TextCanvas canvas = new TextCanvas();

        // 第二步，文本信息

        // 单选文本
        canvas.drawText(2, 0, "You know some birds are not meant to be caged, their feathers are just too bright.");

        // 多行文本
        List<String> textList = new ArrayList<>();
        textList.add("I love three things in the world: the sun, the moon, and you.");
        textList.add("The sun for the day, the moon for the night, and you forever.");
        canvas.drawMultiLineText(4, 5, textList);

        // 多行文本+边框
        canvas.drawMultiLineTextWithBorder(7, 10, textList);

        // 第三步，打印输出
        List<String> lines = canvas.getLines();
        lines.forEach(System.out::println);
    }
}
```

输出结果：

```text
You know some birds are not meant to be caged, their feathers are just too bright.
 
     I love three things in the world: the sun, the moon, and you.
     The sun for the day, the moon for the night, and you forever.
 
          ┌───────────────────────────────────────────────────────────────┐
          │ I love three things in the world: the sun, the moon, and you. │
          │ The sun for the day, the moon for the night, and you forever. │
          └───────────────────────────────────────────────────────────────┘
```

```java
public class TextWithNoteRun {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        lines.add("Analyzer<BasicValue> analyzer = new Analyzer<>(new BasicInterpreter());");
        lines.add("Frame<BasicValue>[] frames = analyzer.analyze(owner, mn);");

        TextWithNote text = new TextWithNote(lines);
        text.addNote(0, 2, TextDirection.UP, 2, "Analyzer");
        text.addNote(0, 14, TextDirection.UP, 1, "Value");
        text.addNote(0, 56, TextDirection.UP, 1, "Interpreter");
        text.addNote(1, 2, TextDirection.DOWN, 2, "Frame");
        text.addNote(1, 11, TextDirection.DOWN, 1, "Value");
        text.draw();
    }
}
```

输出结果：

```text
  ┌─── Analyzer
  │           ┌─── Value                                ┌─── Interpreter
  │           │                                         │
Analyzer<BasicValue> analyzer = new Analyzer<>(new BasicInterpreter());
Frame<BasicValue>[] frames = analyzer.analyze(owner, mn);
  │        │
  │        └─── Value
  └─── Frame
```

### lines

```java
public class StateLineRun {
    public static void main(String[] args) {
        TextStateCanvas canvas = new TextStateCanvas();

        canvas.moveTo(10, 20);
        canvas.turnUp().drawLine(3)
                .switchRight().drawLine(10)
                .switchDown().drawLine(5)
                .switchLeft().drawLine(20)
                .switchUp().drawLine(7)
                .switchRight().drawLine(30);

        canvas.moveTo(20, 30);
        canvas.turnUp().drawLine(3)
                .switchLeft().drawLine(10)
                .switchDown().drawLine(5)
                .switchRight().drawLine(20)
                .switchUp().drawLine(7)
                .switchLeft().drawLine(30);

        canvas.getLines().forEach(System.out::println);
    }
}
```

输出结果：

```text
          ┌──────────────────────────────
          │
          │         ┌──────────┐
          │         │          │
          │         │          │
          │         │          │
          │                    │
          │                    │
          └────────────────────┘
 
          ──────────────────────────────┐
                                        │
                   ┌──────────┐         │
                   │          │         │
                   │          │         │
                   │          │         │
                   │                    │
                   │                    │
                   └────────────────────┘
```

### table

```java
public class OneLineTableRun {
    public static void main(String[] args) {
        String[][] matrix = getSample();
        OneLineTable table = new OneLineTable(matrix, TextAlign.CENTER);
        table.draw();
    }

    @SuppressWarnings("UnnecessaryLocalVariable")
    public static String[][] getSample() {
        String[][] matrix = {
                {"0", "Interpreter", "Value", "Range"},
                {"1", "BasicInterpreter", "BasicValue", "7"},
                {"2", "BasicVerifier", "BasicValue", "7"},
                {"3", "SimpleVerifier", "BasicValue", "N"},
                {"4", "SourceInterpreter", "SourceValue", "N"},
        };
        return matrix;
    }
}
```

输出结果：

```text
┌───┬───────────────────┬─────────────┬───────┐
│ 0 │    Interpreter    │    Value    │ Range │
├───┼───────────────────┼─────────────┼───────┤
│ 1 │ BasicInterpreter  │ BasicValue  │   7   │
├───┼───────────────────┼─────────────┼───────┤
│ 2 │   BasicVerifier   │ BasicValue  │   7   │
├───┼───────────────────┼─────────────┼───────┤
│ 3 │  SimpleVerifier   │ BasicValue  │   N   │
├───┼───────────────────┼─────────────┼───────┤
│ 4 │ SourceInterpreter │ SourceValue │   N   │
└───┴───────────────────┴─────────────┴───────┘
```

### tree

```java
public class TreeRun {
    public static void main(String[] args) {
        Tree tree1 = getSample1();
        tree1.draw();

        Tree tree2 = getSample2();
        tree2.draw();
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
```

输出结果：

```text
                                   ┌─── find potential bugs
                                   │
            ┌─── analysis ─────────┼─── detect unused code
            │                      │
            │                      └─── reverse engineer code
            │
Java ASM ───┼─── generation
            │
            │                      ┌─── optimize programs
            │                      │
            └─── transformation ───┼─── obfuscate programs
                                   │
                                   └─── insert performance monitoring code
```

```text
                             ┌─── asm.jar
                             │
            ┌─── Core API ───┼─── asm-util.jar
            │                │
            │                └─── asm-commons.jar
Java ASM ───┤
            │
            │                ┌─── asm-tree.jar
            └─── Tree API ───┤
                             └─── asm-analysis.jar
```
