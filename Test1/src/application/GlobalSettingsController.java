package application;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class GlobalSettingsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView image;

    @FXML
    private JFXTextField southernTrustContactNo;

    @FXML
    private JFXTextField southernTrustContactNumber;

    @FXML
    private JFXTextField schoolOfMedicineEmailAddress;

    @FXML
    private JFXTextField personalDayAllowance;

    @FXML
    private JFXTextField belfastTrustContactNumber;

    @FXML
    private JFXTextField northernTrustContactNumber;

    @FXML
    private JFXTextField personalDayPolicy;

    @FXML
    private JFXTextField forgottenPasswordLink;

    @FXML
    private JFXTextField schoolOfMedicineContactNumber;

    @FXML
    private JFXTextField findCurrentAbsencesPolicy;

    @FXML
    private JFXTextField qubITOnlineForm;

    @FXML
    private JFXTextField QUBITHelpdeskWebsite;

    @FXML
    private JFXTextField westernTrustContactNumber;

    @FXML
    private JFXTextField absencesEmailAddress;

    @FXML
    void saveDetails(ActionEvent event) {

    }

    @FXML
    void downloadUserGuide(ActionEvent event) {

    }

    @FXML
    void returnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }

    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	image.setImage(i);
    	
        assert image != null : "fx:id=\"image\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert southernTrustContactNo != null : "fx:id=\"southernTrustContactNo\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert southernTrustContactNumber != null : "fx:id=\"southernTrustContactNumber\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert schoolOfMedicineEmailAddress != null : "fx:id=\"schoolOfMedicineEmailAddress\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert personalDayAllowance != null : "fx:id=\"personalDayAllowance\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert belfastTrustContactNumber != null : "fx:id=\"belfastTrustContactNumber\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert northernTrustContactNumber != null : "fx:id=\"northernTrustContactNumber\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert personalDayPolicy != null : "fx:id=\"personalDayPolicy\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert forgottenPasswordLink != null : "fx:id=\"forgottenPasswordLink\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert schoolOfMedicineContactNumber != null : "fx:id=\"schoolOfMedicineContactNumber\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert findCurrentAbsencesPolicy != null : "fx:id=\"findCurrentAbsencesPolicy\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert qubITOnlineForm != null : "fx:id=\"qubITOnlineForm\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert QUBITHelpdeskWebsite != null : "fx:id=\"QUBITHelpdeskWebsite\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert westernTrustContactNumber != null : "fx:id=\"westernTrustContactNumber\" was not injected: check your FXML file 'GlobalSettings.fxml'.";
        assert absencesEmailAddress != null : "fx:id=\"absencesEmailAddress\" was not injected: check your FXML file 'GlobalSettings.fxml'.";

    }
}
