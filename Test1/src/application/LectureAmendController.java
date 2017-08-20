package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.SearchQueries;

public class LectureAmendController {

	protected static Lecture selectedLecture;

	@FXML
	private ImageView Image;
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private JFXTextField WeekText;

	@FXML
	private JFXListView<Lecture> ListOfLectures;

	@FXML
	private JFXTextField StaffText;

	@FXML
	private DatePicker Date;

	@FXML
	private JFXComboBox<Integer> YearText;

	@FXML
	private JFXTextField StartTimeText;

	@FXML
	private JFXComboBox<String> Module;

	/**
	 * This method will allow the user to search via week of lecture
	 * 
	 * @param event
	 */

	@FXML
	void WeekSearch(ActionEvent event) {
		List<Lecture> searched = new ArrayList<Lecture>();

		try {
			searched.addAll(SearchQueries.searchLecture(2, WeekText.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error with searching Lectures", "Error");
			e.printStackTrace();
		}
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
	}

	/**
	 * This method will search the lecture through the start time
	 * 
	 * @param event
	 */
	@FXML
	void StartTimeSearch(ActionEvent event) {
		List<Lecture> searched = new ArrayList<Lecture>();

		try {
			searched.addAll(SearchQueries.searchLecture(4, StartTimeText.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error with searching Lectures", "Error");
			e.printStackTrace();
		}
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
	}
	/**
	 * This method will search the lecture through the year
	 * 
	 * @param event
	 */
	@FXML
	void YearSearch(ActionEvent event) {
		List<Lecture> searched = new ArrayList<Lecture>();

		try {
			searched.addAll(SearchQueries.searchLecture(7, YearText.getValue().toString()));
		} catch (SQLException e) {
			GeneralMethods.show("Error with searching Lectures", "Error");
			e.printStackTrace();
		}
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
	}
	/**
	 * This method will search the lecture through the staff
	 * 
	 * @param event
	 */
	@FXML
	void StaffSearch(ActionEvent event) {
		List<Lecture> searched = new ArrayList<Lecture>();

		try {
			searched.addAll(SearchQueries.searchLecture(5, StaffText.getText()));
		} catch (SQLException e) {
			GeneralMethods.show("Error with searching Lectures", "Error");
			e.printStackTrace();
		}
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
	}
	/**
	 * This method will search the lecture through the module
	 * 
	 * @param event
	 */
	@FXML
	void ModuleSearch(ActionEvent event) {
		List<Lecture> searched = new ArrayList<Lecture>();

		try {
			searched.addAll(SearchQueries.searchLecture(6, Module.getValue()));
		} catch (SQLException e) {
			GeneralMethods.show("Error with searching Lectures", "Error");
			e.printStackTrace();
		}
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
	}
	/**
	 * This method will search the lecture through the date
	 * 
	 * @param event
	 */
	@FXML
	void DateSearch(ActionEvent event) {
		List<Lecture> searched = new ArrayList<Lecture>();

		try {
			searched.addAll(SearchQueries.searchLecture(3, Date.getValue().toString()));
		} catch (SQLException e) {
			GeneralMethods.show("Error with searching Lectures", "Error");
			e.printStackTrace();
		}
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
	}
	/**
	 * This method will return the user to the lecture menu
	 * @param event
	 * @throws Exception
	 */
	@FXML
	void ReturnLectureMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("LectureMenu", "LectureMenu");
	}
/**
 * This method will return the user to the main menu
 * @param event
 * @throws Exception
 */
	@FXML
	void ReturnMainMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
	}
/**
 * This method will allow the user to click on a lecture and take them to the amend
 * delete screen with the selected Lecture
 * @param event
 * @throws Exception
 */
	@FXML
	void ListClicked(MouseEvent event) throws Exception {
		if (event.getClickCount() == 2) {
			selectedLecture = ListOfLectures.getSelectionModel().getSelectedItem();
			System.out.println("clicked on " + selectedLecture);
			GeneralMethods.ChangeScene("AmendSingleLecture", "AmendSingleLecture");
		}
	}

	/**
	 * This method will search lectures on multiple fields
	 * 
	 * @param event
	 */
	@FXML
	void ComboSearch(ActionEvent event) {
		int week;
		if (WeekText.getText().isEmpty()) {
			week = 0;
		} else {
			week = Integer.parseInt(WeekText.getText());
		}
		Lecture l = new Lecture();
		if (YearText.getValue() != null) {
			l.setYear(YearText.getValue().toString());
		}
		l.setWeek(week);
		l.setStartTime(StartTimeText.getText());
		l.setStaff(StaffText.getText());
		if (Module.getValue() != null) {
			l.setModule(Module.getValue());
		}
		if (Date.getValue() != null) {
			l.setStartDate(Date.getValue().toString());
		}

		List<Lecture> searched = new ArrayList<Lecture>();

		try {
			searched.addAll(SearchQueries.ComboSearchLectures(l));
		} catch (SQLException e) {
			GeneralMethods.show("Error with searching Lectures", "Error");
			e.printStackTrace();
		}
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		ListOfLectures.setItems(list);
	}

	/**
	 * This will initialize the stage and populate the image, module and year
	 * @throws SQLException
	 */
	@FXML
	void initialize() throws SQLException {
		ApplicationMethods.Years(YearText);
		Module.getItems().addAll(SQL.Modules());
		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
		Image.setImage(i);

	}
}
