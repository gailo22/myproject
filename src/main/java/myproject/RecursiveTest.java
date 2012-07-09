package myproject;

public class RecursiveTest {
	
	
	public static void main(String[] args) {
//		doRecusive(3);
//		System.out.println("------>" + fib(5));
//		System.out.println(fact(5));
		System.out.println(power(3, 3));
		
	}

	private static void doRecusive(int loop) {
		System.out.println("Before Rexcursive");
		if (loop > 0) {
			System.out.println(loop);
			loop = loop - 1;
			doRecusive(loop);
		}
		System.out.println("After Rexcursive -> " + loop);
	}
	
	private static int fib(int which) {
		if (which <= 2)  {
			System.out.print(" => " + which + " ");
			return 1;
		} else {
			System.out.print(" ->: " + which + " ");
			return fib(which -2) + fib(which -1);
		}
	}
	
	private static int fact(int n) {
		if (n <= 1) {
			return 1;
		} else {
			return n * fact(n -1);
		}
	}
	
	private static int power(int base, int exponent) {
		if (exponent == 0) {
			return 1;
		} else {
			int subProblem = power(base, exponent -1);
			return base * subProblem;
		}
		
	}
	
	

}
