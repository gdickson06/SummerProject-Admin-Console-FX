package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;




public class CoordinatorSQL {
	
	public static void amendCoordinator(List<String> s,Boolean b) throws Exception {
		String Statement;
		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;
		if(b){
		Statement = "UPDATE course_coordinator SET Name ='" + s.get(1) + "', Email='" + s.get(2)+ "', Password='"+s.get(3)+ "', Module='"  + s.get(4) + "'" + " WHERE Username = "
				+ s.get(0) + ";";
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();
		} else {
			System.out.println("stage 2");
			Statement = "INSERT INTO staff " + "VALUES ('" + s.get(0) + "', '" + s.get(1) + "', '" + s.get(5) + "', '" +s.get(3)
			+ "')";
			statement = connection.prepareStatement(Statement);
			
			
			PreparedStatement ps = connection.prepareStatement("DELETE FROM course_coordinator WHERE Username =" + s.get(0));
			ps.executeUpdate();
		}
		
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();
	}

	public static void UploadSingleCoordinator(List<String> s) throws Exception {
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
	
	public static void DeleteCoordinator(String name) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		PreparedStatement ps = c.prepareStatement("DELETE FROM course_coordinator WHERE Username =" + name);
		ps.executeUpdate();
	}

}
