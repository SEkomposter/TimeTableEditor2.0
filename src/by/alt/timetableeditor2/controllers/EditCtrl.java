package by.alt.timetableeditor2.controllers;

import by.alt.timetableeditor2.Object.MainForm;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

import java.awt.*;

public class EditCtrl {
    @FXML
    TextField nameField;
    @FXML
    ComboBox sheduleCombo;
    @FXML
    ComboBox timeFromHr;
    @FXML
    ComboBox timeFromMin;
    @FXML
    ComboBox timeToHr;
    @FXML
    ComboBox timeToMin;

    public EditCtrl(){
        timeFromHr.setItems(MainForm.getHours());
        timeToHr.setItems(MainForm.getHours());
    }
    public void okButtonPressed(ActionEvent actionEvent) {
    }

    public void cancelButtonPressed(ActionEvent actionEvent) {
    }
}
