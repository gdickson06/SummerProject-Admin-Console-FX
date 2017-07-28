package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Coordinator;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.User;
import uk.ac.qub.sql.StaffSQL;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField PasswordText;

    @FXML
    private TextField UsernameText;

    @FXML
    private Button LoginButton;

    @FXML
    private Button Clear;

    @FXML
    void Login(ActionEvent event) throws Exception {
    	Staff user = StaffSQL.login(UsernameText.getText(), PasswordText.getText());
    	ApplicationMethods.CurrentUser = user;
    	if(user instanceof Coordinator){
    		GeneralMethods.show("Course coordinator funcationality will be in a future update", "Warning");
    		UsernameText.setText("");
        	PasswordText.setText("");
    	} else if (user instanceof User && ((User) user).getType().equals("Lecturer")){
    		GeneralMethods.show("Lecturer funcationality will be in a future update", "Warning");
    		UsernameText.setText("");
        	PasswordText.setText("");
    	} else if (user instanceof User && ((User) user).getType().equals("Administrator")){
    		
    		System.out.println(((User) user).getType());
    		GeneralMethods.ChangeScene("mainMenu");
    	} else {
    		GeneralMethods.show("Username or Password Incorrect", "Error");
    		UsernameText.setText("");
        	PasswordText.setText("");
    	}
    }

    @FXML
    void Clear(ActionEvent event) {
    	UsernameText.setText("");
    	PasswordText.setText("");
    }

    @FXML
    void initialize() {
        assert PasswordText != null : "fx:id=\"PasswordText\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert UsernameText != null : "fx:id=\"UsernameText\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert LoginButton != null : "fx:id=\"LoginButton\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert Clear != null : "fx:id=\"Clear\" was not injected: check your FXML file 'LoginPage.fxml'.";

    }
}
