package myproject.concurrent;

import java.util.Date;

public class InfiniteRunnableJob implements Runnable {

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("InfiniteRunnableJob is being run by " + thread.getName() + " at " + new Date());
		
		try {
			while (true) {
				System.out.println(thread.getName() + " thread is running...");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
