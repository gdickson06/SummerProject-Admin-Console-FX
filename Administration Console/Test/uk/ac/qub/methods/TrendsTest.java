package uk.ac.qub.methods;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class TrendsTest {
	List<String> singleDay;
	List<String> multiDays;
	List<LocalDate> singleDate;
	List<LocalDate> multiDates;
	String date1;
	String date2;
	
	
	@Before
	public void setUp() throws Exception {
		singleDay = new ArrayList<String>();
		multiDays = new ArrayList<String>();
		singleDate = new ArrayList<LocalDate>();
		multiDates = new ArrayList<LocalDate>();
		date1= "2017-01-02";
		date2="2017-01-04";
		
		singleDate.add(LocalDate.parse("2017-01-02"));
		multiDates.add(LocalDate.parse("2017-01-02"));
		multiDates.add(LocalDate.parse("2017-01-03"));
		multiDates.add(LocalDate.parse("2017-01-04"));
		singleDay.add("MONDAY");
		multiDays.add("MONDAY");
		multiDays.add("TUESDAY");
		multiDays.add("WEDNESDAY");
	}
	
/**
 * This method will test the dates convert with a start date and end date on the same
 * day
 */
	@Test
	public void testDates1() {
		assertEquals(AbsenceTrends.dates(date1, date1),singleDate);
	}
	/**
	 * This method will test the dates convert with a start date and end date on 
	 * different days
	 */
	@Test
	public void testDates2() {
		assertEquals(AbsenceTrends.dates(date1, date2),multiDates);
	}
	/**
	 * This method will test the day convert with a start date and end date on 
	 * the same day
	 */
	@Test
	public void testDays1() {
		assertEquals(AbsenceTrends.days(singleDate),singleDay);
	}
	/**
	 * This method will test the day convert with a start date and end date on 
	 * different days
	 */
	@Test
	public void testDays2() {
		assertEquals(AbsenceTrends.days(multiDates),multiDays);
	}

}
