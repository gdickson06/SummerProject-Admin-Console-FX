package application;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.ConvertGroup;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.sql.AbsenceSQL;
import uk.ac.qub.sql.LectureSQL;
import uk.ac.qub.sql.SQL;

public class UploadSingleAbsenceController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LectureID;

    @FXML
    private ComboBox<String> Type;

    @FXML
    private TextField EndTime;

    @FXML
    private TextField StudentNumber;

    @FXML
    private TextField StartTime;

    @FXML
    private CheckBox Approved;

    @FXML
    private DatePicker Date;

    @FXML
    private TextArea Reason;

    @FXML
    void UploadSingleAbsenceButton(ActionEvent event) {
    	// This will be in the order of the Studentnumber,lectureid,date,starttime,endtime,reason,approved,type
    	
    	List<String> attributes = new ArrayList<String>();
    	
    	attributes.add(StudentNumber.getText());
    	attributes.add(LectureID.getText());
    	attributes.add(Date.getValue().toString());
    	attributes.add(ConvertGroup.TimeConvertSQL(StartTime.getText()));
    	attributes.add(ConvertGroup.TimeConvertSQL(EndTime.getText()));
    	attributes.add(Reason.getText());
    	attributes.add(String.valueOf(Approved.isSelected()));
    	attributes.add(Type.getValue());
    	
    	try {
			AbsenceSQL.saveSingleAbsence(attributes);
			GeneralMethods.show("Success", "Success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			GeneralMethods.show(e.getMessage(), "Error");
		}
    	
    }
    
    
    @FXML
    void LectureFinder(ActionEvent event) {
    
    	
    	
    }
    @FXML
    void UploadSingleAbsenceCancelButton(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void initialize() {
    	
    	LectureID.textProperty().addListener((observable, oldValue, newValue) -> {
    		String id = LectureID.getText();
        	
        	try {
    			List<String> att = LectureSQL.finder(id);
    			Date.setValue(LocalDate.parse(att.get(0)));
    			StartTime.setText(att.get(1));
    			EndTime.setText(att.get(2));
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	});
    	
    	ApplicationMethods.AbsenceTypes(Type);
        assert LectureID != null : "fx:id=\"LectureID\" was not injected: check your FXML file 'UploadSingleAbsence.fxml'.";
        assert Type != null : "fx:id=\"Type\" was not injected: check your FXML file 'UploadSingleAbsence.fxml'.";
        assert EndTime != null : "fx:id=\"EndTime\" was not injected: check your FXML file 'UploadSingleAbsence.fxml'.";
        assert StudentNumber != null : "fx:id=\"StudentNumber\" was not injected: check your FXML file 'UploadSingleAbsence.fxml'.";
        assert StartTime != null : "fx:id=\"StartTime\" was not injected: check your FXML file 'UploadSingleAbsence.fxml'.";
        assert Approved != null : "fx:id=\"Approved\" was not injected: check your FXML file 'UploadSingleAbsence.fxml'.";
        assert Date != null : "fx:id=\"Date\" was not injected: check your FXML file 'UploadSingleAbsence.fxml'.";
        assert Reason != null : "fx:id=\"Reason\" was not injected: check your FXML file 'UploadSingleAbsence.fxml'.";

    }
}

