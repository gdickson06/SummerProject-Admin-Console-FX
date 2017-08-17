package uk.ac.qub.objects;

public class Placement {
	
	int id,Year;
	String StartDate,EndDate,Location,Cohort,Note,Module,ModuleNumber,Preference;
	public Placement(int id, int year, String startDate, String endDate, String location, String preference, String cohort,
			String note, String module, String moduleNumber) {
		super();
		this.id = id;
		Year = year;
		StartDate = startDate;
		EndDate = endDate;
		Location = location;
		Preference = preference;
		Cohort = cohort;
		Note = note;
		Module = module;
		ModuleNumber = moduleNumber;
	}
	
	
	public Placement(int year, String startDate, String endDate, String location, String cohort, String note,
			String module, String moduleNumber, String preference) {
		super();
		Year = year;
		StartDate = startDate;
		EndDate = endDate;
		Location = location;
		Cohort = cohort;
		Note = note;
		Module = module;
		ModuleNumber = moduleNumber;
		Preference = preference;
	}


	public Placement() {
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public String getPreference() {
		return Preference;
	}
	public void setPreference(String preference) {
		Preference = preference;
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
	public String getModule() {
		return Module;
	}
	public void setModule(String module) {
		Module = module;
	}
	public String getModuleNumber() {
		return ModuleNumber;
	}
	public void setModuleNumber(String moduleNumber) {
		ModuleNumber = moduleNumber;
	}

	
	
}
