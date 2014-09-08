package myproject.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


class Processor7 implements Runnable {
	
	private int id;
	
	Processor7(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("starting: " + id);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("completed: " + id);
	}
	
}


public class App7ThreadPool {

	public static void main(String[] args) {

		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for (int i = 0; i < 5; i++) {
			executor.submit(new Processor7(i));
		}
		
		executor.shutdown();
		
		System.out.println("All tasks submitted.");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("All tasks completed.");
	}

}
