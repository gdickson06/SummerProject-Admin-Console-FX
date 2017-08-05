package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import application.Main;
import uk.ac.qub.objects.Student;

public class StudentSQL {



	


	
	public static void saveSQLStudents(List<Student> students,String year) throws Exception {

		

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
			statement = Main.connection.prepareStatement(newStatement);
			statement.executeUpdate();

		}
		
		

	}
	


	public static void AmendStudent(List<String> s) throws Exception {
		

		PreparedStatement statement = null;

		String Statement = "UPDATE students SET Name ='" + s.get(1) + "', Cohort='" + s.get(2) + "', StudentEmail= '"
				+ s.get(3) + "', IntakeYear = " + s.get(4) + " WHERE StudentNumber = " + s.get(0) + ";";
		System.out.println(Statement);
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}
	
	public static void UploadSingleStudent(List<String> s) throws Exception {
		// This will be in the order of the name,group,email,year.
		// Using the JDBC driver

	
		PreparedStatement statement = null;

		String Statement = "INSERT INTO students " + "VALUES (" + s.get(0) + ", '" + s.get(1) + "', '" + s.get(2)
				+ "', '" + s.get(3) + "', " + s.get(4) + ", '"+SQL.defaultPassword+"')";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}
	
	public static void DeleteStudent(String StudentNumber) throws Exception {
	
		PreparedStatement ps = Main.connection.prepareStatement("DELETE FROM students WHERE StudentNumber =" + StudentNumber);
		ps.executeUpdate();
	}

	public static void DeleteYearStudent(String Year) throws Exception {
		
		PreparedStatement ps = Main.connection.prepareStatement("DELETE FROM students WHERE IntakeYear =" + Year);
		ps.executeUpdate();
	}




}
