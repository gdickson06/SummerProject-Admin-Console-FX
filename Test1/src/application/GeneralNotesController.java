package application;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.objects.Note;
import uk.ac.qub.sql.NoteSQL;
import uk.ac.qub.sql.SearchQueries;

public class GeneralNotesController {
	
private Note n;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> NNYear;

    @FXML
    private TextArea Details;

    @FXML
    private ComboBox<String> Year;

    @FXML
    private TextArea NNDetails;

    @FXML
    private DatePicker NNDate;

    @FXML
    private DatePicker Date;

    @FXML
    private ListView<Note> Notes;

    @FXML
    void SelectNote(MouseEvent event) {
    	if(event.getClickCount()==2){
    		String year;
     		 n=Notes.getSelectionModel().getSelectedItem();
     		Date.setValue(LocalDate.parse(n.getDate(),ApplicationMethods.dtf));
     		switch(n.getYear()){
     		case 1:
     			year = "First Year";
     			break;
     		case 2:
     			year = "Second Year";
     			break;
     		case 3:
     			year = "Third Year";
     			break;
     		case 4:
     			year = "Fourth Year";
     			break;
     		case 5:
     			year = "Fifth Year";
     			break;
     		default:
     			year="All";
     		}
     		
     		Year.setValue(year);
     		Details.setText(n.getDetails());
      	}
    }

    @FXML
    void NewNote(ActionEvent event) {
    	List<String> att = new ArrayList<String>();
    	String year;
    	att.add(NNDate.getValue().toString());
    	switch(NNYear.getValue()){
 		case "First Year":
 			year = "1";
 			break;
 		case "Second Year":
 			year = "2";
 			break;
 		case "Third Year":
 			year = "3";
 			break;
 		case "Fourth Year":
 			year = "4";
 			break;
 		case "Fifth Year":
 			year = "5";
 			break;
 		default:
 			year="All";
 		}
    	att.add(year);
    	
    	att.add(NNDetails.getText());
    	
    	try {
			NoteSQL.UploadNote(att);
			try{
		    	List<Note> live = NoteSQL.ActiveNotes();
				ObservableList<Note> list = FXCollections.observableArrayList();
				list.addAll(live);
				Notes.setItems(list);
		    	} catch (NullPointerException e){
		    		
		    	}
			GeneralMethods.show("Success", "Success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			GeneralMethods.show(e.getMessage(), "Error");
			e.printStackTrace();
		}
    	
    }

    @FXML
    void AmendNote(ActionEvent event) {
    	List<String> att = new ArrayList<String>();
    	att.add(String.valueOf(n.getId()));
    	att.add(Date.getValue().toString());
    	String year;
    	switch(Year.getValue()){
 		case "First Year":
 			year = "1";
 			break;
 		case "Second Year":
 			year = "2";
 			break;
 		case "Third Year":
 			year = "3";
 			break;
 		case "Fourth Year":
 			year = "4";
 			break;
 		case "Fifth Year":
 			year = "5";
 			break;
 		default:
 			year="All";
 		}
    	att.add(year);
    	
    	
    	att.add(Details.getText());
    	
    	try {
			NoteSQL.amendNote(att);
			GeneralMethods.show("Success", "Success");
			try{
		    	List<Note> live = NoteSQL.ActiveNotes();
				ObservableList<Note> list = FXCollections.observableArrayList();
				list.addAll(live);
				Notes.setItems(list);
		    	} catch (NullPointerException e){
		    		
		    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			GeneralMethods.show(e.getMessage(), "Error");
			e.printStackTrace();
		}
    }

    @FXML
    void DeleteNote(ActionEvent event) throws ClassNotFoundException, SQLException {
    	NoteSQL.deleteNote(String.valueOf(n.getId()));
    	try{
        	List<Note> live = NoteSQL.ActiveNotes();
    		ObservableList<Note> list = FXCollections.observableArrayList();
    		list.addAll(live);
    		Notes.setItems(list);
        	} catch (NullPointerException e){
        		
        	}
    }

    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    

    @FXML
    void initialize() {
    	
    	List<String> s = new ArrayList<String>();
    	
    	s.add("First Year");
    	s.add("Second Year");
    	s.add("Third Year");
    	s.add("Fourth Year");
    	s.add("Fifth Year");
    	
    	NNYear.getItems().addAll(s);
    	Year.getItems().addAll(s);
    	try{
    	List<Note> live = NoteSQL.ActiveNotes();
		ObservableList<Note> list = FXCollections.observableArrayList();
		list.addAll(live);
		Notes.setItems(list);
    	} catch (NullPointerException e){
    		System.out.println("be fine");
    	}
        assert NNYear != null : "fx:id=\"NNYear\" was not injected: check your FXML file 'GeneralNotes.fxml'.";
        assert Details != null : "fx:id=\"Details\" was not injected: check your FXML file 'GeneralNotes.fxml'.";
        assert Year != null : "fx:id=\"Year\" was not injected: check your FXML file 'GeneralNotes.fxml'.";
        assert NNDetails != null : "fx:id=\"NNDetails\" was not injected: check your FXML file 'GeneralNotes.fxml'.";
        assert NNDate != null : "fx:id=\"NNDate\" was not injected: check your FXML file 'GeneralNotes.fxml'.";
        assert Date != null : "fx:id=\"Date\" was not injected: check your FXML file 'GeneralNotes.fxml'.";
        assert Notes != null : "fx:id=\"Notes\" was not injected: check your FXML file 'GeneralNotes.fxml'.";

    }
}
