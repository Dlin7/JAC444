package bank;

public class YourThread extends Thread {
	Account obj;
	int amount = 0;
	String currency = "";
	
	@Override
	public synchronized void run() {
		while (obj.isEmpty() == false) {
			try {
				System.out.println("Waiting for withdraw");
				wait();
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("==== " + Thread.currentThread().getName() + " Deposit " + currency + " is running ====");

		if (obj.getBalance() == 0) {
			obj.deposit(amount);
			
			System.out.println(amount + " " + currency + " has been deposited");
			System.out.println("New balance after deposit: " + obj.getBalance());
			
			if (obj.getBalance() > 0) {
				obj.empty(false);
			}
			notifyAll();
			System.out.println("Account" + (obj.isEmpty()? " is ": " is not ") + "empty");
			
		} 
		else {
			System.out.println("Account is not empty");
		}
		
		
		
		
	}
	
	public void Process(int amount, Account receivedObj, String currency) {
		this.obj = receivedObj;
		this.amount = amount;
		this.currency = currency;
	}
}
