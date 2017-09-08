package uk.ac.qub.objects;

/**
 * Name of Package - uk.ac.qub.objects Date Last Amended - 08/09/17 
 * Outline -
 * The below is the GroupCon class that converts group and cohorts into objects
 * so that they can be used in the timetable on the application 
 * Demographics – 82 LOC 6 Methods
 */

public class GroupsCon {

	/*
	 * creating the variables below to be used in the GroupCon constructor,
	 * getters, setters and toString methods below
	 */
	String groups;
	String cohort;

	/**
	 * The below is the primary constructor for the GroupCon class
	 * 
	 * @param groups
	 * @param cohort
	 */
	public GroupsCon(String groups, String cohort) {
		this.groups = groups;
		this.cohort = cohort;
	}

	/**
	 * The below is the default constructor with no args
	 */
	public GroupsCon() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * The below is the getter for retrieving the Group parameter from the
	 * GroupCon object
	 * 
	 * @return
	 */
	public String getGroups() {
		return groups;
	}

	/**
	 * The below is the setter for setting the Group parameter from the GroupCon
	 * object.
	 * 
	 * @param groups
	 */
	public void setGroups(String groups) {

		this.groups = groups;

	}

	/**
	 * The below is the getter for retrieving the Cohort parameter from the
	 * GroupCon object
	 * 
	 * @return
	 */
	public String getCohort() {
		return cohort;
	}

	/**
	 * The below is the setter for setting the Cohort parameter from the
	 * GroupCon object.
	 * 
	 * @param groups
	 */
	public void setCohort(String cohort) {

		this.cohort = cohort;

	}

}
