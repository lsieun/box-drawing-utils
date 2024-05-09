package lsieun.drawing.utils;

import lsieun.drawing.theme.bit.ByteEntry;
import lsieun.drawing.theme.bit.ByteType;
import lsieun.drawing.theme.bit.MultiBytes;

public class MultiBytesUtils {
    public static MultiBytes newInstance(ByteType type, String... array) {
        CheckUtils.notNull(array, "array");
        MultiBytes bytes = new MultiBytes();
        for (String str : array) {
            CheckUtils.notNull(str, "str");
            bytes.add(ByteEntry.of(type, str.length(), str));
        }
        return bytes;
    }

    public static void print(String... array) {
        MultiBytes bytes = newInstance(ByteType.SINGLE, array);
        CanvasUtils.print(bytes);
    }
}
