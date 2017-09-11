package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson
 * The below test suite tests all of the getters, setters and toString()
 * method found in the uk.ac.qub.objects.Note.java class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NoteTest {

	/*
	 * Creating the test data variables that will be used in the below test
	 * suite
	 */
	int validID, invalidID, validYearLowerBoundary, validYearMiddleBoundary, validYearUpperBoundary,
			invalidYearLowerBoundary, invalidYearUpperBoundary;
	String validDate, invalidDate, validDetails, invalidDetails;

	/**
	 * Assigning values to the test variables to be used in the below JUnit test
	 * cases
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		validID = 1;
		invalidID = 0;
		validYearLowerBoundary = 1;
		validYearMiddleBoundary = 3;
		validYearUpperBoundary = 5;
		invalidYearLowerBoundary = 0;
		invalidYearUpperBoundary = 6;
		validDate = "26/09/2017";
		invalidDate = null;
		validDetails = "Bring Journals to Class";
		invalidDetails = null;
	}

	/**
	 * Testing the primary constructor with four args and valid values
	 */
	@Test
	public void testConstructorWithArgs() {
		Note note = new Note(validID, validYearLowerBoundary, validDate, validDetails);
		assertNotNull(note);
		assertEquals(validID, note.getId());
		assertEquals(validYearLowerBoundary, note.getYear());
		assertEquals(validDate, note.getDate());
		assertEquals(validDetails, note.getDetails());
	}

	/**
	 * Testing the default constructor with no args
	 */
	@Test
	public void testDefaultNoteConstructorNoArgs() {
		Note note = new Note();
		assertNotNull(note);
	}

	/**
	 * Testing the getters and setters for ID with valid value (1)
	 */
	@Test
	public void testGetSetValidId() {
		Note note = new Note();
		note.setId(validID);
		assertEquals(validID, note.getId());
	}

	/**
	 * Testing the getters and setters for ID with invalid value (0)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetSetInvalidId() {
		Note note = new Note();
		note.setId(invalidID);
	}

	/**
	 * Testing the getters and setters for year with a valid value at the lower
	 * boundary(1)
	 */
	@Test
	public void testGetSetValidYearLowerBoundary() {
		Note note = new Note();
		note.setYear(validYearLowerBoundary);
		assertEquals(validYearLowerBoundary, note.getYear());
	}

	/**
	 * Testing the getters and setters for year with a valid value at the Middle
	 * boundary(3)
	 */
	@Test
	public void testGetSetValidYearMiddleBoundary() {
		Note note = new Note();
		note.setYear(validYearMiddleBoundary);
		assertEquals(validYearMiddleBoundary, note.getYear());
	}

	/**
	 * Testing the getters and setters for year with a valid value at the upper
	 * boundary(5)
	 */
	@Test
	public void testGetSetValidYearUpperBoundary() {
		Note note = new Note();
		note.setYear(validYearUpperBoundary);
		assertEquals(validYearUpperBoundary, note.getYear());
	}





	/**
	 * Testing the getter and setters for Date parameter with a valid value
	 */
	@Test
	public void testGetSetValidDate() {
		Note note = new Note();
		note.setDate(validDate);
		assertEquals(validDate, note.getDate());
	}



	/**
	 * Testing the getter and setter for Details parameter with a valid value
	 */
	@Test
	public void testGetSetValidDetails() {
		Note note = new Note();
		note.setDetails(validDetails);
		assertEquals(validDetails, note.getDetails());
	}





}
