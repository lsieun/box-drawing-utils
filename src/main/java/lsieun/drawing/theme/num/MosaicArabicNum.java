package lsieun.drawing.theme.num;

import lsieun.drawing.canvas.Canvas;
import lsieun.drawing.canvas.Drawable;
import lsieun.drawing.unicode.GeometricShapes;
import lsieun.drawing.utils.NumberUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MosaicArabicNum implements Drawable {
    static final long BIT_00000000 = 0b00L;
    static final long BIT_00000011 = 0b11L;
    static final long BIT_00001100 = BIT_00000011 << 2;
    static final long BIT_00110000 = BIT_00001100 << 2;
    static final long BIT_11000000 = BIT_00110000 << 2;

    static final long BIT_11000011 = BIT_11000000 | BIT_00000011;
    static final long BIT_11111111 = BIT_11000000 | BIT_00110000 | BIT_00001100 | BIT_00000011;

    private static final int NUM_ROW_SPACE = 0;
    private static final int NUM_COL_SPACE = 2;
    private static final int NUM_HEIGHT = 8;
    private static final int NUM_WIDTH = 8;


    private static final Map<String, Long> NUM_MAP = new HashMap<>();

    static {
        NUM_MAP.put("0", getNum0());
        NUM_MAP.put("1", getNum1());
        NUM_MAP.put("2", getNum2());
        NUM_MAP.put("3", getNum3());
        NUM_MAP.put("4", getNum4());
        NUM_MAP.put("5", getNum5());
        NUM_MAP.put("6", getNum6());
        NUM_MAP.put("7", getNum7());
        NUM_MAP.put("8", getNum8());
        NUM_MAP.put("9", getNum9());
    }

    private static boolean hasBit(long val, int indexFromLeft) {
        int rightShift = 63 - indexFromLeft;
        return ((val >> rightShift) & 1L) == 1L;
    }

    private static long getNum0() {
        return getLong(
                BIT_11111111,
                BIT_11000011,
                BIT_11000011,
                BIT_11000011,
                BIT_11000011,
                BIT_11000011,
                BIT_11111111,
                BIT_00000000
        );
    }

    private static long getNum1() {
        return getLong(
                BIT_00000011,
                BIT_00000011,
                BIT_00000011,
                BIT_00000011,
                BIT_00000011,
                BIT_00000011,
                BIT_00000011,
                BIT_00000000
        );
    }

    private static long getNum2() {
        return getLong(
                BIT_11111111,
                BIT_00000011,
                BIT_00000011,
                BIT_11111111,
                BIT_11000000,
                BIT_11000000,
                BIT_11111111,
                BIT_00000000
        );
    }

    private static long getNum3() {
        return getLong(
                BIT_11111111,
                BIT_00000011,
                BIT_00000011,
                BIT_11111111,
                BIT_00000011,
                BIT_00000011,
                BIT_11111111,
                BIT_00000000
        );
    }

    private static long getNum4() {
        return getLong(
                BIT_11000011,
                BIT_11000011,
                BIT_11000011,
                BIT_11111111,
                BIT_00000011,
                BIT_00000011,
                BIT_00000011,
                BIT_00000000
        );
    }

    private static long getNum5() {
        return getLong(
                BIT_11111111,
                BIT_11000000,
                BIT_11000000,
                BIT_11111111,
                BIT_00000011,
                BIT_00000011,
                BIT_11111111,
                BIT_00000000
        );
    }

    private static long getNum6() {
        return getLong(
                BIT_11111111,
                BIT_11000000,
                BIT_11000000,
                BIT_11111111,
                BIT_11000011,
                BIT_11000011,
                BIT_11111111,
                BIT_00000000
        );
    }

    private static long getNum7() {
        return getLong(
                BIT_11111111,
                BIT_00000011,
                BIT_00000011,
                BIT_00000011,
                BIT_00000011,
                BIT_00000011,
                BIT_00000011,
                BIT_00000000
        );
    }

    private static long getNum8() {
        return getLong(
                BIT_11111111,
                BIT_11000011,
                BIT_11000011,
                BIT_11111111,
                BIT_11000011,
                BIT_11000011,
                BIT_11111111,
                BIT_00000000
        );
    }

    private static long getNum9() {
        return getLong(
                BIT_11111111,
                BIT_11000011,
                BIT_11000011,
                BIT_11111111,
                BIT_00000011,
                BIT_00000011,
                BIT_11111111,
                BIT_00000000
        );
    }

    private static long getLong(long... array) {
        if (array.length != 8) {
            throw new RuntimeException("array.length != 8");
        }

        return array[0] << 56 |
                array[1] << 48 |
                array[2] << 40 |
                array[3] << 32 |
                array[4] << 24 |
                array[5] << 16 |
                array[6] << 8 |
                array[7];
    }


    private final List<String> numList = new ArrayList<>();


    public MosaicArabicNum(int... array) {
        if (array == null || array.length < 1) {
            throw new RuntimeException("array.length < 1");
        }
        for (int num : array) {
            String numStr = String.valueOf(num);
            numList.add(numStr);
        }
    }

    public MosaicArabicNum(long... array) {
        if (array == null || array.length < 1) {
            throw new RuntimeException("array.length < 1");
        }
        for (long num : array) {
            String numStr = String.valueOf(num);
            numList.add(numStr);
        }
    }

    public MosaicArabicNum(String... array) {
        if (array == null || array.length < 1) {
            throw new RuntimeException("array.length < 1");
        }
        for (String numStr : array) {
            if (!NumberUtils.isZeroOrPositiveNumber(numStr)) {
                throw new RuntimeException("numStr is not a valid number");
            }
            numList.add(numStr);
        }
    }

    @Override
    public void draw(Canvas canvas, int startRow, int startCol) {

        for (int i = 0; i < numList.size(); i++) {
            int row1 = startRow + i * (NUM_HEIGHT + NUM_ROW_SPACE);

            String numStr = numList.get(i);
            String[] array = numStr.split("");


            for (int j = 0; j < array.length; j++) {
                int col1 = startCol + j * (NUM_WIDTH + NUM_COL_SPACE);

                String num = array[j];
                long val = NUM_MAP.get(num);

                for (int k = 0; k < Long.SIZE; k++) {

                    int row = row1 + k / NUM_WIDTH;
                    int col = col1 + k % NUM_WIDTH;

                    canvas.moveTo(row, col);

                    if (hasBit(val, k)) {
                        canvas.drawPixel(GeometricShapes.BLACK_SQUARE.value);
                    }
                    else {
                        canvas.drawPixel(" ");
                    }
                }
            }
        }
    }

    public static MosaicArabicNum of(int... array) {
        return new MosaicArabicNum(array);
    }

    public static MosaicArabicNum of(long... array) {
        return new MosaicArabicNum(array);
    }

    public static MosaicArabicNum of(String... array) {
        return new MosaicArabicNum(array);
    }
}
