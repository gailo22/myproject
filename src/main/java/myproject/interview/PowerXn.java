package myproject.interview;

public class PowerXn {
	
	static double myPow(double x, int n) {
		if (n == 0) return 1;
		if (Double.isInfinite(x)) return 0;
		
		if (n < 0) {
			n = -n;
			x = 1/x;
		}
		
		return n%2 == 0 ? myPow(x*x, n/2) : x * myPow(x*x, n/2);
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		System.out.println(myPow(2, 5));
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
}
