package application;


import java.time.LocalDate;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Lecture;

import uk.ac.qub.sql.LectureSQL;


public class SelectedLectureController {
	
	Lecture l = LectureAmendController.selectedLecture;

    @FXML
    private JFXComboBox<Integer> year;

    
    @FXML
    private JFXCheckBox optional;

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
/**
 * This method will save the changes made to a lecture
 * @param event
 * @throws Exception
 */
    @FXML
    void SaveChanges(ActionEvent event) throws Exception {
    	
		
		l.setWeek(Integer.valueOf(WeekText.getText()));
		l.setDay(DayText.getText());
		l.setStartDate(StartDate.getValue().toString());
		l.setStartTime(StartTimeText.getText());
		l.setEndTime(EndTimeText.getText());
		l.setGroup(CohortsText.getText());
		l.setLocation(LocationText.getText());
		l.setSubject(SubjectText.getText());
		l.setTheme(ThemeText.getText());
		l.setTeachingFormat(TeachingText.getText());
		l.setDescription(DescriptionText.getText());
		l.setStaff(StaffText.getText());
		l.setStyle(StyleText.getText());
		l.setModule(ModuleText.getText());
		
		LectureSQL.AmendLecture(l);
		
		GeneralMethods.show("The lecture occuring on "+StartDate.getValue().toString()+" at "+StartTimeText.getText()+"-"+ EndTimeText.getText() + " located in "+LocationText.getText()+" has been sucessfully amended", "Lecture"+Integer.toString(l.getId())+" amendeded");
		
    }
/**
 * This method will delete a lecture
 * @param event
 * @throws Exception
 */
    @FXML
    void Delete(ActionEvent event)throws Exception {
    	LectureSQL.DeleteLecture(Integer.toString(l.getId()));
    	GeneralMethods.show("The lecture occuring on "+StartDate.getValue().toString()+" at "+StartTimeText.getText()+"-"+ EndTimeText.getText() + " located in "+LocationText.getText()+" has been sucessfully deleted", "Lecture Deleted");
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void Home(ActionEvent event) throws Exception{
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }
/**
 * This method will return the user to the searching lecture menu
 * @param event
 * @throws Exception
 */
    @FXML
    void Back(ActionEvent event)throws Exception {
    	GeneralMethods.ChangeScene("AmendDeleteLectureMenu","AmendDeleteLectureMenu");
    }
    
   /**
    * This method will return the user to the lecture menu screen
    * @param event
    * @throws Exception
    */
    @FXML
    void ReturnLectureScreen(ActionEvent event)throws Exception {
    	GeneralMethods.ChangeScene("LectureMenu","LectureMenu");
    }
    /**
     * This intialize method will populate the image and the combo box in the screen
     * along with populating the values of the selected lecture.
     */
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
    	optional.setSelected(l.getEssential());
    	year.setValue(Integer.valueOf(l.getYear()));
    	
    	ApplicationMethods.Years(year);
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
