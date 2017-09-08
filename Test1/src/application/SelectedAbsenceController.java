package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.sql.AbsenceSQL;
import uk.ac.qub.sql.SearchQueries;
/** 
 * Name of Package - application
 * Date Last Amended - 08/09/17
 * Outline - This is the controller class for the selected absence screen, this
 * will contain methods to return to any of the previous three screens and to amend
 * and delete the selected absence
 * Demographics – 198 LOC 6 Methods 
 * 
 */
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
/**
 * This method will let the user go back to the search through absence menu
 * @param event
 * @throws Exception
 */
    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteAbsencesMenu","AmendDeleteAbsencesMenu");
    }
/**
 * This method will allow the users to go back to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
    }
/**
 * This method will allow the user to go to the absences menu
 * @param event
 * @throws Exception
 */
    @FXML
    void ReturnAbsencesScreen(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AbsenceMenu", "AbsenceMenu");
    }
/**
 * This method will allow an absence to be deleted
 * @param event
 * @throws Exception
 */
    @FXML
    void Delete(ActionEvent event) throws Exception {
    	AbsenceSQL.DeleteAbsence(String.valueOf(a.getId()));
    	GeneralMethods.show("Deleted", "Deleted");
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
    }
/**
 * This method will allow an absence to be amended
 * @param event
 * @throws SQLException 
 * @throws NumberFormatException 
 * @throws Exception
 */
    @FXML
    void SaveChanges(ActionEvent event) throws NumberFormatException, SQLException {
    	try{
    	List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(StudentNumber);
		fields.add(StartDate);
		fields.add(Type);
		fields.add(EndDate);
		
		if(ApplicationMethods.noNullValues(fields)){
			if(SearchQueries.allStudentNumbers().contains(StudentNumber.getText())){
    	
				a.setApproved(Approved.isSelected());
    	a.setStudentNumber(Integer.valueOf(StudentNumber.getText()));
    	try{if(Integer.valueOf(Lecture.getText())>0){a.setLectureID(Integer.valueOf(Lecture.getText()));}} catch(Exception e){};
    	a.setStartDate(StartDate.getValue().toString());
    	a.setEndDate(EndDate.getValue().toString());
    	if(!StartTime.getText().isEmpty()){a.setStartTime(StartTime.getText());}else{a.setStartTime("0:00");}
    	if(!EndTime.getText().isEmpty()){a.setEndTime(EndTime.getText());}else{a.setEndTime("23:59");}
    	a.setReason(Reason.getText());
    	a.setType(Type.getValue());
    	ApplicationMethods.timeInput(StartTime.getText());
		ApplicationMethods.timeInput(EndTime.getText());

	}
    	
    	try {
			AbsenceSQL.AmendAbsence(a);
			GeneralMethods.show("Absence amneded successfully", "Success");
		} catch (Exception e) {
			GeneralMethods.show("Error in amending Absence", "Error");
			e.printStackTrace();
		}
		}else {
			GeneralMethods.show("Student not in database", "Error");}
		
		
	} catch (Exception e) {
		e.printStackTrace();
		GeneralMethods.show("Please input time in 24 Hour format", "Warning");
    }
    }
/**
 * The initialize method will populate the fields with all of the current values
 * make the absence as read and set the image
 */
    @FXML
    void initialize() {
    	try {
			AbsenceSQL.readAbsence(a.getId());
		} catch (SQLException e) {
			GeneralMethods.show("Error in marking absence as read", "Error");
		}
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
