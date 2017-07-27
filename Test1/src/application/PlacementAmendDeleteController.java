package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.sql.SearchQueries;

public class PlacementAmendDeleteController {
	
	protected static Placement selectedPlacement;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField WeekText;

    @FXML
    private Button TeacherSearch;

    @FXML
    private TextField CohortText;

    @FXML
    private Button StartDateSearch;

    @FXML
    private Button ComboSearch;

    @FXML
    private TextField SubjectText;

    @FXML
    private TextField StartDateText;

    @FXML
    private TextField LocationText;

    @FXML
    private Button SubjectSearch;

    @FXML
    private Button LocationSearch;

    @FXML
    private Button Back;

    @FXML
    private ListView<Placement> Placements;

    @FXML
    private TextField TeacherText;

    @FXML
    private Button WeekSearch;

    @FXML
    private Button CohortSearch;

    @FXML
    void WeekSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(3, WeekText.getText());
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }

    @FXML
    void CohortSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(6, CohortText.getText());
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
    void SubjectSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(3, WeekText.getText());
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }

    @FXML
    void StartDateSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(1, StartDateText.getText());
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
    void ComboSearch(ActionEvent event) {
    	Placement p = new Placement(Integer.parseInt(WeekText.getText()),StartDateText.getText(),CohortText.getText(),SubjectText.getText(),TeacherText.getText(),LocationText.getText());
    	List<Placement> searched = SearchQueries.ComboSearchPlacement(p);
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    
    }

    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void PlacementClick(MouseEvent event) throws Exception {
    	if(event.getClickCount()==2){
     		 selectedPlacement=Placements.getSelectionModel().getSelectedItem();
     		 System.out.println("clicked on " + selectedPlacement);
     		 GeneralMethods.ChangeScene("SelectedPlacement");
      	}
    }

    @FXML
    void initialize() {
        assert WeekText != null : "fx:id=\"WeekText\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert TeacherSearch != null : "fx:id=\"TeacherSearch\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert CohortText != null : "fx:id=\"CohortText\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert StartDateSearch != null : "fx:id=\"StartDateSearch\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert ComboSearch != null : "fx:id=\"ComboSearch\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert SubjectText != null : "fx:id=\"SubjectText\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert StartDateText != null : "fx:id=\"StartDateText\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert LocationText != null : "fx:id=\"LocationText\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert SubjectSearch != null : "fx:id=\"SubjectSearch\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert LocationSearch != null : "fx:id=\"LocationSearch\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert Placements != null : "fx:id=\"Placements\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert TeacherText != null : "fx:id=\"TeacherText\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert WeekSearch != null : "fx:id=\"WeekSearch\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";
        assert CohortSearch != null : "fx:id=\"CohortSearch\" was not injected: check your FXML file 'PlacementAmendDelete.fxml'.";

    }
}
