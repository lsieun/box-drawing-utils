package lsieun.drawing.canvas;

import lsieun.utils.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Formatter;
import java.util.List;

public class Canvas {
    private int row;
    private int col;
    public final List<TextPixel> pixelList = new ArrayList<>();

    // region move
    public Canvas moveTo(int row, int col) {
        this.row = row;
        this.col = col;
        return this;
    }

    public Canvas up(int count) {
        this.row -= count;
        return this;
    }

    public Canvas down(int count) {
        this.row += count;
        return this;
    }

    public Canvas left(int count) {
        this.col -= count;
        return this;
    }

    public Canvas right(int count) {
        this.col += count;
        return this;
    }

    public void rectifyPosition() {
        int minRow = 0;
        int minCol = 0;
        for (TextPixel pixel : pixelList) {
            int row = pixel.row;
            if (row < minRow) {
                minRow = row;
            }
            int col = pixel.col;
            if (col < minCol) {
                minCol = col;
            }
        }

        for (TextPixel pixel : pixelList) {
            pixel.row -= minRow;
            pixel.col -= minCol;
        }
    }

    public void updatePosition(int startRow, int startCol) {
        for (TextPixel pixel : pixelList) {
            pixel.row += startRow;
            pixel.col += startCol;
        }
    }
    // endregion

    // region Point
    public void drawPixel(BoxDrawing value) {
        TextPixel pixel = findPixel(row, col);
        if (pixel != null) {
            if (BoxDrawing.isValid(pixel.value)) {
                pixel.value = BoxDrawing.merge(pixel.value, value.val).val;
            }
            else {
                pixel.value = value.val;
            }
        }
        else {
            pixel = TextPixel.valueOf(row, col, value.val);
            pixelList.add(pixel);
            Collections.sort(pixelList);
        }
    }

    public void drawPixel(String value) {
        String firstChar = value.substring(0, 1);
        TextPixel pixel = findPixel(row, col);
        if (pixel != null) {
            pixel.value = firstChar;
        }
        else {
            pixel = TextPixel.valueOf(row, col, firstChar);
            pixelList.add(pixel);
            Collections.sort(pixelList);
        }
    }

    public Canvas switchDirection(TextDirection from, TextDirection to) {
        if (from == TextDirection.UP && to == TextDirection.LEFT) {
            drawPixel(BoxDrawing.LIGHT_UP_AND_LEFT);
            left(1);
        }
        else if (from == TextDirection.UP && to == TextDirection.RIGHT) {
            drawPixel(BoxDrawing.LIGHT_UP_AND_RIGHT);
            right(1);
        }
        else if (from == TextDirection.RIGHT && to == TextDirection.UP) {
            drawPixel(BoxDrawing.LIGHT_UP_AND_RIGHT);
            up(1);
        }
        else if (from == TextDirection.RIGHT && to == TextDirection.DOWN) {
            drawPixel(BoxDrawing.LIGHT_DOWN_AND_RIGHT);
            down(1);
        }
        else if (from == TextDirection.DOWN && to == TextDirection.RIGHT) {
            drawPixel(BoxDrawing.LIGHT_DOWN_AND_RIGHT);
            right(1);
        }
        else if (from == TextDirection.DOWN && to == TextDirection.LEFT) {
            drawPixel(BoxDrawing.LIGHT_DOWN_AND_LEFT);
            left(1);
        }
        else if (from == TextDirection.LEFT && to == TextDirection.DOWN) {
            drawPixel(BoxDrawing.LIGHT_DOWN_AND_LEFT);
            down(1);
        }
        else if (from == TextDirection.LEFT && to == TextDirection.UP) {
            drawPixel(BoxDrawing.LIGHT_UP_AND_LEFT);
            up(1);
        }
        else {
            assert false : "impossible here";
        }

        return this;
    }
    // endregion

    // region Line
    public Canvas drawHorizontalLine(int num) {
        int step = num > 0 ? 1 : -1;
        int count = Math.abs(num);
        for (int i = 0; i < count; i++) {
            drawPixel(BoxDrawing.LIGHT_HORIZONTAL);
            col += step;
        }
        return this;
    }

    public Canvas drawVerticalLine(int num) {
        int step = num > 0 ? 1 : -1;
        int count = Math.abs(num);
        for (int i = 0; i < count; i++) {
            drawPixel(BoxDrawing.LIGHT_VERTICAL);
            row += step;
        }
        return this;
    }

    public void drawText(String text) {
        int length = text.length();
        for (int i = 0; i < length; i++) {
            String ch = text.substring(i, i + 1);
            drawPixel(ch);
            col++;
        }
    }
    // endregion

