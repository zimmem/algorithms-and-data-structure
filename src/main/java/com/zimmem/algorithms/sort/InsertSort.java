package com.zimmem.algorithms.sort;

import java.util.Arrays;

public class InsertSort implements SortFunction {

	@Override
	public int[] sort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			for (int j = i ; j > 0; j--) {
				if (array[j] < array[j-1]) {
					int temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;
				} else {
					break;
				}
			}
		}
		return array;
	}

	@Override
	public String name() {
		return "Insert";
	}

}
