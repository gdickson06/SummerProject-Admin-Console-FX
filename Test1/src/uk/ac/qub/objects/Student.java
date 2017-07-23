package uk.ac.qub.objects;

public class Student {
	
	int studentNumber;
	String name, firstName, surname;
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return surname;
	}

	public void setLastName(String lastName) {
		this.surname = lastName;
	}

	String firstGroup;
	String email;
	int intakeYear;
	String Password;

	public Student(int studentNumber, String name, String firstGroup, String email, int intakeYear) {
		this.studentNumber = studentNumber;
		this.name = name;
		this.firstGroup = firstGroup;
		this.email = email;
		this.intakeYear = intakeYear;
	}
	
	public Student(int studentNumber, String name, String firstGroup, String email) {
		this.studentNumber = studentNumber;
		this.name = name;
		this.firstGroup = firstGroup;
		this.email = email;
	}
	
	//creating constructor for ComboSearchStudents in the SearchQueries.java class
	public Student(String name, int studentNumber, String firstGroup, int intakeYear, String email){
		this.name=name;
		this.studentNumber=studentNumber;
		this.firstGroup=firstGroup;
		this.intakeYear=intakeYear;
		this.email=email;
	}

	@Override
	public String toString() {
		return "Student Details [First Name: " + name + ", Student Number: " + studentNumber + ", Cohort: " + firstGroup
				+ ", Surname: " + name + ", Intake Year: " + intakeYear + ", E-mail Address: "+email+"]";
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public int getStudentNumber() {
		return studentNumber;
	}

	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstGroup() {
		return firstGroup;
	}

	public void setFirstGroup(String firstGroup) {
		this.firstGroup = firstGroup;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String secondGroup) {
		this.email = secondGroup;
	}

	public int getIntakeYear() {
		return intakeYear;
	}

	public void setIntakeYear(int intakeYear) {
		this.intakeYear = intakeYear;
	}
	
	

}
