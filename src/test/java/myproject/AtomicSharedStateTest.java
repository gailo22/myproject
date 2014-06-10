package myproject;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AtomicSharedStateTest {
	
	@Test
	public void atomicSharedState() {
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		AtomicCounter c = new AtomicCounter();
		executorService.execute(new CounterSetter(c));
		
		int value = c.getNumber().incrementAndGet();
		assertEquals(1, value);
	}
	
	private static class CounterSetter implements Runnable {
		
		private AtomicCounter counter;
		
		private CounterSetter(AtomicCounter counter) {
			this.counter = counter;
		}

		@Override
		public void run() {
			while (true) {
				counter.getNumber().set(0);
			}
		}
	}
}

class AtomicCounter {
	AtomicInteger number = new AtomicInteger(0);

	public AtomicInteger getNumber() {
		return number;
	}

	public void setNumber(AtomicInteger number) {
		this.number = number;
	}
}
