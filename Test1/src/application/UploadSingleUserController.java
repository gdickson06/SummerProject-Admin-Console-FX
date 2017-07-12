package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class UploadSingleUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField PasswordText;

    @FXML
    private TextField UsernameText;

    @FXML
    private Button Cancel;

    @FXML
    private TextField NameText;

    @FXML
    private Button Upload;

    @FXML
    private ComboBox<?> TypePicker;

    @FXML
    void Upload(ActionEvent event) {

    }

    @FXML
    void Cancel(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert PasswordText != null : "fx:id=\"PasswordText\" was not injected: check your FXML file 'UploadSingleUser.fxml'.";
        assert UsernameText != null : "fx:id=\"UsernameText\" was not injected: check your FXML file 'UploadSingleUser.fxml'.";
        assert Cancel != null : "fx:id=\"Cancel\" was not injected: check your FXML file 'UploadSingleUser.fxml'.";
        assert NameText != null : "fx:id=\"NameText\" was not injected: check your FXML file 'UploadSingleUser.fxml'.";
        assert Upload != null : "fx:id=\"Upload\" was not injected: check your FXML file 'UploadSingleUser.fxml'.";
        assert TypePicker != null : "fx:id=\"TypePicker\" was not injected: check your FXML file 'UploadSingleUser.fxml'.";

    }
}

