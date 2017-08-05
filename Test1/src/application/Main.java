package application;


import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import uk.ac.qub.sql.SQL;
import javafx.scene.Scene;

import javafx.scene.layout.*;



public class Main extends Application {
	private static Stage stage;
	
	public static Connection connection;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		setStage(primaryStage);
		//creating the FXML Loader
		FXMLLoader loader = new FXMLLoader();
		
		//Creating path to the FXML File
		String fxmlDocPath = "src/uk/ac/qub/fxml/LoginPage.fxml";
		FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
		
		//Creating the Pane and all Details
		VBox root = (VBox)loader.load(fxmlStream);
		
		//Creating a new Scene
		Scene scene = new Scene(root);
		//Set the Scene to stage
		primaryStage.setScene(scene);
		//setting the title to the stage
		primaryStage.setTitle("SUPER AMAZIN APP");
		//displaying the stage
		primaryStage.show();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Creating a connection with
			connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		
		
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
