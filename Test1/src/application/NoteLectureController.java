package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
    private Button SearchGroups;

    @FXML
    private Button SearchStaff;

    @FXML
    private Button Cancel;

    @FXML
    private Button SearchSubject;

    @FXML
    private Button SearchWeek;

    @FXML
    private TextField Staff;

    @FXML
    private Button SearchDate;

    @FXML
    private Label SelectedLecture;

    @FXML
    private Button Upload;

    @FXML
    private TextField Date;

    @FXML
    private TextField Subject;

    @FXML
    private ListView<Lecture> TableLectures;

    @FXML
    private TextField Groups;

    @FXML
    private TextArea Note;

    @FXML
    private Button SearchModule;

    @FXML
    private TextField Module;

    @FXML
    private TextField Week;

    @FXML
    void TableClick(MouseEvent event) {
    	 
    		 l=TableLectures.getSelectionModel().getSelectedItem();
    		SelectedLecture.setText(l.toString());
    	    
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
    void Cancel(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("mainMenu");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void SearchWeek(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(2, String.valueOf(Week.getText()));
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		TableLectures.setItems(list);
		
    }

    @FXML
    void SearchDate(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(3, Date.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		TableLectures.setItems(list);
    }

    @FXML
    void SearchGroups(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(4, Groups.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		TableLectures.setItems(list);
    }

    @FXML
    void SearchSubject(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(5, Subject.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		TableLectures.setItems(list);
    }

    @FXML
    void SearchModule(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(6, Module.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		TableLectures.setItems(list);
    }

    @FXML
    void SearchStaff(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(7, Staff.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		TableLectures.setItems(list);
    }

    @FXML
    void initialize() {
        assert SearchGroups != null : "fx:id=\"SearchGroups\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert SearchStaff != null : "fx:id=\"SearchStaff\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert Cancel != null : "fx:id=\"Cancel\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert SearchSubject != null : "fx:id=\"SearchSubject\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert SearchWeek != null : "fx:id=\"SearchWeek\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert Staff != null : "fx:id=\"Staff\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert SearchDate != null : "fx:id=\"SearchDate\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert SelectedLecture != null : "fx:id=\"SelectedLecture\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert Upload != null : "fx:id=\"Upload\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert Date != null : "fx:id=\"Date\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert Subject != null : "fx:id=\"Subject\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert TableLectures != null : "fx:id=\"TableLectures\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert Groups != null : "fx:id=\"Groups\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert Note != null : "fx:id=\"Note\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert SearchModule != null : "fx:id=\"SearchModule\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert Module != null : "fx:id=\"Module\" was not injected: check your FXML file 'NoteLecture.fxml'.";
        assert Week != null : "fx:id=\"Week\" was not injected: check your FXML file 'NoteLecture.fxml'.";

    }
}

