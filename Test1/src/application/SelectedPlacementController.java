package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.ConvertMethods;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.sql.PlacementSQL;

public class SelectedPlacementController {
	
	private Placement p = PlacementAmendDeleteController.selectedPlacement;


    @FXML
    private DatePicker StartDate;

    @FXML
    private JFXTextField Year;

    @FXML
    private JFXTextField Cohort;

    @FXML
    private JFXTextArea Note;

    @FXML
    private JFXTextField Teacher;

    @FXML
    private Label ID;

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
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void Delete(ActionEvent event) throws Exception {
    	PlacementSQL.DeletePlacement(String.valueOf(p.getId()));
    	GeneralMethods.show("Deleted", "Deleted");
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void Save(ActionEvent event) {
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
     	GeneralMethods.ChangeScene("AmendDeletePracticalMenu", "AmendDeletePracticalMenu");
         }
    
    @FXML
    void returnPracticalPlacementScreen(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("PracticalMenuController", "PracticalPlacementMenu");
    	  
    }

    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
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

    }
}
