package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import uk.ac.qub.objects.Room;

public class RoomSQL {


	public static void saveSQLRooms(List<Room> rooms) throws Exception {

		Class.forName("com.mysql.jdbc.Driver");

		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;
		String newStatement = null;

		for (Room r : rooms) {
			String code = r.getCode();
			String name = r.getName();
			try {
				newStatement = "INSERT INTO location " + "VALUES ('" + code + "', '" + name + "')";
				statement = connection.prepareStatement(newStatement);
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
