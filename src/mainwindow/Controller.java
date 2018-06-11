package mainwindow;

import AccessData.WeatherConnect;
import AccessData.WeatherService;
import Model.Weather;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable   {

    @FXML
    private ListView<Weather> weatherListView;

    @FXML
    private ListView<String> cityListView;

    @FXML
    private Label cityNameLabel;

    private static List<Weather> weathers;


    private static WeatherService weatherService;

    static String response;

    ObservableList<Weather> weatherObservableList=FXCollections.observableArrayList();

    ObservableList<String> citiesObservableList=FXCollections.observableArrayList("Warszawa","Gdańsk","Elbląg");

    public Controller()   {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        weatherObservableList=weatherListView.getItems();
        weatherObservableList.addAll(weathers);
        weatherListView.setCellFactory(weatherList->new ListCellController());
        cityListView.setItems(citiesObservableList);


    }

    public static void prepare(String cityID) throws IOException{
        URL url=WeatherConnect.buildURLToResponse(cityID);

        response = WeatherConnect.getResponseFromURL(url);
        WeatherService.parseJSON(response);
        weathers=WeatherService.getWeatherArrayList();

    }

    public void changeCity(ActionEvent actionEvent) throws IOException {
        int selectedCity=cityListView.getSelectionModel().getSelectedIndex();

        switch (selectedCity){
            case 0:
                prepare("274663");
                weatherObservableList.clear();
                weatherObservableList.addAll(weathers);
                cityNameLabel.setText("Warszawa");
                break;

            case 1:
                prepare("275174");
                weatherObservableList.clear();
                weatherObservableList.addAll(weathers);
                cityNameLabel.setText("Gdańsk");
                break;

            case 2:
                prepare("266368");
                weatherObservableList.clear();
                weatherObservableList.addAll(weathers);
                cityNameLabel.setText("Elbląg");
                break;
        }
    }


}
