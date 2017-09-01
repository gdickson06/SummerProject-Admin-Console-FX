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



public class Main extends Application {
	public static Stage stage;
	public static Scene scene;
	
	public static Connection connection;
	
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
