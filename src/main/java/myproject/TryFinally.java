package myproject;

public class TryFinally {
	
	public static void main(String[] args) {
		TryFinally t = new TryFinally();
		int y = t.method1();
		System.out.println(y); // 2
		int z = t.method2();
		System.out.println(z); // 3
	}

	private int method1() {
		int x = 1;
		try {
			return ++x;
		} catch (Exception e) {
		} finally {
			++x;
		}
		return x;
	}
	
	private int method2() {
		int x = 1;
		try {
			return ++x;
		} catch (Exception e) {
		} finally {
			return ++x;
		}
	}

}
