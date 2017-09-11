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
import uk.ac.qub.objects.Staff;
import uk.ac.qub.sql.StaffSQL;
/** 
 * Name of Package - application
 * Date Last Amended - 08/09/17
 * Outline - This is the controller class for the screen to upload a spreadsheet of 
 * staff to the database.
 * Demographics – 114 LOC 5 Methods 
 * 
 */
public class UploadUserCSVController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Image;

    @FXML
    private JFXTextField filePathTextField;
    private FileChooser fileChooser = new FileChooser();
    private File f;
    
	/**
	 * This method will allow a file to be selected to be uploaded.
	 * @param event
	 */
    @FXML
    void chooseCSV(ActionEvent event) {
    	GeneralMethods.configureFileChooser(fileChooser);  
		File fileCSV = fileChooser.showOpenDialog(Main.getStage());
		if (fileCSV != null) {
			f = fileCSV;
		}
		filePathTextField.setText(f.getAbsolutePath());
    }
    /**
     * This method will upload a spreadsheet to the SQL database 
     * @param event
     */
    @FXML
    void uploadFile(ActionEvent event) {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(filePathTextField);
		
		
		if(ApplicationMethods.noNullValues(fields)){   	
    	
    	String s = filePathTextField.getText();


		List<Staff> staff = new ArrayList<Staff>();
		boolean error = false;
		try {
			staff = CSV.readStaffFromCSV(s);
			StaffSQL.saveSQLUsers(staff);
		} catch (Exception e) {
			e.printStackTrace();
			GeneralMethods.show("Issue with input please view the handbook", "ERROR");
			error = true;
		}

		if (error == false) {
			GeneralMethods.show("Import successful with " + staff.size() + " staff imported, to use the system ensure the users are registered in QSIS", "UPLOAD SUCCESS");
		}
    }
    }
/**
 * This method will return the user to the Staff Menu
 * @param event
 * @throws Exception
 */
    @FXML
    void returnStaffMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StaffMenu", "StaffMenu");
    }
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void returnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
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
