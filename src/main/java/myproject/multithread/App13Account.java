package myproject.multithread;

public class App13Account {
	
	private int balance = 10000;
	
	public void deposit(int amount) {
		balance += amount;
	}
	
	public void withdraw(int amount) {
		balance -= amount;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public static void transfer(App13Account acc1, App13Account acc2, int amount) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}

}
