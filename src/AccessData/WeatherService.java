package AccessData;

import Model.Weather;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class WeatherService {

    private static List<Weather> weatherArrayList;

    private static String imageUrlBase="http://developer.accuweather.com/sites/default/files/";

    private static String imageUrlEnd="-s.png";


    public static void parseJSON(String result){

        try {
            weatherArrayList=new ArrayList<>();
            if (weatherArrayList != null) {
                weatherArrayList.clear();
            }

            if (result != null) {
                JSONObject rootObj = new JSONObject(result);
                JSONArray resultsArray = rootObj.getJSONArray("DailyForecasts");

                for (int i = 0; i < resultsArray.length(); i++) {
                    Weather weather = new Weather();

                    JSONObject resultObj = resultsArray.getJSONObject(i);

                    String date = resultObj.getString("Date");
                    weather.setDate(date);

                    JSONObject temperatureObj = resultObj.getJSONObject("Temperature");

                    int minTemp =temperatureObj.getJSONObject("Minimum").getInt("Value");
                    weather.setMinTemperature(String.valueOf(minTemp));

                    int maxTemp =temperatureObj.getJSONObject("Maximum").getInt("Value");
                    weather.setMaxTemperature(String.valueOf(maxTemp));

                    //weather icon
                    int dayIcon =resultObj.getJSONObject("Day").getInt("Icon");
                    weather.setImgDayWeatherNumber(String.valueOf(dayIcon));

                    String dayPhrase = resultObj.getJSONObject("Day").getString("IconPhrase");
                    weather.setDayPhrase(dayPhrase);

                    int nightIcon =resultObj.getJSONObject("Night").getInt("Icon");
                    weather.setImgNightWeatherNumber(String.valueOf(nightIcon));

                    String nightPhrase =resultObj.getJSONObject("Night").getString("IconPhrase");
                    weather.setNightPhrase(nightPhrase);

                    //JSONObject night = resultObj.getJSONObject("Night");


                    String link = resultObj.getString("Link");
                    weather.setLinkToWeather(link);

                    weatherArrayList.add(weather);
                }

            }



        }catch (JSONException e){
            e.printStackTrace();
        }


    }

    public static List<Weather> getWeatherArrayList() {
        return weatherArrayList;
    }



    public String weatherImageToString(String imageNumber){
        StringBuilder stringBuilder=new StringBuilder(imageUrlBase);
        int imgNum=Integer.parseInt(imageNumber);
        if(imgNum>1&&imgNum<=9) imageNumber="0"+imageNumber;
        stringBuilder.append(imageNumber);
        stringBuilder.append(imageUrlEnd);
        String result=stringBuilder.toString();

        return result;
    }
}
