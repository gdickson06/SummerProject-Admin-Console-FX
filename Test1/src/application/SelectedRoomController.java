package application;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Room;
import uk.ac.qub.sql.RoomSQL;

public class SelectedRoomController {
	private Room r = RoomAmendDeleteController.SelectedRoom;
	private String oldRoomCode;

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
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteRoomsMenu", "AmendDeleteRoomsMenu");
        
    }

    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }

    @FXML
    void ReturnRoomsScreen(ActionEvent event) throws Exception {
     	GeneralMethods.ChangeScene("RoomMenu", "RoomMenu");
        
    }

    @FXML
    void Delete(ActionEvent event) throws ClassNotFoundException, SQLException {
    	RoomSQL.deleteRoom(r.getCode());
    	GeneralMethods.show(r.getCode()+" has been successfully deleted", "Room Deleted");
    
    }

    @FXML
    void SaveChanges(ActionEvent event) throws ClassNotFoundException, SQLException {
	List<String> roomList = new ArrayList<String>();
    	
    	roomList.add(RoomCodeTextField.getText());
    	roomList.add(RoomNameTextField.getText());
    	roomList.add(oldRoomCode);
    	
    	RoomSQL.amendRoom(roomList);
    	
    	GeneralMethods.show(r.getCode()+" has been amended successfully.", "Update Successful");
   
    }

    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	oldRoomCode = r.getCode();
    	RoomCodeTextField.setText(String.valueOf(r.getCode()));
    	RoomNameTextField.setText(String.valueOf(r.getName()));
    	
    }
}
