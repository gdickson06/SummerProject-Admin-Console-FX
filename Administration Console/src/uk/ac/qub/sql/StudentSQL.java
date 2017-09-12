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
import uk.ac.qub.objects.Student;

/**
 * Name of Package - uk.ac.qub.sql Date Last Amended - 08/09/17 Outline - This
 * class will contain all of the methods to amend, delete, save single and save
 * multiple students along with any other methods to amend parts of students
 * Demographics – 166 LOC 6 Methods
 */
public class StudentSQL {

	/**
	 * This method will read in a list of Students created in a different method
	 * and upload them to the database it is assumed this spreadsheet will be
	 * created from an existing list on Qsis, which means there is no check
	 * whether the student is on the Qsis system
	 * 
	 * @param students
	 * @param year
	 * @throws Exception
	 */

	public static void saveSQLStudents(List<Student> students, String year) throws Exception {
		int studentNumber;
		String lastName, firstName, middleName, prefix, name, cohort, email, nationality, graduate, comments, portfolio;

		PreparedStatement statement = null;
		String newStatement = null;

		for (Student s : students) {
			studentNumber = s.getStudentNumber();

			lastName = s.getLastName().replaceAll("'", "''");
			firstName = s.getFirstName().replaceAll("'", "''");
			middleName = s.getMiddleName().replaceAll("'", "''");
			prefix = s.getPrefix().replaceAll("'", "''");
			name = s.getName().replaceAll("'", "''");
			cohort = s.getCohort().replaceAll("'", "''");
			email = s.getEmail().replaceAll("'", "''");
			nationality = s.getNationality().replaceAll("'", "''");
			graduate = s.getGraduate().replaceAll("'", "''");
			comments = s.getComments().replaceAll("'", "''");
			portfolio = s.getPortfolio().replaceAll("'", "''");

			newStatement = "INSERT INTO Students " + "VALUES (" + studentNumber + ", '" + lastName + "', '" + firstName
					+ "', '" + middleName + "', '" + prefix + "', '" + name + "', '" + cohort + "', '" + email + "', '"
					+ nationality + "', '" + graduate + "', '" + comments + "', '" + portfolio + "', " + year + ");";
			statement = Main.connection.prepareStatement(newStatement);
			statement.executeUpdate();

		}

	}

	/**
	 * This method will amend a single Student from a List of Strings
	 * 
	 * @param s
	 * @throws Exception
	 */
	public static void AmendStudent(Student s) throws Exception {

		// studentNumber,
		// lastName,firstName,middleName,prefix,name,cohort,email,nationality,graduate,comments,portfolio,year;
		PreparedStatement statement = null;

		String Statement = "UPDATE Students SET last_name ='" + s.getLastName().replaceAll("'", "''")
				+ "', first_name='" + s.getFirstName().replaceAll("'", "''") + "', middle_name= '"
				+ s.getMiddleName().replaceAll("'", "''") + "', prefix = '" + s.getPrefix().replaceAll("'", "''")
				+ "', name ='" + s.getName() + "', cohort = '" + s.getCohort().replaceAll("'", "''") + "', email ='"
				+ s.getEmail().replaceAll("'", "''") + "', nationality = '" + s.getNationality().replaceAll("'", "''")
				+ "', graduate = '" + s.getGraduate().replaceAll("'", "''") + "', comments ='"
				+ s.getComments().replaceAll("'", "''") + "', portfolio = '" + s.getPortfolio().replaceAll("'", "''")
				+ "', year_group =" + s.getYear() + " WHERE student_number = " + s.getStudentNumber() + ";";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}

	/**
	 * This method will use a Student to upload a single student
	 * 
	 * @param s
	 * @throws Exception
	 */
	public static boolean UploadSingleStudent(Student s) throws Exception {
		boolean complete = true;
		PreparedStatement statement = null;
		Boolean exists = StudentInQsis(String.valueOf(s.getStudentNumber()));
		if(exists){
		String Statement = "INSERT INTO Students " + "VALUES (" + s.getStudentNumber() + ", '"
				+ s.getLastName().replaceAll("'", "''") + "', '" + s.getFirstName().replaceAll("'", "''") + "', '"
				+ s.getMiddleName().replaceAll("'", "''") + "', '" + s.getPrefix().replaceAll("'", "''") + "', '"
				+ s.getName().replaceAll("'", "''") + "', '" + s.getCohort().replaceAll("'", "''") + "', '"
				+ s.getEmail().replaceAll("'", "''") + "', '" + s.getNationality().replaceAll("'", "''") + "', '"
				+ s.getGraduate().replaceAll("'", "''") + "', '" + s.getComments().replaceAll("'", "''") + "', '"
				+ s.getPortfolio().replaceAll("'", "''") + "', " + s.getYear() + ")";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();
		} else {
			complete=false;
		}
		return complete;
	}

	/**
	 * This method will Delete a single student from the database
	 * 
	 * @param StudentNumber
	 * @throws Exception
	 */
	public static void DeleteStudent(String StudentNumber) throws Exception {

		PreparedStatement ps = Main.connection
				.prepareStatement("DELETE FROM Students WHERE student_number =" + StudentNumber);
		ps.executeUpdate();
	}

	/**
	 * This method will Delete all Students in an Intake Year
	 * 
	 * @param Year
	 * @throws Exception
	 */
	public static void DeleteYearStudent(String Year) throws Exception {

		PreparedStatement ps = Main.connection.prepareStatement("DELETE FROM Students WHERE year_group =" + Year);
		ps.executeUpdate();
	}

	private static Boolean StudentInQsis(String StudentNumber) throws SQLException {
		Boolean exists = false;
		ResultSet results = null;
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(SQL.QsisUrl, SQL.QsisUser, SQL.QsisPassword);
		} catch (Exception e) {
			GeneralMethods.show("Database connection error, please check your internet connection", "Error");
		}

		Statement statement = connection.createStatement();

		results = statement.executeQuery("select * from Qsis WHERE user_number = " + StudentNumber);

		if (results.next() == false) {
			GeneralMethods.show("Student not registered in Qsis", "Error");
		} else {
			exists = true;
		}
		
		return exists;
	}

}
