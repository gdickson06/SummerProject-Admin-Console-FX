package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button studentUploadCSVButton;
    
    @FXML
    private Button PlacementUploadCSVButton;
    
    @FXML
    private Button PlacementAmmendDeleteButton;

    @FXML
    private Button InputPDF;

    @FXML
    private Button ChangePassword;

    @FXML
    private Button Help;

    @FXML
    private Button practicalUploadCSV;

    @FXML
    private Button SearchAbsence;

    @FXML
    private Button uploadSingleStudentButton;

    @FXML
    private Button UploadSingleStaff;

    @FXML
    private Button AbsenceAmendDelete;

    @FXML
    private Button studentAmmendDelete;

    @FXML
    private Button StaffAmendDelete;

    @FXML
    private Button LectureUploadSingle;

    @FXML
    private Button PracticalUploadSingle;

    @FXML
    private Button AbsenceUploadSingle;

    @FXML
    private Button RoomUploadSingle;

    @FXML
    private Button AbsenceTrends;

    @FXML
    private Button lectureUploadCSV;

    @FXML
    private Button PracticalAmendDelete;

    @FXML
    private Button AmendDeleteRoom;

    @FXML
    private Button CreatePDF;

    @FXML
    private Button Lectures;

    @FXML
    private Button roomUploadCSV;

    @FXML
    private Button Practicals;

    @FXML
    private Button staffUploadCSV;

    @FXML
    private Button LectureAmendDelete;

    @FXML
    void uploadStudentCSV(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("UploadCSVStudent");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void studentAmmendDeleteButton(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("StudentAmmendDelete");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void uploadSingleStudentClick(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("UploadSingleStudent");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void lectureUploadCSVButton(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("UploadCSVLecture");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void LectureAmendDelete(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("LectureAmendDelete");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void LectureUploadSingle(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("UploadSingleLecture");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void practicalUploadCSVButton(ActionEvent event) {

    }

    @FXML
    void practicalAmendDelete(ActionEvent event) {

    }

    @FXML
    void practicalUploadSingle(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSinglePlacement");
    }

    @FXML
    void roomUploadCSVButton(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadCSVRoom");
    }

    @FXML
    void AmendDeleteRoom(ActionEvent event) throws Exception {
    	//changing scene
    	GeneralMethods.ChangeScene("SearchRoomAmmendDelete");
    }

    @FXML
    void RoomUploadSingle(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleRoom");
    }

    @FXML
    void AbsenceAmendDelete(ActionEvent event) {

    }

    @FXML
    void AbsenceUploadSingle(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleAbsence");
    }

    @FXML
    void SearchAbsence(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("AbsenceAmendDelete");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void AbsenceTrends(ActionEvent event) {

    }

    @FXML
    void CreatePDF(ActionEvent event) {

    }

    @FXML
    void InputPDF(ActionEvent event) {

    }

    @FXML
    void staffUploadCSVButton(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("UploadCSVStaff");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void StaffAmendDelete(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("StaffAmendDelete");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    void UploadSingleStaff(ActionEvent event) {
    	try {
			GeneralMethods.ChangeScene("UploadSingleStaff");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void PlacementCSVButton(ActionEvent event){
    	try {
			GeneralMethods.ChangeScene("UploadCSVPlacement");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @FXML
    void PlacementAmmendDeleteButtonClick(ActionEvent event){
    	
    }

    @FXML
    void Help(ActionEvent event) {

    }

    @FXML
    void LectureNotes(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("NoteLecture");
    }

    @FXML
    void PracticalNotes(ActionEvent event) {

    }

    @FXML
    void ChangePassword(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert studentUploadCSVButton != null : "fx:id=\"studentUploadCSVButton\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert InputPDF != null : "fx:id=\"InputPDF\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert ChangePassword != null : "fx:id=\"ChangePassword\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert Help != null : "fx:id=\"Help\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert practicalUploadCSV != null : "fx:id=\"practicalUploadCSV\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert SearchAbsence != null : "fx:id=\"SearchAbsence\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert uploadSingleStudentButton != null : "fx:id=\"uploadSingleStudentButton\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert UploadSingleStaff != null : "fx:id=\"UploadSingleStaff\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert AbsenceAmendDelete != null : "fx:id=\"AbsenceAmendDelete\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert studentAmmendDelete != null : "fx:id=\"studentAmmendDelete\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert StaffAmendDelete != null : "fx:id=\"StaffDeleteUser\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert LectureUploadSingle != null : "fx:id=\"LectureUploadSingle\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert PracticalUploadSingle != null : "fx:id=\"PracticalUploadSingle\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert AbsenceUploadSingle != null : "fx:id=\"AbsenceUploadSingle\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert RoomUploadSingle != null : "fx:id=\"RoomUploadSingle\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert AbsenceTrends != null : "fx:id=\"AbsenceTrends\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert lectureUploadCSV != null : "fx:id=\"lectureUploadCSV\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert PracticalAmendDelete != null : "fx:id=\"PracticalAmendDelete\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert AmendDeleteRoom != null : "fx:id=\"AmendDeleteRoom\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert CreatePDF != null : "fx:id=\"CreatePDF\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert Lectures != null : "fx:id=\"Lectures\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert roomUploadCSV != null : "fx:id=\"roomUploadCSV\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert Practicals != null : "fx:id=\"Practicals\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert staffUploadCSV != null : "fx:id=\"staffUploadCSV\" was not injected: check your FXML file 'mainMenu.fxml'.";
        assert LectureAmendDelete != null : "fx:id=\"LectureAmendDelete\" was not injected: check your FXML file 'mainMenu.fxml'.";

    }
}
