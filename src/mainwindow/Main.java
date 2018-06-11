package mainwindow;


import AccessData.WeatherConnect;
import AccessData.WeatherService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Controller.prepare("274663");
        Parent root = FXMLLoader.load(getClass().getResource("MainWindow.fxml"));
        primaryStage.setTitle("5 - days weather");
        primaryStage.setScene(new Scene(root, 750, 800));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

}
