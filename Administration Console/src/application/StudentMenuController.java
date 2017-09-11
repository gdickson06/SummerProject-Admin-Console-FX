package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.methods.GeneralMethods;
/** 
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - The is the controller class for the student sub menu this will contain
 * links to the 3 main actions that involved students
 * Demographics – 113 LOC 6 Methods 
 * 
 */
public class StudentMenuController {
	
	@FXML
	private Hyperlink logOut;
	
	@FXML
    private Label LogOut;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private ImageView Image;

    @FXML
    private Button uploadSingleStudentButton;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button ammendDeleteStudentsButton;

    @FXML
    private Button uploadStudentCSVButton;
	/**
	 * This method will change the screen to the Upload CSV screen
	 * 
	 * @param event
	 * @throws Exception
	 */
    @FXML
    void uploadStudentCSVButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadStudentCSV", "UploadStudentCSV");
    }
	/**
	 * This method will change the screen to the amend delete menu
	 * 
	 * @param event
	 * @throws Exception
	 */
    @FXML
    void ammendDeleteStudentsButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteStudentMenu","AmendDeleteStudentMenu");
    }
	/**
	 * This method will change the screen to the upload single student menu
	 * 
	 * @param event
	 * @throws Exception
	 */
    @FXML
    void uploadSingleStudentButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleStudentMenu", "UploadSingleStudentMenu");
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
