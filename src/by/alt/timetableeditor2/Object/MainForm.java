package by.alt.timetableeditor2.Object;
import by.alt.timetableeditor2.DAO.DaoClass;
import by.alt.timetableeditor2.Object.*;
import by.alt.timetableeditor2.Object.MyTableModel;
import by.alt.timetableeditor2.Object.TableEntry;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Observable;

public class MainForm {
    static ObservableList<TableEntry> tableEntryList = FXCollections.observableArrayList();
    static ObservableList<String> hours = FXCollections.observableArrayList();
    static ObservableList<String> minutes = FXCollections.observableArrayList();
    public static TEntryList userTimeList = new TEntryList();
    public static TEntryList groupTimeList = new TEntryList();
    private static PropReader propReader;

    static{
        propReader = new PropReader();
        for (int i=0;i<=23;i++){
            hours.add(Integer.toString(i));
        }
        for (int i=0;i<12;i++){
            minutes.add(Integer.toString(i*5));
        }
    }

    public static ObservableList<String> getHours() {
        return hours;
    }

    public static ObservableList<String> getMinutes() {
        return minutes;
    }

    public static PropReader getPropReader() {
        return propReader;
    }

    public static ObservableList<TableEntry> getTableEntryList() {
        return tableEntryList;
    }

    public static void setTableEntryList(ObservableList<TableEntry> tableEntryList) {
        MainForm.tableEntryList = tableEntryList;
    }
}
