package application;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Room;
import uk.ac.qub.sql.RoomSQL;

public class UploadSingleRoomController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField RoomNameTextField;

    @FXML
    private JFXTextField RoomCodeTextField;

    @FXML
    private ImageView Image;

    @FXML
    void UploadSingleRoomUpload(ActionEvent event) throws Exception {
	List<Room> roomDetails = new ArrayList<Room>();
    	
    	Room singleRoom = new Room(RoomCodeTextField.getText(), RoomNameTextField.getText());
    	roomDetails.add(singleRoom);
    	
    	RoomSQL.saveSQLRooms(roomDetails);
    	GeneralMethods.show("Room has been successfully uploaded to Database", "Room Uploaded");
    	
    }

    @FXML
    void Clear(ActionEvent event) {
       RoomNameTextField.setText("");

       RoomCodeTextField.setText("");
    }

    @FXML
    void RoomsMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("RoomMenu","RoomMenu");
    }

    @FXML
    void MainMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MeainMenu3","MainMenu3");
    }

    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
