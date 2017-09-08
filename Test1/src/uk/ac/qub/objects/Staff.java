package uk.ac.qub.objects;
/**
 * Name of Package - uk.ac.qub.objects 
 * Date Last Amended - 08/09/17 
 * Outline - The below is the Staff class that creates Staff objects that 
 * will be used for the Staff Administration screens within the 
 * administration console, as well as for the login screens for
 * the admin console
 * Demographics – 109 LOC 9 Methods
 */


public class Staff {
	
	/*
	 * creating the variables below to be used in the Room constructors,
	 * getters, setters and toString methods below
	 */
	String staff_number, name, access_level;
	
	/**
	 * The below is the primary constructor for the Staff class with 3 args
	 * @param staff_number
	 * @param name
	 * @param access_level
	 */
	public Staff(String staff_number, String name, String access_level) {
		setStaff_number(staff_number);
		setName(name);
		setAccess_level(access_level);
	}
	
	/**
	 * Below is the default constructor for the staff class with no arsg
	 */
	public Staff() {
	
	}
	
	/**
	 * Below is the getter for returning the staff number from the Staff object
	 * @return
	 */
	public String getStaff_number() {
		return staff_number;
	}
	
	/**
	 * Below is the setter for setting the staff number for the Staff object.
	 * @param staff_number
	 */
	public void setStaff_number(String staff_number) {
	
			this.staff_number = staff_number;
		
	}
	
	/**
	 * Below is the getter for returning the name parameter from the staff object 
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Below is the setter for the name parameter from the staff object.
	 * @param name
	 */
	public void setName(String name) {
	
			this.name = name;
	
	}
	
	/**
	 * Below is the getter for returning the Access Level parameter from the
	 * Staff object.
	 * @return
	 */
	public String getAccess_level() {
		return access_level;
	}
	
	/**
	 * Below is the setter for setting the Access Level parameter for the 
	 * Staff object
	 * @param access_level
	 */
	public void setAccess_level(String access_level) {
			this.access_level = access_level;
		
	}
	
	/**
	 * Below is the toString method that will be used to display information on
	 * the Staff Menus on the admin console
	 */
	@Override
	public String toString() {
		return "Staff Number:   " + staff_number + "\t Name:   " + name + "\t Access Level:   " + access_level;
	}

}
