package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import uk.ac.qub.churst.CSV;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.LectureSQL;


public class CSVLectureController {
	   @FXML
	    private ProgressBar Progress;

	    @FXML
	    private TextField Year;

    @FXML
    private Button Cancel;

    @FXML
    private Button FileSelect;

    @FXML
    private Button Upload;

    @FXML
    private TextField FileInput;
    
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
    void Upload(ActionEvent event) {
    	String s = FileInput.getText();


		List<Lecture> lectureList = new ArrayList<Lecture>();
		boolean error = false;
		try {
			lectureList = CSV.readLecturesFromCSV(s);
			LectureSQL.saveSQLLecture(lectureList,Year.getText(),Progress);
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
    void Cancel(ActionEvent event) throws Exception{
    	GeneralMethods.ChangeScene("MainMenu");
    }
    
    @FXML
    void DeleteAll(ActionEvent event) throws Exception {
    	LectureSQL.DeleteLectureYear(Year.getText());
    	GeneralMethods.show("ALL LECTURES DELETED", "ALL LECTURES DELETED");
    }

}
