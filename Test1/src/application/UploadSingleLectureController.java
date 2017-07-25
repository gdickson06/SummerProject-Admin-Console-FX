package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.sql.LectureSQL;


public class UploadSingleLectureController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private CheckBox Essential;
    
    @FXML
    private TextField NoteText;
    
    @FXML
    private TextField YearText;
    

    @FXML
    private TextField StyleText;

    @FXML
    private TextField TeachingText;


    @FXML
    private TextField WeekText;

    @FXML
    private TextField EndTimeText;

    @FXML
    private TextField StaffText;

    @FXML
    private Button UploadButton;

    @FXML
    private Button BackButton;

    @FXML
    private TextField SubjectText;

    @FXML
    private TextField ThemeText;

    @FXML
    private TextField ModuleText;

    @FXML
    private TextField DateText;

    @FXML
    private TextField GroupsText;

    @FXML
    private TextField LocationText;

    @FXML
    private TextField DayText;

    @FXML
    private TextField StartTimeText;

    @FXML
    private TextArea DescriptionText;

    @FXML
    void Upload(ActionEvent event) throws Exception {
    	String essential="false";
    	if(Essential.isSelected()){
    		essential="true";
    	}
    	List<String>attributes= new ArrayList<String>();
		
    	
		attributes.add(WeekText.getText());
		attributes.add(DayText.getText());
		attributes.add(DateText.getText());
		attributes.add(StartTimeText.getText());
		attributes.add(EndTimeText.getText());
		attributes.add(GroupsText.getText());
		attributes.add(LocationText.getText());
		attributes.add(SubjectText.getText());
		attributes.add(ThemeText.getText());
		attributes.add(TeachingText.getText());
		attributes.add(DescriptionText.getText());
		attributes.add(StaffText.getText());
		attributes.add(StyleText.getText());
		attributes.add(ModuleText.getText());
		attributes.add(essential);
		attributes.add(YearText.getText());
		attributes.add(NoteText.getText());
		
		
		LectureSQL.UploadSingleLecture(attributes);
		GeneralMethods.show("Lecture added to database", "Lecture added to database");
    }

    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void initialize() {
        assert WeekText != null : "fx:id=\"WeekText\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert EndTimeText != null : "fx:id=\"EndTimeText\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert StaffText != null : "fx:id=\"StaffText\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert UploadButton != null : "fx:id=\"UploadButton\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert BackButton != null : "fx:id=\"BackButton\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert SubjectText != null : "fx:id=\"SubjectText\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert ThemeText != null : "fx:id=\"ThemeText\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert ModuleText != null : "fx:id=\"ModuleText\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert DateText != null : "fx:id=\"DateText\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert GroupsText != null : "fx:id=\"GroupsText\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert LocationText != null : "fx:id=\"LocationText\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert DayText != null : "fx:id=\"DayText\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert StartTimeText != null : "fx:id=\"StartTimeText\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";
        assert DescriptionText != null : "fx:id=\"DescriptionText\" was not injected: check your FXML file 'UploadSingleLecture.fxml'.";

    }
}