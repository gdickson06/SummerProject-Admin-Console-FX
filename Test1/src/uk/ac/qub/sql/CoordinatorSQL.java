package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;




public class CoordinatorSQL {

	public static void UploadSingleStaff(List<String> s) throws Exception {
		// This will be in the order of the name,group,email,year.
		// Using the JDBC driver

		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;

		String Statement = "INSERT INTO course_coordinator " + "VALUES ('" + s.get(0) + "', '" + s.get(1) + "', '" + s.get(2) + "', '" +s.get(3)
				+ "', '"+s.get(4)+"')";
		System.out.println(Statement);
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();

	}

}
