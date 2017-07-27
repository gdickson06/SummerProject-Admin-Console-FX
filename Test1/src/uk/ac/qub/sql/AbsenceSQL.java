package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class AbsenceSQL {

	public static void AmendAbsence(List<String> s) throws Exception {
		// This will be in the order of the
		// id,Studentnumber,lectureid,date,starttime,endtime,reason,approved,type
		// Using the JDBC driver

		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;

		String Statement = "UPDATE absence SET StudentNumber =" + s.get(1) + ", LectureID=" + s.get(2)
				+ ", StartDate= '" + s.get(3) + "', EndDate= '" + s.get(4) + "', StartTime = '" + s.get(5)
				+ "', EndTime = '" + s.get(6) + "', Reason = '" + s.get(7) + "', Approved = " + s.get(8) + ", Type = '"
				+ s.get(9) + "' WHERE id = " + s.get(0) + ";";
		System.out.println(Statement);
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();

	}

	public static void DeleteAbsence(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		PreparedStatement ps = c.prepareStatement("DELETE FROM absence WHERE id =" + id);
		ps.executeUpdate();
	}

	public static void saveSingleAbsence(List<String> absenceDetails) throws Exception {
		// making a connection to the JDBC Driver
		Class.forName("com.mysql.jdbc.Driver");

		// making a connection with the Medical Timetable Database
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		// creating the preparedStatement to be used in the below method
		PreparedStatement singleAbsenceStatement = null;

		// creating the SQL Query to add details for Single Absence
		String Statement = "INSERT INTO absence (StudentNumber, LectureID, StartDate, EndDate, StartTime, EndTime, Reason, Approved, type)"
				+ "VALUES (" + absenceDetails.get(0) + ", " + absenceDetails.get(1) + ", '" + absenceDetails.get(2)
				+ "', '" + absenceDetails.get(3) + "', '" + absenceDetails.get(4) + "', '" + absenceDetails.get(5)
				+ "', " + absenceDetails.get(6) + ", '" + absenceDetails.get(7) + "', '" + absenceDetails.get(8)
				+ "');";
		// printing the SQL statement to Console to ensure it is correctly
		// prepared
		System.out.println(Statement);
		// assigning the SQL query to the prepareStatement method
		singleAbsenceStatement = connection.prepareStatement(Statement);
		// using the executeUpdate method we now update the database with the
		// Absence
		singleAbsenceStatement.executeUpdate();
	}

}
