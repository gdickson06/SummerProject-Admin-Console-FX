package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson The below is the Student class that
 *         creates Student objects that will be used for the Student
 *         Administration screens within the administration console, as well as
 *         for the login screens for the admin console
 */

public class Student {

	/*
	 * creating the variables below to be used in the Student constructors,
	 * getters, setters and toString methods below
	 */
	int studentNumber;
	String lastName, firstName, middleName, prefix, name, cohort, email, nationality, graduate, comments, portfolio,
			year;

	/**
	 * Below is the primary constructor for the Student class
	 * 
	 * @param studentNumber
	 * @param lastName
	 * @param firstName
	 * @param middleName
	 * @param prefix
	 * @param name
	 * @param cohort
	 * @param email
	 * @param nationality
	 * @param graduate
	 * @param comments
	 * @param portfolio
	 * @param year
	 */
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

	/**
	 * Below is the default constructor for the Student class with no args
	 */
	public Student() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Below is the getter for retrieving the Student Number from the Student
	 * object
	 * 
	 * @return
	 */
	public int getStudentNumber() {
		return studentNumber;
	}

	/**
	 * Below is the setter for setting the Student Numberfor the Student Object.
	 * If the student number is outside of the 00000001-99999999 then an
	 * exception will be thrown
	 * 
	 * @param studentNumber
	 */
	public void setStudentNumber(int studentNumber) {
		if (studentNumber >= 00000000 && studentNumber <= 99999999) {
			this.studentNumber = studentNumber;
		} else {
			throw new IllegalArgumentException("Invalid Student Number Entered");
		}
	}

	/**
	 * Below is the getter for retrieving the Last Name from the Student object
	 * 
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Below is the setter for the Last Name parameter for the Student Object.
	 * If no value is entered an exception will be thrown
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
	
			this.lastName = lastName;
	
	}

	/**
	 * Below is the getter for retrieving the First Name from the Student object
	 * 
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Below is the setter for the First Name parameter for the Student Object.
	 * If no value is entered an exception will be thrown
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
	
this.firstName = firstName;
	
	}

	/**
	 * Below is the getter for retrieving the Middle Name from the Student
	 * object
	 * 
	 * @return
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Below is the setter for the Middle Name parameter for the Student Object.
	 * If no value is entered an exception will be thrown
	 * 
	 * @param middleName
	 */
	public void setMiddleName(String middleName) {
	
			this.middleName=middleName;
		
	}

	/**
	 * Below is the getter for retrieving the Prefix from the Student object
	 * 
	 * @return
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * Below is the setter for setting the Prefix parameter for the Student
	 * Object.
	 * 
	 * @param prefix
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * Below is the getter for retrieving the name parameter from the Student
	 * Object.
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Below is the setter for setting the Name parameter for the Student
	 * Object.
	 * 
	 * @param name
	 */
	public void setName(String name) {
	
			this.name = name;
	
	}

	/**
	 * Below is the getter for retrieving the Cohort parameter from the Student
	 * object
	 * 
	 * @return
	 */
	public String getCohort() {
		return cohort;
	}

	/**
	 * Below is the setter for setting the Cohort parameter from the Student
	 * object. If no Cohort is entered an exception will be thrown
	 * 
	 * @param cohort
	 */
	public void setCohort(String cohort) {

			this.cohort=cohort;
		}
	

	/**
	 * Below is the getter for retrieving the Email Address parameter from the
	 * Student object
	 * 
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Below is the getter for retrieving the Email Address parameter from the
	 * Student object. If no Email Address is Entered an exception will be
	 * thrown
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		
			this.email = email;
		
	}

	/**
	 * Below is the getter for retrieving the nationality parameter from the
	 * Student object
	 * 
	 * @return
	 */
	public String getNationality() {
		return nationality;
	}

	/**
	 * Below is the setter for setting the nationality parameter for the Student
	 * Object
	 * 
	 * @param nationality
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	/**
	 * Below is the getter for retrieving the Graduate parameter from the
	 * Student object
	 * 
	 * @return
	 */
	public String getGraduate() {
		return graduate;
	}

	/**
	 * Below is the setter for setting the graduate parameter for the Student
	 * object
	 * 
	 * @param graduate
	 */
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}

	/**
	 * Below is the getter for retrieving the Comments parameter from the
	 * Student Object
	 * 
	 * @return
	 */
	public String getComments() {
		return comments;
	}

	/**
	 * Below is the setter for setting the Comments parameter from the Student
	 * Object
	 * 
	 * @param comments
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}

	/**
	 * Below is the getter for retrieving the Portfolio parameter from the
	 * Student object
	 * 
	 * @return
	 */
	public String getPortfolio() {
		return portfolio;
	}

	/**
	 * Below is the setter for setting the Portfolio parameter for the Student
	 * object
	 * 
	 * @param portfolio
	 */
	public void setPortfolio(String portfolio) {
		this.portfolio = portfolio;
	}

	/**
	 * The below is the getter for retrieving the year parameter from the
	 * Student object
	 * 
	 * @return
	 */
	public String getYear() {
		return year;
	}

	/**
	 * The below setter sets the Year parameter for the Student object. If the
	 * parameter is set to any value not between 1-5, an exception is thrown
	 * 
	 * @param year
	 */
	public void setYear(String year) {
		this.year = year;
		
	}

	/**
	 * The below is the toString method that will display the Student
	 * information on the Student Menus on the admin console
	 */
	@Override
	public String toString() {
		return "Student Number:   " + studentNumber + "\t Name:   " + name + "\t Cohort:   " + cohort + "\t Year:   " + year;
	}
}
