package application;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import uk.ac.qub.churst.CSV;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Staff;

import uk.ac.qub.sql.StaffSQL;


public class UploadUserCSVController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Cancel;

    @FXML
    private Button Upload;

    @FXML
    private TextField FileText;

    @FXML
    private Button SelectFile;
    
    private FileChooser fileChooser = new FileChooser();
    private File f;

    @FXML
    void SelectFile(ActionEvent event) {
    	GeneralMethods.configureFileChooser(fileChooser);  
		File fileCSV = fileChooser.showOpenDialog(Main.getStage());
		if (fileCSV != null) {
			f = fileCSV;
		}
		FileText.setText(f.getAbsolutePath());
    }

    @FXML
    void Upload(ActionEvent event) {
    	String s = FileText.getText();


		List<Staff> staff = new ArrayList<Staff>();
		boolean error = false;
		try {
			staff = CSV.readStaffFromCSV(s);
			StaffSQL.saveSQLUsers(staff);
		} catch (Exception e) {
			e.printStackTrace();
			GeneralMethods.show("Issue with input please view the handbook", "ERROR");
			error = true;
		}

		if (error == false) {
			GeneralMethods.show("Import successful with " + staff.size() + " students imported", "UPLOAD SUCCESS");
		}
    }

    @FXML
    void Cancel(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void initialize() {
    	
        assert Cancel != null : "fx:id=\"Cancel\" was not injected: check your FXML file 'UploadCSVUser.fxml'.";
        assert Upload != null : "fx:id=\"Upload\" was not injected: check your FXML file 'UploadCSVUser.fxml'.";
        assert FileText != null : "fx:id=\"FileText\" was not injected: check your FXML file 'UploadCSVUser.fxml'.";
        assert SelectFile != null : "fx:id=\"SelectFile\" was not injected: check your FXML file 'UploadCSVUser.fxml'.";

    }
}
