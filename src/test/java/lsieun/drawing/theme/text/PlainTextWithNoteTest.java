package lsieun.drawing.theme.text;

import lsieun.drawing.canvas.TextDirection;
import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PlainTextWithNoteTest {
    @Test
    void getPlainTextWithNote() {
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


        CanvasUtils.print(3, 0, text);
    }
}