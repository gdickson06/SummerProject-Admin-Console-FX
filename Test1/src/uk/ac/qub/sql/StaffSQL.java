package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import application.Main;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Staff;

/**
 * Name of Package - uk.ac.qub.sql
 * Date Last Amended - 08/09/17 
 * Outline - This class will contain all of the methods to amend, 
 * delete, save single and save multiple staff members  along 
 * with any other methods to amend parts of staff members
 * Demographics – 189 LOC 7 Methods
 */

public class StaffSQL {
	/**
	 * This method spans uploading users and coordinators
	 * 
	 * @param users
	 * @throws Exception
	 */

	public static void saveSQLUsers(List<Staff> users) throws Exception {

		PreparedStatement statement = null;
		String newStatement = null;

		for (Staff s : users) {
			String staffNumber = s.getStaff_number();
		
			String name = s.getName().replaceAll("'", "''");
			String accessLevel = s.getAccess_level().replaceAll("'", "''");

			{

				newStatement = "INSERT INTO Staff VALUES (" + staffNumber + ", '" + name + "', '" + accessLevel + "');";

			}

			statement = Main.connection.prepareStatement(newStatement);
			statement.executeUpdate();

		}

	}

	/**
	 * This method will amend a single staff member
	 * 
	 * @param s
	 * @throws Exception
	 */
	public static void amendUser(Staff s) throws Exception {

		String Statement;
		PreparedStatement statement = null;

		Statement = "UPDATE Staff SET name ='" + s.getName().replaceAll("'", "''") + "', access_level='" + s.getAccess_level()
				+ "' WHERE staff_number =" + s.getStaff_number() + ";";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}

	/**
	 * This method will delete a single user
	 * 
	 * @param name
	 * @throws Exception
	 */
	public static void DeleteUser(String snumber) throws Exception {

		PreparedStatement ps = Main.connection.prepareStatement("DELETE FROM Staff WHERE staff_number =" + snumber);
		ps.executeUpdate();
	}

	/**
	 * This method will read in a single staff object to the database
	 * 
	 * @param s
	 * @throws Exception
	 */

	public static void UploadSingleUser(Staff s) throws Exception {

		PreparedStatement statement = null;

		String Statement = "INSERT INTO Staff " + "VALUES (" + s.getStaff_number() + ", '" + s.getName().replaceAll("'", "''") + "', '"
				+ s.getAccess_level() + "')";

		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}

	/**
	 * This method will check to see if staff can be logged in to the app, it
	 * will check this in three different areas The first is that the username
	 * and password is correct according to the qsis, If this is correct the
	 * person logged on is a staff member and not a student If this person is a
	 * staff member they have full admin privileges however this will be done
	 * outside of the method by checking the Staff which is returned by this
	 * method
	 * 
	 * @param Username
	 * @param Password
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public static Staff login(String Username, String Password) throws SQLException, ClassNotFoundException {
		ResultSet results = null;
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(SQL.QsisUrl, SQL.QsisUser, SQL.QsisPassword);
		} catch (Exception e) {
			GeneralMethods.show("Database connection error, please check your internet connection", "Error");
		}
		
		Statement statement = connection.createStatement();

		results = statement.executeQuery("select * from Qsis WHERE user_number = " + Username + " AND password ='" + Password + "'");

	
		Staff answer = null;
		String Usernumber = null;

		
		 if (results.next() == false) {
		        GeneralMethods.show("Username or password incorrect", "Warning");
		      } else {

		     
		        	Usernumber = results.getString("user_number");
		     }
		

		// If Usernumber is no longer null the correct username and password has
		// been entered
		if (Usernumber != null) {
			String statement2 = "select * from Staff WHERE staff_number = " + Username + ";";
			ResultSet results2 = SQL.SQLstatements(statement2);

			if(!results2.next()){
				GeneralMethods.show("User not registered as staff within the admin console, please contact a current"
						+ " admin user to add you" , "Warning");
			}else {

			answer = new Staff(results2.getString("staff_number"), results2.getString("name"),
					results2.getString("access_level"));

		}
		
		}
		return answer;
	}
@Deprecated
	/**
	 * This method allows for a password to be changed this is now deprecated
	 * as we will be using the QSis system to change passwords and will not be allowing
	 * this to be done through this applicaiton
	 * @param username
	 * @param newPassword
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void changePassword(String username, String newPassword) throws ClassNotFoundException, SQLException {

		
		PreparedStatement preparedStatement = null;
	
		String statement = "UPDATE Qsis SET password = '" + newPassword + "' WHERE user_number =" + username + ";";
	
		preparedStatement = Main.connection.prepareStatement(statement);
		preparedStatement.executeUpdate();

	}

}
