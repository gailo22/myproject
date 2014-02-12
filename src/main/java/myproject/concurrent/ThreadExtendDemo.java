package myproject.concurrent;

public class ThreadExtendDemo {

	public static void main(String[] args) {
		new NewExtendThread();
		try {
			for (int n = 5; n > 0; n--) {
				System.out.println("Main thread: " + n);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted!");
		}

		System.out.println("Main thread exiting.");

	}

}

class NewExtendThread extends Thread {

	NewExtendThread() {
		super("Demo thread");
		System.out.println("Child thread: " + this);
		start();
	}

	@Override
	public void run() {
		try {
			for (int n = 5; n > 0; n--) {
				System.out.println("Child thread: " + n);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println("Child thread interrupted!");
		}

		System.out.println("Child thread exiting.");
	}

}
