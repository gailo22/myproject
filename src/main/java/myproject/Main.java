package myproject;

public class Main {
	
	public static void main(String[] args) {
		String str = "hello";
		
		
		for (int i = 0; i < str.length(); i++) {
			int value = str.charAt(i);
			System.out.println(value);
		}
		
		System.out.println((char) 104);
	}

}
