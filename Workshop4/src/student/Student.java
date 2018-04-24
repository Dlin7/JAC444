package student;


public class Student  {
	String firstName;
	String lastName;
	double grade;
	String department;
	
	public Student() {
		
	}
	
	public Student(String firstName, String lastName, double grade, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.grade = grade;
		this.department = department;
	}
	
	public String getName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getFName() {
		return this.firstName;
	}
	
	public String getLName() {
		return this.lastName;
	}
	
	public double getGrade() {
		return this.grade;
	}
	
	private String department() {
		return this.department;	
	}
	
	
	public String toString() {
		return String.format("%-10s%-10s%-10.2f%-10s", getFName(), getLName(), getGrade(), department());
	}


}
