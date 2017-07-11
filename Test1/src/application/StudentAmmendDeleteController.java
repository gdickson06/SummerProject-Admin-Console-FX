package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class StudentAmmendDeleteController {

    @FXML
    private Button studentSearch;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private Button studentCancel;

    @FXML
    private TextField firstNameTextField;

    @FXML
    void studentSearchButton(ActionEvent event) throws IOException {
    	
    	//creating the FXML Loader
    	FXMLLoader loader = new FXMLLoader();
   		
    	String mainMenuFXML = "src/UploadSingleStudent.fxml";
    	FileInputStream mainMenu = new FileInputStream(mainMenuFXML);
    	VBox root = (VBox)loader.load(mainMenu);
    	//Creating a new Scene
    	Scene scene = new Scene(root);
    	//Set the Scene to stage
    	Main.stage.setScene(scene);

    }

    @FXML
    void studentCancelButton(ActionEvent event) throws IOException {
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
