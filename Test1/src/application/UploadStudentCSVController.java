package application;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class UploadStudentCSVController {
	
	@FXML
	private Button cancelButton;
	
	@FXML
	private Button submitButton;

	@FXML
	private TextField inputText;

	@FXML
	private TextArea outputText;

	@FXML
	private URL location;

	@FXML
	private ResourceBundle resources;

	// Add a public no-args constructor
	public UploadStudentCSVController() 
		{
		}

	@FXML
	private void initialize() {
	}

	
	@FXML
	private void cancelButton(ActionEvent event) throws IOException{
		
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
