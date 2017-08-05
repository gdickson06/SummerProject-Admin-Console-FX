package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import application.Main;
import uk.ac.qub.objects.Room;

public class RoomSQL {


	public static void saveSQLRooms(List<Room> rooms) throws Exception {


		PreparedStatement statement = null;
		String newStatement = null;

		for (Room r : rooms) {
			String code = r.getCode();
			String name = r.getName();
			try {
				newStatement = "INSERT INTO location " + "VALUES ('" + code + "', '" + name + "')";
				statement = Main.connection.prepareStatement(newStatement);
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void amendRoom(List<String> list) throws ClassNotFoundException, SQLException{
		
		//creating prepared statement
		PreparedStatement preparedStatement = null;
		//creating statement to pass through preparedStatement containing our SQL query
		String statement = "UPDATE location SET roomCode = '"+list.get(0)+"',roomName = '"+list.get(1)+"' WHERE roomCode ='"+list.get(2)+"';";
		//printing the statement to console for testing purposes
		System.out.println(statement);
		//passing string SQL query into the prepared statement
		preparedStatement = Main.connection.prepareStatement(statement);
		//executing preparedStatement with executeUpdate method (SQL Query essentially is being executed)
		preparedStatement.executeUpdate();
	}
	
	public static void deleteRoom(String roomCode) throws ClassNotFoundException, SQLException{
		
		//creating prepared statement to delete room
		PreparedStatement statement = Main.connection.prepareStatement("DELETE FROM location WHERE roomCode ='"+roomCode+"';");
		//executing the PreparedStatement/SQL Deletion QUery
		statement.executeUpdate();
	}

}
