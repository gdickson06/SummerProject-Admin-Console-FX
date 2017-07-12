package application;

import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.Room;
import uk.ac.qub.churst.SearchQueries;

public class RoomAmmendDeleteController {
	
	protected static Room SelectedRoom;
	@FXML
	private ResourceBundle resources;

    @FXML
    private TextField roomCode;

    @FXML
    private Button roomCancel;

    @FXML
    private TextField roomName;
    
    @FXML
    private ListView<Room> listOfRooms;

    @FXML
    void roomCancelButton(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu");
    }

    @FXML
    void roomCodeSearch(ActionEvent event) {
    	List<Room> roomSearch = SearchQueries.searchRoom(1, roomCode.getText());
    	ObservableList<Room> roomList = FXCollections.observableArrayList();
    	roomList.addAll(roomSearch);
    	listOfRooms.setItems(roomList);
    	System.out.println(roomSearch.size());
    }

    @FXML
    void roomNameSearch(ActionEvent event) {
    	List<Room> roomSearch = SearchQueries.searchRoom(2, roomName.getText());
    	ObservableList<Room> roomList = FXCollections.observableArrayList();
    	roomList.addAll(roomSearch);
    	listOfRooms.setItems(roomList);
    	System.out.println(roomSearch.size());
    }
    
    @FXML
    void ListClicked(MouseEvent event) throws Exception {
    	if(event.getClickCount()==2){
    		SelectedRoom=listOfRooms.getSelectionModel().getSelectedItem();
    		System.out.println("clicked on"+SelectedRoom);
    		GeneralMethods.ChangeScene("SelectedRoom");
    	}
    }
    
    @FXML
    void initialize(){
    	assert roomCode != null :"fx:id=\"roomCode\" was not injected: check the FXML file 'RoomAmmendDelete.fxml'.";
    	assert roomName != null :"fx:id=\"roomName\" was not injected: check the FXML file 'RoomAmmendDelete.fxml'.";
    }

}