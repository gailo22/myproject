package myproject.interview;

public class RandomGenerator {

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 20; i++) {
			System.out.println(generate());
			Thread.sleep(1);
		}
	}
	
	public static long generate() {
		return System.currentTimeMillis() % 16;
	}
	
}
