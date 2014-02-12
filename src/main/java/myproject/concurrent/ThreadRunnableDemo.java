package myproject.concurrent;

public class ThreadRunnableDemo {

	public static void main(String[] args) {
		new NewThread();
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

class NewThread implements Runnable {

	Thread t;

	NewThread() {
		t = new Thread(this, "Demo thread");
		System.out.println("Child thread: " + t);
		t.start();
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
