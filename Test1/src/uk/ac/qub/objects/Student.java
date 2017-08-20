package uk.ac.qub.objects;

public class Student {
	
	@Override
	public String toString() {
		return "student number:" + studentNumber + " name:" + name + " cohort:" + cohort
				+ " year:" + year ;
	}


	int studentNumber;
	String lastName,firstName,middleName,prefix,name,cohort,email,nationality,graduate,comments,portfolio,year;
	
	
	public Student(int studentNumber, String lastName, String firstName, String middleName, String prefix, String name,
			String cohort, String email, String nationality, String graduate, String comments, String portfolio,
			String year) {
		this.studentNumber = studentNumber;
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.prefix = prefix;
		this.name = name;
		this.cohort = cohort;
		this.email = email;
		this.nationality = nationality;
		this.graduate = graduate;
		this.comments = comments;
		this.portfolio = portfolio;
		this.year = year;
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


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getMiddleName() {
		return middleName;
	}


	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}


	public String getPrefix() {
		return prefix;
	}


	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCohort() {
		return cohort;
	}


	public void setCohort(String cohort) {
		this.cohort = cohort;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public String getGraduate() {
		return graduate;
	}


	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}


	public String getComments() {
		return comments;
	}


	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getPortfolio() {
		return portfolio;
	}


	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}


	public String getYear() {
		return year;
	}


	public void setYear(String year) {
		this.year = year;
	}

	

}
