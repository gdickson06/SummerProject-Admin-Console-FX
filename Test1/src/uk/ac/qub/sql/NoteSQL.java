package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import application.ApplicationMethods;
import application.Main;
import uk.ac.qub.objects.Note;
import uk.ac.qub.objects.Student;

public class NoteSQL {

	public static void amendNote(List<String> list) throws ClassNotFoundException, SQLException{
		
		//creating prepared statement
		PreparedStatement preparedStatement = null;
		//creating statement to pass through preparedStatement containing our SQL query
		String statement = "UPDATE Notes SET dates = '"+list.get(1)+"',yearGroup = '"+list.get(2)+"', Notes='"+list.get(3)+"' WHERE id ="+list.get(0)+";";
		//printing the statement to console for testing purposes
		System.out.println(statement);
		//passing string SQL query into the prepared statement
		preparedStatement = Main.connection.prepareStatement(statement);
		//executing preparedStatement with executeUpdate method (SQL Query essentially is being executed)
		preparedStatement.executeUpdate();
		
	}
	
	public static void deleteNote(String id) throws ClassNotFoundException, SQLException{
	
		//creating prepared statement to delete room
		PreparedStatement statement = Main.connection.prepareStatement("DELETE FROM Notes WHERE id ="+id+";");
		//executing the PreparedStatement/SQL Deletion QUery
		statement.executeUpdate();
	}
	
	public static void UploadNote(List<String> s) throws Exception {


		PreparedStatement statement = null;

		String Statement = "INSERT INTO Notes (dates, yearGroup, Notes) " + "VALUES ('" + s.get(0) + "', '" + s.get(1) + "', '" + s.get(2) +"')";
		System.out.println(Statement);
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}
	
	public static List<Note> ActiveNotes() {
		ResultSet r;
		String statement = "SELECT * FROM Notes where dates>='" + ApplicationMethods.dtf.format(LocalDate.now())+"'";
		List<Note> notes = new ArrayList<Note>();

		

		r = SQL.SQLstatements(statement);
		System.out.println(statement);
		try {
			if (r.next()) {

				do {
					Note n = new Note(r.getInt("id"), r.getInt("yearGroup"), r.getString("dates"),
							r.getString("Notes"));
					notes.add(n);
				} while (r.next());

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notes;
	}


}
