package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import org.controlsfx.control.CheckListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Lecture;

import uk.ac.qub.objects.Student;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.SearchQueries;

public class InputPDFController {
	private static Lecture selectedLecture;

	private static List<Student> selectedItems;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField Lecture;

	@FXML
	private CheckListView<Student> Students;

	@FXML
	private Label LectureInfo;

	@FXML
	void SelectStudents(ActionEvent event) {
		
	}

	@FXML
	void LogAbsences(ActionEvent event) {
		selectedItems=Students.getCheckModel().getCheckedItems();
		System.out.println(selectedItems.size());
		
		try {
			SQL.tutorialListAbsences(selectedLecture, selectedItems);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			GeneralMethods.show(e.getLocalizedMessage(), "Error");
		}
	}

	@FXML
	void Back(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("mainMenu");
	}

	@FXML
	void ChangeLecture(ActionEvent event) throws SQLException {
		List<Lecture> lectures = SearchQueries.searchLecture(1, Lecture.getText());

		selectedLecture = lectures.get(0);

		LectureInfo.setText(selectedLecture.toString());

		List<Student> students = SearchQueries.studentsInLecture(selectedLecture.getGroup());

		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(students);
		Students.setItems(list);

	}

	@FXML
	void initialize() {

		assert Lecture != null : "fx:id=\"Lecture\" was not injected: check your FXML file 'InputCSV.fxml'.";
		assert Students != null : "fx:id=\"Students\" was not injected: check your FXML file 'InputCSV.fxml'.";
		assert LectureInfo != null : "fx:id=\"LectureInfo\" was not injected: check your FXML file 'InputCSV.fxml'.";

	}
}
