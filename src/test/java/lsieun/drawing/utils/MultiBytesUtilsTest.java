package lsieun.drawing.utils;

import lsieun.drawing.theme.bit.ByteType;
import lsieun.drawing.theme.bit.MultiBytes;
import org.junit.jupiter.api.Test;

class MultiBytesUtilsTest {
    @Test
    void testNewInstance1() {
        String[] array = {"0010", "1000"};
        print(ByteType.SINGLE, array);
    }

    @Test
    void testNewInstance2() {
        String[] array = {"0010", "1000"};
        print(ByteType.DOUBLE, array);
    }

    private void print(ByteType byteType, String[] array) {
        MultiBytes instance = MultiBytesUtils.newInstance(byteType, array);
        CanvasUtils.print(instance);
    }

}