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
/** 
 *  @author Calum Hurst
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This class holds the methods that will be used within the use of the applicaiton
 * Demographics – 121 LOC 4 Methods 
 * 
 */
public class ApplicationMethods {
	
static String errorStyle ="-fx-border-color: #D1D1D1; -fx-border-width: 3";
public static Staff CurrentUser;

public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
/**
 * This method will take in a list of controls and check for any null values
 * this will return a boolean of true of there are no null values and a value 
 * of false if any object in the list returns a null value. This will also highlight
 * any of the fields which should not be null and use the show method to show an error
 * message.
 * @param fields
 * @return
 */
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
				if(((JFXTextArea) field).getText().isEmpty()){
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
/**
 * This method will be used to fill a JFXComboBox with all of the Absence types
 * @param type
 */
	protected static void AbsenceTypes(JFXComboBox<String> type) {
		List<String>types= new ArrayList<String>();
    	
    	types.add("Illness");
    	types.add("Non Illness Related Absence");
    	types.add("Missing from class");
    	
    	
    	type.getItems().addAll(types);
	}
/**
 * This will be used to fill in a JFXComboBox with all of the possible years	
 * @param e
 */
	protected static void Years(JFXComboBox<Integer> e){
		List<Integer> years = new ArrayList<Integer>();
		years.add(1);
		years.add(2);
		years.add(3);
		years.add(4);
		years.add(5);
		
		e.getItems().addAll(years);
	}
/**
 * This will ensure that the inputted time is in a valid state else it will throw
 * an exception	
 * @param time
 * @throws Exception
 */
public static void timeInput(String time)throws Exception{
	boolean thrown = true;
	
	if(time.isEmpty()){
		thrown =false;
	}

	if((time.length()==4 || time.length()==5)&&time.contains(":") ){
		thrown = false;
	}
	
	if(thrown){
		throw new Exception();
	}
}

}
