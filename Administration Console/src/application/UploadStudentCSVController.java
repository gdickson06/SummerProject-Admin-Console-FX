package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import uk.ac.qub.methods.CSV;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Student;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.StudentSQL;
/** 
 * Name of Package - application
 * Date Last Amended - 08/09/17
 * Outline - This is the controller class for a user to be able to upload a full
 * year of students from a CSV file, deleting a full year of students and to 
 * download a full year of students to a CSV file.
 * Demographics – 190 LOC 7 Methods 
 * 
 */
public class UploadStudentCSVController {
	@FXML
	private JFXComboBox<Integer> Year;

	@FXML
	private ImageView Image;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private JFXTextField filePathTextField;

	private FileChooser fileChooser = new FileChooser();
	private File f;

	/**
	 * This method will allow a file to be selected to be uploaded.
	 * 
	 * @param event
	 */
	@FXML
	void chooseCSV(ActionEvent event) {

		GeneralMethods.configureFileChooser(fileChooser);
		File fileCSV = fileChooser.showOpenDialog(Main.getStage());
		if (fileCSV != null) {
			f = fileCSV;
		}
		filePathTextField.setText(f.getAbsolutePath());
	}

	/**
	 * This method will upload a spreadsheet to the SQL database
	 * 
	 * @param event
	 */
	@FXML
	void uploadFile(ActionEvent event) {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(Year);
		fields.add(filePathTextField);
		
		if(ApplicationMethods.noNullValues(fields)){
				String s = filePathTextField.getText();

				List<Student> studentList = new ArrayList<Student>();

				try {
					studentList = CSV.readStudentsFromCSV(s);
					StudentSQL.saveSQLStudents(studentList, Year.getValue().toString());
					GeneralMethods.show("Import successful with " + studentList.size() + " students imported",
							"UPLOAD SUCCESS");
				} catch (Exception e) {
					if (e instanceof NumberFormatException) {
						GeneralMethods.show("Ensure that Student Number is in number format (max 8)", "Error");
					} else if (e instanceof InputMismatchException) {
						GeneralMethods.show("Error in inputting Cohort", "Error");
					} else if (e instanceof Exception) {
						GeneralMethods.show(e.getMessage(), "Error");
					}
					e.printStackTrace();

				}
			}

		
	}

	/**
	 * This method will return the user to the main menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void returnMainMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("MainMenu", "MainMenu");
	}

	/**
	 * This method will delete a full year worth of Students
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void DeleteYear(ActionEvent event) throws Exception {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(Year);
		
		if(ApplicationMethods.noNullValues(fields)){
			StudentSQL.DeleteYearStudent(Year.getValue().toString());
			GeneralMethods.show("DELETED ALL FOR YEAR", "DELETED ALL FOR YEAR");
		}
	}

	/**
	 * This method will return the user to the Student Menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void returnStudentMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("StudentMenu", "StudentMenu");
	}

	/**
	 * This method will download the Studnet list on the server to a CSV sheet
	 * 
	 * @param event
	 * @throws SQLException
	 * @throws IOException
	 */
	@FXML
	void downloadCSVList(ActionEvent event) throws IOException, SQLException {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(Year);
		
		if(ApplicationMethods.noNullValues(fields)){
			List<String> attributes = new ArrayList<String>();

			attributes.add("student_number");
			attributes.add("last_name");
			attributes.add("first_name");
			attributes.add("middle_name");
			attributes.add("prefix");
			attributes.add("name");
			attributes.add("cohort");
			attributes.add("email");
			attributes.add("nationality");
			attributes.add("graduate");
			attributes.add("comments");
			attributes.add("portfolio");
			SQL.downloadToCSV(attributes, Year.getValue().toString(), "Students WHERE year_group =");
		}
	}

	/**
	 * This method will initialize before the screen loads up by adding an image
	 * and populating a combobox
	 */
	@FXML
	void initialize() {
		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
		Image.setImage(i);
		ApplicationMethods.Years(Year);
	}

}
