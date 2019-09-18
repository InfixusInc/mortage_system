package pmh_system.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import pmh_system.database.DatabaseHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BasicReport implements Initializable {
    private ObservableList<ObservableList> data;
    @FXML
    private AnchorPane anc;
    @FXML
    private TableView tableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildData();
    }

    //CONNECTION DATABASE
    public void buildData() {
        Connection connection;
        data = FXCollections.observableArrayList();
        try {
            connection = DatabaseHandler.getDbConnection();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT DISTINCT surname, firstname, nationalId, standSize, houseType, " +
                    "repaymentPeriod, monthlySubscription FROM  applicants";
//                    + " UNION SELECT DISTINCT initialAmount FROM payments";
            //ResultSet
            ResultSet set = connection.createStatement().executeQuery(SQL);
            // TABLE COLUMN ADDED DYNAMICALLY
            for (int i = 0; i < set.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;

                TableColumn column = new TableColumn(set.getMetaData().getColumnName(i + 1));
                column.setCellValueFactory((Callback<TableColumn.CellDataFeatures
                        <ObservableList<String>, String>, ObservableValue<String>>)
                        param -> new SimpleStringProperty(param.getValue().get(j)));
                tableView.getColumns().addAll(column);
                System.out.println("Column [" + i + "] ");
            }

            // Data added to ObservableList
            while (set.next()) {
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= set.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(set.getString(i));
                }
                System.out.println("Row [1] added " + row);
                data.add(row);
                //FINALLY ADDED TO TableView
                tableView.setItems(data);
            }
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            String msg = "" + e.getMessage();
            Alert alert = new Alert(Alert.AlertType.WARNING, msg);
            alert.showAndWait();
        }
    }

    public void dashboard(ActionEvent e) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/dashboard.fxml"));
        anc.getChildren().setAll(pane);
    }

    public void printReport(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.WARNING, "Feature not yet supported!!!");
        alert.showAndWait();
    }

    public void ageReport(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/age_report.fxml"));
        anc.getChildren().setAll(pane);
    }

    public void customerStatus(ActionEvent event) throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/customer_report.fxml"));
        anc.getChildren().setAll(pane);
    }
}