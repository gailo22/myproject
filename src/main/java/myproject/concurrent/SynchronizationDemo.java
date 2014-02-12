package myproject.concurrent;

public class SynchronizationDemo {

	public static void main(String[] args) {

		Callme target = new Callme();
		Caller c1 = new Caller(target, "hello");
		Caller c2 = new Caller(target, "synchronized");
		Caller c3 = new Caller(target, "world");

		try {
			c1.t.join();
			c2.t.join();
			c3.t.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

class Callme {
	synchronized void call(String msg) {
		System.out.println("message: " + msg);

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

class Caller implements Runnable {

	String msg;
	Callme target;
	Thread t;

	Caller(Callme target, String s) {
		this.target = target;
		msg = s;
		t = new Thread(this);
		t.start();
	}

	@Override
	public void run() {
		target.call(msg);
	}
}
