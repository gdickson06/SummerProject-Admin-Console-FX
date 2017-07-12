package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SelectedUserController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Delete;

    @FXML
    private ComboBox<?> Type;

    @FXML
    private Label UserName;

    @FXML
    private Button Back;

    @FXML
    private Button Change;

    @FXML
    private Button Home;

    @FXML
    private TextField Name;

    @FXML
    private TextField Password;

    @FXML
    void Change(ActionEvent event) {

    }

    @FXML
    void Delete(ActionEvent event) {

    }

    @FXML
    void Back(ActionEvent event) {

    }

    @FXML
    void Home(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Delete != null : "fx:id=\"Delete\" was not injected: check your FXML file 'SelectedUser.fxml'.";
        assert Type != null : "fx:id=\"Type\" was not injected: check your FXML file 'SelectedUser.fxml'.";
        assert UserName != null : "fx:id=\"UserName\" was not injected: check your FXML file 'SelectedUser.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'SelectedUser.fxml'.";
        assert Change != null : "fx:id=\"Change\" was not injected: check your FXML file 'SelectedUser.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'SelectedUser.fxml'.";
        assert Name != null : "fx:id=\"Name\" was not injected: check your FXML file 'SelectedUser.fxml'.";
        assert Password != null : "fx:id=\"Password\" was not injected: check your FXML file 'SelectedUser.fxml'.";

    }
}

