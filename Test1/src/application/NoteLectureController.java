package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
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
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.LectureSQL;
import uk.ac.qub.sql.SearchQueries;

public class NoteLectureController {
	
	private Lecture l;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField StartTime;

    @FXML
    private JFXTextField Staff;

    @FXML
    private JFXTextArea Note;

    @FXML
    private Label SelectedLecture;

    @FXML
    private ImageView Image;

    @FXML
    private JFXTextField Module;

    @FXML
    private JFXTextField Week;

    @FXML
    private DatePicker LectureDate;

    @FXML
    private JFXComboBox<Integer> Year;

    @FXML
    private JFXListView<Lecture> TableLectures;

    @FXML
    void ReturnNotesMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("NotesMenu","NotesMenu");
    }

    @FXML
    void ReturnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
    }

    @FXML
    void TableClick(MouseEvent event) {
 l=TableLectures.getSelectionModel().getSelectedItem();
    		SelectedLecture.setText(l.toString());
    		Note.setText(l.getNotes());
    }
    
    @FXML
    void Search(ActionEvent event) {
    	Lecture l = new Lecture();
    	if(Year.getValue()!=null){l.setYear(Year.getValue().toString());}
    	l.setModule(Module.getText());
    	if(!Week.getText().isEmpty()){l.setWeek(Integer.parseInt(Week.getText()));}
    	if(LectureDate.getValue()!=null){
    		l.setStartDate(LectureDate.getValue().toString());}
    	l.setStaff(Staff.getText());
    	l.setStartTime(StartTime.getText());
List<Lecture> searched = new ArrayList<Lecture>();
try {
	searched.addAll(SearchQueries.ComboSearchLectures(l));
} catch (SQLException e) {
	GeneralMethods.show("Error in searching Lectures", "Error");
	e.printStackTrace();
}
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		TableLectures.setItems(list);
    }
    
    @FXML
    void Upload(ActionEvent event) throws Exception {
    	if(l!=null){
        	LectureSQL.UploadNote(String.valueOf(l.getId()), Note.getText());
        	GeneralMethods.show("Uploaded note for lecture "+ l.getId(), "Upload Success");
        	} else {
        		GeneralMethods.show("No lecture selected", "Error");
        	}
    }

    @FXML
    void initialize() {
    	ApplicationMethods.Years(Year);
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
