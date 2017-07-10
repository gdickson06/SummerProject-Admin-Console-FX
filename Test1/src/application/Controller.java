package application;

import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class Controller {
	
	private VBox content;
	
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
	public Controller() 
		{
		}

	@FXML
	private void initialize() {
	}

	@FXML
	private void printOutput() {
		outputText.setText(inputText.getText());
	}
	
	@FXML
	private void cancelButton(ActionEvent event) throws IOException{
		
		//creating the FXML Loader
		FXMLLoader loader = new FXMLLoader();
		
		String mainMenuFXML = "src/Sample2.fxml";
		FileInputStream mainMenu = new FileInputStream(mainMenuFXML);
		VBox root = (VBox)loader.load(mainMenu);
		//Creating a new Scene
		Scene scene = new Scene(root);
		//Set the Scene to stage
		Main.stage.setScene(scene);
	}

}
