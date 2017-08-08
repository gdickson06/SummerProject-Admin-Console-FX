package application;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.sql.PlacementSQL;

public class UploadSinglePlacementController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker StartDate;

    @FXML
    private JFXTextField Cohort;

    @FXML
    private JFXTextField Year;

    @FXML
    private JFXTextArea Note;

    @FXML
    private JFXTextField Teacher;

    @FXML
    private ImageView Image;

    @FXML
    private JFXTextField Week;

    @FXML
    private DatePicker EndDate;

    @FXML
    private JFXTextField Subject;

    @FXML
    private JFXTextField Location;

    @FXML
    void MainMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }

    @FXML
    void PracticalMenuButtonClick(ActionEvent event) throws Exception {
     	GeneralMethods.ChangeScene("PracticalMenuController", "PracticalPlacementMenu");
        
    }

    @FXML
    void cancelButtonClick(ActionEvent event) {
    	Week.setText("");
    	StartDate.setValue(LocalDate.now());
    	EndDate.setValue(LocalDate.now());
    	Subject.setText("");
    	Location.setText("");
    	Teacher.setText("");
    	Cohort.setText("");
    	Year.setText("");
    	Note.setText("");
    }

    @FXML
    void Upload(ActionEvent event) {
    	Boolean success = true;
    	try{
    	// The list will be Week,StartDate,EndDate,Subject,Location,ClinicalTeacher,Cohort,YearGroup,Note
    	List<String> s = new ArrayList<String>();
    	
    	s.add(Week.getText());
    	s.add(StartDate.getValue().toString());
    	s.add(EndDate.getValue().toString());
    	s.add(Subject.getText());
    	s.add(Location.getText());
    	s.add(Teacher.getText());
    	s.add(Cohort.getText());
    	s.add(Year.getText());
    	s.add(Note.getText());
    	
    	PlacementSQL.UploadSinglePlacement(s);
    	} catch (Exception e) {
    		success=false;
    		GeneralMethods.show(e.toString(), "ERROR");
    	}
    	if(success){
    	GeneralMethods.show("Placement uploaded successfully", "Upload success");
    }
    }

    @FXML
    void initialize() {
    	StartDate.setValue(LocalDate.now());
    	EndDate.setValue(LocalDate.now());
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
