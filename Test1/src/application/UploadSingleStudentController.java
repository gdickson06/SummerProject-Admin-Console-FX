package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class UploadSingleStudentController {

    @FXML
    private Button updateDetailsButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button deleteStudentButton;

    @FXML
    void updateDetailsClick(ActionEvent event) {

    }

    @FXML
    void deleteStudentClick(ActionEvent event) {

    }

    @FXML
    void cancelButtonClick(ActionEvent event) throws IOException {
    	
    	//creating the FXML Loader
    	FXMLLoader loader = new FXMLLoader();
   		
    	String mainMenuFXML = "src/MainMenu.fxml";
    	FileInputStream mainMenu = new FileInputStream(mainMenuFXML);
    	VBox root = (VBox)loader.load(mainMenu);
    	//Creating a new Scene
    	Scene scene = new Scene(root);
    	//Set the Scene to stage
    	Main.stage.setScene(scene);

    }

}