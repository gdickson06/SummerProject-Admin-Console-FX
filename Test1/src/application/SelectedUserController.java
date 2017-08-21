package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;

import uk.ac.qub.objects.Staff;

import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.StaffSQL;

public class SelectedUserController {
	
	Staff s = StaffAmendDeleteController.s;
	

    @FXML
    private ImageView Image;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXComboBox<String> Type;

    @FXML
    private Label UserName;



    @FXML
    private JFXTextField Name;

    
  /**
   * This method will amend the details of a staff member,
   * to update their password this will need to be done via Qsis
   * @param event
   */
   
    @FXML
    void Change(ActionEvent event)  {
    	s.setAccess_level(Type.getValue());
    	s.setName(Name.getText());
    	
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
    void Delete(ActionEvent event) {
    	
    		try {
				StaffSQL.DeleteUser(UserName.getText());
				GeneralMethods.show(s.getName() + " has been deleted", "Success");
				GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
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
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteStaff","AmendDeleteStaff");
    }
/**
 * This method allows the user to go back to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }
 /**
  * This method allows the user to return to the staff screen   
  * @param event
  * @throws Exception
  */
    @FXML
    void ReturnStaffScreen(ActionEvent event) throws Exception {
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
    	
    	Type.getItems().addAll(types);
    
    	Name.setText(s.getName());
    	Type.setValue(s.getAccess_level());
    	UserName.setText(s.getStaff_number());
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
