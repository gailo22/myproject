package myproject.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class CountDownLatch1 {
	
	private static final int NoOfThreads = 10;

	public static void main(String[] args) {
		
		CountDownLatch sLatch = new CountDownLatch(NoOfThreads);
		
		ExecutorService newWorkStealingPool = Executors.newWorkStealingPool();
		
		IntStream.rangeClosed(1, NoOfThreads)
		.forEach(i -> {
			newWorkStealingPool.submit(() -> {
				//int randInt = ThreadLocalRandom.current().nextInt(1000, 5000 + 1);
				int min = 1000;
				int max = 5000;
				int randInt = new Random().nextInt(max - min + 1) + min;
				try {
					Thread.sleep(randInt);
				} catch (Exception e) {}
				
				System.out.println(Thread.currentThread().getName() + ": " + randInt + ": " + i);
				
				sLatch.countDown();
			});
		});
		
		try {
			sLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		newWorkStealingPool.shutdown();
	}

}

