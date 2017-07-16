package uk.ac.qub.churst;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
 
public final class To extends Application {
 
 
 
    @Override
    public void start(final Stage stage) {
        stage.setTitle("File Chooser Sample");
 
        final FileChooser fileChooser = new FileChooser();
 
        final Button openButton = new Button("Open a Picture...");
      
 
        openButton.setOnAction(
            new EventHandler<ActionEvent>() {
                @Override
                public void handle(final ActionEvent e) {
                    File file = fileChooser.showOpenDialog(stage);
                    if (file != null) {
                        System.out.println(file.getAbsolutePath());
                    }
                }
            });
 
        
 
 
        final GridPane inputGridPane = new GridPane();
 
        GridPane.setConstraints(openButton, 0, 0);
        inputGridPane.setHgap(6);
        inputGridPane.setVgap(6);
        inputGridPane.getChildren().addAll(openButton);
 
        final Pane rootGroup = new VBox(12);
        rootGroup.getChildren().addAll(inputGridPane);
        rootGroup.setPadding(new Insets(12, 12, 12, 12));
 
        stage.setScene(new Scene(rootGroup));
        stage.show();
    }
 
    public static void main(String[] args) {
    	
    	GregorianCalendar g = new GregorianCalendar();
    	
    	//current year
    	@SuppressWarnings("deprecation")
		int year=g.getTime().getYear();
    	//current month this has to be +1 because Jan = month 0
    	@SuppressWarnings("deprecation")
		int month = g.getTime().getMonth()+1;
    	// will be taken from the individual student
    	int intakeYear=2014;
    	// if the current month is past sept add 1 to the intake year eg in August 2017 someone with intakeyear 2016 will be a first year 
    	// but if it is past septemeber they will be a secondyear
    	int pastSept=0;
    	
    	if(month>=9){
    		pastSept=1;
    	}
    	//I have to add 1900 because it gives me the year in numbers past the year 1900
    	int whichYear = (year+1900) -intakeYear +pastSept;
    	
    	System.out.println(whichYear);
 
    }
}