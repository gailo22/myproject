package myproject.operators;

public class ShiftOperatorsTest {

	public static void main(String[] args) {

		int x = Integer.MAX_VALUE;

		System.out.println("x:            " + x);
		System.out.println("x (bin):      " + Integer.toBinaryString(x));
		System.out.println("x << 1:       " + (x << 1));
		System.out.println("x << 1 (bin): " + Integer.toBinaryString(x << 1));
		System.out.println("x >> 1:       " + (x >> 1));
		System.out.println("x >> 1(bin):  " + Integer.toBinaryString(x >> 1));
		System.out.println("x >>> 1:      " + (x >>> 1));
		System.out.println("x >>> 1(bin): " + Integer.toBinaryString(x >>> 1));

	}

}

//x:            -1
//x (bin):      11111111111111111111111111111111
//x << 1:       -2
//x << 1 (bin): 11111111111111111111111111111110
//x >> 1:       -1
//x >> 1(bin):  11111111111111111111111111111111
//x >>> 1:      2147483647
//x >>> 1(bin): 1111111111111111111111111111111
