package pmh_system.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Dashboard implements Initializable {
    @FXML
    private AnchorPane anc;
    @FXML
    private Button addApps, reports, btnOverview, viewApps, makePayment, settings, signOut;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void handleClicks(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == addApps) {

            AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/personal.fxml"));
            anc.getChildren().setAll(pane);
        }
        if (actionEvent.getSource() == viewApps){
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/applicants.fxml"));
            anc.getChildren().setAll(pane);
        }
        if (actionEvent.getSource() == reports) {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/basic_report.fxml"));
            anc.getChildren().setAll(pane);
        }
        if (actionEvent.getSource() == btnOverview) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Feature not yet supported!!!");
            alert.show();
        }
        if(actionEvent.getSource()== makePayment) {
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/pay.fxml"));
            anc.getChildren().setAll(pane);
        }
        if (actionEvent.getSource() == settings) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Feature not yet supported!!!");
            alert.show();
        }
        if(actionEvent.getSource()== signOut) {
            signOut.setOnAction(event->{
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Feature not yet supported!");
                alert.showAndWait();
            });
        }
    }
}