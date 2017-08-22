package uk.ac.qub.objects;

public class GroupsCon {
	String groups;
	String cohort;
	
	
	
	@Override
	public String toString() {
		return "GroupsCon [groups=" + groups + ", cohort=" + cohort + "]";
	}
	public GroupsCon(String groups, String cohort) {
		this.groups = groups;
		this.cohort = cohort;
	}
	public GroupsCon() {
		// TODO Auto-generated constructor stub
	}
	public String getGroups() {
		return groups;
	}
	public void setGroups(String groups) {
		this.groups = groups;
	}
	public String getCohort() {
		return cohort;
	}
	public void setCohort(String cohort) {
		this.cohort = cohort;
	}
	
	


	

}
