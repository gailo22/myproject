package myproject.concurrent;

public class VolatileTest extends Thread {
	boolean keepRunning = true;

	public void run() {
		long count = 0;
		while (keepRunning) {
			count++;
		}

		System.out.println("Thread terminated." + count);
	}

	public static void main(String[] args) throws InterruptedException {
		VolatileTest t = new VolatileTest();
		t.start();
		Thread.sleep(1000);
		t.keepRunning = false;
		System.out.println("keepRunning set to false.");
	}
}

//The most common use for volatile variables is as a completion, interruption, or status flag:

//volatile boolean flag;
//while (!flag)  {
//   // do something untill flag is true
//}