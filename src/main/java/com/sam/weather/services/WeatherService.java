package com.sam.weather.services;

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
        // TODO: Implement retrieval
        return new WeatherInfo("Auckland", 15, 43, 33, 26);
    }
}
