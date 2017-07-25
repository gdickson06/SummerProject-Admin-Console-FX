package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import uk.ac.qub.churst.ConvertGroup;
import uk.ac.qub.objects.GroupsCon;
import uk.ac.qub.objects.Lecture;


public class SQL {
	protected static String defaultPassword = "pass";

	protected static String user = "jTurkington";
	protected static String password = "emily1234";
	protected static String url = "jdbc:mysql://qub.cjw92whe4wuf.eu-west-2.rds.amazonaws.com:3306/med?autoReconnect=true&useSSL=false&allowMultiQueries=true";


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
	 * This is a generic method to produce a resultset for searching through the
	 * database
	 * 
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
	 * This method will return a PDF (When completed) of a list of students who
	 * should be attending the lecture
	 * 
	 * @param id
	 * @throws SQLException
	 */
	public static void classGroup(int id) throws SQLException {

		List<String> names = new ArrayList<String>();
		String statement = "select * from lectures where id= " + id;
		ResultSet lecture = SQLstatements(statement);
		lecture.next();
		String groupName = lecture.getString("Groups");

		List<String> groups = ConvertGroup.convert(groupName);

		for (String group : groups) {
			String statement2 = "Select * from students where Group1='" + group + "'";

			ResultSet students = SQLstatements(statement2);

			while (students.next()) {
				names.add(students.getString("Group1") + "      " + students.getString("Name"));
			}
		}

		System.out.println(lecture.getString("Description") + " (" + lecture.getString("Module") + ")");
		System.out.println("Tutorial Group " + lecture.getString("Groups"));
		System.out.println("Date : " + lecture.getString("StartDate") + "       Time : "
				+ lecture.getString("StartTime") + " - " + lecture.getString("EndTime"));
		System.out.println("Tutor Name: " + lecture.getString("Staff"));
		System.out.println("Tutor Signature");
		System.out.println(
				"Teaching staff should return completed attendance sheets to the centre for medical education:");
		System.out.println("MBC Site:Reception, Ground Floor, Whitle medical building");
		System.out.println("RVH Site: Reception, First Floor, Mulhouse Building");
		System.out.println("Group         Student         Signature");
		for (String s : names) {
			System.out.println(s);
		}
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
					List<String> group = new ArrayList<String>();
					try{
					group = ConvertGroup.convert(l.getGroup());
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
					statement=connection.prepareStatement(statements);
					statement.executeUpdate();
					
					System.out.println(g.toString());
				} catch (Exception e) {
					e.printStackTrace();
						}

			}
				
		
	
	}

}