package myproject.concurrent;

public class VolatileTest {

	private final boolean running = true;

	public static void main(final String[] args) {
		final VolatileTest test = new VolatileTest();

		while (test.running) {
			System.out.println("running...");
		}

		System.out.println("stopped.");
	}
}
