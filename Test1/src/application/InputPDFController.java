package application;

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
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import uk.ac.qub.methods.GeneralMethods;
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
			GeneralMethods.show("Absences uploaded to database", "Success");
		} catch (SQLException e) {
			e.printStackTrace();
			GeneralMethods.show("Error in logging absence", "Error");
		}
    }

    @FXML
    void PickLecture(ActionEvent event) throws NumberFormatException, SQLException {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(Lecture);
		
		if(ApplicationMethods.noNullValues(fields)){
    	List<uk.ac.qub.objects.Lecture> lectures = SearchQueries.searchLecture(1, Lecture.getText());
    	try{
		selectedLecture = lectures.get(0);

		LectureInfo.setText(selectedLecture.toString());

		List<Student> students = SearchQueries.studentsInLecture(selectedLecture);
		if(students.size()>0){
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(students);
		Students.setItems(list);
		} else {
			GeneralMethods.show("No students in lecture", "Warning");
		}
	
    	} catch (IndexOutOfBoundsException e){
    		GeneralMethods.show("No such lecture, please check PDF ID", "Error");
    	}
		}
    }

    @FXML
    void returnToPDFMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("PDFMenu", "PDFMenu");
    }

    @FXML
    void returnToMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
    }

    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
