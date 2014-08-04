package com.zimem.algorithms.search;

/**
 * 二分查找， 基于已排序数组。
 * @author zimmem
 *
 */
public class BinarySearch {

    public static int search(int array[], int value) {
        int bottom = 0;
        int top = array.length-1;
        while (bottom != top) {
            int index = (bottom + top) / 2;
            if (value == array[index]) {
                return index;
            } else if (value < array[index]) {
                top = index - 1;
            } else {
                bottom = index + 1;
            }
        }
        if (array[bottom] == value) {
            return bottom;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = new int[] { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11 };
        for (int i = 0; i <= a.length - 1 ; i++) {
            System.out.println(search(a, i));
        }
        //System.out.println(search(a, 10));
    }

}
