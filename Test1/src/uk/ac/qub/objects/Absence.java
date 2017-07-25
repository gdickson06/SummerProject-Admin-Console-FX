package uk.ac.qub.objects;

public class Absence {
	

	

	int id,StudentNumber , LectureID ;
	String Date,StartTime, EndTime, Reason ,type;
	Boolean approved;
	
	
	
	
	public Absence(int id, int studentNumber, String date, String startTime, String endTime, String reason, String type,
			Boolean approved) {
		super();
		this.id = id;
		StudentNumber = studentNumber;
		Date = date;
		StartTime = startTime;
		EndTime = endTime;
		Reason = reason;
		this.type = type;
		this.approved = approved;
	}
	public Absence(int id, int studentNumber, int lectureID, String date, String startTime, String endTime,
			String reason, Boolean approved,  String type) {
	
		this.id = id;
		StudentNumber = studentNumber;
		LectureID = lectureID;
		Date = date;
		StartTime = startTime;
		EndTime = endTime;
		Reason = reason;
		this.type = type;
		this.approved = approved;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getStudentNumber() {
		return StudentNumber;
	}
	public void setStudentNumber(int studentNumber) {
		StudentNumber = studentNumber;
	}
	public int getLectureID() {
		return LectureID;
	}
	public void setLectureID(int lectureID) {
		LectureID = lectureID;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
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
	public String getReason() {
		return Reason;
	}
	public void setReason(String reason) {
		Reason = reason;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getApproved() {
		return approved;
	}
	public void setApproved(Boolean approved) {
		this.approved = approved;
	}
	@Override
	public String toString() {
		return "Absence [id=" + id + ", StudentNumber=" + StudentNumber + ", LectureID=" + LectureID + ", Date=" + Date
				+ ", StartTime=" + StartTime + ", EndTime=" + EndTime + ", Reason=" + Reason + ", type=" + type
				+ ", approved=" + approved + "]";
	}
	
	

	

}
