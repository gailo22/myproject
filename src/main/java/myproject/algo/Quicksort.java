package myproject.algo;

import java.util.Arrays;

public class Quicksort {

	public static void main(String[] args) {

//		quicksort :: Ord a => [a] -> [a]
//		quicksort []     = []
//		quicksort (p:xs) = (quicksort lesser) ++ [p] ++ (quicksort greater)
//				  where
//				        lesser  = filter (< p) xs
//				        greater = filter (>= p) xs

		Integer[] ints = { 32, 39, 21, 45, 23, 3 };
		
		System.out.println(Arrays.toString(ints));
		sort(ints, 0, ints.length - 1);
		System.out.println(Arrays.toString(ints));

	}

	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int j = partition(a, lo, hi);
		sort(a, lo, j - 1);
		sort(a, j + 1, hi);
		assert Util.isSorted(a, lo, hi);
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		Comparable v = a[lo];
		while (true) {

			// find item on lo to swap
			while (Util.less(a[++i], v))
				if (i == hi)
					break;

			// find item on hi to swap
			while (Util.less(v, a[--j]))
				if (j == lo)
					break; // redundant since a[lo] acts as sentinel

			// check if pointers cross
			if (i >= j)
				break;

			Util.exch(a, i, j);
		}

		// put v = a[j] into position
		Util.exch(a, lo, j);

		// with a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
		return j;
	}

}
