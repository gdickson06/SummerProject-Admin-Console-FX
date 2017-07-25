package application;


import java.io.FileInputStream;

import java.io.IOException;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

import javafx.scene.layout.*;



public class Main extends Application {
	private static Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		setStage(primaryStage);
		//creating the FXML Loader
		FXMLLoader loader = new FXMLLoader();
		
		//Creating path to the FXML File
		String fxmlDocPath = "src/uk/ac/qub/fxml/mainMenu.fxml";
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

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		Main.stage = stage;
	}
	
}
