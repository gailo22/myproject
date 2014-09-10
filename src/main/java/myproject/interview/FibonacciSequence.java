package myproject.interview;

import java.util.Scanner;

public class FibonacciSequence {

	public static void main(String[] args) {

		long a = -1, b = 1, c;
		long n, i = 0;
		
		System.out.println("Enter number: ");
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		
		while (i < n) {
			c = a + b;
			System.out.println(c + " ");
			a = b;
			b = c;
			i++;
		}
	}

}
