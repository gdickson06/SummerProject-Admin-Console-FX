package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class UserAmendDeleteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> Type;

    @FXML
    private Button FirstNameSearch;

    @FXML
    private TextField FirstName;

    @FXML
    private Button LastNameSearch;

    @FXML
    private ListView<?> UserTable;

    @FXML
    private Button TypeSearch;

    @FXML
    private TextField LastName;

    @FXML
    private Button UserNameSearch;

    @FXML
    void TypeSearch(ActionEvent event) {

    }

    @FXML
    void FirstNameSearch(ActionEvent event) {

    }

    @FXML
    void LastNameSearch(ActionEvent event) {

    }

    @FXML
    void UserNameSearch(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert Type != null : "fx:id=\"Type\" was not injected: check your FXML file 'UserAmendDelete.fxml'.";
        assert FirstNameSearch != null : "fx:id=\"FirstNameSearch\" was not injected: check your FXML file 'UserAmendDelete.fxml'.";
        assert FirstName != null : "fx:id=\"FirstName\" was not injected: check your FXML file 'UserAmendDelete.fxml'.";
        assert LastNameSearch != null : "fx:id=\"LastNameSearch\" was not injected: check your FXML file 'UserAmendDelete.fxml'.";
        assert UserTable != null : "fx:id=\"UserTable\" was not injected: check your FXML file 'UserAmendDelete.fxml'.";
        assert TypeSearch != null : "fx:id=\"TypeSearch\" was not injected: check your FXML file 'UserAmendDelete.fxml'.";
        assert LastName != null : "fx:id=\"LastName\" was not injected: check your FXML file 'UserAmendDelete.fxml'.";
        assert UserNameSearch != null : "fx:id=\"UserNameSearch\" was not injected: check your FXML file 'UserAmendDelete.fxml'.";

    }
}

