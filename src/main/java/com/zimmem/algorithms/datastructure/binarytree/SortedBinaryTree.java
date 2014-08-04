package com.zimmem.algorithms.datastructure.binarytree;

import java.util.Random;

/**
 * ÅÅÐò¶þ²æÊ÷
 * 
 * @author zimmem
 */
public class SortedBinaryTree extends BinaryTree<Integer> {

    public void insert(Node<Integer> node) {
        if (root == null) {
            root = node;
        } else {
            insert0(root, node);
        }
    };

    protected void insert0(Node<Integer> root, Node<Integer> node) {
        if (node.getValue() < root.getValue()) {
            if (root.getLeft() == null) {
                root.setLeft(node);
            } else {
                insert0(root.getLeft(), node);
            }
        } else if (node.getValue() > root.getValue()) {
            if (root.getRight() == null) {
                root.setRight(node);
            } else {
                insert0(root.getRight(), node);
            }
        } else {
            node.setLeft(root.getLeft());
            root.setLeft(node);
        }
    }

    public static void main(String[] args) {
        SortedBinaryTree tree = new SortedBinaryTree();
        Random random = new Random();
        for (int i = 0; i < 30; i++) {
            tree.insert(new Node<Integer>(random.nextInt(50)));
        }
        TreeUtils.print(tree);

    }
}
