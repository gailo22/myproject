package myproject;

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
	}

}
