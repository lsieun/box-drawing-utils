package lsieun.drawing.theme.miscellaneous;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.canvas.TextAlign;
import lsieun.drawing.canvas.VerticalAlign;
import lsieun.drawing.theme.shape.rect.FullRectangle;
import lsieun.drawing.utils.StringUtils;

import java.util.Arrays;
import java.util.Collections;

public class MainSub implements Drawable {
    private static final int PADDING_WIDTH = 0;
    private static final int PADDING_HEIGHT = 0;
    private static final int BORDER_WIDTH = 1;
    private static final int BORDER_HEIGHT = 1;

    private final String mainName;
    private final String[] mainLines;
    private final String[][][] subCube;
    private final int subRowSpace;
    private final int subColSpace;


    public MainSub(String mainName, String[] mainLines, String[][][] subCube, int subRowSpace, int subColSpace) {
        this.mainName = mainName;
        this.mainLines = mainLines;
        this.subCube = subCube;
        this.subRowSpace = subRowSpace;
        this.subColSpace = subColSpace;
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        int subTotalRows = subCube.length;
        int subTotalCols = subCube[0].length;

        int subContentWidth = StringUtils.maxLength(subCube);
        int subContentHeight = getSubHeight(subCube);
        int subWidth = subContentWidth + 2 * (PADDING_WIDTH + 1);
        int subHeight = subContentHeight + 2 * (PADDING_HEIGHT + 1);

        FullRectangle[][] subRectMatrix = new FullRectangle[subTotalRows][subTotalCols];

        for (int i = 0; i < subTotalRows; i++) {
            for (int j = 0; j < subTotalCols; j++) {
                String[] lines = subCube[i][j];
                if (lines == null) {
                    continue;
                }
                if(StringUtils.isAllNull(lines)) {
                    continue;
                }
                subRectMatrix[i][j] = getRectangle(subContentWidth, subContentHeight, lines);
            }
        }


        // main rectangle
        int mainContentWidth = StringUtils.maxLength(mainLines);
        if (mainName.length() > mainContentWidth) {
            mainContentWidth = mainName.length();
        }
        int mainContentHeight = subTotalRows * (subRowSpace + subHeight) - subRowSpace - 2 * BORDER_HEIGHT;
        int mainWidth = mainContentWidth + 2 * (PADDING_WIDTH + 1);
        int mainHeight = mainContentHeight + 2 * (PADDING_HEIGHT + 1);
        String[] mainFullLines = new String[mainHeight];
        Arrays.fill(mainFullLines, "");
        mainFullLines[0] = mainName;
        int midIndex = subHeight / 2;
        for (int i = 0; i < mainLines.length; i++) {
            String str = mainLines[i];
            if (str == null) {
                continue;
            }
            int index = midIndex - BORDER_HEIGHT + i * (subRowSpace + subHeight);
            mainFullLines[index] = str;
        }
        FullRectangle mainRectangle = getRectangle(mainContentWidth, mainContentHeight, mainFullLines);
        canvas.draw(startRow, startCol, mainRectangle);


        // sub rectangle matrix
        FullRectangle emptyRectangle = getEmptyRectangle(subContentHeight);
        for (int i = 0; i < subTotalRows; i++) {
            int row = startRow + i * (subRowSpace + subHeight);

            FullRectangle rect0 = subRectMatrix[i][0];
            if (rect0 == null) {
                continue;
            }

            for (int j = 0; j < subTotalCols; j++) {
                int col = startCol + mainWidth + j * (subColSpace + subWidth);

                FullRectangle rect = subRectMatrix[i][j];

                if (rect != null) {
                    int midRow = row + midIndex;
                    canvas.moveTo(midRow, col);
                    canvas.drawHorizontalLine(subColSpace);

                    canvas.draw(row, col + subColSpace, rect);
                }
            }
        }

    }

    private static FullRectangle getRectangle(int contentWidth, int contentHeight, String[] lines) {
        return new FullRectangle(
                contentWidth, contentHeight,
                PADDING_WIDTH, PADDING_HEIGHT,
                Arrays.asList(lines),
                TextAlign.CENTER, VerticalAlign.MIDDLE, false
        );
    }

    private static FullRectangle getEmptyRectangle(int contentHeight) {
        return new FullRectangle(
                0, contentHeight,
                PADDING_WIDTH, PADDING_HEIGHT,
                Collections.emptyList(),
                TextAlign.CENTER, VerticalAlign.TOP, false
        );
    }

    private static int getSubHeight(String[][][] subCube) {
        int max = 0;
        int totalRows = subCube.length;
        int totalCols = subCube[0].length;
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                String[] lines = subCube[i][j];
                if (lines == null) {
                    continue;
                }

                int length = lines.length;
                if (length > max) {
                    max = length;
                }
            }
        }
        return max;
    }
}
