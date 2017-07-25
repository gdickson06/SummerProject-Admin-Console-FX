package uk.ac.qub.churst;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

import java.util.List;
import java.util.Set;

import uk.ac.qub.objects.GroupsCon;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.objects.Room;
import uk.ac.qub.objects.Student;

public class SQL {
	
	private static String user="jTurkington";
	private static String password="emily1234";
	private static String url="jdbc:mysql://qub.cjw92whe4wuf.eu-west-2.rds.amazonaws.com:3306/med?autoReconnect=true&useSSL=false&allowMultiQueries=true";

	/**
	 * This method is for admin staff to upload a list of lectures to a
	 * database, this will take a CSV file.
	 * 
	 * @param lectures
	 * @throws Exception
	 */

	public static void saveSQLLecture(List<Lecture> lectures) throws Exception {

		//Using the JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		//Creating a connection with 
		Connection connection = DriverManager.getConnection(url, user, password);

	
		PreparedStatement statement = null;

		for (Lecture l : lectures) {
			int week = l.getWeek();
			String day = l.getDay();
			String startDate = l.getStartDate();
			String startTime = l.getStartTime();
			String endTime = l.getEndTime();
			String groups = l.getGroup();
			String location = l.getLocation();
			String subject = l.getSubject();
			String theme = l.getTheme();
			String format = l.getTeachingFormat();
			String description = l.getDescription();
			String staff = l.getStaff();
			String style = l.getStyle();
			String module = l.getModule();

			description = description.replaceAll("'", "''");
			staff = staff.replaceAll("'", "''");
			startTime = startTime.replaceAll("'", "''");
			String statements=null;
			try {
				ConvertGroup.convert(groups);
				statements="INSERT INTO lectures (Week, Day, StartDate, StartTime, EndTime, Groups, Location, Subject, Theme, Teaching, Description, Staff, Style, Module)" + "VALUES (" + week + ", '" + day + "', '" + startDate
						+ "', '" + startTime + "','" + endTime + "', '" + groups + "', '" + location + "', '" + subject
						+ "', '" + theme + "', '" + format + "', '" + description + "', '" + staff + "', '" + style
						+ "', '" + module + "');";
				
				System.out.println(statements);
				statement=connection.prepareStatement(statements);
				statement.executeUpdate();
			} catch (Exception e) {
				
				System.err.println("Issue with groups, please check the syntax for week" + l.getWeek() + " day "
						+ l.getDay() + " startTime " + l.getStartTime() + " the groups input is " + l.getGroup());
			}

		}

	}
	
