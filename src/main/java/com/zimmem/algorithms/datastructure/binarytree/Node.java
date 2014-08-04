package com.zimem.algorithms.datastructure.binarytree;

public class Node<T> {

    private Node<T> right;

    private Node<T> left;

    private Node<T> parent;

    private T       value;

    public Node(T value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return right == null && left == null;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        if (right != null) {
            right.setParent(this);
        }
        this.right = right;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        if (left != null) {
            left.setParent(this);
        }
        this.left = left;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

}
