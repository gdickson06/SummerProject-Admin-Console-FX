package application;

import com.jfoenix.controls.JFXTextField;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import uk.ac.qub.churst.CSV;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Room;
import uk.ac.qub.sql.RoomSQL;

public class CSVRoomController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Image;

    @FXML
    private JFXTextField filePathTextField;
    
    FileChooser fileChooserWindow = new FileChooser();
    private File file;

    @FXML
    void returnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void returnRoomMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("RoomMenu","RoomMenu");
    }

    @FXML
    void uploadFile(ActionEvent event) {
String filePath = filePathTextField.getText();
    	
    	List<Room> roomList = new ArrayList<Room>();
    	boolean uploadError = false;
    	/*using the readRoomsFromCSV and saveSQLRooms methods from the CSV and
    	* SQL classes to read the rooms from a CSV file and save them into the
    	* database 
    	*/
    	try {
    		roomList= CSV.readRoomsFromCSV(filePath);
    		RoomSQL.saveSQLRooms(roomList);
    		//below catch will display error message if exception occurs
    	} catch (Exception e) {
    		GeneralMethods.show("Error with Rooms Upload, please view handbook", "ERROR");
    		uploadError=true;
    	}
    	/*pop up dialog window will populate of upload is successful and advise of number
    	* rooms that are added 
    	*/
    	if (uploadError == false) {
    		GeneralMethods.show("Upload of Rooms from CSV successful, with "+ roomList.size() +" rooms added to the database", "Rooms Upload Successful");
    	}
    }

    @FXML
    void chooseCSV(ActionEvent event) {
    	GeneralMethods.configureFileChooser(fileChooserWindow);
    	File csvFile = fileChooserWindow.showOpenDialog(Main.getStage());
    	if(csvFile != null){
    		file = csvFile;
    	}
    	filePathTextField.setText(file.getAbsolutePath());
    }

    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
