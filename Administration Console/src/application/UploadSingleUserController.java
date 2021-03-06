package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Staff;

import uk.ac.qub.sql.StaffSQL;

/** 
 * Name of Package - application
 * Date Last Amended - 08/09/17
 * Outline - This is the controller class to upload a single staff member to the database,
 * the methods will be able to upload the staff member and to clear to fields.
 * Demographics � 123 LOC 5 Methods 
 * 
 */

public class UploadSingleUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField staffNumber;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXComboBox<String> accessLevel;

    @FXML
    private ImageView image;


 
/**
 * This method will upload a new user to the database
 * @param event
 */
    @FXML
    void uploadStaffMember(ActionEvent event) {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(staffNumber);
		fields.add(name);
		fields.add(accessLevel);
		
		if(ApplicationMethods.noNullValues(fields)){
	Staff s = new Staff();
	s.setAccess_level(accessLevel.getValue());
	s.setName(name.getText());
	s.setStaff_number(staffNumber.getText());
    	
    		try {
				StaffSQL.UploadSingleUser(s);
				GeneralMethods.show("Success in uploading " + s.getName(), "Success");
			} catch (Exception e) {
				GeneralMethods.show("Error with uploading staff member", "Error");
				e.printStackTrace();
			}
		}
    }
/**
 * This method will clear all inputs to the textboxes
 * @param event
 */
    @FXML
    void clear(ActionEvent event) {
    	staffNumber.setText("");
    	name.setText("");
    
    	accessLevel.setValue("");
    	
    }
/**
 * This method will return the user to the staff menu
 * @param event
 * @throws Exception
 */
    @FXML
    void returnStaffMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StaffMenu", "StaffMenu");
    }
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void mainMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu", "MainMenu");
    }
/**
 * This initialize method will populate the Image and comboboxes on the page
 */
    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	image.setImage(i);
    
    	List<String>types= new ArrayList<String>();
    	
    	types.add("Administrator");
    	types.add("Module Coordinator");
    	types.add("Lecturer");
    	
    	accessLevel.getItems().addAll(types);
    	
    }
}
