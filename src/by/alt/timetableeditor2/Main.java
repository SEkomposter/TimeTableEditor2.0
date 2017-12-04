package by.alt.timetableeditor2;

import by.alt.timetableeditor2.Object.MainForm;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    private Parent root;
    @Override
    public void start(Stage primaryStage) throws Exception{
        new MainForm();
        root = FXMLLoader.load(getClass().getResource("./fxml/mainframe.fxml"));
        primaryStage.setTitle("Редактор расписаний");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.setMinHeight(500);
        primaryStage.setMinWidth(700);
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }

}
