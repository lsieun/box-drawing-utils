package lsieun.drawing.theme.shape.rect;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.TextAlign;
import lsieun.drawing.canvas.VerticalAlign;
import lsieun.drawing.theme.shape.AbstractShape;
import lsieun.drawing.utils.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import static lsieun.drawing.utils.NumberUtils.getOdd;

public class FullRectangle extends AbstractShape implements Rectangle {

    public final int contentWidth;
    public final int contentHeight;
    public final int paddingWidth;
    public final int paddingHeight;

    public final List<String> lines;
    public final TextAlign align;

    public final VerticalAlign verticalAlign;

    public FullRectangle(int contentWidth, int contentHeight) {
        this(contentWidth, contentHeight, 0, 0);
    }

    public FullRectangle(int contentWidth, String text) {
        this(contentWidth, 1, 0, 0, Collections.singletonList(text), TextAlign.CENTER, VerticalAlign.MIDDLE);
    }

    public FullRectangle(int contentWidth, int paddingWidth, int paddingHeight, String text, TextAlign align) {
        this(contentWidth, 1, paddingWidth, paddingHeight, Collections.singletonList(text), align, VerticalAlign.MIDDLE);
    }

    public FullRectangle(int contentWidth, List<String> lines) {
        this(contentWidth, lines.size(), 0, 0, lines, TextAlign.CENTER, VerticalAlign.MIDDLE);
    }

    public FullRectangle(
            int contentWidth, int contentHeight, int paddingWidth, int paddingHeight) {
        this(contentWidth, contentHeight, paddingWidth, paddingHeight, Collections.emptyList(), TextAlign.CENTER, VerticalAlign.MIDDLE, true);
    }

    public FullRectangle(
            int contentWidth, int contentHeight, int paddingWidth, int paddingHeight,
            List<String> lines, TextAlign align, VerticalAlign verticalAlign) {
        this(contentWidth, contentHeight, paddingWidth, paddingHeight, lines, align, verticalAlign, true);
    }

    public FullRectangle(
            int contentWidth, int contentHeight, int paddingWidth, int paddingHeight,
            List<String> lines, TextAlign align, VerticalAlign verticalAlign, boolean requiresOdd) {
        Objects.requireNonNull(lines);
        contentWidth = contentWidth == 0 ? StringUtils.maxLength(lines) : contentWidth;
        contentHeight = contentHeight == 0 ? lines.size() : contentHeight;
        this.contentWidth = requiresOdd ? getOdd(contentWidth) : contentWidth;
        this.contentHeight = requiresOdd ? getOdd(contentHeight) : contentHeight;
        this.paddingHeight = paddingHeight;
        this.paddingWidth = paddingWidth;
        this.lines = lines;
        this.align = align;
        this.verticalAlign = verticalAlign;
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        setStartRow(startRow);
        setStartCol(startCol);

        int width = contentWidth + 2 * paddingWidth;
        int height = contentHeight + 2 * paddingHeight;

        canvas.moveTo(startRow, startCol);
        canvas.drawRectangle(width, height);

        int count = Math.min(contentHeight, lines.size());
        for (int i = 0; i < count; i++) {
            int row = getRowWithAlign(i);
            int col = getCol(0);
            canvas.moveTo(row, col);
            canvas.drawText(contentWidth, lines.get(i), align);
        }
    }

    public int getRowWithAlign(int rowIndex) {
        switch (verticalAlign) {
            case MIDDLE: {
                int offset = contentHeight > lines.size() ? (contentHeight - lines.size()) / 2 : 0;
                return getRow(rowIndex) + offset;
            }
            case BOTTOM: {
                int offset = contentHeight > lines.size() ? contentHeight - lines.size() : 0;
                return getRow(rowIndex) + offset;
            }
            case TOP:
            default: {
                return getRow(rowIndex);
            }
        }
    }


    @Override
    public int getContentWidth() {
        return contentWidth;
    }

    @Override
    public int getContentHeight() {
        return contentHeight;
    }

    @Override
    public int getPaddingWidth() {
        return paddingWidth;
    }

    @Override
    public int getPaddingHeight() {
        return paddingHeight;
    }
}
