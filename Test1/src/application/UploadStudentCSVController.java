package application;


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import javafx.stage.FileChooser;

import uk.ac.qub.churst.CSV;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Student;

import uk.ac.qub.sql.StudentSQL;

public class UploadStudentCSVController {
	 @FXML
	    private TextField Year;

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

    private FileChooser fileChooser = new FileChooser();
    private File f;
    
    @FXML
    void ChooseFile(ActionEvent event) {
    	
		GeneralMethods.configureFileChooser(fileChooser);  
		File fileCSV = fileChooser.showOpenDialog(Main.getStage());
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
    			StudentSQL.saveSQLStudents(studentList,Year.getText());
    		} catch (Exception e) {
    			e.printStackTrace();
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
    void DeleteYear(ActionEvent event) throws Exception {
    	StudentSQL.DeleteYearStudent(Year.getText());
    	GeneralMethods.show("DELETED ALL FOR YEAR", "DELETED ALL FOR YEAR");
    }

    @FXML
    void initialize() {
        assert cancelStudentMenu != null : "fx:id=\"cancelStudentMenu\" was not injected: check your FXML file 'uploadCSVMenu.fxml'.";
        assert submitButton != null : "fx:id=\"submitButton\" was not injected: check your FXML file 'uploadCSVMenu.fxml'.";
        assert fileNamer != null : "fx:id=\"fileNamer\" was not injected: check your FXML file 'uploadCSVMenu.fxml'.";
        assert ChooseFile != null : "fx:id=\"ChooseFile\" was not injected: check your FXML file 'uploadCSVMenu.fxml'.";

    }
    
   
    
   
    
   
}


