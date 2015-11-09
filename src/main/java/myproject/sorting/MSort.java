package myproject.sorting;

public class MSort {

	public static void main(String[] args) {

		int[] ar = new int[] { 4, 5, 1, 3, 2 };
		System.out.print("before: ");
		printArray(ar);

		msort(ar);

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

	static void msort(int[] ar) {
		int n = ar.length;
		if (n <= 1) return;

		int[] aux = new int[n];
		msort(ar, aux, 0, n - 1);
	}

	private static void msort(int[] ar, int[] aux, int lo, int hi) {
		if (lo < hi) {
			int mid = lo + (hi - lo) / 2;

			msort(ar, aux, lo, mid);
			msort(ar, aux, mid + 1, hi);
			merge(ar, aux, lo, mid, hi);
		}

	}

	private static void merge(int[] ar, int[] aux, int lo, int mid, int hi) {
		// copy to aux array
		for (int k = lo; k <= hi; k++) {
			aux[k] = ar[k];
		}
		
		int i = lo, j = mid + 1;
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) ar[k] = aux[j++];
			else if (j > hi) ar[k] = aux[i++];
			else if (aux[j] < aux[i]) ar[k] = aux[j++];
			else ar[k] = aux[i++];
		}
	}

}
