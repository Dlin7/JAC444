package account;

import java.io.Serializable;


public class Account implements Serializable {
	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	
	public Account() {
		this(0, "", "", 0.0);
	}
	
	public Account(int account, String fname, String lname, double balance) {
		this.account = account;
		this.firstName = fname;
		this.lastName = lname;
		this.balance = balance;
	}
	
	public void setAccount(int num) {
		this.account = num;
	}
	
	public void setFName(String fname) {
		this.firstName = fname;
	}
	
	public void setLName(String lname) {
		this.lastName = lname;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public int getAccount() {
		return account;
	}
	
	public String getFName() {
		return firstName;
	}
	
	public String getLName() {
		return lastName;
	}
	
	public double getBalance() {
		return balance;
	}
}
