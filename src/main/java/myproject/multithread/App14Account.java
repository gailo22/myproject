package myproject.multithread;

public class App14Account {
	
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
	
	public static void transfer(App14Account acc1, App14Account acc2, int amount) {
		acc1.withdraw(amount);
		acc2.deposit(amount);
	}

}
