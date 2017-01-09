package myproject.thread;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTestNonBlock {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {}
			
			return 10;
		});
		
		futureCount
		.thenApply(count -> {
			System.out.println(count);
			System.out.println("thenApply");
			return count;
		})
		.thenAccept(count -> {
			System.out.println(count);
			System.out.println("thenAccept");
		})
		.whenComplete((count, error) -> {
			System.out.println(count);
			System.out.println("completed!");
		});
		
		// wait for future to be finished before Main Thread end
		futureCount.join();

		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
	
}
