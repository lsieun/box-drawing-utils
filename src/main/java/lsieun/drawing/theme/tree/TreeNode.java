package lsieun.drawing.theme.tree;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TreeNode <T extends TreeNode<T>>{
    public T parent;
    public final List<T> children = new ArrayList<>();

    public void setParent(@Nullable T parent) {
        this.parent = parent;
    }

    @SuppressWarnings("unchecked")
    public void addChild(@NotNull T child) {
        children.add(child);
        child.setParent((T) this);
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

}
