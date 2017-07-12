package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.SQL;

public class UploadSingleStudentController {

    @FXML
    private Button updateDetailsButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField IntakeYear;

    @FXML
    private TextField Cohort;

    @FXML
    private TextField StudentNumber;

    @FXML
    private TextField StudentName;

    @FXML
    private TextField EmailAddress;

    @FXML
    void updateDetailsClick(ActionEvent event) {
    	//This will be in the order of the Student Number, name,group,email,year.
    	List<String> attributes = new ArrayList<String>();
    	
    	attributes.add(StudentNumber.getText());
    	attributes.add(StudentName.getText());
    	attributes.add(Cohort.getText());
    	attributes.add(EmailAddress.getText());
    	attributes.add(IntakeYear.getText());
    	
    	try {
			SQL.UploadSingleStudent(attributes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			GeneralMethods.show("Error when uploading Student", "ERROR");
		}
    	
    	GeneralMethods.show("Student added with name "+StudentName.getText()+" and Student Number "+ StudentNumber.getText(), "Student Added");
    }

    @FXML
    void cancelButtonClick(ActionEvent event)throws Exception {
    	GeneralMethods.ChangeScene("MainMenu");
    }

}
