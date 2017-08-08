package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class StudentMenuController {

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
    private Button logOutButton;

    @FXML
    private Button ammendDeleteStudentsButton;

    @FXML
    private Button uploadStudentCSVButton;

    @FXML
    void uploadStudentCSVButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadStudentCSV", "UploadStudentCSV");
    }

    @FXML
    void ammendDeleteStudentsButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteStudentMenu","AmendDeleteStudentMenu");
    }

    @FXML
    void uploadSingleStudentButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleStudentMenu", "UploadSingleStudentMenu");
    }

    @FXML
    void logOutButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("Login2", "Login2");
    	ApplicationMethods.CurrentUser=null;
    }

    @FXML
    void returnMainMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }

    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	
        assert uploadSingleStudentButton != null : "fx:id=\"uploadSingleStudentButton\" was not injected: check your FXML file 'StudentMenu.fxml'.";
        assert returnMainMenuButton != null : "fx:id=\"returnMainMenuButton\" was not injected: check your FXML file 'StudentMenu.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'StudentMenu.fxml'.";
        assert ammendDeleteStudentsButton != null : "fx:id=\"ammendDeleteStudentsButton\" was not injected: check your FXML file 'StudentMenu.fxml'.";
        assert uploadStudentCSVButton != null : "fx:id=\"uploadStudentCSVButton\" was not injected: check your FXML file 'StudentMenu.fxml'.";

    }
}
