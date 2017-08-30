package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.sql.PlacementSQL;
import uk.ac.qub.sql.SearchQueries;

public class PlacementNoteController {
	
	private Placement p;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField Cohort;

    @FXML
    private JFXTextArea Note;

    @FXML
    private ImageView Image;

    @FXML
    private JFXListView<Placement> TablePlacement;

    @FXML
    private JFXTextField Subject;

    @FXML
    private DatePicker startDate;

    @FXML
    private JFXTextField Location;
    

    @FXML
    private DatePicker endDate;
    
    @FXML
    private Label SelectedPlacement;
    @FXML
    private JFXComboBox<Integer> year;
 /**
  * This method allows a combo search on all fields input to find a specific placement
  * @param event
  */
    @FXML
    void search(ActionEvent event) {
    	Placement p1 = new Placement();
    	if(startDate.getValue()!=null){p1.setStartDate(startDate.getValue().toString());}
    	p1.setCohort(Cohort.getText());
    	if(year.getValue()!=null){p1.setYear(year.getValue());}
    	p1.setLocation(Location.getText());
    	p1.setModule(Subject.getText());
    	if(endDate.getValue()!=null){p1.setEndDate(endDate.getValue().toString());}
    	List<Placement> searched = new ArrayList<Placement>();
    	try {
    		searched.addAll(SearchQueries.ComboSearchPlacement(p1));
    	} catch (SQLException e) {
    		GeneralMethods.show("Error in searching Lectures", "Error");
    		e.printStackTrace();
    	}
    			ObservableList<Placement> list = FXCollections.observableArrayList();
    			list.addAll(searched);
    			TablePlacement.setItems(list);
    	
    }
/**
 * This method will allow a placement to be selected to upload a note to the database
 * 
 * @param event
 */
    @FXML
    void PlacementSelect(MouseEvent event) {
    	 p=TablePlacement.getSelectionModel().getSelectedItem();
 		SelectedPlacement.setText(p.toString());
 		Note.setText(p.getNote());
    }
/**
 * This method allows a note to the uploaded to the selected placement
 * if no placement is selected an error message will inform the user
 * @param event
 * @throws Exception
 */
    @FXML
    void upload(ActionEvent event) {
    	if(p!=null){
        	try {
				PlacementSQL.UploadNote(String.valueOf(p.getId()), Note.getText());
				GeneralMethods.show("Uploaded note for placement "+ p.getId(), "Upload Success");
	        	
        	} catch (Exception e) {
				GeneralMethods.show("Error in uploading note to placement", "Error");
				e.printStackTrace();
			}
        	} else {
        		GeneralMethods.show("No placement selected", "Error");
        	}
    }
/**
 * This method will allow the user to return to the main menu
 * @param event
 * @throws Exception 
 */
    @FXML
    void returnToMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu", "MainMenu");
    }
/**
 * This method will allow the user to return to the notes menu
 * @param event
 * @throws Exception
 */
    @FXML
    void returnToNoteMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("NotesMenu", "NotesMenu");
    }
/**
 * This intialize method will populate the combo-box and image on the page
 */
    @FXML
    void initialize() {
    	ApplicationMethods.Years(year);
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
