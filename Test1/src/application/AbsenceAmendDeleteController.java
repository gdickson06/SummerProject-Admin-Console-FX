package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.ConvertMethods;
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
    private DatePicker StartDate;

    @FXML
    private JFXComboBox<String> Type;

    @FXML
    private JFXButton ApprovedSearch;

    @FXML
    private JFXTextField EndTime;

    @FXML
    private JFXTextField StudentNumber;

    @FXML
    private JFXButton Back;

    @FXML
    private JFXTextField StartTime;

    @FXML
    private JFXComboBox<String> Approved;

    @FXML
    private JFXListView<Absence> ListAbsence;

    @FXML
    private JFXButton EndTimeSearch;

    @FXML
    private ImageView Image;

    @FXML
    void TypeSearch(ActionEvent event) {
     	List<Absence> searched = SearchQueries.searchAbsence(4, Type.getValue().toString());
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
    void SearchEndTime(ActionEvent event) {
    	List<Absence> searched = SearchQueries.searchAbsence(6, ConvertMethods.TimeConvertSQL(StartTime.getText()));
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
    }

    @FXML
    void SearchTime(ActionEvent event) {
    	List<Absence> searched = SearchQueries.searchAbsence(3, ConvertMethods.TimeConvertSQL(StartTime.getText()));
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
    }

    @FXML
    void SearchDate(ActionEvent event) {
    	List<Absence> searched = SearchQueries.searchAbsence(2, StartDate.getValue().toString());
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
    }

    @FXML
    void SearchStudentNumber(ActionEvent event) {
    	List<Absence> searched = SearchQueries.searchAbsence(1, StudentNumber.getText());
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
    }

    @FXML
    void listClick(MouseEvent event) throws Exception {
    	if(event.getClickCount()==2){
     		 a=ListAbsence.getSelectionModel().getSelectedItem();
     		 System.out.println("clicked on " + a);
     		 GeneralMethods.ChangeScene("SelectedAbsence");
      	}
    }

    @FXML
    void returnMainMenu(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AbsenceMenu","AbsenceMenu");
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
    	Absence a = new Absence();
    	a.setStudentNumber(i);
    	a.setApproved(approved);
    	if(StartDate.getValue()!=null){a.setStartDate(StartDate.getValue().toString());}
    	if(!StartTime.getText().isEmpty()){a.setStartTime(ConvertMethods.TimeConvertSQL(StartTime.getText()));}
    	if(!EndTime.getText().isEmpty()){a.setEndTime(ConvertMethods.TimeConvertSQL(EndTime.getText()));}
    	if(Type.getValue()!=null){a.setType(Type.getValue());}
    	
    	
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
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	ApplicationMethods.AbsenceTypes(Type);
    	
    	List<String>approved= new ArrayList<String>();
    	    	
    	    	approved.add("Not Approved");
    	    	approved.add("Approved");
    	    	
    	    	
    	    	Approved.getItems().addAll(approved);
    }
}
