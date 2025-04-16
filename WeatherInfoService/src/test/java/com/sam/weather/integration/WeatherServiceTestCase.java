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
package com.sam.weather.integration;

import com.sam.weather.models.WeatherInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.google.gson.Gson;

public class WeatherServiceTestCase {
    private static CloseableHttpClient httpClient;
    private static final String SERVICE_BASE_URL = "http://localhost:8080/WeatherInfoService/weather";

    private static final Log log = LogFactory.getLog(WeatherServiceTestCase.class);
    private static final String IN_MEMORY_AVAILABLE_CITY_AUCKLAND = "Auckland";
    private static final String IN_MEMORY_UNAVAILABLE_CITY_WAIKATO = "Waikato";

    @BeforeClass(alwaysRun = true)
    public void initialize() {
        httpClient = HttpClients.custom()
                .setMaxConnTotal(100)
                .setMaxConnPerRoute(10)
                .build();
    }

    @Test(description = "Testing the getting weather by city name")
    public void testGetWeatherByInMemoryAvailableLocation() {
        String url = SERVICE_BASE_URL + "/current?city=" + IN_MEMORY_AVAILABLE_CITY_AUCKLAND;
        HttpGet httpGetRequest = new HttpGet(url);

        try (CloseableHttpResponse response = httpClient.execute(httpGetRequest)) {
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200, "Expected status code 200");
            String responseBody = new String(response.getEntity().getContent().readAllBytes());

            Gson gson = new Gson();
            WeatherInfo weatherInfo = gson.fromJson(responseBody, WeatherInfo.class); // deserializes json into target2

            Assert.assertNotNull(weatherInfo, "WeatherInfo should not be null");
            Assert.assertEquals(weatherInfo.getCityName(), IN_MEMORY_AVAILABLE_CITY_AUCKLAND, "City name should match" +
                    " the request");
        } catch (Exception e) {
            log.error("Error occurred while executing test. Message: " + e.getMessage());
        }
    }

    @Test(description = "Testing the getting weather by city name")
    public void testGetWeatherByInMemoryUnAvailableLocation() {
        String url = SERVICE_BASE_URL + "/current?city=" + IN_MEMORY_UNAVAILABLE_CITY_WAIKATO;
        HttpGet httpGetRequest = new HttpGet(url);

        try (CloseableHttpResponse response = httpClient.execute(httpGetRequest)) {
            Assert.assertEquals(response.getStatusLine().getStatusCode(), 200, "Expected status code 200");
            String responseBody = new String(response.getEntity().getContent().readAllBytes());

            Gson gson = new Gson();
            WeatherInfo weatherInfo = gson.fromJson(responseBody, WeatherInfo.class); // deserializes json into target2

            Assert.assertNotNull(weatherInfo, "WeatherInfo should not be null");
            Assert.assertEquals(weatherInfo.getCityName(), IN_MEMORY_UNAVAILABLE_CITY_WAIKATO, "City name should " +
                    "match the request");
        } catch (Exception e) {
            log.error("Error occurred while executing test. Message: " + e.getMessage());
        }
    }
}
