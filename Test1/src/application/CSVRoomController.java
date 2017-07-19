package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import uk.ac.qub.churst.Room;
import uk.ac.qub.churst.SQL;
import uk.ac.qub.churst.CSV;

public class CSVRoomController {

    @FXML
    private TextField SelectedRoomFilePath;
    
    //creating an instance of the FileChooser Class from the JavaFX superclass
    FileChooser fileChooserWindow = new FileChooser();
    //creating an instance of the file class
    File file;
    
    /*creating the SelectRoomFileButton onClick method, which will 
     * allow the use to select a CSV file from a filepath. The method
     * uses the configureFileChooser class from the  GeneralMehtods
     * class
     */
    
    @FXML
    void SelectRoomFileButton(ActionEvent event) {
    	GeneralMethods.configureFileChooser(fileChooserWindow);
    	File csvFile = fileChooserWindow.showOpenDialog(Main.stage);
    	if(csvFile != null){
    		file = csvFile;
    	}
    	SelectedRoomFilePath.setText(file.getAbsolutePath());
    }

    @FXML
    void UploadRoomFileButton(ActionEvent event) {
    	String filePath = SelectedRoomFilePath.getText();
    	
    	List<Room> roomList = new ArrayList<Room>();
    	boolean uploadError = false;
    	/*using the readRoomsFromCSV and saveSQLRooms methods from the CSV and
    	* SQL classes to read the rooms from a CSV file and save them into the
    	* database 
    	*/
    	try {
    		roomList= CSV.readRoomsFromCSV(filePath);
    		SQL.saveSQLRooms(roomList);
    		//below catch will display error message if exception occurs
    	} catch (Exception e) {
    		GeneralMethods.show("Error with Rooms Upload, please view handbook", "ERROR");
    		uploadError=true;
    	}
    	/*pop up dialog window will populate of upload is successful and advise of number
    	* rooms that are added 
    	*/
    	if (uploadError = false) {
    		GeneralMethods.show("Upload of Rooms from CSV successful, with "+ roomList.size() +" rooms added to the database", "Rooms Upload Successful");
    	}
    }
    
    /*the CancelRoomFileButton onClick method will change the scene
     *from the UploadRoomCSV.fxml file to the mainMenu.fxml file
     */
    
    @FXML
    void CancelRoomFileButton(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

}
