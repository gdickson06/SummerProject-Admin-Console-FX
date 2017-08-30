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
 * @param event
 */
	@FXML
	void uploadFile(ActionEvent event) {
		String s = filePathTextField.getText();

		List<Student> studentList = new ArrayList<Student>();
		boolean error = false;
		try {
			studentList = CSV.readStudentsFromCSV(s);
			StudentSQL.saveSQLStudents(studentList, Year.getValue().toString());
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
 * This method will delete a full year worth of Students
 * @param event
 * @throws Exception
 */
	@FXML
	void DeleteYear(ActionEvent event) throws Exception {
		if(Year.getValue()!=null){
		StudentSQL.DeleteYearStudent(Year.getValue().toString());
		GeneralMethods.show("DELETED ALL FOR YEAR", "DELETED ALL FOR YEAR");
		} else {
			GeneralMethods.show("Pick a year before attempting to delete a year", "Warning");
		}
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
	     * This method will download the Studnet list on the server to a CSV sheet
	     * @param event
	     * @throws SQLException 
	     * @throws IOException 
	     */
	    @FXML
	    void downloadCSVList(ActionEvent event) throws IOException, SQLException{
	    	if(Year.getValue()==null){
	    		GeneralMethods.show("Please pick year first", "Warning");
	    	}else {
	    		List<String>attributes = new ArrayList<String>();
	    		
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
	     * This method will initialize before the screen loads up by adding an image and populating a combobox
	     */
	    @FXML
	    void initialize() {
	    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
	    	Image.setImage(i);
	    	ApplicationMethods.Years(Year);
	    }

}
