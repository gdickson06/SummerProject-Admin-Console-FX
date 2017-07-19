package application;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.Room;
import uk.ac.qub.churst.SQL;

public class UploadSingleRoomController {

    @FXML
    private TextField RoomNameTextField;

    @FXML
    private TextField RoomCodeTextField;

    @FXML
    void ee0404(ActionEvent event) {

    }

    @FXML
    void UploadSingleRoomUpload(ActionEvent event) throws Exception {
    	List<Room> roomDetails = new ArrayList<Room>();
    	
    	Room singleRoom = new Room(RoomCodeTextField.getText(), RoomNameTextField.getText());
    	roomDetails.add(singleRoom);
    	
    	SQL.saveSQLRooms(roomDetails);
    	GeneralMethods.show("Room has been successfully uploaded to Database", "Room Uploaded");
    	
    }

    @FXML
    void UploadSingleRoomCancel(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

}
