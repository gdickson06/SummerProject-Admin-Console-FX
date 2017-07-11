package uk.ac.qub.churst;

public class Student {
	
	int studentNumber;
	String name;
	String firstGroup;
	String email;
	int intakeYear;

	public Student(int studentNumber, String name, String firstGroup, String email, int intakeYear) {
		this.studentNumber = studentNumber;
		this.name = name;
		this.firstGroup = firstGroup;
		this.email = email;
		this.intakeYear = intakeYear;
	}
	
	public Student(int studentNumber, String name, String firstGroup, int intakeYear) {
		this.studentNumber = studentNumber;
		this.name = name;
		this.firstGroup = firstGroup;
		this.intakeYear = intakeYear;
	}

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + ", name=" + name + ", firstGroup=" + firstGroup
				+ ", secondGroup=" + email + ", intakeYear=" + intakeYear + "]";
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
