package bank;

public class Account {
	int balance = 0;
	boolean empty = true;
	
	public Account() {
		this.balance = 0;
	}
	
	public Account(int deposit) {
		this.balance = deposit;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public void deposit(int bal) {
		this.balance += bal;
	}
	
	public void withdraw(int bal) {
		this.balance -= bal;
	}
	
	public boolean isEmpty() {
		return this.empty;
	}
	
	public void empty(boolean cond) {
		this.empty = cond;
	}
}
