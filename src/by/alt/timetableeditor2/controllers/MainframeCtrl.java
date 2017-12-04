package by.alt.timetableeditor2.controllers;

import by.alt.timetableeditor2.Object.MainForm;
import by.alt.timetableeditor2.Object.PropType;
import by.alt.timetableeditor2.Object.TableEntry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class MainframeCtrl {
    Window owner;
    @FXML
    private TableView table;
    @FXML
    private TableColumn<TableEntry,String> tableName;
    @FXML
    private TableColumn<TableEntry,String> tableShedule;
    @FXML
    private TableColumn<TableEntry,String> tableTimeFrom;
    @FXML
    private TableColumn<TableEntry,String> tableTimeTo;
    @FXML
    private void initialize(){
        tableName.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("name"));
        tableShedule.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("shedule"));
        tableTimeFrom.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("timeFrom"));
        tableTimeTo.setCellValueFactory(new PropertyValueFactory<TableEntry, String>("timeTo"));
        table.setItems(MainForm.getTableEntryList());


    }
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
    public void openMenuAction(ActionEvent actionEvent)throws IOException {
            MainForm.getPropReader().readRepProp();
            MainForm.getTableEntryList().clear();
            MainForm.getTableEntryList().addAll(MainForm.getPropReader().getPropertiesList(PropType.TIMETABLE));
    }

    public void newMenuAction(ActionEvent actionEvent) {
    }

    public void saveMenuAction(ActionEvent actionEvent) {
    }

    public void closeMenuAction(ActionEvent actionEvent) {
    }
}
