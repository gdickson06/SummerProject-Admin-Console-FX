package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson
 * The below test suite tests all of the getters, setters and toString()
 * method found in the uk.ac.qub.objects.Note.java class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.mysql.jdbc.log.NullLogger;

public class PlacementTest {
	
	/*
	 * Creating the test data variables that will be used in the below test
	 * suite
	 */
	int validID, invalidID, validYearLowerBoundary, validYearMiddleBoundary, validYearUpperBoundary,
			invalidYearLowerBoundary, invalidYearUpperBoundary;
	String validStartDate, invalidStartDate, validEndDate, invalidEndDate, validDetails, invalidDetails, validLocation,
			invalidLocation, validPreference, validCohort, invalidCohort, validModule, invalidModule, validModuleNumber,
			invalidModuleNumber, validNote;
	
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
		validStartDate = "26/09/2017";
		invalidStartDate = null;
		validEndDate = "27/09/2017";
		validDetails = "Bring Journals to Class";
		invalidDetails = null;
		validNote="Placement may be extended";
		validLocation = "Whitla Medical Building";
		invalidLocation = null;
		validPreference = "Royal Victoria Hospital";
		validCohort = "A1";
		invalidCohort = null;
		validModule = "Building Blocks of Life";
		invalidModule=null;
		validModuleNumber="MBC1025";
		invalidModuleNumber=null;
	}
	
	/**
	 * Testing the primary constructor for the Placement class with 10 args
	 * with valid values
	 */
	@Test
	public void testPlacementConstructorValidTenArgs() {
		Placement placement = new Placement(validID, validYearLowerBoundary, validStartDate, validEndDate, validLocation, validPreference, validCohort, validNote, validModule, validModuleNumber);
		assertNotNull(placement);
		assertEquals(validID, placement.getId());
		assertEquals(validYearLowerBoundary, placement.getYear());
		assertEquals(validStartDate, placement.getStartDate());
		assertEquals(validEndDate, placement.getEndDate());
		assertEquals(validLocation, placement.getLocation());
		assertEquals(validPreference, placement.getPreference());
		assertEquals(validCohort, placement.getCohort());
		assertEquals(validNote, placement.getNote());
		assertEquals(validModule, placement.getModule());
		assertEquals(validModuleNumber, placement.getModuleNumber());
	}
	
	/**
	 * Testing the secondary constructor for the Placement class with 9 args
	 * with valid values
	 */
	@Test
	public void testPlacementConstructorValidNineArgs() {
		Placement placement = new Placement(validYearLowerBoundary, validStartDate, validEndDate, validLocation, validCohort, validNote, validModule, validModuleNumber, validPreference);
		assertNotNull(placement);
		assertEquals(validYearLowerBoundary, placement.getYear());
		assertEquals(validStartDate, placement.getStartDate());
		assertEquals(validEndDate, placement.getEndDate());
		assertEquals(validLocation, placement.getLocation());
		assertEquals(validCohort, placement.getCohort());
		assertEquals(validNote, placement.getNote());
		assertEquals(validModule, placement.getModule());
		assertEquals(validModuleNumber, placement.getModuleNumber());
		assertEquals(validPreference, placement.getPreference());
	}
	
	/**
	 * Testing the default constructor for the Placement class with no args
	 * with valid values
	 */
	@Test
	public void testPlacementConstructorValidNoArgs() {
		Placement placement = new Placement();
		assertNotNull(placement);
	}
	
	/**
	 * Testing the getters and setters for the ID parameter with a valid value
	 * (1)
	 */
	@Test
	public void testGetSetValidId() {
		Placement placement = new Placement();
		placement.setId(validID);
		assertEquals(validID, placement.getId());
	}
	
	/**
	 * Testing the getters and setters for the ID parameter with an invalid value
	 * (0)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetSetInvalidId() {
		Placement placement = new Placement();
		placement.setId(invalidID);
	}
	
	/**
	 * Testing the getters and setters for the Year parameter with a valid value at
	 * the lower boundary (1)
	 */
	@Test
	public void testGetSetValidYearLowerBoundary() {
		Placement placement = new Placement();
		placement.setYear(validYearLowerBoundary);
		assertEquals(validYearLowerBoundary, placement.getYear());
	}
	
	/**
	 * Testing the getters and setters for the Year parameter with a valid value at
	 * the middle boundary (3)
	 */
	@Test
	public void testGetSetValidYearMiddleBoundary() {
		Placement placement = new Placement();
		placement.setYear(validYearMiddleBoundary);
		assertEquals(validYearMiddleBoundary, placement.getYear());
	}
	
	/**
	 * Testing the getters and setters for the Year parameter with a valid value at
	 * the upper boundary (5)
	 */
	@Test
	public void testGetSetValidYearUpperBoundary() {
		Placement placement = new Placement();
		placement.setYear(validYearUpperBoundary);
		assertEquals(validYearUpperBoundary, placement.getYear());
	}
	
	/**
	 * Testing the getters and setters for the Year parameter with an valid value
	 *  at the lower boundary (0)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetSetInvalidYearLowerBoundary() {
		Placement placement = new Placement();
		placement.setYear(invalidYearLowerBoundary);
	}
	
	/**
	 * Testing the getters and setters for the Year parameter with an valid value
	 *  at the upper boundary (6)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetSetInvalidYearUpperBoundary() {
		Placement placement = new Placement();
		placement.setYear(invalidYearUpperBoundary);
	}
	
	/**
	 * Testing the getters and setters for Start Date parameter with
	 * a valid value
	 */
	@Test
	public void testGetSetValidStartDate() {
		Placement placement = new Placement();
		placement.setStartDate(validStartDate);
		assertEquals(validStartDate, placement.getStartDate());
	}
	
	/**
	 * Testing the getters and setters for Start Date parameter with
	 * an invalid value (null value)
	 */
	@Test(expected=NullPointerException.class)
	public void testGetSetInvalidStartDate() {
		Placement placement = new Placement();
		placement.setStartDate(invalidStartDate);
	}
	
	/**
	 * Testing the getters and setters for End Date parameter with valid
	 * value
	 */
	@Test
	public void testGetSetValidEndDate() {
		Placement placement = new Placement();
		placement.setEndDate(validEndDate);
		assertEquals(validEndDate, placement.getEndDate());
	}
	
	/**
	 * Testing the getters and setters for End Date parameter with an invalid
	 * value (null value)
	 */
	@Test(expected=NullPointerException.class)
	public void testGetSetInvalidEndDate() {
		Placement placement = new Placement();
		placement.setEndDate(invalidEndDate);
	}
	
	/**
	 * Testing the getters and setters for Location parameter with an valid
	 * value
	 */
	@Test
	public void testGetSetValidLocation() {
		Placement placement = new Placement();
		placement.setLocation(validLocation);
		assertEquals(validLocation, placement.getLocation());
	}
	
	/**
	 * Testing the getters and setters for Location parameter with an invalid
	 * value (null value)
	 */
	@Test(expected=NullPointerException.class)
	public void testGetSetInvalidLocation() {
		Placement placement = new Placement();
		placement.setLocation(invalidLocation);
	}
	
	/**
	 * Testing the getters and setters for the preference parameter with
	 * a valid value
	 */
	@Test
	public void testGetSetValidPreference() {
		Placement placement = new Placement();
		placement.setPreference(validPreference);
		assertEquals(validPreference, placement.getPreference());
	}
	
	/**
	 * Testing the getters and setters for the cohort parameter with
	 * a valid value
	 */
	@Test
	public void testGetSetValidCohort() {
		Placement placement = new Placement();
		placement.setCohort(validCohort);
		assertEquals(validCohort, placement.getCohort());
	}
	
	/**
	 * Testing the getters and setters for the cohort parameter with
	 * an invalid value (null value)
	 */
	@Test(expected=NullPointerException.class)
	public void testGetSetInvalidCohort() {
		Placement placement = new Placement();
		placement.setCohort(invalidCohort);
	}
	
	/**
	 * Testing the getters and setters for the note parameter with
	 * a valid value
	 */
	@Test
	public void testGetSetValidNote() {
		Placement placement = new Placement();
		placement.setNote(validNote);
		assertEquals(validNote, placement.getNote());
	}
	
	/**
	 * Testing the getters and setters for the module parameter
	 * with a valid value
	 */
	@Test
	public void testGetSetValidModule() {
		Placement placement = new Placement();
		placement.setModule(validModule);
		assertEquals(validModule, placement.getModule());
	}

	/**
	 * Testing the getters and setters for the module parameter
	 * with an invalid value (null value)
	 */
	@Test(expected=NullPointerException.class)
	public void testGetSetInvalidModule() {
		Placement placement = new Placement();
		placement.setModule(invalidModule);
	}
	
	/**
	 * Testing the getters and setters for the module number
	 * parameter with an valid value
	 */
	@Test
	public void testGetSetValidModuleNumber() {
		Placement placement = new Placement();
		placement.setModuleNumber(validModuleNumber);
		assertEquals(validModuleNumber, placement.getModuleNumber());
	}
	
	/**
	 * Testing the getters and setters for the module number
	 * parameter with an valid value
	 */
	@Test(expected=NullPointerException.class)
	public void testGetSetInvalidModuleNumber() {
		Placement placement = new Placement();
		placement.setModuleNumber(invalidModuleNumber);
	}
	
	/**
	 * Testing the toString method that will be used to display all placement information
	 * on the Placement Administration Menus on the admin console
	 */
	@Test
	public void testToString() {
		Placement placement = new Placement(validID, validYearLowerBoundary, validStartDate, validEndDate, validLocation, validPreference, validCohort, validNote, validModule, validModuleNumber);
		String expected = "id:" + placement.getId() + " Year:" + placement.getYear() + " StartDate:" + placement.getStartDate() + " EndDate :" + placement.getEndDate()
				+ "Location : " + placement.getLocation() + " Cohort :" + placement.getCohort() + " Module=:" + placement.getModule();
	}

}