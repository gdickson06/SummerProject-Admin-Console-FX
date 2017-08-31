package application;


import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.image.ImageView;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Student;
import uk.ac.qub.sql.StudentSQL;

public class UploadSingleStudentController {
	@FXML
    private JFXTextArea comments;

    @FXML
    private JFXComboBox<Integer> year;

    @FXML
    private JFXTextField studentNumber;

    @FXML
    private JFXTextField prefix;

    @FXML
    private JFXTextField cohort;

    @FXML
    private JFXTextField firstName;

    @FXML
    private JFXTextField emailAddress;

    @FXML
    private JFXTextField nationality;

    @FXML
    private JFXTextField portfolio;

    @FXML
    private JFXTextField surname;

    @FXML
    private JFXTextField name;

    @FXML
    private JFXTextField middleName;

    @FXML
    private JFXTextField Graduate;
    
    @FXML
    private ImageView Image;

/**
 * This method will upload a new student to the database
 * @param event
 */
    @FXML
    void uploadStudent(ActionEvent event) {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(cohort);
		fields.add(year);
		fields.add(name);
		fields.add(studentNumber);
		if(ApplicationMethods.noNullValues(fields)){
    	Student s = new Student();
    	s.setComments(comments.getText());
    	s.setCohort(cohort.getText());
    	s.setEmail(emailAddress.getText());
    	s.setFirstName(firstName.getText());
    	s.setGraduate(Graduate.getText());
    	s.setLastName(surname.getText());
    	s.setMiddleName(middleName.getText());
    	s.setName(name.getText());
    	s.setNationality(nationality.getText());
    	s.setPortfolio(portfolio.getText());
    	s.setPrefix(prefix.getText());
    	s.setStudentNumber(Integer.valueOf(studentNumber.getText()));
    	s.setYear(year.getValue().toString());
    	try {
			StudentSQL.UploadSingleStudent(s);
			GeneralMethods.show("Successfully uploaded student", "Success");
		} catch (Exception e) {
			e.printStackTrace();
			GeneralMethods.show("Error when uploading Student", "ERROR");
		}}
    	
   }
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void mainMenu(ActionEvent event)throws Exception {
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
    }
/**
 * This method will return the user to the student menu 
 * @param event
 * @throws Exception
 */
    @FXML
    void studentMenu(ActionEvent event)throws Exception {
    	GeneralMethods.ChangeScene("StudentMenu","StudentMenu");
    }
 /**
  * This method will clear all the text on the screen   
  * @param event
  * @throws Exception
  */
    @FXML
    void clear(ActionEvent event)throws Exception {
    	comments.setText("");
    	cohort.setText("");
    	emailAddress.setText("");
    	firstName.setText("");
    	Graduate.setText("");
    	surname.setText("");
    	middleName.setText("");
    	name.setText("");
    	nationality.setText("");
    	portfolio.setText("");
    	prefix.setText("");
    	studentNumber.setText("");
    	year.setValue(null);
    }
    
    /**
     * This intialize method will populate the combobox and the image on the page
     */
    @FXML
    void initialize() {
    	ApplicationMethods.Years(year);
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }

}
