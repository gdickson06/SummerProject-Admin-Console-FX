package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import uk.ac.qub.objects.Coordinator;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.User;

public class StaffSQL {
	/**
	 * This method spans uploading users and coordinators
	 * @param users
	 * @throws Exception
	 */
			
	public static void saveSQLUsers(List<Staff> users) throws Exception {
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
	public static void amendUser(List<String> s, Boolean b) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		String Statement;
		PreparedStatement statement = null;
		if(b){
		 Statement = "UPDATE staff SET Name ='" + s.get(1) + "', Password='" + s.get(3)+ "', Type='" + s.get(5) + "'" + " WHERE StaffNumber = "
				+ s.get(0) + ";";
		System.out.println(Statement);
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();
		} else {
			System.out.println("POWER ON");
			Statement = "INSERT INTO course_coordinator " + "VALUES ('" + s.get(0) + "', '" + s.get(1) + "', '" + s.get(2) + "', '" +s.get(3)
			+ "', '"+s.get(4)+"')";
			statement = connection.prepareStatement(Statement);
			statement.executeUpdate();
			PreparedStatement ps = connection.prepareStatement("DELETE FROM staff WHERE StaffNumber =" + s.get(0));
			ps.executeUpdate();
		}
	}
	

	public static void DeleteUser(String name) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		PreparedStatement ps = c.prepareStatement("DELETE FROM staff WHERE StaffNumber =" + name);
		ps.executeUpdate();
	}
	
	
	
	public static void UploadSingleUser(List<String> s) throws Exception {
		// This will be in the order of the name,group,email,year.
		// Using the JDBC driver

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
