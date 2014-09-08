package myproject.multithread;

public class App1 extends Thread {
	
	
	public static void main(String[] args) {
		App1 t1 = new App1();
		App1 t2 = new App1();
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("finished");
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
