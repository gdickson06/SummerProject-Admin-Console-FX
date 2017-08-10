package application;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
import uk.ac.qub.churst.GeneralMethods;
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
    private JFXTextField Groups;

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
    private DatePicker Date;

    @FXML
    private JFXTextField Year;

    @FXML
    private JFXListView<Lecture> TableLectures;

    @FXML
    void ReturnNotesMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("NotesMenu","NotesMenu");
    }

    @FXML
    void ReturnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void TableClick(MouseEvent event) {
 l=TableLectures.getSelectionModel().getSelectedItem();
    		SelectedLecture.setText(l.toString());
    }
    
    @FXML
    void Search(ActionEvent event) {
    	Lecture l = new Lecture();
    	l.setYear(Year.getText());
    	l.setModule(Module.getText());
    	l.setWeek(Integer.parseInt(Week.getText()));
    	if(Date.getValue()!=null){l.setStartDate(Date.getValue().toString());}
    	l.setStaff(Staff.getText());
    	l.setGroup(Groups.getText());
List<Lecture> searched = SearchQueries.ComboSearchLectures(l);
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
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
