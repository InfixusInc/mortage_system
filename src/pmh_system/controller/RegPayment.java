package pmh_system.controller;

import com.itextpdf.text.DocumentException;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import pmh_system.Main;
import pmh_system.database.DatabaseHandler;
import pmh_system.pdf.ReceiptCreator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static pmh_system.Main.exchangeRate;
import static pmh_system.Main.initialAmount;

public class RegPayment implements Initializable {
    private Status status = new Status();
    private ObservableList<String> methods = FXCollections.observableArrayList();
    private ObservableList<String> currencies = FXCollections.observableArrayList();
    @FXML
    private JFXComboBox method, currency;
    @FXML
    private JFXTextField accountHolder, apId, rate, account, amount;
    @FXML
    private Label equivalent;
    @FXML
    private AnchorPane anc;

    private void filling() {
        methods.add("Cash");
        methods.add("Ecocash");
        methods.add("Transfer");

        currencies.add("GBP");
        currencies.add("US$");
        currencies.add("ZAR");
        currencies.add("ZWL");

        method.setItems(methods);
        currency.setItems(currencies);
    }

    public void save(ActionEvent event) throws IOException, DocumentException {
        if (String.valueOf(method.getValue()) == "" || String.valueOf(currency.getValue()) == ""
                || amount.getText().isEmpty() || account.getText().isEmpty()
                || rate.getText().isEmpty() || accountHolder.getText().isEmpty()) {

            Alert alert = new Alert(Alert.AlertType.WARNING, "You must fill the required fields !");
            alert.showAndWait();
        } else {
            Main.paymentMethod = String.valueOf(this.method.getValue());
            Main.currencyUsed = String.valueOf(this.currency.getValue());
            Main.client = this.accountHolder.getText();
            Main.accountNo = Integer.parseInt(this.apId.getText());
            Main.exchangeRate = Double.parseDouble(this.rate.getText());
            Main.sortedAccNo = this.account.getText();
            Main.initialAmount = Double.parseDouble(this.amount.getText());
            double answer = Math.abs(initialAmount/exchangeRate);
            equivalent.setText(String.valueOf(answer));
            Main.equivalency = Double.parseDouble(this.equivalent.getText());

            DatabaseHandler dbHandler = new DatabaseHandler();
            dbHandler.makePayment();

            ReceiptCreator receiptCreator = new ReceiptCreator();
            receiptCreator.receiptBuild();

            status.stepCompleted();
            dashboard(event);
        }
    }

    public void dashboard(ActionEvent e) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/dashboard.fxml"));
        anc.getChildren().setAll(pane);
    }

    public void addApplicant(ActionEvent e) throws IOException {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/personal.fxml"));
            anc.getChildren().setAll(pane);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filling();

        NumberValidator numberValidator = new NumberValidator();
        numberValidator.setMessage("Please enter a valid number");
        amount.getValidators().add(numberValidator);
        numberValidator.setMessage("Please enter a valid number");
    }
}