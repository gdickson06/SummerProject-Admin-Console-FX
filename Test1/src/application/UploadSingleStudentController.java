package application;

import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.sql.StudentSQL;

public class UploadSingleStudentController {
	   @FXML
	    private ImageView Image;

    @FXML
    private JFXTextField IntakeYear;

    @FXML
    private JFXTextField Cohort;

    @FXML
    private JFXTextField StudentNumber;

    @FXML
    private JFXTextField StudentName;

    @FXML
    private JFXTextField EmailAddress;

    @FXML
    void updateDetails(ActionEvent event) {
    	//This will be in the order of the Student Number, name,group,email,year.
    	List<String> attributes = new ArrayList<String>();
    	
    	attributes.add(StudentNumber.getText());
    	attributes.add(StudentName.getText());
    	attributes.add(Cohort.getText());
    	attributes.add(EmailAddress.getText());
    	attributes.add(IntakeYear.getText());
    	
    	try {
			StudentSQL.UploadSingleStudent(attributes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			GeneralMethods.show("Error when uploading Student", "ERROR");
		}
    	
    	GeneralMethods.show("Student added with name "+StudentName.getText()+" and Student Number "+ StudentNumber.getText(), "Student Added");
    }

    @FXML
    void MainMenu(ActionEvent event)throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }
    
    @FXML
    void StudentMenu(ActionEvent event)throws Exception {
    	GeneralMethods.ChangeScene("StudentMenu","StudentMenu");
    }
    
    @FXML
    void Clear(ActionEvent event)throws Exception {
      IntakeYear.setText("");

     Cohort.setText("");;

       StudentNumber.setText("");;

       StudentName.setText("");;

        EmailAddress.setText("");;
    }
    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }

}
