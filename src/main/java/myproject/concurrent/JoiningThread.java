package myproject.concurrent;

import java.util.Date;

public class JoiningThread {

	public static void main(String[] args) throws InterruptedException {
		
		RunnableJob runnableJob = new RunnableJob();
		InfiniteRunnableJob infiniteRunnableJob = new InfiniteRunnableJob();
		
		Thread thread = Thread.currentThread();
		
		System.out.println(thread.getName() + " thread is running... at " + new Date());
		
		Thread thread1 = new Thread(runnableJob, "T1");
		Thread thread2 = new Thread(runnableJob, "T2");
		Thread thread3 = new Thread(runnableJob, "T3");
		Thread thread4 = new Thread(runnableJob, "T4");
		
		thread1.start();
		thread1.join();
		
		thread2.start();
		thread2.join();
		
		thread3.start();
		thread3.join();
		
		thread4.start();
		thread4.join();
		
		
		Thread thread5 = new Thread(runnableJob, "T5");
		Thread thread6 = new Thread(runnableJob, "T6");
		Thread thread7 = new Thread(runnableJob, "T7");
		Thread thread8 = new Thread(runnableJob, "T8");
		
		thread5.start();
		thread6.start();
		thread7.start();
		thread8.start();
		
		Thread thread9 = new Thread(infiniteRunnableJob, "T9");
		Thread thread10 = new Thread(infiniteRunnableJob, "T10");
		thread9.setDaemon(true);
		thread10.setDaemon(true);
		
		thread9.start();
		thread10.start();
		
		System.out.println(thread.getName() + " is alive:  " + thread.isAlive());
		
	}



}
