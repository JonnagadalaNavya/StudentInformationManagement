package student.info.management;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author jNavya
 * Created Date: 21 October 2021 
 * Created Student Information Management System
 * 
 */
public class StudentInfoManagement {
	
	public static void main(String[] args) {
		CrudOperations cd = new CrudOperations();
		List<StudentDetails> students = new ArrayList<>();
		while (true) {
			Scanner sc = new Scanner(System.in);
			display();
			String choice = sc.nextLine();
			switch (choice) {
			case "1":
				cd.addStudent(students,sc);
				break;
			case "2":
				cd.deleteStudent(students,sc);
				break;
			case "3":
				cd.updateStudent(students,sc);
				break;
			case "4":
				cd.viewStudent(students);
				break;
			case "5":
				cd.searchStudent(students,sc);
				break;
			case "6":
				System.out.println("Exit from the app");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Input");
				break;
			}
		}
	}

	/**
	 * this method displays switch case to the user 
	 */
	private static void display() {
		System.out.println("---------Student Info management--------\n1 : add\n2 : delete\n3 : update\n4 : view\n5 : search\n6 : exit\nPlease enter your choice:");
	}

	
}
