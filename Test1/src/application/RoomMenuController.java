package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;

public class RoomMenuController {
	
	@FXML
	private Hyperlink logOut;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button amendDeleteRoomButton;

    @FXML
    private Button uploadSingleRoomButton;

    @FXML
    private Button uploadRoomCSVButton;

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
    void logOut(MouseEvent event) throws Exception {
    	GeneralMethods.ChangeScene("Login2", "Login2");
    	ApplicationMethods.CurrentUser=null;
    }
	/**
	 * This method will change the screen to the upload single room menu
	 * 
	 * @param event
	 * @throws Exception
	 */
    @FXML
    void uploadSingleRoomButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleRoom","UploadSingleRoom");
    }
	/**
	 * This method will change the screen to the amend delete menu
	 * 
	 * @param event
	 * @throws Exception
	 */
    @FXML
    void amendDeleteRoomButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteRoomsMenu", "AmendDeleteRoomsMenu");
    }
	/**
	 * This method will change the screen to the upload CSV menu
	 * 
	 * @param event
	 * @throws Exception
	 */
    @FXML
    void uploadRoomCSVButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadRoomsCSV", "UploadRoomsCSV");
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
