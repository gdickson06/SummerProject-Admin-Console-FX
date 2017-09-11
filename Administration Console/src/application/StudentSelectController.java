package application;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Student;
import uk.ac.qub.sql.StudentSQL;
/** 
 * Name of Package - application
 * Date Last Amended - 08/09/17
 * Outline - This is the controller class for the selected student screen, this
 * will contain methods to return to any of the previous three screens and to amend
 * and delete the selected student 
 * Demographics – 197 LOC 6 Methods 
 * 
 */
public class StudentSelectController {
	@FXML
	private Label StudentNumber;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	Student s = StudentAmendDeleteController.selectedStudent;
	@FXML
	private JFXTextField lastName;

	@FXML
	private JFXTextArea comments;

	@FXML
	private JFXComboBox<Integer> year;

	@FXML
	private JFXTextField prefix;

	@FXML
	private JFXTextField cohort;

	@FXML
	private ImageView Image;

	@FXML
	private Label studentNumberLabel;

	@FXML
	private JFXTextField firstName;

	@FXML
	private JFXTextField emailAddress;

	@FXML
	private JFXTextField nationality;

	@FXML
	private JFXTextField portfolio;

	@FXML
	private JFXTextField graduate;

	@FXML
	private JFXTextField name;

	@FXML
	private JFXTextField middleName;
/**
 * This method will save all the changes made to a student
 * @param event
 * @throws Exception
 */
	@FXML
	void save(ActionEvent event) throws Exception {
		List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(cohort);
		fields.add(year);
		fields.add(name);
		if(ApplicationMethods.noNullValues(fields)){
		
		s.setCohort(cohort.getText());
		s.setComments(comments.getText());
		s.setEmail(emailAddress.getText());
		s.setFirstName(firstName.getText());
		s.setGraduate(graduate.getText());
		s.setLastName(lastName.getText());
		s.setMiddleName(middleName.getText());
		s.setName(name.getText());
		s.setNationality(nationality.getText());
		s.setPortfolio(portfolio.getText());
		s.setPrefix(prefix.getText());
		s.setYear(year.getValue().toString());
		StudentSQL.AmendStudent(s);

		GeneralMethods.show(
				"The student number" + Integer.toString(StudentAmendDeleteController.selectedStudent.getStudentNumber())
						+ " has been amended",
				"Record Changed");
		}
	}
/**
 * This method will return the user to the search menu
 * @param event
 * @throws Exception
 */
	@FXML
	void returnSearch(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("AmendDeleteStudentMenu", "AmendDeleteStudentMenu");
	}
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
	@FXML
	void returnMain(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("MainMenu", "MainMenu");
	}
/**
 * This method will return the user to the Student menu
 * @param event
 * @throws Exception
 */
	@FXML
	void returnStudentMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("StudentMenu", "StudentMenu");
	}

/**
 * 	This method will delete a selected Student
 * @param event
 * @throws Exception
 */
	@FXML
	void deleteStudent(ActionEvent event) throws Exception {
		StudentSQL.DeleteStudent(Integer.toString(StudentAmendDeleteController.selectedStudent.getStudentNumber()));
		GeneralMethods.show(
				"The record for " + Integer.toString(StudentAmendDeleteController.selectedStudent.getStudentNumber())
						+ " has been deleted.",
				"Record Deleted");
		GeneralMethods.ChangeScene("MainMenu", "MainMenu");

	}
/**
 * The initialize method will populate all of the fields with the values of
 * the selected student and populate the year combo box and the imageview
 */
	@FXML
	void initialize() {

		studentNumberLabel.setText(Integer.toString(StudentAmendDeleteController.selectedStudent.getStudentNumber()));
		lastName.setText(s.getLastName());
		

		comments.setText(s.getComments());

		year.setValue(Integer.valueOf(s.getYear()));

		prefix.setText(s.getPrefix());

		cohort.setText(s.getCohort());

		firstName.setText(s.getFirstName());

		emailAddress.setText(s.getEmail());

		nationality.setText(s.getNationality());

		portfolio.setText(s.getPortfolio());

		graduate.setText(s.getGraduate());

		name.setText(s.getName());

		middleName.setText(s.getMiddleName());

		ApplicationMethods.Years(year);

		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
		Image.setImage(i);
	}
}
