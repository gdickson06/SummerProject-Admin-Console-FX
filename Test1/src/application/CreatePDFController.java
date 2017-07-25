package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class CreatePDFController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> Type;

    @FXML
    private TextField Year;

    @FXML
    private TextField StartTime;

    @FXML
    private ComboBox<?> Module;

    @FXML
    private TextField Week;

    @FXML
    private ListView<?> Lectures;

    @FXML
    private Label LectureInfo;

    @FXML
    private TextField Date;

    @FXML
    void LectureClick(ActionEvent event) {

    }

    @FXML
    void Search(ActionEvent event) {

    }

    @FXML
    void GeneratePDF(ActionEvent event) {

    }

    @FXML
    void Home(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Type != null : "fx:id=\"Type\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert Year != null : "fx:id=\"Year\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert StartTime != null : "fx:id=\"StartTime\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert Module != null : "fx:id=\"Module\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert Week != null : "fx:id=\"Week\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert Lectures != null : "fx:id=\"Lectures\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert LectureInfo != null : "fx:id=\"LectureInfo\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert Date != null : "fx:id=\"Date\" was not injected: check your FXML file 'CreatePDF.fxml'.";

    }
}
