package myproject;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

public class StringPermutation {
	private static Set<String> set = new ConcurrentSkipListSet<String>();

	public static void permutation(String str) {
		permutation("", str);
	}

	private static void permutation(String prefix, String str) {
		int n = str.length();
		if (n == 0) {
			set.add(prefix);
		} else {
			for (int i = 0; i < n; i++) {
				permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}

	public static void main(String[] args) {
		permutation("hello");
		for (String s : set) {
			System.out.println(s);
		}
		
		System.out.println("size: " + set.size());
	}
}
