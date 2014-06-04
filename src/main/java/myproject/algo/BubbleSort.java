package myproject.algo;

import java.util.List;

import com.google.common.collect.Lists;

public class BubbleSort {

	public static void main(String[] args) {

		List<Integer> ints = Lists.newArrayList(5, 2, 1, 3, 4);

		System.out.println(ints);

		List<Integer> sortedInts = sort(ints);

		System.out.println(sortedInts);

	}

	private static List<Integer> sort(List<Integer> ints) {
		int n = ints.size();

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {

				Integer a = ints.get(j);
				Integer b = ints.get(j + 1);

				if (a > b) {
					swap(ints, j, j + 1);
				}
			}
		}
		return ints;
	}

	private static void swap(List<Integer> ints, int i, int j) {
		Integer tmp = ints.get(i);
		ints.set(i, ints.get(j));
		ints.set(j, tmp);
	}

}
