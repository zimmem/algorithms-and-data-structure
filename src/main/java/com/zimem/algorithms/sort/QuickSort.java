package com.zimem.algorithms.sort;

public class QuickSort implements SortFunction {

	@Override
	public int[] sort(int[] array) {
		quickSort(array, 0, array.length);
		return array;
	}

	private void quickSort(int[] array, int left, int right) {
		if (array.length <= 1 || right - left < 1) {
			return;
		}
		int pos = partion(array, left, right);
		quickSort(array, left, pos);
		quickSort(array, pos+1, right);
	}

	private int partion(int[] array, int begin, int end) {
		int key = array[begin];
		int left = begin;
		int right = end - 1;
		while (left < right) {
			while (array[right] >= key && left < right) {
				right--;
			}
			array[left] = array[right];
			while (array[left] <= key && left < right) {
				left++;
			}
			array[right] = array[left];

		}
		array[left] = key;
		return left;
	}

	@Override
	public String name() {
		return "quick";
	}

}
