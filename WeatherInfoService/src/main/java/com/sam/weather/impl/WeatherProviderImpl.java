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
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import javax.ws.rs.core.Response;
import java.io.IOException;

/**
 * WeatherProviderImpl is a singleton class that provides weather data for different cities.
 * It retrieves weather information either from in-memory data or by making an HTTP request to an external API.
 */
public class WeatherProviderImpl {
    private static final String AUCKLAND = "Auckland";
    private static final String WELLINGTON = "Wellington";
    private static final String CHRISTCHURCH = "Christchurch";

    // Example in-memory weather data for different cities for simulation purposes
    WeatherInfo weatherInfoAuckland = new WeatherInfo(AUCKLAND, 15, 43, 33, 26);
    WeatherInfo weatherInfoWellington = new WeatherInfo(WELLINGTON, 20, 50, 40, 30);
    WeatherInfo weatherInfoChristchurch = new WeatherInfo(CHRISTCHURCH, 10, 30, 20, 15);

    private static final WeatherProviderImpl instance = new WeatherProviderImpl();
    String externalWeatherInfoApiUrl = "https://api.openweathermap.org/data/2.5/weather";
    private static final Log log = LogFactory.getLog(WeatherProviderImpl.class);

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
    public Response getWeatherDataByCity(String cityName) {
        if (cityName == null || cityName.isEmpty()) {
            String errorDescription = "City name cannot be null or empty.";
            return WeatherImplUtils.buildBadRequestResponse(errorDescription);
        }
        // TODO: Implement retrieval from persistent storage
        // Simulate fetching weather data from in-memory data
        WeatherInfo weatherInfo = getInMemoryWeatherData(cityName);
        log.debug("Getting weather data for city: " + cityName);

        // If no data is found in memory matching to the hardcoded city names, make an HTTP request to the external API
        if (weatherInfo == null) {
            log.debug("No weather data found for city: " + cityName + ". Making an HTTP request to external API.");
            // Create http client and make a request to an external weather info API
            CloseableHttpClient httpClient = WeatherImplUtils.getHttpClient();
            // appid given is incorrect and will give 401 error
            HttpGet httpGetRequest = new HttpGet(externalWeatherInfoApiUrl + "?q=" + cityName + "&appid" +
                    "=439d4b804bc8187953eb36d2a8c26a02");

            try (CloseableHttpResponse response = httpClient.execute(httpGetRequest)) {
                if (response.getStatusLine().getStatusCode() == 401) { // similar to 200 implementation
                    // Since the external API is not authenticated, it will return 401 always. Hence hardcoded
                    // WeatherInfo object for simulation purposes
                    weatherInfo = new WeatherInfo(cityName, 16, 67, 54, 45);
                } else if (response.getStatusLine().getStatusCode() == 200) {
                    // Here we should ideally parse the response and create a WeatherInfo object from it.
                    weatherInfo = new WeatherInfo(cityName, 16, 67, 54, 45);
                } else {
                    String errorDescription = "Error occurred from the external weather info API: " +
                            response.getStatusLine().getReasonPhrase();
                    return WeatherImplUtils.buildInternalServerErrorResponse(errorDescription);
                }
            } catch (IOException e) {
                String errorDescription = "Error occurred while connecting to external API: " + e.getMessage();
                return WeatherImplUtils.buildBadGatewayResponse(errorDescription);
            }
        }
        return Response.ok().entity(weatherInfo).build();
    }

    /**
     * Retrieves weather data from in-memory storage based on the city name.
     *
     * @param cityName Name of the city for which to retrieve weather data.
     * @return WeatherInfo object containing weather data for the specified city.
     */
    private WeatherInfo getInMemoryWeatherData(String cityName) {
        if (cityName.equalsIgnoreCase(AUCKLAND)) {
            return weatherInfoAuckland;
        } else if (cityName.equalsIgnoreCase(WELLINGTON)) {
            return weatherInfoWellington;
        } else if (cityName.equalsIgnoreCase(CHRISTCHURCH)) {
            return weatherInfoChristchurch;
        } else {
            return null; // No data available for the given city in memory
        }
    }
}
