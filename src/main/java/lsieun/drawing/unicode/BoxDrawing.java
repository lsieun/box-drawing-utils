package lsieun.drawing.unicode;

public enum BoxDrawing {
    LIGHT_DIAGONAL_UPPER_RIGHT_TO_LOWER_LEFT(0x2571, "╱"),
    LIGHT_DIAGONAL_UPPER_LEFT_TO_LOWER_RIGHT(0x2572, "╲"),
    LIGHT_DIAGONAL_CROSS(0x2573, "╳"),
    ;

    public final int code_point;
    public final String value;

    BoxDrawing(int code_point, String value) {
        this.code_point = code_point;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s(%d)", value, super.toString(), code_point);
    }

    public static void main(String[] args) {
        for (BoxDrawing item : BoxDrawing.values()) {
            System.out.println(item);
        }
    }
}
