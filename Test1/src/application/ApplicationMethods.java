package application;


import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.ComboBox;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Staff;

public class ApplicationMethods {
	

public static Staff CurrentUser;

public static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	protected static void AbsenceTypes(ComboBox<String> Type) {
		List<String>types= new ArrayList<String>();
    	
    	types.add("Illness");
    	types.add("Non Illness Related Absence");
    	types.add("Missing from class");
    	
    	
    	Type.getItems().addAll(types);
	}
	
	protected static void ErrorMessage (Exception e){
		if(e instanceof com.mysql.jdbc.exceptions.jdbc4.MySQLNonTransientConnectionException){
			GeneralMethods.show("No internet connection, please check you are connected to the internet", "Error");
		}
	}

}
