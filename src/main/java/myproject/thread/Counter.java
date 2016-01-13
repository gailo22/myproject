package myproject.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		AtomicInteger count = new AtomicInteger(0);
		for (int i = 0; i < 100; i++) {
			pool.execute(() -> {
				String threadName = Thread.currentThread().getName();
				System.out.println(threadName + ": " + count.incrementAndGet());
			});
		}
		
		pool.shutdown();
		try {
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Total: " + count.get());
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
}
