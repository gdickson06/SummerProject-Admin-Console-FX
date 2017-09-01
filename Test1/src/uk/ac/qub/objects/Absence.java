package uk.ac.qub.objects;

/**
 * @author Calum Hurst and Gerard Dickson
 * The below class creates Absence Objects that will interact with the 
 * Absence menu screens on the administration console
 */

import java.time.LocalDate;
import java.util.InputMismatchException;

import uk.ac.qub.methods.GeneralMethods;

public class Absence {

	/*
	 * Creating the data to be used in constructors, getters and setters and
	 * toString()method
	 */
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
		super();
		this.id = id;
		StudentNumber = studentNumber;
		LectureID = lectureID;
		StartDate = startDate;
		EndDate = endDate;
		StartTime = startTime;
		EndTime = endTime;
		Reason = reason;
		this.type = type;
		this.approved = approved;
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
	 * Object. If the Student Number is less than 00000001 or greater than
	 * 99999999 (or if a value other than an int is inputted) an exception will
	 * be thrown
	 * 
	 * @param studentNumber
	 */
	public void setStudentNumber(int studentNumber) {
		try {
			if (studentNumber >= 00000000 && StudentNumber <= 99999999) {
				StudentNumber = studentNumber;
			} else {
				throw new IllegalArgumentException("Invalid Entry for Student Number");
			}
		} catch (InputMismatchException e) {
			System.err.println("Incorrect Input entered for Student Number");
			e.printStackTrace();
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
	 * This setter will set the Lecture ID arg for an absence object If a value
	 * other than an int, or a value less than 1, is inputted an exception will
	 * be thrown
	 * 
	 * @param lectureID
	 */
	public void setLectureID(int lectureID) {
		try {
			if (lectureID >= 1) {
				LectureID = lectureID;
			} else {
				throw new IllegalArgumentException("Lecture ID cannot be less than 1");
			}
		} catch (InputMismatchException e) {
			System.err.println("Incorrect Input entered for Lecture ID");
			e.printStackTrace();
		}
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
	 * This setter will return the start date of the absence object and will
	 * throw an exception if the arg is empty
	 * 
	 * @return
	 */
	public void setStartDate(String startDate) {
		try {
			if (!startDate.isEmpty()) {
				StartDate = startDate;
			} else {
				throw new IllegalArgumentException("No input for startDate");
			}
		} catch (InputMismatchException e) {
			System.err.println("Incorrect Input entered for Start Date");
		}
	}

	/**
	 * Below is the getter for retreiving the EndDate arg of an absence object
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
	 * Below is the setter for the End Time arg of an Absence Object If the
	 * field is left empty an exception will be thrown
	 * 
	 * @param endTime
	 */
	public void setEndTime(String endTime) {
		try {
			if (!endTime.isEmpty()) {
				EndTime = endTime;
			} else {
				throw new IllegalArgumentException("End Time is empty");
			}
		} catch (InputMismatchException e) {
			System.err.println("Incorrect Input entered for End Time");
			e.printStackTrace();
		}

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
		return "Absence id:   " + id + "\t Student Number:   " + StudentNumber + "\t Lecture ID:   " + LectureID + "\t Start Date:   "
				+ StartDate + "\t End Date:  " + EndDate + "\t Start Time:   " + StartTime + "\t End Time:   " + EndTime + "\t Reason:   "
				+ Reason + "\t Type:   " + type + "\t Approved:   " + approved;
	}

}
