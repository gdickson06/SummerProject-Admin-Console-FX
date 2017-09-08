package uk.ac.qub.objects;

/**
 * Name of Package - uk.ac.qub.objects
 * Date Last Amended - 08/09/17
 * Outline - The below is the class for Extended Absences, an absence that is longer than
 * five days, and which will be used in the Absence menus
 * Demographics – 88 LOC 10 Methods 
 */

public class ExtendedAbsence {

	int year, studentNumber;
	String Type, start, end;
	
	/**
	 * The getter for the year value
	 * @return
	 */
	public int getYear() {
		return year;
	}
	/**
	 * The setter for year value
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * The getter for Student number
	 * @return
	 */
	public int getStudentNumber() {
		return studentNumber;
	}
	/**
	 * The setter for student number
	 * @param studentNumber
	 */
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	/**
	 * The getter for type
	 * @return
	 */
	public String getType() {
		return Type;
	}
	/**
	 * The setter for type
	 * @param type
	 */
	public void setType(String type) {
		Type = type;
	}
	/**
	 * The getter for start date
	 * @return
	 */
	public String getStart() {
		return start;
	}
	/**
	 * The setter for start date
	 * @param start
	 */
	public void setStart(String start) {
		this.start = start;
	}
	/**
	 * The getter for end date
	 * @return
	 */
	public String getEnd() {
		return end;
	}
	/**
	 * The setter for end date
	 * @param end
	 */
	public void setEnd(String end) {
		this.end = end;
	}
	

}
