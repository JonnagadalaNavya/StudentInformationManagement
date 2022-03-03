package student.info.management;

import java.util.List;
import java.util.Scanner;

/**
 * @author jNavya
 * Created Date: 21 October 2021
 * This class implements validate methods for the scanner inputs
 */
public class InputValidatingFunctions {
	
	/**
	 * This method validates Student Id scanner input
	 * @param students ArrayList of student details
	 * @param sc Scanner input
	 * @return Student Id
	 */
	public int idValidation(List<StudentDetails> students, Scanner sc) {
		CrudOperations crudObject = new CrudOperations();
		int studentId;
		while (true) {
			String sid = sc.next();
			if (isNumeric(sid)) {
				studentId = Integer.parseInt(sid);
				boolean bool = crudObject.isSidRepeat(studentId, students);
				if (bool)
					System.out.println("Id is repeated");
				else
					break;
			} else
				System.out.println("Enter valid id");
		}
		return studentId;
	}

	/**
	 * This method validates FIRST NAME and LAST NAME scanner input
	 * @param sc Scanner input
	 * @returns name
	 */
	public String nameValidation(Scanner sc) {
		String name;
		while (true) {
			name = sc.next();
			boolean checkName = verifyName(name);
			if (checkName)
				break;
			else
				System.out.println("Enter valid Name");
		}
		return name;
	}
	
	private boolean verifyName(String name) {
		name = name.trim();
		return (name == null || name.equals("") || !name.matches("[a-zA-Z]*"))?false:true;
		
	}

	/**
	 * This method validates AGE scanner input
	 * @param sc
	 * @returns age
	 */
	public int ageValidation(Scanner sc) {
		String info;
		int age;
		while (true) {
			info = sc.next();
			if (isNumeric(info)) {
				age = Integer.parseInt(info);
				boolean checkAge = verifyAge(age);
				if (checkAge)
					break;
				else
					System.out.println("Enter valid age group");
			} else
				System.out.println("Enter valid age group");
		}
		return age;
	}
	
	private boolean verifyAge(int age) {
		return age < 0 || age > 100 ?false:true;
	}

	/**
	 * This method validates branch scanner input 
	 * @param sc
	 * @return branch
	 */
	public String branchValidation(Scanner sc) {
		String branch;
		while (true) {
			branch = sc.next();
			boolean checkBranch = verifyBranch(branch);
			if (checkBranch)
				break;
			else
				System.out.println("Enter valid Name");
		}
		return branch;
	}

	private boolean verifyBranch(String branch) {
		return (branch.length() != 3) ? false : true;
	}

	/**
	 * this method validates the CGPA scanner input
	 * @param sc Scanner Input
	 * @return CGPA
	 */
	public double cgpaValidation(Scanner sc) {
		String info;
		double cgpa;
		while (true) {
			info = sc.next();
			if (isNumeric(info)) {
				cgpa = Double.parseDouble(info);
				boolean checkCgpa = verifyCgpa(cgpa);
				if (checkCgpa)
					break;
				else
					System.out.println("Enter valid Cgpa group");
			} else
				System.out.println("Enter valid Cgpa group");
		}
		return cgpa;
	}

	private boolean verifyCgpa(double cgpa) {
		return (cgpa < 0.0 || cgpa > 10.0)?false:true;		
	}
	
	public boolean isNumeric(String value) {
		if (value == null)
			return false;
		try {
			Double.parseDouble(value);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
