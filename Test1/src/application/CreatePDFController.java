package application;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.FileWriter;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.churst.PDF;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.SearchQueries;

public class CreatePDFController {
	
    @FXML
    private TextField SaveLocation;
	
	private Lecture selectedLecture;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Year;

    @FXML
    private TextField Staff;

    @FXML
    private TextField StartTime;

    @FXML
    private ComboBox<String> Module;

    @FXML
    private TextField Week;

    @FXML
    private ListView<Lecture> Lectures;

    @FXML
    private Label LectureInfo;

    @FXML
    private TextField Date;

    @FXML
    void LectureClick(MouseEvent event) {
    	if(event.getClickCount()==2){
      		 selectedLecture=Lectures.getSelectionModel().getSelectedItem();
      		
      		 LectureInfo.setText(selectedLecture.toString());
       	}
    }

    @FXML
    void Search(ActionEvent event) {
    	int week;
    	if(Week.getText().isEmpty()){
    		week = 0;
    	}else {
 week = Integer.parseInt(Week.getText());
    	}
    	Lecture l = new Lecture(week, Date.getText(), StartTime.getText(), Staff.getText(), Module.getValue(), Year.getText());
    	List<Lecture> searched = SearchQueries.ComboSearchLectures(l);
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Lectures.setItems(list);
    }

    @FXML
    void GeneratePDF(ActionEvent event) throws SQLException {
    	File f = new File ("SaveInfo.txt");
    	if(f.exists()){
    	try{
    	if(selectedLecture!=null){
    		System.out.println("TESTING");
    	PDF pdf = new PDF(selectedLecture);
    	pdf.setLocation(FileWriter.load());
    	pdf.create();
    	GeneralMethods.show("PDF created at " + FileWriter.load(),"Success");
    	}
    	} catch (Exception e){
    		e.printStackTrace();
    	}
    	
    	} else {
    		GeneralMethods.show("No save location specified go to setttings to specify", "Error");
    	}
    }

    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void initialize() {
    	Module.getItems().addAll(SQL.Modules());
        assert Year != null : "fx:id=\"Year\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert Staff != null : "fx:id=\"Staff\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert StartTime != null : "fx:id=\"StartTime\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert Module != null : "fx:id=\"Module\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert Week != null : "fx:id=\"Week\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert Lectures != null : "fx:id=\"Lectures\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert LectureInfo != null : "fx:id=\"LectureInfo\" was not injected: check your FXML file 'CreatePDF.fxml'.";
        assert Date != null : "fx:id=\"Date\" was not injected: check your FXML file 'CreatePDF.fxml'.";

    }
}

