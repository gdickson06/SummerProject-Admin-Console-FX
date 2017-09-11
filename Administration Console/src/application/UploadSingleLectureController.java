package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
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

import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.LectureSQL;
/** 
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This is the controller class to upload a single lecture to the database,
 * the methods will be able to upload the lecture and to clear to fields.
 * Demographics – 210 LOC 5 Methods 
 * 
 */
public class UploadSingleLectureController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private JFXTextField cohortTextField;

	@FXML
	private JFXButton mainMenuButton;

	@FXML
	private JFXTextField endTimeTextfield;

	@FXML
	private JFXTextField dayTextField;

	@FXML
	private JFXTextField lectureStyleTextfield;

	@FXML
	private JFXTextField teachingTextField;

	@FXML
	private JFXTextField staffTextField;

	@FXML
	private ImageView Image;

	@FXML
	private JFXTextField locationTextField;

	@FXML
	private JFXButton returnLectureMenuButton;

	@FXML
	private JFXCheckBox optional;

	@FXML
	private JFXButton uploadLectureButton;

	@FXML
	private DatePicker startDate;

	@FXML
	private JFXButton cancelButton;

	@FXML
	private JFXComboBox<Integer> year;

	@FXML
	private JFXTextField subjectTextField;

	@FXML
	private JFXTextField startTimeTextfield;

	@FXML
	private JFXTextField noteTextField;

	@FXML
	private JFXTextField themeTextField;

	@FXML
	private JFXTextField styleTextField;

	@FXML
	private JFXTextField weekTextfield;

	@FXML
	private JFXTextArea descriptionTextarea;

	@FXML
	private JFXTextField moduleTextField;

	/**
	 * This method will upload a single lecture, there will be checks that NON
	 * NULL values cannot be set to null and that time is in the correct format.
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void uploadLectureButtonClick(ActionEvent event) throws Exception {
		try {
			List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();

			fields.add(startTimeTextfield);
			fields.add(year);
			fields.add(startDate);
			fields.add(endTimeTextfield);
			fields.add(locationTextField);
			fields.add(subjectTextField);
			if (ApplicationMethods.noNullValues(fields)) {
				Lecture l = new Lecture();

				if (!weekTextfield.getText().isEmpty()) {
					l.setWeek(Integer.valueOf(weekTextfield.getText()));
				}
				l.setDay(dayTextField.getText());
				l.setStartDate(startDate.getValue().toString());
				l.setStartTime(startTimeTextfield.getText());
				l.setEndTime(endTimeTextfield.getText());
				l.setGroup(cohortTextField.getText());
				l.setLocation(locationTextField.getText());
				l.setSubject(subjectTextField.getText());
				l.setTheme(themeTextField.getText());
				l.setTeachingFormat(teachingTextField.getText());
				l.setDescription(descriptionTextarea.getText());
				l.setStaff(staffTextField.getText());
				l.setStyle(styleTextField.getText());
				l.setModule(moduleTextField.getText());
				l.setEssential(optional.isSelected());
				l.setYear(year.getValue().toString());

				LectureSQL.UploadSingleLecture(l);
				GeneralMethods.show("Lecture added to database", "Lecture added to database");
				ApplicationMethods.timeInput(startTimeTextfield.getText());
				ApplicationMethods.timeInput(endTimeTextfield.getText());
			}
		} catch (Exception e) {
			e.printStackTrace();
			GeneralMethods.show("Please input time in 24 Hour format", "Warning");
		}

	}

/**
 * This method will clear all the text input on the screen
 * @param event
 */
	@FXML
	void clear(ActionEvent event) {
		weekTextfield.setText("");
		dayTextField.setText("");
		startDate.setValue(LocalDate.now());
		startTimeTextfield.setText("");
		endTimeTextfield.setText("");
		cohortTextField.setText("");
		locationTextField.setText("");
		subjectTextField.setText("");
		themeTextField.setText("");
		teachingTextField.setText("");
		descriptionTextarea.setText("");
		staffTextField.setText("");
		styleTextField.setText("");
		moduleTextField.setText("");
		optional.setSelected(false);
		year.setValue(0);

	}
/**
 * This method will return the user to the lecture menu
 * @param event
 * @throws Exception
 */
	@FXML
	void returnLectureMenuButtonClick(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("LectureMenu", "LectureMenu");
	}
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
 * The initialize method will populate the combo boxes and the image
 */
	@FXML
	void initialize() {
		ApplicationMethods.Years(year);
		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
		Image.setImage(i);
	}
}
