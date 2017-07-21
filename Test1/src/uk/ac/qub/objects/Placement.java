package uk.ac.qub.objects;

public class Placement {
	
	int id,week,Year;
	String StartDate,EndDate,Subject,Location,Teacher,Cohort,Note;
	public Placement(int id, int week, int year, String startDate, String endDate, String subject, String location,
			String teacher, String cohort, String note) {
		super();
		this.id = id;
		this.week = week;
		Year = year;
		StartDate = startDate;
		EndDate = endDate;
		Subject = subject;
		Location = location;
		Teacher = teacher;
		Cohort = cohort;
		Note = note;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getWeek() {
		return week;
	}
	public void setWeek(int week) {
		this.week = week;
	}
	public int getYear() {
		return Year;
	}
	public void setYear(int year) {
		Year = year;
	}
	public String getStartDate() {
		return StartDate;
	}
	public void setStartDate(String startDate) {
		StartDate = startDate;
	}
	public String getEndDate() {
		return EndDate;
	}
	public void setEndDate(String endDate) {
		EndDate = endDate;
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
	public String getTeacher() {
		return Teacher;
	}
	public void setTeacher(String teacher) {
		Teacher = teacher;
	}
	public String getCohort() {
		return Cohort;
	}
	public void setCohort(String cohort) {
		Cohort = cohort;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	
}
