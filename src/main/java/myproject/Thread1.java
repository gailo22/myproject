package myproject;

import java.util.concurrent.TimeUnit;

public class Thread1 {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		Thread t1 = new Thread(newTask());
		Thread t2 = new Thread(newTask());
		Thread t3 = new Thread(newTask());
		t1.start();
		t2.start();
		t3.start();
		
		Thread interruptThread = new Thread(newInterruptTask(t1, t2, t3));
		interruptThread.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}

	private static Runnable newInterruptTask(Thread... ts) {
		return new Runnable() {

			@Override
			public void run() {
				
				try {
					TimeUnit.SECONDS.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				for (Thread t : ts) {
					t.interrupt();
				}
			}
		};
	}

	private static Runnable newTask() {
		return new Runnable() {

			@Override
			public void run() {
				while (true) {
					String threadName = Thread.currentThread().getName();
					System.out.println("running #" + threadName);
					
					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) {
						e.printStackTrace();
						
						// exit if been interrupted
						break;
					}
				}
			}
			
		};
	}
}
