package myproject.interview;

public class MultiplyBySeven {

	public static void main(String[] args) {
		System.out.println(mulBy7(9));
	}
	
	public static int mulBy7(int number) {
		int result = number << 3; // multiply by 8 => (2^3 = 8)
		result = result - number; // subtract by the number => (n x 8) - n = (n x 7)
		return result;
	}

}
