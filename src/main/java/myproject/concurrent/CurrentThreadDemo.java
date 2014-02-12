package myproject.concurrent;

public class CurrentThreadDemo {

	public static void main(String[] args) {
		Thread t = Thread.currentThread();
		System.out.println("Current thread: " + t);

		t.setName("my thread");
		System.out.println("Current thread: " + t);

		try {
			for (int n = 5; n > 0; n--) {
				System.out.println(n);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
