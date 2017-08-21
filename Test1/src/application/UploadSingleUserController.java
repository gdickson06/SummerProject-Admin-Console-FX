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
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Staff;

import uk.ac.qub.sql.StaffSQL;

public class UploadSingleUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField UsernameText;

    @FXML
    private JFXTextField NameText;

    @FXML
    private JFXComboBox<String> TypePicker;

    @FXML
    private ImageView Image;


 
/**
 * This method will upload a new user to the database
 * @param event
 */
    @FXML
    void Upload(ActionEvent event) {
	Staff s = new Staff();
	s.setAccess_level(TypePicker.getValue());
	s.setName(NameText.getText());
	s.setStaff_number(UsernameText.getText());
    	
    		try {
				StaffSQL.UploadSingleUser(s);
				GeneralMethods.show("Success in uploading " + s.getName(), "Success");
			} catch (Exception e) {
				GeneralMethods.show("Error with uploading staff member", "Error");
				e.printStackTrace();
			}
    	
    }
/**
 * This method will clear all inputs to the textboxes
 * @param event
 */
    @FXML
    void Clear(ActionEvent event) {
    	UsernameText.setText("");
    	NameText.setText("");
    
    	TypePicker.setValue("");
    	
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
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }
/**
 * This initialize method will populate the Image and comboboxes on the page
 */
    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    
    	List<String>types= new ArrayList<String>();
    	
    	types.add("Administrator");
    	types.add("Module Coordinator");
    	types.add("Lecturer");
    	
    	TypePicker.getItems().addAll(types);
    	
    }
}
