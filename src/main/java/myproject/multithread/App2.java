package myproject.multithread;

public class App2 implements Runnable {
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new App2());
		Thread t2 = new Thread(new App2());
		
		t1.start();
		t2.start();
		
		System.out.println("finish");
		
	}

	@Override
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println("Hello: " + i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
