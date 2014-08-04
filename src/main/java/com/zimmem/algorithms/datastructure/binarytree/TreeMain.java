package com.zimmem.algorithms.datastructure.binarytree;

public class TreeMain {

    public static void main(String[] args) {
        Node<Integer> root = new Node<Integer>(1);
        Node<Integer> a = new Node<Integer>(2);
        Node<Integer> b = new Node<Integer>(3);
        Node<Integer> c = new Node<Integer>(4);
        Node<Integer> d = new Node<Integer>(5);
        Node<Integer> e = new Node<Integer>(6);
        Node<Integer> f = new Node<Integer>(7);
        root.setLeft(a);
        root.setRight(b);
        a.setLeft(c);
        c.setRight(d);
        b.setLeft(e);
        b.setRight(f);
        BinaryTree<Integer> tree = new BinaryTree<Integer>() {
        };
        tree.setRoot(root);
        TreeUtils.print(tree);

    }
}
