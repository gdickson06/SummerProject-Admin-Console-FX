package application;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.sql.StudentSQL;

public class StudentSelectController {
	  @FXML
	    private Label StudentNumber;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

  

    @FXML
    private JFXTextField Cohort;


    @FXML
    private JFXTextField StudentName;

 
    @FXML
    private JFXTextField EmailAddress;
    
    @FXML
    private JFXTextField IntakeYear;
 

    @FXML
    void Save(ActionEvent event) throws Exception{
    	List<String> attributes = new ArrayList<String>();
    	//This will be in the order of the studentNumber,name,group,email,year.
    	
    	attributes.add(Integer.toString(StudentAmendDeleteController.selectedStudent.getStudentNumber()));
    	attributes.add(StudentName.getText());
    	attributes.add(Cohort.getText());
    	attributes.add(EmailAddress.getText());
    	attributes.add(IntakeYear.getText());
    	
    	StudentSQL.AmendStudent(attributes);
    	
    	GeneralMethods.show("The student number"+Integer.toString(StudentAmendDeleteController.selectedStudent.getStudentNumber())+" has been amended", "Record Changed");
    	
    }

    @FXML
    void returnSearch(ActionEvent event)throws Exception {
    	GeneralMethods.ChangeScene("StudentAmendDelete","StudentAmendDelete");
    }

    @FXML
    void returnMain(ActionEvent event) throws Exception{
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }
    
    @FXML
    void returnStudentMenu(ActionEvent event) throws Exception{
    	GeneralMethods.ChangeScene("StudentMenu","StudentMenu");
    }

    @FXML
    void Delete(ActionEvent event)throws Exception{
    	StudentSQL.DeleteStudent(Integer.toString(StudentAmendDeleteController.selectedStudent.getStudentNumber()));
    	GeneralMethods.show("The record for "+Integer.toString(StudentAmendDeleteController.selectedStudent.getStudentNumber())+" has been deleted.", "Record Deleted");
    	GeneralMethods.ChangeScene("StudentAmmendDelete");
    	
    }

    @FXML
    void initialize() {
    	
    	StudentNumber.setText(Integer.toString(StudentAmendDeleteController.selectedStudent.getStudentNumber()));
    	StudentName.setText(StudentAmendDeleteController.selectedStudent.getName());
    	EmailAddress.setText(StudentAmendDeleteController.selectedStudent.getEmail());
    	Cohort.setText(StudentAmendDeleteController.selectedStudent.getFirstGroup());
    	IntakeYear.setText(Integer.toString(StudentAmendDeleteController.selectedStudent.getIntakeYear()));
    
    }
}
