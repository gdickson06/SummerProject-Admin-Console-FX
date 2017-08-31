package application;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.sql.PlacementSQL;

public class SelectedPlacementController {
	
	private Placement p = PlacementAmendDeleteController.selectedPlacement;

	   @FXML
	    private JFXTextField moduleNumber;

	    @FXML
	    private JFXTextArea comments;

	    @FXML
	    private DatePicker endDate;

	    @FXML
	    private JFXComboBox<Integer> year;

	    @FXML
	    private JFXTextField module;

	    @FXML
	    private JFXTextField preference;

	    @FXML
	    private Label ID;

	    @FXML
	    private ImageView Image;

	    @FXML
	    private JFXTextField hospital;

	    @FXML
	    private DatePicker startDate;

	    @FXML
	    private JFXTextField group;
	    
	    @FXML
	    private JFXComboBox<String> prefix;
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
    }
/**
 * This method will delete the selected Placement
 * @param event
 * @throws Exception
 */
    @FXML
    void Delete(ActionEvent event) throws Exception {
    	PlacementSQL.DeletePlacement(String.valueOf(p.getId()));
    	GeneralMethods.show("Deleted", "Deleted");
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
    }
/**
 * This method will save any changes to the placement
 * @param event
 */
    @FXML
    void Save(ActionEvent event) {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(group);
		fields.add(year);
		fields.add(startDate);
		fields.add(endDate);
		if(ApplicationMethods.noNullValues(fields)){
    	p.setCohort(group.getText());
    	p.setEndDate(endDate.getValue().toString());
    	p.setLocation(hospital.getText());
    	p.setModule(module.getText());
    	p.setModuleNumber(moduleNumber.getText());
    	p.setNote(comments.getText());
    	p.setPreference(preference.getText());
    	p.setStartDate(startDate.getValue().toString());
    	p.setYear(year.getValue());
    	
    	try {
			PlacementSQL.amendPlacement(p);
			GeneralMethods.show("Success in amending placement, placement "+p.getId()+" is amended", "Success");
		} catch (Exception e) {
			
			GeneralMethods.show("Error in amending Placement","Error");
			e.printStackTrace();
		}
		}
    }
    /**
     * This method will take the user back to the search menu for placements
     * @param event
     * @throws Exception
     */
    @FXML
    void Back(ActionEvent event) throws Exception {
     	GeneralMethods.ChangeScene("AmendDeletePracticalMenu", "AmendDeletePracticalMenu");
         }
    /**
     * This method will take the user back to the placement menu
     * @param event
     * @throws Exception
     */
    @FXML
    void returnPlacementScreen(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("PracticalMenuController", "PracticalPlacementMenu");
    	  
    }
/**
 * The initialize method will populate all of the field with the pre existing data of the
 * selected placement along with populating the image
 */
    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	startDate.setValue(LocalDate.parse(p.getStartDate()));
    	ID.setText(String.valueOf(p.getId()));
    	endDate.setValue(LocalDate.parse(p.getEndDate()));
    	hospital.setText(p.getLocation());
    	group.setText(p.getCohort());
    	comments.setText(p.getNote());
    	moduleNumber.setText(p.getModuleNumber());
    	year.setValue(p.getYear());
    	preference.setText(p.getPreference());
    	module.setText(p.getModule());
    	ApplicationMethods.Years(year);
    }
}
