package myproject.algo;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {

		int[] ints = { 3, 4, 2, 5, 1 };

		System.out.println("ints: " + Arrays.toString(ints));
		msort(ints);
		System.out.println("sorted: " + Arrays.toString(ints));

	}

	private static void msort(int[] ints) {
		int[] aux = new int[ints.length];
		msort(ints, aux, 0, ints.length - 1);
	}

	private static void msort(int[] a, int[] aux, int lo, int hi) {
		if (hi <= lo)
			return;
		
		int mid = lo + (hi - lo) / 2;
		msort(a, aux, lo, mid);
		msort(a, aux, mid + 1, hi);
		
		merge(a, aux, lo, mid, hi);

	}

	private static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		// copy to aux[]
		for (int k = lo; k <= hi; k++) {
            aux[k] = a[k]; 
        }
		
		// merge back to original a[]
		int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];   // this copying is unnecessary
            else if (j > hi)               a[k] = aux[i++];
            else if (Util.less(aux[j], aux[i])) a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }
		
	}

}
