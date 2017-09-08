package application;

import com.jfoenix.controls.JFXTextField;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import uk.ac.qub.methods.FileWriter;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.sql.SQL;

public class GlobalSettingsController {
	/** 
	 * Name of Package - application
	 * Date Last Amended - 07/09/17
	 * Outline - This controller is for the global settings page, it will offer the 
	 * user the ability to download the user guide, change global and personal settings 
	 * and go to the forgotten password screen.
	 * Demographics – 202 LOC 6 Methods 
	 * 
	 */
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private ImageView image;

	@FXML
	private JFXTextField southernTrustContactNo;

	@FXML
	private JFXTextField southEasternTrustContactNumber;

	@FXML
	private JFXTextField schoolOfMedicineEmailAddress;

	@FXML
	private JFXTextField personalDayAllowance;

	@FXML
	private JFXTextField belfastTrustContactNumber;

	@FXML
	private JFXTextField changeFileLocation;

	@FXML
	private JFXTextField northernTrustContactNumber;

	@FXML
	private JFXTextField personalDayPolicy;

	@FXML
	private JFXTextField forgottenPasswordLink;

	@FXML
	private JFXTextField schoolOfMedicineContactNumber;

	@FXML
	private JFXTextField findCurrentAbsencesPolicy;

	@FXML
	private JFXTextField qubITOnlineForm;

	@FXML
	private JFXTextField QUBITHelpdeskWebsite;

	@FXML
	private JFXTextField westernTrustContactNumber;

	@FXML
	private JFXTextField absencesEmailAddress;
/**
 * This method will take a list of Strings and update all of the user settings with
 * the new values
 * @param event
 */
	@FXML
	void saveDetails(ActionEvent event) {

		List<String>newValues = new ArrayList<String>();
		
		newValues.add(westernTrustContactNumber.getText());
		newValues.add(southernTrustContactNo.getText());
		newValues.add(southEasternTrustContactNumber.getText());
		newValues.add(schoolOfMedicineEmailAddress.getText());
		newValues.add(schoolOfMedicineContactNumber.getText());
		newValues.add(qubITOnlineForm.getText());
		newValues.add(QUBITHelpdeskWebsite.getText());
		newValues.add(personalDayPolicy.getText());
		newValues.add(personalDayAllowance.getText());
		newValues.add(northernTrustContactNumber.getText());
		newValues.add(forgottenPasswordLink.getText());
		newValues.add(findCurrentAbsencesPolicy.getText());
		newValues.add(belfastTrustContactNumber.getText());
		newValues.add(absencesEmailAddress.getText());
		
		try {
			SQL.updateInfo(newValues);
			GeneralMethods.show("Successfully updated items", "Success");
		} catch (SQLException e) {
			GeneralMethods.show("Error in updating values", "Error");
		}
		
		
	}
/**
 * This method will display the user guide on the screen
 * @param event
 */
	@FXML
	void downloadUserGuide(ActionEvent event) {
		
		 try {
			Desktop.getDesktop().open(new File("Administration Console User Guide.pdf"));
		} catch (IOException e) {
			GeneralMethods.show("Error in opening user guide", "Error");
		}
	}
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
	@FXML
	void returnMainMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("MainMenu", "MainMenu");
	}
/**
 * This method will send the user to the forgotten password link
 * @param event
 * @throws IOException
 * @throws URISyntaxException
 */
	@FXML
	void ChangePassword(ActionEvent event) throws IOException, URISyntaxException {
		java.awt.Desktop.getDesktop().browse(new URI(forgottenPasswordLink.getText()));
		
	}
/**
 * This method will write to the saveinfo.txt file the location where the user
 * wants the files to be saved.
 * @param event
 */
    @FXML
    void ChangeFileLocation(ActionEvent event) {
     	FileWriter.save(changeFileLocation.getText().replace("\\" , "/"));
    	GeneralMethods.show("Location changed to" + changeFileLocation.getText(), "Location Changed");
   
    }
/**
 * This is the initialize method and will upload the current information to the screen
 * along with setting the image in the top left hand side of the screen
 */
	@FXML
	void initialize() {
		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
		image.setImage(i);
		try {
			Map<String, String> info = SQL.importGlobalSettings();
			
			System.out.println(info.size());
			southernTrustContactNo.setText(info.get("Southern Trust Contact Number"));
			southEasternTrustContactNumber.setText(info.get("South Eastern Trust"));
			schoolOfMedicineEmailAddress.setText(info.get("School of Medicine Email "));
			personalDayAllowance.setText(info.get("Personal Day Allowance"));
			belfastTrustContactNumber.setText(info.get("Belfast Trust Contact Number"));
			northernTrustContactNumber.setText(info.get("Northern Trust Contact Number"));
			personalDayPolicy.setText(info.get("Personal Day Policy"));
			forgottenPasswordLink.setText(info.get("Forgotten Password Link "));
			schoolOfMedicineContactNumber.setText(info.get("School of Medicine Contact Number"));
			findCurrentAbsencesPolicy.setText(info.get("Find Current Absences Policy "));
			qubITOnlineForm.setText(info.get("QUB IT Online Form"));
			QUBITHelpdeskWebsite.setText(info.get("QUB IT Helpdesk Website"));
			westernTrustContactNumber.setText(info.get("Western Trust Contact Number"));
			absencesEmailAddress.setText(info.get("Absences Email Address"));
		} catch (SQLException e) {
			GeneralMethods.show("Error when populating fields", "Error");
			e.printStackTrace();
		}
		try {
			changeFileLocation.setText(FileWriter.load());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
