package uk.ac.qub.objects;

public class Note {
	
	int id,Year;
	String Date,Details;
	public Note(int id, int year, String date, String details) {
		
		this.id = id;
		Year = year;
		Date = date;
		Details = details;
	}
	public Note() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Note [id=" + id + ", Year=" + Year + ", Date=" + Date + ", Details=" + Details + "]";
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
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	

	

}
