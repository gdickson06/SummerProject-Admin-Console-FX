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
 * Outline - The is the controller class for the lecture sub menu this will contain
 * links to the 3 main actions that involved lectures
 * Demographics – 112 LOC 6 Methods 
 * 
 */
public class LectureMenuController {
	@FXML
	private Hyperlink logOut;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ImageView Image;

    @FXML
    private Button uploadSingleLectureButton;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button amendDeleteLectureButton;

    @FXML
    private Button uploadLectureCSVButton;
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
   	 * This method will change the screen to the upload single lecture screen
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    @FXML
    void uploadSingleLectureButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleLecture", "UploadSingleLecture");
    }
    /**
   	 * This method will change the screen to the amend delete lecture screen
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    @FXML
    void amendDeleteLectureButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteLectureMenu", "AmendDeleteLectureMenu");
    }
    /**
   	 * This method will change the screen to the upload lecture CSV menu screen
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    @FXML
    void uploadLectureCSVButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadLectureCSV", "UploadLectureCSV");
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
