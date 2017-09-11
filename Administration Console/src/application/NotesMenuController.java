package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.methods.GeneralMethods;

/** 
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This class will be the controller for the sub menu of the notes section,
 * it will hold links to the main menu, lecture note, placement note, log out and general 
 * notes
 * Demographics – 114 LOC 6 Methods 
 * 
 */

public class NotesMenuController {
	
	@FXML
	private Hyperlink logOut;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

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
    	GeneralMethods.ChangeScene("MainMenu", "MainMenu");
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
    	GeneralMethods.ChangeScene("Login", "Login");
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
    	logOut.setText("Not "+ApplicationMethods.CurrentUser.getName()+ "? Log Out Here");
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    

    }
}

