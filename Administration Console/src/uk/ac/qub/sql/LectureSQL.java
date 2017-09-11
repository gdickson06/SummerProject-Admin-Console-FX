package uk.ac.qub.sql;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import application.Main;
import uk.ac.qub.methods.ConvertMethods;

import uk.ac.qub.objects.Lecture;
/**
 * Name of Package - uk.ac.qub.sql
 * Date Last Amended - 08/09/17 
 * Outline - This class will contain all of the methods to amend, 
 * delete, save single and save multiple lectures along with any other methods to amend
 * parts of lectures
 * Demographics – 198 LOC 7 Methods
 */

public class LectureSQL {

	/**
	 * This method will take in a list of lectures and upload them all to the
	 * SQL database, it will also take in a
	 * 
	 * @param lectures
	 * @param Year
	 * @return 
	 * @throws Exception
	 */
	public static List<String> saveSQLLecture(List<Lecture> lectures, String Year) throws Exception {

		
		List<String> errors = new ArrayList<String>();

		PreparedStatement statement = null;

		for (Lecture l : lectures) {
			int week = l.getWeek();
			String day = l.getDay();
			String startDate = ConvertMethods.DateConvertSQL(l.getStartDate());
			String startTime = l.getStartTime().replaceAll("'", "''");
			String endTime = l.getEndTime().replaceAll("'", "''");
			String groups = l.getGroup();
			String location = l.getLocation().replaceAll("'", "''");
			String subject = l.getSubject().replaceAll("'", "''");
			String theme = l.getTheme().replaceAll("'", "''");
			String format = l.getTeachingFormat().replaceAll("'", "''");
			String description = l.getDescription().replaceAll("'", "''");
			String staff = l.getStaff().replaceAll("'", "''");
			String style = l.getStyle().replaceAll("'", "''");
			String module = l.getModule().replaceAll("'", "''");

			String statements = null;
			try {
				ConvertMethods.convert(groups);
				statements = "INSERT INTO Lectures (week, day, date, start_time, end_time, groups, location, subject, theme, teaching, description, staff, style, module, optional, year)"
						+ "VALUES (" + week + ", '" + day + "', " + startDate + ", '" + startTime + "','" + endTime
						+ "', '" + groups + "', '" + location + "', '" + subject + "', '" + theme + "', '" + format
						+ "', '" + description + "', '" + staff + "', '" + style + "', '" + module + "', false," + Year
						+ ");";

				statement = Main.connection.prepareStatement(statements);
				statement.executeUpdate();
			} catch (Exception e) {
				
				errors.add(l.getStartDate() + " " + l.getStartTime() + " " + l.getLocation());
			}

		}

		
		GroupsConSQL.GroupsToGroup(lectures);
		
		return errors;
	}

	/**
	 * This method will take in a list of Strings to amend a lecture
	 * 
	 * @param l
	 * @throws Exception
	 */

	public static void AmendLecture(Lecture l) throws Exception {

		PreparedStatement statement = null;

		String Statement = "UPDATE Lectures SET week =" + l.getWeek() + ", day='" + l.getDay() + "', date= '"
				+ l.getStartDate() + "', start_time= '" + l.getStartTime() + "', end_time= '" + l.getEndTime()
				+ "', groups= '" + l.getGroup().replaceAll("'", "''") + "', location= '"
				+ l.getLocation().replaceAll("'", "''") + "', subject= '" + l.getSubject().replaceAll("'", "''")
				+ "', theme= '" + l.getTheme().replaceAll("'", "''") + "', teaching= '"
				+ l.getTeachingFormat().replaceAll("'", "''") + "', description= '"
				+ l.getDescription().replaceAll("'", "''") + "', staff= '" + l.getStaff().replaceAll("'", "''")
				+ "', style = '" + l.getStyle().replaceAll("'", "''") + "', module = '"
				+ l.getModule().replaceAll("'", "''") + "', optional=" + l.getEssential() + ", year =" + l.getYear()
				+ " WHERE lecture_id = " + l.getId() + ";";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}

	/**
	 * This method takes in a String which is the id of a lecture to delete the
	 * lecture from the SQL Database
	 * 
	 * @param id
	 * @throws Exception
	 */

	public static void DeleteLecture(String id) throws Exception {

		PreparedStatement ps = Main.connection.prepareStatement("DELETE FROM Lectures WHERE lecture_id =" + id);
		ps.executeUpdate();
	}

	/**
	 * This method will delete a full year of lectures from the SQL database it
	 * will take in a String which will say which year that this is.
	 * 
	 * @param Year
	 * @throws Exception
	 */
	public static void DeleteLectureYear(String Year) throws Exception {

		PreparedStatement ps = Main.connection.prepareStatement("DELETE FROM Lectures WHERE year =" + Year);
		ps.executeUpdate();
	}

	/**
	 * This will take in a List of Strings to upload a single lecture
	 * 
	 * @param l
	 * @throws Exception
	 */
	public static void UploadSingleLecture(Lecture l) throws Exception {

		PreparedStatement statement = null;

		String Statement = "INSERT INTO Lectures (week, day, date, start_time, end_time, groups, location, subject, theme, teaching, description, staff, style, module, optional, year)"
				+ "VALUES (" + l.getWeek() + ", '" + l.getDay() + "', '" + l.getStartDate() + "', '" + l.getStartTime()
				+ "','" + l.getEndTime() + "', '" + l.getGroup().replaceAll("'", "''") + "', '"
				+ l.getLocation().replaceAll("'", "''") + "', '" + l.getSubject().replaceAll("'", "''") + "', '"
				+ l.getTheme().replaceAll("'", "''") + "', '" + l.getTeachingFormat().replaceAll("'", "''") + "', '"
				+ l.getDescription().replaceAll("'", "''") + "', '" + l.getStaff().replaceAll("'", "''") + "', '"
				+ l.getStyle().replaceAll("'", "''") + "', '" + l.getModule().replaceAll("'", "''") + "', "
				+ l.getEssential() + ", " + l.getYear() + ");";

		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();
	}

	/**
	 * This method will upload a note connected to a lecture, it will take in
	 * the id and the text of the note
	 * 
	 * @param id
	 * @param note
	 * @throws Exception
	 */
	public static void UploadNote(String id, String note) throws Exception {

		PreparedStatement statement = null;

		String Statement = "UPDATE Lectures SET notes ='" + note.replaceAll("'", "''") + "' WHERE lecture_id = " + id
				+ ";";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();
	}


}
