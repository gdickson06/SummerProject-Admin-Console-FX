package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import uk.ac.qub.sql.SQL;

public class TrendsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField StudentInfo;

    @FXML
    private PieChart TrendPie;

    @FXML
    private PieChart AveragePie;

    @FXML
    private ComboBox<String> DayInfo;

    @FXML
    private TextField CohortInfo;

    @FXML
    private ComboBox<String> ModuleInfo;

    @FXML
    private ComboBox<String> YearInfo;

    @FXML
    private BarChart<String, Double> BarChart;

    @FXML
    private DatePicker DateInfo;

    @FXML
    private ComboBox<String> StaffInfo;

    @FXML
    private ComboBox<String> TypeInfo;

    @FXML
    private ComboBox<String> TypeBox;

   


    @FXML
    void Year(ActionEvent event) {

    }

    @FXML
    void Cohort(ActionEvent event) {

    }

    @FXML
    void Staff(ActionEvent event) {

    }

    @FXML
    void Module(ActionEvent event) {

    }

    @FXML
    void Day(ActionEvent event) {

    }

    @FXML
    void Date(ActionEvent event) {

    }

    @FXML
    void Student(ActionEvent event) {

    }

    @FXML
    void Home(ActionEvent event) {

    }

    @FXML
    void initialize() {
    	
List<String>types= new ArrayList<String>();
List<String>days = new ArrayList<String>();
List<String>years = new ArrayList<String>();

years.add("YEAR 1");
years.add("YEAR 2");
years.add("YEAR 3");
years.add("YEAR 4");
years.add("YEAR 5");

days.add("MONDAY");
days.add("TUESDAY");
days.add("WEDNESDAY");
days.add("THURSDAY");
days.add("FRIDAY");
    	
    	types.add("Administrator");
    	types.add("Module Coordinator");
    	types.add("Lecturer");
    	
    	TypeInfo.getItems().addAll(types);
    	ModuleInfo.getItems().addAll(SQL.Modules());
    	DayInfo.getItems().addAll(days);
    	YearInfo.getItems().addAll(years);
    	ApplicationMethods.AbsenceTypes(TypeInfo);
    	
    	
    	
        assert StudentInfo != null : "fx:id=\"StudentInfo\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert TrendPie != null : "fx:id=\"TrendPie\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert AveragePie != null : "fx:id=\"AveragePie\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert DayInfo != null : "fx:id=\"DayInfo\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert CohortInfo != null : "fx:id=\"CohortInfo\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert ModuleInfo != null : "fx:id=\"ModuleInfo\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert YearInfo != null : "fx:id=\"YearInfo\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert BarChart != null : "fx:id=\"BarChart\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert DateInfo != null : "fx:id=\"DateInfo\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert StaffInfo != null : "fx:id=\"StaffInfo\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert TypeInfo != null : "fx:id=\"TypeInfo\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert TypeBox != null : "fx:id=\"TypeBox\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";

    }
}
