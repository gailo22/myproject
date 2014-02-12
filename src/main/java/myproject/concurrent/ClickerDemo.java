package myproject.concurrent;

public class ClickerDemo {

	public static void main(String[] args) {
		Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
		Clicker hi = new Clicker(Thread.NORM_PRIORITY + 2);
		Clicker lo = new Clicker(Thread.NORM_PRIORITY - 2);

		lo.start();
		hi.start();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		lo.stop();
		hi.stop();

		try {
			lo.t.join();
			hi.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Low priority thread: " + lo.click);
		System.out.println("High priority thread: " + hi.click);

	}

}
