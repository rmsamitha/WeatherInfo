/*
 * Copyright 2025 Samitha Chathuranga
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sam.weather.models;

/**
 * WeatherInfo class represents the weather information for a specific city.
 * It contains details such as temperature, precipitation, humidity, and wind speed.
 */
public class WeatherInfo {
    private String cityName;
    private int temperature;
    private int precipitation;
    private int humidity;
    private int windSpeed;
    private String dateTime;

    private String longitude;
    private String latitude;

    public WeatherInfo(String cityName, int temperature, int precipitation, int humidity, int windSpeed,
                       String dateTime, String latitude, String longitude) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.precipitation = precipitation;
        this.humidity = humidity;
        this.windSpeed = windSpeed;
        this.dateTime = dateTime;
        this.latitude = latitude;
        this.longitude = longitude;
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

    public String getDateTime() {
        return dateTime;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setPrecipitation(int precipitation) {
        this.precipitation = precipitation;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public void setWindSpeed(int windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
