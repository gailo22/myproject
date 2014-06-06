package myproject.interview;

public class PrimeNumber {

	public static void main(String[] args) {

		int n = 13;

		System.out.println(isPrime1(n));
		System.out.println(isPrime2(n));
		System.out.println(isPrime3(n));
	}

	private static boolean isPrime1(int n) {

		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	private static boolean isPrime2(int n) {
		for (int i = 2; (2 * i) < n; i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

	private static boolean isPrime3(int n) {
		if (n % 2 == 0)
			return false;

		for (int i = 3; i < n; i += 2) {
			if (n % i == 0)
				return false;
		}

		return true;
	}

}
