package application;

import java.awt.Checkbox;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.churst.SQL;

public class UploadSingleAbsenceController {

    @FXML
    private TextField ReasonTextField;

    @FXML
    private TextField TypeTextField;

    @FXML
    private TextField StudentNumberTextField;

    @FXML
    private TextField DateTextField;

    @FXML
    private TextField LectureIDTextField;

    @FXML
    private TextField TimeTextField;
    
    @FXML
    private CheckBox Approved;
    
   /*creating the onClick method below that will add the absence details
    *to the database using the saveSingleAbsence method from the SQL class 
    */
    @FXML
    void UploadSingleAbsenceButton(ActionEvent event) throws Exception {
    	List<String> absenceDetails = new ArrayList<String>();
    	String approved = "false";
    	if(Approved.isSelected()){
    		approved = "true";
    	}
    	
    	
    	//instantiating the Absence class to be inserted into the absenceDetails ArrayList
		absenceDetails.add(StudentNumberTextField.getText());
		absenceDetails.add(LectureIDTextField.getText());
		absenceDetails.add(DateTextField.getText());
		absenceDetails.add(TimeTextField.getText());
		absenceDetails.add(ReasonTextField.getText());
		absenceDetails.add(approved);
		absenceDetails.add(TypeTextField.getText());		
				
		//using the saveSingleAbsence method in the SQL class to save the details to DB
		SQL.saveSingleAbsence(absenceDetails);
		/*dialog box will confirm if absence is saved to the DB using show method
		 *from GeneralMethods class
		*/
		GeneralMethods.show("Absence has been successfully uploaded to the Database", "Absence Uploaded");
	}
    
    /*below method uses the changeScene method to populate the mainMenu fxml file
     *when the "Cancel" button is clicked
     */
    @FXML
    void UploadSingleAbsenceCancelButton(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

}
