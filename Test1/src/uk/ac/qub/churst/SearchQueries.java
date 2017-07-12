package uk.ac.qub.churst;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchQueries {

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
			statement = "select * from students where Group1 = '" + info + "';";
			break;
		// First Name
		case 4:
			statement = "select * from students where Name LIKE '" + info + "%';";
			break;
		// Last Name
		case 5:
			statement = "select * from students where Name LIKE '% " + info + "%';";
			break;
		//Email Address
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
					Student s = new Student(r.getInt("StudentNumber"), r.getString("Name"), r.getString("Group1"),
							r.getString("StudentEmail"),r.getInt("IntakeYear"));
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
			statement = "select * from lectures where Groups LIKE '%" + info + "%';";
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
			statement = "select * from lectures where Subject LIKE '" + info + "%';";
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

	public static List<Lecturer> searchLecturer(int search, String info) {
		ResultSet r;
		String statement = null;
		List<Lecturer> lecturers = new ArrayList<Lecturer>();

		switch (search) {
		// first name
		case 1:
			statement = "select * from lecturers where Name = '" + info + "%';";
			break;
		case 2:
			statement = "select * from lecturers where Name = '% " + info + "%';";
			break;
		// module
		case 3:
			statement = "select * from lecturers where Module = '" + info + "';";
			break;

		default:
			System.out.println("Error in searching lecturers");
		}

		r = SQL.SQLstatements(statement);
		System.out.println(statement);
		try {
			if (r.next()) {

				do {
					Lecturer l = new Lecturer(r.getString("Name"), r.getString("Email"), r.getString("Module"));
					lecturers.add(l);
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecturers;
	}

	public static List<Room> searchRoom(int search, String info) {
		ResultSet r;
		String statement = null;
		List<Room> rooms = new ArrayList<Room>();

		switch (search) {
		// First name
		case 1:
			statement = "select * from location where Name = '" + info + "%';";
			break;
		// Last Name
		case 2:
			statement = "select * from location where Name = '% " + info + "%';";
			break;
		// module
		case 3:
			statement = "select * from location where Module = '%" + info + "%';";
			break;

		default:
			System.out.println("Error in searching rooms");
		}

		r = SQL.SQLstatements(statement);
		try {
			if (r.next()) {

				do {
					Room room = new Room(r.getString("Code"), r.getString("Name"));
					rooms.add(room);
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rooms;
	}

	public static List<Lecturer> searchAbsence(int search, String info) {
		ResultSet r;
		String statement = null;
		List<Lecturer> lecturers = new ArrayList<Lecturer>();

		switch (search) {
		// First name
		case 1:
			statement = "select * from absence join students using (StudentNumber) where Name = '" + info + "%';";
			break;
		// Last name
		case 2:
			statement = "select * from absence join students using (StudentNumber) where Name = '% " + info + "%';";
			break;
		// Student Number
		case 3:
			statement = "select * from absence where StudentNumber = " + info + ";";
			break;
		// Date 
		case 4:
			statement = "select * from absence where Date = " + info + ";";
			break;
		//type
		case 5:
			statement = "select * from absence where type = " + info + ";";
			break;
		default:
			System.out.println("Error in searching absences");
		}

		r = SQL.SQLstatements(statement);
		System.out.println(statement);
		try {
			if (r.next()) {

				do {
					Lecturer l = new Lecturer(r.getString("Name"), r.getString("Email"), r.getString("Module"));
					lecturers.add(l);
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lecturers;
	}
	
	

}
