package myproject.sorting;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;

class MergeSort2 {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 4, 3, 9, 1, 8, 6, 7 };

		print(arr);
		sort(arr);
		print(arr);

	}

	private static void sort(int[] arr) {
		int len = arr.length;

		int[] aux = new int[len];
		mergeSort(arr, aux, 0, len - 1);
	}

	private static void mergeSort(int[] arr, int[] aux, int lo, int hi) {
		if (lo >= hi)
			return;

		int mid = lo + (hi - lo) / 2;
		mergeSort(arr, aux, lo, mid);
		mergeSort(arr, aux, mid + 1, hi);
		merge(arr, aux, lo, mid, hi);
	}

	private static void merge(int[] arr, int[] aux, int lo, int mid, int hi) {
		for (int i = lo; i <= hi; i++) {
			aux[i] = arr[i];
		}

		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				arr[k] = aux[j++];
			} else if (j > hi) {
				arr[k] = aux[i++];
			} else if (aux[i] < aux[j]) {
				arr[k] = aux[i++];
			} else {
				arr[k] = aux[j++];
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
