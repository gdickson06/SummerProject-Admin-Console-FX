package uk.ac.qub.sql;


import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import application.Main;
import uk.ac.qub.methods.ConvertMethods;
import uk.ac.qub.objects.Placement;

public class PlacementSQL {

	/**
	 * This method will upload a Year's worth of Placements taking in a list of 
	 * Placements which will be created in a seperate method.
	 * @param placements
	 * @param Year
	 * @throws Exception
	 */
	public static void saveSQLPlacement(List<Placement> placements, int Year) throws Exception {
	

		PreparedStatement statement = null;
		String newStatement = null;

		for (Placement p : placements) {
			String cohort =p.getCohort().replaceAll("'", "''");
			String module = p.getModule().replaceAll("'", "''");
			String StartDate = ConvertMethods.TextDate(p.getStartDate());
			String EndDate =  ConvertMethods.TextDate(p.getEndDate());
			String module_number = p.getModuleNumber().replaceAll("'", "''");
			String Location = p.getLocation().replaceAll("'", "''");
			String preference = p.getPreference().replaceAll("'", "''");
			String comments = p.getNote().replaceAll("'", "''");
		
			
			try {
				newStatement = "INSERT INTO Placements (cohort,module,start_date,end_date,module_number,hospital,preference,comments,year)"
						+ " VALUES ('" + cohort + "', '" + module+ "', " + StartDate + ", "
						+ EndDate + ", '" + module_number+ "', '" + Location+ "', '" + preference+ "', '"+comments+"', + "+Year+ ")";
				statement = Main.connection.prepareStatement(newStatement);
				statement.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		

	}
	
	/**
	 * This method will amend a single placement with an amended placement holding the information
	 * @param s
	 * @throws Exception
	 */
	public static void amendPlacement(Placement p) throws Exception {
	

		PreparedStatement statement = null;
		String Statement = "UPDATE Placements SET cohort ='" + p.getCohort().replaceAll("'", "''") + "', module='" + p.getModule().replaceAll("'", "''")+ "', start_date='" + p.getStartDate() + 
				"', end_date = '"+p.getEndDate()+"',module_number = '" +p.getModuleNumber().replaceAll("'", "''")+"', hospital ='"+p.getLocation().replaceAll("'", "''")+
				"', preference = '"+p.getPreference().replaceAll("'", "''")+"', comments ='"+p.getNote().replaceAll("'", "''")+"', year="+p.getYear() + " WHERE id= "
				+ p.getId() + ";";
		System.out.println(Statement);
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();
	}
	
	/**
	 * This method will Delete a placement from the SQL database
	 * @param id
	 * @throws Exception
	 */
	public static void DeletePlacement(String id) throws Exception {
	
		PreparedStatement ps =Main.connection.prepareStatement("DELETE FROM Placements WHERE id =" + id);
		ps.executeUpdate();
	}
	
	
/**
 * This method will delete a full year of placements
 * @param year
 * @throws Exception
 */
	public static void DeleteYearPlacement(String year) throws Exception {
		
		PreparedStatement ps =Main.connection.prepareStatement("DELETE FROM Placements WHERE year =" + year);
		ps.executeUpdate();
	}
	
/**
 * This method will upload a single placement from a list of Strings
 * @param p
 * @throws Exception
 */
	public static void UploadSinglePlacement(Placement p) throws Exception {
		

		PreparedStatement statement = null;

		String Statement = "INSERT INTO Placements(cohort,module,start_date,end_date,module_number,hospital,preference,year) VALUES('"+p.getCohort().replaceAll("'", "''")+"',"
				+ "'"+p.getModule().replaceAll("'", "''")+"','"+p.getStartDate()+"','"+p.getEndDate()+"','"+p.getModuleNumber().replaceAll("'", "''")
		+"','"+p.getLocation().replaceAll("'", "''")+"','"+p.getPreference().replaceAll("'", "''")+"', '"+p.getYear()+"');";
		System.out.println(Statement);
		
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();

	}

/**
 * This method will upload a note to a placement 
 * @param id
 * @param note
 * @throws Exception
 */
	public static void UploadNote(String id,String note) throws Exception{
	

		PreparedStatement statement = null;

		String Statement = "UPDATE Placements SET comments ='"+ note.replaceAll("'", "''")+ "' WHERE id = " + id + ";";
		statement = Main.connection.prepareStatement(Statement);
		statement.executeUpdate();
	}

	public static File downloadToCSV(String year) throws IOException, SQLException {
		File file =new File("year"+year+"placements.csv");
		 PrintWriter pw = new PrintWriter(file);
	        StringBuilder sb = new StringBuilder();
	        sb.append("Student ID");
	        sb.append(',');
	        sb.append("name");
	        sb.append(',');
	        sb.append("cohort");
	        sb.append(',');
	        sb.append("module");
	        sb.append(',');
	        sb.append("start date");
	        sb.append(',');
	        sb.append("end date");
	        sb.append(',');
	        sb.append("module number");
	        sb.append(',');
	        sb.append("hospital");
	        sb.append(',');
	        sb.append("preference");
	        sb.append(',');
	        sb.append("comments");
	        sb.append('\n');
	        
	        ResultSet r = SQL.SQLstatements("SELECT * FROM Placements Where year = '" + year +"'");
	        if(r.next()){
	        do{
	        	sb.append(" ");
	        	sb.append(',');
	        	sb.append(" ");
	        	sb.append(',');
	        	if(r.getString("cohort")==null){sb.append(" ");}else{sb.append(r.getString("cohort"));}
	        	sb.append(',');
	        	if(r.getString("module")==null){sb.append(" ");}else{sb.append(r.getString("module"));}
	       
	        	sb.append(',');
	        	if(r.getString("start_date")==null){sb.append(" ");}else{sb.append(r.getString("start_date"));}
	        	
	        	sb.append(',');
	        	if(r.getString("end_date")==null){sb.append(" ");}else{sb.append(r.getString("end_date"));}
	        	
	        	sb.append(',');
	        	if(r.getString("module_number")==null){sb.append(" ");}else{sb.append(r.getString("module_number"));}
	        	
	        	sb.append(',');
	        	if(r.getString("hospital")==null){sb.append(" ");}else{sb.append(r.getString("hospital"));}
	        	
	        	sb.append(',');
	        	if(r.getString("preference")==null){sb.append(" ");}else{sb.append(r.getString("preference"));}
	        	
	        	sb.append(',');
	        	if(r.getString("comments")==null){sb.append(" ");}else{sb.append(r.getString("comments"));}
	        	
	        	sb.append('\n');
	        }while (r.next());

	        }

	        pw.write(sb.toString());
	        pw.close();
	       return file;
	}
}
