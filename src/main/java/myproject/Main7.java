package myproject;

import java.util.function.Supplier;

public class Main7 {

	public static void main(String[] args) {

		long start = System.currentTimeMillis();

//		int value = time(() -> longDouble(10));
//		System.out.println(value);
//		
//		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
//		
//		System.out.println(fib(5));
		
		toh(4, "a", "c", "b");

	}

	private static void toh(int n, String from, String to, String spare) {
		if (n <= 1) return;
		toh(n-1, from, spare, to);
		System.out.printf("Move %s -> %s" + System.lineSeparator(), from, to);
		toh(n-1, spare, to, from);
    }

	private static int longDouble(int x) {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}

		return x * 2;
	}

	private static <R> R time(Supplier<R> s) {
		long t0 = System.nanoTime();
		R result = s.get();
		long t1 = System.nanoTime();
		System.out.println("Elapsed time: " + (t1 - t0) + "ns");
		return result;
	}
	
	private static int fib(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		return fib(n-1) + fib(n-2);
	}

}
