package com.zimem.algorithms.datastructure.binarytree;

import java.util.Arrays;

public class TreeUtils {

    public static void print(BinaryTree<?> tree) {

        int width = getMaxWidth(tree.getRoot(), 0);
        int depth = tree.depth();

        String[] format = new String[getLines(depth)];
        Arrays.fill(format, "");
        formatTree(tree.getRoot(), format, 0, format.length - 1, width);
        for (String string : format) {
            System.out.println(string);
        }

    }

    private static void formatTree(Node<?> root, String[] format, int top, int bottom, int valueLength) {
        if (root.getLeft() != null) {
            formatTree(root.getLeft(), format, top, (bottom + top) / 2 - 1, valueLength);
            int i = top;
            for (; i < ((bottom + top) / 2 - 1 + top) / 2; i++) {
                format[i] = "  " + format[i];
            }
            format[i] = "+-" + format[i];
            for (i = i + 1; i < (bottom + top) / 2; i++) {
                format[i] = "| " + format[i];
            }

        }
        if (root.getLeft() != null || root.getRight() != null) {
            format[(bottom + top) / 2] = "+" + format[(bottom + top) / 2];
        }
        if (root.getRight() != null) {
            formatTree(root.getRight(), format, (bottom + top) / 2 + 1, bottom, valueLength);
            int i = (bottom + top) / 2 + 1;
            for (; i < ((bottom + top) / 2 + 1 + bottom) / 2; i++) {
                format[i] = "| " + format[i];
            }
            format[i] = "+-" + format[i];
            for (i = i + 1; i <= bottom; i++) {
                format[i] = "  " + format[i];
            }
        }
        String str = formatNodeValue(root, valueLength);
        String spaces = "";
        for (int i = str.length(); i > 0; i--) {
            spaces += " ";
        }
        for (int i = top; i <= bottom; i++) {
            if (i == (top + bottom) / 2) {
                format[i] = str + format[i];
            } else {
                format[i] = spaces + format[i];
            }
        }

    }

    private static int getMaxWidth(Node node, int length) {
        if (node == null) {
            return 0;
        }
        int left = getMaxWidth(node.getLeft(), length);
        int right = getMaxWidth(node.getRight(), length);
        return Math.max(node.getValue().toString().length(), Math.max(left, right));
    }

    private static String formatNodeValue(Node node, int length) {
        int left = (length - node.getValue().toString().length()) / 2;
        int right = length - left - node.getValue().toString().length();
        StringBuilder sb = new StringBuilder();
        sb.append(" (");
        while (left > 0) {
            sb.append(" ");
            left--;
        }
        sb.append(node.getValue());
        while (right > 0) {
            sb.append(" ");
            right--;
        }
        sb.append(") ");
        return sb.toString();

    }

    private static int getLines(int n) {
        if (n == 1) return 1;
        if (n == 2) return 3;
        else return getLines(n - 1) * 2 + 1;
    }
}
