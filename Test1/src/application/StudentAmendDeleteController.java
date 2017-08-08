package application;

import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Student;
import uk.ac.qub.sql.SearchQueries;

public class StudentAmendDeleteController {

	protected static Student selectedStudent;
    @FXML
    private ResourceBundle resources;
    
    @FXML
    private ImageView Image;

    @FXML
    private URL location;

    @FXML
    private JFXTextField firstName;

    @FXML
    private JFXTextField lastName;

    @FXML
    private JFXTextField Cohort;

    @FXML
    private JFXTextField IntakeYear;

    @FXML
    private JFXTextField StudentNumber;

    @FXML
    private JFXListView<Student> listOfStudents;

    @FXML
    private JFXTextField EmailAddress;

    @FXML
    void comboSearch(ActionEvent event) {
List<String> list = new ArrayList<String>();
		
		list.add(firstName.getText());
		list.add(lastName.getText());
		list.add(StudentNumber.getText());
		list.add(Cohort.getText());
		list.add(IntakeYear.getText());
		list.add(EmailAddress.getText());
		
		List<Student> searched = SearchQueries.ComboSearchStudents(list);
		ObservableList<Student> List = FXCollections.observableArrayList();
		List.addAll(searched);
		listOfStudents.setItems(List);
    }

    @FXML
    void returnStudentMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StudentMenu", "StudentMenu");
    }

    @FXML
    void returnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void ListClick(MouseEvent event) throws Exception {
    	 if(event.getClickCount()==2){
    		 selectedStudent=listOfStudents.getSelectionModel().getSelectedItem();
    		 System.out.println("clicked on " + selectedStudent);
    		 GeneralMethods.ChangeScene("AmendSingleStudent","AmendSingleStudentMenu");
    	    }
    }

    @FXML
    void SearchFirstName(ActionEvent event) {
    	List<Student> searched = SearchQueries.searchStudent(4, firstName.getText());
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		listOfStudents.setItems(list);
		System.out.println(searched.size());
		
    }

    @FXML
    void SearchStudentNumber(ActionEvent event) {
    	List<Student> searched = SearchQueries.searchStudent(1, StudentNumber.getText());
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		listOfStudents.setItems(list);
		System.out.println(searched.size());
    }

    @FXML
    void CohortSearch(ActionEvent event) {
    	List<Student> searched = SearchQueries.searchStudent(3, Cohort.getText());
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		listOfStudents.setItems(list);
		System.out.println(searched.size());
    }

    @FXML
    void EmailSearch(ActionEvent event) {
    	List<Student> searched = SearchQueries.searchStudent(6, EmailAddress.getText());
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		listOfStudents.setItems(list);
		System.out.println(searched.size());
    }

    @FXML
    void IntakeYearSearch(ActionEvent event) {
    	List<Student> searched = SearchQueries.searchStudent(2, IntakeYear.getText());
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		listOfStudents.setItems(list);
		System.out.println(searched.size());
    }

    @FXML
    void SearchSurname(ActionEvent event) {
    	List<Student> searched = SearchQueries.searchStudent(5, lastName.getText());
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		listOfStudents.setItems(list);
		System.out.println(searched.size());
    }

    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
        assert firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'AmendDeleteStudentMenu.fxml'.";
        assert lastName != null : "fx:id=\"lastName\" was not injected: check your FXML file 'AmendDeleteStudentMenu.fxml'.";
        assert Cohort != null : "fx:id=\"Cohort\" was not injected: check your FXML file 'AmendDeleteStudentMenu.fxml'.";
        assert IntakeYear != null : "fx:id=\"IntakeYear\" was not injected: check your FXML file 'AmendDeleteStudentMenu.fxml'.";
        assert StudentNumber != null : "fx:id=\"StudentNumber\" was not injected: check your FXML file 'AmendDeleteStudentMenu.fxml'.";
        assert listOfStudents != null : "fx:id=\"listOfStudents\" was not injected: check your FXML file 'AmendDeleteStudentMenu.fxml'.";
        assert EmailAddress != null : "fx:id=\"EmailAddress\" was not injected: check your FXML file 'AmendDeleteStudentMenu.fxml'.";

    }
}
