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
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.LectureSQL;

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
    private JFXTextField loactionTextField;

    @FXML
    private JFXButton returnLectureMenuButton;

    @FXML
    private JFXCheckBox Optional;

    @FXML
    private JFXButton uploadLectureButton;

    @FXML
    private DatePicker Date;

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

 

    @FXML
    void uploadLectureButtonClick(ActionEvent event) throws Exception {
    	
    	Lecture l = new Lecture();
    	Boolean essential =false;
    	if(Optional.isSelected()){
    		essential=true;
    	}
    	
		
    	
		l.setWeek(Integer.valueOf(weekTextfield.getText()));
		l.setDay(dayTextField.getText());
		l.setStartDate(Date.getValue().toString());
		l.setStartTime(startTimeTextfield.getText());
		l.setEndTime(endTimeTextfield.getText());
		l.setGroup(cohortTextField.getText());
		l.setLocation(loactionTextField.getText());
		l.setSubject(subjectTextField.getText());
		l.setTheme(themeTextField.getText());
		l.setTeachingFormat(teachingTextField.getText());
		l.setDescription(descriptionTextarea.getText());
		l.setStaff(staffTextField.getText());
		l.setStyle(styleTextField.getText());
		l.setModule(moduleTextField.getText());
		l.setEssential(Optional.isSelected());
		l.setYear(year.getValue().toString());
		
		
		
		LectureSQL.UploadSingleLecture(l);
		GeneralMethods.show("Lecture added to database", "Lecture added to database");
    }

    @FXML
    void clear(ActionEvent event) {
    	weekTextfield.setText("");
		dayTextField.setText("");
		Date.setValue(LocalDate.now());
		startTimeTextfield.setText("");
		endTimeTextfield.setText("");
		cohortTextField.setText("");
		loactionTextField.setText("");
		subjectTextField.setText("");
		themeTextField.setText("");
		teachingTextField.setText("");
		descriptionTextarea.setText("");
		staffTextField.setText("");
		styleTextField.setText("");
		moduleTextField.setText("");
		Optional.setSelected(false);
		year.setValue(0);

    }
   
    @FXML
    void returnLectureMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("LectureMenu", "LectureMenu");
    }

    @FXML
    void mainMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void initialize() {
    	ApplicationMethods.Years(year);
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
