package account;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int choice = 0;
		
		System.out.println("1. Create new account");
		System.out.println("2. Display records");
		System.out.println("3. Exit");

		Scanner menu = new Scanner(System.in);

		
		while (true) {


			
			if(menu.hasNextInt()) 
			{
				choice = menu.nextInt();
			}
			else {
				choice = 2;
			}
	
			//choice = menu.nextInt();
	
			switch(choice) {
			case 1:
				//Account[] accObj = new Account[100];
				//index++;
				//accObj[index] = new Account();
				//Input.enterInput(index, accObj, menu);
//				Input.main(args);
				CreateAccounts.main(args);
				InsertAccounts.main(args);

				break;
				
			case 2:
//				FileReader.main(args);
				QueryAccounts.main(args);
				System.exit(0);
				break;
			case 3:
				menu.close();
				System.exit(0);
			}
			
			//choice = menu.nextInt();
		
		//menu.close();

		
		//System.out.println(index);
		}
	}
	

}
