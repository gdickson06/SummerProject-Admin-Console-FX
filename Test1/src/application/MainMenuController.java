package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class MainMenuController {

    @FXML
    private Button studentUploadCSVButton;

    @FXML
    private Button roomUploadCSV;

    @FXML
    private Button lecturerUploadCSV;

    @FXML
    private Button lectureUploadCSV;
    
    

    @FXML
    void uploadStudentCSV(ActionEvent event) throws IOException {
    	
    	//creating the FXML Loader
    	FXMLLoader loader = new FXMLLoader();
    			
    	String mainMenuFXML = "src/uploadCSVMenu.fxml";
    	FileInputStream mainMenu = new FileInputStream(mainMenuFXML);
    	VBox root = (VBox)loader.load(mainMenu);
    	//Creating a new Scene
    	Scene scene = new Scene(root);
    	//Set the Scene to stage
    	Main.stage.setScene(scene);

    }

    @FXML
    void lectureUploadCSVButton(ActionEvent event) throws IOException {
    	
    	//creating the FXML Loader
    	FXMLLoader loader = new FXMLLoader();
    			
    	String mainMenuFXML = "src/uploadCSVMenu.fxml";
    	FileInputStream mainMenu = new FileInputStream(mainMenuFXML);
    	VBox root = (VBox)loader.load(mainMenu);
    	//Creating a new Scene
    	Scene scene = new Scene(root);
    	//Set the Scene to stage
    	Main.stage.setScene(scene);

    }

    @FXML
    void lecturerUploadCSVButton(ActionEvent event) throws IOException {
    	
    	//creating the FXML Loader
    	FXMLLoader loader = new FXMLLoader();
    			
    	String mainMenuFXML = "src/uploadCSVMenu.fxml";
    	FileInputStream mainMenu = new FileInputStream(mainMenuFXML);
    	VBox root = (VBox)loader.load(mainMenu);
    	//Creating a new Scene
    	Scene scene = new Scene(root);
    	//Set the Scene to stage
    	Main.stage.setScene(scene);

    }

    @FXML
    void roomUploadCSVButton(ActionEvent event) throws IOException {
    	
    	//creating the FXML Loader
    	FXMLLoader loader = new FXMLLoader();
    			
    	String mainMenuFXML = "src/uploadCSVMenu.fxml";
    	FileInputStream mainMenu = new FileInputStream(mainMenuFXML);
    	VBox root = (VBox)loader.load(mainMenu);
    	//Creating a new Scene
    	Scene scene = new Scene(root);
    	//Set the Scene to stage
    	Main.stage.setScene(scene);

    }

}