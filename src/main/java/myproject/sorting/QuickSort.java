package myproject.sorting;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;

class QuickSort {

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

	private static void quickSort(int[] arr, int left, int right) {
		if (left >= right)
			return;

		int pivot = arr[(left + right) / 2];
		int index = partition(arr, left, right, pivot);
		quickSort(arr, left, index - 1);
		quickSort(arr, index, right);
	}

	private static int partition(int[] arr, int left, int right, int pivot) {
		while (left <= right) {
			while (arr[left] < pivot) {
				left++;
			}

			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left;
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
