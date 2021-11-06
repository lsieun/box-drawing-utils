package lsieun.canvas;

import java.util.Formatter;
import java.util.List;

public interface Drawable {
    void draw();

    default String list2str(List<String> list) {
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        for (String item : list) {
            fm.format("%s%n", item);
        }
        return sb.toString();
    }
}
