package uk.ac.qub.churst;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import application.ApplicationMethods;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.objects.ExtendedAbsence;



public class Test {

	public static void main(String[] args) {
		
	ExtendedAbsence ea = new ExtendedAbsence();
	
	
	List <Absence> a = new ArrayList<>();
	try {
		a = AbsenceTrends.filteredAbsence(ea);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		System.out.println(a.size());
		Map<String, Double> i=AbsenceTrends.DayTrend(a);
		
		for(Map.Entry<String, Double> e: i.entrySet()){
			System.out.println(e.getKey() +" : " +e.getValue());
		}
		
		AbsenceTrends.DateTrend(a);
	}
	
	
	public static void timeConvert(String time){
		
		String [] split = time.split(":");
		int hour = Integer.parseInt(split[0]);
		
		if(split[2].charAt(3)=='P'&&split[0].equals("12")==false){
			split[0]=String.valueOf(hour+=12);
		}
		
		split[2]=split[2].substring(0, 2);
		
		String answer="";
		
		for(int i=0; i<split.length;i++){
			if(i!=split.length-1){
			answer=answer+split[i] + ":";
			} else {
				answer = answer+split[i];
			}
		}
		
		System.out.println(answer);
	}
}