package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import uk.ac.qub.objects.Student;

public class StudentSQL {



	


	
	public static void saveSQLStudents(List<Student> students,String year) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;
		String newStatement = null;

		for (Student s : students) {
			int studentNumber = s.getStudentNumber();
			String name = s.getName();
			String group = s.getFirstGroup();
			String email = s.getEmail();
			String intakeYear = year;
		
			newStatement = "INSERT INTO students " + "VALUES (" + studentNumber + ", '" + name + "', '" + group + "', '"
					+ email + "', " + intakeYear + ", '"+SQL.defaultPassword+"');";
			System.out.println(newStatement);
			statement = connection.prepareStatement(newStatement);
			statement.executeUpdate();

		}
		
		

	}
	


	public static void AmendStudent(List<String> s) throws Exception {
		// This will be in the order of the studentNumber,name,group,email,year.
		// Using the JDBC driver

		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;

		String Statement = "UPDATE students SET Name ='" + s.get(1) + "', Cohort='" + s.get(2) + "', StudentEmail= '"
				+ s.get(3) + "', IntakeYear = " + s.get(4) + " WHERE StudentNumber = " + s.get(0) + ";";
		System.out.println(Statement);
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();

	}
	
	public static void UploadSingleStudent(List<String> s) throws Exception {
		// This will be in the order of the name,group,email,year.
		// Using the JDBC driver

		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;

		String Statement = "INSERT INTO students " + "VALUES (" + s.get(0) + ", '" + s.get(1) + "', '" + s.get(2)
				+ "', '" + s.get(3) + "', " + s.get(4) + ", '"+SQL.defaultPassword+"')";
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();

	}
	
	public static void DeleteStudent(String StudentNumber) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		PreparedStatement ps = c.prepareStatement("DELETE FROM students WHERE StudentNumber =" + StudentNumber);
		ps.executeUpdate();
	}






}
