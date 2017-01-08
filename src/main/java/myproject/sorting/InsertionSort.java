package myproject.sorting;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;

class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 4, 3, 9, 1, 8, 6, 7 };

		print(arr);
		sort(arr);
		print(arr);

	}

	private static void sort(int[] arr) {
		int len = arr.length;

		insertionSort(arr, len);

	}

	private static void insertionSort(int[] arr, int n) {
		int j;
		for (int i = 1; i < n; i++) {
			j = i;
			while (j > 0 && arr[j] < arr[j - 1]) {
				swap(arr, j, j - 1);
				j--;
			}
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
