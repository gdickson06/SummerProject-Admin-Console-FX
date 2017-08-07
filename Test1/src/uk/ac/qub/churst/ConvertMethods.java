package uk.ac.qub.churst;




import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

import uk.ac.qub.objects.Lecture;
import uk.ac.qub.objects.Student;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.SearchQueries;

public class ConvertMethods {
	private static int ChangeMonth = 8;
	private static int ChangeDay =9;
	
	
	public static int ConvertYear(int intakeYear){
		LocalDate localDate = LocalDate.now();
		int Day = localDate.getDayOfMonth();
		int Month =localDate.getMonthValue();
		int Year = localDate.getYear();
		
		
		int YearGroup;
		YearGroup = Year-intakeYear;
		
		if(ChangeMonth<=Month && ChangeDay<=Day){
			YearGroup+=1;
		}
		
		return YearGroup;
	}
	
	public static int DeconvertYear(int YearGroup){
		LocalDate localDate = LocalDate.now();
		int Day = localDate.getDayOfMonth();
		int Month =localDate.getMonthValue();
		int Year = localDate.getYear();
	
		int intakeYear = Year - YearGroup;
		if(ChangeMonth<=Month && ChangeDay<=Day){
			intakeYear+=1;
		}
		
		return intakeYear;
		
	}
	public static String TimeConvertSQL(String time){
		String r=time.replace(":","");
		
		String answer = r + "00";
		
		return answer;
		
	}
	
	public static String DateConvertSQL(String date){
		
		String[]q = date.split("/");
		String answer="";
		for( int i =2; i>=0; i--){
			answer=answer+q[i];
		}
		
		
		
		return answer;
		
	}

	
	public static List<String> convert (String s) throws InputMismatchException{
		System.out.println(s);
		
		List <String> answer = new ArrayList<String>();
		try{
		s=s.replaceAll("\\s+","");
		if(s.equalsIgnoreCase("ALL")||s.equalsIgnoreCase("optional all")||s.isEmpty()){
			for(int i = 1; i<25;i++){
				answer.add("A"+i);
				answer.add("B"+i);
			}
		} else {
			
			String[] separated = s.split("\\+");
			if (s.contains("-")){
				for(int i=0; i<separated.length;i++){
					if(separated[i].contains("-")){
						char set = separated[i].charAt(0);
						int startGroup;
						int endGroup; 
						
						int dash = 0;
						
						for(int k=0; k<separated[i].length();k++){
							if(separated[i].charAt(k)=='-'){
								dash=k;
							}
						}
						
						startGroup=Integer.parseInt(separated[i].substring(1,dash));
						endGroup = Integer.parseInt(separated[i].substring(dash+2));
						
						
						for(int p=startGroup; p<=endGroup; p++){
							String answers = String.valueOf(set)+String.valueOf(p);
							
							answer.add(answers);
						}
					}
				}
			} else {
				for (int i=0; i<separated.length;i++){
					answer.add(separated[i]);
				}
			}
		}
		} catch (Exception e){
			e.printStackTrace();
		}
		return answer;
		
	}
	
	
	

	
public static String timeConvert(String time){
		try {
		String [] split = time.split(":");
		int hour = Integer.parseInt(split[0]);
		
		if(split[2].charAt(3)=='P'&&split[0].equals("12")==false){
			split[0]=String.valueOf(hour+=12);
		}
		
		split[2]=split[2].substring(0, 2);
		
		String answer="";
		
		for(int i=0; i<split.length-1;i++){
			if(i!=split.length-2){
			answer=answer+split[i] + ":";
			} else {
				answer = answer+split[i];
			}
		}
		
		return answer;
	} catch (Exception e){
		return time;
	}
}
}