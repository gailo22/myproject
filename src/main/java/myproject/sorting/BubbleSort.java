package myproject.sorting;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;

class BubbleSort {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 4, 3, 9, 1, 8, 6, 7 };

		print(arr);
		sort(arr);
		print(arr);

	}

	private static void sort(int[] arr) {
		boolean isSorted = false;
		int len = arr.length - 1;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < len; i++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
					isSorted = false;
				}
			}
			len--;
		}
	}

	// utils
	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private static void print(int[] arr) {
		System.out.println(Arrays.stream(arr).boxed().collect(toList()));
	}

}