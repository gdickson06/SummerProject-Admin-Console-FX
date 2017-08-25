package uk.ac.qub.objects;

/**
 * @author Calum Hurst & Gerard Dickson The below is the lecture class that
 *         creates Lecture objects which will be used for the Lecture
 *         Administration and Lecture Notes screens within the administration
 *         console
 */

public class Lecture {

	/*
	 * creating the variables below to be used in the Lecture constructors,
	 * getters, setters and toString methods below
	 */
	int Week, id;

	String Day, startDate, StartTime, EndTime, group, location, subject, theme, teachingFormat, description, staff,
			style, module, year, notes;

	Boolean Essential;

	public Lecture(int week, String startTime, String staff, String module, String year) {
		super();
		Week = week;

		StartTime = startTime;
		this.staff = staff;
		this.module = module;
		this.year = year;
	}

	/**
	 * Below is the primary constructor with args for the Lecture class
	 * 
	 * @param id
	 * @param week
	 * @param day
	 * @param startDate
	 * @param startTime
	 * @param endTime
	 * @param group
	 * @param location
	 * @param subject
	 * @param theme
	 * @param teachingFormat
	 * @param description
	 * @param staff
	 * @param style
	 * @param module
	 */
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

	/**
	 * Below is the getter for returning the ID parameter from the Lecture
	 * object
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Below is the setter for setting the ID parameter for the Lecture object.
	 * If the ID is less than o an exception will be thrown
	 * 
	 * @param id
	 */
	public void setId(int id) {
		if (id >= 1) {
			this.id = id;
		} else {
			throw new IllegalArgumentException("Invalid Lecture ID entered");
		}
	}

