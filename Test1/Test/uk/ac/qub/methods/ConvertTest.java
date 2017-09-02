package uk.ac.qub.methods;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ConvertTest {
	
	String finalDateFormat, preDate1, preDate2, prehourtime1, prehourtime2, posthourtime1, posthourtime2;
	String cohort1, cohort2, cohort3, cohort4, cohort5;
	List<String> cohorts1, cohorts2, cohorts3, cohorts4, cohorts5;
	
	@Before
	public void setUp() throws Exception {
	finalDateFormat = "20170101";
	preDate1 = "01/01/2017";
	preDate2 = "Sun 01 Jan 17";
	prehourtime1 = "9:00:00 AM";
	prehourtime2 = "1:00:00 PM";
	posthourtime1= "9:00";
	posthourtime2="13:00";
	cohort1 = "A1";
	cohort2 = "A1-A4";
	cohort3 = "B1+B5";
	cohort4 = "A9-A11+A21-A23";
	cohort5="D";
	cohorts1 = new ArrayList<String>();
	cohorts2 = new ArrayList<String>();
	cohorts3 = new ArrayList<String>();
	cohorts4 = new ArrayList<String>();
	cohorts5 = new ArrayList<String>();
	cohorts1.add("A1");
	cohorts2.add("A1");
	cohorts2.add("A2");
	cohorts2.add("A3");
	cohorts2.add("A4");
	cohorts3.add("B1");
	cohorts3.add("B5");
	cohorts4.add("A9");
	cohorts4.add("A10");
	cohorts4.add("A11");
	cohorts4.add("A21");
	cohorts4.add("A22");
	cohorts4.add("A23");
	cohorts5.add("D");
	}
	
	/**
	 * This will test that a method will convert a date from a written date
	 * to a proper date format eg Mon 01 Jan 17 will convert to 20170101
	 */
	@Test
	public void testTextDate() {
		assertEquals(ConvertMethods.TextDate(preDate2),finalDateFormat);
	}
	/**
	 * This will test that a method will convert a date from a written date
	 * to a proper date format eg Mon 01/01/2017 will convert to 20170101
	 */
	@Test
	public void testDateConvertSQL() {
		assertEquals(ConvertMethods.DateConvertSQL(preDate1),finalDateFormat);
	}
	/**
	 * This method will convert a written group of Cohorts to a list of the groups 
	 * contained in this
	 * This will attempt to convert a single first year cohort
	 */
	@Test
	public void testConvert1() {
		assertEquals(ConvertMethods.convert(cohort1),cohorts1);
	}
	/**
	 * This method will convert a written group of Cohorts to a list of the groups 
	 * contained in this
	 * This will attempt to convert consecutive cohorts
	 */
	@Test
	public void testConvert2() {
		assertEquals(ConvertMethods.convert(cohort2),cohorts2);
	}
	/**
	 * This method will convert a written group of Cohorts to a list of the groups 
	 * contained in this
	 * This will attempt to convert non consecutive cohorts
	 */
	@Test
	public void testConvert3() {
		assertEquals(ConvertMethods.convert(cohort3),cohorts3);
	}
	/**
	 * This method will convert a written group of Cohorts to a list of the groups 
	 * contained in this
	 * This will attempt to convert both consecutive and non consecutive cohorts
	 */
	@Test
	public void testConvert4() {
		assertEquals(ConvertMethods.convert(cohort4),cohorts4);
	}
	/**
	 * This method will convert a written group of Cohorts to a list of the groups 
	 * contained in this
	 * This will test a non first year cohort
	 */
	@Test
	public void testConvert5() {
		assertEquals(ConvertMethods.convert(cohort5),cohorts5);
	}
	/**
	 * This method will convert 12 hour time to 24 hour time
	 * This will test a time before 12 PM
	 */
	@Test
	public void testTimeConvert1() {
		assertEquals(ConvertMethods.timeConvert(prehourtime1),posthourtime1);
	}
	/**
	 * This method will convert 12 hour time to 24 hour time
	 * This will test a time after 12PM
	 */
	@Test
	public void testTimeConvert2() {
		assertEquals(ConvertMethods.timeConvert(prehourtime2),posthourtime2);
	}

}
