package lsieun.drawing.theme.bit;

import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

class MultiBytesTest {
    @Test
    void test() {
        MultiBytes bytes = new MultiBytes();
        bytes.add(ByteEntry.of(ByteType.SINGLE, 3, "76543210"));
        bytes.add(ByteEntry.of(ByteType.SINGLE, 3, "one byte"));
        bytes.add(ByteEntry.of(ByteType.DOUBLE, 8, ""));
        bytes.add(ByteEntry.of(ByteType.DOUBLE, 16, "a variable number of bytes"));

        CanvasUtils.print(bytes);
    }
}