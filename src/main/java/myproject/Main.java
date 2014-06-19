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
		
	}

	


}
