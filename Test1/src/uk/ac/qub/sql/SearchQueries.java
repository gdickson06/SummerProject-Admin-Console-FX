package uk.ac.qub.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uk.ac.qub.churst.ConvertGroup;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.objects.Coordinator;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.objects.Room;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.Student;
import uk.ac.qub.objects.User;

public class SearchQueries {

	public static List<Absence> searchAbsence(int search, String info) {

		ResultSet r;
		String statement = null;
		List<Absence> absences = new ArrayList<Absence>();

		switch (search) {
		case 1:
			statement = "select * from absence where StudentNumber = " + info + ";";
			break;
		case 2:
			statement = "select * from absence where Date LIKE '" + info + "';";
			break;
		case 3:
			statement = "select * from absence where StartTime = '" + info + "';";
			break;
		case 4:
			statement = "select * from absence where Type = '" + info + "';";
			break;
		case 5:
			statement = "select * from absence where Approved = " + info + ";";
			break;
		case 6:
			statement = "select * from absence where EndTime = '" + info + "';";
			break;

		}

		r = SQL.SQLstatements(statement);
		System.out.println(statement);
		try {
			if (r.next()) {

				do {
					Absence a = new Absence(r.getInt("id"),r.getInt("StudentNumber"), r.getInt("LectureID"), r.getString("Date"),
							r.getString("StartTime"),r.getString("EndTime"), r.getString("Reason"), r.getBoolean("Approved"), r.getString("Type"));

					
					System.out.println("Value of ID is" + a.getId());
					absences.add(a);
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return absences;
	}

	public static List<Absence> ComboSearchAbsence(Absence A, Boolean boolEmpty) {

		ResultSet r;

		List<Absence> absences = new ArrayList<Absence>();

		String statement = "select * from absence ";
		Boolean start = true;
		if (boolEmpty == false) {
			statement = statement + " Where Approved = " + Boolean.toString(A.getApproved());
			start = false;
		}

		if (A.getStudentNumber() != 0) {
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}
			statement = statement + "StudentNumber =" + A.getStudentNumber();
			start = false;
		}

		if (A.getDate().isEmpty() == false) {
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}
			statement = statement + "Date Like'" + A.getDate() + "%'";
			start = false;
		}

		if (A.getStartTime().isEmpty() == false) {
			System.out.println(A.getStartTime().isEmpty());
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}

			statement = statement + "Time Like'" + A.getStartTime() + "%'";
			start = false;
		}

		if (A.getType() != null) {
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}

			statement = statement + "Type ='" + A.getType() + "'";
		}

		statement = statement + ";";

		System.out.println(statement);

		r = SQL.SQLstatements(statement);

