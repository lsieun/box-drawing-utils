package lsieun.drawing.utils;

public class BitUtils {
    public static String fromInt(int intValue) {
        int length = Integer.SIZE;
        byte[] bytes = new byte[length];
        for (int i = 0; i < length; i++) {
            int val = ((intValue << i) < 0) ? 0x31 : 0x30;
            bytes[i] = (byte) val;
        }
        return new String(bytes);
    }
}
