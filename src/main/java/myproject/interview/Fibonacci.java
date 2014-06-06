package myproject.interview;

public class Fibonacci {

	public static void main(String[] args) {
		
		// fn = fn-1 + fn-2
		// first 10 Fibonacci numbers are 1, 1, 2, 3, 5, 8, 13, 21, 34, 55
		
		System.out.println(fibonacciRecur(10));
		System.out.println(fibonacci(10));

	}

	private static int fibonacciRecur(int n) {
		if (n == 1 || n == 2) 
			return 1;
		
		return fibonacciRecur(n - 1) + fibonacciRecur(n - 2);
	}
	
	private static int fibonacci(int n) {
		if (n == 1 || n == 2) 
			return 1;
		
		int fib1 = 1, fib2 = 1, fib = 1;
		
		for (int i = 3; i <= n; i++) {
			fib = fib1 + fib2;
			fib1 = fib2;
			fib2 = fib;

		}
		
		return fib;
	}
}
