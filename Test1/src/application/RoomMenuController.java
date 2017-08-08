package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class RoomMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button amendDeleteRoomButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button uploadSingleRoomButton;

    @FXML
    private Button uploadRoomCSVButton;

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
    void uploadSingleRoomButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleRoom","UploadSingleRoom");
    }

    @FXML
    void amendDeleteRoomButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteRoomsMenu", "AmendDeleteRoomsMenu");
    }

    @FXML
    void uploadRoomCSVButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadRoomsCSV", "UploadRoomsCSV");
    }

    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	
      
    }
}
