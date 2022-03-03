package student.info.management;


/**
 * @author jNavya
 * Created Date: 21 October 2021
 * Students details class
 */
public class StudentDetails {
	
	int id;
	String firstName;
	String lastName;
	int age;
	String branch;
	double cgpa;
	StudentDetails(int id, String firstName, String lastName, int age, String branch, double cgpa){
		this.id=id;
		this.firstName=firstName;
		this.lastName=lastName;
		this.age=age;
		this.branch=branch;
		this.cgpa = cgpa;
	}
	public int getId() {
	    return id;
	    }
	public void setId(int id) {
	    this.id=id;
	    }
	 
    public String getFirstName() {
    	return firstName;
    }
    public void setFirstName(String firstName) {
    	this.firstName = firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    public void setLastName(String lastName) {
    	this.lastName = lastName;
    }
    
    public int getAge() {
	    return age;
	}
    public void setAge(int age) {
	    this.age = age;
	}
    public String getBranch() {
    	return branch;
    }
    public void setBranch(String branch) {
    	this.branch = branch;
    }
    public double getCgpa() {
    	return cgpa;
    }
    public void setCgpa(double cgpa) {
    	this.cgpa = cgpa;
    }
    public String toString() {
		return "STUDENT ID: "+id+" FIRST NAME: "+firstName+" LAST NAME: "+lastName+ " AGE: "+age+" BRANCH: "+branch+" CGPA: "+cgpa;

    }
}
