package myproject.interview;

public class Power {

	public static void main(String[] args) {
		
		System.out.println(power(2, 5));

	}
	
	public static int power(int x, int y) {
		if (y == 0) {
			return 1;
		} else if (y % 2 == 0) {
			return power(x, y/2) * power(x, y/2);
		} else {
			return x * power(x, y/2) * power(x, y/2);
		}
	}

}
