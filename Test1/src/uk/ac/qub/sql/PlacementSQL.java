package uk.ac.qub.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import uk.ac.qub.churst.ConvertGroup;
import uk.ac.qub.objects.Placement;

public class PlacementSQL {

	public static void saveSQLPlacement(List<Placement> placements, int Year) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

	Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;
		String newStatement = null;

		for (Placement p : placements) {
			int Week = p.getWeek();
			String StartDate = ConvertGroup.DateConvertSQL(p.getStartDate());
			String EndDate =  ConvertGroup.DateConvertSQL(p.getEndDate());
			String Subject = p.getSubject();
			String Location = p.getLocation();
			String Teacher = p.getTeacher();
			String Cohort = p.getCohort();
			
			try {
				newStatement = "INSERT INTO placement (Week,StartDate,EndDate,Subject,Location,ClinicalTeacher,Cohort,YearGroup) VALUES (" + Week + ", " + StartDate+ ", " + EndDate + ", '" + Subject + ", '" + Location+ "', '" + Teacher+ "', '" + Cohort+ "', " + Year+ "')";
				statement = connection.prepareStatement(newStatement);
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

	}
	public static void amendPlacement(List<String> s) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;
		// The list will be id,Week,StartDate,EndDate,Subject,Location,ClinicalTeacher,Cohort,YearGroup,Note
		String Statement = "UPDATE placement SET Week =" + s.get(1) + ", StartDate=" + s.get(2)+ ", EndDate=" + s.get(3) + 
				", Subject = '"+s.get(4)+"',Location = '" +s.get(5)+"', ClinicalTeacher ='"+s.get(6)+
				"', Cohort = '"+s.get(7)+"', YearGroup ="+s.get(8)+", Note='"+s.get(9) + "' WHERE id= "
				+ s.get(0) + ";";
		System.out.println(Statement);
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();
	}
	
	public static void DeleteStaff(String id) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection c = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		PreparedStatement ps = c.prepareStatement("DELETE FROM placement WHERE id =" + id);
		ps.executeUpdate();
	}
	
	public static void UploadSingleStaff(List<String> s) throws Exception {
		// The list will be Week,StartDate,EndDate,Subject,Location,ClinicalTeacher,Cohort,YearGroup,Note
		// Using the JDBC driver

		Class.forName("com.mysql.jdbc.Driver");

		// Creating a connection with
		Connection connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);

		PreparedStatement statement = null;

		String Statement = "INSERT INTO placement(Week,StartDate,EndDate,Subject,Location,ClinicalTeacher,Cohort,YearGroup,Note) VALUES("+s.get(0)+","+s.get(1)+","+s.get(2)+",'"+s.get(3)+"','"+s.get(4)
		+"','"+s.get(5)+"','"+s.get(6)+"',"+s.get(7)+",'"+s.get(8)+"');";
		System.out.println(Statement);
		
		statement = connection.prepareStatement(Statement);
		statement.executeUpdate();

	}

}
