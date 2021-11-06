package lsieun.drawing.table;

import lsieun.canvas.Drawable;
import lsieun.canvas.TextAlign;
import lsieun.canvas.TextStateCanvas;

import java.util.List;

public class OneLineTable implements Drawable {
    public final String[][] matrix;
    public final TextAlign align;

    public OneLineTable(String[][] matrix, TextAlign align) {
        this.matrix = matrix;
        this.align = align;
    }

    @Override
    public void draw() {
        TextStateCanvas canvas = new TextStateCanvas();
        int row = matrix.length;
        int col = matrix[0].length;

        int currentCol = 0;

        for (int j = 0; j < col; j++) {
            int maxLength = 0;

            for (int i = 0; i < row; i++) {
                String item = matrix[i][j];
                if (item == null) continue;
                int length = item.length();
                if (length > maxLength) {
                    maxLength = length;
                }
            }
            maxLength += 4;
            if (maxLength % 2 == 0) {
                maxLength += 1;
            }

            for (int i = 0; i < row; i++) {
                String item = matrix[i][j];
                if (item == null) item = "";
                canvas.drawRectangle(2 * i, currentCol, 3, maxLength);
                switch (align) {
                    case LEFT: {
                        canvas.drawText(2 * i + 1, currentCol + 2, item);
                        break;
                    }

                    case CENTER: {
                        int padding = (maxLength - item.length()) / 2;
                        canvas.drawText(2 * i + 1, currentCol + padding, item);
                        break;
                    }

                    case RIGHT: {
                        int padding = maxLength - item.length();
                        canvas.drawText(2 * i + 1, currentCol + padding - 2, item);
                        break;
                    }
                    default:
                        assert false : "impossible";
                }

            }
            currentCol += maxLength - 1;
        }


        List<String> lines = canvas.getLines();
        String result = list2str(lines);
        System.out.println(result);
    }
}
