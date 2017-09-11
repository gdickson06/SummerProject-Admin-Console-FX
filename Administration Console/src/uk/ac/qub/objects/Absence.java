package uk.ac.qub.objects;

/**
 * Name of Package - uk.ac.qub.objects
 * Date Last Amended - 08/09/17
 * Outline - The below class creates Absence Objects that will interact with the 
 * Absence menu screens on the administration console
 * Demographics – 312 LOC 25 Methods 
 */

import java.time.LocalDate;
import java.util.InputMismatchException;

import uk.ac.qub.methods.GeneralMethods;

public class Absence {

	int id, StudentNumber, LectureID;
	String StartDate, EndDate, StartTime, EndTime, Reason, type;
	Boolean approved, viewed;

	/**
	 * Below is the primary constructor for an Absence Object
	 * 
	 * @param id
	 * @param studentNumber
	 * @param lectureID
	 * @param startDate
	 * @param endDate
	 * @param startTime
	 * @param endTime
	 * @param reason
	 * @param type
	 * @param approved
	 * @param viewed
	 */
	public Absence(int id, int studentNumber, int lectureID, String startDate, String endDate, String startTime,
			String endTime, String reason, String type, Boolean approved, Boolean viewed) {
		
		setId(id);
		setStudentNumber(studentNumber);
		setLectureID(lectureID);
		setStartDate(startDate);
		setEndDate(endDate);
		setStartTime(startTime);
		setEndTime(endTime);
		setReason(reason);
		setType(type);
		setApproved(approved);
		setViewed(viewed);
	}
/**
 * The getter for the viewed boolean
 * @return
 */
	public Boolean getViewed() {
		return viewed;
	}
/**
 * The setter for the viewed boolean
 * @param viewed
 */
	public void setViewed(Boolean viewed) {
		this.viewed = viewed;
	}

	/**
	 * Below is the default empty constructor for the Absence Class
	 */
	public Absence() {

	}

	/**
	 * The below is the getter for retrieving the ID arg from an Absence object
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * The below setter sets the ID arg for an absence Object, and if the value
	 * of the ID is less than 1 or is not an int, then an exception will be
	 * thrown
	 * 
	 * @param id
	 */
	public void setId(int id) {
		try {
			if (id >= 1) {
				this.id = id;
			} else {
				throw new IllegalArgumentException("ID cannot be lower than one");
			}
		} catch (InputMismatchException e) {
			System.err.println("Incorrect format used for ID");
		}
	}

	/**
	 * Below is the getter for retrieving the Student Nunber arg from an Absence
	 * object
	 * 
	 * @return
	 */
	public int getStudentNumber() {
		return StudentNumber;
	}

	/**
	 * The below setter sets the value of the Student Number for the Absence
	 * Object. If the Student Number is less than 00000000 or greater than
	 * 99999999 (or if a value other than an int is inputted) an exception will
	 * be thrown the value of 00000000 is allowed in case of null
	 * 
	 * @param studentNumber
	 */
	public void setStudentNumber(int studentNumber) throws IllegalArgumentException {

		if (studentNumber >= 00000000 && StudentNumber <= 99999999) {
			StudentNumber = studentNumber;
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * This getter retreives the value of the Lecture ID arg of an Absence
	 * object
	 * 
	 * @return
	 */
	public int getLectureID() {
		return LectureID;
	}

	/**
	 * The setter for the lecture ID, validation is done in different classes
	 * and will be handled different depending on the needs
	 * 
	 * @param lectureID
	 */
	public void setLectureID(int lectureID) {

		LectureID = lectureID;

	}

	/**
	 * This getter will retrieve the Start Date of an absence object
	 * 
	 * @return
	 */
	public String getStartDate() {
		return StartDate;
	}

	/**
	 * This setter will return the start date of the absence object 
	 * 
	 * @return
	 */
	public void setStartDate(String startDate) {
		
				StartDate = startDate;
		
	}

	/**
	 * Below is the getter for retrieving the EndDate arg of an absence object
	 * 
	 * @return
	 */
	public String getEndDate() {

		return EndDate;
	}

	/**
	 * This method will return the end date of an absence and ensure that it is
	 * not earlier than the start date
	 * 
	 * @return
	 */
	public void setEndDate(String endDate) {
		if (LocalDate.parse(endDate).isBefore(LocalDate.parse(StartDate))) {
			GeneralMethods.show("End date cannot come before start date", "Error");
		} else {
			EndDate = endDate;
		}
	}

	/**
	 * Below is the getter for the Start Time arg of an Absence Object
	 * 
	 * @return
	 */
	public String getStartTime() {
		return StartTime;
	}

	/**
	 * Below is the setter for Start Time arg of an Absence Object If the arg
	 * value is null an exception will be thrown
	 * 
	 * @param startTime
	 */
	public void setStartTime(String startTime) {

		StartTime = startTime;

	}

	/**
	 * below is the getter for End Time arg for an absence object
	 * 
	 * @return
	 */
	public String getEndTime() {
		return EndTime;
	}

	/**
	 * Below is the setter for the End Time arg of an Absence Object 
	 * 
	 * @param endTime
	 */
	public void setEndTime(String endTime) {
	
				EndTime = endTime;
		

	}

	/**
	 * Below is the getter for retrieving the reason arg for an absence object
	 * 
	 * @return
	 */
	public String getReason() {
		return Reason;
	}

	/**
	 * setter for the reason arg in absence object, if this field is not filled
	 * a NullPointerException is thrown
	 * 
	 * @param reason
	 */
	public void setReason(String reason) {

		Reason = reason;

	}

	/**
	 * getter for retrieving the type boolean from an absence object
	 * 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * The below setter sets the value of type to one of the three options if
	 * the option entered does not match an exception will be thrown
	 * 
	 * @param type
	 */
	public void setType(String type) {
		if (type.equalsIgnoreCase("Illness") || type.equalsIgnoreCase("Non Illness Related Absence")
				|| type.equalsIgnoreCase("Missing from class")) {
			this.type = type;
		} else
			throw new IllegalArgumentException("Incorrect Type entered");
	}

	/**
	 * getter for retrieving the approved boolean from an absence object
	 * 
	 * @return
	 */
	public Boolean getApproved() {
		return approved;
	}

	/**
	 * The below setter sets the value of approved to the boolean that is
	 * selected when an instance of the absence object is created
	 * 
	 * @param approved
	 */
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	/**
	 * Below is the toString method that will be used to display Absence
	 * information in the Amend Delete Absence ListView menu
	 */
	@Override
	public String toString() {
		return "Absence id:   " + id + "\t Student Number:   " + StudentNumber + "\t Lecture ID:   " + LectureID
				+ "\t Start Date:   " + StartDate + "\t End Date:  " + EndDate + "\t Start Time:   " + StartTime
				+ "\t End Time:   " + EndTime + "\t Reason:   " + Reason + "\t Type:   " + type + "\t Approved:   "
				+ approved;
	}

}
