package myproject.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;



public class MultiCounter {
	
	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		
		ExecutorService pool = Executors.newFixedThreadPool(10);
		
		Counter counter = new Counter();
		for (int i = 0; i<1000; i++) {
			pool.submit(() -> {
				counter.increment();
			});
		}
		
		try {
			pool.shutdown();
			pool.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("final count: " + counter.getCounter());
		System.out.println("final count Synchronized: " + counter.getCounterSynchronized());
		System.out.println("final count Lock: " + counter.getCounterLock());
		System.out.println("final count Atomic: " + counter.getCounterAtomic());
		
		System.out.println("Elapsed time: " + (System.currentTimeMillis() - start));
		
	}
	
	static class Counter {
		int count;
		int countSynchronized;
		int countLock;
		AtomicInteger countAtomic = new AtomicInteger(0);
		
		static ReentrantLock counterLock = new ReentrantLock(true);
		
		public void increment() {
			
			count++;
			
			synchronized (this) {
				countSynchronized++;
			}
			
			counterLock.lock();
			try {
				countLock++;
			} finally {
				counterLock.unlock();
			}
			
			countAtomic.getAndIncrement();
		}
		
		public int getCounter() {
			return count;
		}
		
		public int getCounterSynchronized() {
			return countSynchronized;
		}
		
		public int getCounterLock() {
			return countLock;
		}
		
		public int getCounterAtomic() {
			return countAtomic.get();
		}
	}
}
