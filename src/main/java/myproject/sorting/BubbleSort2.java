package myproject.sorting;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;

class BubbleSort2 {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 4, 3, 9, 1, 8, 6, 7 };

		print(arr);
		sort(arr);
		print(arr);

	}

	private static void sort(int[] arr) {
		int len = arr.length;

		bubbleSort(arr, len);
	}

	private static void bubbleSort(int[] arr, int len) {
		int newLen = len - 1;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < newLen; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
			newLen--;
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
