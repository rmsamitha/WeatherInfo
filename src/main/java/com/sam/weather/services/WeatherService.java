package com.sam.weather.services;

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
    public Response getWeatherByCity(@PathParam("cityName") String cityName) {
        return null;
    }
}
