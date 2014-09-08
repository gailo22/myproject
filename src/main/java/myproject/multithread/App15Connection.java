package myproject.multithread;

import java.util.concurrent.Semaphore;

public class App15Connection {
	
	private static App15Connection instance = new App15Connection();
	
	private Semaphore sem = new Semaphore(10);
	
	private int connections = 0;
	
	private App15Connection() {}
	
	public static App15Connection getInstance() {
		return instance;
	}
	
	public void connect() {
		try {
			sem.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		try {
			doConnect();
		}
		finally {
			sem.release();
		}
	}
	
	public void doConnect() {
		
		synchronized (this) {
			connections++;
			System.out.println("Current connections: " + connections);
		}
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		synchronized (this) {
			connections--;
			System.out.println("Current connections: " + connections);
		}
		
	}

}
