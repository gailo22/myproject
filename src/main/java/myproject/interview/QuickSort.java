package myproject.interview;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		int max = 10;
		int[] a = new int[max];
		
		for (int i = 0; i < max; i++) {
			a[i] = (int) (Math.random() * 10);
		}
		
		System.out.println(Arrays.toString(a));
		sort(a);
		System.out.println(Arrays.toString(a));
		
	}

	private static void sort(int[] a) {
		int n = a.length;
		if (n <= 1) return;
		
		qsort(a, 0, n - 1);
		
	}

	private static void qsort(int[] a, int lo, int hi) {
		if (hi - lo <= 0) return;
		
		int j = partition(a, lo, hi);
		
		qsort(a, lo, j - 1);
		qsort(a, j + 1, hi);
		
	}

	private static int partition(int[] a, int lo, int hi) {
		int l = lo + 1;
		int r = hi;
		
		int pivot = a[lo];
		
		while (true) {
			
			while(l <= r) {
				if (a[l] < pivot) {
					l++;
				} else {
					break;
				}
			}
			
			while (r > l) {
				if (a[r] < pivot) {
					break;
				} else {
					r--;
				}
			}
			
			if (l >= r) {
				break;
			}
			
			swap(a, l, r);
			
			l++;
			r--;
		}
		
		a[lo] = a[l - 1];
		a[l - 1] = pivot;
		
		return l - 1;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
