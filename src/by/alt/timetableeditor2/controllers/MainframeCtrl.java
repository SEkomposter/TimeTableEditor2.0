package by.alt.timetableeditor2.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class MainframeCtrl {
    Window owner;

    public void showEditDialog(ActionEvent actionEvent) throws IOException {
        owner =((Node)actionEvent.getSource()).getScene().getWindow();
        Stage stage = new Stage();
        Parent edit = FXMLLoader.load(getClass().getResource("../fxml/edittableform.fxml"));
        stage.setScene(new Scene(edit, 400, 250));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);
        stage.setResizable(false);
        stage.setTitle("Новое расписание");
        stage.show();
    }
}
