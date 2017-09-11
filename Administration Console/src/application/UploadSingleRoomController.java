package application;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Room;
import uk.ac.qub.sql.RoomSQL;
/** 
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This is the controller class to upload a single room to the database,
 * the methods will be able to upload the room and to clear to fields.
 * Demographics – 98 LOC 5 Methods 
 * 
 */
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
/**
 * This method will upload a single room
 * @param event
 * @throws Exception
 */
    @FXML
    void UploadSingleRoomUpload(ActionEvent event) throws Exception {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(RoomCodeTextField);
		fields.add(RoomNameTextField);
	
		
		if(ApplicationMethods.noNullValues(fields)){
	List<Room> roomDetails = new ArrayList<Room>();
    	
    	Room singleRoom = new Room(RoomCodeTextField.getText(), RoomNameTextField.getText());
    	roomDetails.add(singleRoom);
    	
    	RoomSQL.saveSQLRooms(roomDetails);
    	GeneralMethods.show("Room has been successfully uploaded to Database", "Room Uploaded");
		}
    }
/**
 * This method will clear all data input in the textfields
 * @param event
 */
    @FXML
    void Clear(ActionEvent event) {
       RoomNameTextField.setText("");

       RoomCodeTextField.setText("");
    }
/**
 * This method will return the user to the rooms menu
 * @param event
 * @throws Exception
 */
    @FXML
    void RoomsMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("RoomMenu","RoomMenu");
    }
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void MainMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
    }
/**
 * The initialize method will populate the image on the screen
 */
    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
