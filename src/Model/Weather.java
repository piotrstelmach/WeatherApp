package Model;

public class Weather {
    private String date;
    private String minTemperature;
    private String maxTemperature;
    private String imgDayWeatherNumber;
    private String imgNightWeatherNumber;
    private String linkToWeather;
    private String dayPhrase;
    private String nightPhrase;

    public Weather() {
    }

    public String getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(String minTemperature) {
        this.minTemperature = minTemperature;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }


    public String getLinktoWeather() {
        return linkToWeather;
    }

    public void setLinkToWeather(String linkToWeather) {
        this.linkToWeather = linkToWeather;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getImgDayWeatherNumber() {
        return imgDayWeatherNumber;
    }

    public void setImgDayWeatherNumber(String imgDayWeatherNumber) {
        this.imgDayWeatherNumber = imgDayWeatherNumber;
    }

    public String getImgNightWeatherNumber() {
        return imgNightWeatherNumber;
    }

    public void setImgNightWeatherNumber(String imgNightWeatherNumber) {
        this.imgNightWeatherNumber = imgNightWeatherNumber;
    }

    public String getDayPhrase() {
        return dayPhrase;
    }

    public void setDayPhrase(String dayPhrase) {
        this.dayPhrase = dayPhrase;
    }

    public String getNightPhrase() {
        return nightPhrase;
    }

    public void setNightPhrase(String nightPhrase) {
        this.nightPhrase = nightPhrase;
    }
}


