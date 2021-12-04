package run.sample;

import lsieun.drawing.canvas.Box;
import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.TextAlign;
import lsieun.drawing.theme.shape.RectangleWithText;
import lsieun.drawing.theme.tree.Tree;

public class JavaAgentSample {

    public static Tree getTreeOfJavaAgentJar() {
        Tree root = Tree.valueOf("TheAgent.jar");

        Tree child1 = Tree.valueOf("META-INF/MANIFEST.MF");
        Tree child2 = Tree.valueOf("Agent Class: LoadTimeAgent.class");
        Tree child3 = Tree.valueOf("ClassFileTransformer: SimpleClassFileTransformer.class");
        root.addChild(child1);
        root.addChild(child2);
        root.addChild(child3);

        return root;
    }

    public static void main(String[] args) {
        Canvas canvas = new Canvas();

        int col1 = 5;
        int col2 = 26;
        int col3 = 40;
        int col4 = 61;
        int col5 = 90;

        int row1 = 2;
        int row2 = row1 + 2;
        int row3 = 8;
        int row4 = row3 + 2;

        // rectangle: java file
        RectangleWithText java_file_rectangle = RectangleWithText.valueOf(20, 1, "HelloWorld.java", TextAlign.CENTER);
        canvas.draw(row1, col1, java_file_rectangle);

        // rectangle: class file
        RectangleWithText class_file_rectangle = RectangleWithText.valueOf(20, 1, "HelloWorld.class", TextAlign.CENTER);
        canvas.draw(row1, col3, class_file_rectangle);

        // rectangle: transformed class file
        RectangleWithText transformed_class_file_rectangle = RectangleWithText.valueOf(20, 1, "HelloWorld.class", TextAlign.CENTER);
        canvas.draw(row3, col3, transformed_class_file_rectangle);

        // rectangle: JVM
        RectangleWithText jvm_rectangle = RectangleWithText.valueOf(20, row4 - row1 - 1, "JVM", TextAlign.CENTER);
        canvas.draw(row1, col5, jvm_rectangle);

        // line: compile
        canvas.moveTo(row1 + 1, col2);
        canvas.drawPixel(Box.VERTICAL_AND_RIGHT);
        canvas.right(1);
        canvas.drawHorizontalLine(col3 - col2 - 1).drawPixel(Box.VERTICAL_AND_LEFT);
        canvas.moveTo(2, 30);
        canvas.drawText("compile");

        // line: load original bytecode
        canvas.moveTo(row1 + 1, col4);
        canvas.drawPixel(Box.VERTICAL_AND_RIGHT);
        canvas.right(1);
        canvas.drawHorizontalLine(col5 - col4 - 1).drawPixel(Box.VERTICAL_AND_LEFT);
        canvas.moveTo(row1, col4 + 2);
        canvas.drawText("load original bytecode");

        // line: load transformed bytecode
        canvas.moveTo(row3 + 1, col4);
        canvas.drawPixel(Box.VERTICAL_AND_RIGHT);
        canvas.right(1);
        canvas.drawHorizontalLine(col5 - col4 - 1).drawPixel(Box.VERTICAL_AND_LEFT);
        canvas.moveTo(row3, col4 + 2);
        canvas.drawText("load transformed bytecode");

        // line: bytecode transformation
        canvas.moveTo(row2, (col3 + col4) / 2);
        canvas.drawPixel(Box.DOWN_AND_HORIZONTAL);
        canvas.down(1);
        canvas.drawVerticalLine(row3 - row2 - 1).drawPixel(Box.UP_AND_HORIZONTAL);
        canvas.moveTo(row2 + 2, (col3 + col4) / 2 + 1);
        canvas.drawText("bytecode transformation");

        // text: Instrumentation
        canvas.moveTo(row4 + 1, col3);
        canvas.drawText("Instrumentation");

        System.out.println(canvas);
    }
}
