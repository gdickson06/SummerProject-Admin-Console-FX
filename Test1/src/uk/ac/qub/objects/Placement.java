package uk.ac.qub.objects;

public class Placement {
	
	int Week;
	String StartDate,Cohort,Subject,Location,Notes;
	public Placement(int week, String startDate, String cohort, String subject, String location) {
		Week = week;
		StartDate = startDate;
		Cohort = cohort;
		Subject = subject;
		Location = location;
	}
	public Placement(int week, String startDate, String cohort, String subject, String location, String notes) {
		Week = week;
		StartDate = startDate;
		Cohort = cohort;
		Subject = subject;
		Location = location;
		Notes = notes;
	}
	public int getWeek() {
		return Week;
	}
	public void setWeek(int week) {
		Week = week;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getCohort() {
		return Cohort;
	}
	public void setCohort(String cohort) {
		Cohort = cohort;
	}
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getNotes() {
		return Notes;
	}
	public void setNotes(String notes) {
		Notes = notes;
	}
	
	
	
	

	
}
