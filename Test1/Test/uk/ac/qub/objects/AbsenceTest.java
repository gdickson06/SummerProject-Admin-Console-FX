package uk.ac.qub.objects;

/**
 * @author Calum Hurst and Gerard Dickson
 * Below is the JUnit Test Suite for all testable getters, setters
 * and toString() methods in the uk.ac.qub.objects.Absence.java class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AbsenceTest {

	// creating test data to be used in J-Unit Tests
	int validID, invalidID, validStudentNumberLowerBoundary, validStudentNumberMiddleBoundary,
			validStudentNumberUpperBoundary, invalidStudentNumberLowerBoundary, invalidStudentNumberUpperBoundary,
			validLectureID, invalidLectureID;
	String validStartDate, invalidStartDate, validStartTime, invalidStartTime, validEndTime, invalidEndTime,
			validReason, invalidReason, validType1, validType2, validType3, invalidType, validEndDate;
	boolean validApproved, validViewed;

	/**
	 * Assigning values for the variables to be used in the J Unit Tests for the
	 * Absence class
	 * 
	 * @throws Exception
	 */

	@Before
	public void setUp() throws Exception {
		validID = 1;
		invalidID = -1;
		validStudentNumberLowerBoundary = 00000001;
		validStudentNumberMiddleBoundary = 40000000;
		validStudentNumberUpperBoundary = 99999999;
		invalidStudentNumberLowerBoundary = 0;
		validStudentNumberUpperBoundary = 100000000;
		validLectureID = 1;
		invalidLectureID = 0;
		validStartDate = "12/09/2017";
		validStartTime = "12:00";
		validEndTime = "17:00";
		validReason = "Stomach Virus";
		validType1 = "Illness";
		validType2 = "Non Illness Related Absence";
		validType3 = "Missing from class";
		validEndDate = "13/09/2017";
		validApproved = true;
		validViewed = true;
		invalidStartDate = null;
		invalidEndTime = null;
		invalidReason = null;
		invalidType = "annual leave";
	}

	/**
	 * Testing the constructor with valid arguments included
	 */

	@Test
	public void testAbsenceConstructorWithArgs() {
		Absence absence = new Absence(validID, validStudentNumberLowerBoundary, validLectureID, validStartDate,
				validEndDate, validStartTime, validEndTime, validReason, validType1, validApproved, validViewed);
		assertNotNull(absence);
		// testing each of the arguments within the constructor
		assertEquals(validID, absence.getId());
		assertEquals(validStudentNumberLowerBoundary, absence.getStudentNumber());
		assertEquals(validLectureID, absence.getLectureID());
		assertEquals(validStartDate, absence.getStartDate());
		assertEquals(validEndDate, absence.getEndDate());
		assertEquals(validStartTime, absence.getStartTime());
		assertEquals(validEndDate, absence.getEndDate());
		assertEquals(validReason, absence.getReason());
		assertEquals(validType1, absence.getType());
		assertEquals(validApproved, absence.getApproved());
	}

	/**
	 * Testing the default constructor
	 */
	@Test
	public void testAbsenceConstructorNoArgs() {
		Absence absence = new Absence();
		assertNotNull(absence);
	}

	/**
	 * Testing the getters and setters for id with valid value (1)
	 */
	@Test
	public void testGetSetIdValid() {
		Absence absence = new Absence();
		absence.setId(validID);
		assertEquals(validID, absence.getId());
	}

	/**
	 * Testing the getters and setters for id with invalid value (0)
	 */

	@Test(expected = IllegalArgumentException.class)
	public void testGetSetIdInvalid() {
		Absence absence = new Absence();
		absence.setId(invalidID);
	}

	/**
	 * Testing the getters and setters for Student Number with valid value at
	 * the lower boundary
	 */
	@Test
	public void testGetValidStudentNumberLowerBoundary() {
		Absence absence = new Absence();
		absence.setStudentNumber(validStudentNumberLowerBoundary);
		assertEquals(validStudentNumberLowerBoundary, absence.getStudentNumber());
	}

	/**
	 * Testing the getters and setters for Student Number with valid value at
	 * the middle boundary
	 */
	@Test
	public void testGetValidStudentNumberMiddleBoundary() {
		Absence absence = new Absence();
		absence.setStudentNumber(validStudentNumberMiddleBoundary);
		assertEquals(validStudentNumberMiddleBoundary, absence.getStudentNumber());
	}

	/**
	 * Testing the getters and setters for Student Number with valid value at
	 * the upper boundary
	 */
	@Test
	public void testGetValidStudentNumberUpperBoundary() {
		Absence absence = new Absence();
		absence.setStudentNumber(validStudentNumberUpperBoundary);
		assertEquals(validStudentNumberUpperBoundary, absence.getStudentNumber());
	}

	/**
	 * Testing the getters and setters for Student Number with invalid value at
	 * the lower boundary (0)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInvalidStudentNumberLowerBoundary() {
		Absence absence = new Absence();
		absence.setStudentNumber(invalidStudentNumberLowerBoundary);
	}

	/**
	 * Testing the getters and setters for Student Number with invalid value at
	 * the upper boundary (100000000)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetInvalidStudentNumberUpperBoundary() {
		Absence absence = new Absence();
		absence.setStudentNumber(invalidStudentNumberUpperBoundary);
	}

	/**
	 * Testing the getters and setters for LectureID with valid value
	 */
	@Test
	public void testGetValidLectureID() {
		Absence absence = new Absence();
		absence.setLectureID(validLectureID);
		assertEquals(validLectureID, absence.getLectureID());
	}

	/**
	 * Testing the getters and setters for LectureID with invalid value(0)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetSetInvalidLectureID() {
		Absence absence = new Absence();
		absence.setLectureID(invalidLectureID);
	}

	/**
	 * Testing the getters and setters for Start Date with valid value
	 */
	@Test
	public void testGetSetValidStartDate() {
		Absence absence = new Absence();
		absence.setStartDate(validStartDate);
		assertEquals(validStartDate, absence.getStartDate());
	}

	/**
	 * Testing the getters and setters for Start Date with invalid value (null
	 * value)
	 */
	@Test(expected = NullPointerException.class)
	public void testGetSetInvalidStartDate() {
		Absence absence = new Absence();
		absence.setStartDate(invalidStartDate);

	}

	/**
	 * Testing the getters and setters for Start Time with valid Value (12:00)
	 */
	@Test
	public void testGetSetValidStartTime() {
		Absence absence = new Absence();
		absence.setStartTime(validStartTime);
		assertEquals(validStartTime, absence.getStartTime());
	}

	/**
	 * Testing the getters and setters for Start Time with invalid Value (null
	 * value)
	 */
	@Test(expected = NullPointerException.class)
	public void testGetSetInvalidStartTime() {
		Absence absence = new Absence();
		absence.setStartTime(invalidStartTime);
	}

	/**
	 * Testing the getters and setters for End Time with valid values (17:00)
	 */
	@Test
	public void testGetSetValidEndTime() {
		Absence absence = new Absence();
		absence.setEndTime(validEndTime);
		assertEquals(validEndTime, absence.getEndTime());
	}

	/**
	 * Testing the getters and setters for End Time with invalid values (17:00)
	 */
	@Test(expected = NullPointerException.class)
	public void testGetSetInvalidEndTime() {
		Absence absence = new Absence();
		absence.setEndTime(invalidEndTime);
	}

	/**
	 * Testing the getters and setters for Reason with valid values (Stomach
	 * Virus)
	 */
	@Test
	public void testGetSetValidReason() {
		Absence absence = new Absence();
		absence.setReason(validReason);
		assertEquals(validReason, absence.getReason());
	}

	/**
	 * Testing the getters and setters for Reason with invalid values (null
	 * value)
	 */
	@Test(expected = NullPointerException.class)
	public void testGetSetInvalidReason() {
		Absence absence = new Absence();
		absence.setReason(invalidReason);
	}

	/**
	 * Testing the getters and setters for Type for the first valid Type
	 * (Illness)
	 */
	@Test
	public void testGetSetValidTypeIllness() {
		Absence absence = new Absence();
		absence.setType(validType1);
		assertEquals(validType1, absence.getType());
	}

	/**
	 * Testing the getters and setters for Type for the second valid Type (Non
	 * Illness Related Absence)
	 */
	@Test
	public void testGetSetValidTypeNonIllnessRelatedAbsence() {
		Absence absence = new Absence();
		absence.setType(validType2);
		assertEquals(validType2, absence.getType());
	}

	/**
	 * Testing the getters and setters for Type for the Third valid Type
	 * (Missing from class)
	 */
	@Test
	public void testGetSetValidTypeMissingFromClass() {
		Absence absence = new Absence();
		absence.setType(validType3);
		assertEquals(validType3, absence.getType());
	}

	/**
	 * Testing the getters and setters for Type for the an invalid Type (annual
	 * leave)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetSetInvalidType() {
		Absence absence = new Absence();
		absence.setType(invalidType);
	}

	/**
	 * Testing the getters and setters for the toString method
	 */
	@Test
	public void testAbsenceToString() {
		Absence absence = new Absence(validID, validStudentNumberLowerBoundary, validLectureID, validStartDate,
				validEndDate, validStartTime, validEndTime, validReason, validType1, validApproved, validViewed);
		String expected = "Absence [id=" + absence.getId() + ", StudentNumber=" + absence.getStudentNumber()
				+ ", LectureID=" + absence.getLectureID() + ", StartDate=" + absence.getStartDate() + ", EndDate="
				+ absence.getEndDate() + ", StartTime=" + absence.getStartTime() + ", EndTime=" + absence.getEndTime()
				+ ", Reason=" + absence.getReason() + ", type=" + absence.getType() + ", approved="
				+ absence.getApproved() + "]";
		assertEquals(expected, absence.toString());
	}

}
