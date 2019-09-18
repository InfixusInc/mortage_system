package pmh_system.controller;

import com.jfoenix.controls.JFXAutoCompletePopup;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class Employ implements Initializable {
    private Status status = new Status();
    private ObservableList<String> statuses = FXCollections.observableArrayList();
    private ObservableList<String> locales = FXCollections.observableArrayList();
    private ObservableList<String> sizes = FXCollections.observableArrayList();
    private ObservableList<String> rooms = FXCollections.observableArrayList();
    private ObservableList<String> years = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox employment, locality, size, room, year;
    @FXML
    private JFXTextField companyNameText, companyPhoneText;
    @FXML
    private AnchorPane anc;

    private void filling() {
        statuses.add("Employed");
        statuses.add("Self-Employed");
        statuses.add("Business Owner");
        statuses.add("Unemployed");

        locales.add("Westlea, Harare");
        locales.add("Zimre Park , Harare");
        locales.add("Eastview , Harare");
        locales.add("Somerby Subdivision 2 , Harare");
        locales.add("Southlea Park , Harare");
        locales.add("Budiriro Extension , Harare");
        locales.add("Edinburgh Subdivision 6, Harare");
        locales.add("Upper Rangemore, Bulawayo ");
        locales.add("Lower Rangemore, Bulawayo ");
        locales.add("Fortune Medowlands, Gweru");
        locales.add("Mbuya Maria, Mutare");
        locales.add("Alves of Eden, Chinhoyi");
        locales.add("Yellow city, Marondera");

        sizes.add("150 m");
        sizes.add("200 m");
        sizes.add("250 m");
        sizes.add("300 m");
        sizes.add("350 m");
        sizes.add("400 m");
        sizes.add("450 m");
        sizes.add("500 m");
        sizes.add("550 m");
        sizes.add("600 m");

        rooms.add("N/A");
        rooms.add("2 Roomed");
        rooms.add("3 Roomed");
        rooms.add("4 Roomed");
        rooms.add("5 Roomed");

        years.add("Five Years");
        years.add("Ten Years");
        years.add("Fifteen Years");
        years.add("Twenty Years");
        years.add("Twenty Five Years");
        years.add("Thirty Years");

        employment.setItems(statuses);
        locality.setItems(locales);
        size.setItems(sizes);
        room.setItems(rooms);
        year.setItems(years);
    }

    public void next(ActionEvent e) throws IOException {
        if (String.valueOf(employment.getValue()).equals("null") || companyNameText.getText().isEmpty()
                || companyPhoneText.getText().isEmpty() || String.valueOf(locality.getValue()).equals("null")
                || String.valueOf(size.getValue()).equals("null")
                || String.valueOf(room.getValue()).equals("null")
                || String.valueOf(year.getValue()).equals("null")) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill the required fields !");
            alert.showAndWait();
        } else {
            Main.employmentStatus = String.valueOf(employment.getValue());
            Main.companyName = companyNameText.getText();
            Main.companyPhone = companyPhoneText.getText();
            Main.preferredLocality = String.valueOf(locality.getValue());
            Main.standSize = String.valueOf(size.getValue());
            Main.houseType = String.valueOf(room.getValue());
//            String timeInYears = "Years";
            Main.repaymentPeriod = String.valueOf(year.getValue());


            status.stepCompleted();

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/kindred.fxml"));
            anc.getChildren().setAll(pane);
        }
    }

    private void calculate() {

    }

    public void dashboard(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/dashboard.fxml"));
        anc.getChildren().setAll(pane);
    }

    public void last(ActionEvent e) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/personal.fxml"));
        anc.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filling();
        JFXAutoCompletePopup<String> autoCompletePopup = new JFXAutoCompletePopup<>();
        autoCompletePopup.getSuggestions().addAll("N/A");

        autoCompletePopup.setSelectionHandler(event -> {
            companyNameText.setText(event.getObject());
            companyPhoneText.setText(event.getObject());
        });
        companyNameText.textProperty().addListener(observable -> {
            autoCompletePopup.filter(String -> String.contains(companyNameText.getText()));
            if (autoCompletePopup.getFilteredSuggestions().isEmpty() || companyNameText.getText().isEmpty()) {
                autoCompletePopup.hide();
            } else {
                autoCompletePopup.show(companyNameText);
            }
        });
        companyPhoneText.textProperty().addListener(observable -> {
            autoCompletePopup.filter(String -> String.contains(companyPhoneText.getText()));
            if (autoCompletePopup.getFilteredSuggestions().isEmpty() || companyPhoneText.getText().isEmpty()){
                autoCompletePopup.hide();
            } else {
                autoCompletePopup.show(companyPhoneText);
            }
        });
//        RequiredFieldValidator validator = new RequiredFieldValidator();
//        companyNameText.getValidators().add(validator);
//        validator.setMessage("Company firstName is required!!!");
//        companyPhoneText.getValidators().add(validator);
//        validator.setMessage("Company Phone is required!!!");
    }
}