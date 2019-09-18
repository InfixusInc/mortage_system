package pmh_system.controller;

import com.itextpdf.text.DocumentException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import pmh_system.pdf.DocumentCreator;

import java.io.IOException;

public class Printer {
    @FXML
    private AnchorPane anc;

    public void printForm(ActionEvent e) throws IOException, DocumentException {
        DocumentCreator documentCreator = new DocumentCreator();
        documentCreator.formBuild();

        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/pay.fxml"));
        anc.getChildren().setAll(pane);
    }

    public void dashboard(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/pmh_system/views/dashboard.fxml"));
        anc.getChildren().setAll(pane);
    }
}