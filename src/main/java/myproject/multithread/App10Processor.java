package myproject.multithread;

import java.util.Scanner;

public class App10Processor {
	
	public void produce() throws InterruptedException {
		synchronized (this) {
			System.out.println("Producer thread running...");
			wait();
			System.out.println("Resumed.");
		}
		
	}
	
	public void consume() throws InterruptedException {
		Scanner scanner = new Scanner(System.in);
		Thread.sleep(2000);
		
		synchronized (this) {
			System.out.println("waiting for return key:");
			scanner.nextLine();
			System.out.println("Return key press.");
			notify();
			Thread.sleep(5000);
		}
	}

}
