package myproject.interview;

public class Factorial {

	public static void main(String[] args) {

		// fact = n * (n-1) * (n-2) ... * 1
		// fact = n * fact(n-1)

		System.out.println(factRecur(10));
		System.out.println(fact(10));

	}

	private static int factRecur(int n) {
		if (n == 0)
			return 1;

		return n * factRecur(n - 1);
	}

	private static int fact(int n) {
		int result = 1;
		
		for (int i = 1; i <= n; i++) {
			result = result * i;
		}
		
		return result;
	}
}
