package uk.ac.qub.sql;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;

import application.ApplicationMethods;
import application.Main;
import uk.ac.qub.objects.Note;


public class NoteSQL {

/**
 * This method takes in a list of Strings which will be used to amend a Note
 * The id is the first in the list followed by date, year and the text of the note
 * @param n
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public static void amendNote(Note n) throws ClassNotFoundException, SQLException{
		
		PreparedStatement preparedStatement = null;
		String statement = "UPDATE Notes SET date = '"+n.getDate()+"',year_group = "+n.getYear()+", note_text='"+n.getDetails()+"' WHERE id ="+n.getId()+";";
	preparedStatement = Main.connection.prepareStatement(statement);
		preparedStatement.executeUpdate();
		
	}
	
/**
 * This method will delete a note from the SQL database it takes in a String which
 * will be used to find the id of the Note
 * @param id
 * @throws ClassNotFoundException
 * @throws SQLException
 */
	public static void deleteNote(String id) throws ClassNotFoundException, SQLException{
	

		PreparedStatement statement = Main.connection.prepareStatement("DELETE FROM Notes WHERE id ="+id+";");
		
		statement.executeUpdate();
	}
	
/**
 * This method will upload a new note from a List of Strings
 * @param n1
 * @throws Exception
 */
	public static void UploadNote(Note n1) throws Exception {


		PreparedStatement statement = null;

		String Statement = "INSERT INTO Notes (date, year_group, note_text) " + "VALUES ('" + n1.getDate() + "', '" + n1.getYear() + "', '" + n1.getDetails() +"')";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}
/**
 * This method will return a list of notes which are active after a certain date
 * @return
 * @throws SQLException 
 */
	public static List<Note> ActiveNotes() throws SQLException {
		ResultSet r;
		String statement = "SELECT * FROM Notes where date>='" + ApplicationMethods.dtf.format(LocalDate.now())+"'";
		List<Note> notes = new ArrayList<Note>();

		

		r = SQL.SQLstatements(statement);
		System.out.println(statement);
		try {
			if (r.next()) {

				do {
					Note n = new Note(r.getInt("id"), r.getInt("year_group"), r.getString("date"),
							r.getString("note_text"));
					notes.add(n);
				} while (r.next());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return notes;
	}


}
