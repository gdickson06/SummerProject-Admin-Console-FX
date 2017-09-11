package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Student;
import uk.ac.qub.sql.SearchQueries;
/** 
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This is the controller class for the Amend Delete student page
 * this will allow students to be searched and selected
 * Demographics – 238 LOC 11 Methods 
 * 
 */
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
    private JFXComboBox<Integer> IntakeYear;

    @FXML
    private JFXTextField StudentNumber;

    @FXML
    private JFXListView<Student> listOfStudents;

    @FXML
    private JFXTextField EmailAddress;
    /**
     * This method will search for students using all fields that have had data inputted
     * @param event
     */
    @FXML
    void comboSearch(ActionEvent event) {
    	Student s = new Student();
    	
    	s.setLastName(lastName.getText());
    	s.setFirstName(firstName.getText());
    	if(!StudentNumber.getText().isEmpty()){s.setStudentNumber(Integer.valueOf(StudentNumber.getText()));}
    	s.setCohort(Cohort.getText());
    	s.setEmail(EmailAddress.getText());
    	if(IntakeYear.getValue()!=null){s.setYear(IntakeYear.getValue().toString());}

		
		List<Student> searched = new ArrayList<Student>();
		try {
			searched = SearchQueries.ComboSearchStudents(s);
		} catch (SQLException e) {
			GeneralMethods.show("Error while searching students", "Error");
			e.printStackTrace();
		}
		ObservableList<Student> List = FXCollections.observableArrayList();
		List.addAll(searched);
		listOfStudents.setItems(List);
    }
/**
 * This method will return the user to the Student Menu
 * @param event
 * @throws Exception
 */
    @FXML
    void returnStudentMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StudentMenu", "StudentMenu");
    }
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void returnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
    }
/**
 * This method will take the user to the Student amend delete page by 
 * letting them click on a user in the list view.
 * @param event
 * @throws Exception
 */
    @FXML
    void ListClick(MouseEvent event) throws Exception {
    	 if(event.getClickCount()==2){
    		 selectedStudent=listOfStudents.getSelectionModel().getSelectedItem();
    		 GeneralMethods.ChangeScene("AmendSingleStudent","AmendSingleStudentMenu");
    	    }
    }
/**
 * This method will allow the Student to be searched by first name
 * @param event
 */
    @FXML
    void firstNameSearch(ActionEvent event) {
    	List<Student> searched = new ArrayList<Student>();
    	try {
			searched.addAll(SearchQueries.searchStudent(4, firstName.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching students", "Error");
			e.printStackTrace();
		}
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		listOfStudents.setItems(list);
		
		
    }
/**
 * This method will allow Students to be searched by Student number
 * @param event
 */
    @FXML
    void studentNumberSearch(ActionEvent event) {
    	List<Student> searched = new ArrayList<Student>();
    	try {
			searched.addAll(SearchQueries.searchStudent(1, StudentNumber.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching students", "Error");
			e.printStackTrace();
		}
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		listOfStudents.setItems(list);
		
    }
/**
 * This method will allow students to be searched by cohort
 * @param event
 */
    @FXML
    void cohortSearch(ActionEvent event) {
    	List<Student> searched = new ArrayList<Student>();
    	try {
			searched.addAll(SearchQueries.searchStudent(3, Cohort.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching students", "Error");
			e.printStackTrace();
		}
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		listOfStudents.setItems(list);
		
    }
/**
 * This method will allow the students to be searched by email address
 * @param event
 */
    @FXML
    void emailSearch(ActionEvent event) {
    	List<Student> searched = new ArrayList<Student>();
    	try {
			searched.addAll(SearchQueries.searchStudent(6, EmailAddress.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching students", "Error");
			e.printStackTrace();
		}
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		listOfStudents.setItems(list);
		
    }
/**
 * This method will allow students to be searched through intake year
 * @param event
 */
    @FXML
    void yearSearch(ActionEvent event) {
    	List<Student> searched = new ArrayList<Student>();
    	try {
			searched.addAll(SearchQueries.searchStudent(2, IntakeYear.getValue().toString()));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching students", "Error");
			e.printStackTrace();
		}
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		listOfStudents.setItems(list);
		
    }
/**
 * This will allows students to be searched through the surname
 * @param event
 */
    @FXML
    void lastNameSearch(ActionEvent event) {
    	List<Student> searched = new ArrayList<Student>();
    	try {
			searched.addAll(SearchQueries.searchStudent(5, lastName.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching students", "Error");
			e.printStackTrace();
		}
		ObservableList<Student> list = FXCollections.observableArrayList();
		list.addAll(searched);
		listOfStudents.setItems(list);
		
    }
/**
 * This method will initialize the page and populate the image and year combobox
 */
    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    ApplicationMethods.Years(IntakeYear);
    }
}
