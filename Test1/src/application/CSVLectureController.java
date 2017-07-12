package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import uk.ac.qub.churst.CSV;
import uk.ac.qub.churst.Lecture;
import uk.ac.qub.churst.SQL;

public class CSVLectureController {

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
		File fileCSV = fileChooser.showOpenDialog(Main.stage);
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
			SQL.saveSQLLecture(lectureList);
		} catch (Exception e) {
			GeneralMethods.show("Issue with input please view the handbook", "ERROR");
			error = true;
		}

		if (error == false) {
			GeneralMethods.show("Import successful with " + lectureList.size() + " lectures imported", "UPLOAD SUCCESS");
		}
    }

    @FXML
    void Cancel(ActionEvent event) throws Exception{
    	GeneralMethods.ChangeScene("MainMenu");
    }

}
