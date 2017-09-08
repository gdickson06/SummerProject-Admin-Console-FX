package uk.ac.qub.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uk.ac.qub.methods.ConvertMethods;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.objects.Room;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.Student;

/**
 * Name of Package - uk.ac.qub.sql
 * Date Last Amended - 08/09/17 
 * Outline - This class will contain all of the methods to search through all types of
 * object stored in the database
 * Demographics – 785 LOC 12 Methods
 */

public class SearchQueries {
	public static List<String> allStudentNumbers() throws SQLException {
		ResultSet results;
		List<String> studentNumbers = new ArrayList<String>();
		String statement = "SELECT * FROM Students ";
		results = SQL.SQLstatements(statement);

		if (results.next()) {

			do {

				studentNumbers.add(results.getString("student_number"));
			} while (results.next());

		}

		return studentNumbers;
	}

	/**
	 * This method will return all unread absences which will be displayed on
	 * the absence page
	 * 
	 * @return
	 * @throws SQLException
	 */
	public static List<Absence> unreadAbsence() throws SQLException {
		ResultSet r;
		String statement = "select * from Absences where viewed = false";
		List<Absence> absences = new ArrayList<Absence>();
		r = SQL.SQLstatements(statement);

		if (r.next()) {

			do {
				Absence a = new Absence(r.getInt("absences_id"), r.getInt("student_number"), r.getInt("lecture_id"),
						r.getString("start_date"), r.getString("end_date"), r.getString("start_time"),
						r.getString("end_time"), r.getString("reason"), r.getString("type"), r.getBoolean("approved"),
						r.getBoolean("viewed"));

				absences.add(a);
			} while (r.next());

		}

		return absences;
	}

	/**
	 * This method would search Absences given a certain search criteria and
	 * information
	 * 
	 * @param search
	 * @param info
	 * @return
	 * @throws SQLException
	 */
	public static List<Absence> searchAbsence(int search, String info) throws SQLException {

		ResultSet r;
		String statement = null;
		List<Absence> absences = new ArrayList<Absence>();

		switch (search) {
		case 1:
			statement = "select * from Absences where student_number = " + info + ";";
			break;
		case 2:
			statement = "select * from Absences where start_date = '" + info + "';";
			break;
		case 3:
			statement = "select * from Absences where start_time = '" + info + "';";
			break;
		case 4:
			statement = "select * from Absences where type = '" + info + "';";
			break;
		case 5:
			statement = "select * from Absences where approved = " + info + ";";
			break;
		case 6:
			statement = "select * from Absences where end_time = '" + info + "';";
			break;

		}

		r = SQL.SQLstatements(statement);
		System.out.println(statement);

		if (r.next()) {

			do {
				Absence a = new Absence(r.getInt("absences_id"), r.getInt("student_number"), r.getInt("lecture_id"),
						r.getString("start_date"), r.getString("end_date"), r.getString("start_time"),
						r.getString("end_time"), r.getString("reason"), r.getString("type"), r.getBoolean("approved"),
						r.getBoolean("viewed"));

				absences.add(a);
			} while (r.next());

		}

		return absences;
	}

	/**
	 * This method allows multiple fields to be searched for an Absences
	 * 
	 * @param A
	 * @param boolEmpty
	 * @return
	 * @throws SQLException
	 */
	public static List<Absence> ComboSearchAbsence(Absence A) throws SQLException {

		ResultSet r;

		List<Absence> absences = new ArrayList<Absence>();

		String statement = "select * from Absences ";
		Boolean start = true;
		if (A.getApproved() != null) {
			statement = statement + " Where approved = " + Boolean.toString(A.getApproved());
			start = false;
		}

		if (A.getStudentNumber() != 0) {
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}
			statement = statement + "student_number =" + A.getStudentNumber();
			start = false;
		}

