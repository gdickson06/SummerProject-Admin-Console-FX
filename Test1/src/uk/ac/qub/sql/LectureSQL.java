package uk.ac.qub.sql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import uk.ac.qub.methods.ConvertMethods;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Lecture;

public class LectureSQL {

/**
 * This method will take in a list of lectures and upload them all to the SQL database, it will also take in a 
 * @param lectures
 * @param Year
 * @throws Exception
 */
	public static void saveSQLLecture(List<Lecture> lectures, String Year) throws Exception {
		
		int error = 0;
		List<String> errors = new ArrayList<String>();

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
				error++;
			errors.add(l.getStartDate() + " " + l.getStartTime()+ " " + l.getLocation());}
	
		}
		
		if(error>0){
			GeneralMethods.show("There was an issue with "+ error + " lectures" , "Warning");
			for(String s : errors){
				GeneralMethods.show(s, "Issue with this lecture");
			}
		}
		GroupsConSQL.GroupsToGroup(lectures);
	}
	
/**
 * This method will take in a list of Strings to amend a lecture
 * @param l
 * @throws Exception
 */

	public static void AmendLecture(Lecture l) throws Exception {
		

		PreparedStatement statement = null;

		String Statement = "UPDATE Lectures SET week =" + l.getWeek() + ", day='" + l.getDay() + "', date= '" + l.getStartDate()
				+ "', start_time= '" + l.getStartTime() + "', end_time= '" + l.getEndTime() + "', groups= '" + l.getGroup()
				+ "', location= '" + l.getLocation() + "', subject= '" + l.getSubject() + "', theme= '" + l.getTheme() + "', teaching= '"
				+ l.getTeachingFormat() + "', description= '" + l.getDescription() + "', staff= '" + l.getStaff() + "', style = '" + l.getStyle()
				+ "', module = '" + l.getModule() + "', optional="+l.getEssential()+", year ="+l.getYear()+" WHERE lecture_id = " + l.getId() + ";";
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
 * @param l
 * @throws Exception
 */
	public static void UploadSingleLecture(Lecture l) throws Exception {


		PreparedStatement statement = null;
	
		

		String Statement = "INSERT INTO Lectures (week, day, date, start_time, end_time, groups, location, subject, theme, teaching, description, staff, style, module, optional, year)"
		+ "VALUES (" + l.getWeek() + ", '" + l.getDay() + "', '" + l.getStartDate() + "', '" + l.getStartTime() + "','" + l.getEndTime()
				+ "', '" + l.getGroup() + "', '" + l.getLocation() + "', '" + l.getSubject() + "', '" + l.getTheme() + "', '" + l.getTeachingFormat()
				+ "', '" + l.getDescription() + "', '" + l.getStaff() + "', '" + l.getStyle() + "', '" + l.getModule() + "', "+l.getEssential()+", "+l.getYear()+");";
	
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
