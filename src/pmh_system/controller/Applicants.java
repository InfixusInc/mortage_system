package pmh_system.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;
import javafx.util.StringConverter;
import pmh_system.database.Constants;
import pmh_system.database.DatabaseHandler;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.ResourceBundle;

public class Applicants implements Initializable {
    private ObservableList<ObservableList> data;
    @FXML
    private AnchorPane anc;
    @FXML
    private TableView tableView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        buildData();
//        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);
    }

    //CONNECTION DATABASE
    public void buildData() {
        Connection connection;
        data = FXCollections.observableArrayList();
        try {
            connection = DatabaseHandler.getDbConnection();
            //SQL FOR SELECTING ALL OF CUSTOMER
            String SQL = "SELECT * FROM " + Constants.APPS_TABLE;
            //ResultSet
            ResultSet set = connection.createStatement().executeQuery(SQL);
            // TABLE COLUMN ADDED DYNAMICALLY
            for (int i = 0; i < set.getMetaData().getColumnCount(); i++) {
                //We are using non property style for making dynamic table
                final int j = i;

                TableColumn column = new TableColumn(set.getMetaData().getColumnName(i + 1).toUpperCase());
                    column.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList<String>, String>, ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j)));
                tableView.getColumns().addAll(column);
                System.out.println("Column [" + i + "] ");

                Callback<TableColumn<Map, String>, TableCell<Map, String>> cellFactoryForMap
                        = new Callback<TableColumn<Map, String>, TableCell<Map, String>>() {
                    @Override
                    public TableCell call(TableColumn p) {
                        return new TextFieldTableCell( new StringConverter() {
                            @Override
                            public String toString(Object object) {
                                return object.toString();
                            }

                            @Override
                            public Object fromString(String string) {
                                return string;
                            }
                        });
                    }
                };

                if (j != 1)
                    column.setCellFactory(cellFactoryForMap);
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

            tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object oldValue, Object newValue) {
                //Check whether item is selected and set value of selected item to Label
                if (tableView.getSelectionModel().getSelectedItem() != null) {
                    TableView.TableViewSelectionModel selectionModel = tableView.getSelectionModel();
                    ObservableList selectedCells = selectionModel.getSelectedCells();
                    TablePosition tablePosition = (TablePosition) selectedCells.get(0);
                    Object val = tablePosition.getTableColumn().getCellData(newValue);
                    // commit edition to db
                    System.out.println("Selected Value " + val);
                    System.out.println("Selected row " + newValue);
                }
            }
        });
            connection.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            String msg = "" + e.getMessage();
            Alert alert = new Alert(Alert.AlertType.WARNING, msg);
            alert.showAndWait();
        }
    }

    public void deleteApplicant(ActionEvent event) {

    }

    public void dashboard(ActionEvent e) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/dashboard.fxml"));
        anc.getChildren().setAll(pane);
    }
}