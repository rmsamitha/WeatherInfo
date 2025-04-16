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
 * ForecastInfo class represents the weather forecast information for a specific city.
 * It contains details such as temperature, humidity, wind speed, precipitation probability,
 * thunderstorm probability, and the date and time of the forecast.
 */
public class ForecastInfo {
    private String cityName;
    private int temperature;
    private int humidity;
    private int windSpeed;
    private int precipitationProb;
    private int thunderstormProb;
    private String dateTime;
    private float latitude;
    private float longitude;

    public ForecastInfo(String cityName, int temperature, int precipitation, int humidity, int windSpeed,
                        int precipitationProb, int thunderstormProb, String dateTime, float latitude, float longitude) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.precipitationProb = precipitationProb;
        this.thunderstormProb = thunderstormProb;
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

    public int getPrecipitationProb() {
        return precipitationProb;
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

    public int getThunderstormProb() {
        return thunderstormProb;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public void setPrecipitationProb(int precipitationProb) {
        this.precipitationProb = precipitationProb;
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

    public void setThunderstormProb(int thunderstormProb) {
        this.thunderstormProb = thunderstormProb;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
