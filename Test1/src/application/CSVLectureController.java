package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import uk.ac.qub.churst.CSV;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.LectureSQL;
import uk.ac.qub.sql.PlacementSQL;
import uk.ac.qub.sql.SQL;


public class CSVLectureController {
	
	   @FXML
	    private ImageView Image;
	    @FXML
	    private JFXComboBox<Integer> Year;

  

    @FXML
    private JFXTextField FileInput;
    
    FileChooser fileChooser = new FileChooser();
    File f;
/**
 * This method will allow a file to be selected to be uploaded.
 * @param event
 */
    @FXML
    void SelectFile(ActionEvent event) {
    	GeneralMethods.configureFileChooser(fileChooser);  
		File fileCSV = fileChooser.showOpenDialog(Main.getStage());
		if (fileCSV != null) {
			f = fileCSV;
		}
		FileInput.setText(f.getAbsolutePath());
    }
/**
 * This method will upload a CSV of lectures to the database
 * @param event
 */
    @FXML
    void uploadFile(ActionEvent event) {
    	String s = FileInput.getText();


		List<Lecture> lectureList = new ArrayList<Lecture>();
		boolean error = false;
		try {
			lectureList = CSV.readLecturesFromCSV(s);
			LectureSQL.saveSQLLecture(lectureList,Year.getValue().toString());
		} catch (Exception e) {
			GeneralMethods.show("Issue with input please view the handbook", "ERROR");
			error = true;
			
			e.printStackTrace();
		}

		if (error == false) {
			GeneralMethods.show("Import successful with " + lectureList.size() + " lectures imported", "UPLOAD SUCCESS");
		}
    }
    /**
     * This method will download the Lecture list on the server to a CSV sheet
     * @param event
     * @throws SQLException 
     * @throws IOException 
     */
    @FXML
    void downloadCSVList(ActionEvent event) throws IOException, SQLException{
    	if(Year.getValue()==null){
    		GeneralMethods.show("Please pick year first", "Warning");
    	}else {
    		List<String>attributes = new ArrayList<String>();
    		
    		attributes.add("week");
    		attributes.add("day");
    		attributes.add("date");
    		attributes.add("start_time");
    		attributes.add("end_time");
    		attributes.add("groups");
    		attributes.add("location");
    		attributes.add("subject");
    		attributes.add("theme");
    		attributes.add("teaching");
    		attributes.add("description");
    		attributes.add("staff");
    		attributes.add("style");
    		attributes.add("module");
    	SQL.downloadToCSV(attributes, Year.getValue().toString(), "Lectures WHERE year=");
    	}
    }
/**
 * This method will allow the user to return to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void returnMainMenu(ActionEvent event) throws Exception{
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }
   /**
    * This method will allow the user to return to the lectures menu
    * @param event
    * @throws Exception
    */
    @FXML
    void returnLectureMenu(ActionEvent event) throws Exception{
    	GeneralMethods.ChangeScene("LectureMenu","LectureMenu");
    }
    /**
     * This method allows a user to delete all lectures for a year 
     * @param event
     * @throws Exception
     */
    @FXML
    void DeleteAll(ActionEvent event) throws Exception {
    	LectureSQL.DeleteLectureYear(Year.getValue().toString());
    	GeneralMethods.show("ALL LECTURES DELETED", "ALL LECTURES DELETED");
    }
    
    /**
     * This method will initialize before the screen loads up by adding an image and populating a combobox
     */
    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	ApplicationMethods.Years(Year);
    }
}
