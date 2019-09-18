package pmh_system.controller;

import com.jfoenix.controls.*;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import pmh_system.Main;
import pmh_system.validation.Validation;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

import static javafx.fxml.FXMLLoader.load;
import static pmh_system.Main.dob;

public class Personal implements Initializable {
    private Status status = new Status();
    @FXML
    JFXDatePicker birthDate;
    @FXML
    private JFXTextField lastName, firstName, natId, birthCountry, nationality, cell, email;
    @FXML
    private JFXTextArea address;
    @FXML
    private JFXCheckBox male, female, single, married, divorced, widowed;
    @FXML
    private AnchorPane anc;

    public void next(ActionEvent e) throws IOException {
        if (lastName.getText().isEmpty() || firstName.getText().isEmpty() || natId.getText().isEmpty()
                || birthCountry.getText().isEmpty() || nationality.getText().isEmpty()
                || cell.getText().isEmpty() || Objects.equals(birthDate.getValue(), "")
                || address.getText().isEmpty() || (!male.isSelected() && !female.isSelected())
                || (!single.isSelected() && !married.isSelected() && !divorced.isSelected() && !widowed.isSelected())) {

            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill required fields!");
            alert.showAndWait();
        } else {
            Validation validation = new Validation();
            if (validation.isValid("lastName", lastName) || validation.isValid("lastName", firstName)
                    || validation.isValid("id", natId) || validation.isValid("lastName", birthCountry)
                    || validation.isValid("id", nationality) || validation.isValid("mobile", cell)) {
                Main.surname = lastName.getText();
                Main.firstName = firstName.getText();
                Main.natIdNo = natId.getText();
                Main.countryOfBirth = birthCountry.getText();
                Main.nationality = nationality.getText();
                Main.cellNumber = cell.getText();
                Main.email = email.getText();
                Main.physAdd = address.getText();
//                LocalDate localDate = LocalDate.of(2001, Month.JUNE, 1);
                dob = String.valueOf(birthDate.getValue());

                if (male.isSelected())
                    Main.gender = male.getText();
                else
                    Main.gender = female.getText();

                if (single.isSelected())
                    Main.maritalStatus = single.getText();
                else if (married.isSelected())
                    Main.maritalStatus = married.getText();
                else if (divorced.isSelected())
                    Main.maritalStatus = divorced.getText();
                else
                    Main.maritalStatus = widowed.getText();

                status.stepCompleted();

                AnchorPane pane = load(getClass().getResource("/pmh_system/views/employ.fxml"));
                anc.getChildren().setAll(pane);
            }
        }
    }

    public void dashboard(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/dashboard.fxml"));
        anc.getChildren().setAll(pane);
    }

    public void action1(ActionEvent e) {
        if (male.isSelected())
            female.setSelected(false);
    }

    public void action2(ActionEvent e) {
        if (female.isSelected())
            male.setSelected(false);
    }

    public void action3(ActionEvent e) {
        if (single.isSelected()) {
            married.setSelected(false);
            divorced.setSelected(false);
            widowed.setSelected(false);
        }
    }

    public void action4(ActionEvent e) {
        if (married.isSelected()) {
            single.setSelected(false);
            divorced.setSelected(false);
            widowed.setSelected(false);
        }
    }

    public void action5(ActionEvent e) {
        if (divorced.isSelected()) {
            widowed.setSelected(false);
            married.setSelected(false);
            single.setSelected(false);
        }
    }

    public void action6(ActionEvent e) {
        if (widowed.isSelected()) {
            divorced.setSelected(false);
            married.setSelected(false);
            single.setSelected(false);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        JFXAutoCompletePopup<String> popup = new JFXAutoCompletePopup<>();
        popup.getSuggestions().addAll("Zimbabwean", "Zambian", "South African", "Mozambican");
        popup.setSelectionHandler(event -> {
            nationality.setText(event.getObject());
        });
        birthCountry.textProperty().addListener(observable -> {
            if (popup.getFilteredSuggestions().isEmpty() || nationality.getText().isEmpty()){
                popup.hide();
            }  else {
                popup.show(nationality);
            }
        });

        JFXAutoCompletePopup<String> autoCompletePopup = new JFXAutoCompletePopup<>();
        autoCompletePopup.getSuggestions().addAll("Zimbabwe", "Zambia", "South Africa", "Mozambique", "Botswana");
        autoCompletePopup.setSelectionHandler(event -> {
            birthCountry.setText(event.getObject());
        });
        birthCountry.textProperty().addListener(observable -> {
            if (autoCompletePopup.getFilteredSuggestions().isEmpty() || birthCountry.getText().isEmpty()){
                autoCompletePopup.hide();
            } else {
                autoCompletePopup.show(birthCountry);
            }
        });

//        birthDateRange(birthDate, LocalDate.of(1940, Month.JANUARY, 1), LocalDate.of(2001,Month.JANUARY, 1));
        RequiredFieldValidator validator = new RequiredFieldValidator();
        lastName.getValidators().add(validator);
        validator.setMessage("Last firstName is required!!!");
        firstName.getValidators().add(validator);
        validator.setMessage("First firstName is required!!!");
        natId.getValidators().add(validator);
        validator.setMessage("National ID is required!!!");
        birthCountry.getValidators().add(validator);
        validator.setMessage("Country of birth is required!!!");
        nationality.getValidators().add(validator);
        validator.setMessage("Nationality is required!!!");
        cell.getValidators().add(validator);
        validator.setMessage("Cell number is required!!!");
        email.getValidators().add(validator);
        validator.setMessage("Email address is required!!!");
        birthDate.getValidators().add(validator);
        validator.setMessage("Date of birth is required!!!");
        address.getValidators().add(validator);
        validator.setMessage("Address is required!!!");
    }

    private void birthDateRange(JFXDatePicker birthDate, LocalDate minDate, LocalDate maxDate) {
//        final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
//            @Override
//            public DateCell call(final DatePicker datePicker) {
//                return new DateCell() {
//                    @Override
//                    public void updateItem(LocalDate item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (item.isBefore(minDate)) {
//                            setVisible(true);
//                        }else if (item.isAfter(maxDate)) {
//                            setVisible(true);
//                        }
//                    }
//                };
//            }
//        };
//        birthDate.setDayCellFactory(dayCellFactory);
    }
}