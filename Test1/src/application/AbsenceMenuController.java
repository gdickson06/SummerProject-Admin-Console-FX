package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class AbsenceMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button searchAbsenceButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button absenceTrendsButton;

    @FXML
    private Button uploadSingleAbsenceButton;

    @FXML
    private ImageView Image;

    @FXML
    void searchAbsenceButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteAbsencesMenu", "AmendDeleteAbsencesMenu");
    }

    @FXML
    void uploadSingleAbsenceButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleAbsence", "UploadSingleAbsence");
    }

    @FXML
    void absenceTrendsButtonClick(ActionEvent event) {
    	//to be completed
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
    
    }
}
