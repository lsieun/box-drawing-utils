package lsieun.drawing.theme.bit;

public class ByteEntry {
    public ByteType type;
    public int length;
    public String text;

    public ByteEntry(ByteType type, int length, String text) {
        this.type = type;
        this.length = length;
        this.text = text;
    }

    public static ByteEntry valueOf(ByteType type, int length, String text) {
        int actual_length = text == null ? 0 : text.length();
        int max_length = Math.max(length, actual_length);
        return new ByteEntry(type, max_length, text);
    }
}
