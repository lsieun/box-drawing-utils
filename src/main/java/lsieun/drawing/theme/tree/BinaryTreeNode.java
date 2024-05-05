package lsieun.drawing.theme.tree;

public class BinaryTreeNode<T extends BinaryTreeNode<T>> {
    public T parent;
    public T leftChild;
    public T rightChild;


    public void addLeftChild(T leftChild) {
        if (leftChild == null) {
            return;
        }
        this.leftChild = leftChild;
        leftChild.parent = (T) this;
    }

    public void addRightChild(T rightChild) {
        if (rightChild == null) {
            return;
        }
        this.rightChild = rightChild;
        rightChild.parent = (T) this;
    }

    public boolean isRoot() {
        return parent == null;
    }

    public boolean isLeaf() {
        return (leftChild == null) && (rightChild == null);
    }

    public boolean hasParent() {
        return parent != null;
    }

    public boolean hasLeftChild() {
        return leftChild != null;
    }

    public boolean hasRightChild() {
        return rightChild != null;
    }

    public boolean hasBothChild() {
        return (leftChild != null) && (rightChild != null);
    }
}

