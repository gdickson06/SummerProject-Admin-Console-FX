package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Room;
import uk.ac.qub.sql.RoomSQL;

public class SelectedRoomController {
	
	private Room r = RoomAmmendDeleteController.SelectedRoom;
	
	private String oldRoomCode;
	
	//Initialising all the FXML objects as variables below
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Delete;

    @FXML
    private TextField RoomNameTextField;

    @FXML
    private Button Amend;

    @FXML
    private Button Back;

    @FXML
    private TextField RoomCodeTextField;

    @FXML
    private Button Home;

    @FXML
    private Label RoomTitle;
    
    //the below method is for amending the selected room onscreen to the database

    @FXML
    void Amend(ActionEvent event) throws ClassNotFoundException, SQLException {
    //order is roomCode followed by roomName
    	List<String> roomList = new ArrayList<String>();
    	
    	roomList.add(RoomCodeTextField.getText());
    	roomList.add(RoomNameTextField.getText());
    	roomList.add(oldRoomCode);
    	
    	RoomSQL.amendRoom(roomList);
    	
    	GeneralMethods.show(r.getCode()+" has been amended successfully.", "Update Successful");
    }
    
    //the below method will return the admin user to the search screen for Rooms
    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("SearchRoomAmmendDelete");
    }
    
    //the below method will return the user to the main menu
    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }
    
    //the below method will delete the selected Room from the database
    @FXML
    void Delete(ActionEvent event) throws ClassNotFoundException, SQLException {
    	RoomSQL.deleteRoom(r.getCode());
    	GeneralMethods.show(r.getCode()+" has been successfully deleted", "Room Deleted");
    }

    @FXML
    void initialize() {
    	//setting the text of the title to the selected room
    	RoomTitle.setText("Room Code: "+String.valueOf(r.getCode())+ " Room Name: "+String.valueOf(r.getName()));
    	//setting the text for the Room Code and Name TextFields
    	RoomCodeTextField.setText(String.valueOf(r.getCode()));
    	RoomNameTextField.setText(String.valueOf(r.getName()));
    	
    	oldRoomCode = r.getCode();
    	
    	
    	
        assert Delete != null : "fx:id=\"Delete\" was not injected: check your FXML file 'SelectRoomAmmend.fxml'.";
        assert RoomNameTextField != null : "fx:id=\"RoomNameTextField\" was not injected: check your FXML file 'SelectRoomAmmend.fxml'.";
        assert Amend != null : "fx:id=\"Amend\" was not injected: check your FXML file 'SelectRoomAmmend.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'SelectRoomAmmend.fxml'.";
        assert RoomCodeTextField != null : "fx:id=\"RoomCodeTextField\" was not injected: check your FXML file 'SelectRoomAmmend.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'SelectRoomAmmend.fxml'.";
        assert RoomTitle != null : "fx:id=\"RoomTitle\" was not injected: check your FXML file 'SelectRoomAmmend.fxml'.";

    }
}
