package uk.ac.qub.objects;

/**
 * The below is the class for Extended Absences, an absence that is longer than
 * five days, and which will be used in the Absence menus
 * 
 * @author Calum Hurst and Gerard Dickson
 *
 */

public class ExtendedAbsence {

	int year, studentNumber;
	String Type, start, end;
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getStudentNumber() {
		return studentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		this.studentNumber = studentNumber;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	

}
