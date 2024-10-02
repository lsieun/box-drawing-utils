package lsieun.drawing.utils.coll;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapUtils {
    public static <K, V> List<V> getList(Map<K, List<V>> map, K key) {
        List<V> list = map.get(key);
        if (list == null) {
            list = new ArrayList<>();
            map.put(key, list);
        }

        return list;
    }
}
