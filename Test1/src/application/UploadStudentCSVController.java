package application;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import uk.ac.qub.churst.CSV;
import uk.ac.qub.churst.SQL;
import uk.ac.qub.churst.Student;

public class UploadStudentCSVController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button cancelStudentMenu;

    @FXML
    private Button submitButton;

    @FXML
    private TextField fileNamer;

    @FXML
    private Button ChooseFile;

    FileChooser fileChooser = new FileChooser();
    File f;
    
    @FXML
    void ChooseFile(ActionEvent event) {
    	
		configureFileChooser(fileChooser);  
		File fileCSV = fileChooser.showOpenDialog(Main.stage);
		if (fileCSV != null) {
			f = fileCSV;
		}
		fileNamer.setText(f.getAbsolutePath());
    }

    @FXML
    void upload(ActionEvent event) {
    	 String s = fileNamer.getText();


    		List<Student> studentList = new ArrayList<Student>();
    		boolean error = false;
    		try {
    			studentList = CSV.readStudentsFromCSV(s);
    			SQL.saveSQLStudents(studentList);
    		} catch (Exception e) {
    			GeneralMethods.show("Issue with input please view the handbook", "ERROR");
    			error = true;
    		}

    		if (error == false) {
    			GeneralMethods.show("Import successful with " + studentList.size() + " students imported", "UPLOAD SUCCESS");
    		}
    }

    @FXML
    void cancelButton(ActionEvent event)throws Exception {
	GeneralMethods.ChangeScene("MainMenu");
	}
    

    @FXML
    void initialize() {
        assert cancelStudentMenu != null : "fx:id=\"cancelStudentMenu\" was not injected: check your FXML file 'uploadCSVMenu.fxml'.";
        assert submitButton != null : "fx:id=\"submitButton\" was not injected: check your FXML file 'uploadCSVMenu.fxml'.";
        assert fileNamer != null : "fx:id=\"fileNamer\" was not injected: check your FXML file 'uploadCSVMenu.fxml'.";
        assert ChooseFile != null : "fx:id=\"ChooseFile\" was not injected: check your FXML file 'uploadCSVMenu.fxml'.";

    }
    
    private static void configureFileChooser(FileChooser fileChooser) {
		fileChooser.setTitle("Pick CSV");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv*"),
				new FileChooser.ExtensionFilter("CSV", "*.csv"));
	}
    
   
    
   
}


