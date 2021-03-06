package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import application.Main;
import uk.ac.qub.objects.Absence;
/**
 * Name of Package - uk.ac.qub.sql
 * Date Last Amended - 08/09/17 
 * Outline - This class will contain all of the methods to amend, delete, save single and read absence
 * Demographics � 79 LOC 4 Methods
 */
public class AbsenceSQL {

	/**
	 * This method takes in a list of Strings to amend a specific absence, the first entry on 
	 * the list of strings is the id of the absence to amend
	 * @param a
	 * @throws Exception
	 */
	public static void AmendAbsence(Absence a) throws Exception {

		PreparedStatement statement = null;

		String Statement = "UPDATE Absences SET student_number =" + a.getStudentNumber() + ", lecture_id=" + a.getLectureID()
				+ ", start_date= '" + a.getStartDate() + "', end_date= '" + a.getEndDate() + "', start_time = '" + a.getStartTime()
				+ "', end_time = '" + a.getEndTime() + "', reason = '" + a.getReason().replaceAll("'", "''") + "', approved = " + a.getApproved() + ", type = '"
				+ a.getType() + "', viewed = true WHERE absences_id = " + a.getId() + ";";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();
	}
	
	/**
	 * This method takes in a String which will be the id of the absence to delete an absence
	 * @param id
	 * @throws Exception
	 */

	public static void DeleteAbsence(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		PreparedStatement ps = c.prepareStatement("DELETE FROM Absences WHERE absences_id =" + id);
		ps.executeUpdate();
	}

	/**
	 * This method takes in a string of Strings to upload a single absence
	 * @param absenceDetails
	 * @throws Exception
	 */
	public static void saveSingleAbsence(Absence a) throws Exception {
	
		PreparedStatement singleAbsenceStatement = null;


		String Statement = "INSERT INTO Absences (student_number, lecture_id, start_date, end_date, start_time, end_time, reason, approved, type, viewed)"
				+ "VALUES (" + a.getStudentNumber() + ", " + a.getLectureID() + ", '" + a.getStartDate()
				+ "', '" + a.getEndDate() + "', '" + a.getStartTime() + "', '" + a.getEndTime()
				+ "', '" + a.getReason().replaceAll("'", "''") + "', " + a.getApproved() + ", '" + a.getType()
				+ "',true);";
		singleAbsenceStatement = Main.connection.prepareStatement(Statement);
		singleAbsenceStatement.executeUpdate();
	}
	
	/**
	 * This method marks an absence as read.
	 * @param id
	 * @throws SQLException
	 */
	public static void readAbsence(int id) throws SQLException{
		PreparedStatement ps = null;
		String Statement = "UPDATE Absences SET  viewed = true WHERE absences_id = " + id + ";";
		ps=Main.connection.prepareStatement(Statement);
		ps.executeUpdate();
	}
}
