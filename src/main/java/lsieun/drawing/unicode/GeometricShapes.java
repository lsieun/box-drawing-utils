package lsieun.drawing.unicode;

public enum GeometricShapes {
    BLACK_SQUARE(0x25A0, "■"),
    WHITE_SQUARE(0x25A1, "□"),
    WHITE_SQUARE_CONTAINING_BLACK_SMALL_SQUARE(0x25A3, "▣"),
    SQUARE_WITH_ORTHOGONAL_CROSSHATCH_FILL(0x25A6, "▦"),
    SQUARE_WITH_UPPER_LEFT_TO_LOWER_RIGHT_FILL(0x25A7, "▧"),
    SQUARE_WITH_UPPER_RIGHT_TO_LOWER_LEFT_FILL(0x25A8, "▨"),
    SQUARE_WITH_DIAGONAL_CROSSHATCH_FILL(0x25A9, "▩"),

    WHITE_UP_POINTING_TRIANGLE(0x25B3,"△"),
    WHITE_RIGHT_POINTING_TRIANGLE(0x25B7,"▷"),
    WHITE_DOWN_POINTING_TRIANGLE(0x25BD,"▽"),
    WHITE_LEFT_POINTING_TRIANGLE(0x25C1,"◁"),

    BLACK_DIAMOND(0x25C6,"◆"),
    WHITE_DIAMOND(0x25C7,"◇"),
    WHITE_DIAMOND_CONTAINING_BLACK_SMALL_DIAMOND(0x25C8,"◈"),

    FISHEYE(0x25C9,"◉"),
    WHITE_CIRCLE(0x25CB,"○"),
    DOTTED_CIRCLE(0x25CC,"◌"),
    BULLSEYE(0x25CE,"◎"),
    CIRCLE_WITH_VERTICAL_FILL(0x25CD,"◍"),
    BLACK_CIRCLE(0x25CF,"●"),
    ;

    public final int code_point;
    public final String value;

    GeometricShapes(int code_point, String value) {
        this.code_point = code_point;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s(%d)", value, super.toString(), code_point);
    }

    public static void main(String[] args) {
        for (GeometricShapes item : GeometricShapes.values()) {
            System.out.println(item);
        }
    }
}
