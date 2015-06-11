package myproject;

public class MessageBox {
	
	private String message;
	private boolean hasMessage;
	
	// producer
	public synchronized void putMessage(String message) {
		while (hasMessage) {
			// no room for new message
			try {
				wait(); // release the lock of this object
			} catch (InterruptedException e) {}
		}
		// acquire the lock and continue
		hasMessage = true;
		this.message = message + " Put @ " + System.nanoTime();
		notify();
	}

	// consumer
	public synchronized String getMessage() {
		while (!hasMessage) {
			// no new message
			try {
				wait(); // release the lock of this object
			} catch (InterruptedException e) {}
		}
		// acquire the lock and continue
		hasMessage = false;
		notify();
		return message + " Get @ " + System.nanoTime();
	}
	   
	public static void main(String[] args) {
		
		final MessageBox box = new MessageBox();

		Thread producerThread = new Thread() {
			@Override
			public void run() {
				System.out.println("Producer thread started...");
				for (int i = 1; i <= 6; ++i) {
					box.putMessage("message " + i);
					System.out.println("Put message " + i);
				}
			}
		};

		Thread consumerThread1 = new Thread() {
			@Override
			public void run() {
				System.out.println("Consumer thread 1 started...");
				for (int i = 1; i <= 3; ++i) {
					System.out.println("Consumer thread 1 Get " + box.getMessage());
				}
			}
		};

		Thread consumerThread2 = new Thread() {
			@Override
			public void run() {
				System.out.println("Consumer thread 2 started...");
				for (int i = 1; i <= 3; ++i) {
					System.out.println("Consumer thread 2 Get "	+ box.getMessage());
				}
			}
		};

		consumerThread1.start();
		consumerThread2.start();
		producerThread.start();
		
	}

}
