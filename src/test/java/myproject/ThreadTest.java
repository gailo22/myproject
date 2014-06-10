package myproject;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class ThreadTest {

	@Test
	public void executorExample() {
		ExecutorService executor = Executors.newCachedThreadPool();
		Runnable threadNamePrinter = new InfiniteThreadNamePrinter();
		
		System.out.println("Main thread: " + Thread.currentThread().getName());
		
		executor.execute(threadNamePrinter);
	}
	
	@Test
	public void waitToComplete() throws Exception {
		ExecutorService executor = Executors.newCachedThreadPool();
		CountDownLatch latch = new CountDownLatch(1);
		
		executor.execute(new FiniteThreadNamePrinterLatch(latch));
		latch.await(5, TimeUnit.SECONDS);
	}
	
	@Test
	public void sameThread() {
		
		Executor executor = new Executor() {

			@Override
			public void execute(Runnable command) {
				command.run();
			}
			
		};
		
		System.out.println("Main thread: " + Thread.currentThread().getName());
		executor.execute(new FiniteThreadNamePrinter());
	}
	
	private static class InfiniteThreadNamePrinter implements Runnable {
		
		@Override
		public void run() {
			while(true) {
				System.out.println("Run from thread: " + Thread.currentThread().getName());
			}
			
		}
	}
	
	private static class FiniteThreadNamePrinterLatch implements Runnable {
		
		private CountDownLatch latch;

		public FiniteThreadNamePrinterLatch(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			for (int i = 0; i < 25; i++) {
				System.out.println("Run from thread: " + Thread.currentThread().getName());
			}
			latch.countDown();
		}
		
	}
	
	private static class FiniteThreadNamePrinter implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 25; i++) {
				System.out.println("Run from thread: " + Thread.currentThread().getName());
			}
		}

	}
}
