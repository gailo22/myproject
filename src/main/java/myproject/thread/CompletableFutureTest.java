package myproject.thread;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		CompletableFuture<Integer> futureCount = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {}
			
			return 10;
		});
		
		try {
			int count = futureCount.get();
			System.out.println(count);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
	
}
