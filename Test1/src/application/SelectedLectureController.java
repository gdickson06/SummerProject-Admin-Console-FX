package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.ConvertMethods;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Lecture;

import uk.ac.qub.sql.LectureSQL;


public class SelectedLectureController {
	
	Lecture l = LectureAmendController.selectedLecture;

	 @FXML
	    private JFXButton Delete;

	    @FXML
	    private JFXTextField WeekText;

	    @FXML
	    private JFXTextField EndTimeText;

	    @FXML
	    private JFXTextField StaffText;

	    @FXML
	    private JFXTextField ThemeText;

	    @FXML
	    private JFXTextField ModuleText;

	    @FXML
	    private JFXButton returnSearch;

	    @FXML
	    private ImageView Image;
	    
	    @FXML
	    private JFXTextField SubjectText;

	    @FXML
	    private DatePicker StartDate;

	    @FXML
	    private JFXTextField StyleText;

	    @FXML
	    private JFXTextField LocationText;

	    @FXML
	    private JFXTextField DayText;

	    @FXML
	    private JFXButton SaveChanges;

	    @FXML
	    private JFXTextField TeachingText;
	    
	    @FXML
	    private Label IDLabel;

	    @FXML
	    private JFXTextArea DescriptionText;

	    @FXML
	    private JFXTextField StartTimeText;

	    @FXML
	    private JFXTextField CohortsText;

	    @FXML
	    private JFXButton ReturnLectureScreen;

	    @FXML
	    private JFXButton Home;

    @FXML
    void SaveChanges(ActionEvent event) throws Exception {
    	
		List<String>attributes= new ArrayList<String>();
		attributes.add(Integer.toString(l.getId()));
		attributes.add(WeekText.getText());
		attributes.add(DayText.getText());
		attributes.add(StartDate.getValue().toString());
		attributes.add(StartTimeText.getText());
		attributes.add(EndTimeText.getText());
		attributes.add(CohortsText.getText());
		attributes.add(LocationText.getText());
		attributes.add(SubjectText.getText());
		attributes.add(ThemeText.getText());
		attributes.add(TeachingText.getText());
		attributes.add(DescriptionText.getText());
		attributes.add(StaffText.getText());
		attributes.add(StyleText.getText());
		attributes.add(ModuleText.getText());
		
		LectureSQL.AmendLecture(attributes);
		
		GeneralMethods.show("The lecture occuring on "+StartDate.getValue().toString()+" at "+StartTimeText.getText()+"-"+ EndTimeText.getText() + " located in "+LocationText.getText()+" has been sucessfully amended", "Lecture"+Integer.toString(l.getId())+" amendeded");
		
    }

    @FXML
    void Delete(ActionEvent event)throws Exception {
    	LectureSQL.DeleteLecture(Integer.toString(l.getId()));
    	GeneralMethods.show("The lecture occuring on "+StartDate.getValue().toString()+" at "+StartTimeText.getText()+"-"+ EndTimeText.getText() + " located in "+LocationText.getText()+" has been sucessfully deleted", "Lecture Deleted");
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void Home(ActionEvent event) throws Exception{
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void Back(ActionEvent event)throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteLectureMenu","AmendDeleteLectureMenu");
    }
    
    
    @FXML
    void ReturnLectureScreen(ActionEvent event)throws Exception {
    	GeneralMethods.ChangeScene("LectureMenu","LectureMenu");
    }
    @FXML
    void initialize() {
    	
    	WeekText.setText(Integer.toString(l.getWeek()));
    	StartTimeText.setText(l.getStartTime());
    	EndTimeText.setText(l.getEndTime());
    	TeachingText.setText(l.getTeachingFormat());
    	StartDate.setValue(LocalDate.parse(l.getStartDate()));
    	StaffText.setText(l.getStaff());
    	StyleText.setText(l.getStyle());
    	SubjectText.setText(l.getSubject());
    	LocationText.setText(l.getLocation());
    	IDLabel.setText(Integer.toString(l.getId()));
    	DayText.setText(l.getDay());
    	DescriptionText.setText(l.getDescription());
    	CohortsText.setText(l.getGroup());
    	ModuleText.setText(l.getModule());
    	ThemeText.setText(l.getTheme());
    	
    	
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
