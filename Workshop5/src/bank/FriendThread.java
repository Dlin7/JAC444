package bank;

public class FriendThread extends Thread {
	Account obj;
	int amount = 0;
	String currency = "";
	
	@Override
	public synchronized void run() {
		while (obj.isEmpty() == true) {
			try {
				
				System.out.println("Waiting for deposit");
				wait();
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("==== " + Thread.currentThread().getName() + " Withdraw " + currency + " is running ====");
		
		if (obj.getBalance() > 0 && obj.getBalance() >= amount) {
			obj.withdraw(amount);
			
			System.out.println(amount + " " + currency + " has been withdrawn");
			System.out.println("New balance after withdrawal: " + obj.getBalance());
			
			if (obj.getBalance() == 0) {
				obj.empty(true);
				System.out.println("Account" + (obj.isEmpty()? " is ": " is not ") + "empty");
				notifyAll();
			}
			else {
				System.out.println("Account" + (obj.isEmpty()? " is ": " is not ") + "empty. Cannot deposit another currency");

				while (obj.getBalance() != 0) {
					obj.withdraw(amount);
					System.out.println(obj.getBalance());
				}
				notifyAll();
			}
			
			

		} 
		else {
			System.out.println("Insufficient funds");
		}
		
		 
	}
	
	public void Process(int amount, Account receivedObj, String currency) {
		this.obj = receivedObj;
		this.amount = amount;
		this.currency = currency;
	}
}
