package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import uk.ac.qub.objects.Coordinator;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.User;

public class StaffSQL {

	public static void saveSQLStaff(List<Staff> users) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

	Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;
		String newStatement = null;

		for (Staff u : users) {
			String username = u.getStaffNumber();
			String name = u.getName();
			String password = u.getPassword();
			
			try {
				if(u instanceof Coordinator){
					String email = ((Coordinator) u).getEmail();
					String module = ((Coordinator) u).getModule();
				newStatement = "INSERT INTO course_coordinator " + "VALUES ('" + username + "', '" + name+ "', '" + email + "', '" + password + "', '"+module+"')";
				} else {
					String type = ((User)u).getType();
					newStatement = "INSERT INTO staff " + "VALUES ('" + username + "', '" + name+ "', '" + type + "', '" + password + "')";
					
				}
				
				statement = connection.prepareStatement(newStatement);
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

	}
	public static void amendStaff(List<String> s) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;

		String Statement = "UPDATE users SET Name =" + s.get(1) + ", Password='" + s.get(2)+ ", Type='" + s.get(3) + "'" + " WHERE UserName = "
				+ s.get(0) + ";";
		System.out.println(Statement);
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();
	}
	
	public static void DeleteStaff(String name) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		PreparedStatement ps = c.prepareStatement("DELETE FROM users WHERE UserName =" + name);
		ps.executeUpdate();
	}
	
	public static void UploadSingleStaff(List<String> s) throws Exception {
		// This will be in the order of the name,group,email,year.
		// Using the JDBC drivers

		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;

		String Statement = "INSERT INTO staff " + "VALUES ('" + s.get(0) + "', '" + s.get(1) + "', '" + s.get(2) + "', '" +s.get(3)
				+ "')";
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();

	}
}
