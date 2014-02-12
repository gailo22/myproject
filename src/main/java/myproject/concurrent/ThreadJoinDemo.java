package myproject.concurrent;

public class ThreadJoinDemo {

	public static void main(String[] args) {
		NewJoinThread t1 = new NewJoinThread("One");
		NewJoinThread t2 = new NewJoinThread("Two");
		NewJoinThread t3 = new NewJoinThread("Three");

		System.out.println("The thread One is alive: " + t1.t.isAlive());
		System.out.println("The thread Two is alive: " + t2.t.isAlive());
		System.out.println("The thread Three is alive: " + t3.t.isAlive());

		try {
			System.out.println("Waiting for threads to finish...");
			t1.t.join();
			t2.t.join();
			t3.t.join();

		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted!");
		}

		System.out.println("The thread One is alive: " + t1.t.isAlive());
		System.out.println("The thread Two is alive: " + t2.t.isAlive());
		System.out.println("The thread Three is alive: " + t3.t.isAlive());
		System.out.println("Main thread exiting.");
	}

}

class NewJoinThread implements Runnable {
	String name;
	Thread t;

	NewJoinThread(String tName) {
		name = tName;
		t = new Thread(this, name);
		System.out.println("New Thread: " + t);
		t.start();
	}

	@Override
	public void run() {
		try {
			for (int n = 5; n > 0; n--) {
				System.out.println(name + ": " + n);
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			System.out.println(name + " thread interrupted!");
		}

		System.out.println(name + " thread exiting.");
	}

}
