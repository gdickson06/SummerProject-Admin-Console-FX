package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Staff;


import uk.ac.qub.sql.StaffSQL;

public class SelectedUserController {
	
	Staff s = StaffAmendDeleteController.s;
	

    @FXML
    private ImageView image;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXComboBox<String> accessLevel;

    @FXML
    private Label staffNumber;



    @FXML
    private JFXTextField name;

    
  /**
   * This method will amend the details of a staff member,
   * to update their password this will need to be done via Qsis
   * @param event
   */
   
    @FXML
    void saveDetails(ActionEvent event)  {
    	s.setAccess_level(accessLevel.getValue());
    	s.setName(name.getText());
    	
    	try {
			StaffSQL.amendUser(s);
			GeneralMethods.show("Staff member amended successfully", "Success");
		} catch (Exception e) {
			e.printStackTrace();
			GeneralMethods.show("Error in changing staff member", "Error");
		}
    	

    }
/**
 * This method will delete the selected user
 * @param event
 */
    @FXML
    void deleteStaffMember(ActionEvent event) {
    	
    		try {
				StaffSQL.DeleteUser(staffNumber.getText());
				GeneralMethods.show(s.getName() + " has been deleted", "Success");
				GeneralMethods.ChangeScene("MainMenu", "MainMenu");
			} catch (Exception e) {
				e.printStackTrace();
				GeneralMethods.show("Error in deleting user", "Error");
			}
    	
    }
/**
 * This method will allow the user to go back to search the staff
 * @param event
 * @throws Exception
 */
    @FXML
    void back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteStaff","AmendDeleteStaff");
    }
/**
 * This method allows the user to go back to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
    }
 /**
  * This method allows the user to return to the staff screen   
  * @param event
  * @throws Exception
  */
    @FXML
    void returnStaffMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StaffMenu","StaffMenu");
    }
    
  /**
   * The initialize method will fill the combo boxes and image views in the application
   * along with populating the fields with the current values
   */

    @FXML
    void initialize() {
    	
    	
    	List<String>types= new ArrayList<String>();
    	
    	types.add("Administrator");
    	types.add("Module Coordinator");
    	types.add("Lecturer");
    	
    	accessLevel.getItems().addAll(types);
    
    	name.setText(s.getName());
    	accessLevel.setValue(s.getAccess_level());
    	staffNumber.setText(s.getStaff_number());
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	image.setImage(i);
    }
}
