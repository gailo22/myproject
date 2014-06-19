package myproject.interview;

public class TowersOfHanoi {

	public static void main(String[] args) {
		
		int n = 3;
		
		String solution = hanoi(n, 'A', 'C', 'B');
		
		System.out.println(solution);
	}

	private static String hanoi(int n, char origin, char dest, char temp) {
		
		if (n == 1) return origin + " -> " + dest +"\n";
		else {
			
			String sol1 = hanoi(n - 1, origin, temp, dest);
			
			String myStep = origin + " -> " + dest +"\n";
			
			String sol2 = hanoi(n - 1, temp, dest, origin);
			
			return sol1 + myStep + sol2;
			
		}
	}

}
