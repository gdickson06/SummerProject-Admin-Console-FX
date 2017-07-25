package application;

import java.awt.Window.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uk.ac.qub.sql.CoordinatorSQL;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.StaffSQL;

public class UploadSingleUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField PasswordText;

    @FXML
    private ComboBox<String> ModuleBox;

    @FXML
    private Label ModuleTag;

    @FXML
    private TextField UsernameText;

    @FXML
    private Button Cancel;

    @FXML
    private TextField NameText;

    @FXML
    private Button Upload;

    @FXML
    private ComboBox<String> TypePicker;
    
    @FXML
    private TextField EmailText;

    @FXML
    void TypeDrop(ActionEvent event) {
    	if(TypePicker.getValue().equals("Module Coordinator")){
    		ModuleBox.setVisible(true);
    		EmailText.setVisible(true);
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
    		attributes.remove(3);
    		attributes.remove(4);
    		StaffSQL.UploadSingleUser(attributes);
    	}
    }

    @FXML
    void Cancel(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("mainMenu");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void ModuleDrop(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	ModuleBox.setVisible(false);
    	EmailText.setVisible(false);
    	List<String>types= new ArrayList<String>();
    	
    	types.add("Administrator");
    	types.add("Module Coordinator");
    	types.add("Lecturer");
    	
    	TypePicker.getItems().addAll(types);
    	ModuleBox.getItems().addAll(SQL.Modules());
    	
    	
        assert PasswordText != null : "fx:id=\"PasswordText\" was not injected: check your FXML file 'UploadSingleStaff.fxml'.";
        assert ModuleBox != null : "fx:id=\"ModuleBox\" was not injected: check your FXML file 'UploadSingleStaff.fxml'.";
        assert ModuleTag != null : "fx:id=\"ModuleTag\" was not injected: check your FXML file 'UploadSingleStaff.fxml'.";
        assert UsernameText != null : "fx:id=\"UsernameText\" was not injected: check your FXML file 'UploadSingleStaff.fxml'.";
        assert Cancel != null : "fx:id=\"Cancel\" was not injected: check your FXML file 'UploadSingleStaff.fxml'.";
        assert NameText != null : "fx:id=\"NameText\" was not injected: check your FXML file 'UploadSingleStaff.fxml'.";
        assert Upload != null : "fx:id=\"Upload\" was not injected: check your FXML file 'UploadSingleStaff.fxml'.";
        assert TypePicker != null : "fx:id=\"TypePicker\" was not injected: check your FXML file 'UploadSingleStaff.fxml'.";

    }
}
