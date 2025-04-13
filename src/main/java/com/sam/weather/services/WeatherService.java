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
import com.sam.weather.models.WeatherInfo;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("/weather")
@Consumes({ "application/json" })
@Produces({ "application/json" })
public class WeatherService {
    @GET
    @Path("/{cityName}")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    //TODO: Need to change to return Response object
    public WeatherInfo getWeatherByCity(@PathParam("cityName") String cityName) {
        WeatherProviderImpl weatherProvider = WeatherProviderImpl.getInstance();
        return weatherProvider.getWeatherData(cityName);
    }
}
