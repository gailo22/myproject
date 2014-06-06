package myproject.interview;


public class FizzBuzz {

	public static void main(String[] args) {

		fizzBuzz1();
		System.out.println("");
		fizzBuzz2();
		
	}

	private static void fizzBuzz1() {
		for (int i = 1; i <= 100; i++) {
			if (i % (3 * 5) == 0)
				System.out.print("FizzBuzz");
			else if (i % 5 == 0)
				System.out.print("Buzz");
			else if (i % 3 == 0)
				System.out.print("Fizz");
			else
				System.out.print(i);
		}
	}
	
	private static void fizzBuzz2() {
		int n = 100;
		StringBuffer buff = new StringBuffer(n);
		
		for (int i = 1; i <= n; i++) {
			String word = getWord(i, 3, "Fizz") + getWord(i, 5, "Buzz");
			
			if (word.isEmpty()) {
				buff.append(Integer.toString(i));
			} else {
				buff.append(word);
			}
		}
		
		System.out.println(buff.toString());
		
	}
	
	private static String getWord(int i, int modulo, String word) {
		return i % modulo == 0 ? word : "";
	}

}
