package pmh_system.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import pmh_system.Main;
import pmh_system.animations.Shaker;
import pmh_system.database.DatabaseHandler;
import pmh_system.model.User;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Login implements Initializable {
    private Status status = new Status();
    private int userId;
    @FXML
    private JFXTextField loginUsername;
    @FXML
    private JFXPasswordField loginPassword;
    @FXML
    private AnchorPane anc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void login(ActionEvent event) throws IOException{
        DatabaseHandler databaseHandler = new DatabaseHandler();
        String loginUser = loginUsername.getText().trim();
        String loginPass = loginPassword.getText().trim();

        User user = new User();
        user.setUserName(loginUser);
        user.setPassword(loginPass);

        ResultSet userRow = databaseHandler.getUser(user);
        int counter = 0;
        try {
            while (userRow.next()) {
                counter++;
                Main.cashier = userRow.getString("name");
                userId = userRow.getInt("userid");
            }

            if (counter == 1) {
                //Take users to Application screen
                status.loginSuccess();

                AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/dashboard.fxml"));
                anc.getChildren().setAll(pane);
            } else {
                Shaker userNameShaker = new Shaker(loginUsername);
                Shaker passwordShaker = new Shaker(loginPassword);
                passwordShaker.shake();
                userNameShaker.shake();

                Alert alert = new Alert(Alert.AlertType.WARNING, "Please enter the correct username &/or password !");
                alert.showAndWait();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            String msg = "" + e.getMessage();
            Alert alert = new Alert(Alert.AlertType.WARNING, msg);
            alert.showAndWait();
        }
    }

    public void signUp(ActionEvent event) throws IOException{
        status.transition();

        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/signup.fxml"));
        anc.getChildren().setAll(pane);
    }
}