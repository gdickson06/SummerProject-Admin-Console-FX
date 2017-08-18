package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class NotesMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button practicalNoteButton;

    @FXML
    private Button lectureNoteButton;

    @FXML
    private ImageView Image;

    @FXML
    private Button generalNoteButton;
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
   	 * This method will change the screen note screen for the entire year
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    @FXML
    void generalNoteButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("GeneralNoteMenu", "GeneralNoteMenu");
    }
    /**
   	 * This method will change the screen to the note screen for a practical
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    @FXML
    void practicalNoteButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("PracticalNoteMenu", "PracticalNoteMenu");
    }
    /**
   	 * This method will change the screen to the note screen for a lecture
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    @FXML
    void lectureNoteButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("LectureNoteMenu", "LectureNoteMenu");
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

