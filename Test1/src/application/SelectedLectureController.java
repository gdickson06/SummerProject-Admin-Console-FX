package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.ConvertMethods;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Lecture;

import uk.ac.qub.sql.LectureSQL;


public class SelectedLectureController {
	
	Lecture l = LectureAmendController.selectedLecture;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Delete;

    @FXML
    private TextField WeekText;

    @FXML
    private TextField EndTimeText;

    @FXML
    private TextField StaffText;

    @FXML
    private TextField SubjectText;

    @FXML
    private TextField ThemeText;

    @FXML
    private TextField ModuleText;

    @FXML
    private TextField GroupsText;

    @FXML
    private TextField StartDateText;

    @FXML
    private TextField StyleText;

    @FXML
    private TextField LocationText;

    @FXML
    private Label IDLabel;

    @FXML
    private TextField DayText;

    @FXML
    private Button Back;

    @FXML
    private Button SaveChanges;

    @FXML
    private TextField TeachingText;

    @FXML
    private TextField StartTimeText;

    @FXML
    private TextArea DescriptionText;

    @FXML
    private Button Home;

    @FXML
    void SaveChanges(ActionEvent event) throws Exception {
    	
		List<String>attributes= new ArrayList<String>();
		attributes.add(Integer.toString(l.getId()));
		attributes.add(WeekText.getText());
		attributes.add(DayText.getText());
		attributes.add(ConvertMethods.DateConvertSQL(StartDateText.getText()));
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
		
		LectureSQL.AmendLecture(attributes);
		
		GeneralMethods.show("The lecture occuring on "+StartDateText.getText()+" at "+StartTimeText.getText()+"-"+ EndTimeText.getText() + " located in "+LocationText.getText()+" has been sucessfully amended", "Lecture"+Integer.toString(l.getId())+" amendeded");
		
    }

    @FXML
    void Delete(ActionEvent event)throws Exception {
    	LectureSQL.DeleteLecture(Integer.toString(l.getId()));
    	GeneralMethods.show("The lecture occuring on "+StartDateText.getText()+" at "+StartTimeText.getText()+"-"+ EndTimeText.getText() + " located in "+LocationText.getText()+" has been sucessfully deleted", "Lecture Deleted");
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void Home(ActionEvent event) throws Exception{
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void Back(ActionEvent event)throws Exception {
    	GeneralMethods.ChangeScene("LectureAmendDelete");
    }

    @FXML
    void initialize() {
    	
    	WeekText.setText(Integer.toString(l.getWeek()));
    	StartTimeText.setText(l.getStartTime());
    	EndTimeText.setText(l.getEndTime());
    	TeachingText.setText(l.getTeachingFormat());
    	StartDateText.setText(l.getStartDate());
    	StaffText.setText(l.getStaff());
    	StyleText.setText(l.getStyle());
    	SubjectText.setText(l.getSubject());
    	LocationText.setText(l.getLocation());
    	IDLabel.setText(Integer.toString(l.getId()));
    	DayText.setText(l.getDay());
    	DescriptionText.setText(l.getDescription());
    	GroupsText.setText(l.getGroup());
    	ModuleText.setText(l.getModule());
    	ThemeText.setText(l.getTheme());
    	
    	
    	
        assert Delete != null : "fx:id=\"Delete\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert WeekText != null : "fx:id=\"WeekText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert EndTimeText != null : "fx:id=\"EndTimeText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert StaffText != null : "fx:id=\"StaffText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert SubjectText != null : "fx:id=\"SubjectText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert ThemeText != null : "fx:id=\"ThemeText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert ModuleText != null : "fx:id=\"ModuleText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert GroupsText != null : "fx:id=\"GroupsText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert StartDateText != null : "fx:id=\"StartDateText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert StyleText != null : "fx:id=\"StyleText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert LocationText != null : "fx:id=\"LocationText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert IDLabel != null : "fx:id=\"IDLabel\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert DayText != null : "fx:id=\"DayText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert SaveChanges != null : "fx:id=\"SaveChanges\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert TeachingText != null : "fx:id=\"TeachingText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert StartTimeText != null : "fx:id=\"StartTimeText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert DescriptionText != null : "fx:id=\"DescriptionText\" was not injected: check your FXML file 'SelectedLecture.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'SelectedLecture.fxml'.";

    }
}
