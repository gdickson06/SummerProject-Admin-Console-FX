package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Coordinator;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.User;
import uk.ac.qub.sql.CoordinatorSQL;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.StaffSQL;

public class SelectedUserController {
	
	Staff s = StaffAmendDeleteController.s;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button Delete;

    @FXML
    private ComboBox<String> Type;

    @FXML
    private Label UserName;

    @FXML
    private Button Back;

    @FXML
    private Button Change;

    @FXML
    private Button Home;

    @FXML
    private TextField EmailText;

    @FXML
    private ComboBox<String> ModuleText;

    @FXML
    private TextField Name;

    @FXML
    private TextField Password;
    @FXML
    void Typepick(ActionEvent event) {
    	System.out.println(Type.getValue());
    	if(Type.getValue().equals("Module Coordinator")){
    		ModuleText.setVisible(true);
        	EmailText.setVisible(true);
    	} else{
    		ModuleText.setVisible(false);
        	EmailText.setVisible(false);
    	}
    }
    @FXML
    void Change(ActionEvent event) throws Exception {
    	
    	
List<String> attributes = new ArrayList<String>();
    	
    	attributes.add(UserName.getText());
    	attributes.add(Name.getText());
    	attributes.add(EmailText.getText());
		attributes.add(Password.getText());
		attributes.add(ModuleText.getValue());
		attributes.add(Type.getValue());
    	Boolean b = false;
    	
    	if(Type.getValue().equals("Module Coordinator")&& s instanceof Coordinator || Type.getValue().equals("Administrator")&& s instanceof User || Type.getValue().equals("Lecturer")&& s instanceof User){
    		// this means there is not a change of type 
    		
    		b=true;
    	}
    	
    	if(s instanceof Coordinator){
    		System.out.println("c");
    		CoordinatorSQL.amendCoordinator(attributes,b);
    	} else {
    	System.out.println("Stage 1");
    		StaffSQL.amendUser(attributes,b);
    	}
    	
    	GeneralMethods.show("Success", "Success");
    	
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void Delete(ActionEvent event) throws Exception {
    	if( s instanceof Coordinator){
    		CoordinatorSQL.DeleteCoordinator(UserName.getText());
    	} else {
    		StaffSQL.DeleteUser(UserName.getText());
    	}
    }

    @FXML
    void Back(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StaffAmendDelete");
    }

    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("mainMenu");
    }

    @FXML
    void initialize() {
    	
    	ModuleText.setVisible(false);
    	EmailText.setVisible(false);
    	List<String>types= new ArrayList<String>();
    	
    	types.add("Administrator");
    	types.add("Module Coordinator");
    	types.add("Lecturer");
    	
    	Type.getItems().addAll(types);
    	ModuleText.getItems().addAll(SQL.Modules());
    	
    	Name.setText(s.getName());
    	Password.setText(s.getPassword());
    	UserName.setText(s.getStaffNumber());
    	
    	if ( s instanceof Coordinator){
    		ModuleText.setVisible(true);
        	EmailText.setVisible(true);
    		ModuleText.setValue(((Coordinator) s).getModule());
    		EmailText.setText(((Coordinator) s).getEmail());
    		Type.setValue("Module Coordinator");
    	} else if ( s instanceof User){
    		Type.setValue(((User) s).getType());
    	}
    	
    	System.out.println(Type.getValue());
        assert Delete != null : "fx:id=\"Delete\" was not injected: check your FXML file 'SelectedStaff.fxml'.";
        assert Type != null : "fx:id=\"Type\" was not injected: check your FXML file 'SelectedStaff.fxml'.";
        assert UserName != null : "fx:id=\"UserName\" was not injected: check your FXML file 'SelectedStaff.fxml'.";
        assert Back != null : "fx:id=\"Back\" was not injected: check your FXML file 'SelectedStaff.fxml'.";
        assert Change != null : "fx:id=\"Change\" was not injected: check your FXML file 'SelectedStaff.fxml'.";
        assert Home != null : "fx:id=\"Home\" was not injected: check your FXML file 'SelectedStaff.fxml'.";
        assert EmailText != null : "fx:id=\"EmailText\" was not injected: check your FXML file 'SelectedStaff.fxml'.";
        assert ModuleText != null : "fx:id=\"ModuleText\" was not injected: check your FXML file 'SelectedStaff.fxml'.";
        assert Name != null : "fx:id=\"Name\" was not injected: check your FXML file 'SelectedStaff.fxml'.";
        assert Password != null : "fx:id=\"Password\" was not injected: check your FXML file 'SelectedStaff.fxml'.";

    }
}
