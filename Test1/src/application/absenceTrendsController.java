package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import uk.ac.qub.methods.AbsenceTrends;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Absence;
import uk.ac.qub.objects.ExtendedAbsence;

public class absenceTrendsController {
	
	
	protected static Map<String,Double>trend;

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
    private Label graph;


    @FXML
    void dayClick(ActionEvent event) throws SQLException {
    	List<Absence> absences = AbsenceTrends.absenceFilter(currentValue());
    	Map<String,Double> values = AbsenceTrends.DayTrend(absences);
    	
    	String info = "The values below are for days, this just shows how many absences were taken on days"
    			+ "if a student takes two absences on the same day it will come up twice";
    	String average = "The average number of days off is " + values.get("Average");
    	
    	String Monday = "Monday : " + values.get("Monday");
    	String Tuesday = " Tuesday : " +values.get("Tuesday");
    	
    	graph.setText(info + "\n" + average + "\n" + Monday +"\n" + Tuesday);
    	trend =values;
    	
    }

    @FXML
    void staffClick(ActionEvent event) {

    }

    @FXML
    void yearClick(ActionEvent event) {

    }

    @FXML
    void moduleClick(ActionEvent event) {

    }

    @FXML
    void topTenStudentClick(ActionEvent event) {

    }
    
    private ExtendedAbsence currentValue (){
    		ExtendedAbsence ea = new ExtendedAbsence();
    		if(endDate.getValue()!=null){ea.setEnd(endDate.getValue().toString());}
    		if(startDate.getValue()!=null){ea.setStart(startDate.getValue().toString());}
    		if(year.getValue()!=null){ea.setYear(year.getValue());}
    		if(type.getValue()!=null){ea.setType(type.getValue());}
    		if(!studentNumber.getText().isEmpty()){ea.setStudentNumber(Integer.valueOf(studentNumber.getText()));}
    		
    		return ea;
    		
    		
    }

    @FXML
    void returnAbsencesMenu(ActionEvent event) {

    }

    @FXML
    void returnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu", "MainMenu");
    }
    
    @FXML
    void viewGraph(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AbsenceGraph", "AbsenceGraph");
    }

    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
