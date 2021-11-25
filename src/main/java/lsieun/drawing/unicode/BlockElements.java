package lsieun.drawing.unicode;

public enum BlockElements {
    FULL_BLOCK(0x2588, "█"),
    LEFT_HALF_BLOCK(0x258C, "▌"),
    RIGHT_HALF_BLOCK(0x2590, "▐"),
    ;
    public int code_point;
    public String value;

    BlockElements(int code_point, String value) {
        this.code_point = code_point;
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("%s: %s(%d)", value, super.toString(), code_point);
    }

    public static void main(String[] args) {
        for (BlockElements item : BlockElements.values()) {
            System.out.println(item);
        }
    }
}
