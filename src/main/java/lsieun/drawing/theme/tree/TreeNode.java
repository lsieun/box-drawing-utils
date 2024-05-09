package lsieun.drawing.theme.tree;

import java.util.ArrayList;
import java.util.List;

public class TreeNode <T extends TreeNode<T>>{
    public T parent;
    public final List<T> children = new ArrayList<T>();

    public void setParent(T parent) {
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    public void addChild(T child) {
        if (child == null) {
            return;
        }
        children.add(child);
        child.setParent((T) this);
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

}
