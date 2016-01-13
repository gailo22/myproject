package myproject.util;

import com.google.common.base.Function;

public class BinaryTest {

	public static void main(String[] args) {

		byte[] bs = "gailo".getBytes();

		System.out.println("oct: " + toString(bs, new Function<Integer, String>() {

			@Override
			public String apply(Integer input) {
				return input.toString();
			}
		}));

		System.out.println("binary: " + toString(bs, new Function<Integer, String>() {

			@Override
			public String apply(Integer input) {
				return Integer.toBinaryString(input);
			}

		}));

		System.out.println("hex: " + toString(bs, new Function<Integer, String>() {

			@Override
			public String apply(Integer input) {
				return Integer.toHexString(input);
			}
		}));
		
		System.out.println("oct: " + toString(bs, (input) -> input.toString()));
		System.out.println("binary: " + toString(bs, Integer::toBinaryString));
		System.out.println("hex: " + toString(bs, Integer::toHexString));

	}

	private static String toString(byte[] bs, Function<Integer, String> function) {
		StringBuilder sb = new StringBuilder(bs.length);
		for (byte b : bs) {
			sb.append(function.apply(new Integer(b)));
			sb.append(" ");
		}
		return sb.toString();
	}

}
