package myproject;


public class Factorial {
	
	public static void main(String[] args) {
		
		System.out.println("factIter: " + factIter(5));
		System.out.println("factIter: " + factRecur(5));
		
	}

	private static int factIter(int n) {
		int product = 1;
		for (int i = 1; i <= n; i++) {
			product *= i;
		}
		return product;
	}
	
	private static int factRecur(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * factRecur(n-1);
		}
	}
}
