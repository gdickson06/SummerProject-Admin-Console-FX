package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class SettingsHelpMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button localSettinsButton;
    
    @FXML
    private Button globalSettingsButton;

    @FXML
    private Button logOutButton;

    @FXML
    private ImageView Image;

    @FXML
    private Button UserGuide;
    /**
   	 * This method will change the screen to the personal settings menu
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    
    /**
     * This method will allow changes to be made to any amendable content
     * within the application, such as QUB email address, contact numbers
     * and more
     * @param event
     * @throws Exception 
     */
    
    @FXML
    void globalSettingsClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("GlobalSettings", "GlobalSettings");
    }
    
    @FXML
    void localSettingsClick(ActionEvent event) {
    	//to be completed
    }
    /**
   	 * This method will change the screen to the user guide
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    @FXML
    void UserGuideClick(ActionEvent event) {
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
    void logOutButtonClick(ActionEvent event) throws Exception {
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
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	
      
    }
}
