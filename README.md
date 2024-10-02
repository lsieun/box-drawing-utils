# box-drawing-utils

:sunny:

## Intro

Use [box-drawing characters](https://unicode-table.com/en/blocks/box-drawing/) to draw different graphs.

## Source Code

Download Source Code:

```text
git clone https://github.com/lsieun/box-drawing-utils
```

Maven compile:

```text
mvn clean install -DskipTests
```

完整引用：

- [ ] box-drawing-sample
- [ ] learn-java-io

代码复制：

- [ ] learn-byte-buddy

## Examples

### Basic Usage

```java
import lsieun.drawing.canvas.Canvas;

public class A_BasicCanvas {
    public static void main(String[] args) {
        // 1. create Canvas
        Canvas canvas = new Canvas();

        // 2. move to a certain position, and draw something
        // (1) draw point
        canvas.moveTo(0, 3).drawPixel("@");
        canvas.moveTo(1, 6).drawPixel("#");
        canvas.moveTo(2, 9).drawPixel("$");

        // (2) draw line
        canvas.moveTo(3, 3).drawHorizontalLine(20);
        canvas.moveTo(4, 10).drawVerticalLine(-5);
        canvas.moveTo(4, 11).drawText("hello world");

        // (3) draw polygon
        canvas.moveTo(5, 2).drawRectangle(20, 3);

        // 3. print
        canvas.printPixels();
        System.out.println(canvas);
    }
}
```

Output：

```text
   @      │
      #   │
         $│
   ───────┼────────────
          │hello world
  ┌────────────────────┐
  │                    │
  │                    │
  │                    │
  └────────────────────┘
```

### drawable objects

```java
import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;

public class B_Drawable {
    public static void main(String[] args) {
        // 1. graph
        Drawable graph = Sample.getPlainTextWithNote();

        // 2. draw
        Canvas canvas = new Canvas();
        canvas.draw(3, 10, graph);

        // 3. print
        canvas.printPixels();
        System.out.println(canvas);
    }
}
```

text：

```text
  ┌─── Analyzer
  │           ┌─── Value                                ┌─── Interpreter
  │           │                                         │
Analyzer<BasicValue> analyzer = new Analyzer<>(new BasicInterpreter());
Frame<BasicValue>[] frames = analyzer.analyze(owner, mn);
  │        │                 └────────────┬────────────┘
  │        └─── Value                     └─── invoke analyze method
  └─── Frame
```

continuous line:

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
```

table：

```text
┌───────┬───────────────────────┬─────────────────┬───────────┐
│   0   │      Interpreter      │      Value      │   Range   │
├───────┼───────────────────────┼─────────────────┼───────────┤
│   1   │   BasicInterpreter    │   BasicValue    │     7     │
├───────┼───────────────────────┼─────────────────┼───────────┤
│   2   │     BasicVerifier     │   BasicValue    │     7     │
├───────┼───────────────────────┼─────────────────┼───────────┤
│   3   │    SimpleVerifier     │   BasicValue    │     N     │
├───────┼───────────────────────┼─────────────────┼───────────┤
│   4   │   SourceInterpreter   │   SourceValue   │     N     │
└───────┴───────────────────────┴─────────────────┴───────────┘
```

Markdown table:

```text
│ Year │ Algorithm │ Bit Length │
│------│-----------│------------│
│ 1992 │ MD5       │ 128        │
│ 1993 │ SHA1      │ 160        │
│ 2001 │ SHA256    │ 256        │
│ 2001 │ SHA384    │ 384        │
│ 2001 │ SHA512    │ 512        │
```

tree：

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

directory tree:

```text
IDEA
├─── bin
│    ├─── idea.bat
│    ├─── idea.exe
│    └─── idea.exe.vmoptions
├─── help
│    ├─── ReferenceCard.pdf
│    └─── ReferenceCardForMac.pdf
├─── jbr
├─── lib
│    ├─── idea.jar
│    └─── idea_rt.jar
├─── license
├─── plugins
│    ├─── java
│    └─── java-ide-customization
└─── redist
```

binary tree:

```text
                      ■
          0 ┌─────────┴────┐ 1
            ■              ▧
     0 ┌────┴────┐ 1       └────┐ 1
       ▨         □              □
0 ┌────┘         left-right     right-right
  □
  left-left-left
```

byte:

```text
+--------+---+========+=============================+
│76543210│   │        │this is a multiple-bytes data│
+--------+---+========+=============================+
```

## License

This project is licensed under the MIT License.
See the [LICENSE](./LICENSE) file for the full license text.
