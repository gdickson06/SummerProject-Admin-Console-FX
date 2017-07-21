package application;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.SearchQueries;


public class LectureAmendController {

	protected static Lecture SelectedLecture;
    @FXML
    private TextField WeekText;
    
    @FXML
    private Button Back;

    @FXML
    private ListView<Lecture> ListOfLectures;

    @FXML
    private TextField StaffText;

    @FXML
    private Button StaffSearch;

    @FXML
    private TextField SubjectText;

    @FXML
    private TextField ModuleText;

    @FXML
    private TextField DateText;

    @FXML
    private TextField GroupsText;

    @FXML
    private Button SubjectSearch;

    @FXML
    private Button GroupsSearch;

    @FXML
    private Button ModuleSearch;

    @FXML
    private Button WeekSearch;

    @FXML
    private Button DateSearch;

    @FXML
    void WeekSearch(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(2, WeekText.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void GroupsSearch(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(4, GroupsText.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void ModuleSearch(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(6, ModuleText.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void DateSearch(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(3, DateText.getText());
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
    void SubjectSearch(ActionEvent event) {
    	List<Lecture> searched = SearchQueries.searchLecture(7, SubjectText.getText());
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
    }

    @FXML
    void ListClicked(MouseEvent event) throws Exception {
    	if(event.getClickCount()==2){
   		 SelectedLecture=ListOfLectures.getSelectionModel().getSelectedItem();
   		 System.out.println("clicked on " + SelectedLecture);
   		 GeneralMethods.ChangeScene("SelectedLecture");
    	}
    }
    
    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

}
