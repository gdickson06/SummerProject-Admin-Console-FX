package application;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.sql.SQL;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

/** 
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This is the main class of the application, it includes the start method 
 * which will start up the application and create the initial scene and stage for
 * the rest of the appplication to run from.
 * Demographics – 76 LOC 4 Methods 
 * 
 */

public class Main extends Application {
	public static Stage stage;
	public static Scene scene;
	
	public static Connection connection;
	/**
	 * This method will be used to start the application, it includes the creation
	 * of the initial scene and stage
	 */
	@Override
	public void start(Stage primaryStage) throws IOException {

		setStage(primaryStage);
		AnchorPane root = FXMLLoader.load(getClass().getResource("/uk/ac/qub/fxml/Login.fxml"));
		Scene scene = new Scene(root, 900, 700);
		primaryStage.setTitle("QUB School of Medicine Timetable and Absence Notification Administration Console");
		primaryStage.setScene(scene);
		scene.getStylesheets().add(Main.class.getResource("/uk/ac/qub/css/Login.css").toExternalForm());
		primaryStage.setMaximized(true);
		primaryStage.show();
		stage.getIcons().add(new Image("file:resources/toplogo.png"));
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(SQL.url, SQL.user, SQL.password);
		} catch (Exception e) {
			GeneralMethods.show("Database connection error, please check your internet connection", "Error");
		}
		
	
		
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
/**
 * Getter for the stage which is used through the application
 * @return
 */
	public static Stage getStage() {
		return stage;
	}
/**
 * Setter of the stage
 * @param stage
 */
	public static void setStage(Stage stage) {
		Main.stage = stage;
	}
	
}
