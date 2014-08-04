package com.zimmem.algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SortMain {

	private static Random random = new Random();

	public static void main(String[] args) {
		SortFunction[] functions = new SortFunction[] { new CompareSort(),
				new BubbleSort(), new InsertSort(), new QuickSort() };
		run(10, functions);
		run(50, functions);
		run(100, functions);
		run(1000, functions);
		run(10000, functions);
		run(100000, functions);
		run(100000, functions);
		run(100000, functions);

	}

	private static void run(int number, SortFunction... functions) {
		int[] array = generateRandomArray(number);
		for (SortFunction function : functions) {
			long start = System.currentTimeMillis();
			int[] result = function.sort(Arrays.copyOf(array, array.length));
			if(number <= 50){
				System.out.println(Arrays.toString(result));
			}
			System.out.println(function.name() + " valid " + valid(result)
					+ " with " + number + " numbers , coast "
					+ (System.currentTimeMillis() - start));
		}
		System.out.println();
	}

	private static boolean valid(int[] array) {
		for (int i = 1; i < array.length; i++) {
			if (array[i] < array[i] - 1) {
				return false;
			}
		}
		return true;
	}

	private static int[] generateRandomArray(int number) {

		int[] array = new int[number];
		for (int i = 0; i < number; i++) {
			array[i] = random.nextInt();
		}
		return array;

	}
}
