package uk.ac.qub.churst;

import java.io.File;
import java.io.FileInputStream;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GeneralMethods {

	

/**
 * This method will allow the Scene to be changed will a CSS style sheet
 * being loaded as well
 * @param fxml
 * @param css
 * @throws Exception
 */
	public static void ChangeScene(String fxml, String css) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		String FXML = "src/uk/ac/qub/fxml2/"+fxml+".fxml";
		String CSS = "/uk/ac/qub/css/"+css+".css";
		System.out.println(CSS);
		FileInputStream mainMenu = new FileInputStream(FXML);
		AnchorPane root = (AnchorPane)loader.load(mainMenu);

		Scene scene = new Scene(root);
		scene.getStylesheets().add(Main.class.getResource(CSS).toExternalForm());
	
		Main.getStage().setMaximized(true);
		Main.getStage().setScene(scene);
	}

	
/**
 * This method will allow pop up boxes to appear 
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
			Button btnOK = new Button();
			btnOK.setText("OK");
			btnOK.setOnAction(e -> stage.close());
			VBox pane = new VBox(20);
			pane.getChildren().addAll(lbl, btnOK);
			pane.setAlignment(Pos.CENTER);
			Scene scene = new Scene(pane);
			stage.setScene(scene);
			
			stage.showAndWait();
		}

	 /**
	  * This method allows a file chooser which is set to only allow CSV files
	  * as these are the only file that is used in this application.
	  * @param fileChooser
	  */
	 public static void configureFileChooser(FileChooser fileChooser) {
			fileChooser.setTitle("Pick CSV");
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv*"),
					new FileChooser.ExtensionFilter("CSV", "*.csv"));
		}

}
