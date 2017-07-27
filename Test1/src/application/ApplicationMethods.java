package application;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ComboBox;

public class ApplicationMethods {
	



public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	protected static void AbsenceTypes(ComboBox<String> Type) {
		List<String>types= new ArrayList<String>();
    	
    	types.add("Illness");
    	types.add("Non Illness Related Absence");
    	types.add("Missing from class");
    	
    	
    	Type.getItems().addAll(types);
	}

}
