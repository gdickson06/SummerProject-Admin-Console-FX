package application;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import uk.ac.qub.methods.CSV;
import uk.ac.qub.methods.GeneralMethods;
import uk.ac.qub.objects.Placement;
import uk.ac.qub.sql.PlacementSQL;
/** 
 * Name of Package - application
 * Date Last Amended - 07/09/17
 * Outline - This is the controller class for a user to be able to upload a full
 * year of placements from a CSV file, deleting a full year of placements and to 
 * download a full year of placements to a CSV file.
 * Demographics � 169 LOC 7 Methods 
 * 
 */
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
    
   
    
    
  /**
   * This method allows a user to select a file from a file chooser
   * @param event
   */
    @FXML
    void selectFilePlacementCSV(ActionEvent event) {
    	GeneralMethods.configureFileChooser(fileChooser);
    	File fileCSV = fileChooser.showOpenDialog(Main.getStage());
    	if(fileCSV!=null){
    		file = fileCSV;
    	}
    	PlacementCSVFilePath.setText(file.getAbsolutePath());
    }
    
    /**
     * Method below will upload the CSV from the file path into the 'Placement' table in the database 
     * @param event
     */
    @FXML
    void uploadPlacementsCSV(ActionEvent event) {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(PlacementCSVFilePath);
		fields.add(Year);
		
		if(ApplicationMethods.noNullValues(fields)){
    	String path = PlacementCSVFilePath.getText();
    	
    	List<Placement> placementList = new ArrayList<Placement>();
    	boolean error = false;
    		
    	    int year = Year.getValue();
    		try {
				placementList= CSV.readPlacementsFromCSV(path, year);
				
			} catch (IOException e1) {
				GeneralMethods.show(e1.getLocalizedMessage(), "Error");
			}

    		
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
    }
    
    /**
     * This method will delete an entire year of placements
     * @param event
     * @throws Exception
     */
    @FXML
    void DeleteYear(ActionEvent event) throws Exception {
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(Year);
		if(ApplicationMethods.noNullValues(fields)){
    	PlacementSQL.DeleteYearPlacement(String.valueOf(Year.getValue()));
    	GeneralMethods.show("DELETED ALL FOR YEAR", "DELETED ALL FOR YEAR");
    }}
    /**
     * This method will return the user to the main menu
     * @param event
     * @throws Exception
     */
    @FXML
    void returnMainMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu","MainMenu");
    }
    /**
     * This method will return the user to the practical menu
     * @param event
     * @throws Exception
     */
    @FXML
    void returnPracticalMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("PracticalMenuController", "PracticalPlacementMenu");
    }
    
    /**
     * This method will download the placement list on the server to a CSV sheer
     * @param event
     * @throws SQLException 
     * @throws IOException 
     */
    @FXML
    void downloadCSVList(ActionEvent event) throws IOException, SQLException{
List<javafx.scene.control.Control> fields = new ArrayList<javafx.scene.control.Control>();
		
		fields.add(Year);
		
		
		if(ApplicationMethods.noNullValues(fields)){
    		File f =PlacementSQL.downloadToCSV(Year.getValue().toString());
    		
    		Desktop.getDesktop().open(f);
    	}
    }
    
    /**
     * This method will initialize before the screen loads up by adding an image and populating a combobox
     */
    @FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	ApplicationMethods.Years(Year);
    }
}