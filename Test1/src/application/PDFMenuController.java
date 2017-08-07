package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class PDFMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button logOutButton;

    @FXML
    private ImageView Image;

    @FXML
    private Button inputPDFButton;

    @FXML
    private Button createPDFButton;

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
    void inputPDFButtonClick(ActionEvent event) {
    	//to be completed
    }

    @FXML
    void createPDFButtonClick(ActionEvent event) {
    	//to be completed
    }

    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	
        assert returnMainMenuButton != null : "fx:id=\"returnMainMenuButton\" was not injected: check your FXML file 'PDFMenu.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'PDFMenu.fxml'.";
        assert Image != null : "fx:id=\"Image\" was not injected: check your FXML file 'PDFMenu.fxml'.";
        assert inputPDFButton != null : "fx:id=\"inputPDFButton\" was not injected: check your FXML file 'PDFMenu.fxml'.";
        assert createPDFButton != null : "fx:id=\"createPDFButton\" was not injected: check your FXML file 'PDFMenu.fxml'.";

    }
}

