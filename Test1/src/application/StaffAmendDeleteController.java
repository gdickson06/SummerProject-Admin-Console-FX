package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.sql.SearchQueries;

public class StaffAmendDeleteController {
	
	protected static Staff s;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXComboBox<String> accessLevel;

    @FXML
    private JFXListView<Staff> userTable;

    @FXML
    private ImageView Image;

    @FXML
    private JFXTextField staffNumber;

    @FXML
    private JFXTextField LastName;

    @FXML
    private JFXTextField name;
/**
 * This method will search staff by their first name
 * @param event
 */
    @FXML
    void nameSearch(ActionEvent event) {
    	List<Staff> searched = new ArrayList<Staff>();
    	try {
			searched.addAll(SearchQueries.searchStaff(1, name.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("There was an error with searching Staff", "Error");
			e.printStackTrace();
		}
		ObservableList<Staff> list = FXCollections.observableArrayList();
		list.addAll(searched);
		userTable.setItems(list);
    }
/**
 * This method will search Staff by their last name
 * @param event
 */
    @FXML
    void LastNameSearch(ActionEvent event) {
    	List<Staff> searched = new ArrayList<Staff>();
    	try {
			searched.addAll(SearchQueries.searchStaff(2, LastName.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("There was an error with searching Staff", "Error");
			e.printStackTrace();
		}
		ObservableList<Staff> list = FXCollections.observableArrayList();
		list.addAll(searched);
		userTable.setItems(list);
    }
/**
 * This method will search Staff by their staff number
 * @param event
 */
    @FXML
    void staffNumberSearch(ActionEvent event) {
    	List<Staff> searched = new ArrayList<Staff>();
    	try {
			searched.addAll(SearchQueries.searchStaff(3, staffNumber.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("There was an error with searching Staff", "Error");
			e.printStackTrace();
		}
		ObservableList<Staff> list = FXCollections.observableArrayList();
		list.addAll(searched);
		userTable.setItems(list);
    }
/**
 * This method will search staff by type
 * @param event
 */
    @FXML
    void accessLevelSearch(ActionEvent event) {
    	List<Staff> searched = new ArrayList<Staff>();
    	try {
			searched.addAll(SearchQueries.searchStaff(4, accessLevel.getValue()));
		} catch (SQLException e) {
			GeneralMethods.show("There was an error with searching Staff", "Error");
			e.printStackTrace();
		}
		ObservableList<Staff> list = FXCollections.observableArrayList();
		list.addAll(searched);
		userTable.setItems(list);
		
    }

/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }
/**
 * This method will return the user to the Staff menu screen
 * @param event
 * @throws Exception
 */
    @FXML
    void returnStaffScreen(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StaffMenu", "StaffMenu");
    }
/**
 * This method allows the list of Staff to be clickable
 * when a student is clicked it will change the scene to the amend delete 
 * student menu which will be populated with the selected staff
 * @param event
 * @throws Exception
 */
    @FXML
    void ListClick(MouseEvent event) throws Exception {
    	if (event.getClickCount() == 2) {

			s = userTable.getSelectionModel().getSelectedItem();
			GeneralMethods.ChangeScene("AmendSingleStaff","AmendSingleStaff");
		}
    }
/**
 * This intialize method will run before the screen is changed this will populate
 * the image and the types combo box
 */
    @FXML
    void initialize() {
    	List<String> types = new ArrayList<String>();

		types.add("Administrator");
		types.add("Module Coordinator");
		types.add("Lecturer");

		accessLevel.getItems().addAll(types);
		
	  	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
