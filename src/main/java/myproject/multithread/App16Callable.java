package myproject.multithread;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App16Callable {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
//		executor.submit(new Runnable() {
//			
//			@Override
//			public void run() {
//				Random random = new Random();
//				int duration = random.nextInt(4000);
//				
//				System.out.println("starting...");
//				
//				try {
//					Thread.sleep(duration);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				
//				System.out.println("finished.");
//			}
//		});
		
		Future<Integer> future = executor.submit(new Callable<Integer>() {

			@Override
			public Integer call() throws Exception {
				Random random = new Random();
				int duration = random.nextInt(4000);
				
				if (duration > 2000) {
					throw new IOException("Sleeping for too long!!");
				}
				
				System.out.println("starting...");
				
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("finished.");
				
				return duration;
			}
		});
		
		executor.shutdown();
		
		try {
			System.out.println("result is: " + future.get());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			IOException ex = (IOException) e.getCause();
			
			System.out.println("Coused by: " + ex.getMessage());
			
		}
	}

}
