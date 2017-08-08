package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import application.Main;
import javafx.scene.control.ProgressBar;
import uk.ac.qub.churst.ConvertMethods;
import uk.ac.qub.objects.GroupsCon;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.objects.Student;


public class SQL {
	protected static String defaultPassword = "pass";

	public static String user = "jTurkington";
	public static String password = "emily1234";
	public static String url = "jdbc:mysql://qub.cjw92whe4wuf.eu-west-2.rds.amazonaws.com:3306/med?autoReconnect=true&useSSL=false&allowMultiQueries=true";


	public static List<Lecture> myLectures(String group, LocalDate Date) {
		List<Lecture> mine = null;

		try {
			mine = new ArrayList<Lecture>();
		

			// creating the SQL query selecting all information from the fixture
			// table in the DB
			String SqlQuery;
			SqlQuery = "SELECT * FROM lectures WHERE StartDate = '"+ Date +"';";
			Statement statement = Main.connection.createStatement();

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
				List<String> groups = ConvertMethods.convert(l.getGroup());
				if (groups.contains(group)) {
					mine.add(l);
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mine;
	}

	/**
	 * This is a generic method to produce a resultset for searching through the
	 * database
	 * 
	 * @param statementName
	 * @return
	 */
	public static ResultSet SQLstatements(String statementName) {
		ResultSet results = null;
		

	
	
try{
	

			// creating the SQL query selecting all information from the fixture
			// table in the DB
			String SqlQuery;
			SqlQuery = statementName;
			Statement statement = Main.connection.createStatement();

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
	 * This method will return a PDF (When completed) of a list of students who
	 * should be attending the lecture
	 * 
	 * @param id
	 * @return 
	 * @throws SQLException
	 */
	public static List<String> classGroup(int id) throws SQLException {

		List<String> names = new ArrayList<String>();
		String statement = "select * from lectures where id= " + id;
		ResultSet lecture = SQLstatements(statement);
		lecture.next();
		String groupName = lecture.getString("Groups");

		List<String> groups = ConvertMethods.convert(groupName);

		for (String group : groups) {
			String statement2 = "Select * from students where  Cohort='" + group + "'";

			ResultSet students = SQLstatements(statement2);

			while (students.next()) {
				names.add(students.getString("Cohort") + "      " + students.getString("Name"));
			}
		}
		
		List<String> output = new ArrayList<String>();
		output.add(lecture.getString("Description") + " (" + lecture.getString("Module") + ")");
		output.add("Tutorial Group " + lecture.getString("Groups"));
		output.add("Date : " + lecture.getString("StartDate") + "       Time : "
				+ lecture.getString("StartTime") + " - " + lecture.getString("EndTime"));
		output.add("Tutor Name: " + lecture.getString("Staff"));
		output.add("Tutor Signature");
		output.add(
				"Teaching staff should return completed attendance sheets to the centre for medical education:");
		output.add("MBC Site:Reception, Ground Floor, Whitle medical building");
		output.add("RVH Site: Reception, First Floor, Mulhouse Building");
		output.add("Group         Student         Signature");
		for (String s : names) {
			output.add(s);
		}
		
		return output;
	}
	
	public static Set<String> Staff (){
		Set<String> staff = new TreeSet<String>();
		
		
		ResultSet r = SQLstatements("select Staff from lectures");
		
		try {
			if (r.next()) {

				do {
					staff.addAll(Arrays.asList(r.getString("Staff").split("/")));
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String s: staff){
			System.out.println(s);
		}
		return staff;
	}
	
	public static Set<String> Modules (){
		Set<String> modules = new TreeSet<String>();
		
		
		ResultSet r = SQLstatements("select Module from lectures");
		
		try {
			if (r.next()) {

				do {
					modules.add(r.getString("Module"));
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(String s: modules){
			System.out.println(s);
		}
		return modules;
	}

	public static void GroupsToGroup (List<Lecture> lectures)throws Exception{

	
				
				
				Set<GroupsCon> set = new HashSet<GroupsCon>();
				
				for(Lecture l:lectures){
					List<String> group = new ArrayList<String>();
					try{
					group = ConvertMethods.convert(l.getGroup());
					} catch (InputMismatchException e){
						e.printStackTrace();
					}
					for(String s:group){
						GroupsCon g = new GroupsCon();
						
							g.setCohort(s);
							g.setGroups(l.getGroup());
						set.add(g);
						
						

					}
			
				}
				//
				PreparedStatement statement=null;
				String statements=null;
				System.out.println(set.size());
				for(GroupsCon g:set){
				try {
					
					statements="INSERT INTO groupConvert " + "VALUES ('" + g.getGroups() + "', '" + g.getCohort() + "')";
					statement=Main.connection.prepareStatement(statements);
					statement.executeUpdate();
					
					System.out.println(g.toString());
				} catch (Exception e) {
					e.printStackTrace();
						}

			}
				
		
	
	}
	
	public static void tutorialListAbsences (Lecture lecture, List<Student> students) throws SQLException{
	
		
		List<String> statements = new ArrayList<String>();
		
		for(Student s: students){
			String Statement = "INSERT INTO absence (StudentNumber, LectureID, StartDate, EndDate, StartTime, EndTime, Reason, Approved, type)"
					+ "VALUES (" + s.getStudentNumber() + ", " + lecture.getId() + ", '" + lecture.getStartDate() + "', '" + lecture.getStartDate()
					+ "', '" + lecture.getStartTime() + "', '" + lecture.getEndTime() + "', '" + "Missing from tutorial autogenerated absence" + "', " + false+", 'Missing from class');";
		
		statements.add(Statement);
		
		}
		for (String s: statements){
			PreparedStatement statement=Main.connection.prepareStatement(s);
			statement.executeUpdate();
			
			System.out.println(s.toString());
		}
		
		
	}

}