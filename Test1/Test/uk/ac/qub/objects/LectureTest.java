package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson
 * The below test suite tests all of the getters, setters and toString()
 * method found in the uk.ac.qub.objects.Lecture.java class
 */

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LectureTest {

	/*
	 * Creating the test data variables that will be used in the below test
	 * suite
	 */
	int validID, invalidID, validWeekLowerBoundary, validWeekMiddleBoundary, validWeekUpperBoundary,
			invalidWeekLowerBoundary, invalidWeekUpperBoundary;
	String year1, year2, year3, year4, year5, invalidYearLowerBoundary, invalidYearUpperBoundary, validNotes,
			validDayMon, validDayTue, validDayWed, validDayThu, validDayFri, invalidDaySat, invalidDaySun,
			validStartDate, invalidStartDate, validStartTime, invalidStartTime, validEndTime, invalidEndTime,
			validGroup, validLocation, validSubject, invalidSubject, validTheme, validTeachingFormat, validDescription,
			validStaff, invalidStaff, validStyle, validModule;
	boolean validApproved, validEssential;

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
		validWeekLowerBoundary = 1;
		validWeekMiddleBoundary = 12;
		validWeekUpperBoundary = 24;
		invalidWeekLowerBoundary = 0;
		invalidWeekUpperBoundary = 25;
		year1 = "1";
		year2 = "2";
		year3 = "3";
		year4 = "4";
		year5 = "5";
		invalidYearLowerBoundary = "0";
		invalidYearUpperBoundary = "6";
		validNotes = "Important Lecture don't miss";
		validDayMon = "Monday";
		validDayTue = "Tuesday";
		validDayWed = "Wednesday";
		validDayThu = "Thursday";
		validDayFri = "Friday";
		invalidDaySat = "Saturday";
		invalidDaySun = "Sunday";
		validStartDate = "26/09/2017";
		invalidStartDate = null;
		validStartTime = "09:00";
		invalidStartTime = null;
		validEndTime = "10:00";
		invalidEndTime = null;
		validGroup = "A1";
		validLocation = "Whitla Medical Building";
		validSubject = "Building Blocks of Life";
		invalidSubject = null;
		validTheme = "Biology";
		validTeachingFormat = "Lecture";
		validDescription = "Wear appropriate clothes";
		validStaff = "Dr. David Roberts";
		validStyle = "Taught";
		validModule = "MBC1025";
		validApproved = true;
		validEssential = true;
	}

	/**
	 * testing the first Lecture constructor
	 */
	@Test
	public void testLectureConstructorFiveArgs() {
		Lecture lecture = new Lecture(validWeekLowerBoundary, validStartTime, validStaff, validModule, year1);
		assertNotNull(lecture);
		assertEquals(validWeekLowerBoundary, lecture.getWeek());
		assertEquals(validStartTime, lecture.getStartTime());
		assertEquals(validStaff, lecture.getStaff());
		assertEquals(validModule, lecture.getModule());
		assertEquals(year1, lecture.getYear());
	}

	/**
	 * Testing the second Lecture constructor with 15 args
	 */
	@Test
	public void testLectureIntIntStringStringStringStringStringStringStringStringStringStringStringStringString() {
		Lecture lecture = new Lecture(validWeekLowerBoundary, validID, validDayMon, validStartDate, validStartTime,
				validEndTime, validGroup, validLocation, validSubject, validTheme, validTeachingFormat,
				validDescription, validStaff, validStyle, validModule, validEssential, year1, validNotes);
		assertNotNull(lecture);
		assertEquals(validWeekLowerBoundary, lecture.getWeek());
		assertEquals(validID, lecture.getId());
		assertEquals(validDayMon, lecture.getDay());
		assertEquals(validStartDate, lecture.getStartDate());
		assertEquals(validStartTime, lecture.getStartTime());
		assertEquals(validEndTime, lecture.getEndTime());
		assertEquals(validGroup, lecture.getGroup());
		assertEquals(validLocation, lecture.getLocation());
		assertEquals(validSubject, lecture.getSubject());
		assertEquals(validTheme, lecture.getTheme());
		assertEquals(validTeachingFormat, lecture.getTeachingFormat());
		assertEquals(validDescription, lecture.getDescription());
		assertEquals(validStaff, lecture.getStaff());
		assertEquals(validStyle, lecture.getStyle());
		assertEquals(validModule, lecture.getModule());
		assertEquals(validEssential, lecture.getEssential());
		assertEquals(year1, lecture.getYear());
		assertEquals(validNotes, lecture.getNotes());
	}

	/**
	 * testing getter and setters for ID parameter with valid value (1)
	 */
	@Test
	public void testGetSetValidId() {
		Lecture lecture = new Lecture();
		lecture.setId(validID);
		assertEquals(validID, lecture.getId());
	}

	/**
	 * testing getter and setters for ID parameter with invalid value (0)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetSetInvalidID() {
		Lecture lecture = new Lecture();
		lecture.setId(invalidID);
	}

	/**
	 * Testing constructor with 14 args with valid values
	 */
	@Test
	public void testLectureIntStringStringStringStringStringStringStringStringStringStringStringStringString() {
		Lecture lecture = new Lecture(validWeekLowerBoundary, validDayMon, validStartDate, validStartTime, validEndTime,
				validGroup, validLocation, validSubject, validTheme, validTeachingFormat, validDescription, validStaff,
				validStyle, validModule);
		assertNotNull(lecture);
		assertEquals(validWeekLowerBoundary, lecture.getWeek());
		assertEquals(validDayMon, lecture.getDay());
		assertEquals(validStartDate, lecture.getStartDate());
		assertEquals(validStartTime, lecture.getStartTime());
		assertEquals(validEndTime, lecture.getEndTime());
		assertEquals(validGroup, lecture.getGroup());
		assertEquals(validLocation, lecture.getLocation());
		assertEquals(validSubject, lecture.getSubject());
		assertEquals(validTheme, lecture.getTheme());
		assertEquals(validTeachingFormat, lecture.getTeachingFormat());
		assertEquals(validDescription, lecture.getDescription());
		assertEquals(validStaff, lecture.getStaff());
		assertEquals(validStyle, lecture.getStyle());
		assertEquals(validModule, lecture.getModule());
	}

	/**
	 * Testing the largest Lecture constructor with 18 args with valid values
	 */
	@Test
	public void testLectureIntIntStringStringStringStringStringStringStringStringStringStringStringStringStringBooleanStringString() {
		Lecture lecture = new Lecture(validWeekLowerBoundary, validID, validDayMon, validStartDate, validStartTime,
				validEndTime, validGroup, validLocation, validSubject, validTheme, validTeachingFormat,
				validDescription, validStaff, validStyle, validModule, validEssential, year1, validNotes);
		assertNotNull(lecture);
		assertEquals(validWeekLowerBoundary, lecture.getWeek());
		assertEquals(validID, lecture.getId());
		assertEquals(validDayMon, lecture.getDay());
		assertEquals(validStartDate, lecture.getStartDate());
		assertEquals(validStartTime, lecture.getStartTime());
		assertEquals(validEndTime, lecture.getEndTime());
		assertEquals(validGroup, lecture.getGroup());
		assertEquals(validLocation, lecture.getLocation());
		assertEquals(validSubject, lecture.getSubject());
		assertEquals(validTheme, lecture.getTheme());
		assertEquals(validTeachingFormat, lecture.getTeachingFormat());
		assertEquals(validDescription, lecture.getDescription());
		assertEquals(validStaff, lecture.getStaff());
		assertEquals(validStyle, lecture.getStyle());
		assertEquals(validModule, lecture.getModule());
		assertEquals(validEssential, lecture.getEssential());
		assertEquals(year1, lecture.getYear());
		assertEquals(validNotes, lecture.getNotes());
	}

	/**
	 * Testing the empty default constructor with no args
	 */
	@Test
	public void testLecture() {
		Lecture lecture = new Lecture();
		assertNotNull(lecture);
	}

	/**
	 * Testing the getters and setters for year with valid value 1
	 */
	@Test
	public void testGetSetValidYear1() {
		Lecture lecture = new Lecture();
		lecture.setYear(year1);
		assertEquals(year1, lecture.getYear());
	}

	/**
	 * Testing the getters and setters for year with valid value 2
	 */
	@Test
	public void testGetSetValidYear2() {
		Lecture lecture = new Lecture();
		lecture.setYear(year2);
		assertEquals(year2, lecture.getYear());
	}

	/**
	 * Testing the getters and setters for year with valid value 3
	 */
	@Test
	public void testGetSetValidYear3() {
		Lecture lecture = new Lecture();
		lecture.setYear(year3);
		assertEquals(year3, lecture.getYear());
	}

	/**
	 * Testing the getters and setters for year with valid value 4
	 */
	@Test
	public void testGetSetValidYear4() {
		Lecture lecture = new Lecture();
		lecture.setYear(year4);
		assertEquals(year4, lecture.getYear());
	}

	/**
	 * Testing the getters and setters for year with valid value 5
	 */
	@Test
	public void testGetSetValidYear5() {
		Lecture lecture = new Lecture();
		lecture.setYear(year5);
		assertEquals(year5, lecture.getYear());
	}

	/**
	 * Testing the getters and setters for year with invalid value at lower
	 * boundary (0)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetSetInvalidYearLowerBoundary() {
		Lecture lecture = new Lecture();
		lecture.setYear(invalidYearLowerBoundary);
	}

	/**
	 * Testing the getters and setters for year with invalid value at upper
	 * boundary (6)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetSetInvalidYearUpperBoundary() {
		Lecture lecture = new Lecture();
		lecture.setYear(invalidYearUpperBoundary);
	}

	/**
	 * Testing the getters and setters for notes with valid value
	 */
	@Test
	public void testGetSetValidNotes() {
		Lecture lecture = new Lecture();
		lecture.setNotes(validNotes);
		assertEquals(validNotes, lecture.getNotes());
	}

	/**
	 * Testing the getters and setters for essential with valid value
	 */
	@Test
	public void testGetEssential() {
		Lecture lecture = new Lecture();
		lecture.setEssential(validEssential);
		assertEquals(validEssential, lecture.getEssential());
	}

	/**
	 * Testing the getters and setters for week with valid value at Lower
	 * Boundary (1)
	 */
	@Test
	public void testGetSetvalidWeekLowerBoundary() {
		Lecture lecture = new Lecture();
		lecture.setWeek(validWeekLowerBoundary);
		assertEquals(validWeekLowerBoundary, lecture.getWeek());
	}

	/**
	 * Testing the getters and setters for week with valid value at Middle
	 * Boundary (12)
	 */
	@Test
	public void testGetSetValidWeekMiddleBoundary() {
		Lecture lecture = new Lecture();
		lecture.setWeek(validWeekMiddleBoundary);
		assertEquals(validWeekMiddleBoundary, lecture.getWeek());
	}

	/**
	 * Testing the getters and setters for week with valid value at Upper
	 * Boundary (24)
	 */
	@Test
	public void testGetSetValidWeekUpperBoundary() {
		Lecture lecture = new Lecture();
		lecture.setWeek(validWeekUpperBoundary);
		assertEquals(validWeekUpperBoundary, lecture.getWeek());
	}

	

	/**
	 * Testing the getters and setters for week with invalid value at Upper
	 * Boundary (25)
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testGetSetInvalidWeekUpperBoundary() {
		Lecture lecture = new Lecture();
		lecture.setWeek(invalidWeekUpperBoundary);
	}

	/**
	 * Testing the getters and setters for day with valid value (Monday)
	 */
	@Test
	public void testGetSetValidDayMonday() {
		Lecture lecture = new Lecture();
		lecture.setDay(validDayMon);
		assertEquals(validDayMon, lecture.getDay());
	}

	/**
	 * Testing the getters and setters for day with valid value (Tuesday)
	 */
	@Test
	public void testGetSetValidDayTuesday() {
		Lecture lecture = new Lecture();
		lecture.setDay(validDayTue);
		assertEquals(validDayTue, lecture.getDay());
	}

	/**
	 * Testing the getters and setters for day with valid value (Wednesday)
	 */
	@Test
	public void testGetSetValidDayWednesday() {
		Lecture lecture = new Lecture();
		lecture.setDay(validDayWed);
		assertEquals(validDayWed, lecture.getDay());
	}

	/**
	 * Testing the getters and setters for day with valid value (Thursday)
	 */
	@Test
	public void testGetSetValidDayThursday() {
		Lecture lecture = new Lecture();
		lecture.setDay(validDayThu);
		assertEquals(validDayThu, lecture.getDay());
	}

	/**
	 * Testing the getters and setters for day with valid value (Friday)
	 */
	@Test
	public void testGetSetValidDayFriday() {
		Lecture lecture = new Lecture();
		lecture.setDay(validDayFri);
		assertEquals(validDayFri, lecture.getDay());
	}





	/**
	 * Testing the getter and setters for Start Date with valid value
	 */
	@Test
	public void testGetSetValidStartDate() {
		Lecture lecture = new Lecture();
		lecture.setStartDate(validStartDate);
		assertEquals(validStartDate, lecture.getStartDate());
	}



	

	/**
	 * testing getters and setters for Start Time with valid value
	 */
	@Test
	public void testGetSetValidStartTime() {
		Lecture lecture = new Lecture();
		lecture.setStartTime(validStartTime);
		assertEquals(validStartTime, lecture.getStartTime());
	}

	

	/**
	 * Testing getters and setters for End Time with valid value
	 */
	@Test
	public void testGetSetValidEndTime() {
		Lecture lecture = new Lecture();
		lecture.setEndTime(validEndTime);
		assertEquals(validEndTime, lecture.getEndTime());
	}



	/**
	 * Testing getters and setters for Group with valid value
	 */
	@Test
	public void testGetSetValidGroup() {
		Lecture lecture = new Lecture();
		lecture.setGroup(validGroup);
		assertEquals(validGroup, lecture.getGroup());
	}

	/**
	 * Testing getters and setters for Location with valid value
	 */
	@Test
	public void testGetSetValidLocation() {
		Lecture lecture = new Lecture();
		lecture.setLocation(validLocation);
		assertEquals(validLocation, lecture.getLocation());
	}

	/**
	 * Testing getters and setters for Subject with valid value
	 */
	@Test
	public void testGetSetValidSubject() {
		Lecture lecture = new Lecture();
		lecture.setSubject(validSubject);
		assertEquals(validSubject, lecture.getSubject());
	}



	/**
	 * Testing getters and setters for Theme with valid value
	 */
	@Test
	public void testGetSetValidTheme() {
		Lecture lecture = new Lecture();
		lecture.setTheme(validTheme);
		assertEquals(validTheme, lecture.getTheme());
	}

	/**
	 * Testing getters and setters for Teaching Format with valid value
	 */
	@Test
	public void testGetSetValidTeachingFormat() {
		Lecture lecture = new Lecture();
		lecture.setTeachingFormat(validTeachingFormat);
		assertEquals(validTeachingFormat, lecture.getTeachingFormat());
	}

	/**
	 * Testing getters and setters for Description with a valid value
	 */
	@Test
	public void testGetSetValidDescription() {
		Lecture lecture = new Lecture();
		lecture.setDescription(validDescription);
		assertEquals(validDescription, lecture.getDescription());
	}

	/**
	 * Testing getters and setters for Staff with a valid value
	 */
	@Test
	public void testGetSetValidStaff() {
		Lecture lecture = new Lecture();
		lecture.setStaff(validStaff);
		assertEquals(validStaff, lecture.getStaff());
	}

	

	/**
	 * Testing getters and setters for style with a valid value
	 */
	@Test
	public void testGetSetValidStyle() {
		Lecture lecture = new Lecture();
		lecture.setStyle(validStyle);
		assertEquals(validStyle, lecture.getStyle());
	}

	/**
	 * Testing getters and setters for a module with a valid value
	 */
	@Test
	public void testGetSetValidModule() {
		Lecture lecture = new Lecture();
		lecture.setModule(validModule);
		assertEquals(validModule, lecture.getModule());
	}

}
