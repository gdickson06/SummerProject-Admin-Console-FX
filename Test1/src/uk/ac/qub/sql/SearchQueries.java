package uk.ac.qub.sql;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import uk.ac.qub.objects.Coordinator;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.objects.Lecturer;
import uk.ac.qub.objects.Room;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.Student;
import uk.ac.qub.objects.User;

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
					Student s = new Student(r.getInt("StudentNumber"), r.getString("Name"), r.getString("Cohort"),
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

	public static List<Staff> searchStaff(int search, String info,Boolean x) {
		ResultSet r,r1;
		String statement = null;
		String statement2 = null;
		List<Staff> staff = new ArrayList<Staff>();

		switch (search) {
		// first name
		case 1:
			statement = "select * from course_coordinator where Name like '" + info + "%';";
			statement2 = "select * from staff where Name like '" + info + "%';";
			break;
			//Last NAme
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
			statement2="select * from staff where type ='"+info+"'";
			break;
		default:
			System.out.println("Error in searching lecturers");
		}

		r = SQL.SQLstatements(statement);
		r1=SQL.SQLstatements(statement2);
		System.out.println(statement);
		System.out.println(statement2);
		if(x){
		try {
			if (r1.next()) {

				do {
					User u = new User(r1.getString("Name"),r1.getString("StaffNumber"),  r1.getString("Password"),r1.getString("Type"));
					staff.add(u);
				} while (r1.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			if(r.next()){
				do{
					Coordinator c = new Coordinator(r.getString("Name"),r.getString("Username"),r.getString("Password"),r.getString("Module"),r.getString("Email"));
					staff.add(c);
				} while(r.next());
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} else {
			if(info.equals("Module Coordinator")){
				try {
					if (r.next()){
						try {
							do{
								Coordinator c = new Coordinator(r.getString("Name"),r.getString("Username"),r.getString("Password"),r.getString("Module"),r.getString("Email"));
								staff.add(c);
							} while(r.next());
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
							User u = new User(r1.getString("Name"),r1.getString("StaffNumber"),  r1.getString("Password"),r1.getString("Type"));
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
