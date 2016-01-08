package myproject;

import java.util.Arrays;
import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {

		String expStr = "1 + 2 - 3";
		Scanner scanner = new Scanner(expStr);
		
		while(scanner.hasNext()) {
			String next = scanner.next();
			if (!next.isEmpty()) {
				System.out.println(next);
			}
		}
		String s = "He is a very very good boy, isn't he?";
		
		String[] s1 = expStr.split("[A-Za-z !,?.\\_'@]+");
		
		System.out.println(Arrays.asList(s1));
		
		
		String values = "param1\nparam2\nparam3";
		String[] split = values.split("\n");
		
		for (String s2 : split) {
			System.out.println("s2: " + s2);
		}
	}

}
