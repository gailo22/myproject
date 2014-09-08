package myproject.multithread;

import java.util.Scanner;


class Processor4 extends Thread {
	
	private volatile boolean running = true;
	
	@Override
	public void run() {
		
		while (running) {
			System.out.println("Helloooo");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void shutdown() {
		this.running = false;
	}
}

public class App4Volatile {

	public static void main(String[] args) {

		Processor4 proc1 = new Processor4();
		
		proc1.start();
		
		System.out.println("Press any key to stop: ");
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		proc1.shutdown();
	}

}
