package uk.ac.qub.sql;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import application.Main;
import uk.ac.qub.objects.Room;
/**
 * Name of Package - uk.ac.qub.sql
 * Date Last Amended - 08/09/17 
 * Outline - This class will contain all of the methods to amend, 
 * delete, save single and save multiple rooms along with any other methods to amend
 * parts of rooms
 * Demographics – 75 LOC 3 Methods
 */
public class RoomSQL {

	/**
	 * This method will upload a list of rooms to the SQL database from a list
	 * of Rooms created in a seperate method
	 * 
	 * @param rooms
	 * @throws Exception
	 */
	public static void saveSQLRooms(List<Room> rooms) throws Exception {

		PreparedStatement statement = null;
		String newStatement = null;

		for (Room r : rooms) {
			String code = r.getCode().replaceAll("'", "''");
			String name = r.getName().replaceAll("'", "''");

			newStatement = "INSERT INTO LectureLocation " + "VALUES ('" + code + "', '" + name + "')";
			statement = Main.connection.prepareStatement(newStatement);
			statement.executeUpdate();

		}
	}

	/**
	 * This method allows both the room name and room code to be updated from an
	 * old room code
	 * 
	 * @param list
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void amendRoom(List<String> list) throws ClassNotFoundException, SQLException {

		PreparedStatement preparedStatement = null;
		String statement = "UPDATE LectureLocation SET room_code = '" + list.get(0).replaceAll("'", "''")
				+ "',room_location = '" + list.get(1).replaceAll("'", "''") + "' WHERE room_code ='"
				+ list.get(2).replaceAll("'", "''") + "';";
		preparedStatement = Main.connection.prepareStatement(statement);
		preparedStatement.executeUpdate();
	}

	/**
	 * This method will delete a room from the SQL database using the roomcode
	 * 
	 * @param roomCode
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static void deleteRoom(String roomCode) throws ClassNotFoundException, SQLException {

		PreparedStatement statement = Main.connection
				.prepareStatement("DELETE FROM LectureLocation WHERE room_code ='" + roomCode + "';");

		statement.executeUpdate();
	}

}
