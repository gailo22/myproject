package myproject.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class SimpleBlockingQueue<E> {

	private final List<E> list;
	
	private final int capacity;
	
	public SimpleBlockingQueue(int capacity) {
		this.capacity = capacity;
		list = new ArrayList<>();
	}
	
	public synchronized void put(E e) throws InterruptedException {
		while (isFull()) {
			wait();
		}
		
		list.add(e);
		notifyAll();
	}

	public synchronized E take() throws InterruptedException {
		while (list.isEmpty()) {
			wait();
		}
		
		final E e = list.remove(0);
		notifyAll();
		return e;
	}
	
	private boolean isFull() {
		return list.size() == capacity;
	}
	
	public synchronized int size() {
		return list.size();
    }
	
	// testing
	private final static AtomicInteger count = new AtomicInteger(0);
	private final static int maxIterations = 100000;
	
	public static void main(String[] args) {
		
		SimpleBlockingQueue<String> queue = new SimpleBlockingQueue<>(10);
		
		Thread producer = new Thread(makeProducer(queue));
		Thread consumer = new Thread(makeConsumer(queue));
		
		producer.start();
		
		try {
            Thread.sleep(100);
        } catch (InterruptedException e) {}
		
		consumer.start();
		
		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private static Runnable makeProducer(SimpleBlockingQueue<String> queue) {
		return new Runnable() {

			@Override
			public void run() {
				try {
	                for(int i = 0; i < maxIterations; i++) {
	                    count.incrementAndGet();

	                    queue.put(Integer.toString(i));
	                }
	            } catch (InterruptedException e) {
	                System.out.println("InterruptedException caught");
	            }
			}
		};
	}

	private static Runnable makeConsumer(SimpleBlockingQueue<String> queue) {
		return new Runnable() {

			@Override
			public void run() {
				Object s = null;
	            try {
	                for(int i = 0; i < maxIterations; i++) {
	                    // Calls the take() method.
	                    s = queue.take();

	                    count.decrementAndGet();

	                    if((i % (maxIterations / 10)) == 0)
	                        System.out.println(s);
	                }
	            } catch (InterruptedException e) {
	                System.out.println("InterruptedException caught");
	            }
	            
	            System.out.println("Final size of the queue is " 
	                               + queue.size()
	                               + "\ncount is "
	                               + count.get()
	                               + "\nFinal value is "
	                               + s);
			}
		};
	}
	
}
