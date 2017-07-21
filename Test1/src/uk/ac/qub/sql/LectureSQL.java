package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import uk.ac.qub.churst.ConvertGroup;
import uk.ac.qub.objects.Lecture;

public class LectureSQL {


	public static void saveSQLLecture(List<Lecture> lectures) throws Exception {
		
		// Using the JDBC driver
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;

		for (Lecture l : lectures) {
			int week = l.getWeek();
			String day = l.getDay();
			String startDate = ConvertGroup.DateConvertSQL(l.getStartDate());
			String startTime = l.getStartTime();
			String endTime = l.getEndTime();
			String groups = l.getGroup();
			String location = l.getLocation();
			String subject = l.getSubject();
			String theme = l.getTheme();
			String format = l.getTeachingFormat();
			String description = l.getDescription();
			String staff = l.getStaff();
			String style = l.getStyle();
			String module = l.getModule();

			description = description.replaceAll("'", "''");
			staff = staff.replaceAll("'", "''");
			startTime = startTime.replaceAll("'", "''");
			String statements = null;
			try {
				ConvertGroup.convert(groups);
				statements = "INSERT INTO lectures (Week, Day, StartDate, StartTime, EndTime, Groups, Location, Subject, Theme, Teaching, Description, Staff, Style, Module)"
						+ "VALUES (" + week + ", '" + day + "', " + startDate + ", '" + startTime + "','" + endTime
						+ "', '" + groups + "', '" + location + "', '" + subject + "', '" + theme + "', '" + format
						+ "', '" + description + "', '" + staff + "', '" + style + "', '" + module + "');";

				System.out.println(statements);
				statement = connection.prepareStatement(statements);
				statement.executeUpdate();
			} catch (Exception e) {

				System.err.println("Issue with groups, please check the syntax for week" + l.getWeek() + " day "
						+ l.getDay() + " startTime " + l.getStartTime() + " the groups input is " + l.getGroup());
			}

		}
		SQL.GroupsToGroup(lectures);
	}
	


	public static void AmendLecture(List<String> s) throws Exception {
		// This will be in the order of the
		// id,week,day,StartDate,StartTime,EndTime,Groups,Location,Subject,Theme,Teaching,Description,Staff
		// Using the JDBC driver

		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;

		String Statement = "UPDATE lectures SET week =" + s.get(1) + ", Day='" + s.get(2) + "', StartDate= '" + s.get(3)
				+ "', StartTime= '" + s.get(4) + "', EndTime= '" + s.get(5) + "', Groups= '" + s.get(6)
				+ "', Location= '" + s.get(7) + "', Subject= '" + s.get(8) + "', Theme= '" + s.get(9) + "', Teaching= '"
				+ s.get(10) + "', Description= '" + s.get(11) + "', Staff= '" + s.get(12) + "', Style = '" + s.get(13)
				+ "', Module = '" + s.get(14) + "' WHERE id = " + s.get(0) + ";";
		System.out.println(Statement);
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();

	}
	

	public static void DeleteLecture(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		PreparedStatement ps = c.prepareStatement("DELETE FROM lectures WHERE id =" + id);
		ps.executeUpdate();
	}

	public static void UploadSingleLecture(List<String> s) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;
		// This will be in the order of the
		

		String Statement = "INSERT INTO lectures (Week, Day, StartDate, StartTime, EndTime, Groups, Location, Subject, Theme, Teaching, Description, Staff, Style, Module, Essential, Year, Notes)"
				+ "VALUES (" + s.get(0) + ", '" + s.get(1) + "', '" + s.get(2) + "', '" + s.get(3) + "','" + s.get(4)
				+ "', '" + s.get(5) + "', '" + s.get(6) + "', '" + s.get(7) + "', '" + s.get(8) + "', '" + s.get(9)
				+ "', '" + s.get(10) + "', '" + s.get(11) + "', '" + s.get(12) + "', '" + s.get(13) + "', "+s.get(14)+", '"+s.get(15)+"', '"+s.get(16)+"');";
		System.out.println(Statement);
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();
	}
	
	public static void UploadNote(String id,String note) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;

		String Statement = "UPDATE lectures SET Notes ='"+ note+ "' WHERE id = " + id + ";";
		System.out.println(Statement);
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();
	}

}
