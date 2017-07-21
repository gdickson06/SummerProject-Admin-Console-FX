package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uk.ac.qub.sql.PlacementSQL;

public class UploadSinglePlacementController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField StartDate;

    @FXML
    private TextField Year;

    @FXML
    private TextField Cohort;

    @FXML
    private TextArea Note;

    @FXML
    private TextField Teacher;

    @FXML
    private Button Back;

    @FXML
    private Button Upload;

    @FXML
    private TextField Week;

    @FXML
    private TextField EndDate;

    @FXML
    private TextField Subject;

    @FXML
    private TextField Location;

    @FXML
    void Upload(ActionEvent event) {
    	Boolean success = true;
    	try{
    	// The list will be Week,StartDate,EndDate,Subject,Location,ClinicalTeacher,Cohort,YearGroup,Note
    	List<String> s = new ArrayList<String>();
    	
    	s.add(Week.getText());
    	s.add(StartDate.getText());
    	s.add(EndDate.getText());
    	s.add(Subject.getText());
    	s.add(Location.getText());
    	s.add(Teacher.getText());
    	s.add(Cohort.getText());
    	s.add(Year.getText());
    	s.add(Note.getText());
    	
    	PlacementSQL.UploadSingleStaff(s);
    	} catch (Exception e) {
    		success=false;
    		GeneralMethods.show(e.toString(), "ERROR");
    	}
    	if(success){
    	GeneralMethods.show("Placement uploaded successfully", "Upload success");
    }}

    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void initialize() {
        assert StartDate != null : "fx:id=\"StartDate\" was not injected: check your FXML file 'UploadSinglePlacement.fxml'.";
        assert Year != null : "fx:id=\"Year\" was not injected: check your FXML file 'UploadSinglePlacement.fxml'.";
        assert Cohort != null : "fx:id=\"Cohort\" was not injected: check your FXML file 'UploadSinglePlacement.fxml'.";
        assert Note != null : "fx:id=\"Note\" was not injected: check your FXML file 'UploadSinglePlacement.fxml'.";
        assert Teacher != null : "fx:id=\"Teacher\" was not injected: check your FXML file 'UploadSinglePlacement.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'UploadSinglePlacement.fxml'.";
        assert Upload != null : "fx:id=\"Upload\" was not injected: check your FXML file 'UploadSinglePlacement.fxml'.";
        assert Week != null : "fx:id=\"Week\" was not injected: check your FXML file 'UploadSinglePlacement.fxml'.";
        assert EndDate != null : "fx:id=\"EndDate\" was not injected: check your FXML file 'UploadSinglePlacement.fxml'.";
        assert Subject != null : "fx:id=\"Subject\" was not injected: check your FXML file 'UploadSinglePlacement.fxml'.";
        assert Location != null : "fx:id=\"Location\" was not injected: check your FXML file 'UploadSinglePlacement.fxml'.";

    }
}
