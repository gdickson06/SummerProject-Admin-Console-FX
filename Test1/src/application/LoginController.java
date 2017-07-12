package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PasswordField PasswordText;

    @FXML
    private TextField UsernameText;

    @FXML
    private Button LoginButton;

    @FXML
    private Button Clear;

    @FXML
    void Login(ActionEvent event) {

    }

    @FXML
    void Clear(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert PasswordText != null : "fx:id=\"PasswordText\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert UsernameText != null : "fx:id=\"UsernameText\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert LoginButton != null : "fx:id=\"LoginButton\" was not injected: check your FXML file 'LoginPage.fxml'.";
        assert Clear != null : "fx:id=\"Clear\" was not injected: check your FXML file 'LoginPage.fxml'.";

    }
}
