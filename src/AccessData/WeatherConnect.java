package AccessData;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WeatherConnect {



    private static String BASE_URL="http://dataservice.accuweather.com/forecasts/v1/daily/5day/";

    //private static String cityID="274663";

    private static String API_KEY = "?apikey=";

    private static String language="&language=pl-PL";

    private static String PARAM_METRIC = "&metric=true";


public static URL buildURLToResponse(String cityID){

    URL url=null;
    StringBuilder stringBuilder=new StringBuilder(BASE_URL);

    stringBuilder.append(cityID);
    stringBuilder.append(API_KEY);
    stringBuilder.append(language);
    stringBuilder.append(PARAM_METRIC);

    try {
        url=new URL(stringBuilder.toString());
    } catch (MalformedURLException e) {
        e.printStackTrace();
    }
    return url;
}

public static String getResponseFromURL(URL url) throws IOException {
    HttpURLConnection httpURLConnection = null;
    try {
        httpURLConnection = (HttpURLConnection) url.openConnection();

    } catch (IOException e) {
        e.printStackTrace();
    }

    try {
        InputStream in = httpURLConnection.getInputStream();

        Scanner scanner = new Scanner(in);
        scanner.useDelimiter("\\A");

        boolean hasInput = scanner.hasNext();
        if(hasInput) {
            return scanner.next();
        } else {
            return null;
        }

    }finally {
        httpURLConnection.disconnect();
    }

}





}
