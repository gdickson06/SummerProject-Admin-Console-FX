package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

		String Statement = "INSERT INTO staff " + "VALUES ('" + s.get(0) + "', '" + s.get(1) + "', '" + s.get(3) + "', '" +s.get(2)
				+ "')";
		
		System.out.println(Statement);
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();
		
		connection.close();

	}
	
	public static Staff login (String Username, String Password) throws SQLException, ClassNotFoundException{
	
		
		Staff answer = null;

	
		
		String statement = "select * from staff WHERE StaffNumber = "+Username+" AND Password ='"+Password+"'";
		ResultSet results = SQL.SQLstatements(statement);
		
		System.out.println(statement);
		
		try{
			results.next();
			answer= new User(results.getString("Name"),results.getString("StaffNumber"),results.getString("Password"),results.getString("Type"));
		} catch (Exception e){
			
		}
		
		String statement2 = "select * from course_coordinator WHERE Username = "+Username+" AND Password ='"+Password+"'";
		ResultSet results2 = SQL.SQLstatements(statement2);
		System.out.println(statement2);
		try{
		results2.next();
		System.out.println(results2.getString("Name"));
		answer = new Coordinator(results2.getString("Name"),results2.getString("Username"),results2.getString("Password"),results2.getString("Module"),results2.getString("Email"));
		} catch (Exception e){
			
		}
		
		return answer;
	}
	public static void changePassword(String username, String newPassword) throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.jdbc.Driver");
		
		//Creating a connection with the database below
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		//creating prepared statement
		PreparedStatement preparedStatement = null;
		//creating statement to pass through preparedStatement containing our SQL query
		String statement = "UPDATE staff SET Password = '"+newPassword+"' WHERE StaffNumber ="+username+";";
		//printing the statement to console for testing purposes
		System.out.println(statement);
		//passing string SQL query into the prepared statement
		preparedStatement = connection.prepareStatement(statement);
		//executing preparedStatement with executeUpdate method (SQL Query essentially is being executed)
		preparedStatement.executeUpdate();
		connection.close();
	}
	
}
