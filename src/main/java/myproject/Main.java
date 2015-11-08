package myproject;

import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) {
		String str = "hello";
		
		for (int i = 0; i < str.length(); i++) {
			int value = str.charAt(i);
			System.out.println(value);
		}
		
		System.out.println((char) 104);
		
		
		int max = 10;
		int[] a = new int[max];
		
		for (int i = 0; i < max; i++) {
			int n = (int) (Math.random() * 10);
			a[i] = n;
		}
		
		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
		
	}

	private static void sort(int[] a) {
		quicksort(a, 0, a.length - 1);
	}

	private static void quicksort(int[] a, int left, int right) {
		if (left < right - 1) {
			int pivot = left + right >> 1;
			pivot = partition(a, left, right, pivot);
			quicksort(a, left, pivot);
			quicksort(a, pivot + 1, right);
		}
	}

	private static int partition(int[] a, int left, int right, int pivot) {
		int pivotValue = a[pivot];
		swap(a, pivot, --right);
		for (int i = left; i < right; ++i) {
			if (a[i] < pivotValue) {
				swap(a, i, left++);
			}
		}
		swap(a, left, right);
		return left;
	}

	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
