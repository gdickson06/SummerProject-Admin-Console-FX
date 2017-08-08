package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
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
    private DatePicker Date;

    @FXML
    private JFXButton ReturnPracticalMenu;

    @FXML
    private JFXTextField WeekText;

    @FXML
    private JFXTextField LocationText;

    @FXML
    private JFXComboBox<String> Cohort;

    @FXML
    private JFXListView<Placement> Placements;

    @FXML
    private JFXTextField TeacherText;

    @FXML
    private JFXButton ComboSearch;

    @FXML
    private JFXButton ReturnMainMenu;

    @FXML
    private JFXTextField SubjectText;

    @FXML
    private ImageView Image;

    @FXML
    void StartDateSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(1, Date.getValue().toString());
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }

    @FXML
    void SubjectSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(3, WeekText.getText());
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }

    @FXML
    void LocationSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(5, LocationText.getText());
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }

    @FXML
    void TeacherSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(2, TeacherText.getText());
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }

    @FXML
    void CohortSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(6, Cohort.getValue());
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }

    @FXML
    void WeekSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(3, WeekText.getText());
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }

    @FXML
    void ReturnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void ReturnPracticalMenu(ActionEvent event) throws Exception {
     	GeneralMethods.ChangeScene("PracticalMenuController", "PracticalPlacementMenu");
        
    }
    
    @FXML
    void PlacementClick(MouseEvent event) throws Exception {
    	if(event.getClickCount()==2){
     		 selectedPlacement=Placements.getSelectionModel().getSelectedItem();
     		 System.out.println("clicked on " + selectedPlacement);
     		 GeneralMethods.ChangeScene("AmendSinglePractical","AmendSinglePractical");
      	}
    }

    @FXML
    void ComboSearch(ActionEvent event) {
    	Placement p = new Placement(SubjectText.getText(),TeacherText.getText(),LocationText.getText());
    	if(!WeekText.getText().isEmpty()){p.setWeek(Integer.parseInt(WeekText.getText()));}
    	if(Cohort.getValue()!=null){p.setCohort(Cohort.getValue());}
    	if(Date.getValue()!=null){p.setStartDate(Date.getValue().toString());}
    	List<Placement> searched = SearchQueries.ComboSearchPlacement(p);
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }

    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
      Cohort.getItems().setAll(ApplicationMethods.Cohorts);
    }
}
