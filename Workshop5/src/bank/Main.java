package bank;

public class Main {
	public static void main(String[] args) {
		Account accObj = new Account(0);
		
		Dollar(accObj);
		System.out.println("");
		Euro(accObj);
		System.out.println("");
		Pound(accObj);

	}
	
	public static void Dollar(Account accObj) {
		FriendThread friend = new FriendThread();
		YourThread you = new YourThread();
		
		you.Process(1, accObj, "Dollar");
		friend.Process(1, accObj, "Dollar");
		
		you.start();
		try {
			you.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		friend.start();
		try {
			friend.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Euro(Account accObj) {
		FriendThread friend = new FriendThread();
		YourThread you = new YourThread();
		
		you.Process(2, accObj, "Euros");
		friend.Process(2, accObj, "Euros");
		
		you.start();
		try {
			you.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		friend.start();
		try {
			friend.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void Pound(Account accObj) {
		FriendThread friend = new FriendThread();
		YourThread you = new YourThread();
		
		you.Process(3, accObj, "Pounds");
		friend.Process(3, accObj, "Pounds");
		
		you.start();
		try {
			you.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		friend.start();
		try {
			friend.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	
}


