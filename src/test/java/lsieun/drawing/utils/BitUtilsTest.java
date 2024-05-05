package lsieun.drawing.utils;

import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BitUtilsTest {
    @Test
    @Order(1)
    void test0() {
        printBits(-1);
        printBits(0);
        printBits(1);
    }

    @Test
    @Order(2)
    void test1() {
        printBits(0b00000001);
        printBits(0b00000011);
        printBits(0b00000111);
        printBits(0b00001111);
    }

    @Test
    @Order(3)
    void test2N() {
        for (int i = 0; i < 32; i++) {
            int num = 1 << i;
            printBits(num);
        }
    }

    @Test
    @Order(4)
    void testMin() {
        printBits(Integer.MIN_VALUE);
    }

    @Test
    @Order(5)
    void testMax() {
        printBits(Integer.MAX_VALUE);
    }

    private void printBits(int num) {
        System.out.println("num = " + num);
        String str1 = BitUtils.fromInt(num);
        String str2 = String.format("%32s", Integer.toBinaryString(num)).replace(" ", "0");

        Assertions.assertEquals(str1, str2);
        System.out.println(str1);
    }

    @Test
    @Order(6)
    void testNumCount() {
        int num = 0b00100010_1111_0000;
        String str = BitUtils.fromInt(num, 8);
        System.out.println(str);
    }
}