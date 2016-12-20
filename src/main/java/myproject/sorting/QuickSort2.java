package myproject.sorting;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;

class QuickSort2 {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 4, 3, 9, 1, 8, 6, 7 };

		print(arr);
		sort(arr);
		print(arr);

	}

	private static void sort(int[] arr) {
		int len = arr.length;

		quickSort(arr, 0, len - 1);
	}

	private static void quickSort(int[] arr, int start, int end) {
		if (start >= end)
			return;

		int pIndex = partition(arr, start, end);
		quickSort(arr, start, pIndex - 1);
		quickSort(arr, pIndex + 1, end);
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int pIndex = start;

		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, pIndex);
				pIndex++;
			}
		}

		swap(arr, pIndex, end);
		return pIndex;
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
