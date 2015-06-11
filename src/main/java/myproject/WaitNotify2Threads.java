package myproject;


public class WaitNotify2Threads {

	public static void main(String[] args) {
		
		Object obj1 = new Object();
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {

				System.out.println("t1: before wait");
				doSomething1();
				System.out.println("t1: after wait");
			}

			private void doSomething1() {
				synchronized (obj1) {
					for (int i = 0; i<10; i++) {
						try {
							System.out.println("t1:" + i);
							obj1.notify();
							obj1.wait(500);
							Thread.sleep(500);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				System.out.println("t2: before wait");
				doSomething2();
				System.out.println("t2: after wait");
				
			}
			
			private void doSomething2() {
				synchronized (obj1) {
					for (int i = 0; i<5; i++) {
						try {
							System.out.println("t2: " + i);
							obj1.notify();
							obj1.wait();
							Thread.sleep(1000);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						
					}
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
