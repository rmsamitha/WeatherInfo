package com.sam.weather.impl;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class WeatherImplUtils {
    private static CloseableHttpClient httpClient;

    public static void setHttpClient() {
        httpClient = HttpClients.custom()
                .setMaxConnTotal(100) // Set maximum total connections
                .setMaxConnPerRoute(10) // Set maximum connections per route
                .build();
    }

    public static CloseableHttpClient getHttpClient() {
        if (httpClient == null) {
            setHttpClient();
        }
        return httpClient;
    }
}
