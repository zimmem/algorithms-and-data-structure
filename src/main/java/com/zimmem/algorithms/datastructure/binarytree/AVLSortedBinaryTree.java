package com.zimem.algorithms.datastructure.binarytree;

import java.util.Random;

/**
 * 峠財電會屈我峯
 * 
 * @author zimmem
 */
public class AVLSortedBinaryTree extends SortedBinaryTree {

    @Override
    protected void insert0(Node<Integer> root, Node<Integer> node) {
        Node<Integer> newRoot = null;
        Node<Integer> parent = root.getParent();
        if (node.getValue() < root.getValue()) {
            if (root.getLeft() == null) {
                root.setLeft(node);
            } else {
                insert0(root.getLeft(), node);
            }
            newRoot = balanceLeft(root, node);
        } else if (node.getValue() > root.getValue()) {
            if (root.getRight() == null) {
                root.setRight(node);
            } else {
                insert0(root.getRight(), node);
            }
            newRoot = balanceRight(root, node);
        } else {
            return;
        }
        if (parent == null) {
            this.root = newRoot;
            newRoot.setParent(null);
        } else if (root.getValue() < parent.getValue()) {
            parent.setLeft(newRoot);
        } else {
            parent.setRight(newRoot);
        }
    }

    private Node<Integer> balanceRight(Node<Integer> root, Node<Integer> node) {
        Node<Integer> newRoot = root;
        if (depth0(root.getLeft(), 1) - depth0(root.getRight(), 1) == -2) {
            if (root.getRight().getValue() < node.getValue()) {
                newRoot = rotationLeft(root);
            } else {
                newRoot = rotationRightAndLeft(root);
            }
        }
        return newRoot;
    }

    private Node<Integer> balanceLeft(Node<Integer> root, Node<Integer> node) {
        Node<Integer> newRoot = root;
        if (depth0(root.getLeft(), 1) - depth0(root.getRight(), 1) == 2) {

            if (root.getLeft().getValue() > node.getValue()) {
                newRoot = rotationRight(root);
            } else {
                newRoot = rotationLeftAndRight(root);
            }
        }
        return newRoot;
    }

    /**
     * 嘔傴
     * 
     * @param root
     * @return
     */
    private Node<Integer> rotationRight(Node<Integer> root) {
        Node<Integer> originLeft = root.getLeft();
        root.setLeft(originLeft.getRight());
        originLeft.setRight(root);
        return originLeft;

    }

    /**
     * 恣傴
     * 
     * @param root
     * @return
     */
    private Node<Integer> rotationLeft(Node<Integer> root) {
        Node<Integer> originRight = root.getRight();
        root.setRight(originRight.getLeft());
        originRight.setLeft(root);
        return originRight;

    }

    /**
     * 枠恣傴壅嘔傴
     * 
     * @param root
     * @return
     */
    private Node<Integer> rotationLeftAndRight(Node<Integer> root) {
        Node<Integer> newRoot = rotationLeft(root.getLeft());
        root.setLeft(newRoot);
        return rotationRight(root);
    }

    private Node<Integer> rotationRightAndLeft(Node<Integer> root) {
        Node<Integer> newRoot = rotationRight(root.getRight());
        root.setRight(newRoot);
        return rotationLeft(root);

    }

    public static void main(String[] args) {
        AVLSortedBinaryTree tree = new AVLSortedBinaryTree();
        Random random = new Random();
        for (int i = 0; i < 127; i++) {
            tree.insert(new Node<Integer>(random.nextInt(10000)));
            System.out.println("、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、、");
            TreeUtils.print(tree);
        }

    }
}
