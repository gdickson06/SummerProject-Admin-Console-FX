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
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Note;
import uk.ac.qub.sql.NoteSQL;
/** 
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This is the controller class for the General notes class, this will be used
 * to upload a new note for a year, to amend and delete any upcoming notes, there will be
 * a list of the current notes updated from the database.
 * Demographics – 234 LOC 7 Methods 
 * 
 */
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
	private JFXComboBox<Integer> Year;

	@FXML
	private DatePicker NewNoteDate;

	@FXML
	private JFXTextArea NewNoteDetails;

	@FXML
	private ImageView Image;

	@FXML
	private JFXComboBox<Integer> NewNoteYear;

	@FXML
	private DatePicker Date;

	/**
	 * This method will delete the selected note, if no note is selected an
	 * error message will pop up, once the note is deleted the active notes will
	 * be updated
	 * 
	 * @param event
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	@FXML
	void Delete(ActionEvent event) {
		if (n != null) {
			try {
				NoteSQL.deleteNote(String.valueOf(n.getId()));
			} catch (Exception e) {
				GeneralMethods.show("Error when deleting notes", "Error");
				e.printStackTrace();
			}

			List<Note> live = new ArrayList<Note>();
			;
			try {
				live.addAll(NoteSQL.ActiveNotes());
			} catch (SQLException e) {
				GeneralMethods.show("Error when getting live notes", "Error");
				e.printStackTrace();
			}
			ObservableList<Note> list = FXCollections.observableArrayList();
			list.addAll(live);
			NoteList.setItems(list);
			Year.setValue(0);
			NoteDetails.setText("");
			Date.setValue(LocalDate.now());
			n=null;
			GeneralMethods.show("Note deleted", "Success");

		} else {
			GeneralMethods.show("No note selected", "Warning");
		}
	}

	/**
	 * This method will amend an already existing note
	 * 
	 * @param event
	 */
	@FXML
	void Amend(ActionEvent event) {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(Date);
		fields.add(NoteDetails);
		fields.add(Year);
		
		if(ApplicationMethods.noNullValues(fields)){
		n.setDate(Date.getValue().toString());
		n.setDetails(NoteDetails.getText());
		n.setYear(Year.getValue());

		try {
			NoteSQL.amendNote(n);
			GeneralMethods.show("Success", "Success");

			List<Note> live = NoteSQL.ActiveNotes();
			ObservableList<Note> list = FXCollections.observableArrayList();
			list.addAll(live);
			NoteList.setItems(list);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			GeneralMethods.show("Error in amending note", "Error");
			e.printStackTrace();
		}
	}}

	/**
	 * This method will return the user to the main menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void ReturnMainMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("MainMenu", "MainMenu");
	}

	/**
	 * This will allow the user to select a live note
	 * 
	 * @param event
	 */
	@FXML
	void SelectNote(MouseEvent event) {
		if (event.getClickCount() == 2) {

			n = NoteList.getSelectionModel().getSelectedItem();
			Date.setValue(LocalDate.parse(n.getDate(), ApplicationMethods.dtf));

			Year.setValue(n.getYear());
			NoteDetails.setText(n.getDetails());
		}
	}

	/**
	 * This method allows the user to save a new note
	 * 
	 * @param event
	 */
	@FXML
	void SaveNewNote(ActionEvent event) {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(NewNoteDate);
		fields.add(NewNoteDetails);
		fields.add(NewNoteYear);
	
		
		if(ApplicationMethods.noNullValues(fields)){
		Note n1 = new Note();
		n1.setDate(NewNoteDate.getValue().toString());
		n1.setYear(NewNoteYear.getValue());
		n1.setDetails(NewNoteDetails.getText());

		try {
			NoteSQL.UploadNote(n1);

			List<Note> live = NoteSQL.ActiveNotes();
			ObservableList<Note> list = FXCollections.observableArrayList();
			list.addAll(live);
			NoteList.setItems(list);

			GeneralMethods.show("Success in uploading new note", "Success");
		} catch (Exception e) {
			GeneralMethods.show("Error in uploading new note", "Error");
			e.printStackTrace();
		}
	}}

	/**
	 * This method will return the user to the Notes menu
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void ReturnNotesMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("NotesMenu", "NotesMenu");
	}

	/**
	 * This method will populate the image and combo boxes along with the list
	 * view with all live notes (live being set after the current date)
	 * 
	 * @throws SQLException
	 */
	@FXML
	void initialize() throws SQLException {
		ApplicationMethods.Years(NewNoteYear);
		ApplicationMethods.Years(Year);

		List<Note> live = NoteSQL.ActiveNotes();
		ObservableList<Note> list = FXCollections.observableArrayList();
		list.addAll(live);
		NoteList.setItems(list);

		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
		Image.setImage(i);
	}
}
