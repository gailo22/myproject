package myproject.interview;

import java.util.Arrays;

public class MergeSort {

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
		int[] aux = new int[n];
		msort(a, aux, 0, n - 1);
	}

	private static void msort(int[] a, int[] aux, int lo, int hi) {
		if (lo < hi) {
			
			int mid = lo + (hi - lo) / 2;
			
			msort(a, aux, lo, mid);
			msort(a, aux, mid + 1, hi);
			merge(a, aux, lo, mid, hi);
		}
	}

	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}
		
		int i = lo, j = mid + 1;
		
		for (int k = lo; k <= hi; k++) {
			if      (i > mid)         a[k] = aux[j++];
			else if (j > hi)          a[k] = aux[i++];
			else if (aux[j] < aux[i]) a[k] = aux[j++];
			else                      a[k] = aux[i++];
		}
	}

}
