package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import application.Main;

public class AbsenceSQL {

	/**
	 * This method takes in a list of Strings to amend a specific absence, the first entry on 
	 * the list of strings is the id of the absence to amend
	 * @param s
	 * @throws Exception
	 */
	public static void AmendAbsence(List<String> s) throws Exception {

		PreparedStatement statement = null;

		String Statement = "UPDATE Absences SET student_number =" + s.get(1) + ", lecture_id=" + s.get(2)
				+ ", start_date= '" + s.get(3) + "', end_date= '" + s.get(4) + "', start_time = '" + s.get(5)
				+ "', end_time = '" + s.get(6) + "', reason = '" + s.get(7) + "', approved = " + s.get(8) + ", type = '"
				+ s.get(9) + ", viewed = true WHERE absences_id = " + s.get(0) + ";";
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
	public static void saveSingleAbsence(List<String> absenceDetails) throws Exception {
	
		PreparedStatement singleAbsenceStatement = null;


		String Statement = "INSERT INTO absence (student_number, lecture_id, start_date, end_date, start_time, end_time, reason, approved, type, viewed)"
				+ "VALUES (" + absenceDetails.get(0) + ", " + absenceDetails.get(1) + ", '" + absenceDetails.get(2)
				+ "', '" + absenceDetails.get(3) + "', '" + absenceDetails.get(4) + "', '" + absenceDetails.get(5)
				+ "', '" + absenceDetails.get(6) + "', " + absenceDetails.get(7) + ", '" + absenceDetails.get(8)
				+ "',true);";
		singleAbsenceStatement = Main.connection.prepareStatement(Statement);
		singleAbsenceStatement.executeUpdate();
	}

}
