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
 * Outline - This is the controller class for the PDF menu it will contain
 * links to create and input PDFs along with a method to return to main menu and log out
 * Demographics – 97 LOC 4 Methods 
 * 
 */
public class PDFMenuController {
	
	@FXML
	private Hyperlink logOut;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private ImageView Image;

    @FXML
    private Button inputPDFButton;

    @FXML
    private Button createPDFButton;
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
   	 * This method will change the screen to the input PDF lecture screen
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    @FXML
    void inputPDFButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("InputPDF", "InputPDF");
    }
    /**
   	 * This method will change the screen to the create PDF lecture screen
   	 * 
   	 * @param event
   	 * @throws Exception
   	 */
    @FXML
    void createPDFButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("CreatePDF","CreatePDF");
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

