package uk.ac.qub.objects;

/**
 * The below is the class for Extended Absences, an absence that is longer than
 * five days, and which will be used in the Absence menus
 * 
 * @author Calum Hurst and Gerard Dickson
 *
 */

public class ExtendedAbsence {

	/*
	 * Creating variables to be stored as args in the constructors, getters,
	 * setters and toString() method
	 */
	String Year, Day, staff, cohort, module, date, StudentNumber, Type;

	/**
	 * Below is the constructor for ExtendedAbsence with args included
	 */
	public ExtendedAbsence(String year, String day, String staff, String cohort, String module, String date,
			String studentNumber, String type) {
		super();
		Year = year;
		Day = day;
		this.staff = staff;
		this.cohort = cohort;
		this.module = module;
		this.date = date;
		StudentNumber = studentNumber;
		Type = type;
	}

	/**
	 * Below is the default empty constructor for ExtendedAbsence
	 */
	public ExtendedAbsence() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Below is the getter to return the type arg of an ExtendedAbsence object
	 * 
	 * @return
	 */
	public String getType() {
		return Type;
	}

	/**
	 * Below is the setter that will set the Type arg for an ExtendedAbsence
	 * object. If the type entered does not match one of the three types below
	 * then an exception will be thrown
	 * 
	 * @param type
	 */
	public void setType(String type) {
		if (type.equalsIgnoreCase("Illness") || type.equalsIgnoreCase("Non Illness Related Absence")
				|| type.equalsIgnoreCase("Missing from class")) {
			Type = type;
		} else {
			throw new IllegalArgumentException("Incorrect Type Entered");
		}
	}

	/**
	 * The below is the getter that will retreive the year arg from an
	 * ExtendedAbsence object
	 * 
	 * @return
	 */
	public String getYear() {
		return Year;
	}

	/**
	 * The below is the setter for the year arg of an ExtendedAbsence object. If
	 * the year is not between 1-5 then an exception will be thrown
	 * 
	 * @param year
	 */
	public void setYear(String year) {
		if (year.equals("1") || year.equals("2") || year.equals("3") || year.equals("4") || year.equals("5")) {
			Year = year;
		} else {
			throw new IllegalArgumentException("Invalid Year Selected");
		}
	}

	/**
	 * The below getter will retrieve the day arg from an ExtendedAbsence object
	 * 
	 * @return
	 */
	public String getDay() {
		return Day;
	}

	/**
	 * Below is the setter for the day arg in an ExtendedAbsence object. If one
	 * of the below values is not entered an exception will be thrown
	 * 
	 * @param day
	 */
	public void setDay(String day) {
		if (day.equalsIgnoreCase("Monday") || day.equalsIgnoreCase("Tuesday") || day.equalsIgnoreCase("Wednesday")
				|| day.equalsIgnoreCase("Thursday") || day.equalsIgnoreCase("Friday")) {
			Day = day;
		} else {
			throw new IllegalArgumentException("Invalid day Entered");
		}
	}

	/**
	 * Below is the getter for the Staff arg in an ExtendedAbsence object
	 * 
	 * @return
	 */
	public String getStaff() {
		return staff;
	}

	/**
	 * The below is the setter for the Staff arg in an ExtendedAbsence object
	 * 
	 * @param staff
	 */
	public void setStaff(String staff) {
		if (!staff.isEmpty()) {
			this.staff = staff;
		} else {
			throw new NullPointerException("No Staff Inputted");
		}
	}

	/**
	 * The below is the getter for returning the cohort arg from an
	 * ExtendedAbsence object
	 * 
	 * @return
	 */
	public String getCohort() {
		return cohort;
	}

	/**
	 * The below is the setter for setting the cohort arg in an ExtendedAbsence
	 * object
	 * 
	 * @param cohort
	 */
	public void setCohort(String cohort) {
		if (!cohort.isEmpty()) {
			this.cohort = cohort;
		} else {
			throw new NullPointerException("No Cohort Entered");
		}
	}

	/**
	 * The below is the getter for returning the module arg from an
	 * ExtendedAbsence object
	 * 
	 * @return
	 */
	public String getModule() {
		return module;
	}

	/**
	 * The below is the setter for setting the module arg for an ExtendedAbsence
	 * object
	 * 
	 * @param module
	 */
	public void setModule(String module) {
		if (!module.isEmpty()) {
			this.module = module;
		} else {
			throw new NullPointerException("No Module Entered");
		}
	}

	/**
	 * The below is the getter for returning the Date arg of an ExtendedAbsence
	 * object
	 * 
	 * @return
	 */
	public String getDate() {
		return date;
	}

	/**
	 * The below is the setter for setting the Date arg for an ExtendedAbsence
	 * object
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		if (!date.isEmpty()) {
			this.date = date;
		} else {
			throw new NullPointerException("No Date Entered");
		}
	}

	/**
	 * The below is the getter for returning the Student Number arg of an
	 * ExtendedAbsence object
	 * 
	 * @return
	 */
	public String getStudentNumber() {
		return StudentNumber;
	}

	/**
	 * The below is the setter for setting the Student Number arg of an
	 * ExtendedAbsence object
	 * 
	 * @param studentNumber
	 */
	public void setStudentNumber(String studentNumber) {
		if (!studentNumber.isEmpty()) {
			StudentNumber = studentNumber;
		} else {
			throw new NullPointerException("No Student Number Enterd");
		}
	}

	@Override
	public String toString() {
		return "ExtendedAbsence [Year=" + Year + ", Day=" + Day + ", staff=" + staff + ", cohort=" + cohort
				+ ", module=" + module + ", date=" + date + ", StudentNumber=" + StudentNumber + ", Type=" + Type + "]";
	}

}
