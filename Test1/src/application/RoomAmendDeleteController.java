/**
 * Sample Skeleton for 'AmendDeleteRoomsMenu.fxml' Controller Class
 */

package application;

import java.util.List;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Room;
import uk.ac.qub.sql.SearchQueries;

public class RoomAmendDeleteController {

	protected static Room SelectedRoom;
    @FXML // fx:id="RoomName"
    private JFXTextField RoomName; // Value injected by FXMLLoader

    @FXML // fx:id="RoomCode"
    private JFXTextField RoomCode; // Value injected by FXMLLoader

    @FXML // fx:id="RoomList"
    private JFXListView<Room> RoomList; // Value injected by FXMLLoader

    @FXML // fx:id="Image"
    private ImageView Image; // Value injected by FXMLLoader

    @FXML
    void returnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }

    @FXML
    void returnRoomsMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("RoomMenu", "RoomMenu");
    }

    @FXML
    void ListClick(MouseEvent event) {
    	if(event.getClickCount()==2){
    		SelectedRoom=RoomList.getSelectionModel().getSelectedItem();
    		System.out.println("clicked on"+SelectedRoom);
    		try {
				GeneralMethods.ChangeScene("AmendsingleRoom","AmendSingleRoom");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    }

    @FXML
    void RoomCodeSearch(ActionEvent event) {
    	List<Room> roomSearch = SearchQueries.searchRoom(1, RoomCode.getText());
    	ObservableList<Room> roomList = FXCollections.observableArrayList();
    	roomList.addAll(roomSearch);
    	RoomList.setItems(roomList);
    }

    @FXML
    void RoomNameSearch(ActionEvent event) {
    	List<Room> roomSearch = SearchQueries.searchRoom(2, RoomName.getText());
    	ObservableList<Room> roomList = FXCollections.observableArrayList();
    	roomList.addAll(roomSearch);
    	RoomList.setItems(roomList);;
    	System.out.println(roomSearch.size());
    }
    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
