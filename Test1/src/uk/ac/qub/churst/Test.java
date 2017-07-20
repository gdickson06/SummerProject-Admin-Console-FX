package uk.ac.qub.churst;

import java.util.ArrayList;
import java.util.List;

import uk.ac.qub.objects.GroupsCon;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.SQL;

public class Test {

	public static void main(String[] args) {
		List<Lecture> l = CSV.readLecturesFromCSV("timetable.csv");
		List<String> groups = new ArrayList<String>();
		List<GroupsCon> obj = new ArrayList<GroupsCon>();
		
		for(Lecture lec:l){
			groups.add(lec.getGroup());
		}
		
		for(String s: groups){
			try{
			List<String> Cohort =  ConvertGroup.convert(s);
			for(String p: Cohort){
				obj.add(new GroupsCon(s,p));
			}
			}catch (Exception e){
				e.printStackTrace();
			}
			
			
			
		}
	
		System.out.println(obj.size());
		
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