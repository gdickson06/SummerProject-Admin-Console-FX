package uk.ac.qub.sql;

import java.sql.PreparedStatement;
import java.util.List;

import application.Main;
import uk.ac.qub.objects.Student;

public class StudentSQL {



	

/**
 * This method will read in a list of Students created in a different method and upload them to the database
 * @param students
 * @param year
 * @throws Exception
 */
	
	public static void saveSQLStudents(List<Student> students,String year) throws Exception {
		int studentNumber;
		String lastName,firstName,middleName,prefix,name,cohort,email,nationality,graduate,comments,portfolio;
		

		PreparedStatement statement = null;
		String newStatement = null;

		for (Student s : students) {
			studentNumber =s.getStudentNumber();
			
			lastName = s.getLastName();
			firstName=s.getFirstName();
			middleName=s.getMiddleName();
			prefix=s.getPrefix();
			name=s.getName();
			cohort=s.getCohort();
			email=s.getEmail();
			nationality=s.getNationality();
			graduate =s.getGraduate();
			comments=s.getComments();
			portfolio = s.getPortfolio();

		
			newStatement = "INSERT INTO Students " + "VALUES (" + studentNumber + ", '" + lastName+ "', '" + firstName+ "', '" + middleName + "', '" + prefix+ "', '" + name+ "', '" + cohort
					+ "', '"
					+ email + "', '" + nationality+ "', '" + graduate+ "', '" + comments + "', '" + portfolio+ "', " + year+ ");";
			statement = Main.connection.prepareStatement(newStatement);
			statement.executeUpdate();

		}
		
		

	}
	

/**
 * This method will amend a single Student from a List of Strings
 * @param s
 * @throws Exception
 */
	public static void AmendStudent(Student s) throws Exception {
		
//		studentNumber, lastName,firstName,middleName,prefix,name,cohort,email,nationality,graduate,comments,portfolio,year;
		PreparedStatement statement = null;

		String Statement = "UPDATE Students SET last_name ='" + s.getLastName() + "', first_name='" + s.getFirstName() + "', middle_name= '"
				+ s.getMiddleName() + "', prefix = '" + s.getPrefix() + "', name ='"+s.getName()+"', cohort = '"+s.getCohort()+"', email ='"+s.getEmail()+
				"', nationality = '" +s.getNationality()+"', graduate = '" + s.getGraduate()+"', comments ='"+ s.getComments() + "' portfolio = '" +
				s.getPortfolio()+"', year =" + s.getYear()+ " WHERE student_number = " + s.getStudentNumber() + ";";
		
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}

/**
 * This method will use a Student to upload a single student 
 * @param s
 * @throws Exception
 */
	public static void UploadSingleStudent(Student s) throws Exception {
//		studentNumber, lastName,firstName,middleName,prefix,name,cohort,email,nationality,graduate,comments,portfolio,year;

	
		PreparedStatement statement = null;

		String Statement = "INSERT INTO students " + "VALUES (" + s.getStudentNumber() + ", '" + s.getLastName() + "', '" + s.getFirstName()
				+ "', '" + s.getMiddleName() + "', " +s.getPrefix() + ", '"+s.getName()+ ", '"+s.getCohort()+ ", '"+s.getEmail()+ ", '"+s.getNationality()
				+ ", '"+s.getGraduate()+ ", '"+s.getComments()+ ", '"+s.getPortfolio()+ ", "+s.getYear()+")";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}
/**
 * This method will Delete a single student from the database	
 * @param StudentNumber
 * @throws Exception
 */
	public static void DeleteStudent(String StudentNumber) throws Exception {
	
		PreparedStatement ps = Main.connection.prepareStatement("DELETE FROM Students WHERE student_number =" + StudentNumber);
		ps.executeUpdate();
	}
/**
 * This method will Delete all Students in an Intake Year
 * @param Year
 * @throws Exception
 */
	public static void DeleteYearStudent(String Year) throws Exception {
		
		PreparedStatement ps = Main.connection.prepareStatement("DELETE FROM Students WHERE year_group =" + Year);
		ps.executeUpdate();
	}




}
