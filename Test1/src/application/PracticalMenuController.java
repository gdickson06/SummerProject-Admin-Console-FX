package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class PracticalMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button amendDeletePlacementButton;

    @FXML
    private Button uploadPlacementCSVButton;

    @FXML
    private Button uploadSinglePlacementButton;

    @FXML
    private ImageView Image;

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
    void uploadSinglePlacementButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSinglePractical", "UploadSinglePractical");
    }

    @FXML
    void amendDeletePlacementButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeletePracticalMenu", "AmendDeletePracticalMenu");
    }

    @FXML
    void uploadPlacementCSVButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadPracticalsCSV", "UploadPracticalsCSV");
    }

    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	
        assert returnMainMenuButton != null : "fx:id=\"returnMainMenuButton\" was not injected: check your FXML file 'PracticalMenuController.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'PracticalMenuController.fxml'.";
        assert amendDeletePlacementButton != null : "fx:id=\"amendDeletePlacementButton\" was not injected: check your FXML file 'PracticalMenuController.fxml'.";
        assert uploadPlacementCSVButton != null : "fx:id=\"uploadPlacementCSVButton\" was not injected: check your FXML file 'PracticalMenuController.fxml'.";
        assert uploadSinglePlacementButton != null : "fx:id=\"uploadSinglePlacementButton\" was not injected: check your FXML file 'PracticalMenuController.fxml'.";
        assert Image != null : "fx:id=\"Image\" was not injected: check your FXML file 'PracticalMenuController.fxml'.";

    }
}


