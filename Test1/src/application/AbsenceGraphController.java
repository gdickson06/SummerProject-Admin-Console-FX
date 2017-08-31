package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;


import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.chart.BarChart;

import javafx.scene.chart.XYChart;

import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import uk.ac.qub.methods.FileWriter;
import uk.ac.qub.methods.GeneralMethods;

public class AbsenceGraphController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView Image;

   

    @FXML
    private BarChart<String, Double> graph;

    @FXML
    void returnAbsenceTrendsMenu(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("AbsenceTrends", "AbsenceTrends");
    }

    @FXML
    void save(ActionEvent event) {
    	WritableImage snapShot =Main.getStage().getScene().snapshot(null);
    
    	File f = null;
		try {
			
			f = new File (FileWriter.load()+"/barChart.png");
			if(!f.exists()){
			f.createNewFile();
			}
			
		} catch (IOException e1) {
			GeneralMethods.show("Error no save location defined", "Error");
		}
        try {
			ImageIO.write(SwingFXUtils.fromFXImage(snapShot, null), "png", f);
			GeneralMethods.show("File saved in " +FileWriter.load(), "Success");
		} catch (IOException e) {
			GeneralMethods.show("Error in saving image", "Error");
		}
    }
   

   
	@SuppressWarnings("unchecked")
	@FXML
    void initialize() {
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    	XYChart.Series<String, Double> entry = new XYChart.Series<>();
       Map<String, Double> map= absenceTrendsController.trend;
       for(Map.Entry<String, Double> data: map.entrySet()){
    	   
    	   XYChart.Data<String, Double> d = new XYChart.Data<String, Double>(data.getKey(), data.getValue());
    	
    	   entry.getData().add(d);
    	  
       }
       graph.setTitle("Graph of absences per Week Day");
       graph.getData().addAll(entry);
   
       
     graph.setLegendVisible(false);
 
     absenceTrendsController.trend=null;
    }
}
