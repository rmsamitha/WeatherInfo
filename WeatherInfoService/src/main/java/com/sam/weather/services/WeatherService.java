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

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/weather")
@Consumes({"application/json"})
@Produces({"application/json"})
public class WeatherService {
    @GET
    @Path("/current")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    public Response getCurrentWeather(@QueryParam("city") String cityName, @QueryParam("long") String longitude,
                                      @QueryParam("lat") String latitude) {
        WeatherProviderImpl weatherProvider = WeatherProviderImpl.getInstance();
        return weatherProvider.getCurrentWeather(cityName, longitude, latitude);
    }

    @GET
    @Path("/current/temperature")
    @Consumes({"application/json"})
    @Produces({"application/json"})
    //TODO: Need to change to return Response object
    public Response getTemperatureByCity(@QueryParam("city") String cityName) {
        // TODO: Implement logic to fetch temperature data for the specified city
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }

    @GET
    @Path("/forecast/city")
    @Produces({"application/json"})
    public Response getWeatherForecastByCity(@QueryParam("city") String cityName, @QueryParam("date") String date) {
        // TODO: Implement logic to fetch weather forecast data for the specified city on the given date
        return Response.status(Response.Status.NOT_IMPLEMENTED).build();
    }
}
