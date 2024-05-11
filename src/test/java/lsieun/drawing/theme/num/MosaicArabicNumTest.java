package lsieun.drawing.theme.num;

import lsieun.drawing.utils.CanvasUtils;
import org.junit.jupiter.api.Test;

class MosaicArabicNumTest {
    @Test
    void test() {
        MosaicArabicNum num = MosaicArabicNum.of(
                "0123456789",
                "9876543210"
        );
        CanvasUtils.print(num);
    }
}