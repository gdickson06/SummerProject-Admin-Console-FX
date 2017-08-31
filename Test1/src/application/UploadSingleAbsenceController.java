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
import uk.ac.qub.methods.ConvertMethods;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.sql.AbsenceSQL;
import uk.ac.qub.sql.LectureSQL;

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
	
	@FXML
	void mainMenuButtonClick(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("MainMenu", "MainMenu");
	}

	@FXML
	void returnAbsenceMenuButtonClick(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("AbsenceMenu", "AbsenceMenu");
	}

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

	@FXML
	void uploadSingleAbsenceButton(ActionEvent event) {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(studentNumber);
		fields.add(startDate);
		fields.add(type);
		
		if(ApplicationMethods.noNullValues(fields)){
		Absence a = new Absence();

		if(studentNumber.getText().isEmpty()==false){a.setStudentNumber(Integer.valueOf(studentNumber.getText()));}
		if(lectureID.getText().isEmpty()==false){a.setLectureID(Integer.valueOf(lectureID.getText()));}
		a.setStartDate(startDate.getValue().toString());
		a.setEndDate(endDate.getValue().toString());
		if(!startTime.getText().isEmpty()){a.setStartTime(ConvertMethods.TimeConvertSQL(startTime.getText()));}
		if(!endTime.getText().isEmpty()){a.setEndTime(ConvertMethods.TimeConvertSQL(endTime.getText()));}
		a.setReason(reason.getText());
		a.setApproved(approved.isSelected());
		a.setType(type.getValue());

		try {
			AbsenceSQL.saveSingleAbsence(a);
			GeneralMethods.show("Success", "Success");
		} catch (Exception e) {
			
			GeneralMethods.show(e.getMessage(), "Error");
		}}
	}

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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		ApplicationMethods.AbsenceTypes(type);
		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
		Image.setImage(i);
	}
}
