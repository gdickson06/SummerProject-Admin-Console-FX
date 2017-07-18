package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.Absence;
import uk.ac.qub.churst.SQL;

public class UploadSingleAbsenceController {

    @FXML
    private TextField ApprovedTextField;

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
    
   /*creating the onClick method below that will add the absence details
    *to the database using the saveSingleAbsence method from the SQL class 
    */
    @FXML
    void UploadSingleAbsenceButton(ActionEvent event) throws Exception {
    	List<Absence> absenceDetails = new ArrayList<Absence>();
    	
    	/*creating ints for the Student Number so we can use the parseInt method
    	 *need to convert to int to match the Absence constructor arguments
    	 */
    	int studentNumber, lectureID;
    	
    	studentNumber = Integer.parseInt(StudentNumberTextField.getText());
    	lectureID = Integer.parseInt(LectureIDTextField.getText());
    	
    	//creating a boolean for approval
    	Boolean approved = Boolean.parseBoolean(ApprovedTextField.getText());
    	
    	
    	//instantiating the Absence class to be inserted into the absenceDetails ArrayList
		Absence absence = new Absence(studentNumber, lectureID,
				DateTextField.getText(), TimeTextField.getText(), ReasonTextField.getText(),
				approved, TypeTextField.getText());
		
		//adding the values of "absence" into absenceDetails ArrayList
		absenceDetails.add(absence);
		//using the saveSingleAbsence method in the SQL class to save the details to DB
		SQL.saveSingleAbsence(absenceDetails);
		/*dialog box will confirm if absence is saved to the DB using show method
		 *from GeneralMethods class
		*/
		GeneralMethods.show("Absence has been successfully uploaded to DB", "Absence Uploaded");
	}
    
    /*below method uses the changeScene method to populate the mainMenu fxml file
     *when the "Cancel" button is clicked
     */
    @FXML
    void UploadSingleAbsenceCancelButton(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

}
