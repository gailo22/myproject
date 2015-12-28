package myproject.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerPattern {

	public static void main(String[] args) {
		BlockingQueue<Integer> sharedQueue = new LinkedBlockingQueue<>();

		Thread producerThread = new Thread(new Producer(sharedQueue));
		Thread consumerThread = new Thread(new Consumer(sharedQueue));

		producerThread.start();
		consumerThread.start();
	}

	static class Producer implements Runnable {
		private final BlockingQueue<Integer> sharedQueue;
		  
		public Producer(BlockingQueue<Integer> sharedQueue) {
			this.sharedQueue = sharedQueue;
		}

		@Override
		public void run() {
			for (int i = 0; i < 10; i++) {
				try {
					System.out.println("Produced: " + i);
					sharedQueue.put(i);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	static class Consumer implements Runnable {
		private final BlockingQueue<Integer> sharedQueue;
		  
		public Consumer(BlockingQueue<Integer> sharedQueue) {
			this.sharedQueue = sharedQueue;
		}

		@Override
		public void run() {
			while (true) {
				try {
					System.out.println("Consumed: " + sharedQueue.take());
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
			}
		}
	}
}
