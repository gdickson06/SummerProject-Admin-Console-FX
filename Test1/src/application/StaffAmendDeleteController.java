package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.objects.Coordinator;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.Student;
import uk.ac.qub.objects.User;
import uk.ac.qub.sql.SearchQueries;

public class StaffAmendDeleteController {
	
	protected static User u;
	protected static Coordinator c;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> Type;

    @FXML
    private Button FirstNameSearch;

    @FXML
    private TextField FirstName;

    @FXML
    private Button LastNameSearch;

    @FXML
    private ListView<Staff> UserTable;

    @FXML
    private Button StaffNumberSearch;

    @FXML
    private Button TypeSearch;

    @FXML
    private TextField LastName;
    
    @FXML
    private TextField Username;

    @FXML
    private Button UserNameSearch;

    @FXML
    void TypeSearch(ActionEvent event) {
    	List<Staff> searched = SearchQueries.searchStaff(4, Type.getValue(),false);
		ObservableList<Staff> list = FXCollections.observableArrayList();
		list.addAll(searched);
		UserTable.setItems(list);
		System.out.println(searched.size());
    }

    @FXML
    void FirstNameSearch(ActionEvent event)throws Exception {
    	List<Staff> searched = SearchQueries.searchStaff(1, FirstName.getText(),true);
		ObservableList<Staff> list = FXCollections.observableArrayList();
		list.addAll(searched);
		UserTable.setItems(list);
		System.out.println(searched.size());
    }

    @FXML
    void LastNameSearch(ActionEvent event) {
    	List<Staff> searched = SearchQueries.searchStaff(2, LastName.getText(),true);
		ObservableList<Staff> list = FXCollections.observableArrayList();
		list.addAll(searched);
		UserTable.setItems(list);
		System.out.println(searched.size());
    }

    @FXML
    void ListClick(MouseEvent event) throws Exception {
    	 if(event.getClickCount()==2){
    		 
    		 if(UserTable.getSelectionModel().getSelectedItem() instanceof User){
    		 u=(User) UserTable.getSelectionModel().getSelectedItem();
    		 System.out.println("clicked on " + u);
    		 } else {
    			 c=(Coordinator) UserTable.getSelectionModel().getSelectedItem();
        		 System.out.println("clicked on " + c);
    		 }
    	    }
    }

    @FXML
    void UserNameSearch(ActionEvent event) {
    	List<Staff> searched = SearchQueries.searchStaff(3, Username.getText(),true);
		ObservableList<Staff> list = FXCollections.observableArrayList();
		list.addAll(searched);
		UserTable.setItems(list);
		System.out.println(searched.size());
    }
    
    @FXML
    void StaffAmmendDeleteHome(ActionEvent event){
    	try {
			GeneralMethods.ChangeScene("mainMenu");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    

    @FXML
    void initialize() {
List<String>types= new ArrayList<String>();
    	
    	types.add("Administrator");
    	types.add("Module Coordinator");
    	types.add("Lecturer");
    	
    	Type.getItems().addAll(types);
        assert Type != null : "fx:id=\"Type\" was not injected: check your FXML file 'StaffAmendDelete.fxml'.";
        assert FirstNameSearch != null : "fx:id=\"FirstNameSearch\" was not injected: check your FXML file 'StaffAmendDelete.fxml'.";
        assert Username != null : "fx:id=\"StaffNumber\" was not injected: check your FXML file 'StaffAmendDelete.fxml'.";
        assert FirstName != null : "fx:id=\"FirstName\" was not injected: check your FXML file 'StaffAmendDelete.fxml'.";
        assert LastNameSearch != null : "fx:id=\"LastNameSearch\" was not injected: check your FXML file 'StaffAmendDelete.fxml'.";
        assert UserTable != null : "fx:id=\"UserTable\" was not injected: check your FXML file 'StaffAmendDelete.fxml'.";
        assert StaffNumberSearch != null : "fx:id=\"StaffNumberSearch\" was not injected: check your FXML file 'StaffAmendDelete.fxml'.";
        assert TypeSearch != null : "fx:id=\"TypeSearch\" was not injected: check your FXML file 'StaffAmendDelete.fxml'.";
        assert LastName != null : "fx:id=\"LastName\" was not injected: check your FXML file 'StaffAmendDelete.fxml'.";
        assert UserNameSearch != null : "fx:id=\"UserNameSearch\" was not injected: check your FXML file 'StaffAmendDelete.fxml'.";

    }
}

