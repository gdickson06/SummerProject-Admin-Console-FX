package uk.ac.qub.churst;
import java.sql.SQLException;



public class Test {

	public static void main(String[] args) {
		
		
		try {
			PDF pdf = new PDF("C:/Users/calum/Downloads/titsr.pdf");
			pdf.create(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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