package lsieun.drawing.utils;

public class NumberUtils {
    public static int getOdd(int num) {
        return ((num & 1) == 0) ? num + 1 : num;
    }
}
