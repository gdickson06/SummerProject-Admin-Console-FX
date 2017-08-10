package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
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
    private DatePicker StartDate;

    @FXML
    private JFXTextField Lecture;

    @FXML
    private JFXComboBox<String> Type;

    @FXML
    private JFXTextField EndTime;

    @FXML
    private JFXTextField StudentNumber;

    @FXML
    private CheckBox Approved;

    @FXML
    private JFXTextField StartTime;

    @FXML
    private ImageView Image;

    @FXML
    private DatePicker EndDate;

    @FXML
    private JFXTextArea Reason;

    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteAbsencesMenu","AmendDeleteAbsencesMenu");
    }

    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void ReturnAbsencesScreen(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AbsenceMenu", "AbsenceMenu");
    }

    @FXML
    void Delete(ActionEvent event) throws Exception {
    	AbsenceSQL.DeleteAbsence(String.valueOf(a.getId()));
    	GeneralMethods.show("Deleted", "Deleted");
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void SaveChanges(ActionEvent event) throws Exception {
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
    void initialize() {
List<String>types= new ArrayList<String>();
    	
    	types.add("Illness");
    	types.add("Non Illness Related Absence");
    	types.add("Missing from class");
    	
    	
    	Type.getItems().addAll(types);
    	
   
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
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
}
}
