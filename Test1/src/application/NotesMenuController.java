package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import uk.ac.qub.churst.GeneralMethods;

public class NotesMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button returnMainMenuButton;

    @FXML
    private Button logOutButton;

    @FXML
    private Button practicalNoteButton;

    @FXML
    private Button lectureNoteButton;

    @FXML
    private ImageView Image;

    @FXML
    private Button generalNoteButton;

    @FXML
    void returnMainMenuButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3", "MainMenu3");
    }

    @FXML
    void logOutButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("Login2", "Login2");
    	ApplicationMethods.CurrentUser=null;
    }

    @FXML
    void generalNoteButtonClick(ActionEvent event) {
    	//to be completed
    }

    @FXML
    void practicalNoteButtonClick(ActionEvent event) {
    	//to be completed
    }

    @FXML
    void lectureNoteButtonClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("LectureNoteMenu", "LectureNoteMenu");
    }

    @FXML
    void initialize() {
    	
    	
    	
        assert returnMainMenuButton != null : "fx:id=\"returnMainMenuButton\" was not injected: check your FXML file 'NotesMenu.fxml'.";
        assert logOutButton != null : "fx:id=\"logOutButton\" was not injected: check your FXML file 'NotesMenu.fxml'.";
        assert practicalNoteButton != null : "fx:id=\"practicalNoteButton\" was not injected: check your FXML file 'NotesMenu.fxml'.";
        assert lectureNoteButton != null : "fx:id=\"lectureNoteButton\" was not injected: check your FXML file 'NotesMenu.fxml'.";
        assert Image != null : "fx:id=\"Image\" was not injected: check your FXML file 'NotesMenu.fxml'.";
        assert generalNoteButton != null : "fx:id=\"generalNoteButton\" was not injected: check your FXML file 'NotesMenu.fxml'.";

    }
}

