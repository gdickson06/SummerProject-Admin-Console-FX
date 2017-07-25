package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.ConvertGroup;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.sql.SearchQueries;

public class AbsenceAmendDeleteController {
	
	protected static Absence a;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<Absence> ListAbsence;

    @FXML
    private ComboBox<String> Type;

    @FXML
    private Button ApprovedSearch;

    @FXML
    private TextField StudentNumber;

    @FXML
    private Button StudentNumberSearch;
    
    @FXML
    private Button Back;

    @FXML
    private ComboBox<String> Approved;

    @FXML
    private TextField StartTime;
    
    @FXML
    private TextField EndTime;

    @FXML
    private Button StartTimeSearch;
    
    @FXML
    private Button EndTimeSearch;

    @FXML
    private Button ComboSearch;

    @FXML
    private Button DateSearch;

    @FXML
    private Button TypeSearch;

    @FXML
    private DatePicker Date;

    @FXML
    void StudentNumberSearch(ActionEvent event) {
    	List<Absence> searched = SearchQueries.searchAbsence(1, StudentNumber.getText());
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
    }

    @FXML
    void DateSearch(ActionEvent event) {
    	List<Absence> searched = SearchQueries.searchAbsence(2, Date.getValue().toString());
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
    }

    @FXML
    void StartTimeSearch(ActionEvent event) {
    	
    	
    	List<Absence> searched = SearchQueries.searchAbsence(3, ConvertGroup.TimeConvertSQL(StartTime.getText()));
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
    }
    
    @FXML
    void EndTimeSearch(ActionEvent event) {
    	
    	List<Absence> searched = SearchQueries.searchAbsence(6, ConvertGroup.TimeConvertSQL(StartTime.getText()));
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
    }

    @FXML
    void TypeSearch(ActionEvent event) {
    	List<Absence> searched = SearchQueries.searchAbsence(4, Type.getValue());
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
    }

    @FXML
    void ApprovedSearch(ActionEvent event) {
    	String bool="true";
    	if(Approved.getValue().equals("Approved")){
    		bool="true";
    	}
    	List<Absence> searched = SearchQueries.searchAbsence(5, bool);
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
    }

    @FXML
    void TableClick(MouseEvent event)throws Exception {
    	if(event.getClickCount()==2){
      		 a=ListAbsence.getSelectionModel().getSelectedItem();
      		 System.out.println("clicked on " + a);
      		 GeneralMethods.ChangeScene("SelectedAbsence");
       	}
    }

    @FXML
    void ComboSearch(ActionEvent event) {
    	int i=0;
    	Boolean approved = null;
    	
    	if(Approved.getValue()!=null){
    	if(Approved.getValue().equals("Approved")){
    		approved=true;
    	} else if (Approved.getValue().equals("Not Approved")){
    		approved=false;
    	}
    	}
    	if(StudentNumber.getText().isEmpty()==false){
    		
    
    		i=Integer.parseInt(StudentNumber.getText());
    	}
    	Absence a = new Absence(i,0, Date.getValue().toString(), StartTime.getText(), EndTime.getText(), "", Type.getValue(),approved);
    	Boolean b = false;
    	System.out.println("Value is "+Approved.getValue());
    	if(Approved.getValue()==null){
    		b=true;
    	}
    	List<Absence> searched = SearchQueries.ComboSearchAbsence(a,b);
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
	
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
    	List<String>types= new ArrayList<String>();
    	
    	types.add("Illness");
    	types.add("Non Illness Related Absence");
    	types.add("Missing from class");
    	
    	
    	Type.getItems().addAll(types);
    	
List<String>approved= new ArrayList<String>();
    	
    	approved.add("Not Approved");
    	approved.add("Approved");
    	
    	
    	Approved.getItems().addAll(approved);
    	
    	   assert ListAbsence != null : "fx:id=\"ListAbsence\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert ApprovedSearch != null : "fx:id=\"ApprovedSearch\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert StudentNumber != null : "fx:id=\"StudentNumber\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert StudentNumberSearch != null : "fx:id=\"StudentNumberSearch\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert StartTime != null : "fx:id=\"StartTime\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert Approved != null : "fx:id=\"Approved\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert ComboSearch != null : "fx:id=\"ComboSearch\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert TypeSearch != null : "fx:id=\"TypeSearch\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert EndTimeSearch != null : "fx:id=\"EndTimeSearch\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert Date != null : "fx:id=\"Date\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert Type != null : "fx:id=\"Type\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert StartTimeSearch != null : "fx:id=\"StartTimeSearch\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";
           assert DateSearch != null : "fx:id=\"DateSearch\" was not injected: check your FXML file 'AbsenceAmendDelete.fxml'.";

    }
}
