package pmh_system.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import pmh_system.database.DatabaseHandler;
import pmh_system.model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUp implements Initializable {
    public Status status = new Status();
    private RequiredFieldValidator validator = new RequiredFieldValidator();
    @FXML
    private JFXTextField signUpUsername, fullName, signUpEmail;
    @FXML
    private JFXPasswordField signUpPassword;
    @FXML
    private AnchorPane anc;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        signUpUsername.getValidators().add(validator);
        validator.setMessage("Username is required!!!");
//        signUpUsername.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue) {
//                signUpUsername.validate();
//            }
//        });
//        validator = new RequiredFieldValidator();
//        signUpEmail.getValidators().add(validator);
//        validator.setMessage("Email address is required!!!");
//        signUpEmail.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue) {
//                signUpEmail.validate();
//            }
//        });
//        validator = new RequiredFieldValidator();
//        signUpPassword.getValidators().add(validator);
//        validator.setMessage("Password is required!!!");
//        signUpPassword.focusedProperty().addListener((observable, oldValue, newValue) -> {
//            if (newValue) {
//                signUpUsername.validate();
//            }
//        });
    }

    public void signUp(ActionEvent event) throws IOException {

        if (signUpUsername.getText().isEmpty() || signUpEmail.getText().isEmpty() || fullName.getText().isEmpty() || signUpPassword.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING, "Please fill required fields!");
            alert.showAndWait();
        } else {
            DatabaseHandler databaseHandler = new DatabaseHandler();
            String username = signUpUsername.getText();
            String email = signUpEmail.getText();
            String name = fullName.getText();
            String password = signUpPassword.getText();
            User user = new User(username, email, name, password);
            databaseHandler.signUpUser(user);

            Alert alert = new Alert(Alert.AlertType.WARNING, "Account creation  successful!");
            alert.showAndWait();

            goToLogin();
        }
    }

    public void login(ActionEvent e) throws IOException {
        goToLogin();
    }

    private void goToLogin() throws IOException {
        status.transition();

        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/login.fxml"));
        anc.getChildren().setAll(pane);
    }
}