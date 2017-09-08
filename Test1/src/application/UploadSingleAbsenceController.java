package application;

import com.jfoenix.controls.JFXCheckBox;
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
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;

import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.sql.AbsenceSQL;
import uk.ac.qub.sql.LectureSQL;
import uk.ac.qub.sql.SearchQueries;
/** 
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This is the controller class to upload a single absence to the database,
 * the methods will be able to upload the absence and to clear to fields.
 * Demographics – 181 LOC 5 Methods 
 * 
 */
public class UploadSingleAbsenceController {

	@FXML
	private JFXCheckBox approved;
	@FXML
	private ImageView Image;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private JFXTextField lectureID;

	@FXML
	private JFXComboBox<String> type;

	@FXML
	private JFXTextField endTime;

	@FXML
	private JFXTextField studentNumber;

	@FXML
	private JFXTextField startTime;

	@FXML
	private JFXTextArea reason;

	@FXML
	private DatePicker startDate;

	@FXML
	private DatePicker endDate;
/**
 * This method will return the user to the main menu	
 * @param event
 * @throws Exception
 */
	@FXML
	void mainMenuButtonClick(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("MainMenu", "MainMenu");
	}
/**
 * This method will return the user to the absence menu
 * @param event
 * @throws Exception
 */
	@FXML
	void returnAbsenceMenuButtonClick(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("AbsenceMenu", "AbsenceMenu");
	}
/**
 * This method will clear all information on the page
 * @param event
 */
	@FXML
	void clear(ActionEvent event) {
		studentNumber.setText("");
		lectureID.setText("");
		startDate.setValue(LocalDate.now());
		endDate.setValue(LocalDate.now());
		startTime.setText("");
		endTime.setText("");
		reason.setText("");
		approved.setSelected(false);
		type.setValue("");
	}
/**
 * This method will upload a single absence there will be checks to ensure that 
 * NON NULL values cannot be set to null along with a check that the times are in 
 * the correct format
 * @param event
 * @throws NumberFormatException
 * @throws SQLException
 */
	@FXML
	void uploadSingleAbsenceButton(ActionEvent event) throws NumberFormatException, SQLException {
		
		
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(studentNumber);
		fields.add(startDate);
		fields.add(type);
		fields.add(endDate);
		
		if(ApplicationMethods.noNullValues(fields)){
			if(SearchQueries.allStudentNumbers().contains(studentNumber.getText())){
			try{
			
		Absence a = new Absence();

		if(studentNumber.getText().isEmpty()==false){a.setStudentNumber(Integer.valueOf(studentNumber.getText()));}
		if(lectureID.getText().isEmpty()==false){a.setLectureID(Integer.valueOf(lectureID.getText()));}
		if(startDate.getValue()!=null){a.setStartDate(startDate.getValue().toString());}
		if(endDate.getValue()!=null){a.setEndDate(endDate.getValue().toString());}
		if(!startTime.getText().isEmpty()){a.setStartTime(startTime.getText());}else { a.setStartTime("00:00");}
		if(!endTime.getText().isEmpty()){a.setEndTime(endTime.getText());} else { a.setEndTime("23:59");}
		a.setReason(reason.getText());
		a.setApproved(approved.isSelected());
		a.setType(type.getValue());
		ApplicationMethods.timeInput(startTime.getText());
		ApplicationMethods.timeInput(endTime.getText());
	
		try {
			AbsenceSQL.saveSingleAbsence(a);
			GeneralMethods.show("Success", "Success");
		} catch (Exception e) {
			
			GeneralMethods.show(e.getMessage(), "Error");
		}
			} catch (Exception e) {
				GeneralMethods.show("Please input time in 24 Hour format", "Warning");
			e.printStackTrace();
			}
			} else {
				GeneralMethods.show("Student not in database", "Error");
			}
		}
			
	}
/**
 * The initialize will set a listener to the lecture ID so that the start 
 * and end date are filled out along with the start and end times, the combo
 * boxes will also be filled out along with the startTime and endTime
 */
	@FXML
	void initialize() {
		lectureID.textProperty().addListener((observable, oldValue, newValue) -> {
			String id = lectureID.getText();

			try {
				List<String> att = LectureSQL.finder(id);
				startDate.setValue(LocalDate.parse(att.get(0)));
				endDate.setValue(LocalDate.parse(att.get(0)));
				startTime.setText(att.get(1));
				endTime.setText(att.get(2));
			} catch (SQLException e) {
				GeneralMethods.show("Error in finding lecture", "Error");
			}
		});
		ApplicationMethods.AbsenceTypes(type);
		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
		Image.setImage(i);
	}
}
