package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.ConvertGroup;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.SearchQueries;

public class LectureAmendController {
	
	protected static Lecture selectedLecture;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField WeekText;

    @FXML
    private ListView<Lecture> ListOfLectures;

    @FXML
    private TextField StaffText;

    @FXML
    private Button StaffSearch;

    @FXML
    private Button ComboSearch;

    @FXML
    private TextField DateText;

   

    @FXML
    private Button StartTimeSearch;

    @FXML
    private Button ModuleSearch;

 

    @FXML
    private Button Back;

    @FXML
    private TextField YearText;

    @FXML
    private Button WeekSearch;

    @FXML
    private Button YearSearch;

    @FXML
    private Button DateSearch;

    @FXML
    private TextField StartTimeText;

    @FXML
    private ComboBox<String> Module;

   

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
	List<Lecture> searched = SearchQueries.searchLecture(3, ConvertGroup.DateConvertSQL(DateText.getText()));
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void Back(ActionEvent event) throws Exception {
GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void ListClicked(MouseEvent event) throws Exception {
if(event.getClickCount()==2){
   		 selectedLecture=ListOfLectures.getSelectionModel().getSelectedItem();
   		 System.out.println("clicked on " + selectedLecture);
   		 GeneralMethods.ChangeScene("SelectedLecture");
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
    	Lecture l = new Lecture(week, DateText.getText(), StartTimeText.getText(), StaffText.getText(), Module.getValue(), YearText.getText());
    	List<Lecture> searched = SearchQueries.ComboSearchLectures(l);
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void initialize() {
    	Module.getItems().addAll(SQL.Modules());
    	
        assert WeekText != null : "fx:id=\"WeekText\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert ListOfLectures != null : "fx:id=\"ListOfLectures\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert StaffText != null : "fx:id=\"StaffText\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert StaffSearch != null : "fx:id=\"StaffSearch\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert ComboSearch != null : "fx:id=\"ComboSearch\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert DateText != null : "fx:id=\"DateText\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert StartTimeSearch != null : "fx:id=\"StartTimeSearch\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert ModuleSearch != null : "fx:id=\"ModuleSearch\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
       assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert YearText != null : "fx:id=\"YearText\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert WeekSearch != null : "fx:id=\"WeekSearch\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert YearSearch != null : "fx:id=\"YearSearch\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert DateSearch != null : "fx:id=\"DateSearch\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert StartTimeText != null : "fx:id=\"StartTimeText\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";
        assert Module != null : "fx:id=\"Module\" was not injected: check your FXML file 'LectureAmendDelete.fxml'.";

    }
}
