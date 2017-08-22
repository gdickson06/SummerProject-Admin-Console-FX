package uk.ac.qub.churst;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import application.ApplicationMethods;
import application.Main;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.objects.ExtendedAbsence;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.sql.PlacementSQL;
import uk.ac.qub.sql.SQL;



public class Test {

	public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException {
	List<String> s = ConvertMethods.convert("D12-D20");
	
	for(String x : s){
		System.out.println(x);
	}
	}
	
	
	public static void timeConvert(String time){
		
		List<String>attributes = new ArrayList<String>();
	
		attributes.add("week");
		attributes.add("day");
		attributes.add("date");
		attributes.add("start_time");
		attributes.add("end_time");
		attributes.add("groups");
		attributes.add("location");
		attributes.add("subject");
		attributes.add("theme");
		attributes.add("teaching");
		attributes.add("description");
		attributes.add("staff");
		attributes.add("style");
		attributes.add("module");
	}
	
	public static void downloadToCSV(List<String>attributes,String year,String type) throws IOException, SQLException {
		File file =new File("year"+year+"placements.csv");
		 PrintWriter pw = new PrintWriter(file);
	        StringBuilder sb = new StringBuilder();
	        
	        for(String s : attributes){
	        	sb.append(',');
	        	sb.append(s);
	        	
	        }
	        
	        sb.append('\n');
	        sb.deleteCharAt(0);
	        ResultSet r = SQL.SQLstatements("SELECT * FROM "+type+" Where year = '" + year +"'");
	        if(r.next()){
	        do{
	        	for(int i =0; i<attributes.size(); i++){
	        		if(i!=attributes.size()){
	        	if(r.getString(attributes.get(i))==null){sb.append(" ");}else{sb.append(r.getString(attributes.get(i)));}
	        	sb.append(',');
	        		} else {
	        			if(r.getString(attributes.get(i))==null){sb.append(" ");}else{sb.append(r.getString(attributes.get(i)));}
	    	        	
	        		}
	        	}
	        	sb.append('\n');
	        	
	        }while (r.next());

	        }

	        pw.write(sb.toString());
	        pw.close();
	        Desktop.getDesktop().open(file);
	}
}