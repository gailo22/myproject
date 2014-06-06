package myproject.interview;

public class StringReverse {

	public static void main(String[] args) {

		String str = "!dlroW olleH";

		String revStr = reverse(str);
		System.out.println(revStr);

		String revStr1 = reverseRecur(str);
		System.out.println(revStr1);
		
		String revStr2 = reverseImproved(str);
		System.out.println(revStr2);
		
		printOdds();
		
		int[] ints = {2,4,2,3,4,6,7,3,2,4,1};
		System.out.println("largest: " + largest(ints));
	}

	private static String reverse(String str) {
		StringBuilder builder = new StringBuilder();
		char[] chars = str.toCharArray();

		for (int i = chars.length - 1; i >= 0; i--) {
			builder.append(chars[i]);
		}
		return builder.toString();
	}

	private static String reverseRecur(String str) {
		if (str.length() < 2)
			return str;

		return reverseRecur(str.substring(1)) + str.charAt(0);
	}
	
	private static String reverseImproved(String s) {
		int length = s.length(), last = length - 1;
		char[] chars = s.toCharArray();
		
		for (int i = 0; i < length / 2; i++) {
			char c = chars[i];
			chars[i] = chars[last - i];
			chars[last - i] = c;
		}
		
		return new String(chars);
	}
	
	private static void printOdds() {
		for (int i = 1; i < 100; i += 2) {
			System.out.println(i);
		}
	}

	private static int largest(int[] input) {
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < input.length; i++) {
			if (input[i] > max)
				max = input[i];
		}
		return max;
	}

}
