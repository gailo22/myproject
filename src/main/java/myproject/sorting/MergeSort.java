package myproject.sorting;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;

class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 2, 5, 4, 3, 9, 1, 8, 6, 7 };

		print(arr);
		sort(arr);
		print(arr);

	}

	private static void sort(int[] arr) {
		int len = arr.length;

		if (len < 2) {
			return;
		}

		int[] arrTemp = new int[len];

		mergeSort(arr, arrTemp, 0, len - 1);

	}

	private static void mergeSort(int[] arr, int[] arrTemp, int start, int end) {
		if (start >= end) {
			return;
		}
		
		int middle = (start + end) / 2;
		mergeSort(arr, arrTemp, start, middle);
		mergeSort(arr, arrTemp, middle + 1, end);
		merge(arr, arrTemp, start, middle, end);
	}

	private static void merge(int[] arr, int[] arrTemp, int start, int middle, int end) {
		int index = start;
		int leftStart = start;
		int rightStart = middle + 1;
		int len = end - start + 1;

		while (leftStart <= middle && rightStart <= end) {
			if (arr[leftStart] <= arr[rightStart]) {
				arrTemp[index] = arr[leftStart];
				leftStart++;
			} else {
				arrTemp[index] = arr[rightStart];
				rightStart++;
			}
			index++;
		}

		while (leftStart <= middle) {
			arrTemp[index] = arr[leftStart];
			leftStart++;
			index++;
		}

		while (rightStart <= end) {
			arrTemp[index] = arr[rightStart];
			rightStart++;
			index++;
		}
		
//		System.arraycopy(arr, leftStart, arrTemp, index, middle - leftStart + 1);
//		System.arraycopy(arr, rightStart, arrTemp, index, end - rightStart + 1);
		System.arraycopy(arrTemp, start, arr, start, len);
		
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
