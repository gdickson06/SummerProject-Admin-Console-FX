package application;

import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import uk.ac.qub.methods.GeneralMethods;

public class absenceTrendsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label absenceInfo;
    
    @FXML
    private Label graph;

    @FXML
    private DatePicker endDate;

    @FXML
    private JFXComboBox<?> year;

    @FXML
    private JFXComboBox<?> module;

    @FXML
    private ImageView Image;

    @FXML
    private DatePicker startDate;

    @FXML
    private LineChart<Number, Number> absenceChart;

    @FXML
    void dayClick(ActionEvent event) {

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

    @FXML
    void returnAbsencesMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AbsenceMenu", "AbsenceMenu");
    }

    @FXML
    void returnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu", "MainMenu");
    }

    @FXML
    void initialize() {
    	
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
        assert absenceInfo != null : "fx:id=\"absenceInfo\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert endDate != null : "fx:id=\"endDate\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert year != null : "fx:id=\"year\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert module != null : "fx:id=\"module\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert Image != null : "fx:id=\"Image\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert startDate != null : "fx:id=\"startDate\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";
        assert absenceChart != null : "fx:id=\"absenceChart\" was not injected: check your FXML file 'AbsenceTrends.fxml'.";

    }
}
