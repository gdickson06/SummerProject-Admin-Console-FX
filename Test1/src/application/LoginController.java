package application;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Coordinator;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.sql.StaffSQL;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ImageView Image;

    @FXML
    private JFXPasswordField PasswordText;

    @FXML
    private JFXTextField UsernameText;

    @FXML
    private JFXButton LoginButton;

    @FXML
    private JFXButton Clear;
    
    @FXML
    private JFXButton ForgotPassword;

    @FXML
    void Login(ActionEvent event) throws Exception {
    	Staff user = StaffSQL.login(UsernameText.getText(), PasswordText.getText());
    	ApplicationMethods.CurrentUser = user;
    	if(user instanceof Coordinator){
    		GeneralMethods.show("Course coordinator funcationality will be in a future update", "Warning");
    		UsernameText.setText("");
        	PasswordText.setText("");
    	} else if (user instanceof Staff && ((Staff) user).getType().equals("Lecturer")){
    		GeneralMethods.show("Lecturer funcationality will be in a future update", "Warning");
    		UsernameText.setText("");
        	PasswordText.setText("");
    	} else if (user instanceof Staff && ((Staff) user).getType().equals("Administrator")){
    		
    		System.out.println(((Staff) user).getType());
    		GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
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
    void ForgotPassword(ActionEvent event) {

    }
    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	
        assert PasswordText != null : "fx:id=\"PasswordText\" was not injected: check your FXML file 'Login2.fxml'.";
        assert UsernameText != null : "fx:id=\"UsernameText\" was not injected: check your FXML file 'Login2.fxml'.";
        assert LoginButton != null : "fx:id=\"LoginButton\" was not injected: check your FXML file 'Login2.fxml'.";
        assert Clear != null : "fx:id=\"Clear\" was not injected: check your FXML file 'Login2.fxml'.";

    }
}
