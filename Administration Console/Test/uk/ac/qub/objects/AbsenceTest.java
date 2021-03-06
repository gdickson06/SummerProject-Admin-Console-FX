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
	 * Testing the getters and setters for LectureID with valid value
	 */
	@Test
	public void testGetValidLectureID() {
		Absence absence = new Absence();
		absence.setLectureID(validLectureID);
		assertEquals(validLectureID, absence.getLectureID());
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
	 * Testing the getters and setters for Start Time with valid Value (12:00)
	 */
	@Test
	public void testGetSetValidStartTime() {
		Absence absence = new Absence();
		absence.setStartTime(validStartTime);
		assertEquals(validStartTime, absence.getStartTime());
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



}
