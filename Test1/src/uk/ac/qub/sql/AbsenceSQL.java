package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class AbsenceSQL {

	public static void AmendAbsence(List<String> s) throws Exception {
		// This will be in the order of the id,Studentnumber,lectureid,date,time,reason,approved,type
		// Using the JDBC driver

		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;

		String Statement = "UPDATE absence SET StudentNumber =" + s.get(1) + ", LectureID=" + s.get(2) + ", Date= '"
				+ s.get(3) + "', Time = '" + s.get(4) +"', Reason = '" + s.get(5) +"', Approved = " + s.get(6) + ", Type = '" + s.get(7) + "' WHERE id = " + s.get(0) + ";";
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

}
