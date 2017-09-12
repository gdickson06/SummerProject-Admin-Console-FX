package uk.ac.qub.methods;

import java.io.File;
import java.io.FileInputStream;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Name of Package - uk.ac.qub.methods Date Last Amended - 08/09/17 Outline -
 * This class contains all of the methods that did not fit in other classes the
 * change scene class to go from one page to another, the show method for pop up
 * boxes and the configure file chooser to set up the file chooser. This class was made 
 * with the IText API to create the PDF, the code has been created in with the
 * sample code as a basis.
 *  Demographics – 129 LOC 4 Methods
 */
public class GeneralMethods {

	/**
	 * This method will allow the Scene to be changed will a CSS style sheet
	 * being loaded as well
	 * 
	 * @param fxml
	 * @param css
	 * @throws Exception
	 */
	public static void ChangeScene(String fxml, String css) throws Exception {

		FXMLLoader loader = new FXMLLoader();
		String FXML = "resources/uk/ac/qub/fxml/" + fxml + ".fxml";
		String CSS = "/uk/ac/qub/css/" + css + ".css";
		FileInputStream input = new FileInputStream(FXML);
		AnchorPane root = (AnchorPane) loader.load(input);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(Main.class.getResource(CSS).toExternalForm());

		Main.getStage().setMaximized(true);
		Main.getStage().setScene(scene);
	}

	/**
	 * This method will allow pop up boxes to appear the code for this application 
	 * was aided by JavaFX For Dummies (For Dummies (Computers)) 1 by Doug Lowe (ISBN: 9781118385340)
	 * page 79
	 * @param message
	 * @param title
	 */
	public static void show(String message, String title) {
		Stage stage = new Stage();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.setTitle(title);
		stage.setMinWidth(250);
		Label lbl = new Label();
		lbl.setText(message);
		Button OK = new Button();
		OK.setText("OK");
		OK.setOnAction(e -> stage.close());
		VBox pane = new VBox(20);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.getChildren().addAll(lbl, OK);
		pane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane);
		scene.getStylesheets().add(Main.class.getResource("/uk/ac/qub/css/PopUp.css").toExternalForm());
		Image popUpIcon = new Image(Main.class.getResourceAsStream("/icon.png"));
		stage.getIcons().add(popUpIcon);
		stage.setScene(scene);

		stage.showAndWait();
	}
/**
 * This will give a blank loading page to warn the user that the system has not
 * crash but is still loading
 * @param t
 */
	public static void loading(Thread t) {
		Stage stage = new Stage();
		stage.setTitle("UPLOADING PLEASE WAIT");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.setMinWidth(400);
		stage.setMinHeight(250);
		VBox pane = new VBox(200);
		Label lbl = new Label();
		lbl.setText("LOADING PLEASE WAIT");
		pane.getChildren().add(lbl);
		pane.setPadding(new Insets(10, 10, 10, 10));
		pane.setAlignment(Pos.CENTER);
		Scene scene = new Scene(pane);
		Image popUpIcon = new Image(Main.class.getResourceAsStream("/icon.png"));
		stage.getIcons().add(popUpIcon);
		stage.setScene(scene);
		stage.show();

	
		try {
			t.join();
		} catch (InterruptedException e) {
			stage.close();
		}

		stage.close();
	}

	/**
	 * This method allows a file chooser which is set to only allow CSV files as
	 * these are the only file that is used in this application.
	 * 
	 * @param fileChooser
	 */
	public static void configureFileChooser(FileChooser fileChooser) {
		fileChooser.setTitle("Pick CSV");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv*"),
				new FileChooser.ExtensionFilter("CSV", "*.csv"));
	}

}
