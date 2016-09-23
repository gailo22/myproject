package myproject.interview;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] unsorted = { 32, 39, 21, 45, 23, 3 };

		System.out.println(Arrays.toString(unsorted));
		bubbleSort(unsorted);
		System.out.println(Arrays.toString(unsorted));

	}

	private static void bubbleSort(int[] unsorted) {
		int n = unsorted.length;

		for (int i = 1; i < n; i++) {

			for (int j = 0; j < n - i; j++) {
				if (unsorted[j] > unsorted[j + 1]) {
					swap(unsorted, j, j + 1);
				}
			}
			
		}
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}
