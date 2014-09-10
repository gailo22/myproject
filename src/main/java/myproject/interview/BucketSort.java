package myproject.interview;

import java.util.Arrays;
import java.util.Random;

public class BucketSort {

	public static void main(String[] args) {
		
		int max = 20;
		int[] a = new int[max];
		
		Random random = new Random();

		for (int i = 0; i < max; i++) {
			int n = random.nextInt(10);
			a[i] = n;
		}

		System.out.println(Arrays.toString(a));
		int[] bucket = sort(a, 0, 9);
		
		int[] aSorted = new int[max];
		int k = 0;
		for (int i = 0; i < bucket.length; i++) {
			for (int j = 0; j < bucket[i]; j++) {
				aSorted[k++] = i;
			}
		}
		
		System.out.println(Arrays.toString(aSorted));
	}

	public static int[] sort(int[] a, int min, int max) {
		int range = max - min + 1;
		int[] result = new int[range];

		for (int i : a) {
			result[i]++;
		}

		return result;
	}
}
