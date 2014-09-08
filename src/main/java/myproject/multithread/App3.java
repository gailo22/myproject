package myproject.multithread;

public class App3 {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {

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
			
		});
		
		t1.start();
		
		System.out.println("finish");
	}

}
