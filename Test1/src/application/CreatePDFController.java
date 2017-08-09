package application;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.FileWriter;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.churst.PDF;
import uk.ac.qub.objects.Lecture;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.SearchQueries;

public class CreatePDFController {
	
	private Lecture selectedLecture;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXTextField Year;

    @FXML
    private JFXTextField Staff;

    @FXML
    private JFXTextField StartTime;

    @FXML
    private Label PickedLecture;

    @FXML
    private ImageView Image;

    @FXML
    private JFXComboBox<String> Module;

    @FXML
    private JFXTextField Week;

    @FXML
    private JFXListView<Lecture> Lectures;

    @FXML
    private DatePicker Date;

    @FXML
    void LectureClick(MouseEvent event) {

     		 selectedLecture=Lectures.getSelectionModel().getSelectedItem();
     		
     		 PickedLecture.setText(selectedLecture.toString());
      	
    }

    @FXML
    void Search(ActionEvent event) {
    	int week;
    	if(Week.getText().isEmpty()){
    		week = 0;
    	}else {
 week = Integer.parseInt(Week.getText());
    	}
    	Lecture l = new Lecture(week, StartTime.getText(), Staff.getText(), Module.getValue().toString(), Year.getText());
    
    	List<Lecture> searched = SearchQueries.ComboSearchLectures(l);
		ObservableList<Lecture> list = FXCollections.observableArrayList();
		list.addAll(searched);
		Lectures.setItems(list);
    }

    @FXML
    void GeneratePDF(ActionEvent event) {
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
    void ReturnPDFMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("PDFMenu", "PDFMenu");
    }

    @FXML
    void ReturnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void initialize() {
    	Module.getItems().addAll(SQL.Modules());
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}