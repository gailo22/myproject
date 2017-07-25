package myproject.java8.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ThreadId {
	
	private static final AtomicInteger nextId = new AtomicInteger(0);
	
	private static final ThreadLocal<Integer> threadId = ThreadLocal.withInitial(() -> nextId.getAndIncrement());

	public static int get() {
		return threadId.get();
	}
	
	public static void main(String[] args) {
	   ExecutorService pool = Executors.newFixedThreadPool(10);
	   
	   IntStream.rangeClosed(1, 10)
	       .forEach(i -> {
	    	   pool.submit(() -> {
	    		   String threadName = Thread.currentThread().getName();
	    		   int id = ThreadId.get();
	    		   System.out.println(threadName + ": " + id);
	    	   });
	       });
	   
	   pool.shutdown();
	}

}