	public static void saveSQLRooms(List<Room>rooms)throws Exception{

		
		Class.forName("com.mysql.jdbc.Driver");
	

	Connection connection = DriverManager.getConnection(url, user, password);


	PreparedStatement statement = null;
	String newStatement=null;

	for (Room r : rooms) {
		String code = r.getCode();
		String name =r.getName();
		try {
		newStatement="INSERT INTO location " + "VALUES ('"  + code + "', '" + name
				+ "')";
		statement=connection.prepareStatement(newStatement);
		statement.executeUpdate();
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	}

	/**
	 * Saving the SQL list for students
	 * @param students
	 * @throws Exception
	 */
	public static void saveSQLStudents(List<Student> students) throws Exception {

		
		
			Class.forName("com.mysql.jdbc.Driver");
		

		Connection connection = DriverManager.getConnection(url, user, password);

	
		PreparedStatement statement = null;
		String newStatement=null;

		for (Student s : students) {
			int studentNumber = s.getStudentNumber();
			String name = s.getName();
			String group = s.getFirstGroup();
			String email = s.getEmail();
			int intakeYear = s.getIntakeYear();

			newStatement="INSERT INTO students " + "VALUES (" + studentNumber + ", '" + name + "', '" + group
					+ "', '" + email+ "', " + intakeYear + ")";
			statement=connection.prepareStatement(newStatement);
			statement.executeUpdate();

		}

	}

	/**
	 * This method will return a list of lectures depending on the group you are
	 * in.
	 * 
	 * @param group
	 * @return
	 */
	public static List<Lecture> myLectures(String group) {
		List<Lecture> mine = null;

		try {
			mine = new ArrayList<Lecture>();
			Class.forName("com.mysql.jdbc.Driver");


			Connection connection = DriverManager.getConnection(url, user, password);

			// creating the SQL query selecting all information from the fixture
			// table in the DB
			String SqlQuery;
			SqlQuery = "SELECT * FROM lectures";
			Statement statement = connection.createStatement();

			/*
			 * Creating an instance of the ResultSet class to go through the
			 * rows within the fixture and to retrieve all information for aTeam
			 * and bTeam
			 */

			ResultSet results = statement.executeQuery(SqlQuery);

			List<Lecture> lectures = new ArrayList<Lecture>();
			while (results.next()) {
				lectures.add(new Lecture(results.getInt("Week"), results.getString("Day"),
						results.getString("StartDate"), results.getString("StartTime"), results.getString("EndTime"),
						results.getString("Groups"), results.getString("Location"), results.getString("Subject"),
						results.getString("Theme"), results.getString("Teaching"), results.getString("Description"),
						results.getString("Staff"), results.getString("Style"), results.getString("Module")));
			}

			for (Lecture l : lectures) {
				List<String> groups = ConvertGroup.convert(l.getGroup());
				if (groups.contains(group)) {
					mine.add(l);
				}
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mine;
	}

	
/**
 * This is a generic method to produce a resultset for searching through the database
 * @param statementName
 * @return
 */
	public static ResultSet SQLstatements(String statementName) {
		ResultSet results = null;
		try {

			Class.forName("com.mysql.jdbc.Driver");


			Connection connection = DriverManager.getConnection(url, user, password);

			// creating the SQL query selecting all information from the fixture
			// table in the DB
			String SqlQuery;
			SqlQuery = statementName;
			Statement statement = connection.createStatement();

			/*
			 * Creating an instance of the ResultSet class to go through the
			 * rows within the fixture and to retrieve all information for aTeam
			 * and bTeam
			 */

			results = statement.executeQuery(SqlQuery);
			

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error");
		}

		return results;
	}
	/**
	 * This method will return a PDF (When completed) of a list of students who should be attending the lecture
	 * @param id
	 * @throws SQLException
	 */
	public static void classGroup (int id) throws SQLException{
		
		List<String> names = new ArrayList<String>();
		String statement = "select * from lectures where id= "+id;
		ResultSet lecture = SQLstatements(statement);
		lecture.next();
		String groupName = lecture.getString("Groups");
		
		
		List<String> groups = ConvertGroup.convert(groupName);
		
		for(String group: groups){
			String statement2="Select * from students where Group1='"+group+"'";
			
			ResultSet students = SQLstatements(statement2);
			
			while (students.next()){
				names.add(students.getString("Group1")+"      "+students.getString("Name"));
			}
		}
		
		System.out.println(lecture.getString("Description")+" ("+lecture.getString("Module")+")");
		System.out.println("Tutorial Group " +lecture.getString("Groups"));
		System.out.println("Date : " +lecture.getString("StartDate")+ "       Time : "+lecture.getString("StartTime")+" - "+lecture.getString("EndTime"));
		System.out.println("Tutor Name: "+ lecture.getString("Staff"));
		System.out.println("Tutor Signature");
		System.out.println("Teaching staff should return completed attendance sheets to the centre for medical education:");
		System.out.println("MBC Site:Reception, Ground Floor, Whitle medical building");
		System.out.println("RVH Site: Reception, First Floor, Mulhouse Building");
		System.out.println("Group         Student         Signature");
		for(String s:names){
			System.out.println(s);
		}
	}
	
	
	
	public static void GroupsToGroup (List<Lecture> lectures)throws Exception{
		//Using the JDBC driver
				try {
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}

				//Creating a connection with 
				Connection connection = DriverManager.getConnection(url, user, password);
				
				Set<GroupsCon> set = new HashSet<GroupsCon>();
				
				for(Lecture l:lectures){
					try{
					List<String> group = ConvertGroup.convert(l.getGroup());
					
					for(String s:group){
						set.add(new GroupsCon(l.getGroup(),s));
					}
					} catch (Exception e){
						e.printStackTrace();
						System.out.println(l.toString());
					}
				}
				//
				PreparedStatement statement=null;
				String statements=null;
				
				for(GroupsCon g:set){
				try {
					statements="INSERT INTO groups " + "VALUES ('" + g.getGroups() + "', '" + g.getCohort() + "')";
					statement=connection.prepareStatement(statements);
					statement.executeUpdate();
				} catch (Exception e) {
					e.printStackTrace();
						}

			}
				
		
	
	}
	
	public static void AmendStudent(List<String>s)throws Exception{
		//This will be in the order of the studentNumber,name,group,email,year.
		//Using the JDBC driver
				
					Class.forName("com.mysql.jdbc.Driver");
				

				//Creating a connection with 
				Connection connection = DriverManager.getConnection(url, user, password);

			
				PreparedStatement statement = null;
		
		String Statement ="UPDATE students SET Name ='"+s.get(1)+"', Group1='"+s.get(2)+"', StudentEmail= '"+s.get(3)+"', IntakeYear = "+s.get(4)+" WHERE StudentNumber = "+s.get(0)+";";
		System.out.println(Statement);
		statement=connection.prepareStatement(Statement);
		statement.executeUpdate();
		
	}
	
	public static void UploadSingleStudent(List<String>s)throws Exception{
		//This will be in the order of the name,group,email,year.
		//Using the JDBC driver
				
					Class.forName("com.mysql.jdbc.Driver");
				

				//Creating a connection with 
				Connection connection = DriverManager.getConnection(url, user, password);

			
				PreparedStatement statement = null;
		
		String Statement="INSERT INTO students " + "VALUES (" + s.get(0) + ", '" + s.get(1) + "', '" + s.get(2)
				+ "', '" + s.get(3)+ "', " + s.get(4) + ")";
		statement=connection.prepareStatement(Statement);
		statement.executeUpdate();
		
	}
	
	public static void DeleteStudent (String StudentNumber) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(url,user,password);
		PreparedStatement ps = c.prepareStatement("DELETE FROM students WHERE StudentNumber ="+StudentNumber);
		ps.executeUpdate();
	}
	public static void AmendLecture(List<String>s)throws Exception{
		//This will be in the order of the id,week,day,StartDate,StartTime,EndTime,Groups,Location,Subject,Theme,Teaching,Description,Staff
		//Using the JDBC driver
				
					Class.forName("com.mysql.jdbc.Driver");
				

				//Creating a connection with 
				Connection connection = DriverManager.getConnection(url, user, password);

			
				PreparedStatement statement = null;
		
		String Statement ="UPDATE lectures SET week ="+s.get(1)+", Day='"+s.get(2)+"', StartDate= '"+s.get(3)+"', StartTime= '"+s.get(4)+"', EndTime= '"+s.get(5)+"', Groups= '"+s.get(6)+"', Location= '"+s.get(7)+"', Subject= '"+s.get(8)+"', Theme= '"+s.get(9)+"', Teaching= '"+s.get(10)+"', Description= '"+s.get(11)+"', Staff= '"+s.get(12)+"', Style = '"+s.get(13)+"', Module = '"+s.get(14)+"' WHERE id = "+s.get(0)+";";
		System.out.println(Statement);
		statement=connection.prepareStatement(Statement);
		statement.executeUpdate();
		
	}
	
	public static void DeleteLecture (String id) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(url,user,password);
		PreparedStatement ps = c.prepareStatement("DELETE FROM lectures WHERE id ="+id);
		ps.executeUpdate();
	}
	
	public static void UploadSingleLecture(List<String>s)throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		

		//Creating a connection with 
		Connection connection = DriverManager.getConnection(url, user, password);

	
		PreparedStatement statement = null;
		//This will be in the order of the week,day,StartDate,StartTime,EndTime,Groups,Location,Subject,Theme,Teaching,Description,Staff
		
		String Statement = "INSERT INTO lectures (Week, Day, StartDate, StartTime, EndTime, Groups, Location, Subject, Theme, Teaching, Description, Staff, Style, Module)"
				+ "VALUES (" + s.get(0) + ", '" + s.get(1) + "', '" + s.get(2) + "', '" + s.get(3) + "','" + s.get(4)
				+ "', '" + s.get(5) + "', '" + s.get(6) + "', '" + s.get(7) + "', '" + s.get(8) + "', '" + s.get(9)
				+ "', '" + s.get(10) + "', '" + s.get(11) + "', '" + s.get(12) + "', '" + s.get(13) + "');";
		System.out.println(Statement);
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();
	}
	
	public static void saveSingleAbsence(List<String> absenceDetails) throws Exception{
		//making a connection to the JDBC Driver
		Class.forName("com.mysql.jdbc.Driver");
		
		//making a connection with the Medical Timetable Database
		Connection connection = DriverManager.getConnection(url,user,password);
		
		//creating the preparedStatement to be used in the below method
		PreparedStatement singleAbsenceStatement=null;
		
		//creating the SQL Query to add details for Single Absence
		String Statement = "INSERT INTO absence (StudentNumber, LectureID, Date, Time, Reason, Approved, type)"
				+ "VALUES (" + absenceDetails.get(0) + ", " + absenceDetails.get(1) + ", '" + absenceDetails.get(2) + "', '" + absenceDetails.get(3)
				+ "', '" + absenceDetails.get(4) + "', " + absenceDetails.get(5) + ", '" + absenceDetails.get(6)+"');";
		//printing the SQL statement to Console to ensure it is correctly prepared
		System.out.println(Statement);
		//assigning the SQL query to the prepareStatement method
		singleAbsenceStatement = connection.prepareStatement(Statement);
		//using the executeUpdate method we now update the database with the Absence
		singleAbsenceStatement.executeUpdate();
	}

}