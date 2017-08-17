package application;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import uk.ac.qub.churst.GeneralMethods;
import uk.ac.qub.objects.Coordinator;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.objects.Staff;
import uk.ac.qub.sql.CoordinatorSQL;
import uk.ac.qub.sql.SQL;
import uk.ac.qub.sql.StaffSQL;

public class SelectedUserController {
	
	Staff s = StaffAmendDeleteController.s;
	

    @FXML
    private ImageView Image;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private JFXComboBox<String> Type;

    @FXML
    private Label UserName;


    @FXML
    private JFXTextField EmailText;

    @FXML
    private JFXComboBox<String> ModuleText;

    @FXML
    private JFXTextField Name;

    @FXML
    private JFXTextField Password;
    
    @FXML
    void TypePick(ActionEvent event) {
    	
    	if(Type.getValue().equals("Module Coordinator")){
    		ModuleText.setVisible(true);
    		EmailText.setVisible(true);
    	} else {
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
    	
    	if(Type.getValue().equals("Module Coordinator")&& s instanceof Coordinator || Type.getValue().equals("Administrator")&& s instanceof Staff || Type.getValue().equals("Lecturer")&& s instanceof Staff){
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
    	GeneralMethods.ChangeScene("AmendDeleteStaff","AmendDeleteStaff");
    }

    @FXML
    void Home(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("MainMenu3","MainMenu3");
    }
    
    @FXML
    void ReturnStaffScreen(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StaffMenu","StaffMenu");
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
    	//UserName.setText(s.getStaffNumber());
    	
    	if ( s instanceof Coordinator){
    		ModuleText.setVisible(true);
        	EmailText.setVisible(true);
    		ModuleText.setValue(((Coordinator) s).getModule());
    		EmailText.setText(((Coordinator) s).getEmail());
    		Type.setValue("Module Coordinator");
    	} else if ( s instanceof Staff){
    		Type.setValue(((Staff) s).getType());
    	}
    	
    	System.out.println(Type.getValue());
   
    	javafx.scene.image.Image i = new javafx.scene.image.Image("file:resources/qublogo.png");
    	Image.setImage(i);
    }
}
