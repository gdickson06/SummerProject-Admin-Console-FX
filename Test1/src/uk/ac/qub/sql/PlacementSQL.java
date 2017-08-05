package uk.ac.qub.sql;

import java.sql.PreparedStatement;
import java.util.List;

import application.Main;
import uk.ac.qub.churst.ConvertMethods;
import uk.ac.qub.objects.Placement;

public class PlacementSQL {

	public static void saveSQLPlacement(List<Placement> placements, int Year) throws Exception {
	

		PreparedStatement statement = null;
		String newStatement = null;

		for (Placement p : placements) {
			int Week = p.getWeek();
			String StartDate = ConvertMethods.DateConvertSQL(p.getStartDate());
			String EndDate =  ConvertMethods.DateConvertSQL(p.getEndDate());
			String Subject = p.getSubject();
			String Location = p.getLocation();
			String Teacher = p.getTeacher();
			String Cohort = p.getCohort();
			
			try {
				newStatement = "INSERT INTO placement (Week,StartDate,EndDate,Subject,Location,ClinicalTeacher,Cohort,YearGroup) VALUES (" + Week + ", " + StartDate+ ", " + EndDate + ", '" + Subject + "', '" + Location+ "', '" + Teacher+ "', '" + Cohort+ "', " + Year+ ")";
				System.out.println(newStatement);
				statement = Main.connection.prepareStatement(newStatement);
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

	}
	public static void amendPlacement(List<String> s) throws Exception {
	

		PreparedStatement statement = null;
		// The list will be id,Week,StartDate,EndDate,Subject,Location,ClinicalTeacher,Cohort,YearGroup,Note
		String Statement = "UPDATE placement SET Week =" + s.get(1) + ", StartDate=" + s.get(2)+ ", EndDate=" + s.get(3) + 
				", Subject = '"+s.get(4)+"',Location = '" +s.get(5)+"', ClinicalTeacher ='"+s.get(6)+
				"', Cohort = '"+s.get(7)+"', YearGroup ="+s.get(8)+", Note='"+s.get(9) + "' WHERE id= "
				+ s.get(0) + ";";
		System.out.println(Statement);
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();
	}
	
	public static void DeletePlacement(String id) throws Exception {
	
		PreparedStatement ps =Main.connection.prepareStatement("DELETE FROM placement WHERE id =" + id);
		ps.executeUpdate();
	}
	
	public static void DeleteYearPlacement(String year) throws Exception {
		
		PreparedStatement ps =Main.connection.prepareStatement("DELETE FROM placement WHERE Year =" + year);
		ps.executeUpdate();
	}
	
	public static void UploadSinglePlacement(List<String> s) throws Exception {
		

		PreparedStatement statement = null;

		String Statement = "INSERT INTO placement(Week,StartDate,EndDate,Subject,Location,ClinicalTeacher,Cohort,YearGroup,Note) VALUES("+s.get(0)+","+s.get(1)+","+s.get(2)+",'"+s.get(3)+"','"+s.get(4)
		+"','"+s.get(5)+"','"+s.get(6)+"',"+s.get(7)+",'"+s.get(8)+"');";
		System.out.println(Statement);
		
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}
	
	public static void UploadNote(String id,String note) throws Exception{
	

		PreparedStatement statement = null;

		String Statement = "UPDATE placement SET Note ='"+ note+ "' WHERE id = " + id + ";";
		System.out.println(Statement);
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();
	}

}
