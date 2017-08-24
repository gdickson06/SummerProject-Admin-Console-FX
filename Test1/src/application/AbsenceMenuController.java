package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;

public class AbsenceMenuController {
	
	 @FXML
	    private Label LogOut;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button searchAbsenceButton;

    @FXML
    private Button absenceTrendsButton;

    @FXML
    private Button uploadSingleAbsenceButton;

    @FXML
    private ImageView Image;
    /**
	 * This method will change the screen to the Amend delete absence menu.
	 * 
	 * @param event
	 * @throws Exception
	 */
    @FXML
    void searchAbsenceButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteAbsencesMenu", "AmendDeleteAbsencesMenu");
    }
    /**
	 * This method will change the screen to the upload single absence menu
	 * 
	 * @param event
	 * @throws Exception
	 */
    @FXML
    void uploadSingleAbsenceButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleAbsence", "UploadSingleAbsence");
    }

    @FXML
    void absenceTrendsButtonClick(ActionEvent event) {
    	//to be completed
    }
	/**
	 * This method will log the current user out, it will clear the current user
	 * and change the scene to the login screen
	 * 
	 * @param event
	 * @throws Exception
	 */
    @FXML
    void logOut(MouseEvent event) throws Exception {
    	GeneralMethods.ChangeScene("Login2", "Login2");
    	ApplicationMethods.CurrentUser=null;
    }
    /**
 	 * This method will change the screen to the main menu
 	 * 
 	 * @param event
 	 * @throws Exception
 	 */
    @FXML
    void returnMainMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }
    /**
     * The initialize method will do all the work before the page loads up and in this page it will only
     * load the QUB image in the top right hand corner
     */
    @FXML
    void initialize() {
    	LogOut.setText("Not "+ ApplicationMethods.CurrentUser.getName()+ " log out");
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    
    }
}
