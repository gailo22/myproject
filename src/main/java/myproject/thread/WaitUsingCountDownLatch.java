package myproject.thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitUsingCountDownLatch {
	
	private static final AtomicInteger counter = new AtomicInteger();
	private static final CountDownLatch latch = new CountDownLatch(1);
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		ExecutorService pool = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 10; i++) {
			pool.submit(newTask());
		}
		
		pool.execute(new Runnable() {

			@Override
			public void run() {
				while (true) {
					if (counter.get() == 10) {
						latch.countDown();
					}
				}
			}
		});
		
		
		try {
			latch.await();
		} catch (InterruptedException e) {}
		
		pool.shutdown();

		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}

	private static Runnable newTask() {
		return new Runnable() {

			@Override
			public void run() {
				
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				String name = Thread.currentThread().getName();
				System.out.println(name + ": " + counter.incrementAndGet());
				
			}
			
		};
	}
}
