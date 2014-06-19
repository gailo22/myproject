package myproject.algo;

public class Gcd {
	
	public static void main(String... args) {
		
		int gcd = gcd(12, 30);
		
		System.out.println("gcd: " + gcd);
	}

	private static int gcd(int p, int q) {
		if (q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}

}
