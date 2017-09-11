package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson
 * The below test suite tests for all of the getters, setters and toString()
 * method found in the uk.ac.qub.objects.Room.java class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RoomTest {
	
	/*
	 * Creating the test data variables that will be used in the below test
	 * suite
	 */
	String validRoomName, invalidRoomName, validRoomCode, invalidRoomCode;
	
	/**
	 * Assigning values to the test variables to be used in the below JUnit test
	 * cases
	 * 
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		validRoomName = "Whitla Medical Building";
		invalidRoomName = null;
		validRoomCode = "RC1052";
		invalidRoomCode = null;
	}
	
	/**
	 * Testing the primary constructor for the Room class
	 */
	@Test
	public void testPrimaryRoomConstructorValid() {
		Room room = new Room(validRoomCode, validRoomName);
		assertNotNull(room);
		assertEquals(validRoomCode, room.getCode());
		assertEquals(validRoomName, room.getName());
	}
	
	/**
	 * Testing the default constructor for the Room Class with no args
	 */
	@Test
	public void testDefaultRoomConstructorNoArgs() {
		Room room = new Room();
		assertNotNull(room);
	}
	
	/**
	 * testing the getters and setters for the Room Code with a valid
	 * value
	 */
	@Test
	public void testGetSetValidRoomCode() {
		Room room = new Room();
		room.setCode(validRoomCode);
		assertEquals(validRoomCode, room.getCode());
	}
	

	
	/**
	 * Testing the getters and setters for the Room Name with a valid value
	 */
	@Test
	public void testGetSetValidName() {
		Room room = new Room();
		room.setName(validRoomName);
		assertEquals(validRoomName, room.getName());
	}
	

	


}
