package pmh_system.controller;

import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import pmh_system.Main;
import pmh_system.database.DatabaseHandler;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Official implements Initializable {
    private Status status = new Status();

    @FXML
    private JFXTextField loanValueText, propertyValueText, monthlySubText;
    @FXML
    private AnchorPane anc;

    public void next(ActionEvent e) throws IOException {
        if (loanValueText.getText().isEmpty() || propertyValueText.getText().isEmpty()
                || monthlySubText.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING, "You must fill the required fields !");
            alert.showAndWait();
        } else {
            Main.loanValue = Double.parseDouble(loanValueText.getText());
            Main.propertyValue = Double.parseDouble(propertyValueText.getText());
            Main.monthlySubscription = Double.parseDouble(monthlySubText.getText());

            DatabaseHandler dbHandler = new DatabaseHandler();
            dbHandler.registerApplicant();

            status.stepCompleted();

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/printer.fxml"));
            anc.getChildren().setAll(pane);
        }
    }

    public void dashboard(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/dashboard.fxml"));
        anc.getChildren().setAll(pane);
    }

    public void last(ActionEvent e) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/kindred.fxml"));
        anc.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        NumberValidator numberValidator = new NumberValidator();

//        loanValueText.getValidators().add(numberValidator);
//        numberValidator.setMessage("Please enter a valid number");
//        loanValueText.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue){
//                loanValueText.validate();
//            }
//        });
//        propertyValueText.getValidators().add(numberValidator);
//        numberValidator.setMessage("Please enter a valid number");
//        propertyValueText.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue){
//                propertyValueText.validate();
//            }
//        });
//        monthlySubText.getValidators().add(numberValidator);
//        numberValidator.setMessage("Please enter a valid number");
//        monthlySubText.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue){
//                loanValueText.validate();
//            }
//        });
//        insuranceText.getValidators().add(numberValidator);
    }
}