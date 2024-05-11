package lsieun.drawing.theme.text;

import lsieun.drawing.utils.StringUtils;

import java.util.Objects;

public class MultiLineText implements Text {
    private final String[] array;

    public MultiLineText(String[] array) {
        Objects.requireNonNull(array);
        this.array = array;
    }

    @Override
    public int getTotalRows() {
        return array.length;
    }

    @Override
    public int getMaxColWidth() {
        return StringUtils.maxLength(array);
    }

    @Override
    public String getLine(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= array.length) {
            throw new RuntimeException("Invalid rowIndex: " + rowIndex);
        }
        return array[rowIndex];
    }
}
