package application;

import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
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

    }
     private void setAverageColour(XYChart.Data<String, Double> data){
    	 Node node = data.getNode();
    	 if(data.getXValue().equals("Average")){
    		 System.out.println(node);
    		 node.setStyle("-fx-bar-fill: green");
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
     
      
    }
}
