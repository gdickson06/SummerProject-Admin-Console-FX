package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import uk.ac.qub.churst.GeneralMethods;

public class HelpController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

  

    @FXML
    void Student(ActionEvent event) {
    	try {
    	     if (Desktop.isDesktopSupported()) {
    	       Desktop.getDesktop().open(new File("StandardStudentList.csv"));
    	     }
    	   } catch (IOException ioe) {
    	     ioe.printStackTrace();
    	  }
    }

    @FXML
    void Staff(ActionEvent event) {

    }

    @FXML
    void Placement(ActionEvent event) {

    }

    @FXML
    void Lecture(ActionEvent event) {
    	try {
   	     if (Desktop.isDesktopSupported()) {
   	       Desktop.getDesktop().open(new File("StandardLecture.csv"));
   	     }
   	   } catch (IOException ioe) {
   	     ioe.printStackTrace();
   	  }
    }

    @FXML
    void Rooms(ActionEvent event) {
    	try {
   	     if (Desktop.isDesktopSupported()) {
   	       Desktop.getDesktop().open(new File("StandardRoomList.csv"));
   	     }
   	   } catch (IOException ioe) {
   	     ioe.printStackTrace();
   	  }
    }

    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void initialize() {

    }
}