    // region Plane
    public void drawRectangle(int width, int height) {
        // left top
        drawPixel(BoxDrawing.LIGHT_DOWN_AND_RIGHT);
        right(1);
        for (int i = 0; i < width; i++) {
            drawPixel(BoxDrawing.LIGHT_HORIZONTAL);
            right(1);
        }

        // right top
        drawPixel(BoxDrawing.LIGHT_DOWN_AND_LEFT);
        down(1);
        for (int i = 0; i < height; i++) {
            drawPixel(BoxDrawing.LIGHT_VERTICAL);
            down(1);
        }

        // right bottom
        drawPixel(BoxDrawing.LIGHT_UP_AND_LEFT);
        left(1);
        for (int i = 0; i < width; i++) {
            drawPixel(BoxDrawing.LIGHT_HORIZONTAL);
            left(1);
        }

        // right left
        drawPixel(BoxDrawing.LIGHT_UP_AND_RIGHT);
        up(1);
        for (int i = 0; i < height; i++) {
            drawPixel(BoxDrawing.LIGHT_VERTICAL);
            up(1);
        }
    }

    public void drawTable(int[] rowHeightArray, int[] colWidthArray) {
        int startRow = row;
        int startCol = col;

        int rowCount = rowHeightArray.length;
        int colCount = colWidthArray.length;

        int totalWidth = colCount - 1;
        for (int width : colWidthArray) {
            totalWidth += width;
        }

        int totalHeight = rowCount - 1;
        for (int height : rowHeightArray) {
            totalHeight += height;
        }

        // outer border
        drawRectangle(totalWidth, totalHeight);

        // inner horizontal border
        moveTo(startRow, startCol);
        for (int i = 0; i < colCount - 1; i++) {
            int width = colWidthArray[i];
            right(width + 1);
            drawPixel(BoxDrawing.LIGHT_DOWN_AND_HORIZONTAL);
            down(1);
            drawVerticalLine(totalHeight);
            drawPixel(BoxDrawing.LIGHT_UP_AND_HORIZONTAL);
            up(totalHeight + 1);
        }

        // inner vertical border
        moveTo(startRow, startCol);
        for (int i = 0; i < rowCount - 1; i++) {
            int height = rowHeightArray[i];
            down(height + 1);
            drawPixel(BoxDrawing.LIGHT_VERTICAL_AND_RIGHT);
            right(1);
            drawHorizontalLine(totalWidth);
            drawPixel(BoxDrawing.LIGHT_VERTICAL_AND_LEFT);
            left(totalWidth + 1);
        }

    }
    // endregion

    public void printPixels() {
        Collections.sort(pixelList);
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        for (TextPixel pixel : pixelList) {
            fm.format("[DEBUG] %s%n", pixel);
        }
        System.out.println(sb);
    }

    public List<String> getLines() {
        List<String> lines = new ArrayList<>();
        Collections.sort(pixelList);

        int maxRow = findMaxRow(pixelList);
        for (int row = 0; row <= maxRow; row++) {
            List<TextPixel> rowList = findRowItems(row);
            int maxCol = findMaxCol(rowList);
            int i = 0;
            StringBuilder sb = new StringBuilder();
            for (int col = 0; col <= maxCol; col++) {

                TextPixel item = null;
                if (i < rowList.size()) {
                    item = rowList.get(i);
                }

                if (item != null && item.col == col) {
                    sb.append(item.value);
                    i++;
                }
                else {
                    sb.append(BoxDrawing.SPACE.val);
                }
            }
            String line = sb.toString();
            lines.add(line);
        }
        return lines;
    }

    @Override
    public String toString() {
        List<String> lines = getLines();
        return StringUtils.list2str(lines);
    }

    public void draw(int row, int col, Drawable drawable) {
        drawable.draw(this, row, col);
    }

    // region private methods
    private TextPixel findPixel(int row, int col) {
        for (TextPixel item : pixelList) {
            if (item.row == row && item.col == col) {
                return item;
            }
        }
        return null;
    }

    private int findMaxRow(List<TextPixel> list) {
        int maxRow = 0;
        for (TextPixel item : list) {
            if (item.row > maxRow) {
                maxRow = item.row;
            }
        }
        return maxRow;
    }

    private int findMaxCol(List<TextPixel> list) {
        int maxCol = 0;
        for (TextPixel item : list) {
            if (item.col > maxCol) {
                maxCol = item.col;
            }
        }
        return maxCol;
    }

    private List<TextPixel> findRowItems(int row) {
        List<TextPixel> list = new ArrayList<>();
        for (TextPixel item : pixelList) {
            if (item.col < 0) {
                continue;
            }
            if (item.row == row) {
                list.add(item);
            }
        }
        return list;
    }
    // endregion
}
