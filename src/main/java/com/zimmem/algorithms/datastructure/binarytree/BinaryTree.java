package com.zimmem.algorithms.datastructure.binarytree;

public abstract class BinaryTree<T> {

    protected Node<T> root;

    public int depth() {
        if (getRoot() == null) {
            return 0;
        }
        return depth0(getRoot(), 1);
    }

    protected int depth0(Node node, int current) {

        if (node == null) {
            return 0;
        }

        if (node.isLeaf()) {
            return current;
        }

        return Math.max(depth0(node.getLeft(), current + 1), depth0(node.getRight(), current + 1));

    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }

}
