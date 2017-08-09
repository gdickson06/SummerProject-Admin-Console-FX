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
import uk.ac.qub.churst.ConvertMethods;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.sql.AbsenceSQL;
import uk.ac.qub.sql.LectureSQL;

public class UploadSingleAbsenceController {

	@FXML
	private JFXCheckBox Approved;
	@FXML
	private ImageView Image;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private JFXTextField LectureID;

	@FXML
	private JFXComboBox<String> Type;

	@FXML
	private JFXTextField EndTime;

	@FXML
	private JFXTextField StudentNumber;

	@FXML
	private JFXTextField StartTime;

	@FXML
	private JFXTextArea Reason;

	@FXML
	private DatePicker StartDate;

	@FXML
	private DatePicker EndDate;
	
	@FXML
	void mainMenuButtonClick(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
	}

	@FXML
	void returnAbsenceMenuButtonClick(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("AbsenceMenu", "AbsenceMenu");
	}

	@FXML
	void Clear(ActionEvent event) {
		StudentNumber.setText("");
		LectureID.setText("");
		StartDate.setValue(LocalDate.now());
		EndDate.setValue(LocalDate.now());
		StartTime.setText("");
		EndTime.setText("");
		Reason.setText("");
		Approved.setSelected(false);
		Type.setValue("");
	}

	@FXML
	void UploadSingleAbsenceButton(ActionEvent event) {
		List<String> attributes = new ArrayList<String>();

		attributes.add(StudentNumber.getText());
		attributes.add(LectureID.getText());
		attributes.add(StartDate.getValue().toString());
		attributes.add(EndDate.getValue().toString());
		attributes.add(ConvertMethods.TimeConvertSQL(StartTime.getText()));
		attributes.add(ConvertMethods.TimeConvertSQL(EndTime.getText()));
		attributes.add(Reason.getText());
		attributes.add(String.valueOf(Approved.isSelected()));
		attributes.add(Type.getValue());

		try {
			AbsenceSQL.saveSingleAbsence(attributes);
			GeneralMethods.show("Success", "Success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			GeneralMethods.show(e.getMessage(), "Error");
		}
	}

	@FXML
	void initialize() {
		LectureID.textProperty().addListener((observable, oldValue, newValue) -> {
			String id = LectureID.getText();

			try {
				List<String> att = LectureSQL.finder(id);
				StartDate.setValue(LocalDate.parse(att.get(0)));
				EndDate.setValue(LocalDate.parse(att.get(0)));
				StartTime.setText(att.get(1));
				EndTime.setText(att.get(2));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		ApplicationMethods.AbsenceTypes(Type);
		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
		Image.setImage(i);
	}
}
