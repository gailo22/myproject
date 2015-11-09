package myproject.sorting;

public class QSort {

	public static void main(String[] args) {

		int[] ar = new int[] { 4, 5, 1, 3, 2 };
		System.out.print("before: ");
		printArray(ar);

		qsort(ar);

		System.out.print("after:  ");
		printArray(ar);

	}

	static void printArray(int[] ar) {
		for (int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();
	}

	static void swap(int[] ar, int i, int j) {
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
	}

	static void qsort(int[] ar) {
		int n = ar.length;
		if (n <= 1) return;

		qsort(ar, 0, n - 1);
	}

	static void qsort(int[] ar, int lo, int hi) {
		if (lo >= hi) return;

		int p = partition(ar, lo, hi);
		qsort(ar, lo, p - 1);
		qsort(ar, p + 1, hi);
	}

	static int partition(int[] ar, int lo, int hi) {
		int l = lo + 1;
		int r = hi;
		int pivot = ar[lo];

		while (true) {
			while (l <= r) {
				if (ar[l] < pivot) {
					l++;
				} else {
					break;
				}
			}
			while (r > l) {
				if (ar[r] > pivot) {
					r--;
				} else {
					break;
				}
			}

			if (l >= r) break;

			swap(ar, l, r);
			l++;
			r--;
		}

		ar[lo] = ar[l - 1];
		ar[l - 1] = pivot;

		return l - 1;
	}

}
