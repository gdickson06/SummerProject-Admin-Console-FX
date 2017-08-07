package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class SettingsHelpMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button SettingsMenu;

    @FXML
    private Button logOutButton;

    @FXML
    private ImageView Image;

    @FXML
    private Button UserGuide;

    @FXML
    void SettingsMenuClick(ActionEvent event) {
    	//to be completed
    }

    @FXML
    void UserGuideClick(ActionEvent event) {
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
    	
        assert returnMainMenuButton != null : "fx:id=\"returnMainMenuButton\" was not injected: check your FXML file 'SettingsHelpMenu.fxml'.";
        assert SettingsMenu != null : "fx:id=\"SettingsMenu\" was not injected: check your FXML file 'SettingsHelpMenu.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'SettingsHelpMenu.fxml'.";
        assert Image != null : "fx:id=\"Image\" was not injected: check your FXML file 'SettingsHelpMenu.fxml'.";
        assert UserGuide != null : "fx:id=\"UserGuide\" was not injected: check your FXML file 'SettingsHelpMenu.fxml'.";

    }
}
