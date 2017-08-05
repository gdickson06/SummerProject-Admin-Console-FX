package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import application.Main;




public class CoordinatorSQL {
	
	public static void amendCoordinator(List<String> s,Boolean b) throws Exception {
		String Statement;
	

		PreparedStatement statement = null;
		if(b){
		Statement = "UPDATE course_coordinator SET Name ='" + s.get(1) + "', Email='" + s.get(2)+ "', Password='"+s.get(3)+ "', Module='"  + s.get(4) + "'" + " WHERE Username = "
				+ s.get(0) + ";";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();
		} else {
			System.out.println("stage 2");
			Statement = "INSERT INTO staff " + "VALUES ('" + s.get(0) + "', '" + s.get(1) + "', '" + s.get(5) + "', '" +s.get(3)
			+ "')";
			statement = Main.connection.prepareStatement(Statement);
			
			
			PreparedStatement ps = Main.connection.prepareStatement("DELETE FROM course_coordinator WHERE Username =" + s.get(0));
			ps.executeUpdate();
		}
		
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();
	}

	public static void UploadSingleCoordinator(List<String> s) throws Exception {
		

		PreparedStatement statement = null;

		String Statement = "INSERT INTO course_coordinator " + "VALUES ('" + s.get(0) + "', '" + s.get(1) + "', '" + s.get(2) + "', '" +s.get(3)
				+ "', '"+s.get(4)+"')";
		System.out.println(Statement);
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}
	
	public static void DeleteCoordinator(String name) throws Exception {
		
		PreparedStatement ps = Main.connection.prepareStatement("DELETE FROM course_coordinator WHERE Username =" + name);
		ps.executeUpdate();
	}

}
