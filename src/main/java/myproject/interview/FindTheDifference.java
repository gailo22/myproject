package myproject.interview;

public class FindTheDifference {
	
	static char findTheDifference(String s, String t) {
		int sSum = s.chars().sum();
		int tSum = t.chars().sum();
		
		return (char) Math.abs(sSum - tSum);
	}
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		String s = "hello";
		String t = "hellow";
		
		System.out.println(findTheDifference(s, t));
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
}
