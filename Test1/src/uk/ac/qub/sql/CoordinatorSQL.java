package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import uk.ac.qub.objects.Lecturer;

public class CoordinatorSQL {

	public void saveSQLLecturer(List<Lecturer> lecturers) throws Exception {

		// Using the JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;

		for (Lecturer l : lecturers) {
			String name = l.getName();
			String email = l.getEmail();
			String module = l.getModule();

			name = name.replaceAll("'", "''");
			email = email.replaceAll("'", "''");
			String statements = null;
			try {
				statements = "INSERT INTO lecturers" + "VALUES ('" + name + "', '" + email + "', '" + module + "')";
				statement = connection.prepareStatement(statements);
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

}
