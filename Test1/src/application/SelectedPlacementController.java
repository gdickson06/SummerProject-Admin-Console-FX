package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.ConvertGroup;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.sql.PlacementSQL;

public class SelectedPlacementController {
	
	private Placement p = PlacementAmendDeleteController.selectedPlacement;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private DatePicker StartDate;

    @FXML
    private TextField Year;

    @FXML
    private TextField Cohort;

    @FXML
    private TextArea Note;

    @FXML
    private TextField Teacher;

    @FXML
    private Label ID;

    @FXML
    private TextField Week;

    @FXML
    private DatePicker EndDate;

    @FXML
    private TextField Subject;

    @FXML
    private TextField Location;

    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void Delete(ActionEvent event) throws Exception {
    	PlacementSQL.DeletePlacement(String.valueOf(p.getId()));
    	GeneralMethods.show("Deleted", "Deleted");
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void Amend(ActionEvent event) {
    	// The list will be id,Week,StartDate,EndDate,Subject,Location,ClinicalTeacher,Cohort,YearGroup,Note
    	List<String>s = new ArrayList<String>();
    	
    	s.add(String.valueOf(p.getId()));
    	s.add(Week.getText());
    	System.out.println(StartDate.getValue().toString());
    	s.add((StartDate.getValue().toString()));
    	s.add((EndDate.getValue().toString()));
    	s.add(Subject.getText());
    	s.add(Location.getText());
    	s.add(Teacher.getText());
    	s.add(Cohort.getText());
    	s.add(String.valueOf(Year.getText()));
    	s.add(Note.getText());
    	
    	try {
			PlacementSQL.amendPlacement(s);
			GeneralMethods.show("Success", "Success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			GeneralMethods.show(e.getMessage(),"Error");
			e.printStackTrace();
		}
    	
    }

    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("PlacementAmendDelete");
    }

    @FXML
    void initialize() {
    	StartDate.setValue(LocalDate.parse(p.getStartDate(), ApplicationMethods.dtf));
    	Year.setText(String.valueOf(p.getYear()));
    	Cohort.setText(p.getCohort());
    	Note.setText(p.getNote());
    	Teacher.setText(p.getTeacher());
    	ID.setText(String.valueOf(p.getId()));
    	Week.setText(String.valueOf(p.getWeek()));
    	EndDate.setValue(LocalDate.parse(p.getEndDate(),ApplicationMethods.dtf));
    	Subject.setText(p.getSubject());
    	Location.setText(p.getLocation());
    	
    	
        assert StartDate != null : "fx:id=\"StartDate\" was not injected: check your FXML file 'SelectedPlacement.fxml'.";
        assert Year != null : "fx:id=\"Year\" was not injected: check your FXML file 'SelectedPlacement.fxml'.";
        assert Cohort != null : "fx:id=\"Cohort\" was not injected: check your FXML file 'SelectedPlacement.fxml'.";
        assert Note != null : "fx:id=\"Note\" was not injected: check your FXML file 'SelectedPlacement.fxml'.";
        assert Teacher != null : "fx:id=\"Teacher\" was not injected: check your FXML file 'SelectedPlacement.fxml'.";
        assert ID != null : "fx:id=\"ID\" was not injected: check your FXML file 'SelectedPlacement.fxml'.";
        assert Week != null : "fx:id=\"Week\" was not injected: check your FXML file 'SelectedPlacement.fxml'.";
        assert EndDate != null : "fx:id=\"EndDate\" was not injected: check your FXML file 'SelectedPlacement.fxml'.";
        assert Subject != null : "fx:id=\"Subject\" was not injected: check your FXML file 'SelectedPlacement.fxml'.";
        assert Location != null : "fx:id=\"Location\" was not injected: check your FXML file 'SelectedPlacement.fxml'.";

    }
}
