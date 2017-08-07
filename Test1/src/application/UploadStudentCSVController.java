package application;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import uk.ac.qub.churst.CSV;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Student;

import uk.ac.qub.sql.StudentSQL;

public class UploadStudentCSVController {
	@FXML
	private JFXTextField Year;
	
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

	@FXML
	void chooseCSV(ActionEvent event) {

		GeneralMethods.configureFileChooser(fileChooser);
		File fileCSV = fileChooser.showOpenDialog(Main.getStage());
		if (fileCSV != null) {
			f = fileCSV;
		}
		filePathTextField.setText(f.getAbsolutePath());
	}

	@FXML
	void uploadFile(ActionEvent event) {
		String s = filePathTextField.getText();

		List<Student> studentList = new ArrayList<Student>();
		boolean error = false;
		try {
			studentList = CSV.readStudentsFromCSV(s);
			StudentSQL.saveSQLStudents(studentList, Year.getText());
		} catch (Exception e) {
			if (e instanceof NumberFormatException) {
				GeneralMethods.show("Ensure that Student Number is in number format (max 8)", "Error");
			} else if (e instanceof InputMismatchException) {
				GeneralMethods.show("Error in inputting Cohort", "Error");
			} else if (e instanceof Exception) {
				GeneralMethods.show(e.getMessage(), "Error");
			}
			e.printStackTrace();

			error = true;
		}

		if (error == false) {
			GeneralMethods.show("Import successful with " + studentList.size() + " students imported",
					"UPLOAD SUCCESS");
		}
	}

	@FXML
	void returnMainMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
	}

	@FXML
	void DeleteYear(ActionEvent event) throws Exception {
		StudentSQL.DeleteYearStudent(Year.getText());
		GeneralMethods.show("DELETED ALL FOR YEAR", "DELETED ALL FOR YEAR");
	}

	   @FXML
	    void returnStudentMenu(ActionEvent event) throws Exception {
		   GeneralMethods.ChangeScene("StudentMenu", "StudentMenu");
	    }
	@FXML
	void initialize() {
		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
	}

}
