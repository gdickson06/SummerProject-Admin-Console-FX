package uk.ac.qub.objects;

public class Lecture {
	
	int Week,id;
	
	public Lecture(int id, int week, String day, String startDate, String startTime, String endTime, String group,
			String location, String subject, String theme, String teachingFormat, String description, String staff,
			String style, String module) {
	
		Week = week;
		this.id = id;
		Day = day;
		this.startDate = startDate;
		StartTime = startTime;
		EndTime = endTime;
		this.group = group;
		this.location = location;
		this.subject = subject;
		this.theme = theme;
		this.teachingFormat = teachingFormat;
		this.description = description;
		this.staff = staff;
		this.style = style;
		this.module = module;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	String Day, startDate, StartTime, EndTime, group, location, subject, theme, teachingFormat, description, staff, style, module,year,notes;
	Boolean Essential;
	public Lecture(int week, String day, String startDate, String startTime, String endTime,
			String group, String location, String subject, String theme, String teachingFormat, String description,
			String staff, String style, String module) {
		super();
		Week = week;
		Day = day;
		this.startDate = startDate;
		StartTime = startTime;
		EndTime = endTime;
		this.group = group;
		this.location = location;
		this.subject = subject;
		this.theme = theme;
		this.teachingFormat = teachingFormat;
		this.description = description;
		this.staff = staff;
		this.style = style;
		this.module = module;
	}
	
	
	public Lecture(int week, int id, String day, String startDate, String startTime, String endTime, String group,
			String location, String subject, String theme, String teachingFormat, String description, String staff,
			String style, String module,Boolean essential, String year, String notes) {
		Week = week;
		this.id = id;
		Day = day;
		this.startDate = startDate;
		StartTime = startTime;
		EndTime = endTime;
		this.group = group;
		this.location = location;
		this.subject = subject;
		this.theme = theme;
		this.teachingFormat = teachingFormat;
		this.description = description;
		this.staff = staff;
		this.style = style;
		this.module = module;
		this.year = year;
		this.notes = notes;
		Essential = essential;
	}
	
	//creating constructor to be used for ComboSearch method in the LectureAmendController.java class
	public Lecture(int week, String subject, String group, String staff, String module, String startDate){
		Week = week;
		this.subject=subject;
		this.group=group;
		this.staff=staff;
		this.module=module;
		this.startDate=startDate;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public Boolean getEssential() {
		return Essential;
	}
	public void setEssential(Boolean essential) {
		Essential = essential;
	}
	public int getWeek() {
		return Week;
	}
	public void setWeek(int week) {
		Week = week;
	}
	public String getDay() {
		return Day;
	}
	public void setDay(String day) {
		Day = day;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	@Override
	public String toString() {
		return "Lecture [Week=" + Week + ", Day=" + Day + ", startDate=" + startDate + ", StartTime=" + StartTime
				+ ", EndTime=" + EndTime + ", group=" + group + ", location=" + location + ", subject=" + subject
				+ ", theme=" + theme + ", teachingFormat=" + teachingFormat + ", description=" + description
				+ ", staff=" + staff + ", style=" + style + ", module=" + module + "]";
	}
	public String getStartTime() {
		return StartTime;
	}
	public void setStartTime(String startTime) {
		StartTime = startTime;
	}
	public String getEndTime() {
		return EndTime;
	}
	public void setEndTime(String endTime) {
		EndTime = endTime;
	}
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getTeachingFormat() {
		return teachingFormat;
	}
	public void setTeachingFormat(String teachingFormat) {
		this.teachingFormat = teachingFormat;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStaff() {
		return staff;
	}
	public void setStaff(String staff) {
		this.staff = staff;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}   

	

}
