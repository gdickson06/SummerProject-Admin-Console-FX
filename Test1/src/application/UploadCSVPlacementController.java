package application;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import uk.ac.qub.churst.CSV;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.sql.PlacementSQL;

public class UploadCSVPlacementController {
	  @FXML
	    private ImageView Image;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
 
    @FXML
    private JFXComboBox<Integer> Year;

    @FXML
    private JFXTextField PlacementCSVFilePath;
    
    private FileChooser fileChooser = new FileChooser();
    private File file;
    
   
    
    
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
    void uploadPlacementsCSV(ActionEvent event) {
    	String path = PlacementCSVFilePath.getText();
    	
    	List<Placement> placementList = new ArrayList<Placement>();
    	boolean error = false;
    		
    	    int year = Year.getValue();
    		placementList= CSV.readPlacementsFromCSV(path, year);

    		
    		try {
				PlacementSQL.saveSQLPlacement(placementList, year);
			} catch (Exception e) {
				e.printStackTrace();
				error=true;
			}
    		
    		if(error==false){
    			GeneralMethods.show("Upload successful, "+placementList.size()+ " placements added to the database", "Upload Successful");
    		}
   
    }
    @FXML
    void DeleteYear(ActionEvent event) throws Exception {
    	PlacementSQL.DeleteYearPlacement(String.valueOf(Year.getValue()));
    	GeneralMethods.show("DELETED ALL FOR YEAR", "DELETED ALL FOR YEAR");
    }

    @FXML
    void returnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }
    @FXML
    void returnPracticalMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("PracticalMenuController", "PracticalPlacementMenu");
    }
    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	ApplicationMethods.Years(Year);
    }
}