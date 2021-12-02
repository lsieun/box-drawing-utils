package lsieun.drawing.theme.tree;

import java.util.Collections;
import java.util.List;

public class HuffmanTree extends BinaryTree implements Comparable<HuffmanTree> {
    public int frequency;

    public HuffmanTree(String name, int frequency) {
        super(name);
        this.frequency = frequency;
    }

    @Override
    public int compareTo(HuffmanTree another) {
        int diff = this.frequency - another.frequency;
        if (diff == 0) {
            return this.name.compareTo(another.name);
        }
        return diff;
    }

    public static HuffmanTree valueOf(String name, int frequency) {
        return new HuffmanTree(name, frequency);
    }

    public static HuffmanTree generateTree(List<HuffmanTree> list) {
        while (list.size() > 1) {
            // 1. sort
            Collections.sort(list);

            // 2. get two lowest frequencies
            HuffmanTree first = list.get(0);
            HuffmanTree second = list.get(1);
            list.remove(first);
            list.remove(second);

            // 3. merge
            int frequency = first.frequency + second.frequency;
            HuffmanTree merged = HuffmanTree.valueOf("", frequency);
            merged.addLeftChild(first);
            merged.addRightChild(second);

            // 4. add merged one
            list.add(merged);
        }

        return list.get(0);
    }
}
