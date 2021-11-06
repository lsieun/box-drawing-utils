package run;

import lsieun.canvas.TextDirection;
import lsieun.drawing.text.TextWithNote;

import java.util.ArrayList;
import java.util.List;

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
