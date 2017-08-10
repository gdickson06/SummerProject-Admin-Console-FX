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
import uk.ac.qub.sql.CoordinatorSQL;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.StaffSQL;

public class UploadSingleUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField PasswordText;

    @FXML
    private JFXComboBox<String> ModuleBox;

    @FXML
    private JFXTextField UsernameText;

    @FXML
    private JFXTextField NameText;

    @FXML
    private JFXComboBox<String> TypePicker;

    @FXML
    private ImageView Image;

    @FXML
    private JFXTextField EmailText;

    @FXML
    void TypeDrop(ActionEvent event) {
      	if(TypePicker.getValue().equals("Module Coordinator")){
    		ModuleBox.setVisible(true);
    		EmailText.setVisible(true);
    		System.out.println("TITS");
    	} else {
    		ModuleBox.setVisible(false);
    		EmailText.setVisible(false);
    	}
    }

    @FXML
    void Upload(ActionEvent event) throws Exception {
	List<String> attributes = new ArrayList<String>();
    	
    	attributes.add(UsernameText.getText());
    	attributes.add(NameText.getText());
    	attributes.add(EmailText.getText());
    	attributes.add(PasswordText.getText());
    	attributes.add(TypePicker.getValue());
    	attributes.add(ModuleBox.getValue());
    	
    	if(TypePicker.getValue().equals("Module Coordinator")){
    		attributes.remove(4);
    		CoordinatorSQL.UploadSingleCoordinator(attributes);
    	} else {
    		attributes.remove(5);
    		attributes.remove(2);
    		StaffSQL.UploadSingleUser(attributes);
    	}
    }

    @FXML
    void Clear(ActionEvent event) {
    	UsernameText.setText("");
    	NameText.setText("");
    	EmailText.setText("");
    	PasswordText.setText("");
    	TypePicker.setValue("");
    	ModuleBox.setValue("");
    }

    @FXML
    void returnStaffMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StaffMenu", "StaffMenu");
    }

    @FXML
    void mainMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }

    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	ModuleBox.setVisible(false);
    	EmailText.setVisible(false);
    	List<String>types= new ArrayList<String>();
    	
    	types.add("Administrator");
    	types.add("Module Coordinator");
    	types.add("Lecturer");
    	
    	TypePicker.getItems().addAll(types);
    	ModuleBox.getItems().addAll(SQL.Modules());
    }
}
