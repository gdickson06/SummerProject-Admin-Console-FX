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
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.churst.SearchQueries;
import uk.ac.qub.objects.Room;

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
    private Button RoomCodeSearch;

    @FXML
    private Button roomCancelButton;

    @FXML
    private Button roomNameSearch;

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
    }

    @FXML
    void roomNameSearch(ActionEvent event) {
    	List<Room> roomSearch = SearchQueries.searchRoom(2, roomName.getText());
    	ObservableList<Room> roomList = FXCollections.observableArrayList();
    	roomList.addAll(roomSearch);
    	listOfRooms.setItems(roomList);;
    	System.out.println(roomSearch.size());
    }
    
    @FXML
    void roomTableClicked(MouseEvent event){
    	if(event.getClickCount()==2){
    		SelectedRoom=listOfRooms.getSelectionModel().getSelectedItem();
    		System.out.println("clicked on"+SelectedRoom);
    		try {
				GeneralMethods.ChangeScene("SelectRoomAmend");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }
    
    @FXML
    void initialize(){
    	assert RoomCodeSearch != null : "fx:id=\"RoomCodeSearch\" was not injected: check your FXML file 'SearchAbsenceDelete.fxml'.";
        assert listOfRooms != null : "fx:id=\"listOfRooms\" was not injected: check your FXML file 'SearchAbsenceDelete.fxml'.";
        assert roomCancelButton != null : "fx:id=\"roomCancelButton\" was not injected: check your FXML file 'SearchAbsenceDelete.fxml'.";
        assert roomNameSearch != null : "fx:id=\"roomNameSearch\" was not injected: check your FXML file 'SearchAbsenceDelete.fxml'.";
        assert roomCode != null : "fx:id=\"roomCode\" was not injected: check your FXML file 'SearchAbsenceDelete.fxml'.";
        assert roomName != null : "fx:id=\"roomName\" was not injected: check your FXML file 'SearchAbsenceDelete.fxml'.";
    }

}