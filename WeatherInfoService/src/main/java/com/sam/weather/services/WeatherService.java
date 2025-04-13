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

package com.sam.weather.services;

import com.sam.weather.impl.WeatherProviderImpl;
import com.sam.weather.models.Temperature;
import com.sam.weather.models.WeatherInfo;

import javax.ws.rs.*;

@Path("/weather")
@Consumes({"application/json"})
@Produces({"application/json"})
public class WeatherService {
    @GET
    @Path("/current/city")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    //TODO: Need to change to return Response object
    public WeatherInfo getWeatherByCity(@QueryParam("city") String cityName) {
        WeatherProviderImpl weatherProvider = WeatherProviderImpl.getInstance();
        return weatherProvider.getWeatherDataByCity(cityName);
    }

    @GET
    @Path("/current/coordinate")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public WeatherInfo getWeatherByCoordinates(@QueryParam("long") double longitude,
                                               @QueryParam("lat") double latitude) {
        // TODO: Implement logic to fetch weather data using longitude and latitude
        // For now, returning a dummy WeatherInfo object
        return new WeatherInfo("Tauranga", 25, 10, 50, 15);
    }

    @GET
    @Path("/current/city/temperature")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    //TODO: Need to change to return Response object
    public Temperature getTemperatureByCity(@QueryParam("city") String cityName) {
        // TODO: Implement logic to fetch temperature data for the specified city
        // For now, returning a dummy Temperature object
        return new Temperature();
    }

    // implement endpoint to get weather forcast for a city
    @GET
    @Path("/forecast/city")
    @Produces({"application/json"})
    public WeatherInfo getWeatherForecastByCity(@QueryParam("city") String cityName,
                                                @QueryParam("date") String date) {
        // TODO: Implement logic to fetch weather forecast data for the specified city on the given date
        // For now, returning a dummy WeatherInfo object
        return new WeatherInfo(cityName, 18, 60, 40, 20);
    }
}
