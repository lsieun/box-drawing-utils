package lsieun.utils;

import java.util.Formatter;
import java.util.List;

public class StringUtils {
    public static String list2str(List<String> list) {
        StringBuilder sb = new StringBuilder();
        Formatter fm = new Formatter(sb);
        for (String item : list) {
            fm.format("%s%n", item);
        }
        return sb.toString();
    }
}
