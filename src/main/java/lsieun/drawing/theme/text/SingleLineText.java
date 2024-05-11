package lsieun.drawing.theme.text;

import java.util.Objects;

public class SingleLineText implements Text {
    private final String line;

    public SingleLineText(String line) {
        Objects.requireNonNull(line);
        this.line = line;
    }

    @Override
    public int getTotalRows() {
        return 1;
    }

    @Override
    public int getMaxColWidth() {
        return 0;
    }

    @Override
    public String getLine(int rowIndex) {
        if (rowIndex == 0) {
            return line;
        }
        return null;
    }
}
