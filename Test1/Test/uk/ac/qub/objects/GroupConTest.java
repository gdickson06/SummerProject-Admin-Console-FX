package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson
 * The below test suite tests for all of the getters, setters and toString()
 * method found in the uk.ac.qub.objects.GroupCon.java class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GroupConTest {
	
	/*
	 * Creating the test data variables that will be used in the below test
	 * suite
	 */
	String validGroup, invalidGroup, validCohort, invalidCohort;
	
	/**
	 * Assigning values to the test variables to be used in the below JUnit test
	 * cases
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		validGroup="A1-A8";
		invalidGroup=null;
		validCohort="A1";
		invalidCohort=null;
	}
	
	/**
	 * Testing the primary constructor with Group and Cohort args
	 */
	@Test
	public void testGroupsConValidConstructorWithArgs() {
		GroupsCon groupsCon = new GroupsCon(validGroup, validCohort);
		assertNotNull(groupsCon);
		assertEquals(validGroup, groupsCon.getGroups());
		assertEquals(validCohort, groupsCon.getCohort());
	}
	
	/**
	 * Testing the default constructor with no args
	 */
	@Test
	public void testGroupsConDefaultConstructorNoArgs() {
		GroupsCon groupsCon = new GroupsCon();
		assertNotNull(groupsCon);
	}

	/**
	 * Testing the getters and setters for the Group parameter with
	 * a valid value
	 */
	@Test
	public void testGetSetValidGroups() {
		GroupsCon groupsCon = new GroupsCon();
		groupsCon.setGroups(validGroup);
		assertEquals(validGroup, groupsCon.getGroups());
	}

	
	/**
	 * Testing the getters and setters for the Cohort parameter with
	 * a valid value
	 */
	@Test
	public void testGetSetValidCohort() {
		GroupsCon groupsCon = new GroupsCon();
		groupsCon.setCohort(validCohort);
		assertEquals(validCohort, groupsCon.getCohort());
	}
	
	
	
	/**
	 * Testing the toString method for the GroupCon class below
	 */
	@Test
	public void testToString() {
		GroupsCon groupCon = new GroupsCon(validGroup, validCohort);
		String expected = "GroupsCon [groups=" + groupCon.getGroups() + ", cohort=" + groupCon.getCohort() + "]"; 
		assertEquals(expected, groupCon.toString());
	}

}