	/**
	 * Secondary constructor with args (including notes) for Lecture object
	 * 
	 * @param week
	 * @param day
	 * @param startDate
	 * @param startTime
	 * @param endTime
	 * @param group
	 * @param location
	 * @param subject
	 * @param theme
	 * @param teachingFormat
	 * @param description
	 * @param staff
	 * @param style
	 * @param module
	 */
	public Lecture(int week, String day, String startDate, String startTime, String endTime, String group,
			String location, String subject, String theme, String teachingFormat, String description, String staff,
			String style, String module) {
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

	/**
	 * Third constructor for Lecture object
	 * 
	 * @param week
	 * @param id
	 * @param day
	 * @param startDate
	 * @param startTime
	 * @param endTime
	 * @param group
	 * @param location
	 * @param subject
	 * @param theme
	 * @param teachingFormat
	 * @param description
	 * @param staff
	 * @param style
	 * @param module
	 * @param essential
	 * @param year
	 * @param notes
	 */
	public Lecture(int week, int id, String day, String startDate, String startTime, String endTime, String group,
			String location, String subject, String theme, String teachingFormat, String description, String staff,
			String style, String module, Boolean essential, String year, String notes) {
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

	/**
	 * default constructor for Lecture object with no args
	 */
	public Lecture() {

	}

	/**
	 * getter for returning the year paramater from the Lecture object
	 * 
	 * @return
	 */
	public String getYear() {
		return year;
	}

	/**
	 * Setter for setting the year parameter for the Lecture Object. If the year
	 * entered is not between 1-5 an exception is thrown
	 * 
	 * @param year
	 */
	public void setYear(String year) {
		if (year.equals("1") || year.equals("2") || year.equals("3") || year.equals("4") || year.equals("5")) {
			this.year = year;
		} else {
			throw new IllegalArgumentException("Invalid Year entered");
		}
	}

	/**
	 * getter for returning the notes paramater from the Lecture object
	 * 
	 * @return
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * Below is the setter for setting the notes parameter for the Lecture
	 * object.
	 * 
	 * @param notes
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * getter for returning the essential paramater from the Lecture object
	 * 
	 * @return
	 */
	public Boolean getEssential() {
		return Essential;
	}

	/**
	 * Below is the setter for setting the essential parameter for the Lecture
	 * object.
	 * 
	 * @param essential
	 */
	public void setEssential(Boolean essential) {
		Essential = essential;
	}

	/**
	 * Below is the getter for retrieving the week parameter from a Lecture
	 * object
	 * 
	 * @return
	 */
	public int getWeek() {
		return Week;
	}

	/**
	 * Below is the setter for setting the week parameter for the Lecture
	 * object. If the week is not between 1-24 an exception will be thrown
	 * 
	 * @param week
	 */
	public void setWeek(int week) {
		if (week >= 1 && week <= 24) {
			Week = week;
		} else {
			throw new IllegalArgumentException("Invalid Week entered");
		}
	}

	/**
	 * The below getter retrieves the day parameter from the Lecture object
	 * 
	 * @return
	 */
	public String getDay() {
		return Day;
	}

	/**
	 * The below setter sets the day paramater for a Lecture object. If a day
	 * between Monday-Friday is not entered, an exception is thrown
	 * 
	 * @param day
	 */
	public void setDay(String day) {
		if (day.equalsIgnoreCase("Monday") || day.equalsIgnoreCase("Tuesday") || day.equalsIgnoreCase("Wednesday")
				|| day.equalsIgnoreCase("Thursday") || day.equalsIgnoreCase("Friday")) {
			Day = day;
		} else {
			throw new IllegalArgumentException("Invalid Day Entered");
		}
	}

	/**
	 * The below is the getter for retrieving the Start Date for a Lecture
	 * Object
	 * 
	 * @return
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * The below is the setter for setting the Start Date parameter for a
	 * Lecture object
	 * 
	 * @param startDate
	 */
	public void setStartDate(String startDate) {
		if (!startDate.isEmpty()) {
			this.startDate = startDate;
		} else {
			throw new NullPointerException("No Start Date Entered");
		}
	}

	/**
	 * The below is the toString() method for displaying all Lecture data. It is
	 * used in the Amend Delete Absence Menu
	 */
	@Override
	public String toString() {
		return "Lecture [Week=" + Week + ", Day=" + Day + ", startDate=" + startDate + ", StartTime=" + StartTime
				+ ", EndTime=" + EndTime + ", group=" + group + ", location=" + location + ", subject=" + subject
				+ ", theme=" + theme + ", teachingFormat=" + teachingFormat + ", description=" + description
				+ ", staff=" + staff + ", style=" + style + ", module=" + module + "]";
	}

	/**
	 * The below getter retrieves the Start Time parameter from the lecture
	 * object
	 * 
	 * @return
	 */
	public String getStartTime() {
		return StartTime;
	}

	/**
	 * The below setter sets the Start Time parameter for the Lecture Object. If
	 * the Start Time is left unfilled an exception is thrown
	 * 
	 * @param startTime
	 */
	public void setStartTime(String startTime) {
		if (!startTime.isEmpty()) {
			StartTime = startTime;
		} else {
			throw new NullPointerException("No Start Time Entered");
		}
	}

	/**
	 * The below getter retrieves the End Time parameter from the Lecture object
	 * 
	 * @return
	 */
	public String getEndTime() {
		return EndTime;
	}

	/**
	 * The below setter sets the End Time parameter for the Lecture object
	 * 
	 * @param endTime.
	 *            If the parameter is left empty an exception is thrown
	 */
	public void setEndTime(String endTime) {
		if (!endTime.isEmpty()) {
			EndTime = endTime;
		} else {
			throw new NullPointerException("No End Time Entered");
		}
	}

	/**
	 * The below getter retrieves the group parameter from the Lecture object
	 * 
	 * @return
	 */
	public String getGroup() {
		return group;
	}

	/**
	 * The below Setter sets the group parameter for the Lecture object
	 * 
	 * @param group
	 */
	public void setGroup(String group) {
		this.group = group;
	}

	/**
	 * The below getter retrieves the location parameter from the Lecture object
	 * 
	 * @return
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * The below setter sets the location parameter for the Lecture object
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * The below getter retrieves the subject parameter from the Lecture object.
	 * 
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * The below setter sets the subject parameter for the Lecture object. If
	 * the field is left empty an exception is thrown
	 * 
	 * @param subject
	 */
	public void setSubject(String subject) {
		if (!subject.isEmpty()) {
			this.subject = subject;
		} else {
			throw new NullPointerException("No Subject Entered");
		}
	}

	/**
	 * The below getter retrieves the theme parameter from the Lecture object.
	 * 
	 * @return
	 */
	public String getTheme() {
		return theme;
	}

	/**
	 * The below setter sets the theme parameter for the Lecture object
	 * 
	 * @param theme
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * The below getter retrieves the teaching format from the Lecture object
	 * 
	 * @return
	 */
	public String getTeachingFormat() {
		return teachingFormat;
	}

	/**
	 * The below setter sets the teaching format for the Lecture object
	 * 
	 * @param teachingFormat
	 */
	public void setTeachingFormat(String teachingFormat) {
		this.teachingFormat = teachingFormat;
	}

	/**
	 * The below getter retrieves the description parameter from the Lecture
	 * object
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * The below setter sets the description parameter for the Lecture object
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * The below getter retrieves the staff parameter from the Lecture object
	 * 
	 * @return
	 */
	public String getStaff() {
		return staff;
	}

	/**
	 * The below setter sets the staff parameter for the Lecture object. If the
	 * field is left empty an exception is thrown
	 * 
	 * @param staff
	 */
	public void setStaff(String staff) {
		if (!staff.isEmpty()) {
			this.staff = staff;
		} else {
			throw new NullPointerException("No Staff Entered");
		}
	}

	/**
	 * The below getter retrieves the style parameter from the Lecture object
	 * 
	 * @return
	 */
	public String getStyle() {
		return style;
	}

	/**
	 * The below setter sets the style parameter from the Lecture object
	 * 
	 * @param style
	 */
	public void setStyle(String style) {
		this.style = style;
	}

	/**
	 * The below getter retrieves the module parameter from the Lecture object
	 * 
	 * @return
	 */
	public String getModule() {
		return module;
	}

	/**
	 * The below setter sets the module parameter for the Lecture object
	 * 
	 * @param module
	 */
	public void setModule(String module) {
		this.module = module;
	}

}
