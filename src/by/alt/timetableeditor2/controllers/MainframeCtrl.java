package by.alt.timetableeditor2.controllers;

import javafx.event.ActionEvent;
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
        Parent edit = FXMLLoader.load(getClass().getResource("./fxml/edittableform.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(edit, 400, 250));
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(owner);
        Button source = (Button) actionEvent.getSource();
        String fxId = source.getId();
        switch (fxId){
        }
        stage.setTitle("Редактор расписаний");
        stage.setMinHeight(500);
        stage.setMinWidth(700);
        stage.show();
    }
}
