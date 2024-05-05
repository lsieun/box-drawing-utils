package lsieun.drawing.utils;

public class BitUtils {
    public static String fromInt(int intValue) {
        return fromInt(intValue, Integer.SIZE);
    }

    public static String fromInt(int num, int count) {
        CheckUtils.inRange(count, 1, 32, "count");

        byte[] bytes = new byte[count];
        for (int i = 0; i < count; i++) {
            int rightShift = count - 1 - i;
            int val = ((num >>> rightShift) & 1) == 1 ? 0x31 : 0x30;
            bytes[i] = (byte) val;
        }
        return new String(bytes);
    }


}
