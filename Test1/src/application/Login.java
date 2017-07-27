package application;

import javafx.scene.control.Label;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {
	
	public static void Main(String[] args){
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Java FX Example");

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text sceneTitle = new Text("Sign In");
		sceneTitle.setFont(Font.font("Arial Narrow",FontWeight.NORMAL, 20));
		sceneTitle.setFill(Color.WHITE);
		grid.add(sceneTitle, 0, 0, 2, 1);
		
		Label userName = new Label("User Name:");
		grid.add(userName, 0, 1);
		
		TextField userNameTextField = new TextField();
		grid.add(userNameTextField, 1, 1);
		
		Label password = new Label("Password:");
		grid.add(password, 0, 2);
		
		PasswordField pwField = new PasswordField();
		grid.add(pwField, 1, 2);
		
		Button button = new Button("Sign In");
		HBox hbButton = new HBox(10);
		hbButton.setAlignment(Pos.BOTTOM_RIGHT);
		hbButton.getChildren().add(button);
		grid.add(hbButton, 1, 4);
		
		final Text actionTarget = new Text();
				grid.add(actionTarget, 1, 6);
				
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				actionTarget.setFill(Color.WHITE);
				actionTarget.setText("Sign in Button pressed");
				
			}
		});

		Scene scene = new Scene(grid, 800, 400);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(Login.class.getResource("/Login.css").toExternalForm());
		primaryStage.show();
	}

}
