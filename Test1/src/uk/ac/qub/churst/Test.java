package uk.ac.qub.churst;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import application.ApplicationMethods;



public class Test {

	public static void main(String[] args) {
		
		try {
   	     if (Desktop.isDesktopSupported()) {
   	       Desktop.getDesktop().open(new File("StandardStudentList.csv"));
   	     }
   	   } catch (IOException ioe) {
   	     ioe.printStackTrace();
   	  }
		
		
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