package lsieun.drawing.unicode;

public enum Arrows {
    LEFTWARDS_ARROW(0x2190, "←"),
    UPWARDS_ARROW(0x2191, "↑"),
    RIGHTWARDS_ARROW(0x2192, "→"),
    DOWNWARDS_ARROW(0x2193, "↓"),
    ;

    public int code_point;
    public String value;

    Arrows(int code_point, String value) {
        this.code_point = code_point;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s(%d)", value, super.toString(), code_point);
    }

    public static void main(String[] args) {
        for (Arrows item : Arrows.values()) {
            System.out.println(item);
        }
    }
}
