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
 * Outline - The is the controller class for the placement sub menu this will contain
 * links to the 3 main actions that involved placements
 * Demographics � 111 LOC 6 Methods 
 * 
 */
public class PracticalMenuController {
	
	@FXML
	private Hyperlink logOut;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button amendDeletePlacementButton;

    @FXML
    private Button uploadPlacementCSVButton;

    @FXML
    private Button uploadSinglePlacementButton;

    @FXML
    private ImageView Image;
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
   	 * This method will change the screen to the upload single placement screen
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    @FXML
    void uploadSinglePlacementButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSinglePractical", "UploadSinglePractical");
    }
    /**
   	 * This method will change the screen to the amend delete placement menu
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    @FXML
    void amendDeletePlacementButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeletePracticalMenu", "AmendDeletePracticalMenu");
    }
    /**
   	 * This method will change the screen to the upload CSV menu
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    @FXML
    void uploadPlacementCSVButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadPracticalsCSV", "UploadPracticalsCSV");
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


