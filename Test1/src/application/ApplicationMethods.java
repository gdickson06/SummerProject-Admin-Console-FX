package application;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXComboBox;

import javafx.scene.control.Label;

import uk.ac.qub.objects.Staff;

public class ApplicationMethods {
	

public static Staff CurrentUser;


public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	protected static void logOut (Label l){
		
	}

	protected static void AbsenceTypes(JFXComboBox<String> type) {
		List<String>types= new ArrayList<String>();
    	
    	types.add("Illness");
    	types.add("Non Illness Related Absence");
    	types.add("Missing from class");
    	
    	
    	type.getItems().addAll(types);
	}
	
	protected static void Years(JFXComboBox<Integer> e){
		List<Integer> years = new ArrayList<Integer>();
		years.add(1);
		years.add(2);
		years.add(3);
		years.add(4);
		years.add(5);
		
		e.getItems().addAll(years);
	}
	
	

}
