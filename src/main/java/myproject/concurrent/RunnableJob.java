package myproject.concurrent;

import java.util.Date;

public class RunnableJob implements Runnable {

	@Override
	public void run() {
		Thread thread = Thread.currentThread();
		System.out.println("RunnableJob is being run by " + thread.getName() + " at " + new Date());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
