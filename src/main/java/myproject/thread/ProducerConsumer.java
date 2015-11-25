package myproject.thread;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ProducerConsumer {
	
	public static void main(String[] args) {
		BlockingQueue<Integer> q = new LinkedBlockingQueue<>();
		
		Producer p = new Producer(q);
		Consumer c1 = new Consumer(q);
		Consumer c2 = new Consumer(q);
		
		new Thread(p).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}
	
	static class Producer implements Runnable {
		private final BlockingQueue<Integer> queue;
		private int i = 0;
		Producer(BlockingQueue<Integer> q) { this.queue = q; }
		@Override
		public void run() {
			try {
				while (true) {
					Integer produce = produce();
					String tName = Thread.currentThread().getName();
					System.out.println("Thread: " + tName + " produce: " + produce);
					queue.put(produce);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		private Integer produce() {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return i++;
		}
		
	}
	
	static class Consumer implements Runnable {
		private final BlockingQueue<Integer> queue;
		Consumer(BlockingQueue<Integer> q) { this.queue = q; }
		@Override
		public void run() {
			try {
				while (true) { 
					Object take = queue.take();
					String tName = Thread.currentThread().getName();
					System.out.println("Thread: " + tName + " consume: " + take);
					consume(take);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		private void consume(Object take) {
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

}
