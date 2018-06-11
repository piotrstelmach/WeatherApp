package mainwindow;

import AccessData.WeatherService;
import Model.Weather;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ListCellController extends ListCell<Weather> {

    @FXML
    private Label dateLabel;

    @FXML
    private Label minTempLabel;

    @FXML
    private Label maxTempLabel;

    @FXML
    private  Label dayPhraseLabel;

    @FXML
    private Label nightPhraseLabel;


    @FXML
    private ImageView dayImageView=new ImageView();

    @FXML
    private ImageView nigthImageView=new ImageView();

    @FXML
    private AnchorPane anchorPane;

    private FXMLLoader fxmlLoader;

    private WeatherService weatherService=new WeatherService();

    @Override
    protected void updateItem(Weather item, boolean empty) {
        super.updateItem(item, empty);

        if(empty||item == null){
            setText(null);
            setGraphic(null);
        }else {
            if (fxmlLoader == null) {
                fxmlLoader = new FXMLLoader(getClass().getResource("../mainwindow/ListCell.fxml"));
                fxmlLoader.setController(this);

                try {
                    fxmlLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            dateLabel.setText(item.getDate().substring(0,10));
            minTempLabel.setText(item.getMinTemperature());

            maxTempLabel.setText(item.getMaxTemperature());

            //hyperLink=new Hyperlink(item.getLinktoWeather());

            //linkLabel.setText(item.getLinktoWeather());

            String dayImagePath=weatherService.weatherImageToString(item.getImgDayWeatherNumber());

            Image dayImage=new Image(dayImagePath);

            dayImageView.setImage(dayImage);

            String nightImagePath=weatherService.weatherImageToString(item.getImgNightWeatherNumber());

            Image nightImage=new Image(nightImagePath);

            nigthImageView.setImage(nightImage);

            dayPhraseLabel.setText(item.getDayPhrase());

            nightPhraseLabel.setText(item.getNightPhrase());




            setText(null);
            setGraphic(anchorPane);
        }
    }


}
