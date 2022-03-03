package student.info.management;

import java.util.List;
import java.util.Scanner;
import student.info.management.InputValidatingFunctions;

/**
 * @author jNavya 
 * Created Date: 21 October 2021
 * Implemented ADD, DELETE, UPDATE, VIEW and SEARCH operations on
 *         Student Information Management.
 */
public class CrudOperations {

	/**
	 * This function implements ADD operation on student information management system
	 * @param students: ArrayList of student details
	 * @param sc: Scanner input
	 */
	public void addStudent(List<StudentDetails> students, Scanner sc) {
		InputValidatingFunctions validateObj = new InputValidatingFunctions();
		int studentId, age = 0;
		String firstName, lastName, branch = null;
		double cgpa;
		System.out.println("Enter Student Id:");
		studentId = validateObj.idValidation(students, sc);
		System.out.println("Enter your First Name:");
		firstName = validateObj.nameValidation(sc);
		System.out.println("Enter your Last Name:");
		lastName = validateObj.nameValidation(sc);
		System.out.println("Enter your Age:");
		age = validateObj.ageValidation(sc);
		System.out.println("Enter your Branch like('cse','ece'):");
		branch = validateObj.branchValidation(sc);
		System.out.println("Enter your CGPA:");
		cgpa = validateObj.cgpaValidation(sc);

		StudentDetails student = new StudentDetails(studentId, firstName, lastName, age, branch, cgpa);
		students.add(student);
		System.out.println("ADDED SUCCESSFULLY");
	}

	/**
	 * This function implements DELETE operation on student information management system
	 * @param students: ArrayList of student details
	 * @param sc: Scanner input
	 */
	public void deleteStudent(List<StudentDetails> students, Scanner sc) {
		InputValidatingFunctions validateObj = new InputValidatingFunctions();
		CrudOperations crudObject = new CrudOperations();
		int studentId;
		if (students.size() > 0) {
			System.out.println("Please select the student Id to delete");
			while (true) {
				String rawInput = sc.next();
				if (validateObj.isNumeric(rawInput)) {
					studentId = Integer.parseInt(rawInput);
					boolean bool = crudObject.isSidRepeat(studentId, students);
					if (bool) {
						int id = getIndex(studentId, students);
						students.remove(id);
						System.out.println("DELETED SUCCESSFULLY");
						break;
					} else {
						System.out.println("Student Id is not present");
						break;
					}
				} else System.out.println("Enter valid Student Id");
			}
		} else
			System.out.println("Student List is EMPTY!!!!!");
	}
	
	/**
	 * This function implements UPDATE operation on student information management system
	 * @param students: ArrayList of student details
	 * @param sc: Scanner input
	 */
	public void updateStudent(List<StudentDetails> students, Scanner sc) {
		InputValidatingFunctions validateObj = new InputValidatingFunctions();
		CrudOperations crudObject = new CrudOperations();

		int studentId;
		if (students.size() > 0) {
			System.out.println("Enter the student Id details to be updated");
			while (true) {
				String rawInput = sc.next();
				if (validateObj.isNumeric(rawInput)) {
					studentId = Integer.parseInt(rawInput);
					boolean bool = crudObject.isSidRepeat(studentId, students);	
					if (bool) {
						int index = getIndex(studentId, students);
						System.out.println("1 : Modify First Name\n2 : Modify Last Name\n3 : Modify age\n4 : Modify cgpa\nPlease enter your choice:");
						String command = sc.next();
						switch (command) {
						case "1":
							modifyFirstName(students, index, sc);
							break;
						case "2":
							modifyLastName(students, index, sc);
							break;
						case "3":
							modifyAge(students, index, sc);
							break;
						case "4":
							modifyCgpa(students, index, sc);
							break;
						default:
							break;
						}
						break;
					}else {
						System.out.println("Student Id entered is not present in the list");
						break;
					}
			}else 
				System.out.println("Enter valid input");
		}
		}else
			System.out.println("Student List is EMPTY!!!!!");
	}

	private static void modifyCgpa(List<StudentDetails> students, int index, Scanner sc) {
		InputValidatingFunctions validateObj = new InputValidatingFunctions();

		System.out.println("Enter cgpa to be modified");
		students.get(index).setCgpa(validateObj.cgpaValidation(sc));
	}

	private static void modifyAge(List<StudentDetails> students, int index, Scanner sc) {
		InputValidatingFunctions validateObj = new InputValidatingFunctions();

		System.out.println("Enter age to be modified");
		students.get(index).setAge(validateObj.ageValidation(sc));
	}

	private static void modifyFirstName(List<StudentDetails> students, int index, Scanner sc) {
		InputValidatingFunctions validateObj = new InputValidatingFunctions();

		System.out.println("Enter name to be modified");
		students.get(index).setFirstName(validateObj.nameValidation(sc));
	}

	private static void modifyLastName(List<StudentDetails> students, int index, Scanner sc) {
		InputValidatingFunctions validateObj = new InputValidatingFunctions();

		System.out.println("Enter name to be modified");
		students.get(index).setLastName(validateObj.nameValidation(sc));
	}

	/**
	 * This function implements VIEW operation on student information management system
	 * @param students: ArrayList of student details
	 */
	public void viewStudent(List<StudentDetails> students) {

		if (students.size() > 0) {
			System.out.println("List of Student details");
			students.forEach((c) -> System.out.println(c));
		} else
			System.out.println("Student List is EMPTY!!!!!");
	}
	
	/**
	 * This function implements SEARCH operation on student information management system
	 * @param students: ArrayList of student details
	 * @param sc: Scanner input
	 */
	public void searchStudent(List<StudentDetails> students, Scanner sc) {
		if (students.size() > 0) {
			System.out.println("Please enter the student number of the student you want to find:");
			int studentId = sc.nextInt();
			Boolean bool = isSidRepeat(studentId, students);
			if (bool) {
				int index = getIndex(studentId, students);
				System.out.println(students.get(index).toString());
			} else
				System.out.println("No relevant student information was found!");
		} else
			System.out.println("Student List is EMPTY!!!!!");
	}

	/**
	 * This functions checks for the index of the student Id in students details
	 * @param studentid: Student Id 
	 * @param students: ArrayList of Student details
	 * @return index of Student Id
	 */
	public int getIndex(int studentId, List<StudentDetails> students) {
		
		for (int i = 0; i < students.size(); i++) {
			StudentDetails student = students.get(i);
			if (studentId == student.getId()) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * This function checks whether student Id is repeated or not
	 * @param studentid: Student Id 
	 * @param students: ArrayList of Student details
	 * @return boolean (true/false)
	 */
	public boolean isSidRepeat(int studentId, List<StudentDetails> students) {
		for (int i = 0; i < students.size(); i++) {
			StudentDetails student = students.get(i);
			if (studentId == student.getId()) {
				return true;
			}
		}
		return false;
	}

}