		try {
			if (r.next()) {

				do {
					Absence a = new Absence(r.getInt("id"),r.getInt("StudentNumber"), r.getInt("LectureID"), r.getString("Date"),
							r.getString("StartTime"),r.getString("EndTime"), r.getString("Reason"), r.getBoolean("Approved"), r.getString("Type"));
					
					absences.add(a);
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return absences;
	}
	
	public static List<Lecture> ComboSearchLectures(Lecture lectures){
		
		//creating a ResultSet to hold our results of the ComboSearch
		ResultSet results;
		List<Lecture> lectureList = new ArrayList<Lecture>();
		String statement = "SELECT * FROM lectures ";
		Boolean start = true;
		if(lectures.getWeek() != 0){
			statement = statement+"WHERE Week = "+lectures.getWeek();
			start=false;
		}
		
		if(!lectures.getModule().isEmpty()){
			if(start==false){
				statement = statement+" AND ";
			} else {
				statement = statement+" WHERE ";
			}
			
			statement = statement + "Module = '"+lectures.getModule()+"'";
			start = false;
		}
		
		if(!lectures.getYear().isEmpty()){
			if(start==false){
				statement = statement+" AND ";
			} else {
				statement = statement+" WHERE ";
			}
				statement = statement +"Year = '"+lectures.getYear()+"'";
				start=false;
		}
		
		if(!lectures.getStaff().isEmpty()){
			if(start==false){
				statement = statement+" AND ";
			} else {
				statement = statement+" WHERE ";
			}
				statement = statement+"Staff = '"+lectures.getStaff()+"'";
				start=false;
		}		
		
		if(!lectures.getStartTime().isEmpty()){
			if(start==false){
				statement = statement+" AND ";
			} else {
				statement = statement+" WHERE ";
			}
				statement = statement+"StartTime = '"+lectures.getStartTime()+"'";
				start=false;
		}
		
		if(!lectures.getStartDate().isEmpty()){
			if(start==false){
				statement = statement+" AND ";
			} else {
				statement = statement+" WHERE ";
			}
				statement = statement+"StartDate = '"+ConvertGroup.DateConvertSQL(lectures.getStartDate())+"'";
		}
		
		statement = statement+";";
		
		System.out.println(statement);
		
		results = SQL.SQLstatements(statement);
			try {
				if(results.next()){
					do {
						Lecture l = new Lecture(results.getInt("Week"), results.getString("Day"), 
								results.getString("StartDate"), results.getString("StartTime"), 
								results.getString("EndTime"), results.getString("Groups"), 
								results.getString("Location"), results.getString("Subject"), 
								results.getString("Theme"), results.getString("Teaching"), 
								results.getString("Description"), results.getString("Staff"), 
								results.getString("Style"), results.getString("Module"));
						lectureList.add(l);
					} while (results.next());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		return lectureList;
	}
	/**
	 * ComboSearch Method to search with mutliple values inputted for the StudentAmmendDelete page (Search)
	 * @param student
	 * @return
	 */
	public static List<Student> ComboSearchStudents(List<String> s){
		
		//First Name, Last Name, Student Number, Cohort, YEar, Email
		
		ResultSet results;
		List<Student> studentList = new ArrayList<Student>();
		String statement = "SELECT * FROM students ";
		Boolean start = true;
		if(s.get(0).isEmpty()==false){
			statement = statement+"WHERE Name LIKE '"+s.get(0)+"%'";
			start=false;
			System.out.println(start);
		}
		
		
		if(s.get(1).isEmpty()==false){
			if(start){
				statement=statement+" WHERE ";
			} else {
				statement=statement+" AND ";
			}
			statement = statement+"Name LIKE '% "+s.get(1)+"%'";
			start=false;
			System.out.println(start);
		}
		
		
		if(s.get(2).isEmpty()==false){
			if(start){
				statement=statement+" WHERE ";
			} else {
				statement=statement+" AND ";
			}
			statement = statement+"StudentNumber = "+s.get(2);
			start = false;
		}
		
		if(s.get(3).isEmpty()==false){
			if(start){
				statement=statement+" WHERE ";
			} else {
				statement=statement+" AND ";
			}
			
			statement = statement+"Cohort = '"+s.get(3)+"'";
			start = false;
		}
		System.out.println(start);
		if(s.get(4).isEmpty()==false){
			System.out.println(start);
			if(start){
				statement = statement+" WHERE ";
			} else {
				statement = statement+" AND ";
			}
			
			statement = statement+"IntakeYear = "+s.get(4);
			start = false;
		}
		
		if(s.get(5).isEmpty()==false){
			if(start){
				statement=statement+" WHERE ";
			} else {
				statement = statement+" AND ";
			}
			
			statement = statement+"StudentEmail = '"+s.get(5)+"'";
		}
		
		statement = statement+";";
		
		System.out.println(statement);
		
		results = SQL.SQLstatements(statement);
		try {
			if(results.next()){
				do {
					Student student = new Student(results.getString("Name"), results.getInt("StudentNumber"), results.getString("Cohort"), results.getInt("IntakeYear"), results.getString("StudentEmail"));
					studentList.add(student);
				} while(results.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return studentList;
	}

	public static List<Student> searchStudent(int search, String info) {
		ResultSet r;
		String statement = null;
		List<Student> students = new ArrayList<Student>();

		switch (search) {
		// StudentNumber
		case 1:
			statement = "select * from students where StudentNumber = " + info + ";";
			break;
		// IntakeYear
		case 2:
			statement = "select * from students where IntakeYear = " + info + ";";
			break;
		// Group
		case 3:
			statement = "select * from students where Cohort = '" + info + "';";
			break;
		// First Name
		case 4:
			statement = "select * from students where Name LIKE '" + info + "%';";
			break;
		// Last Name
		case 5:
			statement = "select * from students where Name LIKE '% " + info + "%';";
			break;
		// Email Address
		case 6:
			statement = "select * from students where StudentEmail LIKE '" + info + "%';";
			break;
		default:
			System.out.println("Error in searching students");
		}

		r = SQL.SQLstatements(statement);
		System.out.println(statement);
		try {
			if (r.next()) {

				do {
					Student s = new Student(r.getInt("StudentNumber"), r.getString("Name"), r.getString("Cohort"),
							r.getString("StudentEmail"), r.getInt("IntakeYear"));
					students.add(s);
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}

	public static List<Lecture> searchLecture(int search, String info) {
		ResultSet r;
		String statement = null;
		List<Lecture> lectures = new ArrayList<Lecture>();

		switch (search) {
		// id
		case 1:
			statement = "select * from lectures where id = " + info + ";";
			break;
		// week
		case 2:
			statement = "select * from lectures where Week = " + info + ";";
			break;
		// date
		case 3:
			statement = "select * from lectures where StartDate = '" + info + "';";
			break;
		// groups
		case 4:
			statement = "select * from lectures where StartTime = '" + info + "';";
			break;
		// staff
		case 5:
			statement = "select * from lectures where Staff LIKE '%" + info + "%';";
			break;
		// Module
		case 6:
			statement = "select * from lectures where Module LIKE '" + info + "%';";
			break;
		// Subject
		case 7:
			statement = "select * from lectures where Year = " + info + "%;";
			break;
		default:
			System.out.println("Error in searching students");
		}

		r = SQL.SQLstatements(statement);
		System.out.println(statement);
		try {
			if (r.next()) {

				do {
					Lecture l = new Lecture(r.getInt("id"), r.getInt("Week"), r.getString("Day"),
							r.getString("StartDate"), r.getString("StartTime"), r.getString("EndTime"),
							r.getString("Groups"), r.getString("Location"), r.getString("Subject"),
							r.getString("Theme"), r.getString("Teaching"), r.getString("Description"),
							r.getString("Staff"), r.getString("Style"), r.getString("Module"));
					lectures.add(l);
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lectures;
	}

	public static List<Staff> searchStaff(int search, String info, Boolean x) {
		ResultSet r, r1;
		String statement = null;
		String statement2 = null;
		List<Staff> staff = new ArrayList<Staff>();

		switch (search) {
		// first name
		case 1:
			statement = "select * from course_coordinator where Name like '" + info + "%';";
			statement2 = "select * from staff where Name like '" + info + "%';";
			break;
		// Last NAme
		case 2:
			statement = "select * from course_coordinator where Name like '% " + info + "%';";
			statement2 = "select * from staff where Name like '% " + info + "%';";
			break;
		// module
		case 3:
			statement = "select * from course_coordinator where Username = " + info + ";";
			statement2 = "select * from staff where StaffNumber = " + info + ";";
			break;
		// type
		case 4:
			statement = "select * from course_coordinator;";
			statement2 = "select * from staff where type ='" + info + "'";
			break;
		default:
			System.out.println("Error in searching lecturers");
		}

		r = SQL.SQLstatements(statement);
		r1 = SQL.SQLstatements(statement2);
		System.out.println(statement);
		System.out.println(statement2);
		if (x) {
			try {
				if (r1.next()) {

					do {
						User u = new User(r1.getString("Name"), r1.getString("StaffNumber"), r1.getString("Password"),
								r1.getString("Type"));
						staff.add(u);
					} while (r1.next());

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				if (r.next()) {
					do {
						Coordinator c = new Coordinator(r.getString("Name"), r.getString("Username"),
								r.getString("Password"), r.getString("Module"), r.getString("Email"));
						staff.add(c);
					} while (r.next());
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			if (info.equals("Module Coordinator")) {
				try {
					if (r.next()) {
						try {
							do {
								Coordinator c = new Coordinator(r.getString("Name"), r.getString("Username"),
										r.getString("Password"), r.getString("Module"), r.getString("Email"));
								staff.add(c);
							} while (r.next());
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				try {
					if (r1.next()) {

						do {
							User u = new User(r1.getString("Name"), r1.getString("StaffNumber"),
									r1.getString("Password"), r1.getString("Type"));
							staff.add(u);
						} while (r1.next());

					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return staff;
	}

	public static List<Room> searchRoom(int search, String info) {
		ResultSet r;
		String statement = null;
		List<Room> rooms = new ArrayList<Room>();

		switch (search) {
		// First name
		case 1:
			statement = "select * from location where roomCode LIKE '%" + info + "%';";
			break;
		// Last Name
		case 2:
			statement = "select * from location where roomName LIKE '%" + info + "%';";
			break;

		default:
			System.out.println("Error in searching rooms");
		}

		r = SQL.SQLstatements(statement);
		try {
			if (r.next()) {

				do {
					Room room = new Room(r.getString("roomCode"), r.getString("roomName"));
					rooms.add(room);
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rooms;
	}
	
	public static List<Placement> searchPlacement (int search, String info){
		ResultSet r;
		String statement = null;
		List<Placement> placement = new ArrayList<Placement>();

		switch (search) {
		// First name
		case 1:
			statement = "select * from placement where StartDate = '" + info + "';";
			break;
		// Last Name
		case 2:
			statement = "select * from placement where ClinicalTeacher Like '%" + info + "%';";
			break;
			// Last Name
		case 3:
			statement = "select * from placement where YearGroup = " + info + ";";
			break;
			// Last Name
		case 4:
			statement = "select * from placement where Subject Like '%" + info + "%';";
			break;
			// Last Name
		case 5:
			statement = "select * from placement where Location Like '%" + info + "%';";
			break;
			// Last Name
		case 6:
			statement = "select * from placement where Cohort = '" + info + "';";
			break;

		default:
			System.out.println("Error in searching rooms");
		}

		r = SQL.SQLstatements(statement);
		try {
			if (r.next()) {

				do {
					Placement p= new Placement(r.getInt("id"),r.getInt("Week"),r.getInt("YearGroup"),r.getString("StartDate"),r.getString("EndDate"),r.getString("Subject"),r.getString("Location"),r.getString("ClinicalTeacher"),r.getString("Cohort"),r.getString("Note"));
					placement.add(p);
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return placement;
		
	}

}
