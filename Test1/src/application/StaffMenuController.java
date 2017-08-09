package application;

import java.net.URL;
import java.util.ResourceBundle;

import com.sun.javafx.image.impl.General;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class StaffMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button uploadSingleStaffButton;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button uploadStaffCSVButton;

    @FXML
    private Button amendDeleteStaffButton;

    @FXML
    private ImageView Image;

    @FXML
    void uploadStaffCSVButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadStaffCSV", "UploadStaffCSV");
    }

    @FXML
    void amendDeleteStaffButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteStaff", "AmendDeleteStaff");
    }

    @FXML
    void uploadSingleStaffButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleStaff", "UploadSingleStaff");
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