		if (A.getStartDate() != null) {
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}
			statement = statement + "start_date Like'" + A.getStartDate() + "%'";
			start = false;
		}

		if (A.getStartTime() != null) {
			System.out.println(A.getStartTime().isEmpty());
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}

			statement = statement + "start_time Like'" + A.getStartTime() + "%'";
			start = false;
		}

		if (A.getType() != null) {
			if (start == false) {
				statement = statement + " and ";
			} else {
				statement = statement + " where ";
			}

			statement = statement + "type ='" + A.getType() + "'";
		}

		statement = statement + ";";

		r = SQL.SQLstatements(statement);

		if (r.next()) {

			do {
				Absence a = new Absence(r.getInt("absences_id"), r.getInt("student_number"), r.getInt("lecture_id"),
						r.getString("start_date"), r.getString("end_date"), r.getString("start_time"),
						r.getString("end_time"), r.getString("reason"), r.getString("type"), r.getBoolean("approved"),
						r.getBoolean("viewed"));

				absences.add(a);
			} while (r.next());

		}

		return absences;
	}

	/**
	 * This method will allow Lectures to be searched through multiple fields
	 * 
	 * @param lectures
	 * @return
	 * @throws SQLException
	 */

	public static List<Lecture> ComboSearchLectures(Lecture lectures) throws SQLException {

		ResultSet results;
		List<Lecture> lectureList = new ArrayList<Lecture>();
		String statement = "SELECT * FROM Lectures ";
		Boolean start = true;
		if (lectures.getWeek() != 0) {
			statement = statement + "WHERE week = " + lectures.getWeek();
			start = false;
		}

		if (lectures.getModule() != null) {
			if (start == false) {
				statement = statement + " AND ";
			} else {
				statement = statement + " WHERE ";
			}

			statement = statement + "module LIKE '%" + lectures.getModule() + "%'";
			start = false;
		}

		if (lectures.getYear() != null) {
			if (start == false) {
				statement = statement + " AND ";
			} else {
				statement = statement + " WHERE ";
			}
			statement = statement + "year = '" + lectures.getYear() + "'";
			start = false;
		}

		if (!lectures.getStaff().isEmpty()) {
			if (start == false) {
				statement = statement + " AND ";
			} else {
				statement = statement + " WHERE ";
			}
			statement = statement + "staff LIKE '%" + lectures.getStaff() + "%'";
			start = false;
		}

		if (!lectures.getStartTime().isEmpty()) {
			if (start == false) {
				statement = statement + " AND ";
			} else {
				statement = statement + " WHERE ";
			}
			statement = statement + "start_time = '" + lectures.getStartTime() + "'";
			start = false;
		}

		if (lectures.getStartDate() != null) {
			if (start == false) {
				statement = statement + " AND ";
			} else {
				statement = statement + " WHERE ";
			}
			statement = statement + "date = '" + lectures.getStartDate() + "'";
		}

		statement = statement + ";";

		System.out.println(statement);

		results = SQL.SQLstatements(statement);

		if (results.next()) {
			do {
				Lecture l = new Lecture(results.getInt("week"), results.getInt("lecture_id"), results.getString("day"),
						results.getString("date"), results.getString("start_time"), results.getString("end_time"),
						results.getString("groups"), results.getString("location"), results.getString("subject"),
						results.getString("theme"), results.getString("teaching"), results.getString("description"),
						results.getString("staff"), results.getString("style"), results.getString("module"),
						results.getBoolean("optional"), results.getString("year"), results.getString("notes"));

				lectureList.add(l);
			} while (results.next());
		}

		return lectureList;
	}

	/**
	 * ComboSearch Method to search with mutliple values inputed for a student
	 * 
	 * @param student
	 * @return
	 * @throws SQLException
	 */
	public static List<Student> ComboSearchStudents(Student s) throws SQLException {

		ResultSet results;
		List<Student> studentList = new ArrayList<Student>();
		String statement = "SELECT * FROM Students ";
		Boolean start = true;
		if (s.getFirstName().isEmpty() == false) {
			statement = statement + "WHERE first_name LIKE '" + s.getFirstName() + "%'";
			start = false;

		}

		if (s.getLastName().isEmpty() == false) {
			if (start) {
				statement = statement + " WHERE ";
			} else {
				statement = statement + " AND ";
			}
			statement = statement + "last_name LIKE '" + s.getLastName() + "%'";
			start = false;

		}

		if (s.getStudentNumber() != 0) {
			if (start) {
				statement = statement + " WHERE ";
			} else {
				statement = statement + " AND ";
			}
			statement = statement + "student_number = " + s.getStudentNumber();
			start = false;
		}

		if (s.getCohort().isEmpty() == false) {
			if (start) {
				statement = statement + " WHERE ";
			} else {
				statement = statement + " AND ";
			}

			statement = statement + "cohort = '" + s.getCohort() + "'";
			start = false;
		}

		if (s.getYear() != null) {

			if (start) {
				statement = statement + " WHERE ";
			} else {
				statement = statement + " AND ";
			}

			statement = statement + "year_group = '" + s.getYear() + "'";
			start = false;
		}

		if (s.getEmail().isEmpty() == false) {
			if (start) {
				statement = statement + " WHERE ";
			} else {
				statement = statement + " AND ";
			}

			statement = statement + "email = '" + s.getEmail() + "'";
		}

		statement = statement + ";";

		System.out.println(statement);

		results = SQL.SQLstatements(statement);

		if (results.next()) {
			do {
				Student student = new Student(results.getInt("student_number"), results.getString("last_name"),
						results.getString("first_name"), results.getString("middle_name"), results.getString("prefix"),
						results.getString("name"), results.getString("cohort"), results.getString("email"),
						results.getString("nationality"), results.getString("graduate"), results.getString("comments"),
						results.getString("portfolio"), results.getString("year_group"));
				studentList.add(student);
			} while (results.next());
		}

		return studentList;
	}

	/**
	 * This method will search the database of Students on a specific attribute
	 * 
	 * @param search
	 * @param info
	 * @return
	 * @throws SQLException
	 */

	public static List<Student> searchStudent(int search, String info) throws SQLException {
		ResultSet results;
		String statement = null;
		List<Student> students = new ArrayList<Student>();

		switch (search) {
		case 1:
			statement = "select * from Students where student_number = " + info + ";";
			break;

		case 2:
			statement = "select * from Students where year_group = " + info + ";";
			break;

		case 3:
			statement = "select * from Students where cohort = '" + info + "';";
			break;
		// First Name
		case 4:
			statement = "select * from Students where first_name LIKE '" + info + "%';";
			break;
		// Last Name
		case 5:
			statement = "select * from Students where last_name LIKE '" + info + "%';";
			break;
		// Email Address
		case 6:
			statement = "select * from Students where email LIKE '" + info + "%';";
			break;
		default:
			System.out.println("Error in searching students");
		}

		results = SQL.SQLstatements(statement);

		if (results.next()) {

			do {
				Student s = new Student(results.getInt("student_number"), results.getString("last_name"),
						results.getString("first_name"), results.getString("middle_name"), results.getString("prefix"),
						results.getString("name"), results.getString("cohort"), results.getString("email"),
						results.getString("nationality"), results.getString("graduate"), results.getString("comments"),
						results.getString("portfolio"), results.getString("year_group"));
				;
				students.add(s);
			} while (results.next());

		}
		return students;
	}

	public static List<Lecture> searchLecture(int search, String info) throws SQLException {
		ResultSet results;
		String statement = null;
		List<Lecture> lectures = new ArrayList<Lecture>();

		switch (search) {
		case 1:
			statement = "select * from Lectures where lecture_id = " + info + ";";
			break;
			//week
		case 2:
			statement = "select * from Lectures where week = " + info + ";";
			break;
		// date
		case 3:
			statement = "select * from Lectures where date = '" + info + "';";
			break;
		// groups
		case 4:
			statement = "select * from Lectures where start_time = '" + info + "';";
			break;
		// staff
		case 5:
			statement = "select * from Lectures where staff LIKE '%" + info + "%';";
			break;
		//module
		case 6:
			statement = "select * from Lectures where module LIKE '" + info + "%';";
			break;
		//year
		case 7:
			statement = "select * from Lectures where year = '" + info + "';";
			break;
		default:
			System.out.println("Error in searching students");
		}

		results = SQL.SQLstatements(statement);
		System.out.println(statement);
		try {
			if (results.next()) {

				do {
					Lecture l = new Lecture(results.getInt("week"), results.getInt("lecture_id"),
							results.getString("day"), results.getString("date"), results.getString("start_time"),
							results.getString("end_time"), results.getString("groups"), results.getString("location"),
							results.getString("subject"), results.getString("theme"), results.getString("teaching"),
							results.getString("description"), results.getString("staff"), results.getString("style"),
							results.getString("module"), results.getBoolean("optional"), results.getString("year"),
							results.getString("notes"));

					lectures.add(l);
				} while (results.next());

			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lectures;
	}

	/**
	 * This method will search staff on a certain query
	 * 
	 * @param search
	 * @param info
	 * @return
	 * @throws SQLException
	 */
	public static List<Staff> searchStaff(int search, String info) throws SQLException {
		ResultSet r;
		String statement = null;

		List<Staff> staff = new ArrayList<Staff>();

		switch (search) {
		// first name
		case 1:
			statement = "select * from Staff where name like '" + info + "%';";
			break;
		// Last NAme
		case 2:
			statement = "select * from Staff where name like '% " + info + "%';";
			break;
		// staff_number
		case 3:
			statement = "select * from Staff where staff_number = " + info + ";";
			break;
		// type
		case 4:
			statement = "select * from Staff where access_level = '" + info + "';";
			break;
		default:
			System.out.println("Error in searching lecturers");
		}

		r = SQL.SQLstatements(statement);

		if (r.next()) {

			do {
				Staff u = new Staff(r.getString("staff_number"), r.getString("name"), r.getString("access_level"));
				staff.add(u);
			} while (r.next());

		}

		return staff;
	}

	/**
	 * This method will search rooms through either code or name, there is no
	 * combo search as each field in this is unique
	 * 
	 * @param search
	 * @param info
	 * @return
	 * @throws SQLException
	 */

	public static List<Room> searchRoom(int search, String info) throws SQLException {

		ResultSet r;
		String statement = null;
		List<Room> rooms = new ArrayList<Room>();

		switch (search) {

		case 1:
			statement = "select * from LectureLocation where room_code LIKE '%" + info + "%';";
			break;

		case 2:
			statement = "select * from LectureLocation where room_location LIKE '%" + info + "%';";
			break;

		default:
			System.out.println("Error in searching rooms");
		}
		System.out.println(statement);
		r = SQL.SQLstatements(statement);

		if (r.next()) {

			do {
				Room room = new Room(r.getString("room_code"), r.getString("room_location"));
				rooms.add(room);
			} while (r.next());

		}

		return rooms;
	}

	/**
	 * This method will search the database for a Placement
	 * 
	 * @param search
	 * @param info
	 * @return
	 * @throws SQLException
	 */
	public static List<Placement> searchPlacement(int search, String info) throws SQLException {
		ResultSet r;
		String statement = null;
		List<Placement> placement = new ArrayList<Placement>();

		switch (search) {

		case 1:
			statement = "select * from Placements where start_date = '" + info + "';";
			break;

		case 2:
			statement = "select * from Placements where year = " + info + ";";
			break;

		case 3:
			statement = "select * from Placements where end_date = '" + info + "';";
			break;

		case 4:
			statement = "select * from Placements where module Like '%" + info + "%';";
			break;

		case 5:
			statement = "select * from Placements where hospital Like '%" + info + "%';";
			break;

		case 6:
			statement = "select * from Placements where cohort = '" + info + "';";
			break;

		default:
			System.out.println("Error in searching placements");
		}

		r = SQL.SQLstatements(statement);
		System.out.println(statement);
		if (r.next()) {

			do {
				Placement p = new Placement(r.getInt("id"), r.getInt("year"), r.getString("start_date"),
						r.getString("end_date"), r.getString("hospital"), r.getString("preference"),
						r.getString("cohort"), r.getString("comments"), r.getString("module"),
						r.getString("module_number"));
				placement.add(p);
			} while (r.next());

		}

		return placement;

	}

	/**
	 * This method will return a list of Students in a lecture
	 * 
	 * @param cohorts
	 * @param Year
	 * @return
	 * @throws SQLException
	 */
	public static List<Student> studentsInLecture(Lecture l) throws SQLException {
		List<Student> students = new ArrayList<Student>();

		List<String> groups = ConvertMethods.convert(l.getGroup());

		for (String group : groups) {
			String statement2 = "Select * from Students where  cohort='" + group + "' AND year_group =" + l.getYear();

			ResultSet results = SQL.SQLstatements(statement2);
			while (results.next()) {
				students.add(new Student(results.getInt("student_number"), results.getString("last_name"),
						results.getString("first_name"), results.getString("middle_name"), results.getString("prefix"),
						results.getString("name"), results.getString("cohort"), results.getString("email"),
						results.getString("nationality"), results.getString("graduate"), results.getString("comments"),
						results.getString("portfolio"), results.getString("year_group")));

			}
		}
		return students;
	}

	/**
	 * This method will search placements on multiple areas
	 * 
	 * @param p
	 * @return
	 * @throws SQLException
	 */
	public static List<Placement> ComboSearchPlacement(Placement p) throws SQLException {

		ResultSet r;
		List<Placement> placements = new ArrayList<Placement>();
		String statement = "SELECT * FROM Placements ";
		Boolean start = true;
		if (p.getEndDate() != null) {
			statement = statement + "WHERE end_date = '" + p.getEndDate() + "'";
			start = false;
		}

		if (p.getStartDate() != null) {
			if (start == false) {
				statement = statement + " AND ";
			} else {
				statement = statement + " WHERE ";
			}

			statement = statement + "start_date = '" + p.getStartDate() + "'";
			start = false;
		}

		if (!p.getLocation().isEmpty()) {
			if (start == false) {
				statement = statement + " AND ";
			} else {
				statement = statement + " WHERE ";
			}
			statement = statement + "hospital = '" + p.getLocation() + "'";
			start = false;
		}

		if (!p.getCohort().isEmpty()) {
			if (start == false) {
				statement = statement + " AND ";
			} else {
				statement = statement + " WHERE ";
			}
			statement = statement + "cohort = '" + p.getCohort() + "'";
			start = false;
		}

		if (!p.getModule().isEmpty()) {
			if (start == false) {
				statement = statement + " AND ";
			} else {
				statement = statement + " WHERE ";
			}
			statement = statement + "module = '" + p.getModule() + "'";
			start = false;
		}

		if (p.getYear() != 0) {
			if (start == false) {
				statement = statement + " AND ";
			} else {
				statement = statement + " WHERE ";
			}
			statement = statement + "year = '" + p.getYear() + "'";
		}

		statement = statement + ";";

		r = SQL.SQLstatements(statement);
		System.out.println(statement);

		if (r.next()) {
			do {
				Placement placement = new Placement(r.getInt("id"), r.getInt("year"), r.getString("start_date"),
						r.getString("end_date"), r.getString("hospital"), r.getString("preference"),
						r.getString("cohort"), r.getString("comments"), r.getString("module"),
						r.getString("module_number"));
				placements.add(placement);
			} while (r.next());
		}

		return placements;
	}
}
