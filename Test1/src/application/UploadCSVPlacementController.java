package application;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import uk.ac.qub.churst.CSV;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.sql.PlacementSQL;

public class UploadCSVPlacementController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TextField YearTextField;

    @FXML
    private TextField PlacementCSVFilePath;
    
    private FileChooser fileChooser = new FileChooser();
    private File file;
    
    private Button uploadPlacementCSV;
    
    private Button selectFilePlacementCSVButton;
    
    
    /**creating method that will select the file from the user's computer and display filepath of file
     * 
     * @param event
     */
    @FXML
    void selectFilePlacementCSV(ActionEvent event) {
    	//calling configureFileChooser method from GeneralMethods.java class to select file from CPU
    	GeneralMethods.configureFileChooser(fileChooser);
    	File fileCSV = fileChooser.showOpenDialog(Main.getStage());
    	if(fileCSV!=null){
    		file = fileCSV;
    	}
    	//setting text within TextField to filepath of CSV
    	PlacementCSVFilePath.setText(file.getAbsolutePath());
    }
    
    /**
     * Method below will upload the CSV from the file path into the 'Placement' table in the database 
     * @param event
     */
    @FXML
    void UploadPlacementCSVButton(ActionEvent event) {
    	String path = PlacementCSVFilePath.getText();
    	
    	List<Placement> placementList = new ArrayList<Placement>();
    	boolean error = false;
    		
    	    int year = Integer.parseInt(YearTextField.getText());
    		placementList= CSV.readPlacementsFromCSV(path, year);

    		
    		try {
				PlacementSQL.saveSQLPlacement(placementList, year);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				error=true;
			}
    		
    		if(error==false){
    			GeneralMethods.show("Upload successful, "+placementList.size()+ " placements added to the database", "Upload Successful");
    		}
   
    }

    @FXML
    void CancelPlacementFileButton(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void initialize() {
    	assert YearTextField != null : "fx:id=\"YearTextField\" was not injected: check your FXML file 'UploadCSVPlacement.fxml'.";
    	assert uploadPlacementCSV != null : "fx:id=\"uploadPlacementCSV\" was not injected: check your FXML file 'UploadCSVPlacement.fxml'.";
        assert PlacementCSVFilePath != null : "fx:id=\"PlacementCSVFilePath\" was not injected: check your FXML file 'UploadCSVPlacement.fxml'.";
        assert selectFilePlacementCSVButton != null : "fx:id=\"selectFilePlacementCSVButton\" was not injected: check your FXML file 'UploadCSVPlacement.fxml'.";
    }
}