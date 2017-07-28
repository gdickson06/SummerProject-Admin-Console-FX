package application;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.FileWriter;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.sql.StaffSQL;

public class SettingsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField DefaultSave;

    @FXML
    private TextField OldPW;

    @FXML
    private TextField Repeat;

    @FXML
    private TextField NewPW;

   

    @FXML
    void ChangeLocation(ActionEvent event) {
    	FileWriter.save(DefaultSave.getText().replace("\\" , "/"));
    	GeneralMethods.show("Location changed to" + DefaultSave.getText(), "Location Changed");
    }

    @FXML
    void ChangePW(ActionEvent event) throws ClassNotFoundException, SQLException {
    	System.out.println(OldPW.getText());
    	System.out.println(ApplicationMethods.CurrentUser.getPassword());
    	if(OldPW.getText().equals(ApplicationMethods.CurrentUser.getPassword())){
    		if (NewPW.getText().equals(Repeat.getText())){
    			StaffSQL.changePassword(ApplicationMethods.CurrentUser.getStaffNumber(), NewPW.getText());
    			ApplicationMethods.CurrentUser.setPassword(NewPW.getText());
    		} else {
    			GeneralMethods.show("Passwords do not match", "Error");
    		}
    		
    	} else {
    		GeneralMethods.show("Old Password Incorrect", "Error");
    	}
    }

    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void initialize() {
    	
    	try {
			DefaultSave.setText(FileWriter.load());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        assert DefaultSave != null : "fx:id=\"DefaultSave\" was not injected: check your FXML file 'Settings.fxml'.";
        assert OldPW != null : "fx:id=\"OldPW\" was not injected: check your FXML file 'Settings.fxml'.";
        assert Repeat != null : "fx:id=\"Repeat\" was not injected: check your FXML file 'Settings.fxml'.";
        assert NewPW != null : "fx:id=\"NewPW\" was not injected: check your FXML file 'Settings.fxml'.";

    }
}
