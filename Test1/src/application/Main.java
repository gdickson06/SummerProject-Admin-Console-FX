package application;

import java.util.ResourceBundle;
import javafx.scene.control.TextArea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.*;
import javafx.scene.control.TextField;


public class Main extends Application {
	static Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		stage=primaryStage;
		//creating the FXML Loader
		FXMLLoader loader = new FXMLLoader();
		
		//Creating path to the FXML File
		String fxmlDocPath = "src/MainMenu.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		
		//Creating the Pane and all Details
		VBox root = (VBox)loader.load(fxmlStream);
		
		//Creating a new Scene
		Scene scene = new Scene(root);
		//Set the Scene to stage
		primaryStage.setScene(scene);
		//setting the title to the stage
		primaryStage.setTitle("First JavaFX stuff");
		//displaying the stage
		primaryStage.show();
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
}
