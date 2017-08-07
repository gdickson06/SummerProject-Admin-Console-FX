package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.image.impl.General;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class LectureMenuController {

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
    private Button logOutButton;

    @FXML
    private Button uploadLectureCSVButton;

    @FXML
    void returnMainMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }

    @FXML
    void logOutButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("Login2", "Login2");
    	ApplicationMethods.CurrentUser=null;
    }

    @FXML
    void uploadSingleLectureButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleLecture", "UploadSingleLecture");
    }

    @FXML
    void amendDeleteLectureButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteLectureMenu", "AmendDeleteLectureMenu");
    }

    @FXML
    void uploadLectureCSVButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadLectureCSV", "UploadLectureCSV");
    }

    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	
        assert uploadSingleLectureButton != null : "fx:id=\"uploadSingleLectureButton\" was not injected: check your FXML file 'LectureMenu.fxml'.";
        assert returnMainMenuButton != null : "fx:id=\"returnMainMenuButton\" was not injected: check your FXML file 'LectureMenu.fxml'.";
        assert amendDeleteLectureButton != null : "fx:id=\"ammendDeleteLectureButton\" was not injected: check your FXML file 'LectureMenu.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'LectureMenu.fxml'.";
        assert uploadLectureCSVButton != null : "fx:id=\"uploadLectureCSVButton\" was not injected: check your FXML file 'LectureMenu.fxml'.";

    }
}
