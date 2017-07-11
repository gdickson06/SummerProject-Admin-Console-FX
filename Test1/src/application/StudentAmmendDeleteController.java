package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.SearchQueries;
import uk.ac.qub.churst.Student;

public class StudentAmmendDeleteController {
	
	protected Student SelectedStudent;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private TextField firstName;

	@FXML
	private TextField lastName;

	@FXML
	private ListView<Student> ListOfStudents;

	@FXML
	private TextField IntakeYear;

	@FXML
	private TextField Cohort;

	@FXML
	private TextField StudentNumber;

	@FXML
	private Button studentCancel;

	@FXML
	private TextField EmailAddress;

	@FXML
	void studentCancelButton(ActionEvent event) throws Exception {
		GeneralMethods.homeScreen();
	}

	@FXML
	void FirstNameSearch(ActionEvent event) {
		List<Student> searched = SearchQueries.searchStudent(4, firstName.getText());
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfStudents.setItems(list);
		System.out.println(searched.size());
		
		

	}

	@FXML
	void StudentNumberSearch(ActionEvent event) {
		List<Student> searched = SearchQueries.searchStudent(1, StudentNumber.getText());
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfStudents.setItems(list);
		System.out.println(searched.size());
	}

	@FXML
	void CohortSearch(ActionEvent event) {
		List<Student> searched = SearchQueries.searchStudent(3, Cohort.getText());
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfStudents.setItems(list);
		System.out.println(searched.size());
	}

	@FXML
	void SurnameSearch(ActionEvent event) {
		List<Student> searched = SearchQueries.searchStudent(5, lastName.getText());
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfStudents.setItems(list);
		System.out.println(searched.size());
	}

	@FXML
	void IntakeYearSearch(ActionEvent event) {
		List<Student> searched = SearchQueries.searchStudent(2, IntakeYear.getText());
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfStudents.setItems(list);
		System.out.println(searched.size());
	}

	@FXML
	void EmailSearch(ActionEvent event) {
		List<Student> searched = SearchQueries.searchStudent(6, EmailAddress.getText());
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfStudents.setItems(list);
		System.out.println(searched.size());
	}
	
	 @FXML
	    void ListClicked(MouseEvent event) {
		 if(event.getClickCount()==2){
		 SelectedStudent=ListOfStudents.getSelectionModel().getSelectedItem();
		 System.out.println("clicked on " + SelectedStudent);
	    }
	 }
	@FXML
	void initialize() {
		assert firstName != null : "fx:id=\"firstName\" was not injected: check your FXML file 'StudentAmmendDelete.fxml'.";
		assert lastName != null : "fx:id=\"lastName\" was not injected: check your FXML file 'StudentAmmendDelete.fxml'.";
		assert ListOfStudents != null : "fx:id=\"ListOfStudents\" was not injected: check your FXML file 'StudentAmmendDelete.fxml'.";
		assert IntakeYear != null : "fx:id=\"IntakeYear\" was not injected: check your FXML file 'StudentAmmendDelete.fxml'.";
		assert Cohort != null : "fx:id=\"Cohort\" was not injected: check your FXML file 'StudentAmmendDelete.fxml'.";
		assert StudentNumber != null : "fx:id=\"StudentNumber\" was not injected: check your FXML file 'StudentAmmendDelete.fxml'.";
		assert studentCancel != null : "fx:id=\"studentCancel\" was not injected: check your FXML file 'StudentAmmendDelete.fxml'.";
		assert EmailAddress != null : "fx:id=\"EmailAddress\" was not injected: check your FXML file 'StudentAmmendDelete.fxml'.";

	}
}
