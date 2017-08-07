package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.sql.AbsenceSQL;

public class SelectedAbsenceController {
	
	private Absence a = AbsenceAmendDeleteController.a;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Delete;

    @FXML
    private ComboBox<String> Type;

    @FXML
    private TextField Lecture;

    @FXML
    private TextField StudentNumber;
    
    @FXML
    private CheckBox Approved;

    @FXML
    private Button Amend;

    @FXML
    private Button Back;

    @FXML
    private Label Title;

    @FXML
    private TextField StartTime;
    @FXML
    private TextField EndTime;

    @FXML
    private Button Home;

    @FXML
    private DatePicker EndDate;
    
    @FXML
    private DatePicker StartDate;

    @FXML
    private TextArea Reason;

    @FXML
    void LectureChanged(ActionEvent event) {
    	
    }

    @FXML
    void Amend(ActionEvent event) throws Exception {
    	// This will be in the order of the id,Studentnumber,lectureid,date,time,reason,approved,type
    	List<String> l = new ArrayList<String>();
    	
    	l.add(String.valueOf(a.getId()));
    	l.add(String.valueOf(StudentNumber.getText()));
    	l.add(String.valueOf(Lecture.getText()));
    	l.add(StartDate.getValue().toString());
    	l.add(EndDate.getValue().toString());
    	l.add(StartTime.getText());
    	l.add(EndTime.getText());
    	l.add(Reason.getText());
    	if(Approved.isSelected()){
    		l.add("true");
    	} else {
    		l.add("false");
    	}
    	l.add(Type.getValue());
    	
    	System.out.println(l.size());
    	
    	AbsenceSQL.AmendAbsence(l);
    	
    	GeneralMethods.show(a.getId()+" has been updated", "Success");
    }

    @FXML
    void Delete(ActionEvent event) throws Exception {
    	AbsenceSQL.DeleteAbsence(String.valueOf(a.getId()));
    	GeneralMethods.show("Deleted", "Deleted");
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AbsenceAmendDelete");
    }

    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void initialize() {
List<String>types= new ArrayList<String>();
    	
    	types.add("Illness");
    	types.add("Non Illness Related Absence");
    	types.add("Missing from class");
    	
    	
    	Type.getItems().addAll(types);
    	
    	Title.setText("ID : "+String.valueOf(a.getId()));
    	StudentNumber.setText(String.valueOf(a.getStudentNumber()));
    	Lecture.setText(String.valueOf(a.getLectureID()));
    	
    	
    	StartDate.setValue(LocalDate.parse(a.getStartDate(),ApplicationMethods.dtf));
    	EndDate.setValue(LocalDate.parse(a.getStartDate(),ApplicationMethods.dtf));
    	StartTime.setText(a.getStartTime());
    	EndTime.setText(a.getEndTime());
    	
    	Type.setValue(a.getType());
    	Reason.setText(a.getReason());
    	
    	if(a.getApproved()){
    		Approved.setSelected(true);
    	}
    	
    	
    	
        assert Delete != null : "fx:id=\"Delete\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";
        assert Type != null : "fx:id=\"Type\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";
        assert Lecture != null : "fx:id=\"Lecture\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";
        assert Approved != null : "fx:id=\"Approved\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";
        assert Amend != null : "fx:id=\"Amend\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";
        assert Title != null : "fx:id=\"Title\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";
        assert StartTime != null : "fx:id=\"StartTime\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";
        assert EndTime !=null : "fx:id=\"EndTime\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";
        assert StartDate != null : "fx:id=\"StartDate\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";
        assert EndDate != null : "fx:id=\"EndDate\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";
        assert Reason != null : "fx:id=\"Reason\" was not injected: check your FXML file 'SelectedAbsence.fxml'.";

    }
}
