package myproject.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;



public class ThreadCallable {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		List<Future<String>> results = new ArrayList<>();
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 100; i++) {
			final int count = i;
			results.add(executorService.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					TimeUnit.SECONDS.sleep(1);
					return "" + count;
				}
			}));
		}
		
		results.forEach(result -> {
			try {
				System.out.println(result.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		executorService.shutdown();
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
}
