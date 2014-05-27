package myproject;

public class TempTest {

	public static void main(final String[] args) {
		System.out.println(method());
	}

	private static String method() {
		try {
			System.out.println("try");
			return "return in try";
		} catch (final Exception ex) {
			System.out.println("exception");
		} finally {
			System.out.println("finally");
		}

		return "null";
	}

}
