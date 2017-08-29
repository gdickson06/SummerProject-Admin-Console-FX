package uk.ac.qub.sql;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;



import application.Main;

import uk.ac.qub.churst.ConvertMethods;

import uk.ac.qub.objects.Lecture;
import uk.ac.qub.objects.Student;

public class SQL {

	/**
	 * These Strings are for the easy changing of a database
	 */
	public static String user = "jTurkington";
	public static String password = "emily1234";
	public static String url = "jdbc:mysql://qub.cjw92whe4wuf.eu-west-2.rds.amazonaws.com:3306/med?autoReconnect=true&useSSL=false&allowMultiQueries=true";
	public static String QsisUser="QSIS";
	public static String QsisPassword ="James123";
	public static String QsisUrl ="jdbc:mysql://qsis.cjw92whe4wuf.eu-west-2.rds.amazonaws.com:3306/QSIS?autoReconnect=true&useSSL=false&allowMultiQueries=true";
	
	/**
	 * This method will be used in the GlobalSettings screen, this read in all 
	 * of the amendable content from the database and use it to populate the text
	 * boxes in the settings menu
	 * @return
	 * @throws SQLException
	 */
	public static Map<String,String> importGlobalSettings() throws SQLException{
		Map<String,String> values = new HashMap<String,String>();
		
		ResultSet r = SQLstatements("SELECT * FROM AmendableContent");
		
		while (r.next()){
			values.put(r.getString("identifier"), r.getString("current_value"));
		}
		return values;
 	}
	/**
	 * This method will update the database with any new values 
	 * @param values
	 * @throws SQLException
	 */
	public static void updateInfo(List<String> values) throws SQLException{
		List<String>fields = new ArrayList<String>();
		String [] a = {"Western Trust Contact Number", "Southern Trust Contact Number","South Eastern Trust Contact Number", "School of Medicine Email",
		"School of Medicine Contact Number","QUB IT Online Form","QUB IT Helpdesk Website","Personal Day Policy","Personal Day Allowance",
		"Northern Trust Contact Number","Forgotten Password Link ","Find Current Absences Policy", "Belfast Trust Contact Number", "Absences Email Address"};
		fields.addAll(Arrays.asList(a));
		
		for(int i=0; i<fields.size();i++){
			PreparedStatement preparedStatement = null;
			String statement = "UPDATE AmendableContent SET current_value = '"+values.get(i)+"' WHERE identifier ='"+fields.get(i)+"';";
			preparedStatement = Main.connection.prepareStatement(statement);
			preparedStatement.executeUpdate();
		}
	}
	
	/**
	 * This method will take in a cohort and a date and return a list of
	 * Lectures for the date
	 * 
	 * @param group
	 * @param Date
	 * @return
	 * @throws SQLException
	 */
	
	public static void downloadToCSV(List<String>attributes,String year,String type) throws IOException, SQLException {
		File file =new File("year"+year+"placements.csv");
		 PrintWriter pw = new PrintWriter(file);
	        StringBuilder sb = new StringBuilder();
	        
	        for(String s : attributes){
	        	sb.append(',');
	        	sb.append(s);
	        	
	        }
	        
	        sb.append('\n');
	        sb.deleteCharAt(0);
	        System.out.println("SELECT * FROM "+type + year +"'");
	        ResultSet r = SQL.SQLstatements("SELECT * FROM "+type + year +";");
	        if(r.next()){
	        do{
	        	for(int i =0; i<attributes.size(); i++){
	        		if(i!=attributes.size()){
	        	if(r.getString(attributes.get(i))==null){sb.append(" ");}else{sb.append(r.getString(attributes.get(i)));}
	        	sb.append(',');
	        		} else {
	        			if(r.getString(attributes.get(i))==null){sb.append(" ");}else{sb.append(r.getString(attributes.get(i)));}
	    	        	
	        		}
	        	}
	        	sb.append('\n');
	        	
	        }while (r.next());

	        }

	        pw.write(sb.toString());
	        pw.close();
	        Desktop.getDesktop().open(file);
	}
	public static List<Lecture> myLectures(String group, LocalDate Date) throws SQLException {
		List<Lecture> mine = null;

		mine = new ArrayList<Lecture>();

		// int week, int id, String day, String startDate, String startTime,
		// String endTime, String group,
		// String location, String subject, String theme, String teachingFormat,
		// String description, String staff,
		// String style, String module,Boolean essential, String year, String
		// notes
		String SqlQuery;
		SqlQuery = "SELECT * FROM Lectures WHERE StartDate = '" + Date + "';";
		Statement statement = Main.connection.createStatement();

		ResultSet results = statement.executeQuery(SqlQuery);

		List<Lecture> lectures = new ArrayList<Lecture>();
		while (results.next()) {
			lectures.add(new Lecture(results.getInt("week"), results.getInt("id"), results.getString("day"),
					results.getString("date"), results.getString("start_time"), results.getString("end_time"),
					results.getString("groups"), results.getString("location"), results.getString("subject"),
					results.getString("theme"), results.getString("teaching"), results.getString("description"),
					results.getString("staff"), results.getString("style"), results.getString("module"),
					results.getBoolean("essential"), results.getString("year"), results.getString("notes")));
		}

		for (Lecture l : lectures) {
			List<String> groups = ConvertMethods.convert(l.getGroup());
			if (groups.contains(group)) {
				mine.add(l);
			}
		}

		return mine;
	}

