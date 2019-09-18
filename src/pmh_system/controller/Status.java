package pmh_system.controller;

import javafx.animation.PauseTransition;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.load;

public class Status {
    public Stage alert = new Stage();
    private Parent root;

    void loginSuccess() throws IOException {
        root = load(getClass().getResource("/pmh_system/views/reussite.fxml"));
        alert.setTitle("Login Successful");
        alert.setScene(new Scene(root, 362, 149));
        alert.show();
        transition();
    }

    void stepCompleted() throws IOException {
        root = load(getClass().getResource("/pmh_system/views/reussite.fxml"));
        alert.setTitle("Success");
        alert.setScene(new Scene(root, 362, 149));
        alert.show();
        transition();
    }

    void transition() {
        PauseTransition delay = new PauseTransition(Duration.seconds(2));
        delay.setOnFinished(ee -> alert.hide());
        delay.play();
    }
}
