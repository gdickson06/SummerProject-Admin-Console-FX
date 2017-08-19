package uk.ac.qub.churst;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
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

	public static void main(String[] args) {
		String e ="Tue 30 Aug 16";
		String [] split = e.split(" ");
		
		String answer = split[1];
		
		switch (split[2]){
		
		case "Jan":
			answer +="01";
			break;
		case "Feb":
			answer +="02";
			break;
		case "Mar":
			answer +="03";
			break;
		case "Apr":
			answer +="04";
			break;
		case "May":
			answer +="05";
			break;
		case "Jun":
			answer +="06";
			break;
		case "Jul":
			answer += "07";
			break;
		case "Aug":
			answer +="08";
			break;
		case "Sep":
			answer+= "09";
			break;
		case "Oct":
			answer +="10";
			break;
		case "Nov":
			answer +=11;
			break;
		case "Dec":
			answer +=12;
			break;
		default:
			System.out.println("Error");
		}

answer +=20+split[3];
System.out.println(answer);
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