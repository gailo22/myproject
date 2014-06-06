package myproject.interview;

public class SwapWithoutTemp {
	
	public static void main(String[] args) {
		
		swap1();
		swap2();
		swap3();
	}
	
	
	private static void swap1() {
		int a = 5;
		int b = 10;
		
		System.out.println("before: a = " + a + ", b = " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("after: a = " + a + ", b = " + b);
	}
	
	private static void swap2() {
		int a = 3;
		int b = 2;
		
		System.out.println("before: a = " + a + ", b = " + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("after: a = " + a + ", b = " + b);
	}
	
	private static void swap3() {
		int a = 6;
		int b = 1;
		
		System.out.println("before: a = " + a + ", b = " + b);
		a = a * b;
		b = a / b;
		a = a / b;
		System.out.println("after: a = " + a + ", b = " + b);
	}

}
