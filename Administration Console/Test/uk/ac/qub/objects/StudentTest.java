package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson
 * The below test suite tests for all of the getters, setters and toString()
 * method found in the uk.ac.qub.objects.Student.java class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StudentTest {

	/*
	 * Creating the test data variables that will be used in the below test
	 * suite
	 */
	int validStudentNumberLowerBoundary, validStudentNumberMiddleBoundary, validStudentNumberUpperBoundary,
			invalidStudentNumberLowerBoundary, invalidStudentNumberUpperBoundary;
	String validLastName, invalidLastName, validFirstName, invalidFirstName, validMiddleName, invalidMiddleName,
			validPrefix, validName, invalidName, validCohort, invalidCohort, validEmail, invalidEmail, validNationality,
			validGraduate, validComments, validPortfolio, validYear1, validYear2, validYear3, validYear4, validYear5,
			invalidYearLowerBoundary, invalidYearUpperBoundary;

	/**
	 * Assigning values to the test variables to be used in the below JUnit test
	 * cases
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		validStudentNumberLowerBoundary = 00000001;
		validStudentNumberMiddleBoundary = 44444444;
		validStudentNumberUpperBoundary = 99999999;
		invalidStudentNumberLowerBoundary = 0;
		invalidStudentNumberUpperBoundary = 100000000;
		validLastName = "Jones";
		invalidLastName = null;
		validFirstName = "Adam";
		invalidFirstName = null;
		validMiddleName = "John";
		invalidMiddleName = null;
		validPrefix = "Mr";
		validName = "Adam Jones";
		invalidName = null;
		validCohort = "A1";
		invalidCohort = null;
		validEmail = "ajones@qub.ac.uk";
		invalidEmail = null;
		validNationality = "French";
		validGraduate = "Graduate";
		validComments = "ERASMUS student";
		validPortfolio = "Studied Maths at Undergraduate level";
		validYear1 = "1";
		validYear2 = "2";
		validYear3 = "3";
		validYear4 = "4";
		validYear5 = "5";
		invalidYearLowerBoundary = "0";
		invalidYearUpperBoundary = "6";
	}

	/**
	 * Testing the primary constructor for the Student class with 13 args
	 */
	@Test
	public void testStudentPrimaryConstructorWithArgs() {
		Student student = new Student(validStudentNumberLowerBoundary, validLastName, validFirstName, validMiddleName,
				validPrefix, validName, validCohort, validEmail, validNationality, validGraduate, validComments,
				validPortfolio, validYear1);
		assertNotNull(student);
		assertEquals(validStudentNumberLowerBoundary, student.getStudentNumber());
		assertEquals(validLastName, student.getLastName());
		assertEquals(validFirstName, student.getFirstName());
		assertEquals(validMiddleName, student.getMiddleName());
		assertEquals(validPrefix, student.getPrefix());
		assertEquals(validName, student.getName());
		assertEquals(validCohort, student.getCohort());
		assertEquals(validEmail, student.getEmail());
		assertEquals(validNationality, student.getNationality());
		assertEquals(validGraduate, student.getGraduate());
		assertEquals(validComments, student.getComments());
		assertEquals(validPortfolio, student.getPortfolio());
		assertEquals(validYear1, student.getYear());
	}

	/**
	 * Testing the default constructor for the student class with no args
	 */
	@Test
	public void testStudentDefaultConstructorNoArgs() {
		Student student = new Student();
		assertNotNull(student);
	}

	/**
	 * Testing the getter and setters for Student Number with a valid Lower
	 * Boundary value (00000001)
	 */
	@Test
	public void testGetSetValidStudentNumberLowerBoundary() {
		Student student = new Student();
		student.setStudentNumber(validStudentNumberLowerBoundary);
		assertEquals(validStudentNumberLowerBoundary, student.getStudentNumber());
	}

	/**
	 * Testing the getter and setters for Student Number with a valid Middle
	 * Boundary value (44444444)
	 */
	@Test
	public void testGetSetValidStudentNumberMiddleBoundary() {
		Student student = new Student();
		student.setStudentNumber(validStudentNumberMiddleBoundary);
		assertEquals(validStudentNumberMiddleBoundary, student.getStudentNumber());
	}

	/**
	 * Testing the getter and setters for Student Number with a valid Lower
	 * Boundary value (99999999)
	 */
	@Test
	public void testGeSetValidStudentNumberUpperBoundary() {
		Student student = new Student();
		student.setStudentNumber(validStudentNumberUpperBoundary);
		assertEquals(validStudentNumberUpperBoundary, student.getStudentNumber());
	}

	/**
	 * Testing the getter and setters for Student Number with an invalid Upper
	 * Boundary value (100000000)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGeSetInvalidStudentNumberUpperBoundary() {
		Student student = new Student();
		student.setStudentNumber(invalidStudentNumberUpperBoundary);
	}



	/**
	 * Testing the getter and setters for Last Name with a valid value
	 */
	@Test
	public void testGetSetValidLastName() {
		Student student = new Student();
		student.setLastName(validLastName);
		assertEquals(validLastName, student.getLastName());
	}

	

	/**
	 * Testing the getters and setters for First Name with a valid value
	 */
	@Test
	public void testGetSetValidFirstName() {
		Student student = new Student();
		student.setFirstName(validFirstName);
		assertEquals(validFirstName, student.getFirstName());
	}

	

	/**
	 * Testing the getters and setters for Middle Name with a valid value
	 */
	@Test
	public void testGetSetValidMiddleName() {
		Student student = new Student();
		student.setMiddleName(validMiddleName);
		assertEquals(validMiddleName, student.getMiddleName());
	}



	/**
	 * testing the setters and getters for Prefix with a valid value
	 */
	@Test
	public void testGetSetValidPrefix() {
		Student student = new Student();
		student.setPrefix(validPrefix);
		assertEquals(validPrefix, student.getPrefix());
	}

	/**
	 * Testing the getters and setters for Name with a valid value
	 */
	@Test
	public void testGetSetValidName() {
		Student student = new Student();
		student.setName(validName);
		assertEquals(validName, student.getName());
	}



	/**
	 * testing the getters and setters for Cohort with a valid value
	 */
	@Test
	public void testGetSetValidCohort() {
		Student student = new Student();
		student.setCohort(validCohort);
		assertEquals(validCohort, student.getCohort());
	}



	/**
	 * testing the getters and setters for Email Address with a valid value
	 */
	@Test
	public void testGetSetValidEmail() {
		Student student = new Student();
		student.setEmail(validEmail);
		assertEquals(validEmail, student.getEmail());
	}



	/**
	 * Testing the getters and setters for Nationality with a valid value
	 */
	@Test
	public void testGetSetValidNationality() {
		Student student = new Student();
		student.setNationality(validNationality);
		assertEquals(validNationality, student.getNationality());
	}

	/**
	 * Testing the getters and setters for Graduate with a valid value
	 */
	@Test
	public void testGetGraduate() {
		Student student = new Student();
		student.setGraduate(validGraduate);
		assertEquals(validGraduate, student.getGraduate());
	}

	/**
	 * testing the setters and getters for Comments with a valid value
	 */
	@Test
	public void testGetSetValidComments() {
		Student student = new Student();
		student.setComments(validComments);
		assertEquals(validComments, student.getComments());
	}

	/**
	 * testing the setters and getters for Portfolio with a valid value
	 */
	@Test
	public void testGetSetValidPortfolio() {
		Student student = new Student();
		student.setPortfolio(validPortfolio);
		assertEquals(validPortfolio, student.getPortfolio());
	}

	/**
	 * testing the setters and getters for Year with a valid value for Year 1
	 */
	@Test
	public void testGetSetValidYear1() {
		Student student = new Student();
		student.setYear(validYear1);
		assertEquals(validYear1, student.getYear());
	}

	/**
	 * testing the setters and getters for Year with a valid value for Year 2
	 */
	@Test
	public void testGetSetValidYear2() {
		Student student = new Student();
		student.setYear(validYear2);
		assertEquals(validYear2, student.getYear());
	}

	/**
	 * testing the setters and getters for Year with a valid value for Year 3
	 */
	@Test
	public void testGetSetValidYear3() {
		Student student = new Student();
		student.setYear(validYear3);
		assertEquals(validYear3, student.getYear());
	}

	/**
	 * testing the setters and getters for Year with a valid value for Year 4
	 */
	@Test
	public void testGetSetValidYear4() {
		Student student = new Student();
		student.setYear(validYear4);
		assertEquals(validYear4, student.getYear());
	}

	

	


	

}