	/**
	 * This is a generic method to produce a resultset for searching through the
	 * database
	 * 
	 * @param statementName
	 * @return
	 * @throws SQLException
	 */
	public static ResultSet SQLstatements(String statementName) throws SQLException {
		ResultSet results = null;

		String SqlQuery;
		SqlQuery = statementName;
		Statement statement = Main.connection.createStatement();

		results = statement.executeQuery(SqlQuery);

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
		String statement = "select * from Lectures where lecture_id= " + id;
		ResultSet lecture = SQLstatements(statement);
		lecture.next();
		String groupName = lecture.getString("groups");

		List<String> groups = ConvertMethods.convert(groupName);

		for (String group : groups) {
			String statement2 = "Select * from Students where  cohort='" + group + "'";

			ResultSet students = SQLstatements(statement2);

			while (students.next()) {
				names.add(students.getString("cohort") + "      " + students.getString("name"));
			}
		}

		List<String> output = new ArrayList<String>();
		output.add(lecture.getString("Description") + " (" + lecture.getString("Module") + ")");
		output.add("Tutorial Group " + lecture.getString("Groups"));
		output.add("Date : " + lecture.getString("StartDate") + "       Time : " + lecture.getString("StartTime")
				+ " - " + lecture.getString("EndTime"));
		output.add("Tutor Name: " + lecture.getString("Staff"));
		output.add("Tutor Signature");
		output.add("Teaching staff should return completed attendance sheets to the centre for medical education:");
		output.add("MBC Site:Reception, Ground Floor, Whitle medical building");
		output.add("RVH Site: Reception, First Floor, Mulhouse Building");
		output.add("Group         Student         Signature");
		for (String s : names) {
			output.add(s);
		}

		return output;
	}

	/**
	 * This method will return a collection which contains all of the staff in
	 * the lectures
	 * 
	 * @return
	 * @throws SQLException
	 */

	public static Set<String> Staff() throws SQLException {
		Set<String> staff = new TreeSet<String>();

		ResultSet r = SQLstatements("select staff from Lectures");

		if (r.next()) {

			do {
				staff.addAll(Arrays.asList(r.getString("staff").split("/")));
			} while (r.next());

		}

		return staff;
	}

	/**
	 * This method will return a collection which contains all of the modules in
	 * the lectures
	 * 
	 * @return
	 * @throws SQLException
	 */

	public static Set<String> Modules() throws SQLException {
		Set<String> modules = new TreeSet<String>();

		ResultSet r = SQLstatements("select Module from Lectures");

		if (r.next()) {

			do {
				modules.add(r.getString("Module"));
			} while (r.next());

		}

		return modules;
	}
	

	
	
	/**
	 * Creating Absences for inputting PDFs
	 * @param lecture
	 * @param students
	 * @throws SQLException
	 */

	public static void tutorialListAbsences(Lecture lecture, List<Student> students) throws SQLException {

		List<String> statements = new ArrayList<String>();

		for (Student s : students) {
			String Statement = "INSERT INTO Absences (student_number, lecture_id, start_date, end_date, start_time, end_time, reason, approved, type, viewed)"
					+ "VALUES (" + s.getStudentNumber() + ", " + lecture.getId() + ", '" + lecture.getStartDate()
					+ "', '" + lecture.getStartDate() + "', '" + lecture.getStartTime() + "', '" + lecture.getEndTime()
					+ "', '" + "Missing from tutorial autogenerated absence" + "', " + false
					+ ", 'Missing from class',true);";

			statements.add(Statement);

		}
		for (String s : statements) {
			PreparedStatement statement = Main.connection.prepareStatement(s);
			statement.executeUpdate();

		}

	}

}