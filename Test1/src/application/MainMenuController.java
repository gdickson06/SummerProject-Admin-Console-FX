package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {

    @FXML
    private Button studentUploadCSVButton;

    @FXML
    private Button InputPDF;

    @FXML
    private Button AbsenceUploadSingle;

    @FXML
    private Button Help;

    @FXML
    private Button RoomUploadSingle;

    @FXML
    private Button AmendDeleteUser;

    @FXML
    private Button SearchAbsence;

    @FXML
    private Button AbsenceTrends;

    @FXML
    private Button lectureUploadCSV;

    @FXML
    private Button AmendDeleteRoom;

    @FXML
    private Button CreatePDF;

    @FXML
    private Button LecturerUploadSingle;

    @FXML
    private Button UploadSingleUser;

    @FXML
    private Button uploadSingleStudentButton;

    @FXML
    private Button userUploadCSV;

    @FXML
    private Button LecturerAmendDelete;

    @FXML
    private Button roomUploadCSV;

    @FXML
    private Button AbsenceAmendDelete;

    @FXML
    private Button studentAmmendDelete;

    @FXML
    private Button lecturerUploadCSV;

    @FXML
    private Button LectureAmendDelete;

    @FXML
    private Button LectureUploadSingle;

    @FXML
    void uploadStudentCSV(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("uploadCSVMenu");
    }

    @FXML
    void studentAmmendDeleteButton(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("StudentAmmendDelete");
    }

    @FXML
    void uploadSingleStudentClick(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleStudent");
    }

    @FXML
    void lectureUploadCSVButton(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadCSVLecture");
    }

    @FXML
    void LectureAmendDelete(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("LectureAmendDelete");
    }

    @FXML
    void LectureUploadSingle(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadSingleLecture");
    }

    @FXML
    void lecturerUploadCSVButton(ActionEvent event) {

    }

    @FXML
    void LecturerAmendDelete(ActionEvent event) {

    }

    @FXML
    void LecturerUploadSingle(ActionEvent event) {

    }

    @FXML
    void roomUploadCSVButton(ActionEvent event) throws Exception {
    	GeneralMethods.ChangeScene("UploadCSVRoom");
    }

    @FXML
    void AmendDeleteRoom(ActionEvent event) throws Exception {
    	//changing scene
    	GeneralMethods.ChangeScene("RoomAmmendDelete");
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
    void userUploadCSVButton(ActionEvent event) {

    }

    @FXML
    void AmendDeleteUser(ActionEvent event) {

    }

    @FXML
    void UploadSingleUser(ActionEvent event) {

    }

    @FXML
    void Help(ActionEvent event) {

    }

}
