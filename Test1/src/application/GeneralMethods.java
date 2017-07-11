package application;

import java.io.FileInputStream;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;

public class GeneralMethods {

	public static void homeScreen() throws Exception{
FXMLLoader loader = new FXMLLoader();
		
		String mainMenuFXML = "src/MainMenu.fxml";
		FileInputStream mainMenu = new FileInputStream(mainMenuFXML);
		VBox root = (VBox)loader.load(mainMenu);
		//Creating a new Scene
		Scene scene = new Scene(root);
		//Set the Scene to stage
		Main.stage.setScene(scene);
	}

}
