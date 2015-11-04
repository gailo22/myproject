package myproject;

public class RecursiveTest {
	
	
	public static void main(String[] args) {
		doRecusive(3);
		System.out.println("------>" + fib(5));
		System.out.println(fact(5));
		System.out.println(power(2, 10));
		System.out.println(power2(2, 20));
		
	}

	private static void doRecusive(int loop) {
		System.out.println("Before Rexcursive");
		if (loop > 0) {
			System.out.println(loop);
			doRecusive(loop - 1);
		}
		System.out.println("After Rexcursive -> " + loop);
	}
	
	private static int fib(int which) {
		if (which <= 2)  {
			System.out.print(" => " + which + " ");
			return 1;
		} else {
			System.out.print(" ->: " + which + " ");
			return fib(which - 2) + fib(which - 1);
		}
	}
	
	private static int fact(int n) {
		if (n <= 1) {
			System.out.print(" 1 ");
			return 1;
		} else {
			System.out.print(n + " * ");
			return n * fact(n - 1);
		}
	}
	
	private static int power(int base, int exponent) {
		if (exponent == 0) {
			System.out.println("return: 1");
			return 1;
		} else {
			int subProblem = power(base, exponent - 1);
			System.out.println("return: " + base +" * " + subProblem + " = " + (base * subProblem));
			return base * subProblem;
		}
	}
	
	private static int power2(int base, int exponent) {
		if (exponent == 0) {
			return 1;
		} else if (exponent % 2 == 0) {
			int y = power2(base, exponent/2);
			return y * y;
		} else {
			return base * power2(base, exponent - 1);
		}
	}
	
}
