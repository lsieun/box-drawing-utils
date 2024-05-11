package lsieun.drawing.theme.miscellaneous;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.canvas.TextAlign;
import lsieun.drawing.theme.shape.rect.FullRectangle;
import lsieun.drawing.theme.text.Text;
import lsieun.drawing.utils.StringUtils;

import java.util.Arrays;
import java.util.Collections;

public class MainSub implements Drawable {
    private static final int PADDING_WIDTH = 0;
    private static final int PADDING_HEIGHT = 0;
    private static final int BORDER_WIDTH = 1;
    private static final int BORDER_HEIGHT = 1;

    private final String mainName;
    private final Text mainText;
    private final Text[][] subMatrix;
    private final int subRowSpace;
    private final int subColSpace;


    public MainSub(String mainName, Text mainText, Text[][] subMatrix, int subRowSpace, int subColSpace) {
        this.mainName = mainName;
        this.mainText = mainText;
        this.subMatrix = subMatrix;
        this.subRowSpace = subRowSpace;
        this.subColSpace = subColSpace;
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {
        int subTotalRows = subMatrix.length;
        int subTotalCols = subMatrix[0].length;

        int subContentWidth = StringUtils.maxLength(subMatrix);
        int subContentHeight = getSubHeight(subMatrix);
        int subWidth = subContentWidth + 2 * (PADDING_WIDTH + 1);
        int subHeight = subContentHeight + 2 * (PADDING_HEIGHT + 1);

        FullRectangle[][] subRectMatrix = new FullRectangle[subTotalRows][subTotalCols];

        for (int i = 0; i < subTotalRows; i++) {
            for (int j = 0; j < subTotalCols; j++) {
                Text text = subMatrix[i][j];
                if (text == null) {
                    continue;
                }
                subRectMatrix[i][j] = getRectangle(subContentWidth, subContentHeight, text);
            }
        }


        // main rectangle
        int mainContentWidth = StringUtils.maxLength(mainText);
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
        for (int i = 0; i < mainText.getTotalRows(); i++) {
            String str = mainText.getLine(i);
            if (str == null) {
                continue;
            }
            int index = midIndex - BORDER_HEIGHT + i * (subRowSpace + subHeight);
            mainFullLines[index] = str;
        }
        FullRectangle mainRectangle = getRectangle(mainContentWidth, mainContentHeight, Text.of(mainFullLines));
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

    private static FullRectangle getRectangle(int contentWidth, int contentHeight, Text text) {
        return FullRectangle.of(
                contentWidth, contentHeight,
                PADDING_WIDTH, PADDING_HEIGHT,
                text,
                TextAlign.CENTER_MIDDLE,
                false
        );
    }

    private static FullRectangle getEmptyRectangle(int contentHeight) {
        return FullRectangle.of(
                0, contentHeight,
                PADDING_WIDTH, PADDING_HEIGHT,
                Collections.emptyList(),
                TextAlign.CENTER_MIDDLE,
                false
        );
    }

    private static int getSubHeight(Text[][] subCube) {
        int max = 0;
        int totalRows = subCube.length;
        int totalCols = subCube[0].length;
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                Text text = subCube[i][j];
                if (text == null) {
                    continue;
                }

                int length = text.getTotalRows();
                if (length > max) {
                    max = length;
                }
            }
        }
        return max;
    }
}
