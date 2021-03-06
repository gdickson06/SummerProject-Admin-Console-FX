package application;

import com.jfoenix.controls.JFXComboBox;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.sql.PlacementSQL;
/** 
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This is the controller class to upload a single placement to the database,
 * the methods will be able to upload the placement and to clear to fields.
 * Demographics � 140 LOC 5 Methods 
 * 
 */
public class UploadSinglePlacementController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField moduleNumber;

    @FXML
    private DatePicker endDate;

    @FXML
    private JFXComboBox<Integer> year;

    @FXML
    private JFXTextField module;

    @FXML
    private JFXTextField hospital;

    @FXML
    private ImageView Image;

    @FXML
    private JFXTextField preference;

    @FXML
    private DatePicker startDate;

    @FXML
    private JFXTextField group;
/**
 * This method will take the user back to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void MainMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu", "MainMenu");
    }
/**
 * This method will return the user to the placement menu
 * @param event
 * @throws Exception
 */
    @FXML
    void PlacementMenuButtonClick(ActionEvent event) throws Exception {
     	GeneralMethods.ChangeScene("PracticalMenuController", "PracticalPlacementMenu");
        
    }
/**
 * This method will clear all information input into the screen
 * @param event
 */
    @FXML
    void Clear(ActionEvent event) {
    	moduleNumber.setText("");
    	endDate.setValue(LocalDate.now());
    	startDate.setValue(LocalDate.now());
    	module.setText("");
    	preference.setText("");
    	group.setText("");
    	hospital.setText("");
    	year.setValue(0);
    }
    /**
	 * This method will upload a single placement, there will be checks that NON
	 * NULL values cannot be set to null and that time is in the correct format.
	 * 
	 * @param event
	 * @throws Exception
	 */
    @FXML
    void upload(ActionEvent event) {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(group);
		fields.add(year);
		fields.add(startDate);
		fields.add(endDate);
		if(ApplicationMethods.noNullValues(fields)){
    	try{
    	Placement p = new Placement();
    	p.setModuleNumber(moduleNumber.getText());
    	p.setEndDate(endDate.getValue().toString());
    	p.setStartDate(startDate.getValue().toString());
    	p.setModule(module.getText());
    	p.setPreference(preference.getText());
    	p.setCohort(group.getText());
    	p.setLocation(hospital.getText());
    	p.setYear(year.getValue());
    	
    	PlacementSQL.UploadSinglePlacement(p);
     	GeneralMethods.show("Placement uploaded successfully", "Upload success");
        
    	} catch (Exception e) {
    		e.printStackTrace();
    		GeneralMethods.show("Error in uploading placement", "ERROR");
    	}
		}
    }
/**
 * The initialize method will populate the comboboxes and image on the screen
 */
    @FXML
    void initialize() {
    	ApplicationMethods.Years(year);
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
