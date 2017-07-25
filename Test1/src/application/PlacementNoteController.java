package application;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;
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
    private Button TeacherSearch;

    @FXML
    private TextField CohortText;

    @FXML
    private TextArea NoteText;

    @FXML
    private Button Upload;

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
    private TextField YearText;

    @FXML
    private ListView<Placement> Placements;

    @FXML
    private Button Back;

    @FXML
    private TextField TeacherText;

    @FXML
    private Button YearSearch;

    @FXML
    private Button DateSearch;

    @FXML
    private Label SelectedPlacement;

    @FXML
    private Button CohortSearch;

    @FXML
    void DateSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(1, StartDateText.getText());
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }

    @FXML
    void YearSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(3, YearText.getText());
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
    void CohortSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(6, CohortText.getText());
		ObservableList<Placement> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Placements.setItems(list);
    }

    @FXML
    void SubjectSearch(ActionEvent event) {
    	List<Placement> searched = SearchQueries.searchPlacement(4, SubjectText.getText());
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
    void PlacementSelect(MouseEvent event) {
    	 p=Placements.getSelectionModel().getSelectedItem();
 		SelectedPlacement.setText(p.toString());
    }

    @FXML
    void upload(ActionEvent event) throws Exception {
    	if(p!=null){
        	PlacementSQL.UploadNote(String.valueOf(p.getId()), NoteText.getText());
        	GeneralMethods.show("Uploaded note for placement "+ p.getId(), "Upload Success");
        	} else {
        		GeneralMethods.show("No placement selected", "Error");
        	}
    }

    @FXML
    void Back(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("mainMenu");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void initialize() {
        assert TeacherSearch != null : "fx:id=\"TeacherSearch\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert CohortText != null : "fx:id=\"CohortText\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert NoteText != null : "fx:id=\"NoteText\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert Upload != null : "fx:id=\"Upload\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert SubjectText != null : "fx:id=\"SubjectText\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert StartDateText != null : "fx:id=\"StartDateText\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert LocationText != null : "fx:id=\"LocationText\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert SubjectSearch != null : "fx:id=\"SubjectSearch\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert LocationSearch != null : "fx:id=\"LocationSearch\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert YearText != null : "fx:id=\"YearText\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert Placements != null : "fx:id=\"Placements\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert TeacherText != null : "fx:id=\"TeacherText\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert YearSearch != null : "fx:id=\"YearSearch\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert DateSearch != null : "fx:id=\"DateSearch\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert SelectedPlacement != null : "fx:id=\"SelectedPlacement\" was not injected: check your FXML file 'PlacementNote.fxml'.";
        assert CohortSearch != null : "fx:id=\"CohortSearch\" was not injected: check your FXML file 'PlacementNote.fxml'.";

    }
}
