package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson
 * The below test suite tests all of the getters, setters and toString()
 * method found in the uk.ac.qub.objects.ExtendedAbsence.java class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ExtendedAbsenceTest {

	/*
	 * Creating the test data variables that will be used in the below test
	 * suite
	 */
	String validType1, validType2, validType3, invalidType, validYear1, validYear2, validYear3, validYear4, validYear5,
			invalidYearLowerBoundary, invalidYearUpperBoundary, validDayMon, validDayTues, validDayWed, validDayThurs,
			validDayFri, validStaff, invalidDay1, invalidDay2, invalidStaff, validCohort, invalidCohort, validModule,
			invalidModule, validDate, invalidDate, validStudentNumber, invalidStudentNumber;

	/**
	 * Assigning values to the test variables to be used in the below JUnit test
	 * cases
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		validType1 = "Illness";
		validType2 = "Non Illness Related Absence";
		validType3 = "Missing from class";
		invalidType = "annual leave";
		validYear1 = "1";
		validYear2 = "2";
		validYear3 = "3";
		validYear4 = "4";
		validYear5 = "5";
		invalidYearLowerBoundary = "0";
		invalidYearUpperBoundary = "6";
		validDayMon = "Monday";
		validDayTues = "Tuesday";
		validDayWed = "Wednesday";
		validDayThurs = "Thursday";
		validDayFri = "Friday";
		invalidDay1 = "Saturday";
		invalidDay2 = "Sunday";
		validStaff = "Dr. David Roberts";
		invalidStaff = null;
		validCohort = "A1";
		invalidCohort = null;
		validModule = "MBC1025";
		invalidModule = null;
		validDate = "12/08/2017";
		invalidDate = null;
		validStudentNumber = "13457689";
		invalidStudentNumber = null;
	}

	/**
	 * Testing the ExtendedAbsence constructor with args, with valid values
	 */
	@Test
	public void testExtendedAbsenceConstructorWithArgs() {
		ExtendedAbsence absence = new ExtendedAbsence(validYear1, validDayMon, validStaff, validCohort, validModule,
				validDate, validStudentNumber, validType1);
		assertNotNull(absence);
		assertEquals(validYear1, absence.getYear());
		assertEquals(validDayMon, absence.getDay());
		assertEquals(validStaff, absence.getStaff());
		assertEquals(validCohort, absence.getCohort());
		assertEquals(validModule, absence.getModule());
		assertEquals(validDate, absence.getDate());
		assertEquals(validStudentNumber, absence.getStudentNumber());
		assertEquals(validType1, absence.getType());
	}

	/**
	 * Testing the default ExtendedAbsence constructor with no args
	 */
	@Test
	public void testExtendedAbsenceDefaultConstructorNoArgs() {
		ExtendedAbsence absence = new ExtendedAbsence();
		assertNotNull(absence);
	}

	/**
	 * Testing the getter and setter for Type with valid args, Type 1 (Illness)
	 */
	@Test
	public void testGetSetValidTypeIllness() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setType(validType1);
		assertEquals(validType1, absence.getType());
	}

	/**
	 * Testing the getter and setter for Type with valid args, Type 2 (Non
	 * Illness Related Absence)
	 */
	@Test
	public void testGetSetValidTypeNonIllnessRelatedAbsence() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setType(validType2);
		assertEquals(validType2, absence.getType());
	}

	/**
	 * Testing the getter and setter for Type with valid args, Type 3 Missing
	 * from class)
	 */
	@Test
	public void testGetSetValidTypeMissingFromClass() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setType(validType3);
		assertEquals(validType3, absence.getType());
	}

	/**
	 * Testing the getter and setter for Type with invalid args (annual leave)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetSetInvalidType() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setType(invalidType);
	}

	/**
	 * Testing the getters and setters for Year with the valid value 1
	 */
	@Test
	public void testGetSetYear1() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setYear(validYear1);
		assertEquals(validYear1, absence.getYear());
	}

	/**
	 * Testing the getters and setters for Year with the valid value 2
	 */
	@Test
	public void testGetSetYear2() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setYear(validYear2);
		assertEquals(validYear2, absence.getYear());
	}

	/**
	 * Testing the getters and setters for Year with the valid value 3
	 */
	@Test
	public void testGetSetYear3() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setYear(validYear3);
		assertEquals(validYear3, absence.getYear());
	}

	/**
	 * Testing the getters and setters for Year with the valid value 4
	 */
	@Test
	public void testGetSetYear4() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setYear(validYear4);
		assertEquals(validYear4, absence.getYear());
	}

	/**
	 * Testing the getters and setters for Year with the valid value 5
	 */
	@Test
	public void testGetSetYear5() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setYear(validYear5);
		assertEquals(validYear5, absence.getYear());
	}

	/**
	 * Testing the getters and setters for Year with invalid value at the lower
	 * boundary (0)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetSetInvalidYearLowerBoundary() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setYear(invalidYearLowerBoundary);
	}

	/**
	 * Testing the getters and setters for Year with invalid value at the upper
	 * boundary (0)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetSetInvalidYearUpperBoundary() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setYear(invalidYearUpperBoundary);
	}

	/**
	 * Testing the getters and setters for Day with the valid value Monday
	 */
	@Test
	public void testGetSetValidDayMonday() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setDay(validDayMon);
		assertEquals(validDayMon, absence.getDay());
	}

	/**
	 * Testing the getters and setters for Day with the valid value Tuesday
	 */
	@Test
	public void testGetSetValidDayTuesday() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setDay(validDayTues);
		assertEquals(validDayTues, absence.getDay());
	}

	/**
	 * Testing the getters and setters for Day with the valid value Wednesday
	 */
	@Test
	public void testGetSetValidDayWednesday() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setDay(validDayWed);
		assertEquals(validDayWed, absence.getDay());
	}

	/**
	 * Testing the getters and setters for Day with the valid value Thursday
	 */
	@Test
	public void testGetSetValidDayThursday() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setDay(validDayThurs);
		assertEquals(validDayThurs, absence.getDay());
	}

	/**
	 * Testing the getters and setters for Day with the valid value Friday
	 */
	@Test
	public void testGetSetValidDayFriday() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setDay(validDayFri);
		assertEquals(validDayFri, absence.getDay());
	}

	/**
	 * Testing the getters and setters for Day with the invalid value Saturday
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetSetInvalidDaySaturday() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setDay(invalidDay1);
	}

	/**
	 * Testing the getters and setters for Day with the invalid value Sunday
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetSetInvalidDaySunday() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setDay(invalidDay2);
	}

	/**
	 * Testing the getters and setters for Staff with a valid value
	 */
	@Test
	public void testGetSetValidStaff() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setStaff(validStaff);
		assertEquals(validStaff, absence.getStaff());
	}

	/**
	 * Testing the getters and setters for Staff with an invalid value (null
	 * value)
	 */
	@Test(expected = NullPointerException.class)
	public void testGetSetInvalidStaff() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setStaff(invalidStaff);
	}

	/**
	 * Testing the getters and setters for Cohort with a valid value
	 */
	@Test
	public void testGetSetValidCohort() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setCohort(validCohort);
		assertEquals(validCohort, absence.getCohort());
	}

	/**
	 * Testing the getters and setters for Cohort with an invalid value (null
	 * value)
	 */
	@Test(expected = NullPointerException.class)
	public void testGetSetInvalidCohort() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setCohort(invalidCohort);
	}

	/**
	 * Testing the getters and setters for module with a valid value
	 */
	@Test
	public void testGetSetValidModule() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setModule(validModule);
		assertEquals(validModule, absence.getModule());
	}

	/**
	 * Testing the getters and setters for module with an invalid value (Null
	 * value)
	 */
	@Test(expected = NullPointerException.class)
	public void testGetSetInvalidModule() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setCohort(invalidModule);
	}

	/**
	 * Testing the getters and setters for Date with a valid date
	 */
	@Test
	public void testGetSetValidDate() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setDate(validDate);
		assertEquals(validDate, absence.getDate());
	}

	/**
	 * Testing the getters and setters for Date with an invalid date (null
	 * value)
	 */
	@Test(expected = NullPointerException.class)
	public void testGetSetInvalidDate() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setDate(invalidDate);
	}

	/**
	 * Testing the getters and setters for Student Number with a valid Student
	 * Number
	 */
	@Test
	public void testGetSetValidStudentNumber() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setStudentNumber(validStudentNumber);
		assertEquals(validStudentNumber, absence.getStudentNumber());
	}

	/**
	 * Testing the getters and setters for Student Number with an invalid
	 * Student Number (null value)
	 */
	@Test(expected = NullPointerException.class)
	public void testGetSetInvalidStudentNumber() {
		ExtendedAbsence absence = new ExtendedAbsence();
		absence.setStudentNumber(invalidStudentNumber);

	}

	/**
	 * Testing the toString method below with valid values inserted
	 */
	@Test
	public void testToString() {
		ExtendedAbsence absence = new ExtendedAbsence(validYear1, validDayMon, validStaff, validCohort, validModule,
				validDate, validStudentNumber, validType1);
		String expected = "ExtendedAbsence [Year=" + absence.getYear() + ", Day=" + absence.getDay() + ", staff="
				+ absence.getStaff() + ", cohort=" + absence.getCohort() + ", module=" + absence.getModule() + ", date="
				+ absence.getDate() + ", StudentNumber=" + absence.getStudentNumber() + ", Type=" + absence.getType()
				+ "]";
		assertEquals(expected, absence.toString());
	}

}
