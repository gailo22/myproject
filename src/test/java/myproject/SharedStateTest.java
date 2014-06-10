package myproject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SharedStateTest {
	
	@Test
	public void sharedState() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		SimpleCounter c = new SimpleCounter();
		executorService.execute(new CounterSetter(c));
		
		c.setNumber(200);
		assertEquals(200, c.getNumber());
		
	}
	
	@Test
	public void lockedSharedState() {
		ExecutorService executorService = Executors.newCachedThreadPool();

		SimpleCounter c = new SimpleCounter();
		executorService.execute(new CounterSetterLocked(c));
		
		synchronized (c) {
			c.setNumber(200);
			assertEquals(200, c.getNumber());
		}
	}
	
	private static class CounterSetter implements Runnable {
		
		private SimpleCounter counter;
		
		private CounterSetter(SimpleCounter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			while(true) {
				counter.setNumber(100);
			}
		}
	}
	
	private static class CounterSetterLocked implements Runnable {

		private SimpleCounter counter;

		private CounterSetterLocked(SimpleCounter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			while (true) {
				synchronized (counter) {
					counter.setNumber(100);
				}
			}
		}
	}
	
}

class SimpleCounter {
	private int number = 0;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}
