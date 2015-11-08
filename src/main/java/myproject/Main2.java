package myproject;

import java.util.Arrays;

import com.google.common.collect.ImmutableList;

public class Main2 {

	public static void main(String[] args) {
		
		ImmutableList<String> list = new ImmutableList.Builder<String>()
			.addAll(Arrays.asList("a", "b", "c"))
			.add("d")
			.build();
		
		for (String l : list) {
			System.out.println(l);
		}
		
		Arrays.asList(1,2,3,4,5)
		      .forEach(i -> doSomethingWithI(i));
		
	}

	private static void doSomethingWithI(Integer i) {
		System.out.println(i*i);
	}

}
