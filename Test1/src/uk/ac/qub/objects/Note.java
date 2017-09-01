package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson The below is the Note class that
 *         creates Note objects which will be used for the Note Upload screens
 *         within the administration console
 */

public class Note {

	/*
	 * creating the variables below to be used in the Note constructors,
	 * getters, setters and toString methods below
	 */

	int id, Year;
	String Date, Details;

	/**
	 * Below is the primary constructor for the note class
	 * 
	 * @param id
	 * @param year
	 * @param date
	 * @param details
	 */
	public Note(int id, int year, String date, String details) {

		this.id = id;
		Year = year;
		Date = date;
		Details = details;
	}

	/**
	 * Below is the empty constructor
	 */

	public Note() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Below is the getter for retrieving the ID parameter of a note object
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Below is the setter for setting the ID parameter of a Note object. If the
	 * ID is less than 1 an exception will be thrown
	 * 
	 * @param id
	 */
	public void setId(int id) {
		if (id >= 1) {
			this.id = id;
		} else {
			throw new IllegalArgumentException("Invalid ID entered");
		}
	}

	/**
	 * Below is the getter for retrieving the year parameter for a Note object
	 * 
	 * @return
	 */
	public int getYear() {
		return Year;
	}

	/**
	 * Below is the setter for setting the year parameter for a Note object. If
	 * the year is not between 1-5 an exception will be thrown
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		
			Year = year;
		
	}

	/**
	 * Below is the getter for retrieving the date parameter from a Note object
	 * 
	 * @return
	 */
	public String getDate() {
		return Date;
	}

	/**
	 * Below is the setter for setting the date parameter for a Note object. If
	 * the field is left empty an exception will be thrown
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		
			Date = date;
		
	}

	/**
	 * below is the getter for retrieving the details parameter from the Note
	 * object
	 * 
	 * @return
	 */
	public String getDetails() {
		return Details;
	}

	/**
	 * Below is the setter for setting the details parameter for a Note object.
	 * If the field is left empty an exception will be thrown
	 * 
	 * @param details
	 */
	public void setDetails(String details) {
		
			Details = details;
		
	}

	/**
	 * Below is the toString method that will be used to display all Note
	 * Parameters to screen on the Note Uploads menus
	 */
	@Override
	public String toString() {
		return "Note id:   " + id + "\t Year:   " + Year + "\t Date:   " + Date + "\t Details:   " + Details;
	}

}
