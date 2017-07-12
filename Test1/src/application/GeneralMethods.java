package application;

import java.io.FileInputStream;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class GeneralMethods {

	public static void ChangeScene(String fxml) throws Exception{
FXMLLoader loader = new FXMLLoader();
		
		String FXML = "src/"+fxml+".fxml";
		FileInputStream mainMenu = new FileInputStream(FXML);
		VBox root = (VBox)loader.load(mainMenu);
		//Creating a new Scene
		Scene scene = new Scene(root);
		//Set the Scene to stage
		Main.stage.setScene(scene);
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
	

}
