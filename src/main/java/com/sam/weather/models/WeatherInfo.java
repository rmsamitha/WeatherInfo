package com.sam.weather.models;

public class WeatherInfo {
    private String cityName;
    private int temperature;
    private int precipitation;
    private int humidity;
    private int windSpeed;

    public WeatherInfo(String cityName, int temperature, int precipitation, int humidity, int windSpeed) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
    }

    public String getCityName() {
        return cityName;
    }

    public int getTemperature() {
        return temperature;
    }

    public int getPrecipitation() {
        return precipitation;
    }

    public int getHumidity() {
        return humidity;
    }

    public int getWindSpeed() {
        return windSpeed;
    }
}
