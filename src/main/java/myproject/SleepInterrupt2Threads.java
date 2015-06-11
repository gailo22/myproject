package myproject;

public class SleepInterrupt2Threads {
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("t1: before sleep");
				doSomething();
				System.out.println("t1: after sleep");
			}

			private void doSomething() {
				for (int i = 0; i<5; i++) {
					System.out.println("t1: " + i);
					try {
						// sleep forever
						Thread.sleep(Long.MAX_VALUE);
					} catch (InterruptedException e) { }
				}
			}
		});
		
		t1.start();
		
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// sleep for 5 secs and then interrupt t1
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				System.out.println("try to interrupt t1");
				for (int i = 0; i<5; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println("t2: interrupt " + i);
					t1.interrupt();
					
				}
			}
		});
		
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("main ended");
	}

}
