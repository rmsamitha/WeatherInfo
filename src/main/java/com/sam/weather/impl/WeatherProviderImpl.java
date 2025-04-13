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


package com.sam.weather.impl;

import com.sam.weather.models.WeatherInfo;

public class WeatherProviderImpl {
    private static final String AUCKLAND = "Auckland";
    private static final String WELLINGTON = "Wellington";
    private static final String CHRISTCHURCH = "Christchurch";
    private static final String WAIKATO = "Waikato";

    // Example in-memory weather data for different cities for simulation purposes
    WeatherInfo weatherInfoAuckland = new WeatherInfo(AUCKLAND, 15, 43, 33, 26);
    WeatherInfo weatherInfoWellington = new WeatherInfo(WELLINGTON, 20, 50, 40, 30);
    WeatherInfo weatherInfoChristchurch = new WeatherInfo(CHRISTCHURCH, 10, 30, 20, 15);
    WeatherInfo weatherInfoWaikato = new WeatherInfo(WAIKATO, 10, 30, 23, 33);

    private static final WeatherProviderImpl instance = new WeatherProviderImpl();

    private WeatherProviderImpl() {
    }

    public static WeatherProviderImpl getInstance() {
        return instance;
    }

    /**
     * Retrieves weather data for a given city name.
     *
     * @param cityName Name of the city for which to retrieve weather data.
     * @return WeatherInfo object containing weather data for the specified city.
     */
    public WeatherInfo getWeatherData(String cityName) {
        // TODO: Implement retrieval from persistent storage
        // Simulate fetching weather data from in-memory data
        WeatherInfo weatherInfo = getInMemoryWeatherData(cityName);
        if (weatherInfo == null) {
            // Call to an external REST API to fetch weather data
            weatherInfo = new WeatherInfo(cityName, 15, 43, 33, 26);
        }

        return weatherInfo;
    }

    private WeatherInfo getInMemoryWeatherData(String cityName) {
        if (cityName.equalsIgnoreCase(AUCKLAND)) {
            return weatherInfoAuckland;
        } else if (cityName.equalsIgnoreCase(WELLINGTON)) {
            return weatherInfoWellington;
        } else if (cityName.equalsIgnoreCase(CHRISTCHURCH)) {
            return weatherInfoChristchurch;
        } else if (cityName.equalsIgnoreCase(WAIKATO)) {
            return weatherInfoWaikato;
        } else {
            return null; // No data available for the given city
        }
    }
}
