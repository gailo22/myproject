package myproject.bitwise;

public class BitwiseTest {

	public static void main(String[] args) {

		for (int i = 1; i < 100; i++) {
			System.out.println(i + " -> " + isPowerOfTwo(i));
		}
		
		swap(10, 20);

	}
	
	
	public static boolean isPowerOfTwo(int i) {
		return (i & (i - 1)) == 0;
	}
	
	public static void swap(int x, int y) {
		System.out.println("x: " + x + ", y: " + y);
		x ^= y;
		y ^= x;
		x ^= y;
		System.out.println("x: " + x + ", y: " + y);
	}

}
