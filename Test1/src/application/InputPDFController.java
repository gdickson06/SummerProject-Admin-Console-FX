package application;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Student;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.SearchQueries;

import org.controlsfx.control.CheckListView;

public class InputPDFController {
	
    @FXML
    private Label LectureInfo;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField Lecture;

    @FXML
    private CheckListView<Student> Students;

    @FXML
    private ImageView Image;

private static uk.ac.qub.objects.Lecture selectedLecture;

	private static List<Student> selectedItems;
  

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
    void PickLecture(ActionEvent event) throws NumberFormatException, SQLException {
    	List<uk.ac.qub.objects.Lecture> lectures = SearchQueries.searchLecture(1, Lecture.getText());

		selectedLecture = lectures.get(0);

		LectureInfo.setText(selectedLecture.toString());

		List<Student> students = SearchQueries.studentsInLecture(selectedLecture.getGroup(),Integer.parseInt(selectedLecture.getYear()));

		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(students);
		System.out.println(list.size());
		Students.setItems(list);
    }

    @FXML
    void returnToPDFMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("PDFMenu", "PDFMenu");
    }

    @FXML
    void returnToMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
