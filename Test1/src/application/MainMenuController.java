package application;

import java.awt.Font;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;

public class MainMenuController {
	
	 @FXML
	    private Label LogOut;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView Image;

	/**
	 * This method will change the screen to the student menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void Student(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("StudentMenu", "StudentMenu");
	}

	/**
	 * This method will change the screen to the lecture menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void Lecture(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("LectureMenu", "LectureMenu");
	}

	/**
	 * This method will change the screen to the practical menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void Placement(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("PracticalMenuController", "PracticalPlacementMenu");
	}

	/**
	 * This method will change the screen to the room menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void Room(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("RoomMenu", "RoomMenu");
	}

	/**
	 * This method will change the screen to the Absence menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void Absence(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("AbsenceMenu", "AbsenceMenu");
	}

	/**
	 * This method will change the screen to the PDF menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void PDF(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("PDFMenu", "PDFMenu");
	}

	/**
	 * This method will change the screen to the staff menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void Staff(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("StaffMenu", "StaffMenu");
	}

	/**
	 * This method will change the screen to the notes menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void Notes(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("NotesMenu", "NotesMenu");
	}

	/**
	 * This method will change the screen to the settings menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void Settings(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("GlobalSettings", "GlobalSettings");
	}

	/**
	 * This method will log the current user out, it will clear the current user
	 * and change the scene to the login screen
	 * 
	 * @param event
	 * @throws Exception
	 */

	  @FXML
	    void LogOut(MouseEvent event) throws Exception {
		  GeneralMethods.ChangeScene("Login2", "Login2");
			ApplicationMethods.CurrentUser = null;
	    }
	/**
	 * The initialize method will do all the work before the page loads up and
	 * in this page it will only load the QUB image in the top right hand corner
	 */
	@FXML
	void initialize() {
		LogOut.setText("Not "+ ApplicationMethods.CurrentUser.getName()+ " log out");
		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
		Image.setImage(i);

	}
}
