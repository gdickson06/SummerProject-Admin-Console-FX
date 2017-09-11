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
import uk.ac.qub.methods.CSV;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Room;
import uk.ac.qub.sql.RoomSQL;
/** 
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This is the controller class for the screen to upload a spreadsheet of 
 * rooms to the database.
 * Demographics – 123 LOC 5 Methods 
 * 
 */
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

	/**
	 * This method will allow the user to return to the main menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void returnMainMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("MainMenu", "MainMenu");
	}

	/**
	 * This method will alow the user to return to the room menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void returnRoomMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("RoomMenu", "RoomMenu");
	}

	/**
	 * This method will allow a file to be selected to be uploaded.
	 * 
	 * @param event
	 */
	@FXML
	void uploadFile(ActionEvent event) {
		List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();

		fields.add(filePathTextField);

		if (ApplicationMethods.noNullValues(fields)) {
			String filePath = filePathTextField.getText();

			List<Room> roomList = new ArrayList<Room>();
	

			try {
				roomList = CSV.readRoomsFromCSV(filePath);
				RoomSQL.saveSQLRooms(roomList);
				GeneralMethods.show(
						"Upload of Rooms from CSV successful, with " + roomList.size() + " rooms added to the database",
						"Rooms Upload Successful");

			} catch (Exception e) {
				GeneralMethods.show(e.getLocalizedMessage(), "ERROR");
				
			}

			
		}
	}

	/**
	 * This method will upload a spreadsheet of rooms to the database
	 * 
	 * @param event
	 */
	@FXML
	void chooseCSV(ActionEvent event) {
		GeneralMethods.configureFileChooser(fileChooserWindow);
		File csvFile = fileChooserWindow.showOpenDialog(Main.getStage());
		if (csvFile != null) {
			file = csvFile;
		}
		filePathTextField.setText(file.getAbsolutePath());
	}

	/**
	 * This will initialize the class by populating the image
	 */
	@FXML
	void initialize() {

		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
		Image.setImage(i);
	}
}
