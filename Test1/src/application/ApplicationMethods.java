package application;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;


import javafx.scene.control.DatePicker;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Staff;

public class ApplicationMethods {
	
static String errorStyle ="-fx-border-color: white";
public static Staff CurrentUser;

public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@SuppressWarnings("rawtypes")
	protected static boolean noNullValues(List<javafx.scene.control.Control> fields){
		boolean valid = true;
		
		for(javafx.scene.control.Control field: fields){
			if(field instanceof DatePicker){
				if(((DatePicker) field).getValue()==null){
					field.setStyle(errorStyle);
					valid=false;
				}
			} else if (field instanceof JFXTextField){
				if(((JFXTextField) field).getText().isEmpty()){
					field.setStyle(errorStyle);
					valid=false;
				}
			} else if (field instanceof JFXComboBox){
				if(((JFXComboBox) field).getValue()==null){
					field.setStyle(errorStyle);
					valid=false;
				}
			}	else if (field instanceof JFXTextArea){
				if(((JFXTextField) field).getText().isEmpty()){
					field.setStyle(errorStyle);
					valid=false;
				}
			} 
			
		}
		if(!valid){
			GeneralMethods.show("Field needs to be filled in", "Error");
		}
		return valid;
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
