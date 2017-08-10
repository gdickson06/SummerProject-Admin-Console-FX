package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
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
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Note;
import uk.ac.qub.sql.NoteSQL;

public class GeneralNotesController {
	
	private Note n;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextArea NoteDetails;

    @FXML
    private JFXListView<Note> NoteList;

    @FXML
    private JFXComboBox<String> Year;

    @FXML
    private DatePicker NewNoteDate;

    @FXML
    private JFXTextArea NewNoteDetails;

    @FXML
    private ImageView Image;

    @FXML
    private JFXComboBox<String> NewNoteYear;

    @FXML
    private DatePicker Date;

  

    @FXML
    void Clear(ActionEvent event) throws ClassNotFoundException, SQLException {
    	NoteSQL.deleteNote(String.valueOf(n.getId()));
    	try{
        	List<Note> live = NoteSQL.ActiveNotes();
    		ObservableList<Note> list = FXCollections.observableArrayList();
    		list.addAll(live);
    		NoteList.setItems(list);
        	} catch (NullPointerException e){
        		
        	}
    }

    @FXML
    void Upload(ActionEvent event) {
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
    	
    	
    	att.add(NoteDetails.getText());
    	
    	try {
			NoteSQL.amendNote(att);
			GeneralMethods.show("Success", "Success");
			try{
		    	List<Note> live = NoteSQL.ActiveNotes();
				ObservableList<Note> list = FXCollections.observableArrayList();
				list.addAll(live);
				NoteList.setItems(list);
		    	} catch (NullPointerException e){
		    		
		    	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			GeneralMethods.show(e.getMessage(), "Error");
			e.printStackTrace();
		}
    }

    @FXML
    void ReturnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }

    @FXML
    void SelectNote(MouseEvent event) {
    	if(event.getClickCount()==2){
    		String year;
     		 n=NoteList.getSelectionModel().getSelectedItem();
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
     		NoteDetails.setText(n.getDetails());
      	}
    }

    @FXML
    void SaveNewNote(ActionEvent event) {
    	List<String> att = new ArrayList<String>();
    	String year;
    	att.add(NewNoteDate.getValue().toString());
    	switch(NewNoteYear.getValue()){
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
    	
    	att.add(NewNoteDetails.getText());
    	
    	try {
			NoteSQL.UploadNote(att);
			try{
		    	List<Note> live = NoteSQL.ActiveNotes();
				ObservableList<Note> list = FXCollections.observableArrayList();
				list.addAll(live);
				NoteList.setItems(list);
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
    void ReturnNotesMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("NotesMenuController", "NotesMenuController");
    }

    @FXML
    void initialize() {
List<String> s = new ArrayList<String>();
    	
    	s.add("First Year");
    	s.add("Second Year");
    	s.add("Third Year");
    	s.add("Fourth Year");
    	s.add("Fifth Year");
    	
    	NewNoteYear.getItems().addAll(s);
    	Year.getItems().addAll(s);
    	try{
    	List<Note> live = NoteSQL.ActiveNotes();
		ObservableList<Note> list = FXCollections.observableArrayList();
		list.addAll(live);
		NoteList.setItems(list);
    	} catch (NullPointerException e){
    		System.out.println("be fine");
    	}
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
