package uk.ac.qub.sql;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import application.Main;
import uk.ac.qub.objects.Room;

public class RoomSQL {

/**
 * This method will upload a list of rooms to the SQL database from a list of Rooms created in a seperate method
 * @param rooms
 * @throws Exception
 */
	public static void saveSQLRooms(List<Room> rooms) throws Exception {


		PreparedStatement statement = null;
		String newStatement = null;

		for (Room r : rooms) {
			String code = r.getCode();
			String name = r.getName();
			try {
				newStatement = "INSERT INTO LectureLocation " + "VALUES ('" + code + "', '" + name + "')";
				statement = Main.connection.prepareStatement(newStatement);
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * This method allows both the room name and room code to be updated from an old room code
	 * @param list
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void amendRoom(List<String> list) throws ClassNotFoundException, SQLException{
		
		PreparedStatement preparedStatement = null;
		String statement = "UPDATE LectureLocation SET room_code = '"+list.get(0)+"',room_location = '"+list.get(1)+"' WHERE room_code ='"+list.get(2)+"';";
		preparedStatement = Main.connection.prepareStatement(statement);
		preparedStatement.executeUpdate();
	}
	
	/**
	 * This method will delete a room from the SQL database using the roomcode
	 * @param roomCode
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void deleteRoom(String roomCode) throws ClassNotFoundException, SQLException{
		

		PreparedStatement statement = Main.connection.prepareStatement("DELETE FROM LectureLocation WHERE room_code ='"+roomCode+"';");
	
		statement.executeUpdate();
	}

}
