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
import uk.ac.qub.methods.GeneralMethods;
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
/**
 * This method will take the user back to the searching room menu
 * @param event
 * @throws Exception
 */
    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteRoomsMenu", "AmendDeleteRoomsMenu");
        
    }
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }
/**
 * This method will return the user to the room screen
 * @param event
 * @throws Exception
 */
    @FXML
    void ReturnRoomsScreen(ActionEvent event) throws Exception {
     	GeneralMethods.ChangeScene("RoomMenu", "RoomMenu");
        
    }
/**
 * This method will delete a room from the database
 * @param event
 * @throws ClassNotFoundException
 * @throws SQLException
 */
    @FXML
    void Delete(ActionEvent event) {
    	try{
    	RoomSQL.deleteRoom(r.getCode());
    	GeneralMethods.show(r.getCode()+" has been successfully deleted", "Room Deleted");
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    	} catch (Exception e){
    		GeneralMethods.show("Error with deleting room", "Error");
    	}
    }
/**
 * This method will amend a room on the database, the method is special as unlike
 * all the other objects we are allowing the user to amend the primary key as these
 * are likely to be changed such as room codes, this means we will be passing in a 
 * list of strings rather than an object.
 * @param event
 * @throws ClassNotFoundException
 * @throws SQLException
 */
    @FXML
    void SaveChanges(ActionEvent event) throws ClassNotFoundException, SQLException {
	List<String> roomList = new ArrayList<String>();
    	
    	roomList.add(RoomCodeTextField.getText());
    	roomList.add(RoomNameTextField.getText());
    	roomList.add(oldRoomCode);
    	
    	RoomSQL.amendRoom(roomList);
    	
    	GeneralMethods.show(r.getCode()+" has been amended successfully.", "Update Successful");
   
    }
/**
 * The initialize method will populate the fields of the room code and room description
 * along with the image however in this method we also have a hidden string called
 * old room code which is populated and will be used in the save changes method
 */
    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	oldRoomCode = r.getCode();
    	RoomCodeTextField.setText(String.valueOf(r.getCode()));
    	RoomNameTextField.setText(String.valueOf(r.getName()));
    	
    }
}
