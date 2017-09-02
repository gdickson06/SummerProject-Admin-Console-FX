package application;
/**
 * This class will test the only J Unit testable method in the applicationMethods
 * class, the other tests will be ran in user testing.
 */

import org.junit.Before;
import org.junit.Test;



public class ApplicationMethodsTest {


	
	String correctTime4Char, correctTime5Char, shortTime, longTime, noColon, blank;
	
	@Before
	public void setUp() throws Exception {
	correctTime4Char = "9:00";
	correctTime5Char = "12:00";
	shortTime = "12";
	longTime = "12 O Clock";
	noColon ="1200";
	blank = "";
	}

	/**
	 * Testing the time method with 4 characters
	 * Correct input no error
	 * @throws Exception 
	 */
	@Test
	public void testTime1() throws Exception {
		ApplicationMethods.timeInput(correctTime4Char);
	}
	
	/**
	 * Testing the time method with 5 characters
	 * Correct input no error
	 * @throws Exception 
	 */
	@Test
	public void testTime2() throws Exception {
		ApplicationMethods.timeInput(correctTime5Char);
	}
	
	/**
	 * Testing the time method with shortTime
	 * Correct input Exception
	 * @throws Exception 
	 */
	@Test(expected = Exception.class)
	public void testTime3() throws Exception {
		ApplicationMethods.timeInput(shortTime);
	}
	
	/**
	 * Testing the time method with long Time
	 * Correct input Exception
	 * @throws Exception 
	 */
	@Test(expected = Exception.class)
	public void testTime4() throws Exception {
		ApplicationMethods.timeInput(longTime);
	}
	
	/**
	 * Testing the time method with no colon
	 * Correct input Exception
	 * @throws Exception 
	 */
	@Test(expected = Exception.class)
	public void testTime5() throws Exception {
		ApplicationMethods.timeInput(noColon);
	}
	
	/**
	 * Testing the time method with blank input
	 * Correct input no exception
	 
	 */
	@Test
	public void testTime6() throws Exception {
		ApplicationMethods.timeInput(blank);
	}

}
