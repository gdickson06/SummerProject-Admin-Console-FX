package application;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.SQLException;
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
import uk.ac.qub.methods.ConvertMethods;
import uk.ac.qub.methods.GeneralMethods;
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
/**
 * This method will allow absences to be searched by type
 * @param event
 */
    @FXML
    void TypeSearch(ActionEvent event) {
    	List<Absence> searched = new ArrayList<Absence>();
     	try {
			searched.addAll(SearchQueries.searchAbsence(4, Type.getValue().toString()));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching absences", "Error");
			e.printStackTrace();
		}
    		ObservableList<Absence> list = FXCollections.observableArrayList();
    		list.addAll(searched);
    		ListAbsence.setItems(list);
    }
 /**
  * This method will allow absences to be searched by whether they are approved or not 
  * @param event
  */
    @FXML
    void ApprovedSearch(ActionEvent event) {
    	String bool="true";
    	if(Approved.getValue().equals("Approved")){
    		bool="true";
    	}
    	List<Absence> searched = new ArrayList<Absence>();
    	
    	try {
			searched.addAll(SearchQueries.searchAbsence(5, bool));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching absences", "Error");
			e.printStackTrace();
		}
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
    }
/**
 * This allows absences to be searched by end time
 * @param event
 */
    @FXML
    void SearchEndTime(ActionEvent event) {
    	List<Absence> searched = new ArrayList<Absence>();
     	try {
			searched.addAll(SearchQueries.searchAbsence(6, ConvertMethods.TimeConvertSQL(EndTime.getText())));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching absences", "Error");
			e.printStackTrace();
		}
    		ObservableList<Absence> list = FXCollections.observableArrayList();
    		list.addAll(searched);
    		ListAbsence.setItems(list);
    }
/**
 * This allows absences to be searched by start time
 * @param event
 */
    @FXML
    void SearchTime(ActionEvent event) {
    	List<Absence> searched = new ArrayList<Absence>();
     	try {
			searched.addAll(SearchQueries.searchAbsence(6, ConvertMethods.TimeConvertSQL(StartTime.getText())));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching absences", "Error");
			e.printStackTrace();
		}
    		ObservableList<Absence> list = FXCollections.observableArrayList();
    		list.addAll(searched);
    		ListAbsence.setItems(list);
    }
/**
 * This allows absences to be searched by the start date of the absence
 * @param event
 */
    @FXML
    void SearchDate(ActionEvent event) {
    	List<Absence> searched = new ArrayList<Absence>();
     	try {
			searched.addAll(SearchQueries.searchAbsence(2, StartDate.getValue().toString()));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching absences", "Error");
			e.printStackTrace();
		}
    		ObservableList<Absence> list = FXCollections.observableArrayList();
    		list.addAll(searched);
    		ListAbsence.setItems(list);
    }
/**
 * This allows absences to be searched by student number
 * @param event
 */
    @FXML
    void SearchStudentNumber(ActionEvent event) {
    	List<Absence> searched = new ArrayList<Absence>();
     	try {
			searched.addAll(SearchQueries.searchAbsence(1, StudentNumber.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching absences", "Error");
			e.printStackTrace();
		}
    		ObservableList<Absence> list = FXCollections.observableArrayList();
    		list.addAll(searched);
    		ListAbsence.setItems(list);
    }
/**
 * This allows the user to click on an absence and be taken to the amend and delete page
 * with the selected absence
 * @param event
 * @throws Exception
 */
    @FXML
    void listClick(MouseEvent event) throws Exception {
    	if(event.getClickCount()==2){
     		 a=ListAbsence.getSelectionModel().getSelectedItem();
     		 System.out.println("clicked on " + a);
     		 GeneralMethods.ChangeScene("AmendSingleAbsence","AmendSingleAbsence");
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
 * This method will return the user to the absence menu
 * @param event
 * @throws Exception
 */
    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AbsenceMenu","AbsenceMenu");
    }
/**
 * This method will search the absence on multiple fields
 * @param event
 */
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
    	
    	
    
    	List<Absence> searched = new ArrayList<Absence>();
		try {
			searched.addAll(SearchQueries.ComboSearchAbsence(a));
		} catch (SQLException e) {
			GeneralMethods.show("Error when searching absences", "Error");
			e.printStackTrace();
		}
		ObservableList<Absence> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListAbsence.setItems(list);
    }
/**
 * This intialize method will populate the iamges and combo boxes on the page
 */
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
