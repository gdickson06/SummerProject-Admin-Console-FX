package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.methods.FileWriter;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.methods.PDF;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.SearchQueries;

public class CreatePDFController {
	
	private Lecture selectedLecture;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXComboBox<Integer> Year;

    @FXML
    private JFXTextField Staff;

    @FXML
    private JFXTextField StartTime;

    @FXML
    private Label PickedLecture;

    @FXML
    private ImageView Image;

    @FXML
    private JFXComboBox<String> Module;

    @FXML
    private JFXTextField Week;

    @FXML
    private JFXListView<Lecture> Lectures;

    @FXML
    private DatePicker Date;
/**
 * This method will allow a lecture to be clicked and set to the current lecture
 * @param event
 */
    @FXML
    void LectureClick(MouseEvent event) {

     		 selectedLecture=Lectures.getSelectionModel().getSelectedItem();
     		
     		 PickedLecture.setText(selectedLecture.toString());
      	
    }
/**
 * This method will search through the lectures on multiple fields
 * @param event
 */
    @FXML
    void Search(ActionEvent event) {
    	
    	Lecture l = new Lecture();
    	if(!Week.getText().isEmpty()){l.setWeek(Integer.valueOf(Week.getText()));}
    	l.setStartTime(StartTime.getText());
    	l.setStaff(Staff.getText());
    	if(Module.getValue()!=null){l.setModule(Module.getValue());}
    	if(Year.getValue()!=null){l.setYear(Year.getValue().toString());}
    	if(Date.getValue()!=null){l.setStartDate(Date.getValue().toString());}
    	
    	List<Lecture> searched = new ArrayList<Lecture>();
		try {
			searched.addAll(SearchQueries.ComboSearchLectures(l));
		} catch (SQLException e) {
			GeneralMethods.show("Error in searching lectures", "Error");
			e.printStackTrace();
		}
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Lectures.setItems(list);
    }
/**
 * This method will generate a PDF of the students in a selected lecture and this will 
 * be saved in a specified location which can be changed in the settings menu
 * @param event
 */
    @FXML
    void GeneratePDF(ActionEvent event) {
    	File f = new File ("SaveInfo.txt");
    	if(f.exists()){
    	try{
    	if(selectedLecture!=null){
    		
    	PDF pdf = new PDF(selectedLecture);
    	pdf.setLocation(FileWriter.load());
    	pdf.create();
    	GeneralMethods.show("PDF created at " + FileWriter.load(),"Success");
    	}
    	} catch (Exception e){
    		e.printStackTrace();
    	}
    	
    	} else {
    		GeneralMethods.show("No save location specified go to setttings to specify", "Error");
    	}
    }
/**
 * This method will return the user to the PDF menu
 * @param event
 * @throws Exception
 */
    @FXML
    void ReturnPDFMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("PDFMenu", "PDFMenu");
    }
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void ReturnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
    }
/**
 * This initialize method will populate the image and combo boxes on the page
 */
    @FXML
    void initialize() {
    	ApplicationMethods.Years(Year);
    	try {
			Module.getItems().addAll(SQL.Modules());
		} catch (SQLException e) {
			GeneralMethods.show("Error in finding modules", "Error");
			e.printStackTrace();
		}
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}