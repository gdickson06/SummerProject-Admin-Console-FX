package application;

import com.jfoenix.controls.JFXTextField;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
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
    private ImageView Image;

    @FXML
    private JFXTextField filePathTextField;
    private FileChooser fileChooser = new FileChooser();
    private File f;
    @FXML
    void chooseCSV(ActionEvent event) {
    	GeneralMethods.configureFileChooser(fileChooser);  
		File fileCSV = fileChooser.showOpenDialog(Main.getStage());
		if (fileCSV != null) {
			f = fileCSV;
		}
		filePathTextField.setText(f.getAbsolutePath());
    }

    @FXML
    void uploadFile(ActionEvent event) {
    	String s = filePathTextField.getText();


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
    void returnStaffMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StaffMenu", "StaffMenu");
    }

    @FXML
    void returnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }

    @FXML
    void initialize() {
      	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
