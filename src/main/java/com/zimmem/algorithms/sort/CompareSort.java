package com.zimem.algorithms.sort;

/**
 * �Ƚ����� ��ͷ��ʼ�� ÿһ��������ıȽϣ� ����Ⱥ���Ĵ� �ͽ���λ�ã� ���Ӷ� O(n^2), ���������㷨
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
