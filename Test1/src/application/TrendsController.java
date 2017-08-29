package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import uk.ac.qub.methods.AbsenceTrends;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.objects.ExtendedAbsence;


public class TrendsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private  TextField StudentInfo;

    @FXML
    private PieChart TrendPie;

    @FXML
    private PieChart AveragePie;

    @FXML
    private ComboBox<String> DayInfo;

   

    @FXML
    private  ComboBox<String> ModuleInfo;

    @FXML
    private  ComboBox<String> YearInfo;

    @FXML
    private BarChart<String, Double> BarChart;

    @FXML
    private  DatePicker DateInfo;

    @FXML
    private ComboBox<String> StaffInfo;

    @FXML
    private ComboBox<String> TypeInfo;

    @FXML
    private ComboBox<String> TypeBox;
    

    @SuppressWarnings("unchecked")
	@FXML
    void Year(ActionEvent event) throws SQLException {
    	 ExtendedAbsence ea = new ExtendedAbsence();
  	   
  	   //ea.setCohort(CohortInfo.getText());
  	   //if(DateInfo!=null){ea.setDate(DateInfo.getValue().toString());}
  	   //ea.setDay(DayInfo.getValue());
  	   //ea.setModule(ModuleInfo.getValue());
  	   //ea.setStaff(StaffInfo.getValue());
  	   //ea.setStudentNumber(StudentInfo.getText());
  	   ea.setType(TypeInfo.getValue());
  	   //ea.setYear(YearInfo.getValue().substring(5));
    	TypeBox.setValue("Bar Chart");
    	
    	List<Absence> absences = AbsenceTrends.filteredAbsence(ea);
    	Map<String, Double> map = AbsenceTrends.YearTrends(absences);
    	
    	XYChart.Series<String, Double> series1 = new XYChart.Series<>();
        series1.setName("Year");
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            String tmpString = entry.getKey();
            Double tmpValue = entry.getValue();
            XYChart.Data<String, Double> d = new XYChart.Data<>(tmpString, tmpValue);
            System.out.println(d);
            series1.getData().add(d);
        }
        BarChart.setTitle(series1.getName());
        BarChart.getData().addAll(series1);
    	BarChart.setVisible(true);
    	

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
    	BarChart.setAnimated(false);
    	
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
    	
    	
    	TypeInfo.getItems().addAll(types);
    	//ModuleInfo.getItems().addAll(SQL.Modules());
    	DayInfo.getItems().addAll(days);
    	YearInfo.getItems().addAll(years);
    	//ApplicationMethods.AbsenceTypes(TypeInfo);
    	//StaffInfo.getItems().addAll(SQL.Staff());
    	TypeBox.getItems().add("Pie Chart");
    	TypeBox.getItems().add("Bar Chart");
    	
    	
    	

    }
}
