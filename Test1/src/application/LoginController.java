package application;


import java.net.URI;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;


import uk.ac.qub.objects.Staff;
import uk.ac.qub.sql.StaffSQL;

public class LoginController {
	
	@FXML
	private Hyperlink info;

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
/**
 * This method will attempt to login the user to the system, if there is 
 * no user passed back via the StaffSQL.login method the user will get a warning
 * about an incorrect username and password, if the user passed back is not an admin
 * user there will be a warning about the lecturer and module coordinator funcationality
 * not appearing in this update
 * @param event
 * @throws Exception
 */
    @FXML
    void Login(ActionEvent event) throws Exception {
    	if(UsernameText.getText().isEmpty()||PasswordText.getText().isEmpty()){
    		GeneralMethods.show("Username or password field empty", "Warning");
    	} else {
    	Staff user = StaffSQL.login(UsernameText.getText(), PasswordText.getText());
    	
    	ApplicationMethods.CurrentUser = user;
    	if(user.getAccess_level().equals("Administrator")){
    		GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    	} else {
    		GeneralMethods.show("Functionality for non admin staff will be implemented in a future update", "Warning");
    	}
    }}
/**
 * This method will clear the username and password field
 * @param event
 */
    @FXML
    void Clear(ActionEvent event) {
    	UsernameText.setText("");
    	PasswordText.setText("");
    }
    
    /**
     * This method is for when a user has forgotten their password, it will try 
     * to open up the QSIS forgotten password page on the user's broswer
     * if there is an error a pop up will appear warning the user of this.
     * @param event
     */
    @FXML
    void ForgotPassword(ActionEvent event) {
    	
    	try {
			java.awt.Desktop.getDesktop().browse(new URI("https://pss.qub.ac.uk/pwm/public/ForgottenPassword"));
		} catch (Exception e) {
			GeneralMethods.show("Error connecting to website", "Error");
		} 
    }
    
    /**
     * The initialize method will do all the work before the page loads up and in this page it will only
     * load the QUB image in the top right hand corner
     */
    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	
    
    }
}
