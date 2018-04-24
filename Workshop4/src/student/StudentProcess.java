package student;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.Optional;



public class StudentProcess {
	public static void main(String[] args) {

		List<Student> lists = Arrays.asList(
				new Student("Jack", "Smith", 50.0, "IT"),
				new Student("Aaron", "Johnson", 76.0, "IT"),
				new Student("Maaria", "White", 35.8, "Business"),
				new Student("John", "White", 47.0, "Media"),
				new Student("Laney", "White", 62.0, "IT"),
				new Student("Jack", "Jones", 32.9, "Business"),
				new Student("Wesley", "Jones", 42.89, "Media")
				);

		
		Task1(lists);
		Task2(lists);
		Task3(lists);
		Task4(lists);
		Task5(lists);
		Task6(lists);
		Task7(lists);
		Task8(lists);
		Task9(lists);
		Task10(lists);
	}
	
	public static void Task1(List<Student> lists) {
		System.out.println("Task 1: \n");
		System.out.println("Complete Student list: ");
		lists.forEach(System.out::println);
		System.out.println("\n");
	}
	
	public static void Task2(List<Student> lists) {
		Comparator<Student> byGrade = (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade());
		
		List<Student> filteredList = lists.stream()
				.sorted(byGrade)
				.filter(list -> list.grade >= 50)
				.collect(Collectors.toList());
		
		System.out.println("Task 2: \n");
		System.out.println("Students who got 50.0-100.0 sorted by grade: ");
		filteredList.forEach(System.out::println);
		System.out.println("\n");
	}
	
	public static void Task3(List<Student> lists) {
		Comparator<Student> byGrade = (s1, s2) -> Double.compare(s1.getGrade(), s2.getGrade());
		
		Optional<Student> filteredList = lists.stream()
				.sorted(byGrade)
				.filter(list -> list.grade >= 50)
				.findFirst();
		
		
		
		System.out.println("Task 3: \n");
		System.out.println("First Student who got 50.0-100.0:");
		System.out.println(filteredList.get());
		System.out.println("\n");

	}
	
	public static void Task4(List<Student> lists) {
		Comparator<Student> byLName = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {

				String LName1 = s1.getLName().toUpperCase();
				String LName2 = s2.getLName().toUpperCase();
				
				return LName1.compareTo(LName2);
			}
		};
		
		Comparator<Student> byFName = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {

				String FName1 = s1.getFName().toUpperCase();
				String FName2 = s2.getFName().toUpperCase();
				
				
				return FName1.compareTo(FName2);
			}
		};
		

		
		List<Student> filteredList1 = lists.stream()
				.sorted(byFName)
				.sorted(byLName)
				.collect(Collectors.toList());
		
		List<Student> filteredList2 = lists.stream()
				.sorted(Collections.reverseOrder(byFName))
				.sorted(Collections.reverseOrder(byLName))
				.collect(Collectors.toList());
		
		System.out.println("Task 4: \n");
		System.out.println("Students in ascending order by last name then first: ");
		filteredList1.forEach(System.out::println);
		System.out.println("");
		
		System.out.println("Students in descending order by last name then first: ");
		filteredList2.forEach(System.out::println);
		System.out.println("\n");
		
	}
	
	public static void Task5(List<Student> lists) {
	
		List<String> filteredList = lists.stream()
				.map(list -> list.getLName())
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		
//		List<String> strings = filteredList1.stream()
//				   .map(list -> Objects.toString(list, null))
//				   .collect(Collectors.toList());
		
//		Set<String> uniqueLNames = new HashSet<String>(strings);
		
		System.out.println("Task 5: ");
		filteredList.forEach(System.out::println);
		System.out.println("");
	}
	
	public static void Task6(List<Student> lists) {
		Comparator<Student> byLName = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {

				String LName1 = s1.getLName().toUpperCase();
				String LName2 = s2.getLName().toUpperCase();
				
				return LName1.compareTo(LName2);
			}
		};
		
		Comparator<Student> byFName = new Comparator<Student>() {
			public int compare(Student s1, Student s2) {
				String FName1 = s1.getFName().toUpperCase();
				String FName2 = s2.getFName().toUpperCase();
				
				
				return FName1.compareTo(FName2);
			}
		};
		
		List<Student> filteredList1 = lists.stream()
				.sorted(byFName)
				.sorted(byLName)
				.collect(Collectors.toList());
		
		Stream<Object> filteredList2 = filteredList1.stream()
				.map(list -> list.getName());
		
		System.out.println("Task 6: \n");
		System.out.println("Student names in order by last name then first name: ");
		filteredList2.forEach(System.out::println);
		System.out.println("\n");
	}
	
	public static void Task7(List<Student> lists) {	
		System.out.println("Task 7: \n");
		System.out.println("Students by department: ");
		

		
//		Map<String, Student> MediaHashMap = new TreeMap<>(MediaMap);
		
		System.out.println("Media");
		
		Map<String, Student> MediaMap = lists.stream()
				.filter(list -> list.department == "Media")
				.collect(Collectors.toMap(Student::getName, item -> item));
		
		MediaMap.forEach((name, record) -> System.out.print("   " + record + "\n"));
		
		
		System.out.println("IT");
		
		Map<String, Student> ITMap = lists.stream()
				.filter(list -> list.department == "IT")
				.collect(Collectors.toMap(Student::getName, item -> item));
		
		ITMap.forEach((name, record) -> System.out.print("   " + record + "\n"));

		
		System.out.println("Business");

		Map<String, Student> BusinessMap = lists.stream()
				.filter(list -> list.department == "Business")
				.collect(Collectors.toMap(Student::getName, item -> item));
		
		BusinessMap.forEach((name, record) -> System.out.print("   " + record + "\n"));
		System.out.println("\n");
	}
	
	public static void Task8(List<Student> lists) {	
		System.out.println("Task 8: \n");
		System.out.println("Count of Students by department: ");

		Map<String, Double> BusinessCount = lists.stream()
				.filter(list -> list.department == "Business")
				.collect(Collectors.toMap(Student::getName, Student::getGrade));
		
		Map<String, Double> ITCount = lists.stream()
				.filter(list -> list.department == "IT")
				.collect(Collectors.toMap(Student::getName, Student::getGrade));
		
		Map<String, Double> MediaCount = lists.stream()
				.filter(list -> list.department == "Media")
				.collect(Collectors.toMap(Student::getName, Student::getGrade));
		
		System.out.println("Business has " + BusinessCount.size() + " Student(s)");
		System.out.println("IT has " + ITCount.size() + " Student(s)");
		System.out.println("Media has " + MediaCount.size() + " Student(s)");
		
		System.out.println("\n");
	}
	
	public static void Task9(List<Student> lists) {
		System.out.println("Task 9: \n");
		
		DoubleStream sumStream = lists.stream()
				.mapToDouble(Student::getGrade);
		
		double sum = sumStream.sum();
		
		System.out.println("Sum of Students' grades: " + sum);
		System.out.println("\n");
	}
	
	public static void Task10(List<Student> lists) {
		System.out.println("Task 10: \n");
		
		DoubleStream sumStream = lists.stream()
				.mapToDouble(Student::getGrade);
		
		double average = sumStream.average().getAsDouble();
		
		System.out.printf("Average of Students' grades: %.2f", average);
	}
}
