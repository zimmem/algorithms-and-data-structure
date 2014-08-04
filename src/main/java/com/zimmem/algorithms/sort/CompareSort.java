package com.zimem.algorithms.sort;

/**
 * 比较排序， 开头开始， 每一个跟后面的比较， 如果比后面的大， 就交换位置， 复杂度 O(n^2), 最垃圾的算法
 * @author zimmem
 *
 */
public class CompareSort implements SortFunction {

	@Override
	public int[] sort(int[] array) {
		for (int i = 0; i < array.length - 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}

	@Override
	public String name() {
		return "compare";
	}
}
