package myproject.multithread;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class App13Runner {
	
	private App13Account acc1 = new App13Account();
	private App13Account acc2 = new App13Account();
	
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	public void firstThread() throws InterruptedException {
		Random random = new Random();
		
		for (int i = 0; i < 10000; i++) {
			
			lock1.lock();
			lock2.lock();
			
			try {
				App13Account.transfer(acc1, acc2, random.nextInt(100));
			}
			finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
	}
	
	public void secondThread() throws InterruptedException {
		Random random = new Random();
		
		for (int i = 0; i < 10000; i++) {
			lock2.lock();
			lock1.lock();
			
			try {
				App13Account.transfer(acc2, acc1, random.nextInt(100));
			}
			finally {
				lock1.unlock();
				lock2.unlock();
			}
		}
		
	}
	
	public void finished() {
		System.out.println("Account 1 balance: " + acc1.getBalance());
		System.out.println("Account 2 balance: " + acc2.getBalance());
		System.out.println("Total balance: " + (acc1.getBalance() + acc2.getBalance()));
	}

}
