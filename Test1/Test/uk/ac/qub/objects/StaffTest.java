package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson
 * The below test suite tests for all of the getters, setters and toString()
 * method found in the uk.ac.qub.objects.Staff.java class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StaffTest {
	
	/*
	 * Creating the test data variables that will be used in the below test
	 * suite
	 */
	
	String validStaffNumber, invalidStaffNumber, validName, invalidName, validAccessLevel1, validAccessLevel2, validAccessLevel3, invalidAccessLevel;
	
	/**
	 * Assigning values to the test variables to be used in the below JUnit test
	 * cases
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		validStaffNumber="13456789";
		invalidStaffNumber=null;
		validName="Daniel Jacobs";
		invalidName=null;
		validAccessLevel1="Administrator";
		validAccessLevel2="Module Coordinator";
		validAccessLevel3="Lecturer";
		invalidAccessLevel="Teacher";
	}
	
	/**
	 * testing the primary constructor for the Staff class with 3 args
	 */
	@Test
	public void testStaffprimaryConstructorWithArgs() {
		Staff staff = new Staff(validStaffNumber, validName, validAccessLevel1);
		assertNotNull(staff);
		assertEquals(validStaffNumber, staff.getStaff_number());
		assertEquals(validName, staff.getName());
		assertEquals(validAccessLevel1, staff.getAccess_level());
	}
	
	/**
	 * testing the default constructor with no args for the Staff clas
	 */
	@Test
	public void testDefaultStaffConstructorNoArgs() {
		Staff staff = new Staff();
		assertNotNull(staff);
	}
	
	/**
	 * testing the getters and setters for Staff Number with a valid value
	 */
	@Test
	public void testGetSetValidStaff_number() {
		Staff staff = new Staff();
		staff.setStaff_number(validStaffNumber);
		assertEquals(validStaffNumber, staff.getStaff_number());
	}
	
	/**
	 * testing the getters and setters for Staff Number with an invalid value
	 * (null value)
	 */
	@Test(expected=NullPointerException.class)
	public void testGetSetInvalidStaff_number() {
		Staff staff = new Staff();
		staff.setStaff_number(invalidStaffNumber);
	}
	
	/**
	 * testing the getters and setters for the name parameter with a valid value
	 */
	@Test
	public void testGetSetValidName() {
		Staff staff = new Staff();
		staff.setName(validName);
		assertEquals(validName, staff.getName());
	}
	
	/**
	 * testing the getters and setters for the name parameter with
	 * an invalid value
	 */
	@Test(expected=NullPointerException.class)
	public void testGetSetInvalidName() {
		Staff staff = new Staff();
		staff.setName(invalidName);
	}
	
	/**
	 * testing the getters and setters for the Access Level parameter
	 * with the first valid type ("Administrator")
	 */
	@Test
	public void testGetSetValidAccess_levelAdministrator() {
		Staff staff = new Staff();
		staff.setAccess_level(validAccessLevel1);
		assertEquals(validAccessLevel1, staff.getAccess_level());
	}
	
	/**
	 * testing the getters and setters for the Access Level parameter
	 * with the second valid type ("Administrator")
	 */
	@Test
	public void testGetSetValidAccess_levelModuleCoordinator() {
		Staff staff = new Staff();
		staff.setAccess_level(validAccessLevel2);
		assertEquals(validAccessLevel2, staff.getAccess_level());
	}
	
	/**
	 * testing the getters and setters for the Access Level parameter
	 * with the third type ("Lecturer")
	 */
	@Test
	public void testGetSetValidAccess_levelLecturer() {
		Staff staff = new Staff();
		staff.setAccess_level(validAccessLevel3);
		assertEquals(validAccessLevel3, staff.getAccess_level());
	}
	
	/**
	 * testing the getters and setters for the Access Level parameter
	 * with an invalid value (Teacher)
	 */
	@Test(expected=IllegalArgumentException.class)
	public void testGetSetInvalidAccessLevel() {
		Staff staff = new Staff();
		staff.setAccess_level(invalidAccessLevel);
	}
	
	/**
	 * Testing the toString method that will display all parameters from
	 * the Staff object
	 */
	@Test
	public void testToString() {
		Staff staff = new Staff(validStaffNumber, validName, validAccessLevel1);
		String expected = "staff number:" + staff.getStaff_number() + " name:" + staff.getName() + ", access level:" + staff.getAccess_level();
		assertEquals(expected, staff.toString());
	}

}
