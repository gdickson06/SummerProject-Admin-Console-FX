package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import application.Main;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.Staff;

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
			System.out.println("staffNumber = " + staffNumber);
			String name = s.getName();
			String accessLevel = s.getAccess_level();

			{

				newStatement = "INSERT INTO Staff VALUES (" + staffNumber + ", '" + name + "', '" + accessLevel + "');";

			}
System.out.println(newStatement);
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

		Statement = "UPDATE Staff SET name ='" + s.getName() + "', access_level='" + s.getAccess_level()
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
		System.out.println(ps);
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

		String Statement = "INSERT INTO Staff " + "VALUES (" + s.getStaff_number() + ", '" + s.getName() + "', '"
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

		Staff answer = null;
		String Usernumber = null;

		String statement = "select * from Qsis WHERE user_number = " + Username + " AND password ='" + Password + "'";
		ResultSet results = SQL.SQLstatements(statement);

		results.next();
		Usernumber = results.getString("user_number");

		// If Usernumber is no longer null the correct username and password has
		// been entered
		if (Usernumber != null) {
			String statement2 = "select * from Staff WHERE staff_number = " + Username + ";";
			ResultSet results2 = SQL.SQLstatements(statement2);

			results2.next();

			answer = new Staff(results2.getString("staff_number"), results2.getString("name"),
					results2.getString("access_level"));

		} else {
			GeneralMethods.show("Students should not be using the admin console", "Access Denied");
		}
		return answer;
	}

	/**
	 * This method allows for a password to be changed 
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
