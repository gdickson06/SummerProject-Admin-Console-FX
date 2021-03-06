package uk.ac.qub.objects;

/**
 * Name of Package - uk.ac.qub.objects Date Last Amended - 08/09/17 
 * Outline - The below is the Placement class that
 *         creates Placement objects that will be used for the Placement Upload
 *         screens within the administration console
 * Demographics � 270 LOC 24 Methods
 */


public class Placement {
	
	/*
	 * creating the variables below to be used in the Placement constructors,
	 * getters, setters and toString methods below
	 */
	int id,Year;
	String StartDate,EndDate,Location,Cohort,Note,Module,ModuleNumber,Preference;
	
	/**
	 * Below is the primary constructor for the Placement class
	 * @param id
	 * @param year
	 * @param startDate
	 * @param endDate
	 * @param location
	 * @param preference
	 * @param cohort
	 * @param note
	 * @param module
	 * @param moduleNumber
	 */
	public Placement(int id, int year, String startDate, String endDate, String location, String preference, String cohort,
			String note, String module, String moduleNumber) {
		
		setId(id);
		setYear(year);
		setStartDate(startDate);
		setEndDate(endDate);
		setLocation(location);
		setPreference(preference);
		setCohort(cohort);
		setNote(note);
		setModule(module);
		setModuleNumber(moduleNumber);

	}
	
	
	/**
	 * Below is the default constructor with no args for the Placement class
	 */
	public Placement() {
	
	}
	
	/**
	 * Below is the getter for retrieving the ID parameter from a
	 * Placement object
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * Below is the setter for setting the ID parameter of a Placement object.
	 * If the ID is less than 1 an exception will be thrown
	 * 
	 * @param id
	 */
	public void setId(int id) {
		if (id >= 0) {
			this.id = id;
		} else {
			throw new IllegalArgumentException("Invalid ID entered");
		}
	}
	
	/**
	 * Below is the getter for retrieving the year parameter for a Placement 
	 * object
	 * @return
	 */
	public int getYear() {
		return Year;
	}
	
	/**
	 * Below is the setter for setting the year parameter for a Placement object.
	 *  If the year is not between 1-5 an exception will be thrown
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		if (year >= 0 && year <= 5) {
			Year = year;
		} else {
			throw new IllegalArgumentException("Invalid Year Entered");
		}
	}
	
	/**
	 * Below is the getter for retrieving the Start Date parameter from a Placement
	 *  object
	 * @return
	 */
	public String getStartDate() {
		return StartDate;
	}
	
	/**
	 * Below is the setter for setting the Start Date parameter for a 
	 * Placement object.
	 * 
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		
			StartDate = startDate;
	
	}
	
	/**
	 * Below is the getter for retrieving the end Date parameter from a Placement
	 *  object
	 * @return
	 */
	public String getEndDate() {
		return EndDate;
	}
	
	/**
	 * Below is the setter for setting the End Date parameter for a 
	 * Placement object.
	 * 
	 * @param endDate
	 */
	public void setEndDate(String endDate) {
		
			EndDate = endDate;
		
	}
	
	/**
	 * Below is the getter for retrieving the location parameter from a Placement
	 *  object
	 * @return
	 */
	public String getLocation() {
		return Location;
	}
	
	/**
	 * Below is the setter for setting the location parameter for a Placement
	 * object. 
	 * @param location
	 */
	public void setLocation(String location) {
	
			Location = location;
	
	}
	
	/**
	 * Below is the getter for retrieving the preference parameter from a Placement
	 * object
	 * @return
	 */
	public String getPreference() {
		return Preference;
	}
	
	/**
	 * Below is the setter for setting the preference parameter for a Placement
	 * object.
	 * @param preference
	 */
	public void setPreference(String preference) {
			Preference = preference;
	}
	
	/**
	 * Below is the getter for retrieving the cohort parameter from a Placement
	 * object
	 * @return
	 */
	public String getCohort() {
		return Cohort;
	}
	
	/**
	 * Below is the setter for setting the cohort parameter for a Placement
	 * object.
	 * @param cohort
	 */
	public void setCohort(String cohort) {
	
			Cohort = cohort;
		
	}
	
	/**
	 * Below is the getter for retrieving the note parameter from a Placement
	 * object
	 * @return
	 */
	public String getNote() {
		return Note;
	}
	
	/**
	 * Below is setter for setting the note parameter for a Placement Object
	 * @param note
	 */
	public void setNote(String note) {
		Note = note;
	}
	
	/**
	 * Below is the getter for retrieving the module parameter for a Placement
	 * Object
	 * @return
	 */
	public String getModule() {
		return Module;
	}
	
	/**
	 * Below is the setter for setting the module parameter for a Placement
	 * Object. 
	 * @param module
	 */
	public void setModule(String module) {
	
			Module = module;
		
	}
	
	/**
	 * The below is the getter for retrieving the module number for a 
	 * Placement Object 
	 * @return
	 */
	public String getModuleNumber() {
		return ModuleNumber;
	}
	
	/**
	 * The below is the setter for setting the module number for a
	 * Placement object.
	 * @param moduleNumber
	 */
	public void setModuleNumber(String moduleNumber) {
		
			ModuleNumber = moduleNumber;
		
	}
	
	/**
	 * Below is the toString method that will display all Placement info on
	 * the Placement Menus on the Admin console
	 */
	@Override
	public String toString() {
		return "Placement id:   " + id + "\t Year:   " + Year + "\t Start Date:   " + StartDate + "\t End Date:   " + EndDate
				+ "\t Location:   " + Location + "\t Cohort:   " + Cohort + "\t Module:   " + Module;
	}
}
