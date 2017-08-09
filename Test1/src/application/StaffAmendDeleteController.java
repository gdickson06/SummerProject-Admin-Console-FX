package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
    private JFXComboBox<String> Type;

    @FXML
    private JFXListView<Staff> UserTable;

    @FXML
    private ImageView Image;

    @FXML
    private JFXTextField Username;

    @FXML
    private JFXTextField LastName;

    @FXML
    private JFXTextField FirstName;

    @FXML
    void FirstNameSearch(ActionEvent event) {
    	List<Staff> searched = SearchQueries.searchStaff(1, FirstName.getText(), true);
		ObservableList<Staff> list = FXCollections.observableArrayList();
		list.addAll(searched);
		UserTable.setItems(list);
		System.out.println(searched.size());
    }

    @FXML
    void LastNameSearch(ActionEvent event) {
    	List<Staff> searched = SearchQueries.searchStaff(2, LastName.getText(), true);
		ObservableList<Staff> list = FXCollections.observableArrayList();
		list.addAll(searched);
		UserTable.setItems(list);
		System.out.println(searched.size());
    }

    @FXML
    void UserNameSearch(ActionEvent event) {
    	List<Staff> searched = SearchQueries.searchStaff(3, Username.getText(), true);
		ObservableList<Staff> list = FXCollections.observableArrayList();
		list.addAll(searched);
		UserTable.setItems(list);
		System.out.println(searched.size());
    }

    @FXML
    void TypeSearch(ActionEvent event) {
    	List<Staff> searched = SearchQueries.searchStaff(4, Type.getValue(), false);
		ObservableList<Staff> list = FXCollections.observableArrayList();
		list.addAll(searched);
		System.out.println(list.size());
		UserTable.setItems(list);
		System.out.println(searched.size());
    }


    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }

    @FXML
    void ReturnStaffScreen(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StaffMenu", "StaffMenu");
    }

    @FXML
    void ListClick(MouseEvent event) throws Exception {
    	if (event.getClickCount() == 2) {

			s = UserTable.getSelectionModel().getSelectedItem();
			GeneralMethods.ChangeScene("AmendSingleStaff","AmendSingleStaff");
		}
    }

    @FXML
    void initialize() {
    	List<String> types = new ArrayList<String>();

		types.add("Administrator");
		types.add("Module Coordinator");
		types.add("Lecturer");

		Type.getItems().addAll(types);
		
	  	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
