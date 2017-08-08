package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class MainMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Image;

    @FXML
    void Student(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StudentMenu", "StudentMenu");
    }

    @FXML
    void Lecture(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("LectureMenu", "LectureMenu");
    }

    @FXML
    void Practical(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("PracticalMenuController", "PracticalPlacementMenu");
    }

    @FXML
    void Room(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("RoomMenu", "RoomMenu");
    }

    @FXML
    void Absence(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AbsenceMenu", "AbsenceMenu");
    }

    @FXML
    void PDF(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("PDFMenu", "PDFMenu");
    }

    @FXML
    void Staff(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StaffMenu", "StaffMenu");
    }

    @FXML
    void Notes(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("NotesMenu", "NotesMenu");
    }

    @FXML
    void Settings(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("SettingsHelpMenu", "SettingsHelpMenu");
    }

    @FXML
    void LogOut(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("Login2", "Login2");
    	ApplicationMethods.CurrentUser=null;
    }

    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
        
    }
}
