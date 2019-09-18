package pmh_system.controller;

import com.jfoenix.controls.JFXAutoCompletePopup;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import pmh_system.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static pmh_system.Main.nameOfKin;
import static pmh_system.Main.surnameOfKin;

public class Kindred implements Initializable {
    //    private ObservableList<String> sexes = FXCollections.observableArrayList();
    private Status status = new Status();
    @FXML
    private AnchorPane anc;
    @FXML
    private JFXTextArea kinAddress;
    @FXML
    private JFXTextField kinName, kinSurname, kinNatId, kinPhone, kinDob;
    @FXML
    private JFXTextField id, id1, id2, id3, id4, id5, id6, id7, id8, id9;
    @FXML
    private JFXTextField dob, dob1, dob2, dob3, dob4, dob5, dob6, dob7, dob8, dob9;
    @FXML
    private JFXTextField sex, sex1, sex2, sex3, sex4, sex5, sex6, sex7, sex8, sex9;
    @FXML
    private JFXTextField rel, rel1, rel2, rel3, rel4, rel5, rel6, rel7, rel8, rel9;
    @FXML
    private JFXTextField name, name1, name2, name3, name4, name5, name6, name7, name8, name9;
    @FXML
    private JFXTextField surname, surname1, surname2, surname3, surname4, surname5, surname6, surname7, surname8, surname9;

    private void filling() {
//        sexes.add("Female");
//        sexes.add("Male");
//
//        sex.setItems(sexes);
//        sex1.setItems(sexes);
//        sex2.setItems(sexes);
//        sex3.setItems(sexes);
//        sex4.setItems(sexes);
    }

    public void next(ActionEvent e) throws IOException {
        if (kinName.getText().isEmpty() ||kinSurname.getText().isEmpty() ||kinDob.getText().isEmpty()
                ||kinNatId.getText().isEmpty() ||kinPhone.getText().isEmpty()
                ||kinAddress.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill required fields!");
            alert.showAndWait();
        }
        else {
            nameOfKin = kinName.getText();
            Main.surnameOfKin = kinSurname.getText();
            Main.kinName = nameOfKin + surnameOfKin;
            Main.dobOfKin = kinDob.getText();
            Main.idOfKin = kinNatId.getText();
            Main.phoneOfKin = kinPhone.getText();
            Main.addressOfKin = kinAddress.getText();

            Main.benName = name.getText();
            Main.benSurname = surname.getText();
            Main.benGender = sex.getText();
            Main.benDob = dob.getText();
            Main.benNatId = id.getText();
            Main.benRel = rel.getText();

            Main.benName1 = name1.getText();
            Main.benSurname1 = surname1.getText();
            Main.benGender1 = sex1.getText();
            Main.benDob1 = dob1.getText();
            Main.benNatId1 = id1.getText();
            Main.benRel1 = rel1.getText();

            Main.benName2 = name2.getText();
            Main.benSurname2 = surname2.getText();
            Main.benGender2 = sex2.getText();
            Main.benDob2 = dob2.getText();
            Main.benNatId2 = id2.getText();
            Main.benRel2 = rel2.getText();

            Main.benName3 = name3.getText();
            Main.benSurname3 = surname3.getText();
            Main.benGender3 = sex3.getText();
            Main.benDob3 = dob3.getText();
            Main.benNatId3 = id3.getText();
            Main.benRel3 = rel3.getText();

            Main.benName4 = name4.getText();
            Main.benSurname4 = surname4.getText();
            Main.benGender4 = sex4.getText();
            Main.benDob4 = dob4.getText();
            Main.benNatId4 = id4.getText();
            Main.benRel4 = rel4.getText();

            Main.benName5 = name5.getText();
            Main.benSurname5 = surname5.getText();
            Main.benGender5 = sex5.getText();
            Main.benDob5 = dob5.getText();
            Main.benNatId5 = id5.getText();
            Main.benRel5 = rel5.getText();

            Main.benName6 = name6.getText();
            Main.benSurname6 = surname6.getText();
            Main.benGender6 = sex6.getText();
            Main.benDob6 = dob6.getText();
            Main.benNatId6 = id6.getText();
            Main.benRel6 = rel6.getText();

            Main.benName7 = name7.getText();
            Main.benSurname7 = surname7.getText();
            Main.benGender7 = sex7.getText();
            Main.benDob7 = dob7.getText();
            Main.benNatId7 = id7.getText();
            Main.benRel7 = rel7.getText();

            Main.benName8 = name8.getText();
            Main.benSurname8 = surname8.getText();
            Main.benGender8 = sex8.getText();
            Main.benDob8 = dob8.getText();
            Main.benNatId8 = id8.getText();
            Main.benRel8 = rel8.getText();

            Main.benName9 = name9.getText();
            Main.benSurname9 = surname9.getText();
            Main.benGender9 = sex9.getText();
            Main.benDob9 = dob9.getText();
            Main.benNatId9 = id9.getText();
            Main.benRel9 = rel9.getText();

            status.stepCompleted();
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/official.fxml"));
            anc.getChildren().setAll(pane);
        }
    }

    public void dashboard(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/dashboard.fxml"));
        anc.getChildren().setAll(pane);
    }

    public void last(ActionEvent e) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/premier_system/views/employ.fxml"));
        anc.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        filling();
//        JFXAutoCompletePopup completePopup = new JFXAutoCompletePopup<>();
//        completePopup.getSuggestions().addAll("Female", "Male");
//        completePopup.setSelectionHandler(event -> sex.setText(event.get));
        JFXAutoCompletePopup<String> autoCompletePopup = new JFXAutoCompletePopup<>();
        autoCompletePopup.getSuggestions().addAll("Brother", "Cousin", "Daughter", "Father", "Mother", "Son", "Sister");
        autoCompletePopup.setSelectionHandler(event -> rel.setText(event.getObject()));
        rel.textProperty().addListener(observable -> {
            if (autoCompletePopup.getFilteredSuggestions().isEmpty() || rel.getText().isEmpty()){
                autoCompletePopup.hide();
            } else {
                autoCompletePopup.show(rel);
            }
        });
        rel1.textProperty().addListener(observable -> {
            if (autoCompletePopup.getFilteredSuggestions().isEmpty() ||rel1.getText().isEmpty()) {
                autoCompletePopup.hide();
            } else {
                autoCompletePopup.show(rel1);
            }
        });
    }
}