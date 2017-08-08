package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
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
    private JFXCheckBox essentialCheckbox;

    @FXML
    private JFXTextField loactionTextField;

    @FXML
    private JFXButton returnLectureMenuButton;

    @FXML
    private CheckBox Essential;

    @FXML
    private JFXButton uploadLectureButton;

    @FXML
    private DatePicker Date;

    @FXML
    private JFXButton cancelButton;

    @FXML
    private JFXTextField yeartextField;

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
    	Boolean essential =false;
    	if(Essential.isSelected()){
    		essential=true;
    	}
    	List<String>attributes= new ArrayList<String>();
		
    	
		attributes.add(weekTextfield.getText());
		attributes.add(dayTextField.getText());
		attributes.add(Date.getValue().toString());
		attributes.add(startTimeTextfield.getText());
		attributes.add(endTimeTextfield.getText());
		attributes.add(cohortTextField.getText());
		attributes.add(loactionTextField.getText());
		attributes.add(subjectTextField.getText());
		attributes.add(themeTextField.getText());
		attributes.add(teachingTextField.getText());
		attributes.add(descriptionTextarea.getText());
		attributes.add(staffTextField.getText());
		attributes.add(styleTextField.getText());
		attributes.add(moduleTextField.getText());
		attributes.add(String.valueOf(essential));
		attributes.add(yeartextField.getText());
		
		
		
		LectureSQL.UploadSingleLecture(attributes);
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
		Essential.setSelected(false);
		yeartextField.setText("");

    }
    @FXML
    void essentialCheckboxClicked(ActionEvent event) {

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
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
