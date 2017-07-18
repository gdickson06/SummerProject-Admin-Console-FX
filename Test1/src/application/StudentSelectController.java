package application;import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.StudentSQL;

public class StudentSelectController {
	  @FXML
	    private Label StudentNumber;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Delete;

    @FXML
    private TextField Cohort;

    @FXML
    private Button Back;

    @FXML
    private Button Save;

    @FXML
    private TextField StudentName;

    @FXML
    private Button Home;

    @FXML
    private TextField EmailAddress;
    
    @FXML
    private TextField IntakeYear;
 

    @FXML
    void Save(ActionEvent event) throws Exception{
    	List<String> attributes = new ArrayList<String>();
    	//This will be in the order of the studentNumber,name,group,email,year.
    	
    	attributes.add(Integer.toString(StudentAmmendDeleteController.SelectedStudent.getStudentNumber()));
    	attributes.add(StudentName.getText());
    	attributes.add(Cohort.getText());
    	attributes.add(EmailAddress.getText());
    	attributes.add(IntakeYear.getText());
    	
    	StudentSQL.AmendStudent(attributes);
    	
    	GeneralMethods.show("The student number"+Integer.toString(StudentAmmendDeleteController.SelectedStudent.getStudentNumber())+" has been amended", "Record Changed");
    	
    }

    @FXML
    void Back(ActionEvent event)throws Exception {
    	GeneralMethods.ChangeScene("StudentAmmendDelete");
    }

    @FXML
    void Home(ActionEvent event) throws Exception{
    	GeneralMethods.ChangeScene("MainMenu");
    }

    @FXML
    void Delete(ActionEvent event)throws Exception{
    	StudentSQL.DeleteStudent(Integer.toString(StudentAmmendDeleteController.SelectedStudent.getStudentNumber()));
    	GeneralMethods.show("The record for "+Integer.toString(StudentAmmendDeleteController.SelectedStudent.getStudentNumber())+" has been deleted.", "Record Deleted");
    	GeneralMethods.ChangeScene("StudentAmmendDelete");
    	
    }

    @FXML
    void initialize() {
    	System.out.println(StudentAmmendDeleteController.SelectedStudent.getEmail());
    	StudentNumber.setText(Integer.toString(StudentAmmendDeleteController.SelectedStudent.getStudentNumber()));
    	StudentName.setText(StudentAmmendDeleteController.SelectedStudent.getName());
    	EmailAddress.setText(StudentAmmendDeleteController.SelectedStudent.getEmail());
    	Cohort.setText(StudentAmmendDeleteController.SelectedStudent.getFirstGroup());
    	IntakeYear.setText(Integer.toString(StudentAmmendDeleteController.SelectedStudent.getIntakeYear()));
        assert Delete != null : "fx:id=\"Delete\" was not injected: check your FXML file 'SelectedStudent.fxml'.";
        assert Cohort != null : "fx:id=\"Cohort\" was not injected: check your FXML file 'SelectedStudent.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'SelectedStudent.fxml'.";
        assert Save != null : "fx:id=\"Save\" was not injected: check your FXML file 'SelectedStudent.fxml'.";
        assert StudentName != null : "fx:id=\"StudentName\" was not injected: check your FXML file 'SelectedStudent.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'SelectedStudent.fxml'.";
        assert EmailAddress != null : "fx:id=\"EmailAddress\" was not injected: check your FXML file 'SelectedStudent.fxml'.";

    }
}
