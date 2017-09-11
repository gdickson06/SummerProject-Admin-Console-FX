package application;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Room;
import uk.ac.qub.sql.SearchQueries;

/** 
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This is the controller class for the Amend Delete room page
 * this will allow rooms to be searched
 * Demographics – 125 LOC 6 Methods 
 * 
 */
public class RoomAmendDeleteController {

	protected static Room SelectedRoom;
 @FXML
    private JFXTextField RoomName; 
 @FXML
    private JFXTextField RoomCode; 
 @FXML
    private JFXListView<Room> RoomList; 
 @FXML
    private ImageView Image;
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void returnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu", "MainMenu");
    }
/**
 * This method will return the user to the rooms menu
 * @param event
 * @throws Exception
 */
    @FXML
    void returnRoomsMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("RoomMenu", "RoomMenu");
    }
/**
 * This method will allow the user to click on a room to go to the amend 
 * delete room menu with that room selected
 * @param event
 */
    @FXML
    void ListClick(MouseEvent event) {
    	if(event.getClickCount()==2){
    		SelectedRoom=RoomList.getSelectionModel().getSelectedItem();
    		try {
				GeneralMethods.ChangeScene("AmendsingleRoom","AmendSingleRoom");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
    	}
    }
/**
 * This method will allow a user to search rooms by the room code
 * @param event
 */
    @FXML
    void RoomCodeSearch(ActionEvent event) {
    	List<Room> roomSearch = new ArrayList<Room>();
    	try {
    		
    		List<Room>r = SearchQueries.searchRoom(1, RoomCode.getText());
			roomSearch.addAll(r);
		} catch (SQLException e) {
			GeneralMethods.show("Error when Searching rooms", "Error");
			e.printStackTrace();
		}
    	ObservableList<Room> roomList = FXCollections.observableArrayList();
    	roomList.addAll(roomSearch);
    	RoomList.setItems(roomList);
    }
/**
 * This method will allow a user to search rooms by room name
 * @param event
 */
    @FXML
    void RoomNameSearch(ActionEvent event) {
    	List<Room> roomSearch = new ArrayList<Room>();
    	try {
			roomSearch.addAll(SearchQueries.searchRoom(2, RoomName.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error when Searching rooms", "Error");
			e.printStackTrace();
		}
    	ObservableList<Room> roomList = FXCollections.observableArrayList();
    	roomList.addAll(roomSearch);
    	RoomList.setItems(roomList);
    	
    }
    
    /**
     * This intiailize method will populate the image on the page
     */
    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	
    }
}
