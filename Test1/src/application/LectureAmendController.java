package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.SearchQueries;

public class LectureAmendController {
	
	protected static Lecture selectedLecture;

    @FXML
    private ImageView Image;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField WeekText;

    @FXML
    private JFXListView<Lecture> ListOfLectures;

    @FXML
    private JFXTextField StaffText;


    @FXML
    private DatePicker Date;


    @FXML
    private JFXTextField YearText;


    @FXML
    private JFXTextField StartTimeText;

    @FXML
    private JFXComboBox<String> Module;

   

    @FXML
    void WeekSearch(ActionEvent event) {
List<Lecture> searched = SearchQueries.searchLecture(2, WeekText.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void StartTimeSearch(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(4, StartTimeText.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void YearSearch(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(7, YearText.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void StaffSearch(ActionEvent event) {
List<Lecture> searched = SearchQueries.searchLecture(5, StaffText.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void ModuleSearch(ActionEvent event) {
List<Lecture> searched = SearchQueries.searchLecture(6, Module.getValue());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void DateSearch(ActionEvent event) {
	List<Lecture> searched = SearchQueries.searchLecture(3, Date.getValue().toString());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void ReturnLectureMenu(ActionEvent event) throws Exception {
GeneralMethods.ChangeScene("LectureMenu","LectureMenu");
    }
    
    @FXML
    void ReturnMainMenu(ActionEvent event) throws Exception {
GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void ListClicked(MouseEvent event) throws Exception {
if(event.getClickCount()==2){
   		 selectedLecture=ListOfLectures.getSelectionModel().getSelectedItem();
   		 System.out.println("clicked on " + selectedLecture);
   		 GeneralMethods.ChangeScene("AmendSingleLecture","AmendSingleLecture");
    	}
    }

    @FXML
    void ComboSearch(ActionEvent event) {
    	int week;
    	if(WeekText.getText().isEmpty()){
    		week = 0;
    	}else {
 week = Integer.parseInt(WeekText.getText());
    	}
    	Lecture l = new Lecture(week, StartTimeText.getText(), StaffText.getText(), Module.getValue(), YearText.getText());
    	if(Date.getValue()!=null){l.setStartDate(Date.getValue().toString());}
    	List<Lecture> searched = SearchQueries.ComboSearchLectures(l);
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void initialize() {
    	Module.getItems().addAll(SQL.Modules());
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
   
    }
}
