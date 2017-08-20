package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.sql.SearchQueries;

public class PlacementAmendDeleteController {
	
	protected static Placement selectedPlacement;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private JFXComboBox<Integer> Year;

    @FXML
    private DatePicker endDate;

    @FXML
    private JFXTextField module;

    @FXML
    private JFXListView<Placement> Placements;

    @FXML
    private JFXTextField hospital;

    @FXML
    private ImageView Image;

    @FXML
    private DatePicker startDate;

    @FXML
    private JFXTextField group;
/**
 * This method will take the value of the start date field and fill the Placement List
 * with any placement which occurs on the given date
 * @param event
 */

    @FXML
    void startDateSearch(ActionEvent event) {
    	List<Placement> searched = new ArrayList<Placement>();
		try {
			searched.addAll(SearchQueries.searchPlacement(1, startDate.getValue().toString()));
		} catch (SQLException e) {
			GeneralMethods.show("Error while searching Placements", "Error");
		}
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }
/**
 * This method will take the value of the module field and fill the placement list with any placement which
 * is under that module
 * @param event
 */
    @FXML
    void moduleSearch(ActionEvent event) {
    	List<Placement> searched = new ArrayList<Placement>();
		try {
			searched.addAll(SearchQueries.searchPlacement(4, module.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error while searching Placements", "Error");
			e.printStackTrace();
		}
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }
/**
 * This method will take the value of the hospital field and fill the placement list with any placement
 * which take places in that hospital
 * @param event
 */
    @FXML
    void hospitalSearch(ActionEvent event) {
    	List<Placement> searched = new ArrayList<Placement>();
    	try {
			searched.addAll(SearchQueries.searchPlacement(5, hospital.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error while searching Placements", "Error");
			e.printStackTrace();
		}
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }
/**
 * This method will take the value of the end date field and fill the placement list with any placement
 * which ends on the given date.
 * @param event
 */
    @FXML
    void endDateSearch(ActionEvent event) {
    	List<Placement> searched = new ArrayList<Placement>();
    	try {
			searched.addAll(SearchQueries.searchPlacement(3, endDate.getValue().toString()));
		} catch (SQLException e) {
			GeneralMethods.show("Error while searching Placements", "Error");
			e.printStackTrace();
		}
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }
/**
 * This method will take the value of the group field and fill the placement list with any placement 
 * which has the specified group in the list
 * @param event
 */
    @FXML
    void groupSearch(ActionEvent event) {
    	List<Placement> searched = new ArrayList<Placement>();
    	
    	try {
			searched.addAll(SearchQueries.searchPlacement(6, group.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error while searching Placements", "Error");
			e.printStackTrace();
		}
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }
/**
 * This will search via the year
 * @param event
 */
    @FXML
    void yearSearch(ActionEvent event) {
    	List<Placement> searched = new ArrayList<Placement>();
    	try {
			searched.addAll(SearchQueries.searchPlacement(2, Year.getValue().toString()));
		} catch (SQLException e) {
			GeneralMethods.show("Error while searching Placements", "Error");
			e.printStackTrace();
		}
    	System.out.println(searched.size());
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }
/**
 * This method will allow the user to return to the main menu
 * @param event
 * @throws Exception
 */
    @FXML
    void ReturnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }
/**
 * This method returns the user to the placement menu
 * @param event
 * @throws Exception
 */
    @FXML
    void ReturnPlacementMenu(ActionEvent event) throws Exception {
     	GeneralMethods.ChangeScene("PracticalMenuController", "PracticalPlacementMenu");
        
    }
 /**
  * This method will select a placement to populate the amend delete fields in the next screen   
  * @param event
  * @throws Exception
  */
    @FXML
    void PlacementClick(MouseEvent event) throws Exception {
    	if(event.getClickCount()==2){
     		 selectedPlacement=Placements.getSelectionModel().getSelectedItem();
     		 System.out.println("clicked on " + selectedPlacement);
     		 GeneralMethods.ChangeScene("AmendSinglePractical","AmendSinglePractical");
      	}
    }
/**
 * This method will search through all of the areas where data has been inputted.
 * @param event
 */
    @FXML
    void ComboSearch(ActionEvent event) {
    	List<Placement> searched = new ArrayList<Placement>();
    	Placement p = new Placement();
    	if(Year.getValue()!=null){p.setYear(Year.getValue());}
    	if(endDate.getValue()!=null){p.setEndDate(endDate.getValue().toString());}
    	if(startDate.getValue()!=null){p.setStartDate(startDate.getValue().toString());}
    	p.setCohort(group.getText());
    	p.setModule(module.getText());
    	p.setLocation(hospital.getText());
    	try {
			searched.addAll(SearchQueries.ComboSearchPlacement(p));
		} catch (SQLException e) {
			GeneralMethods.show("Error while searching Placements", "Error");
			e.printStackTrace();
		}
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }
/**
 * This will initialize the methods and fill in the image in the top right along with populate 
 * the year combo box
 */
    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	ApplicationMethods.Years(Year);
    }
}
