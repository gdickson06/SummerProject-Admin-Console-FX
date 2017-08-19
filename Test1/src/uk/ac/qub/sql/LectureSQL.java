package uk.ac.qub.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.Main;

import uk.ac.qub.churst.ConvertMethods;
import uk.ac.qub.objects.Lecture;

public class LectureSQL {

/**
 * This method will take in a list of lectures and upload them all to the SQL database, it will also take in a 
 * @param lectures
 * @param Year
 * @throws Exception
 */
	public static void saveSQLLecture(List<Lecture> lectures, String Year) throws Exception {
		
	

		PreparedStatement statement = null;
	
		for (Lecture l : lectures) {
			int week = l.getWeek();
			String day = l.getDay();
			String startDate = ConvertMethods.DateConvertSQL(l.getStartDate());
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
			String statements = null;
			try {
				ConvertMethods.convert(groups);
				statements = "INSERT INTO Lectures (week, day, date, start_time, end_time, groups, location, subject, theme, teaching, description, staff, style, module, optional, year)"
						+ "VALUES (" + week + ", '" + day + "', " + startDate + ", '" + startTime + "','" + endTime
						+ "', '" + groups + "', '" + location + "', '" + subject + "', '" + theme + "', '" + format
						+ "', '" + description + "', '" + staff + "', '" + style + "', '" + module + "', false," + Year+");";

				System.out.println(statement);
				statement = Main.connection.prepareStatement(statements);
				statement.executeUpdate();
			} catch (Exception e) {

			e.printStackTrace();}
	
		}
		SQL.GroupsToGroup(lectures);
	}
	
/**
 * This method will take in a list of Strings to amend a lecture
 * @param s
 * @throws Exception
 */

	public static void AmendLecture(List<String> s) throws Exception {
		

		PreparedStatement statement = null;

		String Statement = "UPDATE Lectures SET week =" + s.get(1) + ", day='" + s.get(2) + "', date= '" + s.get(3)
				+ "', start_time= '" + s.get(4) + "', end_time= '" + s.get(5) + "', groups= '" + s.get(6)
				+ "', location= '" + s.get(7) + "', subject= '" + s.get(8) + "', theme= '" + s.get(9) + "', teaching= '"
				+ s.get(10) + "', description= '" + s.get(11) + "', staff= '" + s.get(12) + "', style = '" + s.get(13)
				+ "', module = '" + s.get(14) + "', optional="+s.get(15)+", year ="+s.get(16)+", notes ='"+s.get(17)+"' WHERE lecture_id = " + s.get(0) + ";";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}

/**
 * This method takes in a String which is the id of a lecture to delete the lecture from the SQL Database
 * @param id
 * @throws Exception
 */

	public static void DeleteLecture(String id) throws Exception {
		
		PreparedStatement ps = Main.connection.prepareStatement("DELETE FROM Lectures WHERE lecture_id =" + id);
		ps.executeUpdate();
	}

	/**
	 * This method will delete a full year of lectures from the SQL database
	 * it will take in a String which will say which year that this is.
	 * @param Year
	 * @throws Exception
	 */
public static void DeleteLectureYear(String Year) throws Exception {
		
		PreparedStatement ps = Main.connection.prepareStatement("DELETE FROM Lectures WHERE year =" + Year);
		ps.executeUpdate();
	}

/**
 * This will take in a List of Strings to upload a single lecture
 * @param s
 * @throws Exception
 */
	public static void UploadSingleLecture(List<String> s) throws Exception {


		PreparedStatement statement = null;
	
		

		String Statement = "INSERT INTO Lectures (week, day, date, start_time, end_time, groups, location, subject, theme, teaching, description, staff, style, module, optional, year)"
		+ "VALUES (" + s.get(0) + ", '" + s.get(1) + "', '" + s.get(2) + "', '" + s.get(3) + "','" + s.get(4)
				+ "', '" + s.get(5) + "', '" + s.get(6) + "', '" + s.get(7) + "', '" + s.get(8) + "', '" + s.get(9)
				+ "', '" + s.get(10) + "', '" + s.get(11) + "', '" + s.get(12) + "', '" + s.get(13) + "', "+s.get(14)+", "+s.get(15)+", '"+s.get(16)+"');";
	
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();
	}
	
/**
 * This method will upload a note connected to a lecture, it will take in the id and the text of the note
 * @param id
 * @param note
 * @throws Exception
 */
	public static void UploadNote(String id,String note) throws Exception{
		

		PreparedStatement statement = null;

		String Statement = "UPDATE Lectures SET notes ='"+ note+ "' WHERE lecture_id = " + id + ";";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();
	}
	
/**
 * This method finds the time and date of a lecture based on the id of the lecture
 * @param id
 * @return
 * @throws SQLException
 */
	public static List<String> finder (String id) throws SQLException{
		
		List<String> s = new ArrayList<String>();

    	
    	String statement = "select * from Lectures where lecture_id ='" + id + "'";
    	
    	ResultSet r = SQL.SQLstatements(statement);
    	r.next();
	
		s.add(r.getString("start_date"));
		s.add(r.getString("start_time"));
		s.add(r.getString("end_Time"));
		
		return s;
	}

}
