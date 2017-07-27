package uk.ac.qub.objects;

public class Absence {
	

	

	int id,StudentNumber , LectureID ;
	String StartDate,EndDate,StartTime, EndTime, Reason ,type;
	Boolean approved;
	
	
	public Absence(int id, int studentNumber, int lectureID, String startDate, String endDate, String startTime,
			String endTime, String reason, String type, Boolean approved) {
		super();
		this.id = id;
		StudentNumber = studentNumber;
		LectureID = lectureID;
		StartDate = startDate;
		EndDate = endDate;
		StartTime = startTime;
		EndTime = endTime;
		Reason = reason;
		this.type = type;
		this.approved = approved;
	}


	public Absence(int studentNumber, String startDate, String startTime, String endTime, String type,Boolean approved) {
		super();
		StudentNumber = studentNumber;
		StartDate = startDate;
		StartTime = startTime;
		EndTime = endTime;
		this.type = type;
		this.approved=approved;
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
		return "Absence [id=" + id + ", StudentNumber=" + StudentNumber + ", LectureID=" + LectureID + ", StartDate="
				+ StartDate + ", EndDate=" + EndDate + ", StartTime=" + StartTime + ", EndTime=" + EndTime + ", Reason="
				+ Reason + ", type=" + type + ", approved=" + approved + "]";
	}
	
	
	
	
	

	

}
