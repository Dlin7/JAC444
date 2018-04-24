package account;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Input {
	private static ObjectOutputStream output; // outputs data to file
	
	public static void main(String[] args){
		openFile();
		addRecords();
		closeFile();
		System.out.println("task finished");
		return;
	}

	// open file clients.ser
	public static void openFile(){
		try{
    		output = new ObjectOutputStream(Files.newOutputStream(Paths.get("clients.ser")));

		}catch (IOException ioException){
		    System.err.println("Error opening file. Terminating.");
		    System.exit(1); // terminate the program
		  }
	}

	
	public static void addRecords(){
		Scanner input = new Scanner(System.in);
	    System.out.printf("%s%n%s%n? ",
		"Enter account number, first name, last name and balance.",
		"Enter end-of-file indicator to end input.");
		
		while (input.hasNext()) 
		{
		   try{
			Account record = new Account(input.nextInt(), input.next(), input.next(), input.nextDouble());
			
			System.out.println(record.getAccount());
			System.out.println(record.getFName());
			System.out.println(record.getLName());
			System.out.println(record.getBalance());


			output.writeObject(record);
			
		    }catch (NoSuchElementException elementException){
		    	System.err.println("Invalid input. Please try again.");
				input.nextLine(); 
			}catch (IOException ioException){
				System.err.println("Error writing to file. Terminating.");
				System.err.println(ioException);
				break;
			} System.out.print("? ");
		}
	}
	
	// close file and terminate application
	public static void closeFile(){
		try{
			if (output != null)
				System.out.println("end of file");
				output.close();
			}catch (IOException ioException){	 
					System.err.println("Error closing file. Terminating.");
		    }
	}
		



}
