package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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


public class CSVLectureController {
	
	   @FXML
	    private ImageView Image;
	    @FXML
	    private JFXTextField Year;

  

    @FXML
    private JFXTextField FileInput;
    
    FileChooser fileChooser = new FileChooser();
    File f;

    @FXML
    void SelectFile(ActionEvent event) {
    	GeneralMethods.configureFileChooser(fileChooser);  
		File fileCSV = fileChooser.showOpenDialog(Main.getStage());
		if (fileCSV != null) {
			f = fileCSV;
		}
		FileInput.setText(f.getAbsolutePath());
    }

    @FXML
    void uploadFile(ActionEvent event) {
    	String s = FileInput.getText();


		List<Lecture> lectureList = new ArrayList<Lecture>();
		boolean error = false;
		try {
			lectureList = CSV.readLecturesFromCSV(s);
			LectureSQL.saveSQLLecture(lectureList,Year.getText());
		} catch (Exception e) {
			GeneralMethods.show("Issue with input please view the handbook", "ERROR");
			error = true;
			
			e.printStackTrace();
		}

		if (error == false) {
			GeneralMethods.show("Import successful with " + lectureList.size() + " lectures imported", "UPLOAD SUCCESS");
		}
    }

    @FXML
    void returnMainMenu(ActionEvent event) throws Exception{
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }
    
    @FXML
    void returnLectureMenu(ActionEvent event) throws Exception{
    	GeneralMethods.ChangeScene("LectureMenu","LectureMenu");
    }
    
    @FXML
    void DeleteAll(ActionEvent event) throws Exception {
    	LectureSQL.DeleteLectureYear(Year.getText());
    	GeneralMethods.show("ALL LECTURES DELETED", "ALL LECTURES DELETED");
    }
    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
        assert Year != null : "fx:id=\"Year\" was not injected: check your FXML file 'UploadLectureCSV.fxml'.";
        assert FileInput != null : "fx:id=\"fileInput\" was not injected: check your FXML file 'UploadLectureCSV.fxml'.";
        assert Image != null : "fx:id=\"Image\" was not injected: check your FXML file 'UploadLectureCSV.fxml'.";

    }
}
