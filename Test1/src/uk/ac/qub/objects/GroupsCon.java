package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson 
 * The below is the GroupCon class that converts group and cohorts
 * into objects so that they can be used in the timetable on the application
 *
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
	 * @param groups
	 * @param cohort
	 */
	public GroupsCon(String groups, String cohort) {
		this.groups = groups;
		this.cohort = cohort;
	}
	
	/**
	 *  The below is the default constructor with no args
	 */
	public GroupsCon() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * The below is the getter for retrieving the Group parameter from
	 * the GroupCon object
	 * @return
	 */
	public String getGroups() {
		return groups;
	}
	
	/**
	 * The below is the setter for setting the Group parameter from
	 * the GroupCon object. If the Group field is left empty an
	 * exception will be thrown
	 * @param groups
	 */
	public void setGroups(String groups) {
		if(!groups.isEmpty()){
			this.groups = groups;
		} else {
			throw new NullPointerException("No Group Entered");
		}
	}
	
	/**
	 * The below is the getter for retrieving the Cohort parameter from
	 * the GroupCon object
	 * @return
	 */
	public String getCohort() {
		return cohort;
	}
	
	/**
	 * The below is the setter for setting the Cohort parameter from
	 * the GroupCon object. If the Cohort field is left empty an
	 * exception will be thrown
	 * @param groups
	 */
	public void setCohort(String cohort) {
		if(!cohort.isEmpty()){
			this.cohort = cohort;
		} else {
			throw new NullPointerException("No Cohort Entered");
		}
	}
	
	/**
	 * Below is the toString method for the GroupCon class
	 */
	@Override
	public String toString() {
		return "GroupsCon [groups=" + groups + ", cohort=" + cohort + "]";
	}

}
