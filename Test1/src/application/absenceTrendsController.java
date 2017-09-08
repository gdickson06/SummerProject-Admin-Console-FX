package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.DatePicker;

import javafx.scene.image.ImageView;

import uk.ac.qub.methods.AbsenceTrends;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.objects.ExtendedAbsence;
/** 
 * @author Calum Hurst
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This will be the controller class for the absence trends, this will
 * allow the user to view which trends they would like to see along with filters 
 * for the trends
 * Demographics – 211 LOC 9 Methods 
 * 
 */
public class absenceTrendsController {

	protected static Map<String, Double> trend;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private JFXTextField studentNumber;

	@FXML
	private DatePicker endDate;

	@FXML
	private JFXComboBox<Integer> year;

	@FXML
	private JFXComboBox<String> type;

	@FXML
	private ImageView Image;

	@FXML
	private DatePicker startDate;

	@FXML
	private JFXTextArea graph;

	@FXML
	void dayClick(ActionEvent event) throws SQLException {
		List<Absence> absences = AbsenceTrends.absenceFilter(currentValue());
		Map<String, Double> values = AbsenceTrends.DayTrend(absences);

		String info = "The values below are for days, this just shows how many absences were taken on days"
				+ "if a student takes two absences on the same day it will come up twice";
		String average = "The average number of days off is " + values.get("Average");

		String Monday = "Monday : " + values.get("Monday");
		String Tuesday = " Tuesday : " + values.get("Tuesday");
		String Wednesday = " Wednesday : " + values.get("Wednesday");
		String Thursday = " Thursday : " + values.get("Thursday");
		String Friday = " Friday : " + values.get("Friday");

		graph.setText(info + "\n" + average + "\n" + Monday + "\n" + Tuesday + "\n" + Wednesday + "\n" + Thursday + "\n"
				+ Friday);
		trend = values;

	}

	@FXML
	void staffClick(ActionEvent event) throws SQLException {
		List<Absence> absences = AbsenceTrends.absenceFilter(currentValue());
		Map<String, Double> values = AbsenceTrends.StaffTrends(absences);
		String info = "The values below are for days, this just shows how many absences were taken on days"
				+ "if a student takes two absences on the same day it will come up twice\n";
		String average = "The average number of days off is " + values.get("Average");
		StringBuilder sb = new StringBuilder();

		sb.append(info);
		sb.append(average + "\n");

		for (Entry<String, Double> entry : values.entrySet()) {
			if (!entry.getKey().equals("Average")) {
				sb.append(entry.getKey() + " : " + entry.getValue() + "\n");
			}
		}
		graph.setText(sb.toString());
		trend = null;
	}

	@FXML
	void yearClick(ActionEvent event) throws SQLException {
		List<Absence> absences = AbsenceTrends.absenceFilter(currentValue());
		Map<String, Double> values = AbsenceTrends.YearTrends(absences);
		String info = "The values below are for days, this just shows how many absences were taken on days"
				+ "if a student takes two absences on the same day it will come up twice\n";
		String average = "The average number of days off is " + values.get("Average");
		StringBuilder sb = new StringBuilder();

		sb.append(info);
		sb.append(average + "\n");

		for (Entry<String, Double> entry : values.entrySet()) {
			if (!entry.getKey().equals("Average")) {
				sb.append(entry.getKey() + " : " + entry.getValue() + "\n");
			}
		}
		graph.setText(sb.toString());
		trend = values;
	}

	@FXML
	void moduleClick(ActionEvent event) throws SQLException {
		List<Absence> absences = AbsenceTrends.absenceFilter(currentValue());
		Map<String, Double> values = AbsenceTrends.ModuleTrends(absences);
		String info = "The values below are for days, this just shows how many absences were taken on days"
				+ "if a student takes two absences on the same day it will come up twice";
		String average = "The average number of days off is " + values.get("Average");
		StringBuilder sb = new StringBuilder();

		sb.append(info);
		sb.append(average + "\n");

		values.remove("Average");

		for (Entry<String, Double> entry : values.entrySet()) {
			sb.append(entry.getKey() + " : " + entry.getValue() + "\n");
		}
		graph.setText(sb.toString());
		trend = null;
	}

	@FXML
	void topTenStudentClick(ActionEvent event) throws SQLException {
		List<Absence> absences = AbsenceTrends.absenceFilter(currentValue());
		List<String> info = AbsenceTrends.topTen(absences);
		StringBuilder sb = new StringBuilder();

		for (String s : info) {
			sb.append(s + "\n");
		}
		graph.setText(sb.toString());
		trend = null;
	}

	private ExtendedAbsence currentValue() {
		ExtendedAbsence ea = new ExtendedAbsence();
		if (endDate.getValue() != null) {
			ea.setEnd(endDate.getValue().toString());
		}
		if (startDate.getValue() != null) {
			ea.setStart(startDate.getValue().toString());
		}
		if (year.getValue() != null) {
			ea.setYear(year.getValue());
		}
		if (type.getValue() != null) {
			ea.setType(type.getValue());
		}
		if (!studentNumber.getText().isEmpty()) {
			ea.setStudentNumber(Integer.valueOf(studentNumber.getText()));
		}

		return ea;

	}

	@FXML
	void returnAbsencesMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("AbsenceMenu", "AbsenceMenu");
	}

	@FXML
	void returnMainMenu(ActionEvent event) throws Exception {
		GeneralMethods.ChangeScene("MainMenu", "MainMenu");
	}

	@FXML
	void viewGraph(ActionEvent event) throws Exception {
		if (trend != null) {
			GeneralMethods.ChangeScene("AbsenceGraph", "AbsenceGraph");
		} else {
			GeneralMethods.show("No valid data selected, trends can only be created for years and days", "Error");
		}
	}

	
	@FXML
	void initialize() {
		ApplicationMethods.Years(year);
		ApplicationMethods.AbsenceTypes(type);
		javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
		Image.setImage(i);
	}
}
