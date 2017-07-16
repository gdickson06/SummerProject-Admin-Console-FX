package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

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

    @FXML
    void SelectFile(ActionEvent event) {
    	
    }

    @FXML
    void Upload(ActionEvent event) {

    }

    @FXML
    void Cancel(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Cancel != null : "fx:id=\"Cancel\" was not injected: check your FXML file 'UploadCSVUser.fxml'.";
        assert Upload != null : "fx:id=\"Upload\" was not injected: check your FXML file 'UploadCSVUser.fxml'.";
        assert FileText != null : "fx:id=\"FileText\" was not injected: check your FXML file 'UploadCSVUser.fxml'.";
        assert SelectFile != null : "fx:id=\"SelectFile\" was not injected: check your FXML file 'UploadCSVUser.fxml'.";

    }
}
