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

	public static void ChangeScene(String fxml) throws Exception{
FXMLLoader loader = new FXMLLoader();
		
		String FXML = "src/uk/ac/qub/fxml2/"+fxml+".fxml";
		FileInputStream mainMenu = new FileInputStream(FXML);
		AnchorPane root = (AnchorPane)loader.load(mainMenu);
		//Creating a new Scene
		Scene scene = new Scene(root);
		//Set the Scene to stage
		Main.getStage().setScene(scene);
	}
	
	public static void ChangeScene(String fxml, String css) throws Exception {
		
		FXMLLoader loader = new FXMLLoader();
		String FXML = "src/uk/ac/qub/fxml2/"+fxml+".fxml";
		String CSS = "/uk/ac/qub/css/"+css+".css";
		System.out.println(CSS);
		FileInputStream mainMenu = new FileInputStream(FXML);
		AnchorPane root = (AnchorPane)loader.load(mainMenu);
		
		//Creating a new Scene
		Scene scene = new Scene(root);
		scene.getStylesheets().add(Main.class.getResource(CSS).toExternalForm());
		
		//Set the Scene to stage
		Main.getStage().setMaximized(true);
		Main.getStage().setScene(scene);
	}
	
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
	 
	 public static void configureFileChooser(FileChooser fileChooser) {
			fileChooser.setTitle("Pick CSV");
			fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
			fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV", "*.csv*"),
					new FileChooser.ExtensionFilter("CSV", "*.csv"));
		}

}
