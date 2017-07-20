package uk.ac.qub.objects;

public class Absence {
	

	@Override
	public String toString() {
		return "Absence [id=" + id + ", StudentNumber=" + StudentNumber + ", LectureID=" + LectureID + ", Date=" + Date
				+ ", Time=" + Time + ", Reason=" + Reason + ", type=" + type + ", approved=" + approved + "]";
	}

	int id,StudentNumber , LectureID ;
	String Date,Time, Reason ,type;
	Boolean approved;
	
	public Absence(int studentNumber, int lectureID, String date, String time, String reason,Boolean approved, String type
			) {
		
		StudentNumber = studentNumber;
		LectureID = lectureID;
		Date = date;
		Time = time;
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

	public String getTime() {
		return Time;
	}

	public void setTime(String time) {
		Time = time;
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

	

}
