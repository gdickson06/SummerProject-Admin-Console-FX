package application;


import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.sql.SQL;
import javafx.scene.Scene;

import javafx.scene.layout.*;



public class Main extends Application {
	public static Stage stage;
	public static Scene scene;
	
	public static Connection connection;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		ApplicationMethods.Cohorts.add("A1");
		ApplicationMethods.Cohorts.add("B1"); 
		ApplicationMethods.Cohorts.add("A2");
		ApplicationMethods.Cohorts.add("B2"); 
		ApplicationMethods.Cohorts.add("A3");
		ApplicationMethods.Cohorts.add("B3"); 
		ApplicationMethods.Cohorts.add("A4");
		ApplicationMethods.Cohorts.add("B4"); 
		ApplicationMethods.Cohorts.add("A5");
		ApplicationMethods.Cohorts.add("B5"); 
		ApplicationMethods.Cohorts.add("A6");
		ApplicationMethods.Cohorts.add("B6"); 
		ApplicationMethods.Cohorts.add("A7");
		ApplicationMethods.Cohorts.add("B7"); 
		ApplicationMethods.Cohorts.add("A8");
		ApplicationMethods.Cohorts.add("B8"); 
		ApplicationMethods.Cohorts.add("A9");
		ApplicationMethods.Cohorts.add("B9"); 
		ApplicationMethods.Cohorts.add("A10");
		ApplicationMethods.Cohorts.add("B10"); 
		ApplicationMethods.Cohorts.add("A11");
		ApplicationMethods.Cohorts.add("B11"); 
		ApplicationMethods.Cohorts.add("A12");
		ApplicationMethods.Cohorts.add("B12"); 
		ApplicationMethods.Cohorts.add("A13");
		ApplicationMethods.Cohorts.add("B13"); 
		ApplicationMethods.Cohorts.add("A14");
		ApplicationMethods.Cohorts.add("B14"); 
		ApplicationMethods.Cohorts.add("A15");
		ApplicationMethods.Cohorts.add("B15"); 
		ApplicationMethods.Cohorts.add("A16");
		ApplicationMethods.Cohorts.add("B16"); 
		ApplicationMethods.Cohorts.add("A17");
		ApplicationMethods.Cohorts.add("B17"); 
		ApplicationMethods.Cohorts.add("A18");
		ApplicationMethods.Cohorts.add("B18"); 
		ApplicationMethods.Cohorts.add("A19");
		ApplicationMethods.Cohorts.add("B19"); 
		ApplicationMethods.Cohorts.add("A20");
		ApplicationMethods.Cohorts.add("B20"); 
		ApplicationMethods.Cohorts.add("A21");
		ApplicationMethods.Cohorts.add("B21"); 
		ApplicationMethods.Cohorts.add("A22");
		ApplicationMethods.Cohorts.add("B22"); 
		ApplicationMethods.Cohorts.add("A23");
		ApplicationMethods.Cohorts.add("B23"); 
		ApplicationMethods.Cohorts.add("A24");
		ApplicationMethods.Cohorts.add("B24"); 
		setStage(primaryStage);
		AnchorPane root = FXMLLoader.load(getClass().getResource("/uk/ac/qub/fxml2/Login2.fxml"));
		Scene scene = new Scene(root, 900, 700);
		primaryStage.setTitle("Administration Console");
		primaryStage.setScene(scene);
		scene.getStylesheets().add(Main.class.getResource("/uk/ac/qub/css/login2.css").toExternalForm());
		primaryStage.setMaximized(true);
		primaryStage.show();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// Creating a connection with
			connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		} catch (Exception e) {
			GeneralMethods.show("Database connection error, please check your internet connection", "Error");
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
